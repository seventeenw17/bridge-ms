package com.bms.backend.backend;

import com.bms.backend.backend.mapper.BridgeMapper;
import com.bms.backend.backend.mapper.OthersMapper;
import com.bms.backend.backend.mapper.RouteMapper;
import com.bms.backend.backend.service.*;
import net.bytebuddy.utility.nullability.UnknownNull;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
public class BackendApplicationTests {
    @Autowired
    BridgeService bridgeService;
    @Autowired
    RouteService routeService;
    @Autowired
    InitRecordService initRecordService;
    @Autowired
    BridgeMapper bridgeMapper;
    @Autowired
    OthersMapper othersMapper;
    @Autowired
    RouteMapper routeMapper;
    @Autowired
    UnitsService unitsService;

    @Autowired
    AssunitService assunitService;

    @Autowired
    BasicCardService basicCardService;
    @Test
    void contextLoads() {
        Map<String,String> map = new HashMap<>();
<<<<<<< HEAD
        map.put("bri_id","1");
        System.out.println(basicCardService.getCsereByid(map));
=======
        map.put("bri_id","2");
        map.put("record_id","2");
        map.put("record_ulform","2");
        initRecordService.insertOne(map);
>>>>>>> 4fd449a17f30a7d2beb7067e8f66f73978e98476
    }
}
