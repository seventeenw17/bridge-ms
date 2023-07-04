package com.bms.backend.backend.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TechIndex { // 桥梁技术指标
    private String bri_id; //桥梁编码
    private String tech_id; //桥梁技术指标编码
    private String tech_length; //桥梁全长
    private String tech_width; //桥梁总宽
    private String tech_carwidth; //车道宽度
    private String tech_peowidth; //人行道宽度
    private String tech_barheight; //护栏或防护墙高度
    private String tech_divwidth; //中央分割带宽度
    private String tech_staclear; //桥面标准净空
    private String tech_reaclear; //桥面实际净空
    private String tech_scleargrade; //桥下通航等级及标准净空
    private String tech_dreaclear; //桥下实际净空
    private String tech_apwidth; //引道总宽
    private String tech_floodfrelev; //设计洪水频率及其水位
    private String tech_curradius; //引道线形或曲率半径
    private String tech_floodlev; //历史洪水位
    private String tech_eaqua; //地震峰值加速度系数
    private String tech_elevation; //桥面高程
}
