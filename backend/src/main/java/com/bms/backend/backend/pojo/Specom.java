package com.bms.backend.backend.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Specom { // 桥梁具体部件
    private String asun_id; //部件编码
    private String bty_id; //桥梁类型编码
    private String bri_id; //桥梁编码
    private String spec_id; //桥梁部件编码
    private String spec_name; //桥梁部件名称
    private String spec_loc; //缺损位置
}
