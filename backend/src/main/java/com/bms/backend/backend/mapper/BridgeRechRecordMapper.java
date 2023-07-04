package com.bms.backend.backend.mapper;

import com.bms.backend.backend.pojo.BridgeRechRecord;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Mapper
@Repository
public interface BridgeRechRecordMapper {
    void insertOne(Map<String, String> map);
    Map<String, String> getRech(Map<String, String> map);
}
