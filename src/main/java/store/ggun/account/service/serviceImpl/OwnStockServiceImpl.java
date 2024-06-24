package store.ggun.account.service.serviceImpl;

import store.ggun.account.domain.dto.Messenger;
import store.ggun.account.domain.dto.OwnStockDto;
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
    private final KoreaInvestmentOpenFeignImpl openFeign;
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
        openFeign.getAppToken();
        openFeign.getPrice("005930");
        return 0;
    }

    @Override
    public boolean existsById(Long id) {
        return false;
    }







}
