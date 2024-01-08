create table phone(
phone_name varchar2(30) not null,
phone_carrier char(2) not null check(phone_carrier in('SK', 'KT', 'LG')),
phone_price number not null check(phone_price >= 0),
phone_contract number(2) check(phone_contract in(0, 24, 36)),
-- 이름 + 통신사를 합쳐서 같은 경우는 없다
unique(phone_name, phone_carrier)
);

drop table phone;

insert into phone(phone_name, phone_carrier, phone_price, phone_contract)
values('갤럭시Fold4', 'SK', 1800000, 0);
insert into phone(phone_name, phone_carrier, phone_price, phone_contract)
values('갤럭시Fold4', 'KT', 1750000, 24);
insert into phone(phone_name, phone_carrier, phone_price, phone_contract)
values('아이폰15', 'LG', 2000000, 36);
insert into phone(phone_name, phone_carrier, phone_price, phone_contract)
values('아이폰15', 'SK', 1990000, 0);

select * from phone;
