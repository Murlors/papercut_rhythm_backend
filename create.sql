# `article` 表

CREATE TABLE article
(
    id          INT AUTO_INCREMENT PRIMARY KEY,
    title       VARCHAR(255) NOT NULL,
    content     TEXT         NOT NULL,
    creator_id  INT          NOT NULL,
    column_id   INT          NOT NULL,
    cover_img   VARCHAR(255),
    create_time DATETIME   DEFAULT CURRENT_TIMESTAMP,
    status      VARCHAR(1) DEFAULT '1',
    visit_count INT        DEFAULT 0
) CHARACTER SET utf8mb4
  COLLATE utf8mb4_unicode_ci;


# `column_table` 表

CREATE TABLE column_table
(
    id          INT AUTO_INCREMENT PRIMARY KEY,
    title       VARCHAR(255) NOT NULL,
    content     TEXT,
    creator_id  INT          NOT NULL,
    cover_img   VARCHAR(255),
    create_time DATETIME DEFAULT CURRENT_TIMESTAMP
) CHARACTER SET utf8mb4
  COLLATE utf8mb4_unicode_ci;


# `comment` 表

CREATE TABLE comment
(
    id               INT AUTO_INCREMENT PRIMARY KEY,
    comment_topic_id INT        NOT NULL,
    comment_user_id  INT        NOT NULL,
    content          TEXT       NOT NULL,
    type             VARCHAR(1) NOT NULL,
    comment_time     DATETIME DEFAULT CURRENT_TIMESTAMP,
    floor_count      INT      DEFAULT 0
) CHARACTER SET utf8mb4
  COLLATE utf8mb4_unicode_ci;


# `favor` 表

CREATE TABLE favor
(
    id      INT AUTO_INCREMENT PRIMARY KEY,
    work_id INT        NOT NULL,
    type    VARCHAR(1) NOT NULL,
    user_id INT        NOT NULL
) CHARACTER SET utf8mb4
  COLLATE utf8mb4_unicode_ci;


# `topic` 表

CREATE TABLE topic
(
    id          INT AUTO_INCREMENT PRIMARY KEY,
    title       VARCHAR(255) NOT NULL,
    content     TEXT         NOT NULL,
    creator_id  INT          NOT NULL,
    create_time DATETIME   DEFAULT CURRENT_TIMESTAMP,
    status      VARCHAR(1) DEFAULT '1',
    visit_count INT        DEFAULT 0
) CHARACTER SET utf8mb4
  COLLATE utf8mb4_unicode_ci;


# `art` 表

CREATE TABLE art
(
    id               INT AUTO_INCREMENT PRIMARY KEY,
    title            VARCHAR(255) NOT NULL,
    author_id        INT          NOT NULL,
    create_time      DATETIME DEFAULT CURRENT_TIMESTAMP,
    content          TEXT         NOT NULL,
    img_url          VARCHAR(255),
    background_color VARCHAR(7),
    background_url   VARCHAR(255)
) CHARACTER SET utf8mb4
  COLLATE utf8mb4_unicode_ci;


# `thumbs` 表

CREATE TABLE thumbs
(
    id              INT AUTO_INCREMENT PRIMARY KEY,
    thumbs_topic_id INT        NOT NULL,
    thumbs_user_id  INT        NOT NULL,
    type            VARCHAR(1) NOT NULL
) CHARACTER SET utf8mb4
  COLLATE utf8mb4_unicode_ci;


# `user` 表

CREATE TABLE user
(
    id           INT AUTO_INCREMENT PRIMARY KEY,
    username     VARCHAR(255) NOT NULL UNIQUE,
    password     VARCHAR(255) NOT NULL,
    email        VARCHAR(255) NOT NULL,
    avatar       VARCHAR(255),
    introduction TEXT,
    role_id      INT        DEFAULT 1,
    state        TINYINT(1) DEFAULT 0,
    rank         INT        DEFAULT 0
) CHARACTER SET utf8mb4
  COLLATE utf8mb4_unicode_ci;


# `label` 表

CREATE TABLE label
(
    id         INT AUTO_INCREMENT PRIMARY KEY,
    label_name VARCHAR(255) NOT NULL
) CHARACTER SET utf8mb4
  COLLATE utf8mb4_unicode_ci;


# `art_label` 表

CREATE TABLE art_label
(
    id       INT AUTO_INCREMENT PRIMARY KEY,
    art_id   INT NOT NULL,
    label_id INT NOT NULL
) CHARACTER SET utf8mb4
  COLLATE utf8mb4_unicode_ci;

INSERT INTO `art`
VALUES (1, '十二生肖——虎', 2, '2024-06-24 16:24:22', '虎',
        'https://pic.chaopx.com/chao_origin_pic/20/24/01/07ddfadf4c6016912bf61b37ef953d50.png', NULL, NULL),
       (2, '十二生肖——兔', 2, '2024-06-24 16:25:33', '兔',
        'https://png.pngtree.com/png-clipart/20221020/ourmid/pngtree-year-of-the-rabbit-paper-cut-window-flowers-png-image_6365802.png',
        NULL, NULL);

INSERT INTO `article`
VALUES (1, '剪纸的艺术',
        '<p><span style=\"color: rgb(51, 51, 51); background-color: rgb(255, 255, 255); font-size: 14px;\">中国剪纸是一种用剪刀或刻刀在纸上剪刻花纹，用于装点生活或配合其他民俗活动的民间艺术。在中国，剪纸具有广泛的群众基础，交融于各族人民的社会生活，是各种民俗活动的重要组成部分。其传承赓续的视觉形象和造型格式，蕴涵了丰富的文化历史信息，表达了广大民众的社会认知、道德观念、实践经验、生活理想和审美情趣，具有认知、教化、表意、抒情、娱乐、交往等多重社会价值。</span></p>',
        2, 1, 'https://s2.loli.net/2024/06/24/VZwOjtxpAvg69Yf.png', '2024-06-24 16:15:34', '1', 3);

INSERT INTO `column_table`
VALUES (1, '剪纸的艺术', '一起学习剪纸的艺术', 2, 'https://s2.loli.net/2024/06/24/4pgQwqdIBY9SP8u.png',
        '2024-06-24 16:11:59');

INSERT INTO `favor`
VALUES (1, 1, '0', 2);

INSERT INTO `topic`
VALUES (1, '剪纸的艺术', '一起学习剪纸的艺术', 2, '2024-06-24 16:13:17', '1', 4),
       (2, 'hhhh', 'hhhh', 2, '2024-06-24 22:58:35', '1', 1);

INSERT INTO `user`
VALUES (1, 'admin', 'admin', 'admin@admin.com', 'https://murlors.netlify.app/assets/avatar.jpg', 'admin', 3, 0, 0),
       (2, 'artist', 'artist', 'artist@artist.com', 'https://murlors.netlify.app/assets/avatar.jpg', 'artist', 2, 0, 0),
       (3, 'testuser', 'testuser', 'testuser@testuser.com', 'https://murlors.netlify.app/assets/avatar.jpg', 'testuser',
        1, 0, 0),
       (4, 'cyyy', '123456', '3068670643@qq.com', NULL, NULL, 2, 0, 0),
       (5, 'hlt', '123456', '1595258509@qq.com', NULL, NULL, 2, 0, 0);
