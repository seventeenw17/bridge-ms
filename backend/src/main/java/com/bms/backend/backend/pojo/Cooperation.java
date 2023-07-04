package com.bms.backend.backend.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cooperation { // 单位合作
    private String units_id; //单位编号
    private String bri_id; //桥梁编码
    private String unit_duty; //单位责任
}
