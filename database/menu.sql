create table menu(
menu_no number primary key,--메뉴번호, 시퀀스로 자동 부여
menu_name_kor varchar2(60) not null,--메뉴 한글 이름
menu_name_eng varchar2(60) not null,--메뉴 영문 이름
menu_type varchar2(30) not null,--메뉴 종류
menu_price number default 0 not null check(menu_price >= 0)--메뉴 판매가(원)
);

create sequence menu_seq;

INSERT INTO menu (menu_no, menu_name_kor, menu_name_eng, menu_type, menu_price)
VALUES
(menu_seq.nextval, '아메리카노', 'Americano', '음료', 4000);
INSERT INTO menu (menu_no, menu_name_kor, menu_name_eng, menu_type, menu_price)
VALUES (menu_seq.nextval, '카페라떼', 'Cafe Latte', '음료', 5000);

SELECT * FROM menu;
