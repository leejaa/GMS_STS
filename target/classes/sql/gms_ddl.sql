-- *********************

-- 1. major
-- 2. subject
-- 3. member
-- 4. prof
-- 5. student
-- 6. grade
-- 7. board


drop table board;

create table major(
	major_id char(10),
	title char(30),
	primary key(major_id)
);

create table subject(
	subj_id char(10),
	title char(10),
	major_id char(10),
	primary key(subj_id)
);

create table member(
	member_id char(20),
	name char(20),
	password char(20),
	ssn char(20),
	regdate date,
	major_id char(10),
	phone char(20),
	email char(20),
	profile char(20),
	primary key(member_id)
);

create table grade(
	grade_seq int auto_increment,
	score char(10),
	exam_date char(20),
	subj_id char(20),
	member_id char(20),
	primary key(grade_seq)
);

create table board(
	article_seq int auto_increment,
	member_id char(20),
	title char(30),
	content char(225),
	hitcount int,
	regdate date,
	primary key(article_seq)
);

select * from member;

insert into member values 
('jamhon','잠혼','dd','900304-1234323',now(),'4','010-3432-2343','jamhon@gmail.com','default.img');

('deeney','deeney','dd','900304-1234323',now(),'2','010-3432-2343','deeney@gmail.com','default.img'),
('behrami','behrami','dd','800304-1234323',now(),'3','010-3432-2343','behrami@gmail.com','default.img'),
('pareyra','pareyra','dd','920304-1234323',now(),'4','010-3432-2343','pareyra@gmail.com','default.img'),
('capoue','capoue','dd','930304-1234323',now(),'1','010-3432-2343','capoue@gmail.com','default.img'),
('holebas','holebas','dd','900304-1234323',now(),'2','010-3432-2343','holebas@gmail.com','default.img'),
('cathcart','cathcart','dd','920304-1234323',now(),'3','010-3432-2343','cathcart@gmail.com','default.img'),
('britos','britos','dd','820304-1234323',now(),'4','010-3442-2343','britos@gmail.com','default.img'),
('kaboul','kaboul','dd','900304-1234323',now(),'1','010-3432-2343','kaboul@gmail.com','default.img'),
('janmaat','janmaat','dd','900304-1234323',now(),'2','010-3432-2343','janmaat@gmail.com','default.img'),
('gomes','gomes','dd','900304-1234323',now(),'3','010-3432-2343','gomes@gmail.com','default.img'),
('poleon','poleon','dd','900304-1234323',now(),'4','010-3432-2343','poleon@gmail.com','default.img'),
('taylor','taylor','dd','900304-1234323',now(),'1','010-3432-2343','taylor@gmail.com','default.img'),
('barcham','barcham','dd','900304-1234323',now(),'2','010-3432-2343','barcham@gmail.com','default.img'),
('charles','charles','dd','900304-1234323',now(),'3','010-3432-2343','charles@gmail.com','default.img'),
('reeves','reeves','dd','900304-1234323',now(),'4','010-3432-2343','reeves@gmail.com','default.img'),

insert into subject values ('1','java','1');
insert into subject values ('2','c','1');
insert into subject values ('3','phython','1');
insert into subject values ('4','c++','1');
insert into subject values ('5','html','1');
insert into subject values ('6','css','1');
insert into subject values ('7','javascript','1');

create table member_subject(
	member_id char(20),
	subj_id char(10)
);

insert into member_subject values ('bangtong','3');
insert into member_subject values ('barcham','4');
insert into member_subject values ('behrami','3');
insert into member_subject values ('britos','4');
insert into member_subject values ('capoue','5');
insert into member_subject values ('cathcart','6');
insert into member_subject values ('charles','7');
insert into member_subject values ('deeney','1');
insert into member_subject values ('dongsp','2');
insert into member_subject values ('gomes','3');
insert into member_subject values ('gwakga','4');
insert into member_subject values ('hahoodon','5');
insert into member_subject values ('holebas','6');
insert into member_subject values ('hwangge','7');
insert into member_subject values ('hwangho','1');
insert into member_subject values ('ighalo','2');
insert into member_subject values ('ighaloo','3');
insert into member_subject values ('jamhon','4');
insert into member_subject values ('janmaat','5');
insert into member_subject values ('jegal','6');
insert into member_subject values ('jomoo','7');
insert into member_subject values ('jooyoo','1');
insert into member_subject values ('joun','2');
insert into member_subject values ('jungook','3');
insert into member_subject values ('junwe','4');
insert into member_subject values ('kaboul','5');
insert into member_subject values ('macho','6');
insert into member_subject values ('pareyra','7');

create view student (num,member_id,name,password,ssn,regdate,major_id,phone,email,profile,gender,title)
as
select rownum no, t3.*
from
(select m.*,t2.title from member m
join
(select t.member_id,group_concat(t.title separator ',') group by t.title
from
(select m.*,s.title from member m
join MEMBER_SUBJECT ms on ms.member_id=m.member_id
join SUBJECT s on s.subj_id=ms.subj_id) t
group by t.member_id) t2 on t2.member_id=m.member_id order by regdate asc) t3
order by no desc;


insert into board (member_id,title,content,hitcount,regdate) values ('bangtong','aaa','aaa',5,now());
insert into board (member_id,title,content,hitcount,regdate) values ('jamhon','bbb','bbb',5,now());
insert into board (member_id,title,content,hitcount,regdate) values ('deeney','ccc','ccc',5,now());
insert into board (member_id,title,content,hitcount,regdate) values ('behrami','ddd','ddd',5,now());
insert into board (member_id,title,content,hitcount,regdate) values ('pareyra','eee','eee',5,now());
insert into board (member_id,title,content,hitcount,regdate) values ('capoue','fff','fff',5,now());
insert into board (member_id,title,content,hitcount,regdate) values ('cathcart','hhh','hhh',5,now());
insert into board (member_id,title,content,hitcount,regdate) values ('britos','iii','iii',5,now());
insert into board (member_id,title,content,hitcount,regdate) values ('kaboul','jjj','jjj',5,now());
insert into board (member_id,title,content,hitcount,regdate) values ('janmaat','kkk','kkk',5,now());
insert into board (member_id,title,content,hitcount,regdate) values ('gomes','lll','lll',5,now());
insert into board (member_id,title,content,hitcount,regdate) values ('poleon','mmm','mmm',5,now());
insert into board (member_id,title,content,hitcount,regdate) values ('taylor','nnn','nnn',5,now());
insert into board (member_id,title,content,hitcount,regdate) values ('barcham','ooo','ooo',5,now());
insert into board (member_id,title,content,hitcount,regdate) values ('charles','ppp','ppp',5,now());
insert into board (member_id,title,content,hitcount,regdate) values ('reeves','qqq','qqq',5,now());

update member set gender='female';

alter table member add column gender char(20);


