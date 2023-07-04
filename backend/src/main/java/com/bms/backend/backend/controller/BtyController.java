package com.bms.backend.backend.controller;

import com.bms.backend.backend.service.BtyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class BtyController {
    @Autowired
    BtyService btyService;

    @PostMapping ("/api/bty/insertone")
    public void insertOne(@RequestParam Map<String, String> map) {
        btyService.insertOne(map);
    }

    @PostMapping("/api/bty/delete")
    public void deleteBty(@RequestParam String bty_id) {
        btyService.deleteBty(bty_id);
    }

    @GetMapping("/api/bty/getall")
    public List<Map<String, String>> getALL() {
        return btyService.getALL();
    }

    @PostMapping("/api/bty/update")
    public void updateBty(@RequestParam Map<String, String> map) {
        btyService.updateBty(map);
    }
}
