package com.bms.backend.backend.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BridgeRechRecord { // 桥梁定期检查记录
    private String bri_id; // 桥梁编号
    private String rech_nowtime; //本次检查时间
    private String rech_latime; //上次检查时间
    private String rech_tem; //本次检查气候
    private String rech_grade; //桥梁技术状况评级
    private String rech_clzk; //桥梁清洁状况
    private String rech_xfyhzk; //预防及修复养护状况
    private String rech_notekeeper; //记录人
    private String rech_prinpeo; //负责人
    private String rech_netime; //下次检查时间
}
