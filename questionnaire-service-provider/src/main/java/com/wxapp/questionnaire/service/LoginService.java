package com.wxapp.questionnaire.service;

import com.alibaba.fastjson.JSONObject;
import javafx.util.Pair;
import org.springframework.stereotype.Service;

/**
 * @author orangeboy
 * 登录时的业务逻辑
 */
@Service
public class LoginService {

    public Pair<String, String> getOpenidAndSessionKey(String response){
        //解析数据
        JSONObject jsonObject = JSONObject.parseObject(response);
        String openid = jsonObject.getString("openid");
        String sessionKey = jsonObject.getString("session_key");
        return new Pair<>(openid, sessionKey);
    }

}
