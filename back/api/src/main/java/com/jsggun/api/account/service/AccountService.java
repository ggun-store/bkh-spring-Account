package com.jsggun.api.account.service;

import com.jsggun.api.account.domain.AccountModel;
import com.jsggun.api.account.domain.AccountDto;
import com.jsggun.api.common.component.Messenger;
import com.jsggun.api.common.service.CommandService;
import com.jsggun.api.common.service.QueryService;
import com.jsggun.api.user.domain.UserModel;

import java.util.List;

public interface AccountService extends CommandService<AccountDto>, QueryService<AccountDto> {

    default AccountModel dtoToEntity(AccountDto accountDto, UserModel userModel){
        return AccountModel.builder()
                .id(accountDto.getId())
                .acno(accountDto.getAcno())
                .acpw(accountDto.getAcpw())
                .balance(accountDto.getBalance())
                .bank(accountDto.getBank())
                .acType(accountDto.getAcType())
                .user(userModel)
                .build();
    }

    default AccountDto entityToDto(AccountModel accountModel){
        return AccountDto.builder()
                .id(accountModel.getId())
                .acno(accountModel.getAcno())
                .acpw(accountModel.getAcpw())
                .balance(accountModel.getBalance())
                .bank(accountModel.getBank())
                .acType(accountModel.getAcType())
                .user(accountModel.getUser().getId())
                .regDate(String.valueOf(accountModel.getRegDate()))
                .modDate(String.valueOf(accountModel.getRegDate()))
                .build();
    }


    List<AccountDto> findByUser(Long id);

    Messenger deposit(AccountDto accountDto);
}