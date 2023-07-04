package com.bms.backend.backend.controller;

import com.bms.backend.backend.service.InitRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@RestController
public class InitCardController {
    @Autowired
    InitRecordService initRecordService;

    @GetMapping("/api/init/get/init")
    public Map<String, String> getinit(@RequestParam Map<String,String> map) {
        return initRecordService.getInitcard(map);
    }

    @GetMapping("/api/init/get/bridge")
    public Map<String, String> getBri(@RequestParam Map<String,String> map) {
        return initRecordService.getBriByid(map);
    }

    @GetMapping("/api/init/get/tech")
    public Map<String, String> gettech(@RequestParam Map<String,String> map) {
        return initRecordService.getTechByid(map);
    }

    @PostMapping("/api/init/insert/init")
    public void insertInit(@RequestParam Map<String, String> map) {
        initRecordService.insertOne(map);
    }

    @PostMapping("/api/init/insert/tech")
    public void insertTech(@RequestParam Map<String, String> map) {
        initRecordService.insertTech(map);
    }

    @PostMapping("/api/init/insert/bridge")
    public void insertBri(@RequestParam Map<String, String> map) {
        initRecordService.insertBri(map);
    }

}
