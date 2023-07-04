package com.bms.backend.backend.controller;

import com.bms.backend.backend.service.AssunitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class AssunitController {
    @Autowired
    AssunitService assunitService;
    @PostMapping("/api/assunit/insertone")
    public void insertOne(@RequestParam Map<String, String> map) {
        assunitService.insertOne(map);
    }

    @PostMapping("/api/assunit/delete")
    public void deleteAssunit(@RequestParam String asun_id) {
        assunitService.deleteAssunit(asun_id);
    }

    @GetMapping("/api/assunit/getall")
    public List<Map<String, String>> getALL() {
        return assunitService.getALL();
    }

    @PostMapping("/api/assunit/update")
    public void updateAssunit(@RequestParam Map<String, String> map) {
        assunitService.updateAssunit(map);
    }

}
