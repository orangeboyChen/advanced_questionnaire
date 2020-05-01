package com.wxapp.questionnaire.dao;

import com.wxapp.questionnaire.pojo.QuestionnaireBasic;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * @author orangeboy
 * 搜索问卷基本信息持久类
 */
@Repository
public interface QuestionnaireBasicDao extends ElasticsearchRepository<QuestionnaireBasic, String> {

}
