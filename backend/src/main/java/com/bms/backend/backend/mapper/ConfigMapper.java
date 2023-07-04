package com.bms.backend.backend.mapper;

import com.bms.backend.backend.pojo.Config;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ConfigMapper {
    default void insertOne() {
        insertOne(null);
    }
    void insertOne(Config config);
}
