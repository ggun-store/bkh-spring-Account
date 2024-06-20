package com.jsggun.api.nonCcld.service;

import com.jsggun.api.common.component.Messenger;
import com.jsggun.api.nonCcld.domain.NonCcldDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class NonCcldServiceImpl implements NonCcldService{


    @Override
    public Messenger save(NonCcldDto nonCcldDto) {
        return null;
    }

    @Override
    public Messenger deleteById(Long id) {
        return null;
    }

    @Override
    public Optional<NonCcldDto> modify(NonCcldDto nonCcldDto) {
        return Optional.empty();
    }

    @Override
    public List<NonCcldDto> findAll() {
        return null;
    }

    @Override
    public Optional<NonCcldDto> findById(Long id) {
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
    public List<NonCcldDto> findByAccount(Long id) {
        return null;
    }
}
