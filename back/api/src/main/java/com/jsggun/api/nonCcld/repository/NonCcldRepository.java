package com.jsggun.api.nonCcld.repository;


import com.jsggun.api.nonCcld.domain.NonCcldModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NonCcldRepository extends JpaRepository<NonCcldModel,Long> {
}
