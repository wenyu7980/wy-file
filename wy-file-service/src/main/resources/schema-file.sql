DROP TABLE IF EXISTS `wy_file_info`;

CREATE TABLE `wy_file_info`(
  `id` varchar(32) NOT NULL COMMENT '用户id',
  `filename` varchar(256) COMMENT '文件名',
  `bucket_name` varchar(256) COMMENT 'bucket名称',
  `public_flag` bit(1) default 0 COMMENT '是否公开',
  `created_date_time` datetime COMMENT '创建时间',
  primary key(`id`)
)
ENGINE=innodb DEFAULT CHARACTER SET utf8mb4
COMMENT '文件信息表';