package com.bms.backend.backend.service;

import java.util.List;
import java.util.Map;

public interface BtyService {
    void insertOne(Map<String, String> map);

    void deleteBty(String bty_id);

    List<Map<String, String>> getALL();

    void updateBty(Map<String, String> map);
}
