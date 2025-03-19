CREATE
DATABASE IF NOT EXISTS `online_study` ;
USE
`online_study`;

DROP TABLE IF EXISTS `notification`;
DROP TABLE IF EXISTS `like`;
DROP TABLE IF EXISTS `favourite`;
DROP TABLE IF EXISTS `comment`;
DROP TABLE IF EXISTS `post`;
DROP TABLE IF EXISTS `post_category`;
DROP TABLE IF EXISTS `client_user`;
DROP TABLE IF EXISTS `admin_user`;

CREATE TABLE `admin_user`
(
    `id`          BIGINT      NOT NULL PRIMARY KEY COMMENT '时间戳唯一id',
    `name`        VARCHAR(32) COMMENT '用户名',
    `username`    VARCHAR(32) UNIQUE COMMENT '用户登录账号',
    `password`    VARCHAR(64) NOT NULL COMMENT '用户登录密码',
    `phone`       VARCHAR(15) UNIQUE COMMENT '用户手机',
    `gender`      CHAR(1) COMMENT '用户性别（M: 男，F: 女）',
    `status`      TINYINT DEFAULT 1 COMMENT '登录权限（1=可登录, 0=禁用）',
    `level`       TINYINT DEFAULT 0 COMMENT '修改权限（1=有权限, 0=无权限）'
    `create_time` DATETIME COMMENT '创建时间',
    `update_time` DATETIME COMMENT '更新时间',
    `create_user` BIGINT COMMENT '创建用户ID',
    `update_user` BIGINT COMMENT '更新用户ID',
) COMMENT='管理端用户表';

INSERT INTO `admin_user` (id, name, username, password, phone, gender, status, create_time, update_time, create_user,
                          update_user, level)
VALUES (11741666652149400, 'Admin', 'admin', 'e10adc3949ba59abbe56e057f20f883e', '15889925075', 'F', 1,
        '2025-03-11 12:15:21', '2025-03-11 12:15:21', 11741666213042300, 11741666213042300, 1);

CREATE TABLE `client_user`
(
    `id`          BIGINT      NOT NULL PRIMARY KEY COMMENT '时间戳唯一id',
    `name`        VARCHAR(32) COMMENT '用户名',
    `email`       VARCHAR(256) UNIQUE COMMENT '用户邮箱地址，同为登录账号',
    `password`    VARCHAR(64) NOT NULL COMMENT '用户登录密码',
    `gender`      CHAR(1) COMMENT '用户性别（M: 男，F: 女）',
    `status`      TINYINT      DEFAULT 1 COMMENT '使用权限（1=可登录, 0=禁用）',
    `avatar`      VARCHAR(500) DEFAULT NULL COMMENT '头像资源链接',
    `create_time` DATETIME COMMENT '创建时间',
    `update_time` DATETIME COMMENT '更新时间'
) COMMENT='客户端用户表';

INSERT INTO `client_user` (id, name, email, password, gender, status, avatar, create_time, update_time)
VALUES (2174169369495300, 'SamGoldSee', 'chunxin.huang@m.scnu.edu.cn', 'e10adc3949ba59abbe56e057f20f883e', 'M', 1, '',
        '2025-03-11 19:48:14', '2025-03-11 19:48:14');

CREATE TABLE `post_category`
(
    `id`   INT         NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT '帖子种类自增id',
    `name` VARCHAR(50) NOT NULL COMMENT '帖子种类'
)COMMENT = '帖子分类表';

INSERT INTO `post_category` (name)
VALUES ('其他'),
       ('组队'),
       ('教程'),
       ('笔记'),
       ('经验'),
       ('资源'),
       ('求助');

CREATE TABLE `post`
(
    `id`            BIGINT       NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT '帖子自增id',
    `user_id`       BIGINT       NOT NULL COMMENT 'C端用户id',
    `title`         VARCHAR(100) NOT NULL COMMENT '帖子标题',
    `content`       text COMMENT '帖子内容',
    `top`           TINYINT DEFAULT 0 COMMENT '置顶状态，0=普通，1=置顶',
    `pro`           TINYINT DEFAULT 0 COMMENT '加精状态，0=正常，1=精华',
    `is_deleted`    TINYINT DEFAULT 0 COMMENT '删除状态，0=正常，1=删除', -- 修改字段名
    `view_count`    INT     DEFAULT 0 COMMENT '浏览数',
    `like_count`    INT     DEFAULT 0 COMMENT '点赞数',
    `comment_count` INT     DEFAULT 0 COMMENT '评论数',
    `create_time`   DATETIME COMMENT '创建时间',
    `update_time`   DATETIME COMMENT '更新时间',
    `score` DOUBLE DEFAULT NULL COMMENT '热度系数',
    `category_id`   INT     DEFAULT 1 COMMENT '帖子种类id',
    FOREIGN KEY (user_id) REFERENCES `client_user` (id) ON DELETE CASCADE,
    FOREIGN KEY (category_id) REFERENCES `post_category` (id) ON DELETE SET NULL
) COMMENT ='帖子表';

