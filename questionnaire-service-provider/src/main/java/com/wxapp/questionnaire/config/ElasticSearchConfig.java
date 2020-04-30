package com.wxapp.questionnaire.config;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author orangeboy
 * ElasticSearch配置类
 */
@Configuration
public class ElasticSearchConfig {

    @Value("${elasticsearch.url}")
    private String elasticsearchUrl;

    @Value("${elasticsearch.port}")
    private int elasticsearchPort;

    @Bean
    public RestHighLevelClient restHighLevelClient(){
        RestHighLevelClient restHighLevelClient = new RestHighLevelClient(RestClient.builder(
                new HttpHost(
                        elasticsearchUrl,
                        elasticsearchPort,
                        "http"
                )
        ));
        return restHighLevelClient;
    }
}
