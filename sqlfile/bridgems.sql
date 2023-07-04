/*
 Navicat Premium Data Transfer

 Source Server         : c1
 Source Server Type    : MySQL
 Source Server Version : 80031
 Source Host           : localhost:3306
 Source Schema         : bridgetest

 Target Server Type    : MySQL
 Target Server Version : 80031
 File Encoding         : 65001

 Date: 03/07/2023 16:33:25
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for aidata
-- ----------------------------
DROP TABLE IF EXISTS `aidata`;
CREATE TABLE `aidata`  (
  `AIdata_funtype` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `AIdata_load` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `AIdata_slope` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `AIdata_radius` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `AIdata_fintime` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `AIdata_id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `bri_id` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`AIdata_id`) USING BTREE,
  INDEX `FK_Relationship_24`(`bri_id`) USING BTREE,
  CONSTRAINT `FK_Relationship_24` FOREIGN KEY (`bri_id`) REFERENCES `bridge` (`bri_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of aidata
-- ----------------------------
INSERT INTO `aidata` VALUES ('公铁两用', '1000', '10', '2', '2013-6-24', '1', '1');

-- ----------------------------
-- Table structure for assunit
-- ----------------------------
DROP TABLE IF EXISTS `assunit`;
CREATE TABLE `assunit`  (
  `asun_id` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `part_id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `asun_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`asun_id`) USING BTREE,
  INDEX `FK_Relationship_1`(`part_id`) USING BTREE,
  CONSTRAINT `FK_Relationship_1` FOREIGN KEY (`part_id`) REFERENCES `part` (`part_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of assunit
-- ----------------------------
INSERT INTO `assunit` VALUES ('1', '1', '1');
INSERT INTO `assunit` VALUES ('2', '2', '2');

-- ----------------------------
-- Table structure for bri_asut
-- ----------------------------
DROP TABLE IF EXISTS `bri_asut`;
CREATE TABLE `bri_asut`  (
  `asun_id` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `bty_id` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `bri_id` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`asun_id`, `bty_id`, `bri_id`) USING BTREE,
  INDEX `FK_Relationship_4`(`bri_id`) USING BTREE,
  CONSTRAINT `FK_Relationship_4` FOREIGN KEY (`bri_id`) REFERENCES `bridge` (`bri_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_Relationship_5` FOREIGN KEY (`asun_id`, `bty_id`) REFERENCES `config` (`asun_id`, `bty_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of bri_asut
-- ----------------------------

-- ----------------------------
-- Table structure for bridge
-- ----------------------------
DROP TABLE IF EXISTS `bridge`;
CREATE TABLE `bridge`  (
  `bri_id` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `bty_id` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `route_id` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `bri_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`bri_id`) USING BTREE,
  INDEX `FK_Relationship_16`(`route_id`) USING BTREE,
  INDEX `FK_Relationship_9`(`bty_id`) USING BTREE,
  CONSTRAINT `FK_Relationship_16` FOREIGN KEY (`route_id`) REFERENCES `route` (`route_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_Relationship_9` FOREIGN KEY (`bty_id`) REFERENCES `bridgetype` (`bty_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of bridge
-- ----------------------------
INSERT INTO `bridge` VALUES ('1', '1', '1', '重庆千厮门嘉陵江大桥');
INSERT INTO `bridge` VALUES ('2', '1', '2', '港珠澳大桥');
INSERT INTO `bridge` VALUES ('3', '1', '3', '铜陵长江公铁大桥');
INSERT INTO `bridge` VALUES ('4', '1', '4', '广东虎门大桥');
INSERT INTO `bridge` VALUES ('5', '1', '5', '杭州湾跨海大桥');
INSERT INTO `bridge` VALUES ('6', '1', '6', '安康东坝汉江大桥');
INSERT INTO `bridge` VALUES ('7', '1', '7', '天津永乐桥');
INSERT INTO `bridge` VALUES ('8', '1', '8', '北京卢沟桥');

-- ----------------------------
-- Table structure for bridgecheckrecord
-- ----------------------------
DROP TABLE IF EXISTS `bridgecheckrecord`;
CREATE TABLE `bridgecheckrecord`  (
  `bri_id` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `chrecord_settime` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `chrecord_checktype` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `chrecord_spchcln` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `chrecord_handleway` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `chrecord_nechtime` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`bri_id`, `chrecord_settime`) USING BTREE,
  CONSTRAINT `FK_Relationship_20` FOREIGN KEY (`bri_id`) REFERENCES `bridge` (`bri_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of bridgecheckrecord
-- ----------------------------
INSERT INTO `bridgecheckrecord` VALUES ('1', '2023-1-1', '普通检查', '需要养护', '近期安排养护', '2024-5-1');
INSERT INTO `bridgecheckrecord` VALUES ('1', '2023-5-1', '特殊检查', '正常', '无', '2024-6-1');

-- ----------------------------
-- Table structure for bridgeinitrecord
-- ----------------------------
DROP TABLE IF EXISTS `bridgeinitrecord`;
CREATE TABLE `bridgeinitrecord`  (
  `record_ulform` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `record_group` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `record_method` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `record_precase` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `record_aftercase` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `record_incocase` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `record_fintime` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `record_firtime` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `record_tem` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `record_height` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `record_gzx` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `record_zlxx` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `record_dtmheight` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `record_dtmlean` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `record_levheight` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `record_hordis` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `record_susbri` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `record_wbas` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `record_dgsl` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `record_gjsize` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `record_czqd` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `record_bhcgd` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `record_hntmsd` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `record_stares` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `record_dynres` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `record_notekeeper` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `record_id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `bri_id` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`record_id`) USING BTREE,
  INDEX `FK_Relationship_21`(`bri_id`) USING BTREE,
  CONSTRAINT `FK_Relationship_21` FOREIGN KEY (`bri_id`) REFERENCES `bridge` (`bri_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of bridgeinitrecord
-- ----------------------------
INSERT INTO `bridgeinitrecord` VALUES (NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '1', '1');
INSERT INTO `bridgeinitrecord` VALUES (NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '5', '5');

-- ----------------------------
-- Table structure for bridgerechrecord
-- ----------------------------
DROP TABLE IF EXISTS `bridgerechrecord`;
CREATE TABLE `bridgerechrecord`  (
  `bri_id` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `rech_nowtime` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `rech_latime` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `rech_tem` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `rech_grade` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `rech_clzk` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `rech_xfyhzk` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `rech_notekeeper` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `rech_prinpeo` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `rech_netime` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`bri_id`, `rech_nowtime`) USING BTREE,
  CONSTRAINT `FK_Relationship_22` FOREIGN KEY (`bri_id`) REFERENCES `bridge` (`bri_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of bridgerechrecord
-- ----------------------------

-- ----------------------------
-- Table structure for bridgerecord
-- ----------------------------
DROP TABLE IF EXISTS `bridgerecord`;
CREATE TABLE `bridgerecord`  (
  `brcord_id` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `bri_id` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `brcord_despaper` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `brcord_file` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `bricord_finpaper` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `bricord_buildfile` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `bricord_checkfile` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `bricord_reviewfile` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `bricord_refularfile` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `bricord_specialfile` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `bricord_fixfile` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `bricord_elsefile` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `bricord_fileform` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `bricord_filltime` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`brcord_id`) USING BTREE,
  INDEX `bridgerecord_bridge_bri_id_fk`(`bri_id`) USING BTREE,
  CONSTRAINT `bridgerecord_bridge_bri_id_fk` FOREIGN KEY (`bri_id`) REFERENCES `bridge` (`bri_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of bridgerecord
-- ----------------------------
INSERT INTO `bridgerecord` VALUES ('1', '1', '全', '全', '全', '全', '全', '全', '全', '全', '全', '无', '电子', '2014-11-8');

-- ----------------------------
-- Table structure for bridgetype
-- ----------------------------
DROP TABLE IF EXISTS `bridgetype`;
CREATE TABLE `bridgetype`  (
  `bty_id` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `bty_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`bty_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of bridgetype
-- ----------------------------
INSERT INTO `bridgetype` VALUES ('1', '悬索桥');
INSERT INTO `bridgetype` VALUES ('2', '拱桥');

-- ----------------------------
-- Table structure for briinsrecord
-- ----------------------------
DROP TABLE IF EXISTS `briinsrecord`;
CREATE TABLE `briinsrecord`  (
  `asun_id` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `bty_id` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `bri_id` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `spec_id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `rec_id` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `rec_time` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `rec_type` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `spec_loc` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `rec_range` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `rec_pic` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `rec_score` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `rec_cl` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `rec_form` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `rec_tips` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `rec_goujian` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `rec_spec` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`asun_id`, `bty_id`, `bri_id`, `spec_id`, `rec_id`) USING BTREE,
  CONSTRAINT `FK_Relationship_7` FOREIGN KEY (`asun_id`, `bty_id`, `bri_id`, `spec_id`) REFERENCES `specom` (`asun_id`, `bty_id`, `bri_id`, `spec_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of briinsrecord
-- ----------------------------

-- ----------------------------
-- Table structure for config
-- ----------------------------
DROP TABLE IF EXISTS `config`;
CREATE TABLE `config`  (
  `asun_id` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `bty_id` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `con_id` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`asun_id`, `bty_id`) USING BTREE,
  INDEX `FK_Relationship_3`(`bty_id`) USING BTREE,
  CONSTRAINT `FK_Relationship_2` FOREIGN KEY (`asun_id`) REFERENCES `assunit` (`asun_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_Relationship_3` FOREIGN KEY (`bty_id`) REFERENCES `bridgetype` (`bty_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of config
-- ----------------------------

-- ----------------------------
-- Table structure for cooperation
-- ----------------------------
DROP TABLE IF EXISTS `cooperation`;
CREATE TABLE `cooperation`  (
  `units_id` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `AIdata_id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `unit_duty` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`units_id`, `AIdata_id`) USING BTREE,
  INDEX `FK_Relationship_14`(`AIdata_id`) USING BTREE,
  CONSTRAINT `FK_Relationship_13` FOREIGN KEY (`units_id`) REFERENCES `units` (`units_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_Relationship_14` FOREIGN KEY (`AIdata_id`) REFERENCES `aidata` (`AIdata_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cooperation
-- ----------------------------
INSERT INTO `cooperation` VALUES ('中交路建', '1', '设计');
INSERT INTO `cooperation` VALUES ('中铁八局', '1', '施工');
INSERT INTO `cooperation` VALUES ('交通运输部', '1', '监理');
INSERT INTO `cooperation` VALUES ('西南交通专科学校', '1', '业主');
INSERT INTO `cooperation` VALUES ('重庆交通大学', '1', '管养');

-- ----------------------------
-- Table structure for cserecord
-- ----------------------------
DROP TABLE IF EXISTS `cserecord`;
CREATE TABLE `cserecord`  (
  `bri_id` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `cse_time` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `cse_type` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `cse_rea` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `cse_range` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `cse_cost` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `cse_mfrom` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `cse_judge` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`bri_id`, `cse_time`) USING BTREE,
  CONSTRAINT `FK_Relationship_19` FOREIGN KEY (`bri_id`) REFERENCES `bridge` (`bri_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cserecord
-- ----------------------------
INSERT INTO `cserecord` VALUES ('1', '2023-1-1~2023.1.20', '一般处治', '定期维护', '桥面', '30000', '重庆市政府', '良好');
INSERT INTO `cserecord` VALUES ('1', '2023-5-20~2023-6-20', '维修', '桥索磨损', '桥索', '20000', '交通运输部', '良好');

-- ----------------------------
-- Table structure for others
-- ----------------------------
DROP TABLE IF EXISTS `others`;
CREATE TABLE `others`  (
  `oth_totalimg` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `oth_engineer` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `oth_faceimg` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `oth_people` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `oth_date` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `oth_tips` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `oth_id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `bri_id` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`oth_id`) USING BTREE,
  INDEX `FK_Relationship_25`(`bri_id`) USING BTREE,
  CONSTRAINT `FK_Relationship_25` FOREIGN KEY (`bri_id`) REFERENCES `bridge` (`bri_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of others
-- ----------------------------
INSERT INTO `others` VALUES ('https://img2.baidu.com/it/u=385387975,2624851570&fm=253&fmt=auto&app=138&f=JPEG?w=755&h=500', '冉嵬', 'https://img1.qunarzz.com/travel/d7/1709/1b/188aa382c87ba9b5.jpg', '管理员', '2014-12-20', '无', '1', '1');
INSERT INTO `others` VALUES ('https://img2.baidu.com/it/u=1297520841,1721429313&fm=253&fmt=auto&app=120&f=JPEG?w=1422&h=800', NULL, NULL, NULL, NULL, NULL, '2', '2');
INSERT INTO `others` VALUES ('https://img1.baidu.com/it/u=2529700941,575811050&fm=253&fmt=auto&app=138&f=JPEG?w=905&h=500', NULL, NULL, NULL, NULL, NULL, '3', '3');
INSERT INTO `others` VALUES ('https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fci.xiaohongshu.com%2F47da711d-1780-9e1c-b539-aa44853e8bc5%3FimageView2%2F2%2Fw%2F1080%2Fformat%2Fjpg&refer=http%3A%2F%2Fci.xiaohongshu.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=auto?sec=1690117904&t=8d7ba7d40b3a7a0bb8326571c02a125b', NULL, NULL, NULL, NULL, NULL, '4', '4');
INSERT INTO `others` VALUES ('https://img1.baidu.com/it/u=787377333,2178243118&fm=253&fmt=auto&app=138&f=JPEG?w=667&h=500', NULL, NULL, NULL, NULL, NULL, '5', '5');
INSERT INTO `others` VALUES ('https://images.0915home.com/attachment/ue/20200812/6dd0824ba0979e7d0c7e3ceb22d4aec9e5e58211.jpeg?x-oss-process=style/w_800', NULL, NULL, NULL, NULL, NULL, '6', '6');
INSERT INTO `others` VALUES ('https://dimg01.c-ctrip.com/images/fd/tg/g6/M0A/F9/2E/CggYslcfIO2AJJAhAA-1wAztynw420.jpg', NULL, NULL, NULL, NULL, NULL, '7', '7');
INSERT INTO `others` VALUES ('https://img2.baidu.com/it/u=3400544180,3593512483&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=263', NULL, NULL, NULL, NULL, NULL, '8', '8');

-- ----------------------------
-- Table structure for part
-- ----------------------------
DROP TABLE IF EXISTS `part`;
CREATE TABLE `part`  (
  `part_id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `part_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`part_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of part
-- ----------------------------
INSERT INTO `part` VALUES ('1', '1');
INSERT INTO `part` VALUES ('2', '2');

-- ----------------------------
-- Table structure for route
-- ----------------------------
DROP TABLE IF EXISTS `route`;
CREATE TABLE `route`  (
  `route_id` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `route_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `route_grade` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`route_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of route
-- ----------------------------
INSERT INTO `route` VALUES ('1', 'zx', '1');
INSERT INTO `route` VALUES ('2', '2', '2');
INSERT INTO `route` VALUES ('3', '3', '3');
INSERT INTO `route` VALUES ('4', '4', '4');
INSERT INTO `route` VALUES ('5', '5', '5');
INSERT INTO `route` VALUES ('6', '6', '6');
INSERT INTO `route` VALUES ('7', '7', '7');
INSERT INTO `route` VALUES ('8', '8', '8');
INSERT INTO `route` VALUES ('9', '9', '9');

-- ----------------------------
-- Table structure for specom
-- ----------------------------
DROP TABLE IF EXISTS `specom`;
CREATE TABLE `specom`  (
  `asun_id` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `bty_id` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `bri_id` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `spec_id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `spec_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `spec_loc` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`asun_id`, `bty_id`, `bri_id`, `spec_id`) USING BTREE,
  CONSTRAINT `FK_Relationship_6` FOREIGN KEY (`asun_id`, `bty_id`, `bri_id`) REFERENCES `bri_asut` (`asun_id`, `bty_id`, `bri_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of specom
-- ----------------------------

-- ----------------------------
-- Table structure for techindex
-- ----------------------------
DROP TABLE IF EXISTS `techindex`;
CREATE TABLE `techindex`  (
  `tech_length` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `tech_width` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `tech_carwidth` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `tech_peowidth` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `tech_barheight` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `tech_divwidth` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `tech_staclear` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `tech_reaclear` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `tech_scleargrade` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `tech_dreaclear` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `tech_apwidth` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `tech_floodfrelev` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `tech_curradius` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `tech_floodlev` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `tech_eaqua` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `tech_elevation` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `tech_id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `bri_id` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`tech_id`) USING BTREE,
  INDEX `FK_Relationship_23`(`bri_id`) USING BTREE,
  CONSTRAINT `FK_Relationship_23` FOREIGN KEY (`bri_id`) REFERENCES `bridge` (`bri_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of techindex
-- ----------------------------
INSERT INTO `techindex` VALUES ('720', '36.9', '24', '12', '1.3', '0.9', '5', '4.5', '4.4', '4.2', '3.6', '20', '0.6', '16', '8.0', '15', '1', '1');

-- ----------------------------
-- Table structure for units
-- ----------------------------
DROP TABLE IF EXISTS `units`;
CREATE TABLE `units`  (
  `units_id` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `units_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`units_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of units
-- ----------------------------
INSERT INTO `units` VALUES ('1', '中国铁建');
INSERT INTO `units` VALUES ('中交路建', '中交路建');
INSERT INTO `units` VALUES ('中铁八局', '中铁八局');
INSERT INTO `units` VALUES ('交通运输部', '交通运输部');
INSERT INTO `units` VALUES ('西南交通专科学校', '西南交通专科学校');
INSERT INTO `units` VALUES ('重庆交通大学', '重庆交通大学');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `username` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `password` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `units_id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`username`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('admin', '123456', '1');
INSERT INTO `user` VALUES ('Allin', '123456', '1');
INSERT INTO `user` VALUES ('wj', '123456', '1');

SET FOREIGN_KEY_CHECKS = 1;
