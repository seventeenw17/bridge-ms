package com.bms.backend.backend.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Mapper
@Repository
public interface BridgeRecordMapper {
    void insertOne(Map<String, String> map);
    Map<String, String> getreByid(Map<String, String> map);
}
