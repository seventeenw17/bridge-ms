package com.bms.backend.backend.mapper;

import com.bms.backend.backend.pojo.BridgeCheckRecord;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface BridgeCheckRecordMapper {
    void insertOne(Map<String, String> map);
    List<Map<String, String>> getcheckcard(Map<String, String> map);
}
