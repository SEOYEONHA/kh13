/*
	삭제(delete)
	- delete [from] 테이블명 [where 조건]
	- 전체를 지울 일은 거의 존재하지 않으므로 조건을 결합하여 사용
*/

-- 전체 삭제
delete product; -- 추천
delete from product; -- 가능하지만 비추천(select와 헷갈림)

-- 1번 상품 삭제
delete product where no = 1;

-- (Q) 과자와 아이스크림 삭제
delete product where type = '과자' or type = '아이스크림';
delete product where type in('과자', '아이스크림');
--delete product where type = '아이스크림';

-- (Q) 2020년 상반기에 생산된 제품 삭제
delete product where
	extract(year from made) = 2020
	and
	extract(month from made) between 1 and 6;

delete product where made between
	to_date('2020-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS')
	AND
	to_date('2020-06-30 23:59:59', 'YYYY-MM-DD HH24:MI:SS');

select * from product;
rollback;

select * from pocketmon;
delete pocketmon where pocketmon_no = 99;

select * from book;

delete book where book_id = 50;
commit;

drop sequence emp_seq;

create table emp(
emp_no number primary key,--사원번호, 시퀀스로 자동 부여
emp_name varchar2(21) not null,--사원의 한글 이름
emp_dept varchar2(30) not null,--사원의 소속 부서
emp_date char(10) not null,--사원의 입사일
emp_sal number default 0 not null check(emp_sal >= 0)--사원의 급여(원)
);
create sequence emp_seq;

drop table emp;

INSERT INTO emp (emp_no, emp_name, emp_dept, emp_date, emp_sal) 
VALUES (emp_seq.nextval, '김철수', '인사부', '2022-01-01', 50000);
INSERT INTO emp (emp_no, emp_name, emp_dept, emp_date, emp_sal) 
VALUES (emp_seq.nextval, '이영희', '영업부', '2022-02-15', 60000);
INSERT INTO emp (emp_no, emp_name, emp_dept, emp_date, emp_sal) 
VALUES(emp_seq.nextval, '박민지', '개발부', '2022-03-10', 70000);
INSERT INTO emp (emp_no, emp_name, emp_dept, emp_date, emp_sal) 
VALUES(emp_seq.nextval, '정현우', '마케팅부', '2022-04-05', 55000);
INSERT INTO emp (emp_no, emp_name, emp_dept, emp_date, emp_sal) 
VALUES(emp_seq.nextval, '송지영', '인사부', '2022-05-20', 48000);
INSERT INTO emp (emp_no, emp_name, emp_dept, emp_date, emp_sal) 
VALUES(emp_seq.nextval, '홍길동', '영업부', '2022-06-15', 75000);
INSERT INTO emp (emp_no, emp_name, emp_dept, emp_date, emp_sal) 
VALUES(emp_seq.nextval, '신지수', '개발부', '2022-07-10', 65000);
INSERT INTO emp (emp_no, emp_name, emp_dept, emp_date, emp_sal) 
VALUES(emp_seq.nextval, '김민호', '마케팅부', '2022-08-25', 60000);
INSERT INTO emp (emp_no, emp_name, emp_dept, emp_date, emp_sal) 
VALUES(emp_seq.nextval, '이지은', '인사부', '2022-09-30', 52000);
INSERT INTO emp (emp_no, emp_name, emp_dept, emp_date, emp_sal) 
VALUES(emp_seq.nextval, '박성우', '영업부', '2022-10-15', 70000);

select * from emp;

select * from emp where emp_name like '영%' or emp_dept like '영%';

commit;
