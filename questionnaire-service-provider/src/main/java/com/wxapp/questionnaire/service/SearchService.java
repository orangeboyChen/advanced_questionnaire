package com.wxapp.questionnaire.service;

import com.wxapp.questionnaire.pojo.QuestionnaireBasic;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @author orangeboy
 * 搜索问卷抽象类
 */
public interface SearchService {
    /**
     * 通过问卷标题搜索问卷
     * @param keyword 关键词
     * @param from 分页，从第几条
     * @param size 分页大小
     * @return 基本问卷
     */
    public Page<QuestionnaireBasic> queryByTitle(String keyword, int from, int size);

    /**
     * 通过问卷类型搜索问卷
     * @param keyword 关键词
     * @param from 分页，从第几条
     * @param size 分页大小
     * @return 基本问卷
     */
    public Page<QuestionnaireBasic> queryByType(String keyword, int from, int size);

    /**
     * 添加搜索数据
     * @param questionnaireBasic 基本问卷
     * @return 添加成功后问卷的uuid
     */
    public QuestionnaireBasic insert(QuestionnaireBasic questionnaireBasic);

    /**
     * 删除基本问卷
     * @param questionnaireBasic 要删除的基本问卷
     * @return 是否删除成功
     */
    public boolean delete(QuestionnaireBasic questionnaireBasic);
}
