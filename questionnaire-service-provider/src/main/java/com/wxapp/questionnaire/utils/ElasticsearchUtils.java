package com.wxapp.questionnaire.utils;

import com.alibaba.fastjson.JSON;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/**
 * @author orangeboy
 * @version 1.0
 * @date 2020/5/1 11:56
 * Elasticsearch工具类
 */
@Component
public class ElasticsearchUtils {

//    @Autowired
//    private RestHighLevelClient restHighLevelClient;
//
//
//    public <T> Page<T> search(QueryBuilder queryBuilder, Class<T> resultType, String index, int from, int size) {
//        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
//        SearchRequest searchRequest = new SearchRequest(index);
//
//        searchSourceBuilder.query(queryBuilder);
//        searchSourceBuilder.from(from);
//        searchSourceBuilder.size(size);
//
//        searchRequest.source(searchSourceBuilder);
//        searchSourceBuilder.timeout(new TimeValue(60, TimeUnit.SECONDS));
//
//        SearchResponse response = null;
//        try {
//            response = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        ArrayList<T> list = new ArrayList<>();
//        assert response != null;
//        for (SearchHit field : response.getHits().getHits()) {
//            list.add(JSON.parseObject(field.getSourceAsString(), resultType));
//        }
//        return new PageImpl<>(list);
//    }
}
