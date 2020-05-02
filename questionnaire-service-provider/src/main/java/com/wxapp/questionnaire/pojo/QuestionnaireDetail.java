package com.wxapp.questionnaire.pojo;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author orangeboy
 * @version 1.0
 * @date 2020/5/2 14:44
 * 问卷详情类
 */

@EqualsAndHashCode(callSuper = true)
@Data
public class QuestionnaireDetail extends QuestionnaireBasic {

    private String data;

    public QuestionnaireDetail(QuestionnaireBasic questionnaireBasic){
        super(questionnaireBasic.getQuestionnaireId(),
                questionnaireBasic.getTitle(),
                questionnaireBasic.getSubtitle(),
                questionnaireBasic.getTypeName(),
                questionnaireBasic.getUserNickname(),
                questionnaireBasic.getAvatarUrl(),
                questionnaireBasic.getCreateTime(),
                questionnaireBasic.getLike(),
                questionnaireBasic.getView());
    }

    public void setBasic(QuestionnaireBasic questionnaireBasic){
        setQuestionnaireId(questionnaireBasic.getQuestionnaireId());
        setTitle(questionnaireBasic.getTitle());
        setSubtitle(questionnaireBasic.getSubtitle());
        setTypeName(questionnaireBasic.getTypeName());
        setUserNickname(questionnaireBasic.getUserNickname());
        setAvatarUrl(questionnaireBasic.getAvatarUrl());
        setCreateTime(questionnaireBasic.getCreateTime());
        setLike(questionnaireBasic.getLike());
        setView(questionnaireBasic.getView());
    }

}
