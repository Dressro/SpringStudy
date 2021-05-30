drop sequence jdbcboardseq;
drop table jdbcboard;

create sequence jdbcboardseq;

create table jdbcboard(
	seq number primary key,
	writer varchar2(500) not null,
	title varchar2(1000) not null,
	content varchar2(4000)	not null,
	regdate date not null
);

insert into jdbcboard
values (jdbcboardseq.nextval,'관리자','TEST 글','사실 spring-jdbc는 잘 안쓰여요',sysdate);

select seq,writer,title,content,regdate
from jdbcboard
order by seq desc;