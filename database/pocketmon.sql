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
insert into pocketmon(pocketmon_no, pocketmon_name, pocketmon_type)
values(5, '리자드', '불꽃');
insert into pocketmon(pocketmon_no, pocketmon_name, pocketmon_type)
values(9, '거북왕', '물');
insert into pocketmon(pocketmon_no, pocketmon_name, pocketmon_type)
values(10, '캐터피', '벌레');

select * from pocketmon;
