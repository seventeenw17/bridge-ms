package com.bms.backend.backend.service.impl;

import com.bms.backend.backend.mapper.UnitMapper;
import com.bms.backend.backend.service.UnitsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UnitsServiceimpl implements UnitsService {

    @Autowired
    UnitMapper unitMapper;

    @Override
    public void insertOne(Map<String, String> map) {
        unitMapper.insertOne(map);
    }

    @Override
    public void deleteUnit(String units_id) {
        unitMapper.deleteUnit(units_id);
    }

    @Override
    public void updateUnit(Map<String, String> map) {
        System.out.println("ssssss");
        unitMapper.updateUnit(map);
    }

    @Override
    public List<Map<String, String>> getALL() {
        return unitMapper.getALL();
    }
}
