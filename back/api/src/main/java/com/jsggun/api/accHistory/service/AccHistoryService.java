package com.jsggun.api.accHistory.service;

import com.jsggun.api.accHistory.domain.AccHistoryModel;
import com.jsggun.api.accHistory.domain.AccHistoryDto;
import com.jsggun.api.account.domain.AccountModel;
import com.jsggun.api.common.service.CommandService;
import com.jsggun.api.common.service.QueryService;

import java.util.List;

public interface AccHistoryService extends CommandService<AccHistoryDto>, QueryService<AccHistoryDto> {


    default AccHistoryModel dtoToEntity(AccHistoryDto accHistorydto, AccountModel accountModel){
        return AccHistoryModel.builder()
                .id(accHistorydto.getId())
                .balance(accHistorydto.getBalance())
                .tradeType(accHistorydto.getTradeType())
                .bank(accHistorydto.getBank())
                .accountModel(accountModel)
                .build();
    }

    default AccHistoryDto entityToDto(AccHistoryModel accHistoryModel){
        return AccHistoryDto.builder()
                .id(accHistoryModel.getId())
                .balance(accHistoryModel.getBalance())
                .tradeType(accHistoryModel.getTradeType())
                .bank(accHistoryModel.getBank())
                .account(accHistoryModel.getAccountModel().getId())
                .build();
    }


    List<AccHistoryDto> findByAccount(Long id);
}
