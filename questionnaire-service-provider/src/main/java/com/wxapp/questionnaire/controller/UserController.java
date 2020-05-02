package com.wxapp.questionnaire.controller;

import com.wxapp.questionnaire.pojo.User;
import com.wxapp.questionnaire.service.UserService;
import com.wxapp.questionnaire.utils.ApiUtils;
import com.wxapp.questionnaire.vo.ApiVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @author orangeboy
 * 获取用户信息的Controller
 */
@RestController
@RequestMapping("/user")
@Api(tags = "用户")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("")
    @ApiOperation("用户信息")
    public ApiVO getUserInfo(HttpSession httpSession){
        String openid = (String) httpSession.getAttribute("openid");

        if(StringUtils.isEmpty(openid)) {
            return ApiUtils.error(403, "该用户未登录");
        }

        User user = userService.queryUser(openid);

        if(user == null){
            return ApiUtils.error(403, "未找到该用户");
        }
        else{
            return ApiUtils.success(user);
        }
    }

}
