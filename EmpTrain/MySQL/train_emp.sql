/*
Navicat MySQL Data Transfer

Source Server         : Sui
Source Server Version : 50624
Source Host           : localhost:3306
Source Database       : train_emp

Target Server Type    : MYSQL
Target Server Version : 50624
File Encoding         : 65001

Date: 2015-12-29 23:26:30
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `attendance_time`
-- ----------------------------
DROP TABLE IF EXISTS `attendance_time`;
CREATE TABLE `attendance_time` (
  `ATTENDANCE_TIME_ID` varchar(50) NOT NULL,
  `TITLE` varchar(50) DEFAULT NULL,
  `START_TIME` time DEFAULT NULL,
  `END_TIME` time DEFAULT NULL,
  `REMARK` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ATTENDANCE_TIME_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of attendance_time
-- ----------------------------

-- ----------------------------
-- Table structure for `dic_system_dictionary`
-- ----------------------------
DROP TABLE IF EXISTS `dic_system_dictionary`;
CREATE TABLE `dic_system_dictionary` (
  `DICTIONARY_OPTION_ID` varchar(40) NOT NULL,
  `DICTIONARY_OPTION_NAME` varchar(50) DEFAULT NULL,
  `UP_DICTIONARY_OPTION_ID` varchar(30) DEFAULT NULL,
  `IS_USE` int(11) DEFAULT NULL,
  `DESCRIPTIONS` varchar(200) DEFAULT NULL,
  `SORT_NO` int(11) DEFAULT NULL,
  `FLAG` int(11) DEFAULT NULL,
  `ENGLISH_NAME` varchar(100) DEFAULT NULL,
  `DATA_TYPE` varchar(100) DEFAULT NULL,
  `REMARK1` varchar(20) DEFAULT NULL,
  `REMARK2` varchar(20) DEFAULT NULL,
  `MATCH_DIC_ID` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`DICTIONARY_OPTION_ID`),
  KEY `FK_DICTIONARY_OPTION_ID1` (`UP_DICTIONARY_OPTION_ID`),
  CONSTRAINT `FK_DICTIONARY_OPTION_ID1` FOREIGN KEY (`UP_DICTIONARY_OPTION_ID`) REFERENCES `dic_system_dictionary` (`DICTIONARY_OPTION_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dic_system_dictionary
-- ----------------------------

-- ----------------------------
-- Table structure for `emp_attendance`
-- ----------------------------
DROP TABLE IF EXISTS `emp_attendance`;
CREATE TABLE `emp_attendance` (
  `EMP_ATTENDANCE_ID` varchar(50) NOT NULL,
  `EMP_ID` varchar(50) DEFAULT NULL,
  `RECORD_DATE` date DEFAULT NULL,
  `CLASS_START_TIME` time DEFAULT NULL,
  `CLASS_END_TIME` time DEFAULT NULL,
  `ATTENDANCE_RESULT` varchar(2) DEFAULT NULL,
  `REMARK` varchar(50) DEFAULT NULL,
  `REMARK1` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`EMP_ATTENDANCE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of emp_attendance
-- ----------------------------

-- ----------------------------
-- Table structure for `train_emp`
-- ----------------------------
DROP TABLE IF EXISTS `train_emp`;
CREATE TABLE `train_emp` (
  `TRAIN_EMP_ID` varchar(50) NOT NULL,
  `TRAIN_ITEM_ID` varchar(50) DEFAULT NULL,
  `TRAIN_PLAN_ID` varchar(50) DEFAULT NULL,
  `EMP_ID` varchar(50) DEFAULT NULL,
  `CREATE_TIME` datetime DEFAULT NULL,
  `REMARK` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`TRAIN_EMP_ID`),
  KEY `FK_Reference_21` (`TRAIN_ITEM_ID`),
  KEY `FK_Reference_22` (`TRAIN_PLAN_ID`),
  CONSTRAINT `FK_Reference_21` FOREIGN KEY (`TRAIN_ITEM_ID`) REFERENCES `train_plan_item` (`TRAIN_ITEM_ID`),
  CONSTRAINT `FK_Reference_22` FOREIGN KEY (`TRAIN_PLAN_ID`) REFERENCES `train_plan_info` (`TRAIN_PLAN_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of train_emp
-- ----------------------------
INSERT INTO `train_emp` VALUES ('08565b3b-aab0-41c9-9d75-2672a4194606', '432eb98b-2fba-4911-9397-0980e8f9dde0', 'bc045d57-1944-43fc-99e6-5fae7c0be753', '1884c208-4bd0-4bfd-84e0-97b1484f9680', '2015-12-27 00:00:00', null);
INSERT INTO `train_emp` VALUES ('122907ee-b50d-4e9d-b1ca-f3eb4e552579', '9e0d652c-e08b-4f59-a668-6ad1dfb9d7c1', '92f597f4-c8b5-46d5-8c72-158b6372fa12', 'b2ceda4f-6d74-459b-a1e9-05806958d681', '2015-12-27 00:00:00', null);
INSERT INTO `train_emp` VALUES ('18018627-a18c-4833-9cbc-8c660c965ef5', '3ed5184a-47a1-4dd3-9434-3fe9c54ab520', 'd3c7709c-436e-4303-91c3-99ddccaf7a7b', 'b43c9cee-cc87-4c33-8be9-e0567eaf8147', '2015-12-28 00:00:00', null);
INSERT INTO `train_emp` VALUES ('2023e535-8870-4a7d-953e-2f26b1d734b8', '9e0d652c-e08b-4f59-a668-6ad1dfb9d7c1', '92f597f4-c8b5-46d5-8c72-158b6372fa12', '8307693c-ca70-45d6-8c3c-faec71745da1', '2015-12-27 00:00:00', null);
INSERT INTO `train_emp` VALUES ('269159a8-0065-4cb6-a5ab-a2183d5d6335', '8d3ec9a1-93ef-4581-815d-87bd775b4ffb', 'a56371b9-93bd-4112-87ab-97775047408d', '2a577533-67b3-448c-b15e-416f8a8a0bbc', '2015-12-28 00:00:00', null);
INSERT INTO `train_emp` VALUES ('28494139-e236-47b5-9f3c-5b20ce0ee5dc', '88f3ab0f-0d44-4395-9078-ec8d701f2a71', '06c04ee5-86ad-4b86-9060-e383fba8a617', '6c03d392-18a7-443b-97d8-aee7824bb263', '2015-12-29 00:00:00', null);
INSERT INTO `train_emp` VALUES ('2b3fba1b-5ade-4abc-960f-515e6079632c', 'b9768ec2-8fb4-44d0-9d51-0e558b883dd2', 'dd34c57a-1e17-481b-b351-8bb7760fb53d', '58916bba-ca85-405e-a6c6-c052b2bbb866', '2015-12-28 00:00:00', null);
INSERT INTO `train_emp` VALUES ('2f583b80-3906-4ed6-8748-6eeea1758f16', '9e0d652c-e08b-4f59-a668-6ad1dfb9d7c1', '92f597f4-c8b5-46d5-8c72-158b6372fa12', '1bd7c4a0-7fb5-44b8-90f6-7d0a5516db21', '2015-12-27 00:00:00', null);
INSERT INTO `train_emp` VALUES ('369fb5b2-ceaa-4518-adf5-6b312f43783d', '441520a1-0c83-4b78-a94b-81af7478965f', '8aa3b106-9d2a-4659-bd6f-bbd3bc7fa960', 'ac2728ae-a880-481e-9721-9f7d1cfab9c6', '2015-12-28 00:00:00', null);
INSERT INTO `train_emp` VALUES ('3788e88d-3318-4ca5-a43c-a07d3e9f4353', '0e3a60dc-0818-48cb-8dc6-463bcdb2fc2a', '1c1d87a5-8eef-42fe-9577-569a9a887dcc', '5db7533a-364a-4dfd-8fa8-81adbb9a8b72', '2015-12-27 00:00:00', null);
INSERT INTO `train_emp` VALUES ('38c15378-2438-47a9-b27c-873a87039381', '09547566-d988-4c54-ba0c-87c836464afa', 'a0e5f1b6-1760-41c1-9f53-7ad500c1b7d7', 'ac2728ae-a880-481e-9721-9f7d1cfab9c6', '2015-12-27 00:00:00', null);
INSERT INTO `train_emp` VALUES ('3f14733c-18eb-41e1-bba9-429828142fea', 'c69e7ae8-5a01-4513-9a7f-4274dd84f43d', 'c4d63067-6fe4-4787-b6e3-2ceedaf39243', '1884c208-4bd0-4bfd-84e0-97b1484f9680', '2015-12-29 00:00:00', null);
INSERT INTO `train_emp` VALUES ('4309df52-ab14-4445-b5d1-03cd841259cb', '2b8824a3-c815-4f29-9efd-9a94f8924aba', '0c5c407d-270e-401a-8a67-dafceab77639', '09600968-decf-4c0a-8a05-dde9ff97ba20', '2015-12-28 00:00:00', null);
INSERT INTO `train_emp` VALUES ('4aef1e7c-3a6b-43ba-8d2a-45b09f16e190', '2b8824a3-c815-4f29-9efd-9a94f8924aba', '0c5c407d-270e-401a-8a67-dafceab77639', '2fd0d2b8-4ac9-4d27-8200-1c82cb2f2ed2', '2015-12-28 00:00:00', null);
INSERT INTO `train_emp` VALUES ('4b835aff-6867-4ec9-9a8f-9f82d5a73a86', '432eb98b-2fba-4911-9397-0980e8f9dde0', 'bc045d57-1944-43fc-99e6-5fae7c0be753', 'b2ceda4f-6d74-459b-a1e9-05806958d681', '2015-12-27 00:00:00', null);
INSERT INTO `train_emp` VALUES ('5239e99b-ec9e-485a-9509-709979fcf382', '441520a1-0c83-4b78-a94b-81af7478965f', '8aa3b106-9d2a-4659-bd6f-bbd3bc7fa960', 'cf89aceb-010a-4478-8df9-5caa1abc800a', '2015-12-28 00:00:00', null);
INSERT INTO `train_emp` VALUES ('53b36dfc-0089-4d4b-8cb7-ee30d9a50ee4', '0e3a60dc-0818-48cb-8dc6-463bcdb2fc2a', '1c1d87a5-8eef-42fe-9577-569a9a887dcc', 'd9791b6a-686d-4e04-a0a4-090728e04420', '2015-12-27 00:00:00', null);
INSERT INTO `train_emp` VALUES ('551f5cd2-d777-47e9-8b76-4d01c53c97ec', '60328d31-b6b5-4658-aede-2338045fdf08', 'e7402e4b-8a82-48e6-9d68-017f277a69fe', '1884c208-4bd0-4bfd-84e0-97b1484f9680', '2015-12-28 00:00:00', null);
INSERT INTO `train_emp` VALUES ('56e2abc6-b148-4b7f-af50-87e261f88142', '0e3a60dc-0818-48cb-8dc6-463bcdb2fc2a', '1c1d87a5-8eef-42fe-9577-569a9a887dcc', '7a29b9ab-0a56-449b-a4e6-3cbdac83736d', '2015-12-27 00:00:00', null);
INSERT INTO `train_emp` VALUES ('599ab77a-0b7b-49f1-9c07-f0b904ed150e', '432eb98b-2fba-4911-9397-0980e8f9dde0', 'bc045d57-1944-43fc-99e6-5fae7c0be753', '7a29b9ab-0a56-449b-a4e6-3cbdac83736d', '2015-12-27 00:00:00', null);
INSERT INTO `train_emp` VALUES ('5dcb9a71-d28a-4999-969f-02b6ab09511a', 'b9768ec2-8fb4-44d0-9d51-0e558b883dd2', 'dd34c57a-1e17-481b-b351-8bb7760fb53d', 'b2ceda4f-6d74-459b-a1e9-05806958d681', '2015-12-28 00:00:00', null);
INSERT INTO `train_emp` VALUES ('5df32a3f-5a07-4d66-b5b4-7d46b48374a1', '0e3a60dc-0818-48cb-8dc6-463bcdb2fc2a', '1c1d87a5-8eef-42fe-9577-569a9a887dcc', 'b2ceda4f-6d74-459b-a1e9-05806958d681', '2015-12-27 00:00:00', null);
INSERT INTO `train_emp` VALUES ('5f502a16-69a9-4506-9080-cc42bcb63560', '8d3ec9a1-93ef-4581-815d-87bd775b4ffb', 'a56371b9-93bd-4112-87ab-97775047408d', 'ac2728ae-a880-481e-9721-9f7d1cfab9c6', '2015-12-28 00:00:00', null);
INSERT INTO `train_emp` VALUES ('5f9dd2e2-cc77-4177-8498-12ed5757e9cd', '9e0d652c-e08b-4f59-a668-6ad1dfb9d7c1', '92f597f4-c8b5-46d5-8c72-158b6372fa12', 'b43c9cee-cc87-4c33-8be9-e0567eaf8147', '2015-12-27 00:00:00', null);
INSERT INTO `train_emp` VALUES ('5ffa071b-4ebd-4300-8386-526458211529', '60328d31-b6b5-4658-aede-2338045fdf08', 'e7402e4b-8a82-48e6-9d68-017f277a69fe', 'b685597d-3035-4b75-8ba0-777bd0953da8', '2015-12-28 00:00:00', null);
INSERT INTO `train_emp` VALUES ('601fb833-f88d-4984-a083-9d717a18a863', '8d3ec9a1-93ef-4581-815d-87bd775b4ffb', 'a56371b9-93bd-4112-87ab-97775047408d', '39322861-417d-40b8-9ece-076c120fd2e3', '2015-12-28 00:00:00', null);
INSERT INTO `train_emp` VALUES ('6316a7e6-2e22-4e36-9c92-bfcbf4c58051', '2b8824a3-c815-4f29-9efd-9a94f8924aba', '0c5c407d-270e-401a-8a67-dafceab77639', 'ca81fa5e-e811-4a50-bfed-e317bbae7494', '2015-12-28 00:00:00', null);
INSERT INTO `train_emp` VALUES ('6378be8e-fed9-4b57-82eb-c8b339231987', 'b9768ec2-8fb4-44d0-9d51-0e558b883dd2', 'dd34c57a-1e17-481b-b351-8bb7760fb53d', '7a29b9ab-0a56-449b-a4e6-3cbdac83736d', '2015-12-28 00:00:00', null);
INSERT INTO `train_emp` VALUES ('656ce5f0-c052-40ba-a9fd-1361e213752d', '8d3ec9a1-93ef-4581-815d-87bd775b4ffb', 'a56371b9-93bd-4112-87ab-97775047408d', 'ca81fa5e-e811-4a50-bfed-e317bbae7494', '2015-12-28 00:00:00', null);
INSERT INTO `train_emp` VALUES ('66a73c4c-319c-42a2-9b34-a47d68b98a1b', '3ed5184a-47a1-4dd3-9434-3fe9c54ab520', 'd3c7709c-436e-4303-91c3-99ddccaf7a7b', '1884c208-4bd0-4bfd-84e0-97b1484f9680', '2015-12-28 00:00:00', null);
INSERT INTO `train_emp` VALUES ('67bc8341-0b00-442f-8251-dc97cf1b1d75', '8d3ec9a1-93ef-4581-815d-87bd775b4ffb', 'a56371b9-93bd-4112-87ab-97775047408d', '9d2a2d9f-d8e0-4ab6-9ecc-0fd9a9e8dd39', '2015-12-28 00:00:00', null);
INSERT INTO `train_emp` VALUES ('6a77057d-81e7-4f80-b11d-cb171d1321db', '0e3a60dc-0818-48cb-8dc6-463bcdb2fc2a', '1c1d87a5-8eef-42fe-9577-569a9a887dcc', '1bd7c4a0-7fb5-44b8-90f6-7d0a5516db21', '2015-12-27 00:00:00', null);
INSERT INTO `train_emp` VALUES ('791816dc-6c6e-4ead-9c41-d19ed4872871', '8d3ec9a1-93ef-4581-815d-87bd775b4ffb', 'a56371b9-93bd-4112-87ab-97775047408d', '1bd7c4a0-7fb5-44b8-90f6-7d0a5516db21', '2015-12-28 00:00:00', null);
INSERT INTO `train_emp` VALUES ('7a7dd988-3790-47cb-97cb-944dffd0bc45', '88f3ab0f-0d44-4395-9078-ec8d701f2a71', '06c04ee5-86ad-4b86-9060-e383fba8a617', '1884c208-4bd0-4bfd-84e0-97b1484f9680', '2015-12-27 00:00:00', null);
INSERT INTO `train_emp` VALUES ('7d0496dd-099d-42b5-93b0-494ba0c31045', '09547566-d988-4c54-ba0c-87c836464afa', 'a0e5f1b6-1760-41c1-9f53-7ad500c1b7d7', '1884c208-4bd0-4bfd-84e0-97b1484f9680', '2015-12-27 00:00:00', null);
INSERT INTO `train_emp` VALUES ('7d645939-a543-44a1-ae9f-931c9183dc2e', 'b9768ec2-8fb4-44d0-9d51-0e558b883dd2', 'dd34c57a-1e17-481b-b351-8bb7760fb53d', '1bd7c4a0-7fb5-44b8-90f6-7d0a5516db21', '2015-12-28 00:00:00', null);
INSERT INTO `train_emp` VALUES ('7e46d90d-3ad8-471f-b409-13752f4ccd90', 'c69e7ae8-5a01-4513-9a7f-4274dd84f43d', 'c4d63067-6fe4-4787-b6e3-2ceedaf39243', 'b43c9cee-cc87-4c33-8be9-e0567eaf8147', '2015-12-29 00:00:00', null);
INSERT INTO `train_emp` VALUES ('84fc4626-4479-4e18-9e77-2c5384c65a43', 'c69e7ae8-5a01-4513-9a7f-4274dd84f43d', 'c4d63067-6fe4-4787-b6e3-2ceedaf39243', '5ac9406f-e0a0-49c9-926f-bea59d80354a', '2015-12-29 00:00:00', null);
INSERT INTO `train_emp` VALUES ('864f1980-b94d-4d33-8690-03ac698c0318', '09547566-d988-4c54-ba0c-87c836464afa', 'a0e5f1b6-1760-41c1-9f53-7ad500c1b7d7', '02e3f516-7b63-4907-b4f1-d4e6aa7cac9a', '2015-12-27 00:00:00', null);
INSERT INTO `train_emp` VALUES ('87153fa6-6b2c-4eef-b919-adf9713b5c38', '432eb98b-2fba-4911-9397-0980e8f9dde0', 'bc045d57-1944-43fc-99e6-5fae7c0be753', '5db7533a-364a-4dfd-8fa8-81adbb9a8b72', '2015-12-27 00:00:00', null);
INSERT INTO `train_emp` VALUES ('87647bae-a93a-427b-9d7e-4a9d126a4ade', '9e0d652c-e08b-4f59-a668-6ad1dfb9d7c1', '92f597f4-c8b5-46d5-8c72-158b6372fa12', 'ac2728ae-a880-481e-9721-9f7d1cfab9c6', '2015-12-27 00:00:00', null);
INSERT INTO `train_emp` VALUES ('87cedf0f-18a6-42b5-a680-1987eb3d13c8', '0e3a60dc-0818-48cb-8dc6-463bcdb2fc2a', '1c1d87a5-8eef-42fe-9577-569a9a887dcc', 'b43c9cee-cc87-4c33-8be9-e0567eaf8147', '2015-12-27 00:00:00', null);
INSERT INTO `train_emp` VALUES ('8f819cae-4419-4d0f-a15f-1f7a121e64ec', '2b8824a3-c815-4f29-9efd-9a94f8924aba', '0c5c407d-270e-401a-8a67-dafceab77639', '4737bb40-644c-4d8d-a1d3-169a15f9bd4f', '2015-12-28 00:00:00', null);
INSERT INTO `train_emp` VALUES ('93ed8f9b-6b64-402f-ad9e-12a5399c9aa8', '3ed5184a-47a1-4dd3-9434-3fe9c54ab520', 'd3c7709c-436e-4303-91c3-99ddccaf7a7b', '5db7533a-364a-4dfd-8fa8-81adbb9a8b72', '2015-12-28 00:00:00', null);
INSERT INTO `train_emp` VALUES ('95b1fa0f-824d-4cfc-b555-a5e12d60f602', '9e0d652c-e08b-4f59-a668-6ad1dfb9d7c1', '92f597f4-c8b5-46d5-8c72-158b6372fa12', '1884c208-4bd0-4bfd-84e0-97b1484f9680', '2015-12-27 00:00:00', null);
INSERT INTO `train_emp` VALUES ('95c40769-e942-4392-8ed7-b5512ee7918c', '2b8824a3-c815-4f29-9efd-9a94f8924aba', '0c5c407d-270e-401a-8a67-dafceab77639', 'ac2728ae-a880-481e-9721-9f7d1cfab9c6', '2015-12-28 00:00:00', null);
INSERT INTO `train_emp` VALUES ('99a524b5-ed3f-4772-869c-e1560bbb0420', '0e3a60dc-0818-48cb-8dc6-463bcdb2fc2a', '1c1d87a5-8eef-42fe-9577-569a9a887dcc', '0f2ceffb-794a-4569-900f-cc1afe8bd7bb', '2015-12-28 00:00:00', null);
INSERT INTO `train_emp` VALUES ('9ef3aa5f-07fe-433c-b82d-947339a3b234', 'c69e7ae8-5a01-4513-9a7f-4274dd84f43d', 'c4d63067-6fe4-4787-b6e3-2ceedaf39243', 'b2ceda4f-6d74-459b-a1e9-05806958d681', '2015-12-29 00:00:00', null);
INSERT INTO `train_emp` VALUES ('9f4656ec-435c-453d-903f-edfebadb044e', 'c69e7ae8-5a01-4513-9a7f-4274dd84f43d', 'c4d63067-6fe4-4787-b6e3-2ceedaf39243', '7a29b9ab-0a56-449b-a4e6-3cbdac83736d', '2015-12-29 00:00:00', null);
INSERT INTO `train_emp` VALUES ('a1da2d13-9181-4afe-9aa1-f1c2c9f82c0a', '8d3ec9a1-93ef-4581-815d-87bd775b4ffb', 'a56371b9-93bd-4112-87ab-97775047408d', '4b8c4370-6e41-47e8-bc2f-f45b6a38abe9', '2015-12-28 00:00:00', null);
INSERT INTO `train_emp` VALUES ('a326b915-3f75-4973-af81-1f1e828d1449', '09547566-d988-4c54-ba0c-87c836464afa', 'a0e5f1b6-1760-41c1-9f53-7ad500c1b7d7', 'b43c9cee-cc87-4c33-8be9-e0567eaf8147', '2015-12-27 00:00:00', null);
INSERT INTO `train_emp` VALUES ('a381e1d8-4797-4a65-8ce5-17cbc644b863', '441520a1-0c83-4b78-a94b-81af7478965f', '8aa3b106-9d2a-4659-bd6f-bbd3bc7fa960', '1884c208-4bd0-4bfd-84e0-97b1484f9680', '2015-12-28 00:00:00', null);
INSERT INTO `train_emp` VALUES ('a3a97e8a-cdde-4b69-9f07-93cf6fcdba51', '2b8824a3-c815-4f29-9efd-9a94f8924aba', '0c5c407d-270e-401a-8a67-dafceab77639', '4db75bde-8e5f-45ef-b2db-b1d47b4d36f5', '2015-12-28 00:00:00', null);
INSERT INTO `train_emp` VALUES ('aaefdfc0-2264-4536-9316-b617ab646549', 'c69e7ae8-5a01-4513-9a7f-4274dd84f43d', 'c4d63067-6fe4-4787-b6e3-2ceedaf39243', '5db7533a-364a-4dfd-8fa8-81adbb9a8b72', '2015-12-29 00:00:00', null);
INSERT INTO `train_emp` VALUES ('aece4dcb-5f48-4cf4-8217-f172baa7d2f2', '88f3ab0f-0d44-4395-9078-ec8d701f2a71', '06c04ee5-86ad-4b86-9060-e383fba8a617', '31014b61-82d2-4da1-aeca-b897d2888073', '2015-12-29 00:00:00', null);
INSERT INTO `train_emp` VALUES ('b06aac09-c1a5-4ac8-a00f-652dc37b40f6', '88f3ab0f-0d44-4395-9078-ec8d701f2a71', '06c04ee5-86ad-4b86-9060-e383fba8a617', '0f2ceffb-794a-4569-900f-cc1afe8bd7bb', '2015-12-29 00:00:00', null);
INSERT INTO `train_emp` VALUES ('b3cd5e4d-d682-42d5-a526-58514c2e8a5c', '2b8824a3-c815-4f29-9efd-9a94f8924aba', '0c5c407d-270e-401a-8a67-dafceab77639', '4b8c4370-6e41-47e8-bc2f-f45b6a38abe9', '2015-12-28 00:00:00', null);
INSERT INTO `train_emp` VALUES ('b8c3ef47-7400-4d55-bdbb-8433883089fb', '8c682da6-e300-440e-87ea-650fa075ba3f', '32fdcc77-048a-4c5f-9ed8-74cdf5c0b444', '1884c208-4bd0-4bfd-84e0-97b1484f9680', '2015-12-27 00:00:00', null);
INSERT INTO `train_emp` VALUES ('b8db6c8e-05ba-4776-ac14-25dbdf88bee6', '9e0d652c-e08b-4f59-a668-6ad1dfb9d7c1', '92f597f4-c8b5-46d5-8c72-158b6372fa12', '5db7533a-364a-4dfd-8fa8-81adbb9a8b72', '2015-12-27 00:00:00', null);
INSERT INTO `train_emp` VALUES ('bda68bea-eb01-45f4-9268-650fed3d1def', '8c682da6-e300-440e-87ea-650fa075ba3f', '32fdcc77-048a-4c5f-9ed8-74cdf5c0b444', '7a29b9ab-0a56-449b-a4e6-3cbdac83736d', '2015-12-27 00:00:00', null);
INSERT INTO `train_emp` VALUES ('be002152-668c-43a2-95a4-0858d844fb36', '8d3ec9a1-93ef-4581-815d-87bd775b4ffb', 'a56371b9-93bd-4112-87ab-97775047408d', '4db75bde-8e5f-45ef-b2db-b1d47b4d36f5', '2015-12-28 00:00:00', null);
INSERT INTO `train_emp` VALUES ('c02cc9fc-473b-4808-bb7e-78532fde9106', '88f3ab0f-0d44-4395-9078-ec8d701f2a71', '06c04ee5-86ad-4b86-9060-e383fba8a617', '8307693c-ca70-45d6-8c3c-faec71745da1', '2015-12-29 00:00:00', null);
INSERT INTO `train_emp` VALUES ('cc3b7abd-0f2b-44ae-8ba8-c102e37c9860', '432eb98b-2fba-4911-9397-0980e8f9dde0', 'bc045d57-1944-43fc-99e6-5fae7c0be753', 'b43c9cee-cc87-4c33-8be9-e0567eaf8147', '2015-12-27 00:00:00', null);
INSERT INTO `train_emp` VALUES ('d2f8df70-7ca4-440d-b1e2-71c003e21397', '8d3ec9a1-93ef-4581-815d-87bd775b4ffb', 'a56371b9-93bd-4112-87ab-97775047408d', '1b75bb29-afa1-470c-8f5e-c10c8fbb15d3', '2015-12-28 00:00:00', null);
INSERT INTO `train_emp` VALUES ('d51e1c1e-76f6-4fb0-8a00-f8090a349daf', '8c682da6-e300-440e-87ea-650fa075ba3f', '32fdcc77-048a-4c5f-9ed8-74cdf5c0b444', 'cf89aceb-010a-4478-8df9-5caa1abc800a', '2015-12-27 00:00:00', null);
INSERT INTO `train_emp` VALUES ('d714e506-532b-4367-b0fd-982d47dc70fe', '8c682da6-e300-440e-87ea-650fa075ba3f', '32fdcc77-048a-4c5f-9ed8-74cdf5c0b444', '5db7533a-364a-4dfd-8fa8-81adbb9a8b72', '2015-12-27 00:00:00', null);
INSERT INTO `train_emp` VALUES ('d8e03d3f-3d52-4526-9642-17dea3d44eb3', '9e0d652c-e08b-4f59-a668-6ad1dfb9d7c1', '92f597f4-c8b5-46d5-8c72-158b6372fa12', '508e5477-9ec0-4984-bfea-7631f43b7042', '2015-12-27 00:00:00', null);
INSERT INTO `train_emp` VALUES ('df6f2e2c-909a-401b-8262-fd5b485dd07a', '441520a1-0c83-4b78-a94b-81af7478965f', '8aa3b106-9d2a-4659-bd6f-bbd3bc7fa960', '58916bba-ca85-405e-a6c6-c052b2bbb866', '2015-12-28 00:00:00', null);
INSERT INTO `train_emp` VALUES ('e23016fa-a07e-45c7-adc0-59de5a524a41', '441520a1-0c83-4b78-a94b-81af7478965f', '8aa3b106-9d2a-4659-bd6f-bbd3bc7fa960', '7a29b9ab-0a56-449b-a4e6-3cbdac83736d', '2015-12-28 00:00:00', null);
INSERT INTO `train_emp` VALUES ('e5fd8da5-334d-476c-8d85-eac639e06632', '88f3ab0f-0d44-4395-9078-ec8d701f2a71', '06c04ee5-86ad-4b86-9060-e383fba8a617', '02e3f516-7b63-4907-b4f1-d4e6aa7cac9a', '2015-12-29 00:00:00', null);
INSERT INTO `train_emp` VALUES ('e8ce1495-8b36-43f2-900c-890114920568', '8c682da6-e300-440e-87ea-650fa075ba3f', '32fdcc77-048a-4c5f-9ed8-74cdf5c0b444', 'b2ceda4f-6d74-459b-a1e9-05806958d681', '2015-12-27 00:00:00', null);
INSERT INTO `train_emp` VALUES ('e92f0540-f6a9-4e9f-b138-9dd52764bc30', '441520a1-0c83-4b78-a94b-81af7478965f', '8aa3b106-9d2a-4659-bd6f-bbd3bc7fa960', '4dbd4ae2-ab3e-4ab3-b938-2b289666c513', '2015-12-28 00:00:00', null);
INSERT INTO `train_emp` VALUES ('e94d5418-f053-4cd0-8a71-49dfae9d5b4c', '8c682da6-e300-440e-87ea-650fa075ba3f', '32fdcc77-048a-4c5f-9ed8-74cdf5c0b444', 'b43c9cee-cc87-4c33-8be9-e0567eaf8147', '2015-12-27 00:00:00', null);
INSERT INTO `train_emp` VALUES ('edc7fef0-1ece-46fd-aa74-b0c71a047cb1', '9e0d652c-e08b-4f59-a668-6ad1dfb9d7c1', '92f597f4-c8b5-46d5-8c72-158b6372fa12', '4dbd4ae2-ab3e-4ab3-b938-2b289666c513', '2015-12-27 00:00:00', null);
INSERT INTO `train_emp` VALUES ('f497061d-b1f5-470f-b5c4-85fb1066dc19', '09547566-d988-4c54-ba0c-87c836464afa', 'a0e5f1b6-1760-41c1-9f53-7ad500c1b7d7', '5db7533a-364a-4dfd-8fa8-81adbb9a8b72', '2015-12-27 00:00:00', null);
INSERT INTO `train_emp` VALUES ('f730fff6-920f-49b6-8040-6aab7b69fcd5', '8c682da6-e300-440e-87ea-650fa075ba3f', '32fdcc77-048a-4c5f-9ed8-74cdf5c0b444', '508e5477-9ec0-4984-bfea-7631f43b7042', '2015-12-27 00:00:00', null);
INSERT INTO `train_emp` VALUES ('f7c0890b-720b-45cb-ab93-1218b833072c', '8d3ec9a1-93ef-4581-815d-87bd775b4ffb', 'a56371b9-93bd-4112-87ab-97775047408d', '5dd72ce3-8a8f-406c-856f-f6d6c76525e5', '2015-12-28 00:00:00', null);
INSERT INTO `train_emp` VALUES ('f953bf99-8e22-4ad7-aeff-95db915e3d98', 'c69e7ae8-5a01-4513-9a7f-4274dd84f43d', 'c4d63067-6fe4-4787-b6e3-2ceedaf39243', 'd9791b6a-686d-4e04-a0a4-090728e04420', '2015-12-29 00:00:00', null);
INSERT INTO `train_emp` VALUES ('fa429038-9443-414a-8291-b3286b46112c', '2b8824a3-c815-4f29-9efd-9a94f8924aba', '0c5c407d-270e-401a-8a67-dafceab77639', '825893bd-4213-411d-af20-ade13cf75b98', '2015-12-28 00:00:00', null);
INSERT INTO `train_emp` VALUES ('fc77b8cd-2d43-446a-a135-552f1ef4fa24', '3ed5184a-47a1-4dd3-9434-3fe9c54ab520', 'd3c7709c-436e-4303-91c3-99ddccaf7a7b', 'b2ceda4f-6d74-459b-a1e9-05806958d681', '2015-12-28 00:00:00', null);

-- ----------------------------
-- Table structure for `train_evaluation`
-- ----------------------------
DROP TABLE IF EXISTS `train_evaluation`;
CREATE TABLE `train_evaluation` (
  `TRAIN_EVALUATION_ID` varchar(50) NOT NULL,
  `EMP_ID` varchar(50) DEFAULT NULL,
  `EVALUATION_CONTENT` longtext,
  `EVALUATION_TIME` datetime DEFAULT NULL,
  `REMARK1` varchar(50) DEFAULT NULL,
  `REMARK2` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`TRAIN_EVALUATION_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of train_evaluation
-- ----------------------------

-- ----------------------------
-- Table structure for `train_plan_info`
-- ----------------------------
DROP TABLE IF EXISTS `train_plan_info`;
CREATE TABLE `train_plan_info` (
  `TRAIN_PLAN_ID` varchar(50) NOT NULL,
  `TRAIN_PLAN_NAME` varchar(50) NOT NULL,
  `TRAIN_PLAN_TYPE` varchar(50) NOT NULL,
  `TRAIN_PLAN_YEAR` varchar(8) NOT NULL,
  `START_TIME` date NOT NULL,
  `END_TIME` date NOT NULL,
  `IS_FINISH` varchar(8) NOT NULL,
  `CREATE_TIME` datetime DEFAULT NULL,
  `REMARK1` varchar(50) DEFAULT NULL,
  `REMARK2` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`TRAIN_PLAN_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of train_plan_info
-- ----------------------------
INSERT INTO `train_plan_info` VALUES ('06c04ee5-86ad-4b86-9060-e383fba8a617', '新员工入厂培训', '新员工入厂培训', '2017', '2017-12-13', '2017-12-30', '未培训', null, null, null);
INSERT INTO `train_plan_info` VALUES ('0c5c407d-270e-401a-8a67-dafceab77639', '中层管理人员培训', '中层管理人员培训', '2015', '2015-12-10', '2015-12-15', '培训中', null, null, null);
INSERT INTO `train_plan_info` VALUES ('1c1d87a5-8eef-42fe-9577-569a9a887dcc', '新员工入厂培训', '新员工入厂培训', '2012', '2012-12-10', '2012-12-31', '已培训', null, null, null);
INSERT INTO `train_plan_info` VALUES ('32fdcc77-048a-4c5f-9ed8-74cdf5c0b444', '班组长培训', '班组长培训', '2013', '2013-06-28', '2013-10-06', '已培训', null, null, null);
INSERT INTO `train_plan_info` VALUES ('362157e0-5669-4f73-aa3a-2ee3d0681525', '班组长培训', '班组长培训', '2016', '2016-01-10', '2016-02-10', '未培训', null, null, null);
INSERT INTO `train_plan_info` VALUES ('3a96e0e3-3cfb-4967-ba1f-426b0013809e', '中层管理人员培训', '中层管理人员培训', '2015', '2015-12-28', '2015-12-31', '未培训', null, null, null);
INSERT INTO `train_plan_info` VALUES ('8aa3b106-9d2a-4659-bd6f-bbd3bc7fa960', '中层管理人员培训', '中层管理人员培训', '2012', '2012-12-27', '2012-12-31', '已培训', null, null, null);
INSERT INTO `train_plan_info` VALUES ('92f597f4-c8b5-46d5-8c72-158b6372fa12', '中层管理人员培训', '中层管理人员培训', '2013', '2013-10-20', '2013-11-22', '已培训', null, null, null);
INSERT INTO `train_plan_info` VALUES ('a0e5f1b6-1760-41c1-9f53-7ad500c1b7d7', '新员工入厂培训', '新员工入厂培训', '2012', '2012-02-02', '2012-02-12', '未培训', null, null, null);
INSERT INTO `train_plan_info` VALUES ('a56371b9-93bd-4112-87ab-97775047408d', '班组长培训', '班组长培训', '2015', '2015-08-28', '2015-09-28', '已培训', null, null, null);
INSERT INTO `train_plan_info` VALUES ('bc045d57-1944-43fc-99e6-5fae7c0be753', '新员工入厂培训', '新员工入厂培训', '2014', '2014-12-26', '2014-01-26', '已培训', null, null, null);
INSERT INTO `train_plan_info` VALUES ('c112f80b-7d73-460c-9ada-7ef2b364e1e8', '班组长培训', '班组长培训', '2016', '2016-12-28', '2016-12-31', '未培训', null, null, null);
INSERT INTO `train_plan_info` VALUES ('c4d63067-6fe4-4787-b6e3-2ceedaf39243', '新员工入厂培训', '新员工入厂培训', '2015', '2015-12-12', '2015-12-22', '已培训', null, null, null);
INSERT INTO `train_plan_info` VALUES ('d3c7709c-436e-4303-91c3-99ddccaf7a7b', '中层管理人员培训', '中层管理人员培训', '2014', '2014-12-28', '2015-11-23', '已培训', null, null, null);
INSERT INTO `train_plan_info` VALUES ('e7402e4b-8a82-48e6-9d68-017f277a69fe', '新员工入厂培训', '新员工入厂培训', '2015', '2015-01-01', '2015-06-30', '已培训', null, null, null);
INSERT INTO `train_plan_info` VALUES ('f91b78bc-5b60-4873-a84f-047454aa395d', '新员工入厂培训', '新员工入厂培训', '2016', '2016-12-10', '2016-12-20', '未培训', null, null, null);

-- ----------------------------
-- Table structure for `train_plan_item`
-- ----------------------------
DROP TABLE IF EXISTS `train_plan_item`;
CREATE TABLE `train_plan_item` (
  `TRAIN_ITEM_ID` varchar(50) NOT NULL DEFAULT '',
  `TRAIN_PLAN_ID` varchar(50) NOT NULL,
  `ZY_DIC_ID` varchar(50) DEFAULT NULL,
  `ZY_NAME` varchar(50) NOT NULL,
  `TRAIN_PURPOSE` longtext NOT NULL,
  `TRAIN_CONTENT` longtext NOT NULL,
  `CLASS_COUNT` varchar(50) NOT NULL,
  `TEACHER` varchar(20) NOT NULL,
  `RESULT_SUBMIT` varchar(2) DEFAULT NULL,
  `CREATE_TIME` datetime DEFAULT NULL,
  `TRAIN_PLACE` varchar(100) DEFAULT NULL,
  `START_DATE` date DEFAULT NULL,
  `END_DATE` date DEFAULT NULL,
  `DAY_START_TIME` time DEFAULT NULL,
  `DAY_END_TIME` time DEFAULT NULL,
  `REMARK` varchar(50) DEFAULT NULL,
  `REMARK1` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`TRAIN_ITEM_ID`),
  KEY `FK_TRAIN_PLAN_ID1` (`TRAIN_PLAN_ID`),
  CONSTRAINT `FK_TRAIN_PLAN_ID1` FOREIGN KEY (`TRAIN_PLAN_ID`) REFERENCES `train_plan_info` (`TRAIN_PLAN_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of train_plan_item
-- ----------------------------
INSERT INTO `train_plan_item` VALUES ('09547566-d988-4c54-ba0c-87c836464afa', 'a0e5f1b6-1760-41c1-9f53-7ad500c1b7d7', '1c0e1b04-f8e9-45a5-aeba-187c5be018d6', '电气', '2', '2', '2', '吴浩', null, null, null, null, null, null, null, null, null);
INSERT INTO `train_plan_item` VALUES ('0e3a60dc-0818-48cb-8dc6-463bcdb2fc2a', '1c1d87a5-8eef-42fe-9577-569a9a887dcc', '2070311b-8b8c-4dd9-8205-335078aa7bc5', '电气', '23', '23', '2', '吴浩', null, null, null, null, null, null, null, null, null);
INSERT INTO `train_plan_item` VALUES ('2b8824a3-c815-4f29-9efd-9a94f8924aba', '0c5c407d-270e-401a-8a67-dafceab77639', '0bfe8026-15d9-40b7-a59b-81ab91c3fe37', '化水', '8', '8', '8', '吴浩', null, null, null, null, null, null, null, null, null);
INSERT INTO `train_plan_item` VALUES ('3ed5184a-47a1-4dd3-9434-3fe9c54ab520', 'd3c7709c-436e-4303-91c3-99ddccaf7a7b', '89df04be-2d6f-41d8-85d7-2fd34965e66b', '锅炉', '技术试炼', '考勤+测试', '16', '王乐', null, null, null, null, null, null, null, null, null);
INSERT INTO `train_plan_item` VALUES ('432eb98b-2fba-4911-9397-0980e8f9dde0', 'bc045d57-1944-43fc-99e6-5fae7c0be753', '06a98cbb-1a46-49a3-baec-75f1f710e946', '汽机', '技术试炼', '考勤+测试', '128', '吴浩', null, null, null, null, null, null, null, null, null);
INSERT INTO `train_plan_item` VALUES ('441520a1-0c83-4b78-a94b-81af7478965f', '8aa3b106-9d2a-4659-bd6f-bbd3bc7fa960', '1440820c-c764-41dd-b600-b6123bbb4378', '锅炉', '2', '2', '2', '李秀明', null, null, null, null, null, null, null, null, null);
INSERT INTO `train_plan_item` VALUES ('45cd2af0-6d64-4499-b72d-c0e9dfee11c9', '3a96e0e3-3cfb-4967-ba1f-426b0013809e', '8c5f0900-d446-4610-a2de-d013e7fd6ed7', '燃运', '321', '321', '123', '丁英杰', null, null, null, null, null, null, null, null, null);
INSERT INTO `train_plan_item` VALUES ('60328d31-b6b5-4658-aede-2338045fdf08', 'e7402e4b-8a82-48e6-9d68-017f277a69fe', '1f33910f-3db2-43b0-b8c9-04c284e1364a', '锅炉', '为了以后更好的生活！', '烧煤', '128', '张亚超', null, null, null, null, null, null, null, null, null);
INSERT INTO `train_plan_item` VALUES ('86f0c597-34d5-4a35-9870-c41c5f472b3f', '4310e4cc-8f13-4306-9b2d-9db2c645b1b8', '8d3049d0-b93b-4e21-b26b-1a71caf40a49', '汽机', 'jkkkkkkkkkkkkkk', 'dwedwedew', '4', 'wewe', null, null, null, null, null, null, null, null, null);
INSERT INTO `train_plan_item` VALUES ('88f3ab0f-0d44-4395-9078-ec8d701f2a71', '06c04ee5-86ad-4b86-9060-e383fba8a617', '235c5a45-565b-48e2-9c9e-b8ebd17f5e49', '电气', '技术试炼', '考勤+测试', '16', '吴浩', null, null, null, null, null, null, null, null, null);
INSERT INTO `train_plan_item` VALUES ('8b6da49e-eab8-4bde-8256-e2715f9c404c', '362157e0-5669-4f73-aa3a-2ee3d0681525', '6021a5f9-6b6e-4092-8c07-0b1b5513705a', '汽机', '1、掌握直流电路组成及作用\n2、了解电磁怎样产生及作用\n3、交流电怎样产生', '电工基础知识：\n1、直流电路\n2、电磁与电磁感应\n3、交流电路', '24', '吴浩', null, null, null, null, null, null, null, null, null);
INSERT INTO `train_plan_item` VALUES ('8c682da6-e300-440e-87ea-650fa075ba3f', '32fdcc77-048a-4c5f-9ed8-74cdf5c0b444', '3aeb1cc2-7271-4421-9c00-63e72852a470', '燃运', '掌握技术', '实练', '12', '吴浩', null, null, null, null, null, null, null, null, null);
INSERT INTO `train_plan_item` VALUES ('8d3ec9a1-93ef-4581-815d-87bd775b4ffb', 'a56371b9-93bd-4112-87ab-97775047408d', '4599c318-1904-4154-9ce0-a1d5cd41319d', '燃运', '技术试炼', '考勤+测试', '128', '刘力瑄', null, null, null, null, null, null, null, null, null);
INSERT INTO `train_plan_item` VALUES ('9e0d652c-e08b-4f59-a668-6ad1dfb9d7c1', '92f597f4-c8b5-46d5-8c72-158b6372fa12', '43efaa15-8335-426f-a19e-999058ffa4c2', '锅炉', '技术试炼', '考勤+测试', '16', '吴浩', null, null, null, null, null, null, null, null, null);
INSERT INTO `train_plan_item` VALUES ('a2c86c3e-4b68-4084-826b-20d6f1fed56c', 'c112f80b-7d73-460c-9ada-7ef2b364e1e8', 'bf979df9-6b4e-4da2-b9bd-6458fcef5e37', '燃运', '技术试炼', '考勤+测试', '26', '赵亚迪', null, null, null, null, null, null, null, null, null);
INSERT INTO `train_plan_item` VALUES ('b9768ec2-8fb4-44d0-9d51-0e558b883dd2', 'dd34c57a-1e17-481b-b351-8bb7760fb53d', 'f4f8f267-3bce-4dea-b082-3113717827ce', '电气', '培训试炼', '考勤+测试', '16', '吴浩', null, null, null, null, null, null, null, null, null);
INSERT INTO `train_plan_item` VALUES ('c69e7ae8-5a01-4513-9a7f-4274dd84f43d', 'c4d63067-6fe4-4787-b6e3-2ceedaf39243', '70008e66-01e7-4e0b-8de5-d0ebd7ddf4c1', '汽机', '4', '4', '4', '张峰耀', null, null, null, null, null, null, null, null, null);
INSERT INTO `train_plan_item` VALUES ('cc8a11f3-3560-4432-b8e8-30c8cd27bed6', 'f91b78bc-5b60-4873-a84f-047454aa395d', '42fdb9ce-df19-4f24-a213-f88059379923', '锅炉', '1、掌握直流电路组成及其作用。\n2、了解电磁怎样产生及其作用。\n3、交流电怎样产生', '电工基础知识：\n1、直流电路\n2、电磁与电磁感应\n3、交流电路', '15', '吴浩', null, null, null, null, null, null, null, null, null);
INSERT INTO `train_plan_item` VALUES ('f9c6d1d2-3d31-4e0a-b18a-7a2fabbc7dee', 'f9c6d1d2-3d31-4e0a-b18a-7a2fabbc7df1', '7d213e71-4872-47b4-b5eb-ee8c5fa5e493', '电气', '2', '2', '2', '吴浩', null, null, null, null, null, null, null, null, null);

-- ----------------------------
-- Table structure for `train_result`
-- ----------------------------
DROP TABLE IF EXISTS `train_result`;
CREATE TABLE `train_result` (
  `TRAIN_RESULT_ID` varchar(50) NOT NULL,
  `TRAIN_EMP_ID` varchar(50) DEFAULT NULL,
  `EXAM_RESULT` float DEFAULT NULL,
  `ATTENDANCE_RESULT` float DEFAULT NULL,
  `TOTAL_RESULT` float DEFAULT NULL,
  `EXAM_TIME` datetime DEFAULT NULL,
  `INPUT_TIME` datetime DEFAULT NULL,
  `REMARK` varchar(50) DEFAULT NULL,
  `REMARK1` varchar(50) DEFAULT NULL,
  `REMARK2` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`TRAIN_RESULT_ID`),
  KEY `FK_TRAIN_EMP_ID1` (`TRAIN_EMP_ID`),
  CONSTRAINT `FK_TRAIN_EMP_ID1` FOREIGN KEY (`TRAIN_EMP_ID`) REFERENCES `t_base_user_info` (`USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of train_result
-- ----------------------------
INSERT INTO `train_result` VALUES ('11c03e5c-49d9-431d-a01d-ff1631bc1d65', 'b2ceda4f-6d74-459b-a1e9-05806958d681', '80', '20', '100', '2015-12-28 00:32:24', '2015-12-28 00:32:24', null, null, null);
INSERT INTO `train_result` VALUES ('32386174-3a64-478e-843b-4857ab8a1965', '5db7533a-364a-4dfd-8fa8-81adbb9a8b72', '70', '20', '96', '2015-12-28 00:35:54', '2015-12-28 00:35:54', null, null, null);
INSERT INTO `train_result` VALUES ('37f43804-76e3-43bc-8115-12b4393aa90f', '58916bba-ca85-405e-a6c6-c052b2bbb866', '80', '20', '100', '2015-12-28 00:32:51', '2015-12-28 00:32:51', null, null, null);
INSERT INTO `train_result` VALUES ('4225cdaf-3b4e-4e37-8575-8f69e7fad50f', '7a29b9ab-0a56-449b-a4e6-3cbdac83736d', '80', '20', '100', '2015-12-28 00:32:14', '2015-12-28 00:32:14', null, null, null);
INSERT INTO `train_result` VALUES ('55c7d9f5-d888-4bc4-bf6e-2257882829cb', 'ac2728ae-a880-481e-9721-9f7d1cfab9c6', '80', '20', '100', '2015-12-29 13:51:45', '2015-12-29 13:51:45', null, null, null);
INSERT INTO `train_result` VALUES ('59c0e2c5-cce3-4a3d-8367-cf3eb8560d84', 'd9791b6a-686d-4e04-a0a4-090728e04420', '80', '20', '100', '2015-12-28 00:32:04', '2015-12-28 00:32:04', null, null, null);
INSERT INTO `train_result` VALUES ('66ec58e3-9f0f-415e-a5ea-ae6ee607b395', 'cf89aceb-010a-4478-8df9-5caa1abc800a', '70', '20', '96', '2015-12-28 00:37:38', '2015-12-28 00:37:38', null, null, null);
INSERT INTO `train_result` VALUES ('720129a2-037f-4f59-bae4-8c7232387240', '1884c208-4bd0-4bfd-84e0-97b1484f9680', '80', '20', '100', '2015-12-28 00:37:41', '2015-12-28 00:37:41', null, null, null);
INSERT INTO `train_result` VALUES ('8cc0f7b7-6098-437e-9aee-d950428d266a', 'b43c9cee-cc87-4c33-8be9-e0567eaf8147', '80', '20', '100', '2015-12-28 00:32:48', '2015-12-28 00:32:48', null, null, null);
INSERT INTO `train_result` VALUES ('a457812f-3596-4fc0-99c5-2b02dbfb1c05', '5db7533a-364a-4dfd-8fa8-81adbb9a8b72', '70', '20', '96', '2015-12-28 00:35:54', '2015-12-28 00:35:54', null, null, null);
INSERT INTO `train_result` VALUES ('afff7e33-d6de-433f-85a7-25874cf62380', 'b685597d-3035-4b75-8ba0-777bd0953da8', '80', '20', '100', '2015-12-28 19:23:42', '2015-12-28 19:23:42', null, null, null);
INSERT INTO `train_result` VALUES ('c03b950b-025c-4206-9961-e07ce3e28d83', '1bd7c4a0-7fb5-44b8-90f6-7d0a5516db21', '80', '20', '100', '2015-12-28 00:32:32', '2015-12-28 00:32:32', null, null, null);
INSERT INTO `train_result` VALUES ('c4ecc34d-c2a2-4b9e-98d9-60a970f28bc4', '508e5477-9ec0-4984-bfea-7631f43b7042', '70', '20', '96', '2015-12-28 00:37:35', '2015-12-28 00:37:35', null, null, null);
INSERT INTO `train_result` VALUES ('cabcfda8-4624-4ac4-bc16-9bd0419589af', 'b2ceda4f-6d74-459b-a1e9-05806958d681', '80', '20', '100', '2015-12-28 18:53:30', '2015-12-28 18:53:30', null, null, null);

-- ----------------------------
-- Table structure for `train_result_ratio`
-- ----------------------------
DROP TABLE IF EXISTS `train_result_ratio`;
CREATE TABLE `train_result_ratio` (
  `TRAIN_RATIO_ID` varchar(50) NOT NULL,
  `TRAIN_ITEM_ID` varchar(50) DEFAULT NULL,
  `EXAM_RATIO` float DEFAULT NULL,
  `ATTENDANCE_RATIO` float DEFAULT NULL,
  `SET_TIME` datetime DEFAULT NULL,
  `REMARK` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`TRAIN_RATIO_ID`),
  KEY `FK_TRAIN_ITEM_ID1` (`TRAIN_ITEM_ID`),
  CONSTRAINT `FK_TRAIN_ITEM_ID1` FOREIGN KEY (`TRAIN_ITEM_ID`) REFERENCES `train_plan_item` (`TRAIN_ITEM_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of train_result_ratio
-- ----------------------------

-- ----------------------------
-- Table structure for `t_base_defined_url`
-- ----------------------------
DROP TABLE IF EXISTS `t_base_defined_url`;
CREATE TABLE `t_base_defined_url` (
  `ID` varchar(40) NOT NULL,
  `MODULE_ID` varchar(40) DEFAULT NULL,
  `MODULE_NAME` varchar(100) DEFAULT NULL,
  `MODULE_URL` varchar(200) DEFAULT NULL,
  `MEMO1` varchar(100) DEFAULT NULL,
  `MEMO2` varchar(100) DEFAULT NULL,
  `INUSE` int(11) DEFAULT NULL,
  `SORT_NO` int(11) DEFAULT NULL,
  `MENU_CLASS` int(11) DEFAULT NULL,
  `FLAG` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_MODULE_ID1` (`MODULE_ID`),
  CONSTRAINT `FK_MODULE_ID1` FOREIGN KEY (`MODULE_ID`) REFERENCES `dic_system_dictionary` (`DICTIONARY_OPTION_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_base_defined_url
-- ----------------------------

-- ----------------------------
-- Table structure for `t_base_unit_info`
-- ----------------------------
DROP TABLE IF EXISTS `t_base_unit_info`;
CREATE TABLE `t_base_unit_info` (
  `UNIT_ID` varchar(40) NOT NULL,
  `UP_UNIT_ID` varchar(40) DEFAULT NULL,
  `UNIT_CLASS` varchar(100) DEFAULT NULL,
  `UNIT_NAME` varchar(100) NOT NULL,
  `ADDRESS` varchar(200) DEFAULT NULL,
  `TELEPHONE` varchar(40) DEFAULT NULL,
  `CONTACT_PERSON` varchar(40) DEFAULT '',
  `EMAIL` varchar(40) DEFAULT NULL,
  `HEADER` varchar(40) DEFAULT NULL,
  `CREATE_DATE` date DEFAULT '0000-00-00',
  `REMARK` longtext,
  PRIMARY KEY (`UNIT_ID`),
  KEY `FK_UNIT_ID4` (`UP_UNIT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_base_unit_info
-- ----------------------------
INSERT INTO `t_base_unit_info` VALUES ('001', null, null, '太原市第二热电厂', '太原', '5362', '李秀明', '5362@qq.com', 'tysderc', '2015-12-15', '');
INSERT INTO `t_base_unit_info` VALUES ('001001', '001', '', '发电一部', '太原', '6270', '丁英杰', '6279@qq.com', 'FD1', '2015-12-15', '');
INSERT INTO `t_base_unit_info` VALUES ('001002', '001', '', '发电二部', '太原', '5630', '秦世杰', '5630@qq.com', 'FD2', '2015-12-11', '');
INSERT INTO `t_base_unit_info` VALUES ('001003', '001', '', '检修车间', '太原', '5980', '郭永鹏', '5980@qq.com', 'JXCJ', '2015-12-11', '');
INSERT INTO `t_base_unit_info` VALUES ('001004', '001', '', '锅炉车间', '太原', '6356', '何勇庆', '6356@qq.com', 'GLCJ', '2015-12-11', '');
INSERT INTO `t_base_unit_info` VALUES ('001005', '001', '', '燃料车间', '太原', '6279', '赵亚迪', '6279@qq.com', 'RLCJ', '2015-12-11', '');
INSERT INTO `t_base_unit_info` VALUES ('001006', '001', null, '运输部', '太原', '6279', '刘力瑄', '3808@qq.com', 'YSB', '2015-12-15', '');
INSERT INTO `t_base_unit_info` VALUES ('001011', '001001', null, '电气1班', '太原', '6158', '王乐', '6158@qq.com', 'DQ1', '2015-12-15', '');
INSERT INTO `t_base_unit_info` VALUES ('001012', '001002', null, '电气1班', '太原', '5630', '小胖子', '5630@qq.com', 'DQ2', '2015-12-15', '');
INSERT INTO `t_base_unit_info` VALUES ('001021', '001001', null, '锅炉1班', '太原', '6270', '小黄毛', '6270@qq.com', 'GL1', '2015-12-15', '');
INSERT INTO `t_base_unit_info` VALUES ('001022', '001002', null, '锅炉1班', '太原', '5980', '郭永鹏', '5980@qq.com', 'GL2', '2015-12-15', '');
INSERT INTO `t_base_unit_info` VALUES ('001031', '001001', null, '汽机1班', '太原', '6270', '猫猫', '6270@qq.com', 'QJ1', '2015-12-15', '');
INSERT INTO `t_base_unit_info` VALUES ('001032', '001002', null, '汽机1班', '太原', '6279', '比亚迪', '6279@qq.com', 'QJ2', '2015-12-15', '');
INSERT INTO `t_base_unit_info` VALUES ('001041', '001001', null, '化水1班', '太原', '66282823', '吴浩', null, 'HS1', '2015-12-29', '');
INSERT INTO `t_base_unit_info` VALUES ('001042', '001002', null, '化水1班', '太原', '66282823', '吴浩', null, 'HS2', '2015-12-29', '');
INSERT INTO `t_base_unit_info` VALUES ('001051', '001001', null, '燃运1班', '太原', '66282823', '吴浩', null, 'RY1', '2015-12-29', '');
INSERT INTO `t_base_unit_info` VALUES ('001052', '001002', null, '燃运1班', '太原', '66282823', '吴浩', null, 'RY2', '2015-12-29', '');

-- ----------------------------
-- Table structure for `t_base_unit_role`
-- ----------------------------
DROP TABLE IF EXISTS `t_base_unit_role`;
CREATE TABLE `t_base_unit_role` (
  `UNIT_ID` varchar(40) DEFAULT NULL,
  `ROLE_ID` varchar(40) DEFAULT NULL,
  `ROLE_NAME` varchar(40) DEFAULT NULL,
  `CREATE_UNIT_ID` varchar(40) DEFAULT NULL,
  `DESCRIPTION` varchar(100) DEFAULT NULL,
  `INUSE` int(11) DEFAULT NULL,
  KEY `FK_ROLE_ID1` (`ROLE_ID`),
  KEY `FK_UNIT_ID1` (`UNIT_ID`),
  CONSTRAINT `FK_ROLE_ID1` FOREIGN KEY (`ROLE_ID`) REFERENCES `dic_system_dictionary` (`DICTIONARY_OPTION_ID`),
  CONSTRAINT `FK_UNIT_ID1` FOREIGN KEY (`UNIT_ID`) REFERENCES `t_base_unit_info` (`UNIT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_base_unit_role
-- ----------------------------

-- ----------------------------
-- Table structure for `t_base_unit_role_module`
-- ----------------------------
DROP TABLE IF EXISTS `t_base_unit_role_module`;
CREATE TABLE `t_base_unit_role_module` (
  `UNIT_ID` varchar(50) DEFAULT NULL,
  `ROLE_ID` varchar(50) DEFAULT NULL,
  `MODULE_ID` varchar(40) DEFAULT NULL,
  KEY `FK_MODULE_ID2` (`MODULE_ID`),
  CONSTRAINT `FK_MODULE_ID2` FOREIGN KEY (`MODULE_ID`) REFERENCES `dic_system_dictionary` (`DICTIONARY_OPTION_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_base_unit_role_module
-- ----------------------------

-- ----------------------------
-- Table structure for `t_base_unit_user_role`
-- ----------------------------
DROP TABLE IF EXISTS `t_base_unit_user_role`;
CREATE TABLE `t_base_unit_user_role` (
  `ROLE_ID` varchar(40) DEFAULT NULL,
  `UNIT_ID` varchar(40) DEFAULT NULL,
  `USER_ID` varchar(40) DEFAULT NULL,
  KEY `FK_MODULE_ID3` (`UNIT_ID`),
  KEY `FK_USER_ID1` (`USER_ID`),
  KEY `FK_ROLE_ID2` (`ROLE_ID`),
  CONSTRAINT `FK_MODULE_ID3` FOREIGN KEY (`UNIT_ID`) REFERENCES `t_base_unit_info` (`UNIT_ID`),
  CONSTRAINT `FK_ROLE_ID2` FOREIGN KEY (`ROLE_ID`) REFERENCES `dic_system_dictionary` (`DICTIONARY_OPTION_ID`),
  CONSTRAINT `FK_USER_ID1` FOREIGN KEY (`USER_ID`) REFERENCES `t_base_user_info` (`USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_base_unit_user_role
-- ----------------------------

-- ----------------------------
-- Table structure for `t_base_user_info`
-- ----------------------------
DROP TABLE IF EXISTS `t_base_user_info`;
CREATE TABLE `t_base_user_info` (
  `USER_ID` varchar(40) NOT NULL,
  `USER_NAME` varchar(40) NOT NULL,
  `SEX` varchar(1) DEFAULT NULL,
  `NAME` varchar(40) DEFAULT NULL,
  `CARD_ID` varchar(18) DEFAULT NULL,
  `BIRTHDAY` date DEFAULT NULL,
  `UNIT_ID` varchar(40) DEFAULT NULL,
  `PASSWORD` varchar(20) NOT NULL,
  `TELEPHONE` varchar(40) DEFAULT NULL,
  `DUTY` varchar(40) DEFAULT NULL,
  `TECDUTY` varchar(40) DEFAULT NULL,
  `USER_COMMENT` varchar(100) DEFAULT NULL,
  `INUSE` int(1) DEFAULT NULL,
  `EMAIL` varchar(40) DEFAULT NULL,
  `CREATE_UNIT_ID` varchar(100) DEFAULT NULL,
  `MOBILE` varchar(200) DEFAULT NULL,
  `CREATE_TIME` date DEFAULT NULL,
  `LAST_LOGIN_TIME` date DEFAULT NULL,
  `REM_PASSWORD` int(1) DEFAULT NULL,
  `AUTO_LOGIN` int(1) DEFAULT NULL,
  PRIMARY KEY (`USER_ID`),
  KEY `FK_UNIT_ID2` (`UNIT_ID`),
  CONSTRAINT `FK_UNIT_ID2` FOREIGN KEY (`UNIT_ID`) REFERENCES `t_base_unit_info` (`UNIT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_base_user_info
-- ----------------------------
INSERT INTO `t_base_user_info` VALUES ('01524aa1-4c97-4fb9-ae49-cecc19813ece', '钱六', '男', '钱六', '48345873538437273', '1984-06-07', '001012', '123456', '18453723784', '员工', '本科', null, null, null, null, null, null, '2015-12-28', '1', '1');
INSERT INTO `t_base_user_info` VALUES ('02e3f516-7b63-4907-b4f1-d4e6aa7cac9a', '王胖子', '男', '王胖子', '411082199202020637', '1992-02-02', '001002', '123456', '18234567890', '厂长', '博士', null, null, null, null, null, null, '2015-12-28', '1', '1');
INSERT INTO `t_base_user_info` VALUES ('091e8e83-1855-4b17-8010-e70b9820a10b', '钱五', '男', '钱五', '48345873538457458', '1984-06-07', '001012', '123456', '18453723622', '员工', '本科', null, null, null, null, null, null, '2015-12-28', null, null);
INSERT INTO `t_base_user_info` VALUES ('09600968-decf-4c0a-8a05-dde9ff97ba20', '林冲', '男', '林冲', '34257474734477574', '1977-12-12', '001032', '123456', '13346573462', '主任', '专科', null, null, null, null, null, null, '2015-12-28', '1', '1');
INSERT INTO `t_base_user_info` VALUES ('0f2ceffb-794a-4569-900f-cc1afe8bd7bb', '张六', '男', '张六', '845564785343648696', '1985-12-17', '001011', '123456', '18724537858', '员工', '专科', null, null, null, null, null, null, '2015-12-28', '1', '1');
INSERT INTO `t_base_user_info` VALUES ('136c504a-b64b-401b-8154-59b2e7251d03', 'lunatic', '男', 'lunatic', '411082199411010637', '1994-10-20', '001012', '359099631', '18435155316', '班长', '本科', null, null, null, null, null, null, '2015-12-28', '1', '1');
INSERT INTO `t_base_user_info` VALUES ('16944890-6bf0-4148-b5a2-b6a864cd830c', 'world', null, 'world', null, null, null, 'qtp', null, null, null, null, null, null, null, null, null, '2015-12-28', null, null);
INSERT INTO `t_base_user_info` VALUES ('1884c208-4bd0-4bfd-84e0-97b1484f9680', '何勇庆', '男', '何勇庆', '123456199412205678', '1994-12-24', '001004', '123456', '18898716356', '员工', '本科', null, null, null, null, null, null, '2015-12-28', '1', '1');
INSERT INTO `t_base_user_info` VALUES ('1b75bb29-afa1-470c-8f5e-c10c8fbb15d3', '高衙内', '男', '高衙内', '75425547345248524', '1977-08-25', '001032', '123456', '13346574723', '班长', '硕士', null, null, null, null, null, null, '2015-12-28', null, null);
INSERT INTO `t_base_user_info` VALUES ('1bd7c4a0-7fb5-44b8-90f6-7d0a5516db21', '王乐', '男', '王乐', '411082199411010627', '1993-12-10', '001021', '123456', '18435156158', '班长', '博士', null, null, null, null, null, null, '2015-12-28', null, null);
INSERT INTO `t_base_user_info` VALUES ('21c04385-c035-451c-b85d-eed776a1bc3b', '李逵', '男', '李逵', '75458483654734545', '1977-08-14', '001032', '123456', '13346575354', '员工', '本科', null, null, null, null, null, null, '2015-12-28', null, null);
INSERT INTO `t_base_user_info` VALUES ('2a577533-67b3-448c-b15e-416f8a8a0bbc', '小乔', '女', '小乔', '73462758256783434', '1976-11-16', '001022', '123456', '13346574242', '班长', '本科', null, null, null, null, null, null, '2015-12-28', null, null);
INSERT INTO `t_base_user_info` VALUES ('2f036549-a077-42a0-8ce0-e73f91c0494c', '钱七', '女', '钱七', '48345873538447343', '1974-02-06', '001012', '123456', '18453725843', '员工', '专科', null, null, null, null, null, null, '2015-12-28', null, null);
INSERT INTO `t_base_user_info` VALUES ('2fd0d2b8-4ac9-4d27-8200-1c82cb2f2ed2', '王七', '男', '王七', '37853374845375484X', '1983-06-10', '001021', '123456', '18371270475', '主任', '博士', null, null, null, null, null, null, '2015-12-28', null, null);
INSERT INTO `t_base_user_info` VALUES ('31014b61-82d2-4da1-aeca-b897d2888073', '张三', '男', '张三', '223134198106096374', '1981-06-09', '001011', '123456', '18736374646', '员工', '专科', null, null, null, null, null, null, '2015-12-28', null, null);
INSERT INTO `t_base_user_info` VALUES ('3348812f-d10d-4c25-8b3a-f76430ae49cb', '邹氏', '女', '邹氏', '34257474734823758', '1977-12-20', '001022', '123456', '13346573244', '员工', '专科', null, null, null, null, null, null, '2015-12-28', null, null);
INSERT INTO `t_base_user_info` VALUES ('3463f896-3452-41df-9d0a-d6008ca3e259', '赵一', '女', '赵一', '845564785344758936', '1985-10-23', '001031', '123456', '18724535768', '员工', '专科', null, null, null, null, null, null, '2015-12-28', null, null);
INSERT INTO `t_base_user_info` VALUES ('39322861-417d-40b8-9ece-076c120fd2e3', '钱四', '男', '钱四', '87539528525784578', '1983-02-01', '001012', '123456', '18453724723', '班长', '本科', null, null, null, null, null, null, null, null, null);
INSERT INTO `t_base_user_info` VALUES ('3a877a06-5542-4296-9725-9aae031eb63d', '刘梅', '女', '刘梅', '411082197812120637', '1978-12-12', '001001', '123456', '18435151234', '厂长', '博士', null, null, null, null, null, null, null, null, null);
INSERT INTO `t_base_user_info` VALUES ('400c50d3-9ca6-4fc8-a56a-a2a0b7d5d1ec', '王四', '男', '王四', '84556478475486584X', '1983-05-19', '001021', '123456', '18371204853', '员工', '专科', null, null, null, null, null, null, null, null, null);
INSERT INTO `t_base_user_info` VALUES ('42d0e49f-3aa9-4c24-8831-afa9c17323d3', '扈三娘', '男', '扈三娘', '75458483648728524', '1977-08-19', '001032', '123456', '13346575254', '员工', '本科', null, null, null, null, null, null, null, null, null);
INSERT INTO `t_base_user_info` VALUES ('4737bb40-644c-4d8d-a1d3-169a15f9bd4f', '钱二', '男', '钱二', '37423374845375484X', '1983-06-20', '001012', '123456', '18453728593', '主任', '本科', null, null, null, null, null, null, null, null, null);
INSERT INTO `t_base_user_info` VALUES ('49e575c5-93eb-4602-9ef1-5f7ee93d136b', '糜夫人', '女', '糜夫人', '73462758384275823', '1976-04-06', '001022', '123456', '13346574823', '员工', '本科', null, null, null, null, null, null, null, null, null);
INSERT INTO `t_base_user_info` VALUES ('4b8c4370-6e41-47e8-bc2f-f45b6a38abe9', '钱三', '男', '钱三', '37425843945375484X', '1983-02-01', '001012', '123456', '18453725949', '班长', '硕士', null, null, null, null, null, null, null, null, null);
INSERT INTO `t_base_user_info` VALUES ('4db75bde-8e5f-45ef-b2db-b1d47b4d36f5', '赵四', '男', '赵四', '84556478533748222X', '1985-08-07', '001031', '123456', '18724538888', '班长', '硕士', null, null, null, null, null, null, null, null, null);
INSERT INTO `t_base_user_info` VALUES ('4dbd4ae2-ab3e-4ab3-b938-2b289666c513', '赵钱孙', '女', '赵钱孙', '123456199812160637', '1998-12-16', '001031', '123456', '18234567890', '厂长', '博士', null, null, null, null, null, null, null, null, null);
INSERT INTO `t_base_user_info` VALUES ('508e5477-9ec0-4984-bfea-7631f43b7042', '赵亚迪', '男', '赵亚迪', '411082199411010635', '1994-11-16', '001032', '8959', '18435156279', '厂长', '博士', null, null, null, null, null, null, null, null, null);
INSERT INTO `t_base_user_info` VALUES ('58916bba-ca85-405e-a6c6-c052b2bbb866', '钱一', '女', '钱一', '123456199607080637', '1976-03-26', '001012', '123456', '18345678901', '厂长', '博士', null, null, null, null, null, null, null, null, null);
INSERT INTO `t_base_user_info` VALUES ('58d60282-80fd-43e8-8683-7b426ca69f3b', '王二', '男', '王二', '84556478644758584X', '1983-03-16', '001021', '123456', '18371202843', '员工', '硕士', null, null, null, null, null, null, null, null, null);
INSERT INTO `t_base_user_info` VALUES ('5ac9406f-e0a0-49c9-926f-bea59d80354a', '刘振楠', '男', '刘振楠', '411082199411200637', '1994-11-20', '001006', '123456', '18898763421', '班长', '本科', null, null, null, null, null, null, null, null, null);
INSERT INTO `t_base_user_info` VALUES ('5db7533a-364a-4dfd-8fa8-81adbb9a8b72', '李秀明', '男', '李秀明', '123456199412200637', '1994-08-18', '001003', '123456', '18435150897', '班长', '硕士', null, null, null, null, null, null, null, '1', '1');
INSERT INTO `t_base_user_info` VALUES ('5dd72ce3-8a8f-406c-856f-f6d6c76525e5', '鲁智深', '男', '鲁智深', '34257474734448524', '1977-11-11', '001032', '123456', '13346575344', '班长', '硕士', null, null, null, null, null, null, null, null, null);
INSERT INTO `t_base_user_info` VALUES ('6c03d392-18a7-443b-97d8-aee7824bb263', '张一', '男', '张一', '845238472658284734', '1985-12-05', '001011', '123456', '18594794543', '员工', '专科', null, null, null, null, null, null, null, null, null);
INSERT INTO `t_base_user_info` VALUES ('731dc8ea-225b-4e25-ab74-a0ad32025925', '貂蝉', '女', '貂蝉', '34257283875824758', '1977-12-14', '001022', '123456', '13346574723', '员工', '本科', null, null, null, null, null, null, null, null, null);
INSERT INTO `t_base_user_info` VALUES ('73adcef6-e3fe-4be3-925a-58ecac53712b', '赵三', '女', '赵三', '845564785337484936', '1985-08-16', '001031', '123456', '18724533743', '员工', '专科', null, null, null, null, null, null, null, null, null);
INSERT INTO `t_base_user_info` VALUES ('76725553-2acc-4e7f-8a39-f21c14a10ecd', '王八', '男', '王八', '48953374845375484X', '1983-06-10', '001021', '123456', '18371279999', '厂长', '硕士', null, null, null, null, null, null, null, null, null);
INSERT INTO `t_base_user_info` VALUES ('7a29b9ab-0a56-449b-a4e6-3cbdac83736d', '温时君', '男', '温时君', '411082199408240637', '1994-08-24', '001003', '359099631', '18212345678', '主任', '硕士', null, null, null, null, null, null, null, null, null);
INSERT INTO `t_base_user_info` VALUES ('825893bd-4213-411d-af20-ade13cf75b98', '大乔', '女', '大乔', '73462758256783434', '1976-11-11', '001022', '123456', '13346574573', '员工', '本科', null, null, null, null, null, null, null, null, null);
INSERT INTO `t_base_user_info` VALUES ('8307693c-ca70-45d6-8c3c-faec71745da1', '张亚超', '男', '张亚超', '411082199411010637', '1994-11-22', '001011', '359099631', '18435155316', '厂长', '本科', null, null, null, null, null, null, null, '1', '1');
INSERT INTO `t_base_user_info` VALUES ('8c14d9d3-3dd9-4977-96bf-7fffc398f330', '宋江', '男', '宋江', '75458639575248524', '1977-08-16', '001032', '123456', '13346576683', '员工', '本科', null, null, null, null, null, null, null, null, null);
INSERT INTO `t_base_user_info` VALUES ('8d39016f-1fcb-48b0-9f74-5232d0e3c244', '张五', '男', '张五', '845582847343648696', '1985-12-17', '001011', '123456', '18724534658', '员工', '专科', null, null, null, null, null, null, null, null, null);
INSERT INTO `t_base_user_info` VALUES ('8e45ea91-1eb2-4f52-84de-ce807a2d4e68', '钱八', '男', '钱八', '48345873538437422', '1974-02-06', '001012', '123456', '18453725334', '员工', '本科', null, null, null, null, null, null, null, null, null);
INSERT INTO `t_base_user_info` VALUES ('91f489e2-12e2-47c7-9f96-f6cce419841f', '赵六', '男', '赵六', '84556478533638534X', '1982-08-12', '001031', '123456', '18724534969', '员工', '本科', null, null, null, null, null, null, null, null, null);
INSERT INTO `t_base_user_info` VALUES ('927a6466-f187-4e64-8ea4-721a2acf4da5', '赵七', '女', '赵七', '84556478534758534X', '1982-08-17', '001031', '123456', '18724535475', '员工', '本科', null, null, null, null, null, null, null, null, null);
INSERT INTO `t_base_user_info` VALUES ('99a3b98e-936d-4dc0-b563-fc16c7b1672d', '吴用', '男', '吴用', '75458633748728524', '1977-08-16', '001032', '123456', '13346575683', '员工', '本科', null, null, null, null, null, null, null, null, null);
INSERT INTO `t_base_user_info` VALUES ('9d2a2d9f-d8e0-4ab6-9ecc-0fd9a9e8dd39', '甘夫人', '女', '甘夫人', '73462758254354345', '1976-07-21', '001022', '123456', '13346577323', '班长', '博士', null, null, null, null, null, null, null, null, null);
INSERT INTO `t_base_user_info` VALUES ('9d64c132-6564-44cd-b2b2-dcc81effdeaa', '时迁', '男', '时迁', '75425454345248524', '1977-08-16', '001032', '123456', '13346577835', '员工', '本科', null, null, null, null, null, null, null, null, null);
INSERT INTO `t_base_user_info` VALUES ('9fba7713-0a40-473b-b40f-091374394517', '张七', '男', '张七', '845564785343486996', '1985-12-09', '001011', '123456', '18724535768', '员工', '专科', null, null, null, null, null, null, null, null, null);
INSERT INTO `t_base_user_info` VALUES ('a630617e-6f3a-4954-8344-d0a7780d333c', '王三', '男', '王三', '84556478474858584X', '1983-03-21', '001021', '123456', '18371203742', '员工', '博士', null, null, null, null, null, null, null, null, null);
INSERT INTO `t_base_user_info` VALUES ('a9ec48ff-d666-47a2-a8bf-dcafeea0330e', '张二', '男', '张二', '845238472658284734', '1985-12-05', '001011', '123456', '18594794543', '员工', '专科', null, null, null, null, null, null, null, null, null);
INSERT INTO `t_base_user_info` VALUES ('ac2728ae-a880-481e-9721-9f7d1cfab9c6', '乔磊', '男', '乔磊', '411082199408180637', '1994-08-18', '001011', '123456', '15212345678', '班长', '硕士', null, null, null, null, null, null, null, null, null);
INSERT INTO `t_base_user_info` VALUES ('b2ceda4f-6d74-459b-a1e9-05806958d681', '郭永鹏', '男', '郭永鹏', '411082199408240637', '1994-08-24', '001006', '123456', '18435155980', '厂长', '博士', null, null, null, null, null, null, null, null, null);
INSERT INTO `t_base_user_info` VALUES ('b43c9cee-cc87-4c33-8be9-e0567eaf8147', '张峰耀', '男', '张峰耀', '411082199411010637', '1994-12-02', '001005', '5963', '18435155963', '主任', '本科', null, null, null, null, null, null, null, null, null);
INSERT INTO `t_base_user_info` VALUES ('b685597d-3035-4b75-8ba0-777bd0953da8', '2', '男', '2', '411082199411010637', '2015-12-28', '001004', '123456', '18435155316', '厂长', '博士', null, null, null, null, null, null, null, null, null);
INSERT INTO `t_base_user_info` VALUES ('b7701e97-1e49-4c2f-a2a5-cdfa820b7a1c', '王六', '男', '王六', '84556374845375484X', '1983-06-10', '001021', '123456', '18371204832', '员工', '本科', null, null, null, null, null, null, null, null, null);
INSERT INTO `t_base_user_info` VALUES ('bfcf2ad3-5edf-4e19-825a-a47a84574ca4', '王五', '男', '王五', '84556478475375484X', '1983-06-10', '001021', '123456', '18371203853', '员工', '本科', null, null, null, null, null, null, null, null, null);
INSERT INTO `t_base_user_info` VALUES ('c5d7cdac-47fa-4866-be46-344f011f0ca9', '赵八', '男', '赵八', '84556478648396534X', '1983-01-23', '001031', '123456', '18724537586', '员工', '本科', null, null, null, null, null, null, null, null, null);
INSERT INTO `t_base_user_info` VALUES ('c6b6d8b7-bf21-4aaa-8846-ee8f439f337f', '孙尚香', '女', '孙尚香', '37257289753475734', '1979-07-04', '001022', '123456', '13346575754', '厂长', '硕士', null, null, null, null, null, null, null, null, null);
INSERT INTO `t_base_user_info` VALUES ('c933e9d5-a407-4aa8-90f0-9a9c317b2def', '钱九', '女', '钱九', '48345873538446237', '1974-02-06', '001012', '123456', '18453725734', '员工', '硕士', null, null, null, null, null, null, null, null, null);
INSERT INTO `t_base_user_info` VALUES ('ca81fa5e-e811-4a50-bfed-e317bbae7494', '王一', '男', '王一', '84556478648337584X', '1983-01-17', '001021', '123456', '18371204567', '班长', '硕士', null, null, null, null, null, null, null, null, null);
INSERT INTO `t_base_user_info` VALUES ('cf89aceb-010a-4478-8df9-5caa1abc800a', '丁英杰', '男', '丁英杰', '330825199408183719', '1994-08-18', '001022', '123456', '18435156270', '主任', '本科', null, null, null, null, null, null, null, null, null);
INSERT INTO `t_base_user_info` VALUES ('d9791b6a-686d-4e04-a0a4-090728e04420', '刘力瑄', '男', '刘力瑄', '411082199408180637', '1994-08-18', '001005', '123456', '18362570987', '主任', '博士', null, null, null, null, null, null, null, null, null);
INSERT INTO `t_base_user_info` VALUES ('da22659d-5752-4bd8-ac53-9b3ba5357323', '甄氏', '女', '甄氏', '34257283875823758', '1977-12-20', '001022', '123456', '13346574742', '员工', '硕士', null, null, null, null, null, null, null, null, null);
INSERT INTO `t_base_user_info` VALUES ('e6955664-d3fd-41eb-a7ec-7df67feba2a7', '赵五', '女', '赵五', '84556478533748634X', '1982-05-31', '001031', '123456', '18724538596', '员工', '本科', null, null, null, null, null, null, null, null, null);
INSERT INTO `t_base_user_info` VALUES ('f4182855-11cf-49bb-98f1-ca62b11d1c56', '张四', '男', '张四', '845238484658284734', '1985-12-17', '001011', '123456', '18724537890', '员工', '专科', null, null, null, null, null, null, null, null, null);
INSERT INTO `t_base_user_info` VALUES ('fe4e19b1-fc5a-4b4c-ba0f-d4bb864c8053', '赵二', '女', '赵二', '845564785344584936', '1985-08-27', '001031', '123456', '18724534563', '员工', '专科', null, null, null, null, null, null, null, null, null);
