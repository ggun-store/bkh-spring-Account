package com.jsggun.api.accHistory.repository;

import com.jsggun.api.accHistory.domain.AccHistoryModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccHistoryRepository extends JpaRepository<AccHistoryModel,Long> {


}
