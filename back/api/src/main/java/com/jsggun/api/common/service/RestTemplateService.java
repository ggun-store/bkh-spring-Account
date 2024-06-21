package com.jsggun.api.common.service;

import com.jsggun.api.common.model.KoreaInvestmentRequestToken;
import com.jsggun.api.common.model.KoreaInvestmentResponseToken;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Component
@RequiredArgsConstructor
public class RestTemplateService {

    private final RestTemplate restTemplate;
    private final KoreaInvestmentOpenFeign openFeign;
    private static final String successCode = "A0000";

    private static final String base_url = "https://openapi.koreainvestment.com:9443";




    public KoreaInvestmentResponseToken getToken(KoreaInvestmentRequestToken requestToken){
        HttpHeaders httpHeaders = generateHeader("Content-Type","application/json; charset=utf-8");
        HttpEntity httpEntity = generateHttpEntityWithBody(httpHeaders, requestToken.toMultiValueMap());


        KoreaInvestmentResponseToken koreaInvestmentResponseToken = restTemplate.exchange(base_url + "/oauth2/tokenP",
                HttpMethod.POST, httpEntity, KoreaInvestmentResponseToken.class).getBody();

        return koreaInvestmentResponseToken;

    }




    private HttpEntity generateHttpEntityWithBody(HttpHeaders httpHeaders, MultiValueMap body) {
        return new HttpEntity<>(body, httpHeaders);
    }
    /**
     * 요청할 HttpEntity 생성
     */
    private HttpEntity generateHttpEntity(HttpHeaders httpHeaders) {
        return new HttpEntity<>(httpHeaders);
    }


    /**
     * 헤더 생성
     */
    private HttpHeaders generateHeader(String name ,String val){
        HttpHeaders httpHeaders = new HttpHeaders();
        if (name.equals("Authorization")) {
            httpHeaders.add(name, "Bearer "+val);
            return httpHeaders;
        }
        httpHeaders.add(name, val);
        return httpHeaders;
    }

    private boolean isErrorCode(String code){
        if (code==null) return false;
        if (code.equals(successCode)){
            return false;
        }
        return true;
    }



//    public MultiValueMap getAppToken(){
//        String path = "/oauth2/tokenP";
////        HttpHeaders headers = new HttpHeaders();
////        headers.setContentType(MediaType.APPLICATION_JSON);
////        headers.add("user-agent",
////                "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.124 Safari/537.36");
////
////        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
////        params.add("grant_type", "client_credentials");
////        params.add("appkey", appKey);
////        params.add("appsecret", appSecret);
////        log.info("키 {}", appKey);
////        log.info("시크릿 {}", appSecret);
//        URI uri = UriComponentsBuilder
//                .fromUriString("https://openapi.koreainvestment.com:9443")
//                .path(path)
//                .encode()
//                .build()
//                .toUri();
////
////        String token = getKoreaInvestmentRes(headers, params,path).getBody();
////        log.info("확인 {}", token);
//        return openFeign.getToken("client_credentials",appKey,appSecret);
//    }

    public ResponseEntity<String> getKoreaInvestmentRes(HttpHeaders headers, MultiValueMap<String, String> params, String path) {
        HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(params,headers);

//        URI uri = UriComponentsBuilder
//                .fromUriString("https://openapi.koreainvestment.com:9443")
//                .path(path)
//                .encode()
//                .build()
//                .toUri();
//        RequestEntity<MultiValueMap<String, String>> request = RequestEntity.post(uri).headers(headers).body(params);

//        ResponseEntity<String> response = restTemplate.postForEntity(uri,request,String.class);
        ResponseEntity<String> response = restTemplate.exchange(
////                "https://openapivts.koreainvestment.com:29443"+path, //{요청할 서버 주소}
                "https://openapi.koreainvestment.com:9443"+path, //{요청할 서버 주소}
                HttpMethod.POST, //{요청할 방식}
                entity, // {요청할 때 보낼 데이터}
                String.class // {요청시 반환되는 데이터 타입}
        );
        return response;
    }


//    public Long getMarketPrice(String pdco) {
//        String path = "/uapi/domestic-stock/v1/quotations/inquire-price";
//        HttpHeaders headers = new HttpHeaders();
//        headers.add("Content-Type", "application/json");
//        headers.add("authorization", "dd");
//        headers.add("appKey", appKey);
//        headers.add("appSecret", appSecret);
//        headers.add("tr_id", "FHKST01010100");
//
//
//        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
//        params.add("fid_cond_mrkt_div_code", "J");
//        params.add("fid_input_iscd", pdco);
//
//        return null;
//    }
}
