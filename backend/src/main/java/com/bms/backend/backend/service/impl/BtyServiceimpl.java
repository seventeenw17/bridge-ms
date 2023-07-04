package com.bms.backend.backend.service.impl;

import com.bms.backend.backend.mapper.BridgeTypeMapper;
import com.bms.backend.backend.service.BtyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class BtyServiceimpl implements BtyService {
    @Autowired
    BridgeTypeMapper bridgeTypeMapper;

    @Override
    public void insertOne(Map<String, String> map){
        System.out.println("212121212121");
        bridgeTypeMapper.insertOne(map);
    }

    @Override
    public void deleteBty(String bty_id) {
        bridgeTypeMapper.deleteBty(bty_id);
    }

    @Override
    public List<Map<String, String>> getALL() {
        return bridgeTypeMapper.getALL();
    }

    @Override
    public void updateBty(Map<String, String> map) {
        bridgeTypeMapper.updateBty(map);
    }
}
