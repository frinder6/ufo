/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50613
Source Host           : localhost:3306
Source Database       : ufo

Target Server Type    : MYSQL
Target Server Version : 50613
File Encoding         : 65001

Date: 2016-12-04 11:16:07
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for ufo_dict_info
-- ----------------------------
DROP TABLE IF EXISTS `ufo_dict_info`;
CREATE TABLE `ufo_dict_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '标识列',
  `name` varchar(50) NOT NULL DEFAULT '' COMMENT '字典名称',
  `key` varchar(50) NOT NULL DEFAULT '' COMMENT '字典键',
  `value` varchar(50) NOT NULL DEFAULT '' COMMENT '字典值',
  `status` tinyint(1) NOT NULL DEFAULT '1' COMMENT '状态',
  `create_time` timestamp NOT NULL DEFAULT '1980-01-01 00:00:00' COMMENT '创建时间',
  `creater` varchar(50) NOT NULL DEFAULT 'sys' COMMENT '创建人',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `updater` varchar(50) NOT NULL DEFAULT 'sys' COMMENT '修改人',
  PRIMARY KEY (`id`),
  KEY `idx_dict_name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='表格信息表';

-- ----------------------------
-- Records of ufo_dict_info
-- ----------------------------
INSERT INTO `ufo_dict_info` VALUES ('1', 'status-combobox', '可用', 'true', '1', '1980-01-01 00:00:00', 'sys', '2016-11-27 16:33:52', 'sys');
INSERT INTO `ufo_dict_info` VALUES ('2', 'status-combobox', '禁用', 'false', '1', '1980-01-01 00:00:00', 'sys', '2016-12-04 11:11:24', 'sys');

