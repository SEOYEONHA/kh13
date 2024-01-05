/*
	기본키(Primary key)
	- 테이블에 단 한개만 설정할 수 있는 유일한 불변값
	- 대표항목 역할을 하며 not null + unique 효과를 가짐
	- 회원으로 치면 "아이디"와 "닉네임" 중에서 "아이디"가 기본키 역할을 수행할 수 있다.
		(바뀌면 안되는 것으로 설정)
	- 모든 항목 중에 가장 검색 속도가 빠름
	- 테이블 당 1개를 반드시 만들 것을 권장(없으면 번호라도 생성해서 지정)
*/

-- 포켓몬스터 테이블
create table pocketmon(
pocketmon_no number primary key,
pocketmon_name varchar2(30) not null,
pocketmon_type varchar2(9) not null
);

drop table pocketmon;

insert into pocketmon(pocketmon_no, pocketmon_name, pocketmon_type)
values(1, '이상해씨', '풀');
insert into pocketmon(pocketmon_no, pocketmon_name, pocketmon_type)
values(4, '파이리', '불꽃');
insert into pocketmon(pocketmon_no, pocketmon_name, pocketmon_type)
values(7, '꼬부기', '물');

select * from pocketmon;
