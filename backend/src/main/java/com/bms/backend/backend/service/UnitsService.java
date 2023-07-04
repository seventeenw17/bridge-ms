package com.bms.backend.backend.service;

import java.util.List;
import java.util.Map;

public interface UnitsService {

    void insertOne(Map<String, String> map);

    void deleteUnit(String units_id);

    void updateUnit(Map<String, String> map);

    List<Map<String, String>> getALL();
}
