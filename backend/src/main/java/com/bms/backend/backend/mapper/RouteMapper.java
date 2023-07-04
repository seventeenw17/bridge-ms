package com.bms.backend.backend.mapper;

import com.bms.backend.backend.pojo.Route;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface RouteMapper {
    void insertOne(Map<String, String> map);
    List<String> getAllroute();

    String selectById(String route_id);

    Integer getRoutecnt();

    String getRouteByid(String route_id);

    List<Map<String, String>> getALL();

    void deleteRoute(String route_id);

    void updateRoute(Map<String, String> map);

    Map<String, String> getRoute(String route_id);

}
