package com.bms.backend.backend.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BriInsRecord { // 桥梁具体部件检查记录
    private String asun_id; //部件编码
    private String bty_id ; //桥梁类型编码
    private String bri_id; //桥梁编码
    private String spec_id; //桥梁部件编码
    private String rec_id; //检查明细编码
    private String rec_time; //检查时间
    private String rec_type; //缺损类型
    private String spec_loc; //缺损位置
    private String rec_range; //缺损范围
    private String rec_pic; //缺损照片
    private String rec_score; //评分
    private String rec_cl; //材料
    private String rec_form;  //形式
    private String rec_tips; //养护建议
    private String rec_goujian; //缺损最不利构件
    private String rec_spec; //特殊检查
}
