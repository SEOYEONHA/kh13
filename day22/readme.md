# Oracle
![DBMS](https://cdn.discordapp.com/attachments/1181056701537996810/1192270335312154684/image.png?ex=65a87747&is=65960247&hm=c2f254928908ed21eb8d7f64a8a7c459a1ec1540d523fb2bbdc1664923a0749d&)

# SQL
![대략적 설명](https://cdn.discordapp.com/attachments/1193766807383846936/1193767766516314143/image.png?ex=65ade9de&is=659b74de&hm=53b512214da9b2b742f6e8e75072b175624940af34488884175d8279f225c689&)

# 오라클 데이터 타입
1. 숫자 
	- number로 모든 숫자 유형을 표기
	- number(5) 숫자 5자리
	- number(7,2) 전체 7자리, 소수점 2자리
	- 자리수 지정을 안하면 38자리
2. 글자
	- varchar2는 가변 문자열을 의미
		- 가변 문자열은 최대치만 지정하고 그 안에서 자유롭게 사용
		- 단, 지정하지 않을 수는 없음
		- 유니코드는 1글자당 3byte
	- char는 고정 문자열을 의미
		- 생년월일, 주민등록번호 등 모든 값이 같은 글자 수인 경우 사용
		- 검색 속도가 varchar2에 비해 압도적으로 빠름
		- 만약 자리수를 지키지 않ㅇ르면 나머지 자리를 공백으로 채움
3. 시간
	- date 형태로 시간 데이터를 관리(연월일시분초 모두 포함)
	
# 데이터베이스
- 사용자 : 관리자, 일반사용자
	- 사용자 생성, 삭제 : create user, drop user
	- 권한 부여, 회수 : grant, revoke
- 테이블 : 데이터를 저장하기 위한 표 형식의 도구
	- 표의 형태 결정을 위한 자료형, 제약조건
		- 자료형 : number, varchar2, char, date
		- 제약조건 : not null, check, unique, primary key, default
- 시퀀스 : 데이터에 고유 번호를 부여하기 위한 도구
- 데이터 : CRUD(등록/조회/수정/삭제) 하는 작업을 위한 구문
	- C : Insert Into 테이블(형식) values(값)
	- R : Select 항목 from 테이블 [조건][정렬]
	- U : Update 테이블 set 변경구문 [조건]
	- D : Delete 테이블 [조건]