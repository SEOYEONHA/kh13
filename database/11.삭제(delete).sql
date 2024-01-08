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
