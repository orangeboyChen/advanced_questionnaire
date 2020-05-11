package com.wxapp.questionnaire;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author orangeboy
 * 启动类
 */
@SpringBootApplication
@MapperScan("com.wxapp.questionnaire.dao")
public class QuestionnaireApplication {

    public static void main(String[] args) {
        SpringApplication.run(QuestionnaireApplication.class, args);
    }

}
