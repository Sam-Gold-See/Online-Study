CREATE
DATABASE IF NOT EXISTS `online_study` ;
USE
`online_study`;

DROP TABLE IF EXISTS admin_user;
DROP TABLE IF EXISTS client_user;
DROP TABLE IF EXISTS post;
DROP TABLE IF EXISTS post_category;

CREATE TABLE admin_user
(
    id          BIGINT      NOT NULL PRIMARY KEY COMMENT '时间戳唯一id',
    `name`      VARCHAR(32) COMMENT '用户名',
    username    VARCHAR(32) UNIQUE COMMENT '用户登录账号',
    `password`  VARCHAR(64) NOT NULL COMMENT '用户登录密码',
    phone       VARCHAR(15) UNIQUE COMMENT '用户手机',
    gender      CHAR(1) COMMENT '用户性别（M: 男，F: 女）',
    `status`    TINYINT DEFAULT 1 COMMENT '登录权限（1=可登录, 0=禁用）',
    create_time DATETIME COMMENT '创建时间',
    update_time DATETIME COMMENT '更新时间',
    create_user BIGINT COMMENT '创建用户ID',
    update_user BIGINT COMMENT '更新用户ID',
    `level`     TINYINT DEFAULT 0 COMMENT '是否有权限管理B端用户（1=有权限, 0=无权限）'
) COMMENT='管理端用户表';

INSERT INTO admin_user (id, name, username, password, phone, gender, status, create_time, update_time, create_user,
                        update_user, level)
VALUES (11741666652149400, 'Admin', 'admin', 'e10adc3949ba59abbe56e057f20f883e', '15889925075', 'F', 1,
        '2025-03-11 12:15:21', '2025-03-11 12:15:21', 11741666213042300, 11741666213042300, 1);

CREATE TABLE client_user
(
    id          BIGINT      NOT NULL PRIMARY KEY COMMENT '时间戳唯一id',
    `name`      VARCHAR(32) COMMENT '用户名',
    email       VARCHAR(256) UNIQUE COMMENT '用户邮箱地址，同为登录账号',
    `password`  VARCHAR(64) NOT NULL COMMENT '用户登录密码',
    gender      CHAR(1) COMMENT '用户性别（M: 男，F: 女）',
    `status`    TINYINT DEFAULT 1 COMMENT '使用权限（1=可登录, 0=禁用）',
    avatar      VARCHAR(500) COMMENT '头像资源链接',
    create_time DATETIME COMMENT '创建时间',
    update_time DATETIME COMMENT '更新时间'
) COMMENT='客户端用户表';

INSERT INTO client_user (id, name, email, password, gender, status, avatar, create_time, update_time)
VALUES (2174169369495300, 'SamGoldSee', 'chunxin.huang@m.scnu.edu.cn', 'e10adc3949ba59abbe56e057f20f883e', 'M', 1, '',
        '2025-03-11 19:48:14', '2025-03-11 19:48:14');

CREATE TABLE post
(
    id          BIGINT       NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT '帖子自增id',
    user_id     BIGINT       NOT NULL COMMENT 'C端用户id',
    title       VARCHAR(100) NOT NULL COMMENT '帖子标题',
    content     text COMMENT '帖子内容',
    type        TINYINT DEFAULT 0 COMMENT '帖子类型，0=普通，1=置顶',
    status      INT     DEFAULT 0 COMMENT '帖子状态，0=正常，1=精华，2=拉黑',
    create_time DATETIME COMMENT '创建时间',
    update_time DATETIME COMMENT '更新时间',
    score DOUBLE DEFAULT NULL COMMENT '热度系数',
    category_id INT     DEFAULT 1 COMMENT '帖子种类id'
)COMMENT ='帖子数据表';

INSERT INTO post (user_id, title, content, create_time, update_time)
VALUES (2174169369495300, '测试帖子', '测试内容', '2025-03-18 09:00:00','2025-03-18 09:00:00');

CREATE TABLE post_category
(
    id   INT         NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT '帖子种类自增id',
    name VARCHAR(50) NOT NULL COMMENT '帖子种类'
)COMMENT = '帖子分类表';

INSERT INTO post_category (name)
VALUES ('其他'),
       ('组队'),
       ('教程'),
       ('笔记'),
       ('经验'),
       ('资源'),
       ('求助');