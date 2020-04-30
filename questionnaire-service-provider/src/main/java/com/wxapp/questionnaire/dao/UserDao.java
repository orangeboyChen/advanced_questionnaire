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
public interface UserDao extends BaseMapper<User> {

    public User getUser();
}
