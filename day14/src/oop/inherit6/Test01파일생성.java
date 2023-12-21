package oop.inherit6;

public class Test01파일생성 {

	public static void main(String[] args) {
		Mp4 f1 = new Mp4("객체지향.mp4", 3021L);
		f1.setSpeed(1.2f);
		f1.forward();//MediaFile
		f1.rewind();//MediaFile
		f1.execute();//File
		f1.information();//File -> Mp4(재정의)

		Mp3 f2 = new Mp3("강의녹음.mp3", 1200L, 180);
		f2.forward();//MediaFile
		f2.rewind();//MediaFile
		f2.execute();//File
		f2.information();//File -> Mp3(재정의)
		
		Hwp f3 = new Hwp("강의필기.hwp", 15000L, 1500);
		f3.preview(); //Hwp
		f3.execute();//File
		f3.information();//File

		Ppt f4 = new Ppt("강의자료.ppt", 9999L, 20);
		f4.slideShow();//Ppt
		f4.execute();//File
		f4.information();//File
	}
}
