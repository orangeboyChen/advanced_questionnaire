package com.wxapp.questionnaire.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wxapp.questionnaire.pojo.QuestionnaireCommit;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author orangeboy
 * @version 1.0
 * @date 2020/5/2 14:57
 */
@Repository
public interface QuestionnaireCommitDao extends BaseMapper<QuestionnaireCommit> {

    /**
     * 提交问卷
     * @param commit 提交问卷对象
     */
    public void commit(QuestionnaireCommit commit);

    /**
     * 获取提交的问卷情况
     * @param questionnaireId questionnaireId
     * @return 提交的问卷集合
     */
    public List<QuestionnaireCommit> getCommit(String questionnaireId);
}
