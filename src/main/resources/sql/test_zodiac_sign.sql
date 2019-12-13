create table zodiac_sign
(
    id          int(10) auto_increment
        primary key,
    zodiac_name varchar(255) null,
    ranking     int(10)      null
)
    charset = utf8;

INSERT INTO test.zodiac_sign (zodiac_name, ranking) VALUES ('鼠', 1);
INSERT INTO test.zodiac_sign (zodiac_name, ranking) VALUES ('牛', 2);
INSERT INTO test.zodiac_sign (zodiac_name, ranking) VALUES ('虎', 3);
INSERT INTO test.zodiac_sign (zodiac_name, ranking) VALUES ('兔', 4);
INSERT INTO test.zodiac_sign (zodiac_name, ranking) VALUES ('龙', 5);
INSERT INTO test.zodiac_sign (zodiac_name, ranking) VALUES ('蛇', 6);
INSERT INTO test.zodiac_sign (zodiac_name, ranking) VALUES ('马', 7);
INSERT INTO test.zodiac_sign (zodiac_name, ranking) VALUES ('羊', 8);
INSERT INTO test.zodiac_sign (zodiac_name, ranking) VALUES ('猴', 9);
INSERT INTO test.zodiac_sign (zodiac_name, ranking) VALUES ('鸡', 10);
INSERT INTO test.zodiac_sign (zodiac_name, ranking) VALUES ('狗', 11);
INSERT INTO test.zodiac_sign (zodiac_name, ranking) VALUES ('猪', 12);