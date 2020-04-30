package com.wxapp.questionnaire.service;

import com.wxapp.questionnaire.QuestionnaireApplication;
import com.wxapp.questionnaire.dao.UserDao;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = QuestionnaireApplication.class)
class LoginServiceTest {

    @Autowired
    public UserDao userDao;

    @Test
    public void test(){
        System.out.println(userDao.getUser());
    }

}