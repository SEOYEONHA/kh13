-- 모든 상품의 가격을 0원으로 변경
update product set price = 0;

-- 모든 상품의 종류를 과자로, 가격을 100원으로 변경
update product set type = '과자', price = 100;

-- 1번 상품의 가격을 2000원으로 변경
update product set price = 2000 where no = 1;
-- (주의사항) 없는 번호도 실행은 된다(Updated rows 0인것 확인)
update product set price = 2000 where no = 100;

-- (Q) 멘토스의 가격을 1000원으로 변경하고 분류를 과자로 변경
update product set price = 1000, type = '과자' where name = '멘토스';

-- (Q) 과자의 가격을 500원 할인(오라클에는 누적연산이 없습니다)
update product set price = price - 500 where type = '과자';

-- (Q) 아이스크림의 가격을 10% 인상(오라클에는 누적연산이 없습니다)
update product set price = price * 1.1 where type = '아이스크림';
update product set price = price * 110/100 where type = '아이스크림';

rollback; --지금까지의 작업내용을 취소
commit; --지금까지의 작업내용을 저장
select * from product;

/*
	수정(update)
	- update 테이블명 set 변경구문 [where 조건]
	- 사실상 조건은 무조건 사용한다고 봐야하며, 특히 PK 조건이 많이 쓰임]
*/
