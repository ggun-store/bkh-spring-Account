package com.jsggun.api.ownStock.service;

import com.jsggun.api.common.component.Messenger;
import com.jsggun.api.common.model.KoreaInvestmentRequestToken;
import com.jsggun.api.common.model.KoreaInvestmentResponseToken;
import com.jsggun.api.common.service.KoreaInvestmentOpenFeign;
import com.jsggun.api.common.service.RestTemplateService;
import com.jsggun.api.ownStock.domain.OwnStockDto;
import com.jsggun.api.ownStock.repository.OwnStockRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class OwnStockServiceImpl implements OwnStockService {

    private final OwnStockRepository ownStockRepository;
    private final RestTemplateService restTemplateService;
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
        KoreaInvestmentResponseToken token = restTemplateService.getToken(KoreaInvestmentRequestToken.builder()
                        .appkey(appKey)
                        .appsecret(appSecret)
                        .grant_type("client_credentials")
                .build());
        log.info("토큰 확인 : {}", token.getAccess_token());
        return 5000;
    }

    @Override
    public boolean existsById(Long id) {
        return false;
    }







}
