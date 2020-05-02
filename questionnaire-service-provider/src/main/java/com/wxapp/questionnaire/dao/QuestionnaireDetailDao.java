package com.wxapp.questionnaire.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wxapp.questionnaire.pojo.QuestionnaireDetail;
import org.springframework.stereotype.Repository;

/**
 * @author orangeboy
 * @version 1.0
 * @date 2020/5/2 15:22
 */
@Repository
public interface QuestionnaireDetailDao extends BaseMapper<QuestionnaireDetail> {

    /**
     * 创建问卷
     * @param detail 详情问卷对象
     */
    public void create(QuestionnaireDetail detail);

    /**
     * 获取问卷详情
     * @param questionnaireId questionnaireId
     * @return 问卷详情对象
     */
    public QuestionnaireDetail getDetail(String questionnaireId);
}
