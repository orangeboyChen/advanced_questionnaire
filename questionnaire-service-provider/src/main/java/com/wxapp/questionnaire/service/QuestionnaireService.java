package com.wxapp.questionnaire.service;

import com.wxapp.questionnaire.pojo.QuestionnaireCommit;
import com.wxapp.questionnaire.pojo.QuestionnaireDetail;

import java.util.List;

/**
 * @author orangeboy
 * @version 1.0
 * @date 2020/5/2 15:06
 * 处理提交问卷、问卷创造的业务逻辑
 */
public interface QuestionnaireService {
    /**
     * 用户提交问卷
     * @param questionnaireCommit 提交的问卷对象
     */
    public void commit(QuestionnaireCommit questionnaireCommit);

    /**
     * 根据questionnaireId获取提交的问卷情况
     * @param questionnaireId questionnaireId
     * @return 提交的问卷
     */
    public List<QuestionnaireCommit> getCommit(String questionnaireId);

    /**
     * 创建新的问卷
     * @param questionnaireDetail questionnaireDetail对象
     */
    public void create(QuestionnaireDetail questionnaireDetail);

    /**
     * 获取问卷详情
     * @param questionnaireId questionnaireId
     * @return 问卷详情对象
     */
    public QuestionnaireDetail getDetail(String questionnaireId);
}
