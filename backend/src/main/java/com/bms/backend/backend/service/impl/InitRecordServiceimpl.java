package com.bms.backend.backend.service.impl;

import com.bms.backend.backend.mapper.*;
import com.bms.backend.backend.service.InitRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class InitRecordServiceimpl implements InitRecordService {

    @Autowired
    BridgeInitRecordMapper bridgeInitRecordMapper;

    @Autowired
    BridgeMapper bridgeMapper;

    @Autowired
    TechIndexMapper techIndexMapper;

    @Override
    public void insertOne(Map<String, String> map) {
        bridgeInitRecordMapper.insertOne(map);
    }

    @Override
    public Map<String, String> getInitcard(Map<String, String> map) {
        return bridgeInitRecordMapper.getInitcard(map);
    }

    @Override
    public void insertBri(Map<String, String> map) {
        bridgeMapper.insertOne(map);
    }

    @Override
    public Map<String, String> getBriByid(Map<String, String> map) {
        return bridgeMapper.getBriByid(map);
    }

    @Override
    public void insertTech(Map<String, String> map) {
        techIndexMapper.insertOne(map);
    }

    @Override
    public Map<String, String> getTechByid(Map<String, String> map) {
        return techIndexMapper.getallByid(map);
    }

}
