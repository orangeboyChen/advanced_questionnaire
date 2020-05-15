package com.wxapp.questionnaire.service;

import com.alibaba.fastjson.JSONObject;
import com.wxapp.questionnaire.dao.UserDao;
import com.wxapp.questionnaire.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


/**
 * @author orangeboy
 * 登录时的业务逻辑
 */
@Service
public class LoginServiceImpl implements LoginService{

    @Autowired
    private UserDao userDao;

    @Override
    public Map<String, String> getOpenidAndSessionKey(JSONObject jsonObject){
        //解析数据
        String openid = jsonObject.getString("openid");
        String sessionKey = jsonObject.getString("session_key");
        Map<String, String> map = new HashMap<>(1);
        map.put("openid", openid);
        map.put("session_key", sessionKey);
        return map;
    }

    @Override
    public User getUser(String openid) {
       return userDao.queryUserByOpenid(openid);
    }

}
