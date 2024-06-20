package com.jsggun.api.nonCcld.repository;


import com.jsggun.api.nonCcld.model.NonCcld;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NonCcldRepository extends JpaRepository<NonCcld,Long> {
}
