package com.wxapp.questionnaire.service;

import com.alibaba.fastjson.JSON;
import com.wxapp.questionnaire.dao.QuestionnaireBasicDao;
import com.wxapp.questionnaire.pojo.QuestionnaireBasic;
import com.wxapp.questionnaire.utils.ElasticsearchUtils;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.MatchAllQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class SearchServiceImplTest {

    @Autowired
    private QuestionnaireBasicDao questionnaireBasicDao;

    @Autowired
    private ElasticsearchUtils elasticsearchUtils;


    @Test
    void insert() throws IOException {
        MatchAllQueryBuilder matchAllQueryBuilder = QueryBuilders.matchAllQuery();
//        SearchRequest searchRequest = new SearchRequest("wx");
//        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
//        searchSourceBuilder.query(matchAllQueryBuilder);
//        searchRequest.source(searchSourceBuilder);
//        SearchResponse response = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
//        System.out.println(response.toString());
//        Page<Object> wx = elasticsearchUtils.search(matchAllQueryBuilder, Object.class, "test1", 0, 5);
//
//        wx.forEach(System.out::print);
    }
}