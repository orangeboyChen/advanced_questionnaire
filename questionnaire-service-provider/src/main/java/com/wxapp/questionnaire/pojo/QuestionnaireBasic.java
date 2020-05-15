package com.wxapp.questionnaire.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

import java.util.Date;

/**
 * @author orangeboy
 * 问卷的基本信息
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@Document(indexName = "questionnaire_basic")
public class QuestionnaireBasic {
    @Id
    private String questionnaireId;

    @Field(value = "title", analyzer = "ik_smart", nullValue = "")
    private String title;

    @Field(value = "subtitle")
    private String subtitle;

    @Field("type_name")
    private String typeName;

    @Field("user_nickname")
    private String userNickname;

    @Field("avatar_url")
    private String avatarUrl;

    @Field("create_time")
    private Date createTime;

    @Field("like")
    private long like;

    @Field("view")
    private long view;
}
