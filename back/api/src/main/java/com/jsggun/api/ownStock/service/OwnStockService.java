package com.jsggun.api.ownStock.service;

import com.jsggun.api.account.domain.AccountModel;
import com.jsggun.api.common.service.CommandService;
import com.jsggun.api.common.service.QueryService;
import com.jsggun.api.ownStock.domain.OwnStockModel;
import com.jsggun.api.ownStock.domain.OwnStockDto;

import java.util.List;

public interface OwnStockService extends CommandService<OwnStockDto>, QueryService<OwnStockDto> {
    default OwnStockModel dtoToEntity(OwnStockDto ownStockDto, AccountModel accountModel){
        return OwnStockModel.builder()
                .id(ownStockDto.getId())
                .pdno(ownStockDto.getPdno())
                .prdtName(ownStockDto.getPrdtName())
                .pdQty(ownStockDto.getPdQty())
                .avgPrvs(ownStockDto.getAvgPrvs())
                .tradeType(ownStockDto.getTradeType())
                .accountModel(accountModel)
                .build();
    }

    default OwnStockDto entityToDto(OwnStockModel ownStockModel){
        return OwnStockDto.builder()
                .id(ownStockModel.getId())
                .pdno(ownStockModel.getPdno())
                .prdtName(ownStockModel.getPrdtName())
                .pdQty(ownStockModel.getPdQty())
                .avgPrvs(ownStockModel.getAvgPrvs())
                .tradeType(ownStockModel.getTradeType())
                .account(ownStockModel.getAccountModel().getId())

                .build();
    }


    List<OwnStockDto> findByAccount(Long id);
}
