package com.wxapp.questionnaire.controller;


import com.wxapp.questionnaire.service.LoginService;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.URISyntaxException;

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

    //Todo: 把下面的放在配置文件里
    /**
     * 微信登录链接构造
     */
    private final String URI_APP_ID = "appid";
    private final String URI_APP_SECRET = "secret";
    private final String URI_CODE = "js_code";
    private final String URI_GRANT_TYPE = "grant_type";
    private final String GRANT_TYPE = "authorization_code";

    @GetMapping("")
    @ApiOperation("登录")
    public ApiVO login(@ApiParam("wx.login()获得的code") String code, HttpSession session) throws IOException, URISyntaxException {
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
        int status = response.getStatusLine().getStatusCode();
        switch (status){
            case 40029:
                return ApiUtils.error(40029, "Code无效");
            case -1:
                return ApiUtils.error(-1, "系统繁忙");
            case 45011:
                return ApiUtils.error(45011, "频率限制");
            case 0:
                String responseEntityString = EntityUtils.toString(response.getEntity());
                Pair<String, String> openidAndSecretKey = loginService.getOpenidAndSessionKey(responseEntityString);
                session.setAttribute("openid", openidAndSecretKey.getKey());
                session.setAttribute("secret_key", openidAndSecretKey.getValue());
                return ApiUtils.success(new LoginVO(session.getId()));
            default:
                return ApiUtils.error(404, "未知错误");
        }
    }
}
