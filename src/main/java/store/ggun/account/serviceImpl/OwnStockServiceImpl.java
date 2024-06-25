package store.ggun.account.serviceImpl;

import org.springframework.transaction.annotation.Transactional;
import store.ggun.account.domain.dto.Messenger;
import store.ggun.account.domain.dto.OwnStockDto;
import store.ggun.account.domain.model.AccountModel;
import store.ggun.account.domain.model.OwnStockModel;
import store.ggun.account.repository.AccountRepository;
import store.ggun.account.repository.OwnStockRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import store.ggun.account.service.OwnStockService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class OwnStockServiceImpl implements OwnStockService {

    private final OwnStockRepository ownStockRepository;
    private final AccountRepository accountRepository;
    private final KISOpenFeign openFeign;
    @Value("${koreainvestment.key}")
    private String appKey;

    @Value("${koreainvestment.secret}")
    private String appSecret;


    @Override
    public List<OwnStockDto> findByAccount(Long id) {
        return null;
    }

    @Override
    @Transactional
    public Messenger save(OwnStockDto ownStockDto) {
        Optional<OwnStockModel> stock = ownStockRepository.findByPdnoAndAccountIdAndTradeType(ownStockDto.getPdno(),ownStockDto.getAccount(),ownStockDto.getTradeType());
        Optional<AccountModel> account = accountRepository.findById(ownStockDto.getAccount());


        if(stock.isEmpty()){
            ownStockRepository.save(OwnStockModel.builder()
                            .pdno(ownStockDto.getPdno())
                            .prdtName(ownStockDto.getPrdtName())
                            .pdQty(ownStockDto.getPdQty())
                            .avgPrvs(ownStockDto.getAvgPrvs())
                            .tradeType(ownStockDto.getTradeType())
                            .account(account.get())
                    .build());

        return Messenger.builder().message("주문 완료").build();

        }else {
            stock.get().setPdQty(stock.get().getPdQty()+ownStockDto.getPdQty());
            stock.get().setAvgPrvs((ownStockDto.getAvgPrvs()+stock.get().getAvgPrvs())/2);

            ownStockRepository.save(stock.get());


        return Messenger.builder().message("주문 완료").build();
        }
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
        openFeign.getAppToken();
        openFeign.getPrice("005930");
        return 0;
    }

    @Override
    public boolean existsById(Long id) {
        return false;
    }







}
