package com.interland.machineTest.repository;

import com.interland.machineTest.domain.UpsColRem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UpsColRemRepo extends JpaRepository<UpsColRem, Long> {

    @Query("select u from UpsColRem u where u.clientId = ?1 or u.schemeId = ?2")
    List<UpsColRem> findByBranchIdAndEmployeeId(String clientId, String schemeId);
}
