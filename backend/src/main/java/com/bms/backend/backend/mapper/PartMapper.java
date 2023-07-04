package com.bms.backend.backend.mapper;

import com.bms.backend.backend.pojo.Part;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface PartMapper {
    void insertOne(Map<String, String> map);
    void deletePart(String part_id);

    List<Map<String, String>> getAll();

    void updatePart(Map<String, String> map);
}
