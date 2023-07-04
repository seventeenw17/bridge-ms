package com.bms.backend.backend.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Others { // 其它
    private String bri_id; //桥梁编码
    private String oth_id;
    private String oth_totalimg; //桥梁总体照片
    private String oth_engineer; //桥梁工程师
    private String oth_faceimg; //桥梁正面照片
    private String oth_people; //填卡人
    private String oth_date; //填卡日期
    private String oth_tips; //说明事项
}
