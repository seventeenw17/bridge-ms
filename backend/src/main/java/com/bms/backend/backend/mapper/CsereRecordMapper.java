package com.bms.backend.backend.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface CsereRecordMapper {
    void insertOne(Map<String, String> map);
    List<Map<String, String>> getCsere(Map<String, String> map);
}
