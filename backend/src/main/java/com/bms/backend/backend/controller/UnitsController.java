package com.bms.backend.backend.controller;

import com.bms.backend.backend.service.UnitsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UnitsController {
    @Autowired
    UnitsService unitsService;

    @PostMapping("/api/units/insertone")
    public void insertOne(@RequestParam Map<String, String> map) {
        unitsService.insertOne(map);
    }

    @PostMapping("api/units/delete")
    public void deleteUnits(@RequestParam String units_id) {
        unitsService.deleteUnit(units_id);
    }

    @GetMapping("/api/units/getall")
    public List<Map<String, String>> getALL() {
        return unitsService.getALL();
    }

    @PostMapping("/api/units/update")
    public void updateUnits(@RequestParam Map<String, String> map) {
        unitsService.updateUnit(map);
    }

}
