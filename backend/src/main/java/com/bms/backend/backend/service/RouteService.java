package com.bms.backend.backend.service;

import java.util.List;
import java.util.Map;

public interface RouteService {
    void insertOne(Map<String, String> map);

    String getNameByid(String route_id);

    List<Map<String, String>> getALL();

    void deleteRoute(String route_id);

    void updateRoute(Map<String, String> map);
}
