package com.bms.backend.backend.service.impl;

import com.bms.backend.backend.mapper.BridgeMapper;
import com.bms.backend.backend.mapper.BridgeTypeMapper;
import com.bms.backend.backend.mapper.OthersMapper;
import com.bms.backend.backend.mapper.RouteMapper;
import com.bms.backend.backend.service.BridgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BridgeServiceimpl implements BridgeService {
    @Autowired
    BridgeMapper bridgeMapper;
    @Autowired
    OthersMapper othersMapper;

    @Autowired
    BridgeTypeMapper bridgeTypeMapper;

    @Autowired
    RouteMapper routeMapper;
    @Override
    public void insertOne(Map<String, String> map){
        bridgeMapper.insertOne(map);
        Integer n = othersMapper.getOthcnt() + 1;
        Map<String, String> map1 = new HashMap<>();
        String oth_id = n.toString();
        String bri_id = map.get("bri_id");
        String oth_totalimg = "https://img2.baidu.com/it/u=3303560252,3019908895&fm=253&fmt=auto&app=138&f=JPEG?w=640&h=480";
        map1.put("oth_id", oth_id);
        map1.put("bri_id", bri_id);
        map1.put("oth_totalimg", oth_totalimg);
        othersMapper.insertOne(map1);
    }
    @Override
    public List<Map<String,String>> getBri(){
        List<Map<String,String>> list = new ArrayList<>();
        List<String> ids = getAllbri();
        int n = getBricnt();
        System.out.println(n);
        for(int i = 0;i < n; i ++){
            Map<String,String> map = new HashMap<>();
            String briname = bridgeMapper.selectById(ids.get(i));
            String picurl = othersMapper.getPicUrl(ids.get(i));
            map.put("no",ids.get(i));
            map.put("name",briname);
            map.put("url",picurl);
            list.add(map);
        }
        return list;
    }

    @Override
    public List<String> getAllbri(){
        return bridgeMapper.getAllbri();
    }

    @Override
    public Integer getBricnt(){
        return bridgeMapper.getBricnt();
    }


    @Override
    public List<String> getAllbty(){
        return bridgeTypeMapper.getAllbty();
    }


    @Override
    public Integer getBtycnt(){
        return bridgeTypeMapper.getBtycnt();
    }

    @Override
    public List<Map<String,String>> getBty(){
        List<Map<String,String>> list = new ArrayList<>();
        List<String> ids = getAllbty();
        int n = getBtycnt();
        System.out.println(n);
        for(int i = 0;i < n; i ++){
            Map<String,String> map = new HashMap<>();
            String bty_name = bridgeTypeMapper.selectById(ids.get(i));
            map.put("bty_id",ids.get(i));
            map.put("bty_name",bty_name);
            list.add(map);
        }
        return list;
    }


    @Override
    public Map<String,String> getInfoBybri(String bri_id){
        Map<String,String> map = new HashMap<>();
        String route_id = bridgeMapper.getRouteBybri(bri_id);
        String route_name = routeMapper.getRouteByid(route_id);
        String bri_name = bridgeMapper.getNameByid(bri_id);
        map.put("route_id",route_id);
        map.put("route_name",route_name);
        map.put("bri_name",bri_name);
        return map;
    }


}
