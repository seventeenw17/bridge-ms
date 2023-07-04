package com.bms.backend.backend.mapper;


import com.bms.backend.backend.pojo.Aidata;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface AidataMapper {
    void insertOne(Map<String, String> map);
    Map<String, String> getallByid(Map<String, String> map);

}
