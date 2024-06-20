package com.jsggun.api.account;

import com.jsggun.api.account.domain.AccountDto;
import com.jsggun.api.account.service.AccountService;
import com.jsggun.api.common.component.Messenger;
import com.siot.IamportRestClient.IamportClient;
import com.siot.IamportRestClient.response.IamportResponse;
import com.siot.IamportRestClient.response.Payment;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/accounts")
@CrossOrigin(origins = "*",allowedHeaders = "*")
@Slf4j
public class AccountController {

    private final AccountService service;

    private final IamportClient iamportClient;


    @PostMapping("/verifyIamport/{imp_uid}")
    public ResponseEntity<?> paymentByImpUid(@PathVariable("imp_uid") String imp_uid) {
        log.info("imp_uid={}", imp_uid);
        IamportResponse<Payment> response = iamportClient.paymentByImpUid(imp_uid);
        log.info("결제 요청 응답. 결제 내역 - 주문 번호: {}", response.getResponse());
        return ResponseEntity.ok(response);
    }

    @PostMapping("/save")
    public ResponseEntity<Messenger> save(@RequestBody AccountDto accountDto){
        log.info("계좌가입 입력정보 {} ",accountDto);
        return ResponseEntity.ok(service.save(accountDto));
    }

    @PostMapping("/deposit")
    public ResponseEntity<Messenger> deposit(@RequestBody AccountDto accountDto){
        log.info("계좌가입 입력정보 {} ",accountDto);
        return ResponseEntity.ok(service.deposit(accountDto));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Messenger> deleteById(@RequestParam long id){
        return ResponseEntity.ok(service.deleteById(id));
    }

    @GetMapping("/list")
    public ResponseEntity<List<AccountDto>> findByUser(@RequestParam Long id){
        return ResponseEntity.ok(service.findByUser(id));
    }

    @GetMapping("/detail")
    public ResponseEntity<Optional<AccountDto>> findById(@RequestParam long id){
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping("/count")
    public ResponseEntity<Long> count(){
        return ResponseEntity.ok(service.count());
    }

    @GetMapping("/exists/{id}")
    public ResponseEntity<Boolean> existsById(@RequestParam long id){
        return ResponseEntity.ok(service.existsById(id));
    }

}
