package com.wxapp.questionnaire.service;

import com.wxapp.questionnaire.dao.UserDao;
import com.wxapp.questionnaire.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sun.nio.cs.US_ASCII;

import java.util.UUID;

/**
 * @author orangeboy
 * @version 1.0
 * @date 2020/5/2 0:21
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User queryUserByOpenid(String openid) {
        return userDao.queryUserByOpenid(openid);
    }

    @Override
    public int updateUser(User user) {
        return userDao.updateUser(user);
    }

    @Override
    @Transactional(rollbackFor = {RuntimeException.class, Error.class})
    public void insertUser(User user) {
        user.setUserId(UUID.randomUUID().toString().replaceAll("-", ""));
        userDao.insertUser(user);
        userDao.insertUserScore(user, 0);
    }
}
