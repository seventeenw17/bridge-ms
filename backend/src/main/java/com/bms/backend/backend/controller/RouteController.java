package com.bms.backend.backend.controller;

import com.bms.backend.backend.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class RouteController {
    @Autowired
    RouteService routeServicel;
    @PostMapping("/api/route/insertone")
    public void insertOne(@RequestParam Map<String, String> map) {
       routeServicel.insertOne(map);
    }
    @GetMapping("/api/route/getroute")
    public List<Map<String, String>> getALL() {
        return routeServicel.getALL();
    }
    @PostMapping("/api/route/delete")
    public void deleteRoute(@RequestParam String route_id) {
        routeServicel.deleteRoute(route_id);
    }
    @PostMapping("/api/route/update")
    public void updateRoute(@RequestParam Map<String,String> map) {
        routeServicel.updateRoute(map);
    }

}
