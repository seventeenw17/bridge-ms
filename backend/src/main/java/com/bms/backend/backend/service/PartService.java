package com.bms.backend.backend.service;

import java.util.List;
import java.util.Map;

public interface PartService {
    void insertOne(Map<String, String> map);

    void deletePart(String part_id);

    void updatePart(Map<String, String> map);

    List<Map<String, String>> getALL();
}
