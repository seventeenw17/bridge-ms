package com.bms.backend.backend.mapper;

import com.bms.backend.backend.pojo.Bridge;
import com.bms.backend.backend.pojo.BridgeType;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface BridgeTypeMapper {
    void insertOne(Map<String, String> map);
    List<String> getAllbty();
    String selectById(String bty_id);
    Integer getBtycnt();
    List<Map<String, String>> getALL();
    void deleteBty(String bty_id);
    void updateBty(Map<String, String> map);
}
