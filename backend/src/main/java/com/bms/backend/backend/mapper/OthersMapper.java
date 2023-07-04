package com.bms.backend.backend.mapper;

import com.bms.backend.backend.pojo.Others;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Mapper
@Repository
public interface OthersMapper {
    void insertOne(Map<String, String> map);

    String getPicUrl(String brino);

    Integer getOthcnt();

    Map<String, String> getOthers(Map<String, String> map);
}
