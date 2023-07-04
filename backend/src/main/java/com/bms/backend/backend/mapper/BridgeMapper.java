package com.bms.backend.backend.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface BridgeMapper {
    void insertOne(Map<String, String> map);
    String selectById(String brino);
    List<String> getAllbri();
    Integer getBricnt();
    String getRouteBybri(String bri_id);

    String getNameByid(String bri_id);
    Map<String, String> getBriByid(Map<String,String> map);
}
