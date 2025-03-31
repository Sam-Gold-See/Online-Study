INSERT INTO `admin_user` (id, name, username, password, phone, gender, status, create_time, update_time, create_user,
                          update_user, level)
VALUES (11741666652149400, 'Admin', 'admin', 'e10adc3949ba59abbe56e057f20f883e', '15889925075', 'F', 1,
        '2025-03-11 12:15:21', '2025-03-11 12:15:21', 11741666213042300, 11741666213042300, 1);

INSERT INTO `client_user` (id, name, email, password, gender, status, avatar, create_time, update_time)
VALUES (2174169369495300, 'SamGoldSee', 'chunxin.huang@m.scnu.edu.cn', 'e10adc3949ba59abbe56e057f20f883e', 'M', 1, '',
        '2025-03-11 19:48:14', '2025-03-11 19:48:14');

INSERT INTO `client_user` (id, name, email, password, gender, status, avatar, create_time, update_time)
VALUES (2174169369495400, 'HCX', '2377043893@qq.com', 'e10adc3949ba59abbe56e057f20f883e', 'M', 1, '',
        '2025-03-11 19:48:14', '2025-03-11 19:48:14');

INSERT INTO `post_category` (name)
VALUES ('其他'),
       ('组队'),
       ('教程'),
       ('笔记'),
       ('经验'),
       ('资源'),
       ('求助');

INSERT INTO `post` (user_id, title, content, create_time, update_time)
VALUES (2174169369495300, 'testSGS1', 'TestContent', '2025-03-11 19:48:14', '2025-03-11 19:48:14');

INSERT INTO `post` (user_id, title, content, create_time, update_time)
VALUES (2174169369495300, 'testSGS2', 'TestContent', '2025-03-11 19:48:14', '2025-03-11 19:48:14');

INSERT INTO `post` (user_id, title, content, create_time, update_time)
VALUES (2174169369495300, 'testHCX1', 'TestContent', '2025-03-11 19:48:14', '2025-03-11 19:48:14');
