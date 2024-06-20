package com.jsggun.api.accHistory.repository;

import com.jsggun.api.accHistory.model.AccHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccHistoryRepository extends JpaRepository<AccHistory,Long> {


}
