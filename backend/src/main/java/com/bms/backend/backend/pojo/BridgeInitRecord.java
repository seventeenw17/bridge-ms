package com.bms.backend.backend.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BridgeInitRecord { // 桥梁初始检查记录
    private String bri_id; //桥梁编码
    private String record_id;
    private String record_ulform; //上下部结构形式
    private String record_group; //桥梁分联及跨径组合
    private String record_method; //桥梁施工方法
    private String record_precase; //新建桥梁在施工过程的返工维修或加固情况
    private String record_aftercase; //加固改造后的桥梁改造加固后的情况
    private String record_incocase; //档案资料不齐全的桥梁维护加固情况
    private String record_fintime; //交工时间
    private String record_firtime; //初始检查时间
    private String record_tem; //初始检查时的气候及环境温度
    private String record_height; //桥面高程
    private String record_gzx; //拱轴线
    private String record_zlxx; //主缆线形
    private String record_dtmheight; //墩台身锚碇高程
    private String record_dtmlean; //墩台身锚碇倾斜度
    private String record_levheight; //索塔水平变位高程
    private String record_hordis; //拱桥桥台悬索桥锚碇水平位移
    private String record_susbri; //悬索桥索夹螺栓紧固力
    private String record_wbas; //水中基础
    private String record_dgsl; //吊杆索力
    private String record_gjsize; //主要承重构件尺寸
    private String record_czqd; //材质强度
    private String record_bhcgd; //保护层高度
    private String record_hntmsd; //钢管混凝土管内混凝土密实度
    private String record_stares; //静载试验结果
    private String record_dynres; //动载试验结果
    private String record_notekeeper; //记录人
}
