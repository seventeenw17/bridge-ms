package com.bms.backend.backend.service;

import java.util.Map;

public interface InitRecordService {
    void insertOne(Map<String, String> map);
    Map<String, String> getInitcard(Map<String, String> map);

    void insertBri(Map<String, String> map);

    Map<String, String> getBriByid(Map<String, String> map);

    void insertTech(Map<String, String> map);

    Map<String,String> getTechByid(Map<String,String> map);
}
