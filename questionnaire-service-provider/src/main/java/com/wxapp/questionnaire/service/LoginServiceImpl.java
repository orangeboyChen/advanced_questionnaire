package com.wxapp.questionnaire.service;

import com.alibaba.fastjson.JSONObject;
import com.wxapp.questionnaire.dao.UserDao;
import com.wxapp.questionnaire.pojo.User;
import javafx.util.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author orangeboy
 * 登录时的业务逻辑
 */
@Service
public class LoginServiceImpl implements LoginService{

    @Autowired
    private UserDao userDao;
    
    @Override
    public Pair<String, String> getOpenidAndSessionKey(JSONObject jsonObject){
        //解析数据
        String openid = jsonObject.getString("openid");
        String sessionKey = jsonObject.getString("session_key");
        return new Pair<>(openid, sessionKey);
    }

    @Override
    public User getUser(String openid) {
       return userDao.queryUserByOpenid(openid);
    }

}