INSERT INTO `post` (user_id, title, content, create_time, update_time)
VALUES (2174169369495300, '测试帖子', '测试内容', '2025-03-18 09:00:00', '2025-03-18 09:00:00');

CREATE TABLE `favourite`
(
    `id`          BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT '收藏id',
    `user_id`     BIGINT NOT NULL COMMENT '用户id',
    `post_id`     BIGINT NOT NULL COMMENT '帖子id',
    `create_time` DATETIME COMMENT '创建时间',
    `update_time` DATETIME COMMENT '更新时间',
    FOREIGN KEY (user_id) REFERENCES `client_user` (id) ON DELETE CASCADE,
    FOREIGN KEY (post_id) REFERENCES post (id) ON DELETE CASCADE,
    UNIQUE KEY unique_favourite (user_id, post_id) COMMENT '防止重复收藏'
) COMMENT = '收藏表';

CREATE TABLE `comment`
(
    `id`          BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT '评论id',
    `post_id`     BIGINT NOT NULL COMMENT '帖子id',
    `user_id`     BIGINT NOT NULL COMMENT '评论用户id',
    `parent_id`   BIGINT  DEFAULT NULL COMMENT '父评论id（回复评论）',
    `content`     TEXT   NOT NULL COMMENT '评论内容',
    `status`      TINYINT DEFAULT 0 COMMENT '状态（0=正常，1=删除）',
    `create_time` DATETIME COMMENT '创建时间',
    `update_time` DATETIME COMMENT '更新时间',
    FOREIGN KEY (post_id) REFERENCES post (id) ON DELETE CASCADE,
    FOREIGN KEY (user_id) REFERENCES `client_user` (id) ON DELETE CASCADE,
    FOREIGN KEY (parent_id) REFERENCES comment (id) ON DELETE CASCADE
) COMMENT ='评论表';

CREATE TABLE `like`
(
    `id`          BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT '点赞id',
    `user_id`     BIGINT NOT NULL COMMENT '点赞用户id',
    `post_id`     BIGINT DEFAULT NULL COMMENT '帖子id（点赞帖子时非空）',
    `comment_id`  BIGINT DEFAULT NULL COMMENT '评论id（点赞评论时非空）',
    `create_time` DATETIME COMMENT '创建时间',
    FOREIGN KEY (user_id) REFERENCES client_user (id) ON DELETE CASCADE,
    FOREIGN KEY (post_id) REFERENCES post (id) ON DELETE CASCADE,
    FOREIGN KEY (comment_id) REFERENCES comment (id) ON DELETE CASCADE,
    UNIQUE KEY unique_like_post (user_id, post_id) COMMENT '防止重复点赞帖子',
    UNIQUE KEY unique_like_comment (user_id, comment_id) COMMENT '防止重复点赞评论',
    CHECK (post_id IS NOT NULL OR comment_id IS NOT NULL)
)COMMENT ='点赞表';

CREATE TABLE `notification`
(
    `id`         BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT '通知id',
    `user_id`    BIGINT  NOT NULL COMMENT '接收用户id',
    `type`       TINYINT NOT NULL COMMENT '通知类型（1=点赞，2=评论，3=回复）',
    `source_id`  BIGINT  NOT NULL COMMENT '来源id（帖子id或评论id）',
    `is_read`    TINYINT DEFAULT 0 COMMENT '是否已读（0=未读，1=已读）',
    `comment_id` BIGINT  DEFAULT NULL COMMENT '评论id（回复评论时非空）',
    FOREIGN KEY (user_id) REFERENCES client_user (id) ON DELETE CASCADE,
    FOREIGN KEY (comment_id) REFERENCES comment (id) ON DELETE CASCADE
) COMMENT='通知表';