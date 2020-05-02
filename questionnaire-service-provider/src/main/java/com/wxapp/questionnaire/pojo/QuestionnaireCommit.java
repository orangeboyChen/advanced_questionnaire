package com.wxapp.questionnaire.pojo;

import lombok.Data;

import java.util.Date;

/**
 * @author orangeboy
 * @version 1.0
 * @date 2020/5/2 14:55
 */
@Data
public class QuestionnaireCommit {

    private String userId;
    private String questionnaireId;
    private String data;
    private Date createTime;

}
