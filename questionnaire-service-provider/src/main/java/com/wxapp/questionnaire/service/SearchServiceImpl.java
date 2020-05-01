package com.wxapp.questionnaire.service;

import com.wxapp.questionnaire.dao.QuestionnaireBasicDao;
import com.wxapp.questionnaire.pojo.QuestionnaireBasic;
import com.wxapp.questionnaire.utils.ElasticsearchUtils;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author orangeboy
 * 搜索问卷业务实现类
 */
@Service
public class SearchServiceImpl implements SearchService{

    @Autowired
    private QuestionnaireBasicDao questionnaireBasicDao;

    @Autowired
    private ElasticsearchUtils elasticsearchUtils;

    @Override
    public Page<QuestionnaireBasic> queryByTitle(String keyword, int from, int size) {
        MatchQueryBuilder matchQueryBuilder = QueryBuilders.matchQuery("title", keyword);
        return elasticsearchUtils.search(matchQueryBuilder, QuestionnaireBasic.class, "wx", from, size);
    }

    @Override
    public Page<QuestionnaireBasic> queryByType(String keyword, int from, int size) {
        MatchQueryBuilder matchQueryBuilder = QueryBuilders.matchQuery("type", keyword);
        return elasticsearchUtils.search(matchQueryBuilder, QuestionnaireBasic.class, "wx", from, size);
    }

    @Override
    public QuestionnaireBasic insert(QuestionnaireBasic questionnaireBasic) {
        return questionnaireBasicDao.save(questionnaireBasic);
    }

    @Override
    public boolean delete(QuestionnaireBasic questionnaireBasic) {
        try{
            questionnaireBasicDao.delete(questionnaireBasic);
            return true;
        }catch (Exception e){
            return false;
        }
    }


}
