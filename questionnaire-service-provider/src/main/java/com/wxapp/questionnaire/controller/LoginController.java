package com.wxapp.questionnaire.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.wxapp.questionnaire.pojo.User;
import com.wxapp.questionnaire.service.LoginService;
import com.wxapp.questionnaire.service.UserService;
import com.wxapp.questionnaire.utils.ApiUtils;
import com.wxapp.questionnaire.vo.ApiVO;
import com.wxapp.questionnaire.vo.login.LoginVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import javafx.util.Pair;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author orangeboy
 * 登录，验证、保存用户信息
 */
@RestController
@RequestMapping("/login")
@Api(tags = "登录")
public class LoginController {

    @Value("${wx.login.url}")
    private String wxLoginUrl;

    @Value("${wx.appId}")
    private String appId;

    @Value("${wx.appSecret}")
    private String appSecret;

    @Autowired
    private LoginService loginService;

    @Autowired
    private UserService userService;

    //Todo: 把下面的放在配置文件里
    /**
     * 微信登录链接构造
     */
    private final String URI_APP_ID = "appid";
    private final String URI_APP_SECRET = "secret";
    private final String URI_CODE = "js_code";
    private final String URI_GRANT_TYPE = "grant_type";
    private final String GRANT_TYPE = "authorization_code";

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping("")
    @ApiOperation("登录")
    public ApiVO login(@ApiParam("wx.login()获得的code") @RequestParam String code, @ApiIgnore HttpSession session) throws IOException, URISyntaxException {
        logger.info("code=>" + code);

        //创建URL
        URIBuilder urlBuilder = new URIBuilder(wxLoginUrl);
        String url = urlBuilder
                .addParameter(URI_APP_ID, appId)
                .addParameter(URI_APP_SECRET, appSecret)
                .addParameter(URI_CODE, code)
                .addParameter(URI_GRANT_TYPE, GRANT_TYPE)
                .build()
                .toString();


        //创建连接
        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);
        HttpResponse response = client.execute(httpGet);

        //解析数据
        JSONObject responseObject = JSON.parseObject(EntityUtils.toString(response.getEntity()));
        int status = responseObject.getIntValue("errcode");
        System.out.println(responseObject);
        System.out.println(session.getId());
        switch (status){
            case 40029:
                return ApiUtils.error(40029, "Code无效");
            case -1:
                return ApiUtils.error(-1, "系统繁忙");
            case 45011:
                return ApiUtils.error(45011, "频率限制");
            case 0:
                Map<String, String> openidAndSecretKey = loginService.getOpenidAndSessionKey(responseObject);

                String openid = openidAndSecretKey.get("openid");
                String secretKey = openidAndSecretKey.get("secret_key");

                //存Session Todo:后期考虑存redis
                session.setAttribute("openid", openid);
                session.setAttribute("secret_key", secretKey);

                User user = loginService.getUser(openid);
                return ApiUtils.success(new LoginVO(session.getId(), user == null));


            default:
                return ApiUtils.error(404, "未知错误");
        }
    }

    @PostMapping("/userInfo")
    @ApiOperation("保存用户详情信息")
    public ApiVO getUserInfo(@ApiParam("头像地址") @NotNull String avatarUrl,
                             @ApiParam("性别") @NotNull Integer gender,
                             @ApiParam("昵称") @NotNull String nickName,
                             @ApiIgnore HttpSession httpSession){
        String openid = (String) httpSession.getAttribute("openid");
        System.out.println(httpSession.getId());
        if(StringUtils.isEmpty(openid)){
            return ApiUtils.error(403, "用户未登录");
        }
        System.out.println(nickName);
        System.out.println(gender);
        User user = new User(avatarUrl, nickName, openid, gender);
        User expiredUser = userService.queryUserByOpenid(openid);

        if(expiredUser != null){
            user.setUserId(expiredUser.getUserId());
            userService.updateUser(user);
        }
        else{
            userService.insertUser(user);
        }

        return ApiUtils.success();


    }

}
