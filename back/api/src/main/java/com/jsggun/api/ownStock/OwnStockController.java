package com.jsggun.api.ownStock;

import com.jsggun.api.common.component.Messenger;
import com.jsggun.api.ownStock.model.OwnStockDto;
import com.jsggun.api.ownStock.service.OwnStockService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/ownStocks")
@CrossOrigin(origins = "*",allowedHeaders = "*")
@Slf4j
public class OwnStockController {
    
    private final OwnStockService ownStockService;


    @Value("${koreainvestment.key}")
    private String appKey;

    @Value("${koreainvestment.secret}")
    private String appSecret;

    @PostMapping("/save")
    public ResponseEntity<Messenger> save(@RequestBody OwnStockDto ownStockDto){
        return ResponseEntity.ok(ownStockService.save(ownStockDto));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Messenger> deleteById(@RequestParam long id){
        return ResponseEntity.ok(ownStockService.deleteById(id));
    }

    @GetMapping("/list")
    public ResponseEntity<List<OwnStockDto>> findAll(@RequestParam Long id){
        return ResponseEntity.ok(ownStockService.findByAccount(id));
    }

    @GetMapping("/detail")
    public ResponseEntity<Optional<OwnStockDto>> findById(@RequestParam long id){
        return ResponseEntity.ok(ownStockService.findById(id));
    }

    @GetMapping("/count")
    public ResponseEntity<Long> count(){
        return ResponseEntity.ok(ownStockService.count());
    }

    @GetMapping("/exists/{id}")
    public ResponseEntity<Boolean> existsById(@RequestParam long id){
        return ResponseEntity.ok(ownStockService.existsById(id));
    }

}
