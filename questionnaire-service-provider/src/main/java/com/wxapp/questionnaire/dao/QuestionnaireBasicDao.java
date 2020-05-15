package com.wxapp.questionnaire.dao;

import com.wxapp.questionnaire.pojo.QuestionnaireBasic;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author orangeboy
 * 搜索问卷基本信息持久类
 */
@Repository
public interface QuestionnaireBasicDao extends ElasticsearchRepository<QuestionnaireBasic, String> {

    /**
     * 根据关键词搜索问卷基本对象
     * @param keyword 关键词
     * @param pageable 分页
     * @return 问卷类型列表
     */
    @Query("{\n" +
            "  \"match_phrase\": {\n" +
            "    \"title\": \"?0\"\n" +
            "  }\n" +
            "}")
    public Page<QuestionnaireBasic> findByTitle(String keyword, Pageable pageable);

    /**
     * 根据类型搜索问卷基本对象
     * @param keyword 关键词
     * @param pageable 分页
     * @return 问卷类型列表
     */
    @Query("{\n" +
            "  \"match_phrase\": {\n" +
            "    \"typeName\": \"?0\"\n" +
            "  }\n" +
            "}")
    public Page<QuestionnaireBasic> findByTypeName(String keyword, Pageable pageable);


}
