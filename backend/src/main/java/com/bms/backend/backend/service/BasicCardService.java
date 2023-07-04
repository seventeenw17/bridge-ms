package com.bms.backend.backend.service;

import java.util.List;
import java.util.Map;

public interface BasicCardService {

    void insertAidata(Map<String, String> map);

    Map<String, String> getAidataByid(Map<String, String> map);

    void insertTech(Map<String, String> map);

    Map<String, String> getTechByid(Map<String, String> map);

    void insertRecord(Map<String, String> map);

    Map<String, String> getRecordByid(Map<String, String> map);

    void insertCheckcard(Map<String, String> map);

    List<Map<String, String>> getCheckByid(Map<String, String> map);

    void insertCsere(Map<String, String> map);

    List<Map<String, String>> getCsereByid(Map<String, String> map);

    Map<String, String> getOthersByid(Map<String, String> map);

    void insertOthers(Map<String, String> map);

    Map<String, String> getBriByid(Map<String, String> map);

    void insertCo(Map<String, String> map);

    List<Map<String, String>> getCoByid(Map<String, String> map);
}
