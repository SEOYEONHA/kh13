<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<h1>이미지 실습</h1>

<%--
	img태그
	- 페이지에 이미지를 보여줄 수 있는 효과를 부여
	- 태그만으로는 정보가 부족하므로 속성(attribute)을 통해 추가 정보를 전달
	- 속성은 key=value 형태이며, 속성과 속성 사이는 반드시 띄어쓰기가 필요
	
	- src : 이미지의 경로
	- width : 이미지의 폭(px, %)
	- height : 이미지의 높이(px, %)
	- alt : 접근성 향상을 위한 도움말
--%>

<img width="500"  src="https://mblogthumb-phinf.pstatic.net/MjAyMDA1MjRfMTY3/MDAxNTkwMzA0MjM5MDQz.eav_fvPrQdIhFJq3iYCrCA_7i1Ztth9PAtJWt3fLOpgg.S3_CYuBkewJNzInpiZb8SLt0UPLicBPZ_-hjpHDI8LMg.JPEG.akddnf9/P20191224_202146508_5562A86F-61ED-4AFF-A419-3BFCDBEB95CA.JPG?type=w800">

<hr>

<img alt="마이멜로디 이미지" width="30%" src="https://mblogthumb-phinf.pstatic.net/MjAyMDA1MjRfMTY3/MDAxNTkwMzA0MjM5MDQz.eav_fvPrQdIhFJq3iYCrCA_7i1Ztth9PAtJWt3fLOpgg.S3_CYuBkewJNzInpiZb8SLt0UPLicBPZ_-hjpHDI8LMg.JPEG.akddnf9/P20191224_202146508_5562A86F-61ED-4AFF-A419-3BFCDBEB95CA.JPG?type=w800">

<%--
	프로젝트 외부 위치에 있는 이미지는 보안상의 이유로 src에 설정할 수 없다.
	
	<img width="400" src="D:\yhseo\image\bg.jpg">
	
	이미지를 프로젝트에 포함시켜야 한다(src/main/resources/static)
	이미지를 해당 위치에 포함시키면 주소가 파일명으로 자동 생성된다
	
	http://localhost:8080/파일명
	
	다음과 같이 이미지 태그로 부를 수 있다.
	<img width="400" src="http://localhost:8080/bg.jpg">
	
	같은 서버의 같은 프로젝트에 있기 때문에 주소를 생략할 수 있다
	- 프로토콜 생략 : <img width="400" src="//localhost:8080/bg.jpg">
	- host/port 생략 : <<img width="400" src="/bg.jpg">
	위와 같은 방식은 절대경로(absolute path) 라고 부른다
	
	한편, 다음과 같이 작성해도 된다.
	<img width="400" src="bg.jpg">
	위와 같은 방식은 상대경로(relative path) 라고 부른다
	
	절대경로 - 언제나 한결같은 위치를 가리킴
	상대경로 - 현재페이지에 따라 다른위치를 가리킴
	
 --%>
<img width="400" src="bg.jpg">







