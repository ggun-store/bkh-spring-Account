package com.jsggun.api.trade.repository;

import com.jsggun.api.trade.domain.TradeModel;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TradeDao {


    List<TradeModel> getListByProductName(String prdtName);
}
