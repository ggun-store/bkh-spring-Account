package com.jsggun.api.nonCcld.service;

import com.jsggun.api.account.domain.AccountModel;
import com.jsggun.api.common.service.CommandService;
import com.jsggun.api.common.service.QueryService;
import com.jsggun.api.nonCcld.domain.NonCcldModel;
import com.jsggun.api.nonCcld.domain.NonCcldDto;

import java.util.List;

public interface NonCcldService extends CommandService<NonCcldDto>, QueryService<NonCcldDto> {

    default NonCcldModel dtoToEntity(NonCcldDto nonCcldDto, AccountModel accountModel){
        return NonCcldModel.builder()
                .id(nonCcldDto.getId())
                .ccldPrvs(nonCcldDto.getCcldPrvs())
                .volume(nonCcldDto.getVolume())
                .accountModel(accountModel)
                .build();
    }

    default NonCcldDto entityToDto(NonCcldModel nonCcldModel){
        return NonCcldDto.builder()
                .id(nonCcldModel.getId())
                .ccldPrvs(nonCcldModel.getCcldPrvs())
                .volume(nonCcldModel.getVolume())
                .account(nonCcldModel.getAccountModel().getId())
                .build();
    }


    List<NonCcldDto> findByAccount(Long id);
}
