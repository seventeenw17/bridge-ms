package com.bms.backend.backend.service;

import java.util.List;
import java.util.Map;

public interface RechCardService {
    void insertRech(Map<String, String> map);

    Map<String, String> getRech(Map<String, String> map);

    void insertBri(Map<String, String> map);

    Map<String, String> getBriByid(Map<String, String> map);

    void insertTech(Map<String, String> map);

    Map<String, String> getTechByid(Map<String, String> map);

    void insertRoute(Map<String, String> map);

    Map<String, String> getRoute(Map<String, String> map);

    void insertCo(Map<String, String> map);

    List<Map<String, String>> getCoByid(Map<String, String> map);
}
