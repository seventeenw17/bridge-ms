package com.bms.backend.backend.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BridgeRecord {
    private String bri_id;
    private String brcord_id;
    private String brcord_despaper;
    private String brcord_file;
    private String bricord_finpaper;
    private String bricord_buildfile;
    private String bricord_checkfile;
    private String bricord_reviewfile;
    private String bricord_refularfile;
    private String bricord_specialfile;
    private String bricord_fixfile;
    private String bricord_elsefile;
    private String bricord_fileform;
    private String bricord_filltime;
}
