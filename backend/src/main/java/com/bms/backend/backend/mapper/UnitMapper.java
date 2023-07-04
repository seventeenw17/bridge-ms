package com.bms.backend.backend.mapper;


import com.bms.backend.backend.pojo.Units;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;


@Mapper
@Repository
public interface UnitMapper {
    Units getUnit(String units_id);
    void insertOne(Map<String, String> map);
    void deleteUnit(String units_id);
    void updateUnit(Map<String, String> map);

    List<Map<String, String>> getALL();
}