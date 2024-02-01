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

INSERT INTO menu (menu_no, menu_name_kor, menu_name_eng, menu_type, menu_price)
VALUES (menu_seq.nextval, '아이스 티라미수 라떼', 'Iced Tiramisu Latte', '음료', 6500);

INSERT INTO menu (menu_no, menu_name_kor, menu_name_eng, menu_type, menu_price)
VALUES (menu_seq.nextval, '망고 바나나 스무디', 'Mango Banana Smoothie', '음료', 7000);

INSERT INTO menu (menu_no, menu_name_kor, menu_name_eng, menu_type, menu_price)
VALUES (menu_seq.nextval, '허니 브레드', 'Honey Bread', '디저트', 7500);

INSERT INTO menu (menu_no, menu_name_kor, menu_name_eng, menu_type, menu_price)
VALUES (menu_seq.nextval, '아이스 그린 티 라떼', 'Iced Green Tea Latte', '음료', 5500);

INSERT INTO menu (menu_no, menu_name_kor, menu_name_eng, menu_type, menu_price)
VALUES (menu_seq.nextval, '허니 레몬 차이티', 'Honey Lemon Chai Tea', '음료', 6500);

INSERT INTO menu (menu_no, menu_name_kor, menu_name_eng, menu_type, menu_price)
VALUES (menu_seq.nextval, '초코 카라멜 프라페', 'Chocolate Caramel Frappe', '음료', 6500);

INSERT INTO menu (menu_no, menu_name_kor, menu_name_eng, menu_type, menu_price)
VALUES (menu_seq.nextval, '크로크무슈', 'Croque-Monsieur', '식사', 8500);

INSERT INTO menu (menu_no, menu_name_kor, menu_name_eng, menu_type, menu_price)
VALUES (menu_seq.nextval, '치즈베이글', 'Cheese Bagel', '디저트', 7000);

INSERT INTO menu (menu_no, menu_name_kor, menu_name_eng, menu_type, menu_price)
VALUES (menu_seq.nextval, '핫 초콜릿', 'Hot Chocolate', '음료', 5200);

INSERT INTO menu (menu_no, menu_name_kor, menu_name_eng, menu_type, menu_price)
VALUES (menu_seq.nextval, '허니 아몬드 라떼', 'Honey Almond Latte', '음료', 6000);

INSERT INTO menu (menu_no, menu_name_kor, menu_name_eng, menu_type, menu_price)
VALUES (menu_seq.nextval, '레몬 팝시클', 'Lemon Popsicle', '디저트', 3500);

INSERT INTO menu (menu_no, menu_name_kor, menu_name_eng, menu_type, menu_price)
VALUES (menu_seq.nextval, '라즈베리 스콘', 'Raspberry Scone', '디저트', 4800);

INSERT INTO menu (menu_no, menu_name_kor, menu_name_eng, menu_type, menu_price)
VALUES (menu_seq.nextval, '블루베리 머핀', 'Blueberry Muffin', '디저트', 4500);

INSERT INTO menu (menu_no, menu_name_kor, menu_name_eng, menu_type, menu_price)
VALUES (menu_seq.nextval, '아이스 레몬 에이드', 'Iced Lemonade', '음료', 4800);

INSERT INTO menu (menu_no, menu_name_kor, menu_name_eng, menu_type, menu_price)
VALUES (menu_seq.nextval, '아이스 피치 티', 'Iced Peach Tea', '음료', 4500);

INSERT INTO menu (menu_no, menu_name_kor, menu_name_eng, menu_type, menu_price)
VALUES (menu_seq.nextval, '크림 치즈 샌드위치', 'Cream Cheese Sandwich', '식사', 7500);

INSERT INTO menu (menu_no, menu_name_kor, menu_name_eng, menu_type, menu_price)
VALUES (menu_seq.nextval, '치킨 샐러드 샌드위치', 'Chicken Salad Sandwich', '식사', 8200);

INSERT INTO menu (menu_no, menu_name_kor, menu_name_eng, menu_type, menu_price)
VALUES (menu_seq.nextval, '베이컨 에그 크로와상', 'Bacon Egg Croissant', '식사', 7500);

INSERT INTO menu (menu_no, menu_name_kor, menu_name_eng, menu_type, menu_price)
VALUES (menu_seq.nextval, '치즈케이크 아이스크림', 'Cheesecake Ice Cream', '디저트', 5200);

INSERT INTO menu (menu_no, menu_name_kor, menu_name_eng, menu_type, menu_price)
VALUES (menu_seq.nextval, '초콜릿 칩 쿠키', 'Chocolate Chip Cookie', '디저트', 3500);

INSERT INTO menu (menu_no, menu_name_kor, menu_name_eng, menu_type, menu_price)
VALUES (menu_seq.nextval, '바닐라 빈 스무디', 'Vanilla Bean Smoothie', '음료', 6500);

INSERT INTO menu (menu_no, menu_name_kor, menu_name_eng, menu_type, menu_price)
VALUES (menu_seq.nextval, '오렌지 샤베트', 'Orange Sherbet', '디저트', 4200);


INSERT INTO menu (menu_no, menu_name_kor, menu_name_eng, menu_type, menu_price)
VALUES (menu_seq.nextval, '초콜릿 치즈볼', 'Chocolate Cheese Ball', '디저트', 7000);

INSERT INTO menu (menu_no, menu_name_kor, menu_name_eng, menu_type, menu_price)
VALUES (menu_seq.nextval, '레몬 마들렌', 'Lemon Madeleine', '디저트', 4500);

INSERT INTO menu (menu_no, menu_name_kor, menu_name_eng, menu_type, menu_price)
VALUES (menu_seq.nextval, '스테이크 샐러드', 'Steak Salad', '식사', 11000);

INSERT INTO menu (menu_no, menu_name_kor, menu_name_eng, menu_type, menu_price)
VALUES (menu_seq.nextval, '바나나 브레드', 'Banana Bread', '디저트', 4800);

INSERT INTO menu (menu_no, menu_name_kor, menu_name_eng, menu_type, menu_price)
VALUES (menu_seq.nextval, '레드 벨벳 케이크', 'Red Velvet Cake', '디저트', 8500);

INSERT INTO menu (menu_no, menu_name_kor, menu_name_eng, menu_type, menu_price)
VALUES (menu_seq.nextval, '아이스 허니 라떼', 'Iced Honey Latte', '음료', 6000);

INSERT INTO menu (menu_no, menu_name_kor, menu_name_eng, menu_type, menu_price)
VALUES (menu_seq.nextval, '샐러리 케이크', 'Celery Cake', '디저트', 5200);

INSERT INTO menu (menu_no, menu_name_kor, menu_name_eng, menu_type, menu_price)
VALUES (menu_seq.nextval, '브라우니', 'Brownie', '디저트', 4800);

INSERT INTO menu (menu_no, menu_name_kor, menu_name_eng, menu_type, menu_price)
VALUES (menu_seq.nextval, '피자 꼬치', 'Pizza Skewer', '식사', 9500);

INSERT INTO menu (menu_no, menu_name_kor, menu_name_eng, menu_type, menu_price)
VALUES (menu_seq.nextval, '모히또', 'Mojito', '음료', 7000);

INSERT INTO menu (menu_no, menu_name_kor, menu_name_eng, menu_type, menu_price)
SELECT menu_seq.nextval,
       '메뉴' || menu_seq.currval,
       'Menu' || menu_seq.currval,
       '음료',
       ((menu_seq.currval - 1) * 500) + 4000
FROM dual
CONNECT BY LEVEL <= 30;

SELECT * FROM menu;
