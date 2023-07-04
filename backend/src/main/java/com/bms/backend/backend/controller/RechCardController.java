package com.bms.backend.backend.controller;

import com.bms.backend.backend.service.RechCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class RechCardController {
    @Autowired
    RechCardService rechCardService;

    @GetMapping("/api/rech/get/bridge")
    public Map<String, String> getBri(@RequestParam Map<String, String> map) {
        return rechCardService.getBriByid(map);
    }

    @GetMapping("/api/rech/get/tech")
    public Map<String, String> getTech(@RequestParam Map<String, String> map) {
        return rechCardService.getTechByid(map); }

    @GetMapping("/api/rech/get/rech")
    public Map<String, String> getRech(@RequestParam Map<String, String> map) {
        return rechCardService.getRech(map);
    }

    @GetMapping("/api/rech/get/route")
    public Map<String, String> getRoute(@RequestParam Map<String, String> map) {
        return rechCardService.getRoute(map);
    }

    @GetMapping("/api/rech/get/Co")
    public List<Map<String, String>> getCoByid(@RequestParam Map<String, String> map) {
        return rechCardService.getCoByid(map);
    }

    @PostMapping("/api/rech/insert/tech")
    public void insertTech(@RequestParam Map<String, String> map) {
        rechCardService.insertTech(map);
    }

    @PostMapping("/api/rech/insert/rech")
    public void insertRech(@RequestParam Map<String, String> map) {
        rechCardService.insertRech(map);
    }

    @PostMapping("/api/rech/insert/route")
    public void insertRoute(@RequestParam Map<String, String> map) {
        rechCardService.insertRoute(map);
    }

    @PostMapping("/api/rech/insert/co")
    public void insertCo(@RequestParam Map<String, String> map) {
        rechCardService.insertCo(map);
    }

}
