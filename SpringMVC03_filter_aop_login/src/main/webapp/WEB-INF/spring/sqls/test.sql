DROP SEQUENCE MYNOSEQ;
DROP TABLE MYBOARD;

CREATE SEQUENCE MYNOSEQ;

CREATE TABLE MYBOARD(
	MYNO NUMBER PRIMARY KEY,
	MYNAME VARCHAR2(500) NOT NULL,
	MYTITLE VARCHAR2(1000) NOT NULL,
	MYCONTENT VARCHAR2(4000) NOT NULL,
	MYDATE DATE NOT NULL
);

SELECT MYNO, MYNAME, MYTITLE, MYCONTENT, MYDATE
FROM MYBOARD
ORDER BY MYNO DESC;

-- mymember

drop sequence mymemberseq;
drop table mymember;

create sequence mymemberseq;

create table mymember(
	memberno number primary key,
	memberid varchar2(1000) not null,
	memberpw varchar2(1000) not null,
	membername varchar2(1000) not null
);

insert into mymember
values(mymemberseq.nextval,'admin','admin1234','관리자');

select memberno,memberid,memberpw,membername
from mymember
order by memberno

