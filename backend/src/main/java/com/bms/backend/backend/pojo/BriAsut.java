package com.bms.backend.backend.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BriAsut { // 桥梁部件
    private String asun_id; // 部件编码
    private String bty_id; // 桥梁类型编号
    private String bri_id; // 桥梁编号
}
