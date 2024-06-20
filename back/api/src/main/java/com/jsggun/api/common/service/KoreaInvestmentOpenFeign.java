package com.jsggun.api.common.service;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.net.URI;
@FeignClient(name = "OpenFeignKoreaInvestment", url = "https://openapi.koreainvestment.com:9443")
public interface KoreaInvestmentOpenFeign {


    @PostMapping("/oauth2/tokenP")
    MultiValueMap<?, ?> getToken(
            @RequestParam(name = "grant_type") String grant_type,
            @RequestParam(name = "appkey") String appkey,
            @RequestParam(name = "appsecret") String appsecret
    );
}
