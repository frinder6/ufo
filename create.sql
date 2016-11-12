/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2016/11/12 17:00:53                          */
/*==============================================================*/


drop index idx_grid_id on ufo_grid_button_info;

drop table if exists ufo_grid_button_info;

drop index idx_title on ufo_grid_column_info;

drop index idx_name on ufo_grid_column_info;

drop table if exists ufo_grid_column_info;

drop index idx_grid_id on ufo_grid_extend_info;

drop table if exists ufo_grid_extend_info;

drop index idx_grid_name on ufo_grid_info;

drop table if exists ufo_grid_info;

drop table if exists ufo_grid_metadata_button_info;

drop index idx_name on ufo_grid_metadata_column_info;

drop index idx_title on ufo_grid_metadata_column_info;

drop table if exists ufo_grid_metadata_column_info;

drop index idx_method on ufo_log_info;

drop index idx_class_name on ufo_log_info;

drop index idx_url on ufo_log_info;

drop table if exists ufo_log_info;

drop index idx_parent_id on ufo_menu_info;

drop index idx_title on ufo_menu_info;

drop table if exists ufo_menu_info;

drop index idx_create_time on ufo_queue_info;

drop index idx_queue_name on ufo_queue_info;

drop table if exists ufo_queue_info;

/*==============================================================*/
/* Table: ufo_grid_button_info                                  */
/*==============================================================*/
create table ufo_grid_button_info
(
   id                   bigint not null auto_increment comment '标识列',
   grid_id              bigint not null default 0 comment '表格id',
   text                 varchar(50) not null comment '显示文本',
   title                varchar(50) not null default '' comment '气泡文本',
   img                  varchar(50) not null default '' comment '图标',
   type                 varchar(50) not null default 'button' comment '类型',
   action               varchar(50) not null default '' comment '动作',
   enable               tinyint not null default 1 comment '状态',
   create_time          timestamp not null default '1980-01-01' comment '创建时间',
   creater              varchar(50) not null default 'sys' comment '创建人',
   update_time          timestamp not null default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '修改时间',
   updater              varchar(50) not null default 'sys' comment '修改人',
   primary key (id)
);

alter table ufo_grid_button_info comment '表格事件操作表';

/*==============================================================*/
/* Index: idx_grid_id                                           */
/*==============================================================*/
create index idx_grid_id on ufo_grid_button_info
(
   grid_id
);

/*==============================================================*/
/* Table: ufo_grid_column_info                                  */
/*==============================================================*/
create table ufo_grid_column_info
(
   id                   bigint not null auto_increment comment '标识列',
   grid_id              bigint not null comment '表格id',
   data_id              bigint not null comment '元数据id',
   title                varchar(50) not null default '' comment '列标题',
   type                 varchar(50) not null default 'input' comment '列类型',
   name                 varchar(50) not null default '' comment '列名称',
   is_search            tinyint not null default 1 comment '是否可搜索',
   is_insert            tinyint not null default 1 comment '是否可新增',
   is_modify            tinyint not null default 1 comment '是否可修改',
   status               tinyint not null default 1 comment '状态',
   create_time          timestamp not null default '1980-01-01' comment '创建时间',
   creater              varchar(50) not null default 'sys' comment '创建人',
   update_time          timestamp not null default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '修改时间',
   updater              varchar(50) not null default 'sys' comment '修改人',
   primary key (id)
);

alter table ufo_grid_column_info comment '表格列配置表';

/*==============================================================*/
/* Index: idx_name                                              */
/*==============================================================*/
create index idx_name on ufo_grid_column_info
(
   name
);

/*==============================================================*/
/* Index: idx_title                                             */
/*==============================================================*/
create index idx_title on ufo_grid_column_info
(
   title
);

/*==============================================================*/
/* Table: ufo_grid_extend_info                                  */
/*==============================================================*/
create table ufo_grid_extend_info
(
   id                   bigint not null auto_increment comment '标识列',
   grid_id              bigint not null comment '表格id',
   image_path           varchar(100) not null default '' comment '图标路径',
   skin                 varchar(50) not null default '' comment '表格样式',
   paging_skin          varchar(50) not null default '' comment '分页样式',
   status               tinyint not null default 1 comment '状态',
   create_time          timestamp not null default '1980-01-01' comment '创建时间',
   creater              varchar(50) not null default 'sys' comment '创建人',
   update_time          timestamp not null default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '修改时间',
   updater              varchar(50) not null default 'sys' comment '修改人',
   primary key (id)
);

alter table ufo_grid_extend_info comment '表格配置信息表';

/*==============================================================*/
/* Index: idx_grid_id                                           */
/*==============================================================*/
create unique index idx_grid_id on ufo_grid_extend_info
(
   grid_id
);

/*==============================================================*/
/* Table: ufo_grid_info                                         */
/*==============================================================*/
create table ufo_grid_info
(
   id                   bigint not null auto_increment comment '标识列',
   grid_name            varchar(50) not null default '' comment '表格名称',
   status               tinyint not null default 1 comment '状态',
   create_time          timestamp not null default '1980-01-01' comment '创建时间',
   creater              varchar(50) not null default 'sys' comment '创建人',
   update_time          timestamp not null default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '修改时间',
   updater              varchar(50) not null default 'sys' comment '修改人',
   primary key (id)
);

alter table ufo_grid_info comment '表格信息表';

/*==============================================================*/
/* Index: idx_grid_name                                         */
/*==============================================================*/
create unique index idx_grid_name on ufo_grid_info
(
   grid_name
);

