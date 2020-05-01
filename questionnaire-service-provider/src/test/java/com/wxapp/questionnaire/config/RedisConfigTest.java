package com.wxapp.questionnaire.config;

import com.wxapp.questionnaire.QuestionnaireApplication;
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
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.concurrent.TimeUnit;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = QuestionnaireApplication.class)
class RedisConfigTest {
    @Autowired
    private RestHighLevelClient restHighLevelClient;

    @Test
    public void test() throws IOException {
        GetRequest getRequest = new GetRequest("test1", "1");
        GetResponse getResponse = restHighLevelClient.get(getRequest, RequestOptions.DEFAULT);
        System.out.println(getResponse.getSourceAsString());

        SearchRequest searchRequest = new SearchRequest("test1");
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();

//        TermQueryBuilder termQueryBuilder = QueryBuilders.termQuery("test.keyword", "这是一个测试2");
//        MatchQueryBuilder matchPhraseQueryBuilder = QueryBuilders.matchQuery("text", "这是");
//        searchSourceBuilder.query(matchPhraseQueryBuilder);
//        searchSourceBuilder.timeout(new TimeValue(60, TimeUnit.SECONDS));
//
//        searchRequest.source(searchSourceBuilder);
//
//        SearchResponse searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
//        System.out.println(searchResponse);

    }

}