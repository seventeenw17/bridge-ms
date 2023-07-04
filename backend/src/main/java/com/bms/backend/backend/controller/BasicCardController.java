package com.bms.backend.backend.controller;

import com.bms.backend.backend.service.BasicCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class BasicCardController {
    @Autowired
    BasicCardService basicCardService;

    @GetMapping("/api/basic/get/others")
    public Map<String, String> getOthers(@RequestParam Map<String, String> map) {
        return basicCardService.getOthersByid(map);
    }

    @GetMapping("/api/basic/get/aidata")
    public Map<String, String> getAidata(@RequestParam Map<String, String> map) {
        return basicCardService.getAidataByid(map);
    }

    @GetMapping("/api/basic/get/tech")
    public Map<String, String> getTech(@RequestParam Map<String, String> map) {
        return basicCardService.getTechByid(map);
    }

    @GetMapping("/api/basic/get/bridgerecord")
    public Map<String, String> getBridgeRecord(@RequestParam Map<String, String> map) {
        return basicCardService.getRecordByid(map);
    }

    @GetMapping("/api/basic/get/check")
    public List<Map<String, String>> getCheck(@RequestParam Map<String, String> map) {
        return basicCardService.getCheckByid(map);
    }

    @GetMapping("/api/basic/get/csere")
    public List<Map<String, String>> getCsere(@RequestParam Map<String, String> map) {
        return basicCardService.getCsereByid(map);
    }

    @GetMapping("/api/basic/get/bridge")
    public Map<String, String> getBriByid(@RequestParam Map<String, String> map) {
        return basicCardService.getBriByid(map);
    }

    @GetMapping("/api/basic/get/co")
    public List<Map<String, String>> getCo(@RequestParam Map<String, String> map) {
        return basicCardService.getCoByid(map);
    }

    @PostMapping("/api/basic/insert/others")
    public void insertOthers(@RequestParam Map<String, String> map) {
        basicCardService.insertOthers(map);
    }

    @PostMapping("/api/basic/insert/aidata")
    public void insertAIdata(@RequestParam Map<String, String> map) {
        basicCardService.insertAidata(map);
    }

    @PostMapping("/api/basic/insert/tech")
    public void insertTech(@RequestParam Map<String, String> map) {
        basicCardService.insertTech(map);
    }

    @PostMapping("/api/basic/insert/bridgerecord")
    public void insertRecord(@RequestParam Map<String, String> map) {
        basicCardService.insertRecord(map);
    }

    @PostMapping("/api/basic/insert/check")
    public void insertCheck(@RequestParam Map<String, String> map) {
        basicCardService.insertCheckcard(map);
    }

    @PostMapping("/api/basic/insert/csere")
    public void insertCsere(@RequestParam Map<String, String> map) {
        basicCardService.insertCsere(map);
    }

    @PostMapping("/api/basic/insert/co")
    public void insertCo(@RequestParam Map<String, String> map) {
        basicCardService.insertCo(map);
    }
}
