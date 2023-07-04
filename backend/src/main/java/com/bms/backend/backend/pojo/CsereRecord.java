package com.bms.backend.backend.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CsereRecord { // 养护处治记录
    private String bri_id; //桥梁编码
    private String cse_time; //时间段
    private String cse_type; //处治类别
    private String cse_rea; //处治原因
    private String cse_range; //处治范围
    private String cse_cost; //工程费用
    private String cse_mfrom; //经济来源
    private String cse_judge; //处治质量评定
}
