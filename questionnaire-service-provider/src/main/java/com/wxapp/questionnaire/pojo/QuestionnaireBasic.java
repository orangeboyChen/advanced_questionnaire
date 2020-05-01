package com.wxapp.questionnaire.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.Date;

/**
 * @author orangeboy
 * 问卷的基本信息
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName = "test")
public class QuestionnaireBasic {
    @Id
    private String questionnaireId;

    private String title;
    private String subtitle;
    private String typeName;
    private String userNickname;
    private String avatarUrl;
    private Date createTime;
}
