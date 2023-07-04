package com.bms.backend.backend.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BridgeCheckRecord { // 桥梁检测评定历史
    private String bri_id; //桥梁编码
    private String chrecord_settime; //设定时间
    private String chrecord_checktype; //检测类别
    private String chrecord_spchcln; //特殊检查结论
    private String chrecord_handleway; //处置对策
    private String chrecord_nechtime; //下次检测时间

}
