package com.bms.backend.backend.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Assunit { // 部件
    private String asun_id; // 部件编号
    private String part_id; // 所在部位编号
    private String asun_name; // 部件名称
}
