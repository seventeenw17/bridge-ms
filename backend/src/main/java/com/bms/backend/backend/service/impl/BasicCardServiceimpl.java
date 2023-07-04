package com.bms.backend.backend.service.impl;

import com.bms.backend.backend.mapper.*;
import com.bms.backend.backend.service.BasicCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class BasicCardServiceimpl implements BasicCardService {

    @Autowired
    AidataMapper aidataMapper;

    @Autowired
    TechIndexMapper techIndexMapper;

    @Autowired
    BridgeRecordMapper bridgeRecordMapper;

    @Autowired
    BridgeCheckRecordMapper bridgeCheckRecordMapper;

    @Autowired
    CsereRecordMapper csereRecordMapper;

    @Autowired
    OthersMapper othersMapper;

    @Autowired
    BridgeMapper bridgeMapper;

    @Autowired
    CooperationMapper cooperationMapper;

    @Override
    public void insertAidata(Map<String, String> map) {
        aidataMapper.insertOne(map);
    }

    @Override
    public Map<String, String> getAidataByid(Map<String, String> map) {
        return aidataMapper.getallByid(map);
    }

    @Override
    public void insertTech(Map<String, String> map) {
        techIndexMapper.insertOne(map);
    }

    @Override
    public Map<String, String> getTechByid(Map<String, String> map) {
        return techIndexMapper.getallByid(map);
    }

    @Override
    public void insertRecord(Map<String, String> map) {
        bridgeRecordMapper.insertOne(map);
    }

    @Override
    public Map<String, String> getRecordByid(Map<String, String> map) {
        return bridgeRecordMapper.getreByid(map);
    }

    @Override
    public void insertCheckcard(Map<String, String> map) {
        bridgeCheckRecordMapper.insertOne(map);
    }

    @Override
    public List<Map<String, String>> getCheckByid(Map<String, String> map) {
        return bridgeCheckRecordMapper.getcheckcard(map);
    }

    @Override
    public void insertCsere(Map<String, String> map) {
        csereRecordMapper.insertOne(map);
    }

    @Override
    public List<Map<String, String>> getCsereByid(Map<String, String> map) {
        return csereRecordMapper.getCsere(map);
    }

    @Override
    public Map<String, String> getOthersByid(Map<String, String> map) {
        return othersMapper.getOthers(map);
    }

    @Override
    public void insertOthers(Map<String, String> map) {
        othersMapper.insertOne(map);
    }

    @Override
    public Map<String, String> getBriByid(Map<String, String> map) {
        return bridgeMapper.getBriByid(map);
    }

    @Override
    public void insertCo(Map<String, String> map) {
        cooperationMapper.insertOne(map);
    }

    @Override
    public List<Map<String, String>> getCoByid(Map<String, String> map) {
        return cooperationMapper.getCoByid(map);
    }

}
