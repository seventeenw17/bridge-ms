package com.bms.backend.backend.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Aidata { // 行政识别数据
    private String bri_id; // 桥梁编号
    private String AIdata_id; // 桥梁编号
    private String AIdata_funtype; // 功能类型
    private String AIdata_load; // 设计载荷
    private String AIdata_slope; // 桥梁坡度
    private String AIdata_radius; // 桥梁曲率半径
    private String AIdata_fintime; // 建成时间
}
