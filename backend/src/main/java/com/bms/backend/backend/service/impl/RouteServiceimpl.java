package com.bms.backend.backend.service.impl;

import com.bms.backend.backend.mapper.RouteMapper;
import com.bms.backend.backend.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RouteServiceimpl implements RouteService {
    @Autowired
    RouteMapper routeMapper;
    @Override
    public void insertOne(Map<String, String> map) {
        System.out.println(map);
        routeMapper.insertOne(map);
    }

    @Override
    public String getNameByid(String route_id){
        String route_name = routeMapper.getRouteByid(route_id);
        return route_name;
    }

    @Override
    public List<Map<String, String>> getALL() {
        List<Map<String, String>> maps = routeMapper.getALL();
        return maps;
    }

    @Override
    public void deleteRoute(String route_id) {
        routeMapper.deleteRoute(route_id);
    }

    @Override
    public void updateRoute(Map<String, String> map) {
        routeMapper.updateRoute(map);
    }

}
