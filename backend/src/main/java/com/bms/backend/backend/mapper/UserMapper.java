package com.bms.backend.backend.mapper;


import com.bms.backend.backend.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Mapper
@Repository
public interface UserMapper {
    void insertOne(User user);
    User getUserByUsername(String username);
}