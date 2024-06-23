# `article` 表

CREATE TABLE article (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    content TEXT NOT NULL,
    creator_id INT NOT NULL,
    column_id INT NOT NULL,
    cover_img VARCHAR(255),
    create_time DATETIME DEFAULT CURRENT_TIMESTAMP,
    status VARCHAR(1) DEFAULT '1',
    visit_count INT DEFAULT 0
) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;


# `column_table` 表

CREATE TABLE column_table (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    content TEXT,
    creator_id INT NOT NULL,
    cover_img VARCHAR(255),
    create_time DATETIME DEFAULT CURRENT_TIMESTAMP
) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;


# `comment` 表

CREATE TABLE comment (
    id INT AUTO_INCREMENT PRIMARY KEY,
    comment_topic_id INT NOT NULL,
    comment_user_id INT NOT NULL,
    content TEXT NOT NULL,
    type VARCHAR(1) NOT NULL,
    comment_time DATETIME DEFAULT CURRENT_TIMESTAMP,
    floor_count INT DEFAULT 0
) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;


# `favor` 表

CREATE TABLE favor (
    id INT AUTO_INCREMENT PRIMARY KEY,
    work_id INT NOT NULL,
    type VARCHAR(1) NOT NULL,
    user_id INT NOT NULL
) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;


# `topic` 表

CREATE TABLE topic (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    content TEXT NOT NULL,
    creator_id INT NOT NULL,
    create_time DATETIME DEFAULT CURRENT_TIMESTAMP,
    status VARCHAR(1) DEFAULT '1',
    visit_count INT DEFAULT 0
) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;


# `art` 表

CREATE TABLE art (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    author_id INT NOT NULL,
    create_time DATETIME DEFAULT CURRENT_TIMESTAMP,
    content TEXT NOT NULL,
    img_url VARCHAR(255),
    background_color VARCHAR(7),
    background_url VARCHAR(255)
) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;


# `thumbs` 表

CREATE TABLE thumbs (
    id INT AUTO_INCREMENT PRIMARY KEY,
    thumbs_topic_id INT NOT NULL,
    thumbs_user_id INT NOT NULL,
    type VARCHAR(1) NOT NULL
) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;


# `user` 表

CREATE TABLE user (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    avatar VARCHAR(255),
    introduction TEXT,
    role_id INT DEFAULT 1,
    state TINYINT(1) DEFAULT 0,
    rank INT DEFAULT 0
) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;


# `label` 表

CREATE TABLE label (
    id INT AUTO_INCREMENT PRIMARY KEY,
    label_name VARCHAR(255) NOT NULL
) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;


# `art_label` 表

CREATE TABLE art_label (
    id INT AUTO_INCREMENT PRIMARY KEY,
    art_id INT NOT NULL,
    label_id INT NOT NULL
) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

INSERT INTO user (username, password, email, avatar, introduction, role_id, state, rank) VALUES ('admin', 'admin', 'admin@admin.com', 'https://murlors.netlify.app/assets/avatar.jpg', 'admin', 3, 0, 0);
INSERT INTO user (username, password, email, avatar, introduction, role_id, state, rank) VALUES ('artist', 'artist', 'artist@artist.com', 'https://murlors.netlify.app/assets/avatar.jpg', 'artist', 2, 0, 0);
INSERT INTO user (username, password, email, avatar, introduction, role_id, state, rank) VALUES ('testuser', 'testuser', 'testuser@testuser.com', 'https://murlors.netlify.app/assets/avatar.jpg', 'testuser', 1, 0, 0);