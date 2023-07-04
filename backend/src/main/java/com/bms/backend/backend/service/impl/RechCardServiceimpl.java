package com.bms.backend.backend.service.impl;

import com.bms.backend.backend.mapper.*;
import com.bms.backend.backend.service.RechCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class RechCardServiceimpl implements RechCardService {
    @Autowired
    BridgeRechRecordMapper bridgeRechRecordMapper;

    @Autowired
    BridgeMapper bridgeMapper;

    @Autowired
    TechIndexMapper techIndexMapper;

    @Autowired
    RouteMapper routeMapper;

    @Autowired
    CooperationMapper cooperationMapper;

    @Override
    public void insertRech(Map<String, String> map) {
        bridgeRechRecordMapper.insertOne(map);
    }

    @Override
    public Map<String, String> getRech(Map<String, String> map) {
        return bridgeRechRecordMapper.getRech(map);
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

    @Override
    public void insertRoute(Map<String, String> map) {
        routeMapper.insertOne(map);
    }
    @Override
    public Map<String, String> getRoute(Map<String, String> map) {
        String route_id = bridgeMapper.getRouteBybri(map.get("bri_id"));
        return routeMapper.getRoute(route_id);
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
