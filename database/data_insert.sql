drop database if exists sustc_test;
create database sustc_test;
-- 建库脚本
use sustc_test;
-- 切换数据库

drop table if exists Lecture;
create table Lecture
    (title          varchar(300),
     link           varchar(100),
     speaker        varchar(20),
     lecture_date   date,
     department     varchar(20),
     venue          varchar(50),
     id             int auto_increment,
     primary key (id));
-- 建表脚本

load data local infile 'C:\\Users\\YYJ\\Desktop\\pro\\innovation\\SUSTech_2019_Spring_CS322-master\\BIO.csv' 
into table sustc_test.Lecture character set utf8
fields terminated by ',' optionally enclosed by "'" escaped by "'" 
lines terminated by '\r\n';
-- 导入数据

load data local infile 'C:\\Users\\YYJ\\Desktop\\pro\\innovation\\SUSTech_2019_Spring_CS322-master\\BME.csv' 
into table sustc_test.Lecture character set utf8
fields terminated by ',' optionally enclosed by "'" escaped by "'" 
lines terminated by '\r\n';

load data local infile 'C:\\Users\\YYJ\\Desktop\\pro\\innovation\\SUSTech_2019_Spring_CS322-master\\Chemistry.csv' 
into table sustc_test.Lecture character set utf8
fields terminated by ',' optionally enclosed by "'" escaped by "'" 
lines terminated by '\r\n';

load data local infile 'C:\\Users\\YYJ\\Desktop\\pro\\innovation\\SUSTech_2019_Spring_CS322-master\\CSE.csv' 
into table sustc_test.Lecture character set utf8
fields terminated by ',' optionally enclosed by "'" escaped by "'" 
lines terminated by '\r\n';

load data local infile 'C:\\Users\\YYJ\\Desktop\\pro\\innovation\\SUSTech_2019_Spring_CS322-master\\EE.csv' 
into table sustc_test.Lecture character set utf8
fields terminated by ',' optionally enclosed by "'" escaped by "'" 
lines terminated by '\r\n';

load data local infile 'C:\\Users\\YYJ\\Desktop\\pro\\innovation\\SUSTech_2019_Spring_CS322-master\\ESE.csv' 
into table sustc_test.Lecture character set utf8
fields terminated by ',' optionally enclosed by "'" escaped by "'" 
lines terminated by '\r\n';

load data local infile 'C:\\Users\\YYJ\\Desktop\\pro\\innovation\\SUSTech_2019_Spring_CS322-master\\FIN.csv' 
into table sustc_test.Lecture character set utf8
fields terminated by ',' optionally enclosed by "'" escaped by "'" 
lines terminated by '\r\n';

load data local infile 'C:\\Users\\YYJ\\Desktop\\pro\\innovation\\SUSTech_2019_Spring_CS322-master\\MAE.csv' 
into table sustc_test.Lecture character set utf8
fields terminated by ',' optionally enclosed by "'" escaped by "'" 
lines terminated by '\r\n';

load data local infile 'C:\\Users\\YYJ\\Desktop\\pro\\innovation\\SUSTech_2019_Spring_CS322-master\\Math.csv' 
into table sustc_test.Lecture character set utf8
fields terminated by ',' optionally enclosed by "'" escaped by "'" 
lines terminated by '\r\n';

load data local infile 'C:\\Users\\YYJ\\Desktop\\pro\\innovation\\SUSTech_2019_Spring_CS322-master\\MED.csv' 
into table sustc_test.Lecture character set utf8
fields terminated by ',' optionally enclosed by "'" escaped by "'" 
lines terminated by '\r\n';

load data local infile 'C:\\Users\\YYJ\\Desktop\\pro\\innovation\\SUSTech_2019_Spring_CS322-master\\MEE.csv' 
into table sustc_test.Lecture character set utf8
fields terminated by ',' optionally enclosed by "'" escaped by "'" 
lines terminated by '\r\n';

load data local infile 'C:\\Users\\YYJ\\Desktop\\pro\\innovation\\SUSTech_2019_Spring_CS322-master\\Ocean.csv' 
into table sustc_test.Lecture character set utf8
fields terminated by ',' optionally enclosed by "'" escaped by "'" 
lines terminated by '\r\n';

load data local infile 'C:\\Users\\YYJ\\Desktop\\pro\\innovation\\SUSTech_2019_Spring_CS322-master\\Physics.csv' 
into table sustc_test.Lecture character set utf8
fields terminated by ',' optionally enclosed by "'" escaped by "'" 
lines terminated by '\r\n';
