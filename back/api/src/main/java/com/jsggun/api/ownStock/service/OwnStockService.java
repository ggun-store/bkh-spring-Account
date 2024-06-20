package com.jsggun.api.ownStock.service;

import com.jsggun.api.accHistory.model.AccHistoryDto;
import com.jsggun.api.account.model.Account;
import com.jsggun.api.account.model.AccountDto;
import com.jsggun.api.common.service.CommandService;
import com.jsggun.api.common.service.QueryService;
import com.jsggun.api.ownStock.model.OwnStock;
import com.jsggun.api.ownStock.model.OwnStockDto;
import com.jsggun.api.user.model.User;

import java.util.List;

public interface OwnStockService extends CommandService<OwnStockDto>, QueryService<OwnStockDto> {
    default OwnStock dtoToEntity(OwnStockDto ownStockDto, Account account){
        return OwnStock.builder()
                .id(ownStockDto.getId())
                .pdno(ownStockDto.getPdno())
                .prdtName(ownStockDto.getPrdtName())
                .pdQty(ownStockDto.getPdQty())
                .avgPrvs(ownStockDto.getAvgPrvs())
                .tradeType(ownStockDto.getTradeType())
                .account(account)
                .build();
    }

    default OwnStockDto entityToDto(OwnStock ownStock){
        return OwnStockDto.builder()
                .id(ownStock.getId())
                .pdno(ownStock.getPdno())
                .prdtName(ownStock.getPrdtName())
                .pdQty(ownStock.getPdQty())
                .avgPrvs(ownStock.getAvgPrvs())
                .tradeType(ownStock.getTradeType())
                .account(ownStock.getAccount().getId())

                .build();
    }


    List<OwnStockDto> findByAccount(Long id);
}
