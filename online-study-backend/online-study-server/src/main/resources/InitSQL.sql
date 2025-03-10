CREATE
DATABASE IF NOT EXISTS `online_study` ;
USE
`online_study`;

CREATE
DATABASE IF NOT EXISTS `online_study`;
USE
`online_study`;

CREATE TABLE admin_user
(
    id          BIGINT      NOT NULL PRIMARY KEY COMMENT '时间戳唯一id',
    `name`      VARCHAR(32) COMMENT '用户名',
    username    VARCHAR(32) UNIQUE COMMENT '用户登录账号',
    `password`  VARCHAR(64) NOT NULL COMMENT '用户登录密码',
    phone       VARCHAR(15) UNIQUE COMMENT '用户手机',
    gender      CHAR(1) COMMENT '用户性别（M: 男，F: 女）',
    `status`    TINYINT DEFAULT 1 COMMENT '使用权限（1=可登录, 0=禁用）',
    create_time DATETIME COMMENT '创建时间',
    update_time DATETIME COMMENT '更新时间',
    create_user BIGINT COMMENT '创建用户ID',
    update_user BIGINT COMMENT '更新用户ID',
    `level`     TINYINT DEFAULT 0 COMMENT '是否有权限管理用户（1=有权限, 0=无权限）'
) COMMENT='管理员用户表';
