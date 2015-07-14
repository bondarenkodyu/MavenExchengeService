
CREATE DATABASE exchange_service;
USE exchange_service;

CREATE TABLE IF NOT EXISTS user
(
    id SERIAL,
    first_name VARCHAR(30) NOT NULL,
    middle_name VARCHAR(40) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    birthday DATE,
    registration_date TIMESTAMP,
    sex VARCHAR(1),
    is_bitcoin TINYINT(1),
    is_yandex_money TINYINT(1),
    is_webmoney_eur TINYINT(1),
    is_webmoney_usd TINYINT(1),
    is_webmoney_uah TINYINT(1),
    is_webmoney_rur TINYINT(1),
    PRIMARY KEY(id)

)ENGINE InnoDB CHARACTER SET utf8;






CREATE TABLE IF NOT EXISTS bitcoin  (
    id SERIAL,
    user_id BIGINT UNSIGNED NOT NULL,
    amount DECIMAL(7,6)  NOT NULL,
    PRIMARY KEY(id),
    FOREIGN KEY(user_id)
    REFERENCES user(id)
        ON DELETE CASCADE ON UPDATE CASCADE
)ENGINE InnoDB CHARACTER SET utf8;



CREATE TABLE IF NOT EXISTS yandex_money (
    id SERIAL,
    user_id BIGINT UNSIGNED NOT NULL,
    amount DECIMAL(7,6)  NOT NULL,
    PRIMARY KEY(id),
    FOREIGN KEY(user_id)
    REFERENCES user(id)
        ON DELETE CASCADE ON UPDATE CASCADE
)ENGINE InnoDB CHARACTER SET utf8;



CREATE TABLE IF NOT EXISTS webmoney_eur (
    id SERIAL,
    user_id BIGINT UNSIGNED NOT NULL,
    amount DECIMAL(7,6)  NOT NULL,
    PRIMARY KEY(id),
    FOREIGN KEY(user_id)
    REFERENCES user(id)
        ON DELETE CASCADE ON UPDATE CASCADE
)ENGINE InnoDB CHARACTER SET utf8;


CREATE TABLE IF NOT EXISTS webmoney_uah (
    id SERIAL,
    user_id BIGINT UNSIGNED NOT NULL,
    amount DECIMAL(7,6)  NOT NULL,
    PRIMARY KEY(id),
    FOREIGN KEY(user_id)
    REFERENCES user(id)
        ON DELETE CASCADE ON UPDATE CASCADE
)ENGINE InnoDB CHARACTER SET utf8;


CREATE TABLE IF NOT EXISTS webmoney_usd (
    id SERIAL,
    user_id BIGINT UNSIGNED NOT NULL,
    amount DECIMAL(7,6) NOT NULL,
    PRIMARY KEY(id),
    FOREIGN KEY(user_id)
    REFERENCES user(id)
        ON DELETE CASCADE ON UPDATE CASCADE
)ENGINE InnoDB CHARACTER SET utf8;


CREATE TABLE IF NOT EXISTS webmoney_rur (
    id SERIAL,
    user_id BIGINT UNSIGNED NOT NULL,
    amount DECIMAL(7,6)  NOT NULL,
    PRIMARY KEY(id),
    FOREIGN KEY(user_id)
    REFERENCES user(id)
        ON DELETE CASCADE ON UPDATE CASCADE
)ENGINE InnoDB CHARACTER SET utf8;


CREATE TABLE IF NOT EXISTS transaction (
    id SERIAL,
    date_of_tr TIMESTAMP  NOT NULL,
    user_from_id BIGINT  NOT NULL,
    user_from_numb BIGINT  NOT NULL,
    user_to_id BIGINT  NOT NULL,
    user_to_numb BIGINT  NOT NULL,
    summa DECIMAL(7,6)   NOT NULL,
    rec VARCHAR(100)  NOT NULL,
    PRIMARY KEY(id)
)ENGINE InnoDB CHARACTER SET utf8;







