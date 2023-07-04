package com.bms.backend.backend.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bridge { // 桥
    private String bri_id; // 桥梁编号
    private String bty_id; // 桥梁类型编号
    private String bri_name; // 桥梁名
    private String route_id; //路线编号
}