/*==============================================================*/
/* Table: ufo_grid_metadata_button_info                         */
/*==============================================================*/
create table ufo_grid_metadata_button_info
(
   id                   bigint not null auto_increment comment '标识列',
   text                 varchar(50) not null comment '显示文本',
   title                varchar(50) not null default '' comment '气泡文本',
   img                  varchar(50) not null default '' comment '图标',
   type                 varchar(50) not null default 'button' comment '类型',
   action               varchar(50) not null default '' comment '动作',
   enable               tinyint not null default 1 comment '状态',
   create_time          timestamp not null default '1980-01-01' comment '创建时间',
   creater              varchar(50) not null default 'sys' comment '创建人',
   update_time          timestamp not null default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '修改时间',
   updater              varchar(50) not null default 'sys' comment '修改人',
   primary key (id)
);

alter table ufo_grid_metadata_button_info comment '表格事件操作元数据表';

/*==============================================================*/
/* Table: ufo_grid_metadata_column_info                         */
/*==============================================================*/
create table ufo_grid_metadata_column_info
(
   id                   bigint not null auto_increment comment '标识列',
   title                varchar(50) not null default '' comment '列标题',
   name                 varchar(50) not null default '' comment '列名称',
   status               tinyint not null default 1 comment '状态',
   create_time          timestamp not null default '1980-01-01' comment '创建时间',
   creater              varchar(50) not null default 'sys' comment '创建人',
   update_time          timestamp not null default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '修改时间',
   updater              varchar(50) not null default 'sys' comment '修改人',
   primary key (id)
);

alter table ufo_grid_metadata_column_info comment '表格列配置元数据表';

/*==============================================================*/
/* Index: idx_title                                             */
/*==============================================================*/
create index idx_title on ufo_grid_metadata_column_info
(
   title
);

/*==============================================================*/
/* Index: idx_name                                              */
/*==============================================================*/
create unique index idx_name on ufo_grid_metadata_column_info
(
   name
);

/*==============================================================*/
/* Table: ufo_log_info                                          */
/*==============================================================*/
create table ufo_log_info
(
   id                   bigint not null auto_increment comment '标识列',
   host                 varchar(50) not null default '' comment 'IP地址',
   handler              varchar(50) not null default '' comment '操作人',
   request_url          varchar(200) not null default '' comment '请求地址',
   request_params       varchar(200) default '' comment '请求参数',
   class_name           varchar(200) not null default '' comment '访问类',
   method               varchar(200) not null default '' comment '访问方法',
   method_params        varchar(200) not null default '' comment '方法参数',
   result               text comment '返回结果',
   error                text comment '异常信息',
   status               tinyint not null default 1 comment '日志状态',
   create_time          timestamp not null default '1980-01-01' comment '创建时间',
   creater              varchar(50) not null default 'sys' comment '创建人',
   update_time          timestamp not null default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '修改时间',
   updater              varchar(50) not null default 'sys' comment '修改人',
   primary key (id)
);

alter table ufo_log_info comment '日志信息表';

/*==============================================================*/
/* Index: idx_url                                               */
/*==============================================================*/
create index idx_url on ufo_log_info
(
   request_url
);

/*==============================================================*/
/* Index: idx_class_name                                        */
/*==============================================================*/
create index idx_class_name on ufo_log_info
(
   class_name
);

/*==============================================================*/
/* Index: idx_method                                            */
/*==============================================================*/
create index idx_method on ufo_log_info
(
   method
);

/*==============================================================*/
/* Table: ufo_menu_info                                         */
/*==============================================================*/
create table ufo_menu_info
(
   id                   bigint not null auto_increment comment '标识列',
   parent_id            bigint not null default 0 comment '父菜单',
   title                varchar(50) not null default '' comment '菜单名称',
   url                  varchar(50) not null default '' comment '菜单路径',
   icon                 varchar(50) not null default '' comment '图标',
   sort                 tinyint not null default 0 comment '排序',
   status               tinyint not null default 1 comment '状态',
   create_time          timestamp not null default '1980-01-01' comment '创建时间',
   creater              varchar(50) not null default 'sys' comment '创建人',
   update_time          timestamp not null default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '修改时间',
   updater              varchar(50) not null default 'sys' comment '修改人',
   primary key (id)
);

alter table ufo_menu_info comment '菜单信息表';

/*==============================================================*/
/* Index: idx_title                                             */
/*==============================================================*/
create unique index idx_title on ufo_menu_info
(
   title
);

/*==============================================================*/
/* Index: idx_parent_id                                         */
/*==============================================================*/
create index idx_parent_id on ufo_menu_info
(
   parent_id
);

/*==============================================================*/
/* Table: ufo_queue_info                                        */
/*==============================================================*/
create table ufo_queue_info
(
   id                   bigint not null auto_increment comment '标识列',
   queue_name           varchar(50) not null default '' comment '队列名称',
   exchange_name        varchar(50) not null default '' comment '交换区名称',
   routing_key          varchar(50) not null default '' comment '路由规则',
   exchange_type        varchar(50) not null default '' comment '队列类型',
   status               tinyint not null default 1 comment '队列状态',
   create_time          timestamp not null default '1980-01-01' comment '创建时间',
   creater              varchar(50) not null default 'sys' comment '创建人',
   update_time          timestamp not null default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '修改时间',
   updater              varchar(50) not null default 'sys' comment '修改人',
   primary key (id)
);

alter table ufo_queue_info comment '队列信息表';

/*==============================================================*/
/* Index: idx_queue_name                                        */
/*==============================================================*/
create unique index idx_queue_name on ufo_queue_info
(
   queue_name
);

/*==============================================================*/
/* Index: idx_create_time                                       */
/*==============================================================*/
create index idx_create_time on ufo_queue_info
(
   create_time
);
