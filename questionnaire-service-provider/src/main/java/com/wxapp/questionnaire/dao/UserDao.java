package com.wxapp.questionnaire.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wxapp.questionnaire.pojo.User;
import org.apache.ibatis.annotations.Mapper;
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

}
