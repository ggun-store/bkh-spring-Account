package com.jsggun.api.accHistory.service;

import com.jsggun.api.accHistory.model.AccHistory;
import com.jsggun.api.accHistory.model.AccHistoryDto;
import com.jsggun.api.account.model.Account;
import com.jsggun.api.account.model.AccountDto;
import com.jsggun.api.common.service.CommandService;
import com.jsggun.api.common.service.QueryService;
import com.jsggun.api.user.model.User;

import java.util.List;

public interface AccHistoryService extends CommandService<AccHistoryDto>, QueryService<AccHistoryDto> {


    default AccHistory dtoToEntity(AccHistoryDto accHistorydto,Account account){
        return AccHistory.builder()
                .id(accHistorydto.getId())
                .balance(accHistorydto.getBalance())
                .tradeType(accHistorydto.getTradeType())
                .bank(accHistorydto.getBank())
                .account(account)
                .build();
    }

    default AccHistoryDto entityToDto(AccHistory accHistory){
        return AccHistoryDto.builder()
                .id(accHistory.getId())
                .balance(accHistory.getBalance())
                .tradeType(accHistory.getTradeType())
                .bank(accHistory.getBank())
                .account(accHistory.getAccount().getId())
                .build();
    }


    List<AccHistoryDto> findByAccount(Long id);
}
