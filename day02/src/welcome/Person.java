package welcome;

public class Person {

	
	//멤버 필드 - 변수
    private String name;
    private int age;
    private String job;

    // 생성자 - 초기화
    Person(String name, int age) { //오버로딩(overloading)을 해서 직업이 입력되지 않았을 때 "무직"으로 설정되게끔 함
        this(name, age, "무직");
    }
    
    Person(String name, int age, String job) {
        setName(name);
        setAge(age);
        setJob(job);
    }
    
    //멤버 메소드 - 주요 기능
    void setName(String name) {
    	this.name = name;
    }

   void setAge(int age) { 
        if (age < 1) return; //나이는 1세 이상으로만 입력되게끔 설정
        this.age = age;
   }
    
    void setJob(String job) {
    	this.job = job;
    }
    
    String getName() {
    	return this.name;
    }
    
   int getAge() {
	   return this.age;
   }
   
   String getJob() {
	   return this.job;
   }
   
   String getAgeType(){ // 나이에 따라 해당 정보 확인가능.
	   if (age >= 20) {
         return "(성인입니다.)";
	   } 
	   else if (age >= 14) {
         return "(청소년입니다.)";
	   } 
	   else if (age >= 8) {
         return "(어린이입니다.)";
	   } 
	   else if (age > 1 && age < 8){
        return"(유아입니다.)";
	   }
	   else {
		   return "(나이는 1세 이상만 입력 가능합니다.)";
	   }
		   
   }
   
   void information() {
	   System.out.println("<information>");
	   System.out.println("이름 : " + this.getName());
	   System.out.println("나이 : " + this.getAge() + "세 " + this.getAgeType());
	   System.out.println("직업 : " + this.getJob());
   }
}