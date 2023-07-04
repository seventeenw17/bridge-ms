package com.bms.backend.backend.service.impl;

import com.bms.backend.backend.mapper.UnitMapper;
import com.bms.backend.backend.mapper.UserMapper;
import com.bms.backend.backend.pojo.Units;
import com.bms.backend.backend.pojo.User;
import com.bms.backend.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UnitMapper unitMapper;

    @Override
    public Map<String, String> register(Map<String, String> map) {

        Map<String, String> resp = new HashMap<>();

        String units_id = map.get("units_id");
        String username = map.get("username");
        String password = map.get("password");
        System.out.println(units_id);
        System.out.println(username);
        System.out.println(password);
        try {
            userMapper.insertOne(new User(
                    units_id,
                    password,
                    username
            ));

        } catch (Exception e) {
            resp.put("error_info", "用户名重复");
            return resp;
        }

        resp.put("error_info", "success");

        return resp;
    }

    @Override
    public Map<String, String> login(Map<String, String> map) {

        Map<String, String> resp = new HashMap<>();

//        Integer account = Integer.valueOf(map.get("account"));
        String password = map.get("password");
        String username = map.get("username");
//        User user = userMapper.getUser(account);

        User user = userMapper.getUserByUsername(username);
        System.out.println(user);
        if (user == null) {
            resp.put("error_info", "账号不存在");
            System.out.println("1");
            return resp;
        }

        if (!user.getPassword().equals(password)) {
            resp.put("error_info", "密码错误");
            System.out.println("2");
            return resp;
        }

        Units units = unitMapper.getUnit(user.getUnits_id());
        resp.put("error_info", "success");
        resp.put("username", user.getUsername());
        resp.put("unit_no", units.getUnits_id());
        resp.put("unit_name", units.getUnits_name());

        return resp;
    }
}