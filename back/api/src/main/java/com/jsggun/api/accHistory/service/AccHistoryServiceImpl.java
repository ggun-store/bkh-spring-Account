package com.jsggun.api.accHistory.service;

import com.jsggun.api.accHistory.domain.AccHistoryDto;
import com.jsggun.api.common.component.Messenger;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccHistoryServiceImpl implements AccHistoryService{
    @Override
    public Messenger save(AccHistoryDto accHistoryDto) {
        return null;
    }

    @Override
    public Messenger deleteById(Long id) {
        return null;
    }

    @Override
    public Optional<AccHistoryDto> modify(AccHistoryDto accHistoryDto) {
        return Optional.empty();
    }

    @Override
    public List<AccHistoryDto> findAll() {
        return null;
    }

    @Override
    public Optional<AccHistoryDto> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public boolean existsById(Long id) {
        return false;
    }

    @Override
    public List<AccHistoryDto> findByAccount(Long id) {
        return null;
    }
}
