CREATE DATABASE IF NOT EXISTS cumt;


CREATE TABLE IF NOT EXISTS cumt.user_tb (
  id int auto_increment,
  username varchar(10) UNIQUE,
  password varchar(200) NOT NULL,
  email varchar(20) NOT NULL UNIQUE,
  is_superuser int,
  sex varchar(2),
  photo_url varchar(50),
  PRIMARY KEY (id)
) engine="innodb" DEFAULT charset="utf8";
