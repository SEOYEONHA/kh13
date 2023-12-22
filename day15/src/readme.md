# Markdown 사용 설명서

**markdown**이란 **markup**의 반대 개념으로 최소한의 기호로 문서를 꾸밀 수 있도록 고안된 문법 체계이다.

# 제목 작성법

제목은 #이라는 기호를 이용하여 작성할 수 있다.  
개수는 1개부터 6개까지 사용할 수 있다.  
일반적으로 1개부터 3개까지만 제목으로 쓰고 4개부터는 일반 글자보다 작아서 잘 사용하지 않는다.

# 대제목(# 1개)
## 중제목(# 2개)
### 소제목(# 3개)


# 코드 블록

프로그래밍 코드를 작성하고 싶다면 블록을 생성하고 블록 옆에 언어를 지정하여 작성할 수 있다.

```
일반적인 블록
```

언어를 설정한 코드 블록은 다음과 같다.

```java
for(int i=0; i < 10; i++) {
	System.out.println("Hello World!");
}
```

# 인용구

다른 사람이 했던 말 또는 글귀를 옮겨 적을 때 사용

> 사느냐 죽느냐 그것이 문제로다 -셰익스피어

# 이미지

이미지는 이미지의 주소만 알 수 있다면 문서 내에 표시가 가능하다.

```
![설명](주소)
```

![KH로고](https://image.rocketpunch.com/company/105846/khjeongbogyoyugweon_logo_1572925088.png?s=400x400&t=inside)

# 링크 삽입

이 페이지가 아닌 외부로의 연결고리를 하이퍼링크(hyperlink)라고 부른다.

```
[보여줄글자](주소)
```

[구글에서 자바 검색한 결과 보러가기](https://www.google.com/search?q=%EC%9E%90%EB%B0%94&sca_esv=593038284&sxsrf=AM9HkKl25LH8bgs-Xu5FWcJqDFu_Hbhlgw%3A1703232716704&source=hp&ei=zESFZf7kKP3i2roPw_e-yA4&iflsig=AO6bgOgAAAAAZYVS3LACwmnLPpfPEFTUOomOT48lpLSa&ved=0ahUKEwj--q-ozKKDAxV9sVYBHcO7D-kQ4dUDCAw&uact=5&oq=%EC%9E%90%EB%B0%94&gs_lp=Egdnd3Mtd2l6IgbsnpDrsJQyCBAAGIAEGLEDMgsQABiABBixAxiDATIIEAAYgAQYsQMyCxAAGIAEGLEDGIMBMggQABiABBixAzIFEAAYgAQyCxAAGIAEGLEDGIMBMgUQABiABDIFEAAYgAQyBRAAGIAESKIJUABYkghwAngAkAEBmAG8AaABiAWqAQMwLjW4AQPIAQD4AQGoAgrCAgQQABgDwgILEC4YgAQYsQMYgwHCAhEQLhiABBixAxiDARjHARjRA8ICCxAuGIAEGMcBGK8BwgIHEAAYgAQYCsICDRAuGMcBGNEDGOoCGCfCAgcQIxjqAhgn&sclient=gws-wiz)



# 목록 표시

목록은 크게 두 가지로 나눠진다.

- 순서가 없는 목록(unorder list)
- 순서가 있는 목록(order list)  


순서가 있는 목록은 다음과 같다.  

1. 자바
2. 데이터베이스
3. 웹
4. 서버

목록은 중첩이 가능하다.  
탭키 또는 띄어쓰기 4번을 하면 하위 목록이 된다.  
(디스코드는 띄어쓰기 2번만 인정)

1. 첫번째항목
	- 세부항목1
    - 세부항목2
2. 두번째항목
	- 세부항목1
    - 세부항목2
3. 세번째항목
	- 세부항목1
    - 세부항목2

# 체크리스트 만들기

- [x] 공부하기
- [ ] 운동하기
- [ ] 복습하기
- [x] 술마시기
- [x] 게임하기