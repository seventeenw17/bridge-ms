package com.bms.backend.backend.service;

import java.util.List;
import java.util.Map;

public interface BridgeService {
    void insertOne(Map<String, String> map);
    List<Map<String, String>> getBri();
    List<String> getAllbri();
    Integer getBricnt();
    List<Map<String, String>> getBty();
    List<String> getAllbty();
    Integer getBtycnt();
    Map<String, String> getInfoBybri(String bri_id);

}
