package com.bms.backend.backend.service;

import java.util.List;
import java.util.Map;

public interface AssunitService {
    void insertOne(Map<String, String> map);

    void deleteAssunit(String asun_id);

    List<Map<String, String>> getALL();

    void updateAssunit(Map<String, String> map);
}
