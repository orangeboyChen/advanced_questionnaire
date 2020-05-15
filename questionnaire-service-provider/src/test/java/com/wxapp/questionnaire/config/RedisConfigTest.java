package com.wxapp.questionnaire.config;

import com.wxapp.questionnaire.QuestionnaireApplication;
import com.wxapp.questionnaire.dao.QuestionnaireBasicDao;
import com.wxapp.questionnaire.pojo.QuestionnaireBasic;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.index.query.*;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = QuestionnaireApplication.class)
class RedisConfigTest {
    @Autowired
    private RestHighLevelClient restHighLevelClient;

    @Autowired
    private QuestionnaireBasicDao questionnaireBasicDao;

    @Test
    public void test() throws IOException {
//        GetRequest getRequest = new GetRequest("test1", "1");
//        GetResponse getResponse = restHighLevelClient.get(getRequest, RequestOptions.DEFAULT);
//        System.out.println(getResponse.getSourceAsString());
//
//        SearchRequest searchRequest = new SearchRequest("test1");
//        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
//
        TermQueryBuilder termQueryBuilder = QueryBuilders.termQuery("test.keyword", "这是一个测试2");
        MatchQueryBuilder matchPhraseQueryBuilder = QueryBuilders.matchQuery("wx", "这是");
//        searchSourceBuilder.query(matchPhraseQueryBuilder);
//        searchSourceBuilder.timeout(new TimeValue(60, TimeUnit.SECONDS));
//
//        searchRequest.source(searchSourceBuilder);
//
//        SearchResponse searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
//        System.out.println(searchResponse);

//        questionnaireBasicDao.save(new QuestionnaireBasic(null, "23333", null, null, null, null, new Date(System.currentTimeMillis()), 0, 0));
//        questionnaireBasicDao.save(new QuestionnaireBasic(null, "23333", null, null, null, null, new Date(System.currentTimeMillis()), 0, 0));
//        questionnaireBasicDao.save(new QuestionnaireBasic(null, "23333", null, null, null, null, new Date(System.currentTimeMillis()), 0, 0));
//        questionnaireBasicDao.save(new QuestionnaireBasic(null, "23333", null, null, null, null, new Date(System.currentTimeMillis()), 0, 0));
//        questionnaireBasicDao.save(new QuestionnaireBasic(null, "23333", null, null, null, null, new Date(System.currentTimeMillis()), 0, 0));

        List<QuestionnaireBasic> list = new ArrayList<>();
        list.add(new QuestionnaireBasic(null, "23333", null, null, null, null, new Date(System.currentTimeMillis()), 0, 0));
        list.add(new QuestionnaireBasic(null, "23333", null, null, null, null, new Date(System.currentTimeMillis()), 0, 0));
        list.add(new QuestionnaireBasic(null, "23333", null, null, null, null, new Date(System.currentTimeMillis()), 0, 0));
        list.add(new QuestionnaireBasic(null, "23333", null, null, null, null, new Date(System.currentTimeMillis()), 0, 0));
        list.add(new QuestionnaireBasic(null, "23333", null, null, null, null, new Date(System.currentTimeMillis()), 0, 0));
        list.add(new QuestionnaireBasic(null, "23333", null, null, null, null, new Date(System.currentTimeMillis()), 0, 0));
        list.add(new QuestionnaireBasic(null, "23333", null, null, null, null, new Date(System.currentTimeMillis()), 0, 0));
        list.add(new QuestionnaireBasic(null, "23333", null, null, null, null, new Date(System.currentTimeMillis()), 0, 0));


//        questionnaireBasicDao.deleteAll();
        questionnaireBasicDao.saveAll(list);
//        Iterable<QuestionnaireBasic> search = questionnaireBasicDao.findByTitle("23333");
        Page<QuestionnaireBasic> search = questionnaireBasicDao.findByTitle("23333", PageRequest.of(1000,5));
        search.forEach(System.out::println);
    }

}