package com.bms.backend.backend.service.impl;

import com.bms.backend.backend.mapper.AssunitMapper;
import com.bms.backend.backend.service.AssunitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class AssunitServiceimpl implements AssunitService {
    @Autowired
    AssunitMapper assunitMapper;

    @Override
    public void insertOne(Map<String, String> map) {
        assunitMapper.insertOne(map);
    }

    @Override
    public void deleteAssunit(String asun_id) {
        assunitMapper.deleteAssunit(asun_id);
    }

    @Override
    public List<Map<String, String>> getALL() {
        return assunitMapper.getall();
    }

    @Override
    public void updateAssunit(Map<String, String> map) {
        assunitMapper.updateAssunit(map);
    }

}
