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
    public void insertUser(@Param("user") User user);

    /**
     * 添加用户分数
     * @param user 用户对象
     * @param score 用户分数
     */
    public void insertUserScore(@Param("user") User user, int score);

    /**
     * 更新用户信息
     * @param user 用户对象
     * @return 更新成功的条数
     */
    public int updateUser(@Param("user") User user);

}
