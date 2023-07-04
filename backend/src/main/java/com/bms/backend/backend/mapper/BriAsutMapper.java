package com.bms.backend.backend.mapper;

import com.bms.backend.backend.pojo.BriAsut;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface BriAsutMapper {
    void insertOne(BriAsut briAsut);
}
