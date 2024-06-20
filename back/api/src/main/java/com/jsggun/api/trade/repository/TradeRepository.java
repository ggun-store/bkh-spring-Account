package com.jsggun.api.trade.repository;

import com.jsggun.api.account.domain.AccountModel;
import com.jsggun.api.trade.domain.TradeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface TradeRepository extends JpaRepository<TradeModel,Long>, TradeDao{


    List<TradeModel> findByAccount(AccountModel accountModel);

}
