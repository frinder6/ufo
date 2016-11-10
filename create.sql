/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2016/11/10 9:22:37                           */
/*==============================================================*/


drop table if exists ufo_button_metadata_info;

drop index idx_grid_id on ufo_grid_button_info;

drop table if exists ufo_grid_button_info;

drop index idx_title on ufo_grid_column_info;

drop index idx_name on ufo_grid_column_info;

drop table if exists ufo_grid_column_info;

drop index idx_grid_id on ufo_grid_extend_info;

drop table if exists ufo_grid_extend_info;

drop index idx_grid_name on ufo_grid_info;

drop table if exists ufo_grid_info;

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
/* Table: ufo_button_metadata_info                              */
/*==============================================================*/
create table ufo_button_metadata_info
(
   id                   bigint not null auto_increment,
   text                 varchar(50) not null,
   title                varchar(50) not null default '',
   img                  varchar(50) not null default '',
   type                 varchar(50) not null default 'button',
   action               varchar(50) not null default '',
   enable               tinyint not null default 1,
   create_time          timestamp not null default '1980-01-01',
   creater              varchar(50) not null default 'sys',
   update_time          timestamp not null default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
   updater              varchar(50) not null default 'sys',
   primary key (id)
);

/*==============================================================*/
/* Table: ufo_grid_button_info                                  */
/*==============================================================*/
create table ufo_grid_button_info
(
   id                   bigint not null auto_increment,
   grid_id              bigint not null default 0,
   text                 varchar(50) not null,
   title                varchar(50) not null default '',
   img                  varchar(50) not null default '',
   type                 varchar(50) not null default 'button',
   action               varchar(50) not null default '',
   enable               tinyint not null default 1,
   create_time          timestamp not null default '1980-01-01',
   creater              varchar(50) not null default 'sys',
   update_time          timestamp not null default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
   updater              varchar(50) not null default 'sys',
   primary key (id)
);

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
   id                   bigint not null auto_increment,
   grid_id              bigint not null,
   data_id              bigint not null,
   title                varchar(50) not null default '',
   name                 varchar(50) not null default '',
   is_search            tinyint not null default 1 comment '是否可搜索
            1 是
            0 否',
   is_insert            tinyint not null default 1,
   is_modify            tinyint not null default 1,
   status               tinyint not null default 1,
   create_time          timestamp not null default '1980-01-01',
   creater              varchar(50) not null default 'sys',
   update_time          timestamp not null default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
   updater              varchar(50) not null default 'sys',
   primary key (id)
);

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
   id                   bigint not null auto_increment,
   grid_id              bigint not null,
   image_path           varchar(100) not null default '',
   skin                 varchar(50) not null default '',
   paging_skin          varchar(50) not null default '',
   status               tinyint not null default 1,
   create_time          timestamp not null default '1980-01-01',
   creater              varchar(50) not null default 'sys',
   update_time          timestamp not null default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
   updater              varchar(50) not null default 'sys',
   primary key (id)
);

alter table ufo_grid_extend_info comment '表格配置信息表，列配置另外，保存其它配置，如skin、pagingSkin等';

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
   id                   bigint not null auto_increment,
   grid_name            varchar(50) not null default '',
   status               tinyint not null default 1,
   create_time          timestamp not null default '1980-01-01',
   creater              varchar(50) not null default 'sys',
   update_time          timestamp not null default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
   updater              varchar(50) not null default 'sys',
   primary key (id)
);

/*==============================================================*/
/* Index: idx_grid_name                                         */
/*==============================================================*/
create unique index idx_grid_name on ufo_grid_info
(
   grid_name
);

/*==============================================================*/
/* Table: ufo_grid_metadata_column_info                         */
/*==============================================================*/
create table ufo_grid_metadata_column_info
(
   id                   bigint not null auto_increment,
   title                varchar(50) not null default '',
   name                 varchar(50) not null default '',
   status               tinyint not null default 1,
   create_time          timestamp not null default '1980-01-01',
   creater              varchar(50) not null default 'sys',
   update_time          timestamp not null default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
   updater              varchar(50) not null default 'sys',
   primary key (id)
);

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
   id                   bigint not null auto_increment,
   host                 varchar(50) not null default '',
   handler              varchar(50) not null default '',
   request_url          varchar(200) not null default '',
   request_params       varchar(200) default '',
   class_name           varchar(200) not null default '',
   method               varchar(200) not null default '',
   method_params        varchar(200) not null default '',
   result               text,
   error                text,
   status               tinyint not null default 1,
   create_time          timestamp not null default '1980-01-01',
   creater              varchar(50) not null default 'sys',
   update_time          timestamp not null default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
   updater              varchar(50) not null default 'sys',
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
   id                   bigint not null auto_increment,
   parent_id            bigint not null default 0,
   title                varchar(50) not null default '',
   url                  varchar(50) not null default '',
   icon                 varchar(50) not null default '',
   sort                 tinyint not null default 0,
   status               tinyint not null default 1,
   create_time          timestamp not null default '1980-01-01',
   creater              varchar(50) not null default 'sys',
   update_time          timestamp not null default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
   updater              varchar(50) not null default 'sys',
   primary key (id)
);

alter table ufo_menu_info comment '菜单信息表
';

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
   id                   bigint not null auto_increment,
   queue_name           varchar(50) not null default '',
   exchange_name        varchar(50) not null default '',
   routing_key          varchar(50) not null default '',
   exchange_type        varchar(50) not null default '',
   status               tinyint not null default 1,
   create_time          timestamp not null default '1980-01-01',
   creater              varchar(50) not null default 'sys',
   update_time          timestamp not null default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
   updater              varchar(50) not null default 'sys',
   primary key (id)
);

alter table ufo_queue_info comment '队列信息表
';

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
