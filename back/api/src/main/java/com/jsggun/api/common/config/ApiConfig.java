package com.jsggun.api.common.config;


import com.siot.IamportRestClient.Iamport;
import com.siot.IamportRestClient.IamportClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApiConfig {

    @Value("${imp.key}")
    private String iamportKey;

    @Value("${imp.secret}")
    private String iamportSecret;
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }


    @Bean
    public IamportClient iamportClient(){
        return new IamportClient(iamportKey,iamportSecret);
    }

}


