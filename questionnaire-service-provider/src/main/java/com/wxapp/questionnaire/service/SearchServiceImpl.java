package com.wxapp.questionnaire.service;

import com.wxapp.questionnaire.dao.QuestionnaireBasicDao;
import com.wxapp.questionnaire.pojo.QuestionnaireBasic;
import com.wxapp.questionnaire.utils.ElasticsearchUtils;
import com.wxapp.questionnaire.utils.RedisUtils;
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
    private RedisUtils redisUtils;

    @Override
    public Page<QuestionnaireBasic> queryByTitle(String keyword, int page, int size) {
        Page<QuestionnaireBasic> result = questionnaireBasicDao.findByTitle(keyword, PageRequest.of(page, size));
        return setViewAndLike(result);
    }

    @Override
    public Page<QuestionnaireBasic> queryByType(String keyword, int page, int size) {
        Page<QuestionnaireBasic> result = questionnaireBasicDao.findByTypeName(keyword, PageRequest.of(page,size));
        return setViewAndLike(result);
    }


    /**
     * 设置浏览数与喜欢数
     * @param questionnaireBasics questionnaireBasics
     * @return 完整的questionnaireBasics
     */
    private Page<QuestionnaireBasic> setViewAndLike(Page<QuestionnaireBasic> questionnaireBasics){
        questionnaireBasics.forEach(r->{
            long view = redisUtils.getQuestionnaireView(r);
            long like = redisUtils.getQuestionnaireLike(r);

            //浏览数+1
            redisUtils.incrementQuestionnaireView(r);

            //设置浏览数和获赞数
            r.setView(view).setLike(like);

        });
        return questionnaireBasics;
    }


}