-- ----------------------------
-- Table structure for ufo_grid_button_info
-- ----------------------------
DROP TABLE IF EXISTS `ufo_grid_button_info`;
CREATE TABLE `ufo_grid_button_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '标识列',
  `grid_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '表格id',
  `text` varchar(50) NOT NULL COMMENT '文本',
  `icon_cls` varchar(50) NOT NULL DEFAULT '' COMMENT '图标',
  `plain` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否隐藏文本',
  `disabled` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否禁用',
  `size` varchar(50) NOT NULL DEFAULT 'small' COMMENT '尺寸',
  `icon_align` varchar(50) NOT NULL DEFAULT 'left' COMMENT '图标位置',
  `width` int(11) NOT NULL DEFAULT '50' COMMENT '宽',
  `height` int(11) NOT NULL DEFAULT '30' COMMENT '高',
  `handler` varchar(500) NOT NULL DEFAULT '' COMMENT '操作',
  `status` tinyint(1) NOT NULL DEFAULT '1' COMMENT '状态',
  `create_time` timestamp NOT NULL DEFAULT '1980-01-01 00:00:00' COMMENT '创建时间',
  `creater` varchar(50) NOT NULL DEFAULT 'sys' COMMENT '创建人',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `updater` varchar(50) NOT NULL DEFAULT 'sys' COMMENT '修改人',
  PRIMARY KEY (`id`),
  KEY `idx_grid_id` (`grid_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COMMENT='表格事件操作表';

-- ----------------------------
-- Records of ufo_grid_button_info
-- ----------------------------
INSERT INTO `ufo_grid_button_info` VALUES ('1', '1', '搜索', ' icon-search', '0', '0', 'small', 'left', '60', '30', 'search', '1', '1980-01-01 00:00:00', 'sys', '2016-11-23 17:30:49', 'sys');
INSERT INTO `ufo_grid_button_info` VALUES ('2', '1', '新增', ' icon-add', '0', '0', 'small', 'left', '60', '30', 'insert', '1', '1980-01-01 00:00:00', 'sys', '2016-11-24 15:34:15', 'sys');
INSERT INTO `ufo_grid_button_info` VALUES ('3', '1', '更新', ' icon-edit', '0', '0', 'small', 'left', '60', '30', 'modify', '1', '1980-01-01 00:00:00', 'sys', '2016-11-24 18:54:26', 'sys');
INSERT INTO `ufo_grid_button_info` VALUES ('4', '1', '删除', ' icon-remove', '0', '0', 'small', 'left', '60', '30', 'remove', '1', '1980-01-01 00:00:00', 'sys', '2016-11-25 15:38:07', 'sys');
INSERT INTO `ufo_grid_button_info` VALUES ('5', '2', '搜索', ' icon-search', '0', '0', 'small', 'left', '60', '30', 'search', '1', '1980-01-01 00:00:00', 'sys', '2016-11-27 17:35:54', 'sys');
INSERT INTO `ufo_grid_button_info` VALUES ('6', '2', '新增', ' icon-add', '0', '0', 'small', 'left', '60', '30', 'insert', '1', '1980-01-01 00:00:00', 'sys', '2016-11-27 17:35:54', 'sys');
INSERT INTO `ufo_grid_button_info` VALUES ('7', '2', '更新', ' icon-edit', '0', '0', 'small', 'left', '60', '30', 'modify', '1', '1980-01-01 00:00:00', 'sys', '2016-11-27 17:35:54', 'sys');
INSERT INTO `ufo_grid_button_info` VALUES ('8', '2', '配置', ' icon-man', '0', '0', 'small', 'left', '60', '30', 'function f(){open2(\'window-column-setting?gridName=conf-grid-columns-info\', {width:900, height:600});}', '1', '1980-01-01 00:00:00', 'sys', '2016-12-02 17:52:55', 'sys');
INSERT INTO `ufo_grid_button_info` VALUES ('9', '5', '导入', ' icon-add', '0', '0', 'small', 'left', '60', '30', 'importC', '1', '1980-01-01 00:00:00', 'sys', '2016-11-30 16:09:27', 'sys');
INSERT INTO `ufo_grid_button_info` VALUES ('10', '6', '新增', ' icon-add', '0', '0', 'small', 'left', '60', '30', 'function f(){parent.open(\'window-column-setting?gridName=conf-table-columns-info\', {top:60, left:250, width:400, height:500});}', '1', '1980-01-01 00:00:00', 'sys', '2016-11-30 10:48:29', 'sys');
INSERT INTO `ufo_grid_button_info` VALUES ('11', '6', '删除', ' icon-remove', '0', '0', 'small', 'left', '60', '30', 'remove', '1', '1980-01-01 00:00:00', 'sys', '2016-11-29 16:50:12', 'sys');

-- ----------------------------
-- Table structure for ufo_grid_column_info
-- ----------------------------
DROP TABLE IF EXISTS `ufo_grid_column_info`;
CREATE TABLE `ufo_grid_column_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '标识列',
  `grid_id` bigint(20) NOT NULL COMMENT '表格id',
  `data_id` bigint(20) NOT NULL COMMENT '元数据id',
  `title` varchar(50) NOT NULL DEFAULT '' COMMENT '列标题',
  `field` varchar(50) NOT NULL DEFAULT '' COMMENT '列名称',
  `url` varchar(500) NOT NULL DEFAULT '' COMMENT '加载数据路径',
  `width` int(11) NOT NULL DEFAULT '50' COMMENT '尺寸',
  `rowspan` int(11) NOT NULL DEFAULT '0' COMMENT '合并列',
  `colspan` int(11) NOT NULL DEFAULT '0' COMMENT '合并单元格',
  `halign` varchar(50) NOT NULL DEFAULT '' COMMENT '垂直位置',
  `align` varchar(50) NOT NULL DEFAULT '' COMMENT '水平位置',
  `sortable` tinyint(1) NOT NULL DEFAULT '1' COMMENT '是否支持排序',
  `order` varchar(50) NOT NULL DEFAULT '' COMMENT '排序方式',
  `resizable` tinyint(1) NOT NULL DEFAULT '1' COMMENT '是否支持自适应',
  `fixed` tinyint(1) NOT NULL DEFAULT '1' COMMENT '是否锁定',
  `hidden` tinyint(1) NOT NULL DEFAULT '1' COMMENT '是否可见',
  `checkbox` tinyint(1) NOT NULL DEFAULT '1' COMMENT '是否多选',
  `frozen` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否冻结列',
  `formatter` varchar(500) NOT NULL DEFAULT '' COMMENT '扩展',
  `styler` varchar(500) NOT NULL DEFAULT '' COMMENT '自定义样式',
  `sorter` varchar(500) NOT NULL DEFAULT '' COMMENT '自定义排序',
  `editor` varchar(500) NOT NULL DEFAULT '' COMMENT '编辑类型规则',
  `type` varchar(50) NOT NULL DEFAULT 'text' COMMENT '类型',
  `value` varchar(50) NOT NULL DEFAULT '' COMMENT '默认值',
  `valid_type` varchar(50) NOT NULL DEFAULT '' COMMENT '验证类型',
  `required` tinyint(1) NOT NULL DEFAULT '1' COMMENT '是否必填',
  `searchable` tinyint(1) NOT NULL DEFAULT '1' COMMENT '是否可搜索',
  `insertable` tinyint(1) NOT NULL DEFAULT '1' COMMENT '是否可新增',
  `modifyable` tinyint(1) NOT NULL DEFAULT '1' COMMENT '是否可修改',
  `status` tinyint(1) NOT NULL DEFAULT '1' COMMENT '状态',
  `create_time` timestamp NOT NULL DEFAULT '1980-01-01 00:00:00' COMMENT '创建时间',
  `creater` varchar(50) NOT NULL DEFAULT 'sys' COMMENT '创建人',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `updater` varchar(50) NOT NULL DEFAULT 'sys' COMMENT '修改人',
  PRIMARY KEY (`id`),
  KEY `idx_name` (`field`),
  KEY `idx_title` (`title`),
  KEY `idx_grid_id` (`grid_id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8 COMMENT='表格列配置表';

-- ----------------------------
-- Records of ufo_grid_column_info
-- ----------------------------
INSERT INTO `ufo_grid_column_info` VALUES ('1', '1', '100', '标识列', 'id', '', '0', '0', '0', '', 'center', '1', '', '1', '1', '0', '1', '1', '', '', '', '', 'textbox', '', '', '1', '0', '0', '0', '1', '1980-01-01 00:00:00', 'sys', '2016-11-27 17:50:34', 'sys');
INSERT INTO `ufo_grid_column_info` VALUES ('2', '1', '90', '菜单名称', 'title', '', '100', '0', '0', '', 'left', '1', '', '1', '1', '0', '0', '1', '', '', '', '', 'textbox', '', '', '1', '1', '1', '1', '1', '1980-01-01 00:00:00', 'sys', '2016-11-27 17:50:23', 'sys');
INSERT INTO `ufo_grid_column_info` VALUES ('3', '1', '80', '状态', 'status', '\'dict/get.dict?name=status-combobox\',valueField:\'value\',textField:\'key\',panelHeight:\'auto\'', '50', '0', '0', '', 'center', '1', '', '1', '1', '0', '0', '0', 'function(v,r,i){return v?\'可用\':\'禁用\';}', '', '', '', 'combobox', '', '', '1', '1', '1', '1', '1', '1980-01-01 00:00:00', 'sys', '2016-11-27 17:50:40', 'sys');
INSERT INTO `ufo_grid_column_info` VALUES ('4', '1', '70', '创建时间', 'create_time', '', '150', '0', '0', '', 'center', '1', '', '1', '1', '0', '0', '0', '', '', '', '', 'datebox', '', '', '1', '0', '0', '0', '1', '1980-01-01 00:00:00', 'sys', '2016-11-27 17:50:44', 'sys');
INSERT INTO `ufo_grid_column_info` VALUES ('5', '1', '60', '修改时间', 'update_time', '', '150', '0', '0', '', 'center', '1', '', '1', '1', '0', '0', '0', '', '', '', '', 'datebox', '', '', '1', '0', '0', '0', '1', '1980-01-01 00:00:00', 'sys', '2016-11-27 17:50:48', 'sys');
INSERT INTO `ufo_grid_column_info` VALUES ('6', '1', '88', '父节点', 'parent_id', '\'menu/server.tree\'', '0', '0', '0', '', 'center', '1', '', '1', '1', '1', '0', '0', '', '', '', '', 'combotree', '', '', '1', '1', '1', '1', '1', '1980-01-01 00:00:00', 'sys', '2016-11-27 18:05:40', 'sys');
INSERT INTO `ufo_grid_column_info` VALUES ('7', '2', '90', '表格名称', 'name', '', '200', '0', '0', '', 'left', '1', '', '1', '1', '0', '0', '1', '', '', '', '', 'textbox', '', '', '1', '1', '1', '1', '1', '1980-01-01 00:00:00', 'sys', '2016-11-28 09:44:48', 'sys');
INSERT INTO `ufo_grid_column_info` VALUES ('8', '2', '80', '创建时间', 'create_time', '', '150', '0', '0', '', 'center', '1', '', '1', '1', '0', '0', '0', '', '', '', '', 'datebox', '', '', '1', '0', '0', '0', '1', '1980-01-01 00:00:00', 'sys', '2016-11-27 17:51:16', 'sys');
INSERT INTO `ufo_grid_column_info` VALUES ('9', '2', '70', '修改时间', 'update_time', '', '150', '0', '0', '', 'center', '1', '', '1', '1', '0', '0', '0', '', '', '', '', 'datebox', '', '', '1', '0', '0', '0', '1', '1980-01-01 00:00:00', 'sys', '2016-11-27 17:51:19', 'sys');
INSERT INTO `ufo_grid_column_info` VALUES ('10', '2', '88', '状态', 'status', '\'dict/get.dict?name=status-combobox\',valueField:\'value\',textField:\'key\',panelHeight:\'auto\'', '50', '0', '0', '', 'center', '1', '', '1', '1', '0', '0', '0', 'function(v,r,i){return v?\'可用\':\'禁用\';}', '', '', '', 'combobox', '', '', '1', '1', '1', '1', '1', '1980-01-01 00:00:00', 'sys', '2016-11-27 18:02:05', 'sys');
INSERT INTO `ufo_grid_column_info` VALUES ('11', '2', '100', '标识列', 'id', '', '0', '0', '0', '', 'center', '1', '', '1', '1', '0', '1', '1', '', '', '', '', 'textbox', '', '', '1', '0', '0', '0', '1', '1980-01-01 00:00:00', 'sys', '2016-11-27 18:02:00', 'sys');
INSERT INTO `ufo_grid_column_info` VALUES ('12', '4', '90', '表名', 'table_name', '', '100', '0', '0', '', 'left', '1', '', '1', '1', '0', '0', '1', '', '', '', '', 'textbox', '', '', '1', '1', '1', '1', '1', '1980-01-01 00:00:00', 'sys', '2016-11-27 22:19:06', 'sys');
INSERT INTO `ufo_grid_column_info` VALUES ('13', '4', '90', '表描述', 'table_comment', '', '100', '0', '0', '', 'left', '1', '', '1', '1', '0', '0', '1', '', '', '', '', 'textbox', '', '', '1', '1', '1', '1', '1', '1980-01-01 00:00:00', 'sys', '2016-11-27 22:20:02', 'sys');
INSERT INTO `ufo_grid_column_info` VALUES ('14', '5', '90', '列名', 'field', '', '100', '0', '0', '', 'left', '1', '', '1', '1', '0', '0', '1', '', '', '', '', 'textbox', '', '', '1', '1', '1', '1', '1', '1980-01-01 00:00:00', 'sys', '2016-11-28 20:45:13', 'sys');
INSERT INTO `ufo_grid_column_info` VALUES ('15', '5', '90', '列描述', 'title', '', '100', '0', '0', '', 'left', '1', '', '1', '1', '0', '0', '1', '', '', '', '', 'textbox', '', '', '1', '1', '1', '1', '1', '1980-01-01 00:00:00', 'sys', '2016-11-28 20:45:17', 'sys');
INSERT INTO `ufo_grid_column_info` VALUES ('16', '6', '90', '列名', 'field', '', '100', '0', '0', '', 'left', '1', '', '1', '1', '0', '0', '1', '', '', '', '', 'textbox', '', '', '1', '1', '1', '1', '1', '1980-01-01 00:00:00', 'sys', '2016-11-28 17:54:28', 'sys');
INSERT INTO `ufo_grid_column_info` VALUES ('17', '6', '90', '列描述', 'title', '', '100', '0', '0', '', 'left', '1', '', '1', '1', '0', '0', '1', '', '', '', '', 'textbox', '', '', '1', '1', '1', '1', '1', '1980-01-01 00:00:00', 'sys', '2016-11-28 17:54:33', 'sys');
INSERT INTO `ufo_grid_column_info` VALUES ('18', '5', '100', '标识列', 'id', '', '0', '0', '0', '', 'center', '1', '', '1', '1', '0', '1', '1', '', '', '', '', 'textbox', '', '', '1', '0', '0', '0', '1', '1980-01-01 00:00:00', 'sys', '2016-11-27 18:02:00', 'sys');
INSERT INTO `ufo_grid_column_info` VALUES ('19', '6', '100', '标识列', 'id', '', '0', '0', '0', '', 'center', '1', '', '1', '1', '0', '1', '1', '', '', '', '', 'textbox', '', '', '1', '0', '0', '0', '1', '1980-01-01 00:00:00', 'sys', '2016-11-30 10:06:33', 'sys');

-- ----------------------------
-- Table structure for ufo_grid_extend_info
-- ----------------------------
DROP TABLE IF EXISTS `ufo_grid_extend_info`;
CREATE TABLE `ufo_grid_extend_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '标识列',
  `grid_id` bigint(20) NOT NULL COMMENT '表格id',
  `url` varchar(50) NOT NULL DEFAULT '' COMMENT '加载数据路径',
  `add_url` varchar(50) NOT NULL DEFAULT '' COMMENT '新增数据路径',
  `remove_url` varchar(50) NOT NULL DEFAULT '' COMMENT '删除数据路径',
  `modify_url` varchar(50) NOT NULL DEFAULT '' COMMENT '更新数据路径',
  `fit_columns` tinyint(1) NOT NULL DEFAULT '1' COMMENT '是否自适应',
  `stripe` tinyint(1) NOT NULL DEFAULT '1' COMMENT '是否有网格',
  `nowrap` tinyint(1) NOT NULL DEFAULT '1' COMMENT '是否单行显示',
  `pagination` tinyint(1) NOT NULL DEFAULT '1' COMMENT '是否分页',
  `rownumbers` tinyint(1) NOT NULL DEFAULT '1' COMMENT '是否显示行号',
  `single_select` tinyint(1) NOT NULL DEFAULT '1' COMMENT '是否单选',
  `multi_sort` tinyint(1) NOT NULL DEFAULT '1' COMMENT '是否多列排序',
  `page_position` varchar(50) NOT NULL DEFAULT 'bottom' COMMENT '分页栏位置',
  `page_size` int(11) NOT NULL DEFAULT '50' COMMENT '默认显示记录数',
  `status` tinyint(1) NOT NULL DEFAULT '1' COMMENT '状态',
  `create_time` timestamp NOT NULL DEFAULT '1980-01-01 00:00:00' COMMENT '创建时间',
  `creater` varchar(50) NOT NULL DEFAULT 'sys' COMMENT '创建人',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `updater` varchar(50) NOT NULL DEFAULT 'sys' COMMENT '修改人',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_grid_id` (`grid_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COMMENT='表格配置信息表';

-- ----------------------------
-- Records of ufo_grid_extend_info
-- ----------------------------
INSERT INTO `ufo_grid_extend_info` VALUES ('1', '1', 'menu/page.menus', '', '', '', '1', '1', '1', '1', '1', '0', '0', 'bottom', '50', '1', '1980-01-01 00:00:00', 'sys', '2016-11-30 10:51:45', 'sys');
INSERT INTO `ufo_grid_extend_info` VALUES ('3', '2', 'grid/page.grids', '', '', '', '1', '1', '1', '1', '1', '0', '0', 'bottom', '50', '1', '1980-01-01 00:00:00', 'sys', '2016-11-30 10:51:43', 'sys');
INSERT INTO `ufo_grid_extend_info` VALUES ('4', '3', 'grid/page.columns', '', '', '', '1', '1', '1', '1', '1', '0', '0', 'bottom', '50', '1', '1980-01-01 00:00:00', 'sys', '2016-11-28 18:14:48', 'sys');
INSERT INTO `ufo_grid_extend_info` VALUES ('5', '4', 'grid/page.tables', '', '', '', '1', '1', '1', '0', '1', '1', '0', 'bottom', '50', '1', '1980-01-01 00:00:00', 'sys', '2016-11-30 10:47:08', 'sys');
INSERT INTO `ufo_grid_extend_info` VALUES ('7', '5', 'grid/page.table.columns', '', '', '', '1', '1', '1', '0', '1', '0', '0', 'bottom', '50', '1', '1980-01-01 00:00:00', 'sys', '2016-11-30 11:09:21', 'sys');
INSERT INTO `ufo_grid_extend_info` VALUES ('9', '6', 'grid/page.columns', '', '', '', '1', '1', '1', '1', '1', '0', '0', 'bottom', '50', '1', '1980-01-01 00:00:00', 'sys', '2016-11-30 10:50:21', 'sys');

-- ----------------------------
-- Table structure for ufo_grid_info
-- ----------------------------
DROP TABLE IF EXISTS `ufo_grid_info`;
CREATE TABLE `ufo_grid_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '标识列',
  `name` varchar(50) NOT NULL DEFAULT '' COMMENT '表格名称',
  `status` tinyint(1) NOT NULL DEFAULT '1' COMMENT '状态',
  `create_time` timestamp NOT NULL DEFAULT '1980-01-01 00:00:00' COMMENT '创建时间',
  `creater` varchar(50) NOT NULL DEFAULT 'sys' COMMENT '创建人',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `updater` varchar(50) NOT NULL DEFAULT 'sys' COMMENT '修改人',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_grid_name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='表格信息表';

-- ----------------------------
-- Records of ufo_grid_info
-- ----------------------------
INSERT INTO `ufo_grid_info` VALUES ('1', 'menu-info', '1', '1980-01-01 00:00:00', 'sys', '2016-11-20 20:15:22', 'sys');
INSERT INTO `ufo_grid_info` VALUES ('2', 'grid-info', '1', '1980-01-01 00:00:00', 'sys', '2016-11-20 20:15:22', 'sys');
INSERT INTO `ufo_grid_info` VALUES ('3', 'grid-columns-info', '1', '1980-01-01 00:00:00', 'sys', '2016-11-20 20:15:22', 'sys');
INSERT INTO `ufo_grid_info` VALUES ('4', 'conf-table-info', '1', '1980-01-01 00:00:00', 'sys', '2016-11-30 10:46:10', 'sys');
INSERT INTO `ufo_grid_info` VALUES ('5', 'conf-table-columns-info', '1', '1980-01-01 00:00:00', 'sys', '2016-11-30 10:49:07', 'sys');
INSERT INTO `ufo_grid_info` VALUES ('6', 'conf-grid-columns-info', '1', '1980-01-01 00:00:00', 'sys', '2016-11-30 10:49:14', 'sys');

-- ----------------------------
-- Table structure for ufo_log_info
-- ----------------------------
DROP TABLE IF EXISTS `ufo_log_info`;
CREATE TABLE `ufo_log_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '标识列',
  `host` varchar(50) NOT NULL DEFAULT '' COMMENT 'IP地址',
  `handler` varchar(50) NOT NULL DEFAULT '' COMMENT '操作人',
  `request_url` varchar(200) NOT NULL DEFAULT '' COMMENT '请求地址',
  `request_params` varchar(200) DEFAULT '' COMMENT '请求参数',
  `class_name` varchar(200) NOT NULL DEFAULT '' COMMENT '访问类',
  `method` varchar(200) NOT NULL DEFAULT '' COMMENT '访问方法',
  `method_params` text NOT NULL COMMENT '方法参数',
  `result` text COMMENT '返回结果',
  `error` text COMMENT '异常信息',
  `status` tinyint(1) NOT NULL DEFAULT '1' COMMENT '日志状态',
  `create_time` timestamp NOT NULL DEFAULT '1980-01-01 00:00:00' COMMENT '创建时间',
  `creater` varchar(50) NOT NULL DEFAULT 'sys' COMMENT '创建人',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `updater` varchar(50) NOT NULL DEFAULT 'sys' COMMENT '修改人',
  PRIMARY KEY (`id`),
  KEY `idx_url` (`request_url`),
  KEY `idx_class_name` (`class_name`),
  KEY `idx_method` (`method`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='日志信息表';

-- ----------------------------
-- Records of ufo_log_info
-- ----------------------------

-- ----------------------------
-- Table structure for ufo_menu_info
-- ----------------------------
DROP TABLE IF EXISTS `ufo_menu_info`;
CREATE TABLE `ufo_menu_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '标识列',
  `parent_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '父菜单',
  `title` varchar(50) NOT NULL DEFAULT '' COMMENT '菜单名称',
  `url` varchar(50) NOT NULL DEFAULT '' COMMENT '菜单路径',
  `icon` varchar(50) NOT NULL DEFAULT '' COMMENT '图标',
  `orderby` tinyint(4) NOT NULL DEFAULT '0' COMMENT '排序',
  `status` tinyint(1) NOT NULL DEFAULT '1' COMMENT '状态',
  `create_time` timestamp NOT NULL DEFAULT '1980-01-01 00:00:00' COMMENT '创建时间',
  `creater` varchar(50) NOT NULL DEFAULT 'sys' COMMENT '创建人',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `updater` varchar(50) NOT NULL DEFAULT 'sys' COMMENT '修改人',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_title` (`title`),
  KEY `idx_parent_id` (`parent_id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8 COMMENT='菜单信息表';

-- ----------------------------
-- Records of ufo_menu_info
-- ----------------------------
INSERT INTO `ufo_menu_info` VALUES ('1', '0', '根目录', '', '', '6', '1', '1980-01-01 00:00:00', 'sys', '2016-11-12 19:02:16', 'sys');
INSERT INTO `ufo_menu_info` VALUES ('2', '1', '系统管理', '', '', '6', '1', '1980-01-01 00:00:00', 'sys', '2016-11-12 19:02:16', 'sys');
INSERT INTO `ufo_menu_info` VALUES ('3', '1', '消息管理', '', '', '5', '1', '1980-01-01 00:00:00', 'sys', '2016-11-12 19:02:39', 'sys');
INSERT INTO `ufo_menu_info` VALUES ('4', '1', '库存管理', '', '', '1', '1', '1980-01-01 00:00:00', 'sys', '2016-11-12 19:02:39', 'sys');
INSERT INTO `ufo_menu_info` VALUES ('5', '1', '订单管理', '', '', '2', '1', '1980-01-01 00:00:00', 'sys', '2016-11-12 19:02:44', 'sys');
INSERT INTO `ufo_menu_info` VALUES ('6', '1', '档期管理', '', '', '3', '1', '1980-01-01 00:00:00', 'sys', '2016-11-12 19:02:44', 'sys');
INSERT INTO `ufo_menu_info` VALUES ('7', '1', '专场管理', '', '', '4', '1', '1980-01-01 00:00:00', 'sys', '2016-11-12 19:02:44', 'sys');
INSERT INTO `ufo_menu_info` VALUES ('8', '4', '物理库存', '', '', '1', '1', '1980-01-01 00:00:00', 'sys', '2016-11-12 19:02:53', 'sys');
INSERT INTO `ufo_menu_info` VALUES ('9', '4', '渠道库存', '', '', '2', '1', '1980-01-01 00:00:00', 'sys', '2016-11-12 19:02:53', 'sys');
INSERT INTO `ufo_menu_info` VALUES ('10', '4', '档期库存', '', '', '3', '1', '1980-01-01 00:00:00', 'sys', '2016-11-12 19:02:53', 'sys');
INSERT INTO `ufo_menu_info` VALUES ('11', '4', '专场库存', '', '', '4', '1', '1980-01-01 00:00:00', 'sys', '2016-11-12 19:02:53', 'sys');
INSERT INTO `ufo_menu_info` VALUES ('12', '8', '物理库存调整', '', '', '0', '1', '1980-01-01 00:00:00', 'sys', '2016-11-12 19:02:56', 'sys');
INSERT INTO `ufo_menu_info` VALUES ('13', '9', '渠道库存调整', '', '', '0', '1', '1980-01-01 00:00:00', 'sys', '2016-11-12 19:02:58', 'sys');
INSERT INTO `ufo_menu_info` VALUES ('14', '10', '档期库存调整', '', '', '0', '1', '1980-01-01 00:00:00', 'sys', '2016-11-12 19:03:01', 'sys');
INSERT INTO `ufo_menu_info` VALUES ('15', '11', '专场库存调整', '', '', '0', '1', '1980-01-01 00:00:00', 'sys', '2016-11-12 19:03:02', 'sys');
INSERT INTO `ufo_menu_info` VALUES ('16', '5', '订单占用', '', '', '1', '1', '1980-01-01 00:00:00', 'sys', '2016-11-12 19:03:08', 'sys');
INSERT INTO `ufo_menu_info` VALUES ('17', '5', '订单取消', '', '', '2', '1', '1980-01-01 00:00:00', 'sys', '2016-11-12 19:03:08', 'sys');
INSERT INTO `ufo_menu_info` VALUES ('18', '5', '订单出仓', '', '', '3', '1', '1980-01-01 00:00:00', 'sys', '2016-11-12 19:03:08', 'sys');
INSERT INTO `ufo_menu_info` VALUES ('19', '16', 'PL3订单占用', '', '', '1', '1', '1980-01-01 00:00:00', 'sys', '2016-11-12 19:03:13', 'sys');
INSERT INTO `ufo_menu_info` VALUES ('20', '16', 'SI订单占用', '', '', '2', '1', '1980-01-01 00:00:00', 'sys', '2016-11-12 19:03:13', 'sys');
INSERT INTO `ufo_menu_info` VALUES ('21', '16', 'BIBO订单占用', '', '', '3', '1', '1980-01-01 00:00:00', 'sys', '2016-11-12 19:03:13', 'sys');
INSERT INTO `ufo_menu_info` VALUES ('22', '16', 'JIT订单占用', '', '', '4', '1', '1980-01-01 00:00:00', 'sys', '2016-11-12 19:03:13', 'sys');
INSERT INTO `ufo_menu_info` VALUES ('24', '1', 'test21', '', '', '0', '1', '2016-11-25 14:28:41', 'sys', '2016-11-25 15:37:24', 'sys');
INSERT INTO `ufo_menu_info` VALUES ('25', '1', 'test3', '', '', '0', '1', '2016-11-25 14:29:33', 'sys', '2016-11-25 14:29:33', 'sys');
INSERT INTO `ufo_menu_info` VALUES ('26', '0', 'test11', '', '', '0', '1', '2016-11-25 14:30:35', 'sys', '2016-11-25 14:30:34', 'sys');

-- ----------------------------
-- Table structure for ufo_queue_info
-- ----------------------------
DROP TABLE IF EXISTS `ufo_queue_info`;
CREATE TABLE `ufo_queue_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '标识列',
  `queue_name` varchar(50) NOT NULL DEFAULT '' COMMENT '队列名称',
  `exchange_name` varchar(50) NOT NULL DEFAULT '' COMMENT '交换区名称',
  `routing_key` varchar(50) NOT NULL DEFAULT '' COMMENT '路由规则',
  `exchange_type` varchar(50) NOT NULL DEFAULT '' COMMENT '队列类型',
  `status` tinyint(1) NOT NULL DEFAULT '1' COMMENT '队列状态',
  `create_time` timestamp NOT NULL DEFAULT '1980-01-01 00:00:00' COMMENT '创建时间',
  `creater` varchar(50) NOT NULL DEFAULT 'sys' COMMENT '创建人',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `updater` varchar(50) NOT NULL DEFAULT 'sys' COMMENT '修改人',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_queue_name` (`queue_name`),
  KEY `idx_create_time` (`create_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='队列信息表';

-- ----------------------------
-- Records of ufo_queue_info
-- ----------------------------
