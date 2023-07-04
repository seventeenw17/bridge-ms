package com.bms.backend.backend.controller;

import com.bms.backend.backend.service.PartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class PartController {
    @Autowired
    PartService partService;
    @PostMapping("/api/part/insertone")
    public void insertOne(@RequestParam Map<String, String> map) {
        partService.insertOne(map);
    }

    @GetMapping("/api/part/getall")
    public List<Map<String, String>> getALL() {
        return partService.getALL();
    }

    @PostMapping("/api/part/delete")
    public void deletePart(@RequestParam String part_id) {
        partService.deletePart(part_id);
    }

    @PostMapping("/api/part/update")
    public void updatePart(@RequestParam Map<String, String> map) {
        partService.updatePart(map);
    }

}
