package com.bms.backend.backend.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Config { // 桥梁类型部件配置
    private String asun_id; //部件编码
    private String bty_id; //桥梁类型编码
    private String con_id; //显示序号
}
