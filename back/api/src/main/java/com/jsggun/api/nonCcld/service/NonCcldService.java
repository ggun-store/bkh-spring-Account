package com.jsggun.api.nonCcld.service;

import com.jsggun.api.account.model.Account;
import com.jsggun.api.account.model.AccountDto;
import com.jsggun.api.common.service.CommandService;
import com.jsggun.api.common.service.QueryService;
import com.jsggun.api.nonCcld.NonCcldController;
import com.jsggun.api.nonCcld.model.NonCcld;
import com.jsggun.api.nonCcld.model.NonCcldDto;
import com.jsggun.api.user.model.User;

import java.util.List;

public interface NonCcldService extends CommandService<NonCcldDto>, QueryService<NonCcldDto> {

    default NonCcld dtoToEntity(NonCcldDto nonCcldDto, Account account){
        return NonCcld.builder()
                .id(nonCcldDto.getId())
                .ccldPrvs(nonCcldDto.getCcldPrvs())
                .volume(nonCcldDto.getVolume())
                .account(account)
                .build();
    }

    default NonCcldDto entityToDto(NonCcld nonCcld){
        return NonCcldDto.builder()
                .id(nonCcld.getId())
                .ccldPrvs(nonCcld.getCcldPrvs())    
                .volume(nonCcld.getVolume())
                .account(nonCcld.getAccount().getId())
                .build();
    }


    List<NonCcldDto> findByAccount(Long id);
}
