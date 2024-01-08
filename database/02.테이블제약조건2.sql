/* 
 강의시간 : 0이상
수강료 : 0 이상
구분 : 온라인, 오프라인, 혼합
(추가) 강의시간을 30의 배수인 경우만 설정
*/

CREATE TABLE academy(
academy_name varchar2(60) NOT null unique,
academy_time number NOT NULL 
CHECK(academy_time >= 0 AND mod(academy_time, 30) = 0),
academy_price number NOT NULL CHECK(academy_price >= 0),
academy_type varchar2(12) NOT NULL check(academy_type IN('온라인', '오프라인', '혼합'))
);
DROP TABLE academy;

INSERT INTO academy(academy_name, academy_time, academy_price, academy_type)
VALUES('자바 마스터과정', 90, 1000000, '온라인');
INSERT INTO academy(academy_name, academy_time, academy_price, academy_type)
VALUES('파이썬 기초', 60, 600000, '온라인');
INSERT INTO academy(academy_name, academy_time, academy_price, academy_type)
VALUES('웹 개발자 단기완성', 120, 1200000, '오프라인');

SELECT * FROM ACADEMY; 
