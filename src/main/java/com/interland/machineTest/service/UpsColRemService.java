package com.interland.machineTest.service;

import com.interland.machineTest.domain.UpsColRem;
import com.interland.machineTest.repository.UpsColRemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UpsColRemService {

    @Autowired
    private UpsColRemRepo upsColRemRepo;

    public List<UpsColRem> listAll() {
        return upsColRemRepo.findAll();
    }

    public void save(UpsColRem upsColRem) {
        upsColRemRepo.save(upsColRem);
    }

    public List<UpsColRem> findByClientOrScheme(String client, String scheme) {
        return upsColRemRepo.findByBranchIdAndEmployeeId(client, scheme);
    }

    public UpsColRem get(Long id) {
        return upsColRemRepo.getOne(id);
    }

    public void delete(Long id) {
        upsColRemRepo.deleteById(id);
    }
}
