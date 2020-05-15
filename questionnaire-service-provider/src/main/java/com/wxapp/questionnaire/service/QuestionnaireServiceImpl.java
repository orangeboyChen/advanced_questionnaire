package com.wxapp.questionnaire.service;

import com.wxapp.questionnaire.dao.QuestionnaireBasicDao;
import com.wxapp.questionnaire.dao.QuestionnaireCommitDao;
import com.wxapp.questionnaire.dao.QuestionnaireDetailDao;
import com.wxapp.questionnaire.pojo.QuestionnaireBasic;
import com.wxapp.questionnaire.pojo.QuestionnaireCommit;
import com.wxapp.questionnaire.pojo.QuestionnaireDetail;
import com.wxapp.questionnaire.utils.ElasticsearchUtils;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * @author orangeboy
 * @version 1.0
 * @date 2020/5/2 15:07
 */
@Service
public class QuestionnaireServiceImpl implements QuestionnaireService{

    @Autowired
    private QuestionnaireCommitDao questionnaireCommitDao;

    @Autowired
    private QuestionnaireDetailDao questionnaireDetailDao;

    @Autowired
    private QuestionnaireBasicDao questionnaireBasicDao;

    @Override
    public void commit(QuestionnaireCommit questionnaireCommit) {
        questionnaireCommitDao.commit(questionnaireCommit);
    }

    @Override
    public List<QuestionnaireCommit> getCommit(String questionnaireId) {
        return questionnaireCommitDao.getCommit(questionnaireId);
    }

    @Override
    public void create(QuestionnaireDetail questionnaireDetail) {
        try{
            //先保存基本信息
            QuestionnaireBasic save = questionnaireBasicDao.save((QuestionnaireBasic) questionnaireDetail);

            //再保存详情信息
            questionnaireDetail.setQuestionnaireId(save.getQuestionnaireId());
            questionnaireDetailDao.create(questionnaireDetail);
        }catch (Exception e){
            questionnaireBasicDao.delete((QuestionnaireBasic) questionnaireDetail);
            e.printStackTrace();
        }
    }

    @Override
    public QuestionnaireDetail getDetail(String questionnaireId) {
        Optional<QuestionnaireBasic> questionnaireBasicOptional = questionnaireBasicDao.findById(questionnaireId);
        if(questionnaireBasicOptional.isPresent()){
            QuestionnaireBasic questionnaireBasic = questionnaireBasicOptional.get();
            return questionnaireDetailDao.getDetail(questionnaireId);
        }
        return null;
    }

}
