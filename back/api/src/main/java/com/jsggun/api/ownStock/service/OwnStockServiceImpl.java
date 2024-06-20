package com.jsggun.api.ownStock.service;

import com.jsggun.api.accHistory.model.AccHistoryDto;
import com.jsggun.api.common.component.Messenger;
import com.jsggun.api.common.service.KoreaInvestmentOpenFeign;
import com.jsggun.api.ownStock.model.OwnStockDto;
import com.jsggun.api.ownStock.repository.OwnStockRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class OwnStockServiceImpl implements OwnStockService {

    private final OwnStockRepository ownStockRepository;
    private final RestTemplate restTemplate;
    private final KoreaInvestmentOpenFeign openFeign;

    @Value("${koreainvestment.key}")
    private String appKey;

    @Value("${koreainvestment.secret}")
    private String appSecret;

    @Override
    public List<OwnStockDto> findByAccount(Long id) {
        return null;
    }

    @Override
    public Messenger save(OwnStockDto ownStockDto) {
        return null;
    }

    @Override
    public Messenger deleteById(Long id) {
        return null;
    }

    @Override
    public Optional<OwnStockDto> modify(OwnStockDto ownStockDto) {
        return Optional.empty();
    }

    @Override
    public List<OwnStockDto> findAll() {
        return null;
    }

    @Override
    public Optional<OwnStockDto> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public long count() {
        var token = getAppToken().get("access_token");
        log.info("토큰 확인 : {}", token);
        return 5000;
    }

    @Override
    public boolean existsById(Long id) {
        return false;
    }




    private MultiValueMap getAppToken(){
        String path = "/oauth2/tokenP";
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
//        headers.add("user-agent",
//                "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.124 Safari/537.36");
//
//        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
//        params.add("grant_type", "client_credentials");
//        params.add("appkey", appKey);
//        params.add("appsecret", appSecret);
//        log.info("키 {}", appKey);
//        log.info("시크릿 {}", appSecret);
        URI uri = UriComponentsBuilder
                .fromUriString("https://openapi.koreainvestment.com:9443")
                .path(path)
                .encode()
                .build()
                .toUri();
//
//        String token = getKoreaInvestmentRes(headers, params,path).getBody();
//        log.info("확인 {}", token);
        return openFeign.getToken("client_credentials",appKey,appSecret);
    }

    private ResponseEntity<String> getKoreaInvestmentRes(HttpHeaders headers, MultiValueMap<String, String> params,String path) {
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


    private Long getMarketPrice(String pdco) {
        String path = "/uapi/domestic-stock/v1/quotations/inquire-price";
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        headers.add("authorization", "dd");
        headers.add("appKey", appKey);
        headers.add("appSecret", appSecret);
        headers.add("tr_id", "FHKST01010100");


        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("fid_cond_mrkt_div_code", "J");
        params.add("fid_input_iscd", pdco);

        return null;
    }


}
