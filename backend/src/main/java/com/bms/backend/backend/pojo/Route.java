package com.bms.backend.backend.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Route { // 路线
    private String route_id; //路线编号
    private String route_name; //路线名称
    private String route_grade; //路线等级
}
