package com.wxapp.questionnaire.service;

import com.wxapp.questionnaire.pojo.User;

/**
 * @author orangeboy
 * @version 1.0
 * @date 2020/5/2 0:21
 */
public interface UserService {
    /**
     * 通过openid获取用户信息
     * @param openid openid
     * @return 用户类对象
     */
    public User queryUserByOpenid(String openid);

    /**
     * 更新用户信息
     * @param user 用户对象
     * @return 是否更新成功
     */
    public int updateUser(User user);



    /**
     * 添加用户
     * @param user 用户对象
     */
    public void insertUser(User user);
}
