--[테이블 작성]
create table guestbook(
                          seq   number primary key, -- 시퀀스 객체로부터 값을 얻어온다
                          name  varchar2(30),
                          email  varchar2(30),
                          homepage  varchar2(35),
                          subject  varchar2(500) not null,
                          content  varchar2(4000) not null,
                          logtime  date);

--[시퀀스]
create sequence seq_guestbook nocycle nocache;

--입력한 글 번호(seq)에 해당하는 레코드 불러옴.
SELECT name, email, homepage, subject, content, to_char(logtime, 'YYYY.MM.DD') as logtime FROM GUESTBOOK WHERE seq = ?;

--최신순으로 방명록 List 불러오기
SELECT name, email, homepage, subject, content, to_char(logtime, 'YYYY.MM.DD') as logtime
FROM GUESTBOOK ORDER BY seq desc;

--페이징 처리
--페이지 1 ->최근의 1,2 게시물
--페이지 2 ->최근의 3,4 게시물 ...
SELECT * FROM (
SELECT ROWNUM rn, AA.*
FROM (SELECT seq, name, email, homepage, subject, content, to_char(logtime, 'YYYY.MM.DD') as logtime
FROM GUESTBOOK ORDER BY seq desc) aa)
         WHERE RN>=1 AND RN<=2;

--총 게시글 수
SELECT COUNT(*) FROM GUESTBOOK