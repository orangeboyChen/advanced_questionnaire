package com.wxapp.questionnaire.service;

import com.alibaba.fastjson.JSONObject;
import com.wxapp.questionnaire.pojo.User;
import javafx.util.Pair;

/**
 * @author orangeboy
 * 登录业务逻辑抽象类
 */
public interface LoginService {
    /**
     * 通过微信的返回值获得openid和session_key
     * @param jsonObject 微信服务器返回值的JSON
     * @return openid和session_key组成的Pair
     */
    public Pair<String, String> getOpenidAndSessionKey(JSONObject jsonObject);


    /**
     * 通过openid返回一个User对象，没有则新建一个
     * @param openid openid
     * @return 用户
     */
    public User getUser(String openid);
}
