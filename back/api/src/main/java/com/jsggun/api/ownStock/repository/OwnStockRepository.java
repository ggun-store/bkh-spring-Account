package com.jsggun.api.ownStock.repository;

import com.jsggun.api.ownStock.model.OwnStock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnStockRepository extends JpaRepository<OwnStock,Long> {



}
