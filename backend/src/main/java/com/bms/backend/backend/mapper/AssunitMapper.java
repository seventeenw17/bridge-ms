package com.bms.backend.backend.mapper;

import com.bms.backend.backend.pojo.Assunit;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface AssunitMapper {
    void insertOne(Map<String, String> map);
    void deleteAssunit(String asun_id);

    List<Map<String, String>> getall();

    void updateAssunit(Map<String, String> map);
}
