package com.bms.backend.backend.controller;

import com.bms.backend.backend.service.BridgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class BridgeController {
    @Autowired
    BridgeService bridgeService;
    @PostMapping("/api/bridge/insertOne")
    public void insertOne(@RequestParam Map<String, String> map) {
        bridgeService.insertOne(map);
    }
    @GetMapping("/api/bridge/getBri")
    public List<Map<String, String>> getBri() {
        return bridgeService.getBri();
    }

    @GetMapping("/api/bridge/getbty")
    public List<Map<String, String>> getBty() {
        return bridgeService.getBty();
    }

    @PostMapping("/api/bridge/getinfobybri")
    public Map<String, String>  getInfoBybri(@RequestParam String bri_id) {
        return bridgeService.getInfoBybri(bri_id);
    }

}

