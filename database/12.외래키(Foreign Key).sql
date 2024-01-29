/*
외래키(Foreign Key)
- 다른 테이블과 연결하기 위해 사용하는 도구
- 1대 N 관계 같은 구조적으로 결합되어 있는 형태를 구현할 때 사용
- 데이터의 안정성이 올라간다

<외래키 옵션>
- 외래키 뒤에 on delete를 붙이면 삭제 시 자동 처리를 지시할 수 있다
[1] on delete cascade를 붙이면 상위 항목이 지워지면 하위 항목이 삭제된다
[2] on delete set null을 붙이면 상위 항목이 지워지면 하위 항목의 외래키 값이 null로 변경된다
[3] on delete를 안붙이면 하위 항목이 있으면 상위 항목을 지울 수 없다
 */

-- 포켓몬스터 테이블
create table monster(
monster_no number primary key,
monster_name varchar2(30) not null
);
-- 포켓몬스터 속성 테이블
create table monster_attr(
--monster_no references monster(monster_no),
--monster_no references monster(monster_no) on delete cascade,
monster_no references monster(monster_no) on delete set null,
attr_name varchar2(30) not null
);

-- 1, 이상해씨, 풀/독
insert into monster(monster_no, monster_name) values(1, '이상해씨');
insert into monster_attr(monster_no, attr_name) values(1, '풀');
insert into monster_attr(monster_no, attr_name) values(1, '독');
commit;

-- 4, 파이리, 불
insert into monster(monster_no, monster_name) values(4, '파이리');
insert into monster_attr(monster_no, attr_name) values(4, '불');
commit;

-- 1번(이상해씨) 삭제
--delete monster_attr where monster_no=1;
delete monster where monster_no=1;
rollback;
