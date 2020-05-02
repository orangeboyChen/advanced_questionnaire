package com.wxapp.questionnaire.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wxapp.questionnaire.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author orangeboy
 * UserMapper类
 */
@Mapper
@Repository
public interface UserDao extends BaseMapper<User> {

    /**
     * 通过openid获得User
     * @param openid openid
     * @return User对象
     */
    public User queryUserByOpenid(String openid);

    /**
     * 添加用户
     * @param user 用户对象
     */
    public void insertUser(User user);

    /**
     * 添加用户分数
     * @param user 用户对象
     * @param score 用户分数
     */
    public void insertUserScore(User user, int score);

}
