CREATE DATABASE IF NOT EXISTS spotyweb;

USE spotyweb;

CREATE TABLE IF NOT EXISTS comments (
    id INT AUTO_INCREMENT PRIMARY KEY,
    song VARCHAR(255),
    artist VARCHAR(255),
    username VARCHAR(100),
    comment TEXT
);
