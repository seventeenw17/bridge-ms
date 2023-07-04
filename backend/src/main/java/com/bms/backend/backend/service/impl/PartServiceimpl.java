package com.bms.backend.backend.service.impl;

import com.bms.backend.backend.mapper.PartMapper;
import com.bms.backend.backend.service.PartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
@Service
public class PartServiceimpl implements PartService {
    @Autowired
    PartMapper partMapper;
    @Override
    public void insertOne(Map<String, String> map) {
        partMapper.insertOne(map);
    }

    @Override
    public void deletePart(String part_id) {
        partMapper.deletePart(part_id);
    }

    @Override
    public void updatePart(Map<String, String> map) {
        partMapper.updatePart(map);
    }

    @Override
    public List<Map<String, String>> getALL() {
        return partMapper.getAll();
    }

}
