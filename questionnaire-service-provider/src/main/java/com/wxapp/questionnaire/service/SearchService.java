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
     * @param page 第几页
     * @param size 分页大小
     * @return 基本问卷
     */
    public Page<QuestionnaireBasic> queryByTitle(String keyword, int page, int size);

    /**
     * 通过问卷类型搜索问卷
     * @param keyword 关键词
     * @param page 第几页
     * @param size 分页大小
     * @return 基本问卷
     */
    public Page<QuestionnaireBasic> queryByType(String keyword, int page, int size);
}
