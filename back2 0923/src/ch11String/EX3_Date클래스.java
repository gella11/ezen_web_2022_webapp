package ch11String;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class EX3_Date클래스 {

	public static void main(String[] args) {
	
		// 1. Date 날짜
		// import 필수
		Date now = new Date(); 				System.out.println(now);
		String strNow1 = now.toString(); 	System.out.println( strNow1);
		
		// 2. SimpleDateFormat() 
		// 날짜 / 시간 형식(모양) 변환
		// SimpleDateFormat 객체명 = new SimpleDateFormat(" 형식 ");
		// 객체명.format(데이터)
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 hh시 mm분 ss초");
		String strNow2 = sdf.format( new Date() );
		System.out.println(strNow2);
		
		// 3. Calender 클래스
		// ★★★문자열로 출력
		// Asia/Seoul
		// JST
		// America/Los_Angeles
		// America/New_York
		// 생략 >>> 운영체제 기준 시간대
		//
		// Calendar.getInstance("Asia/Seoul");
		Calendar cal = Calendar.getInstance();
		int year 	= cal.get(Calendar.YEAR);
		int month 	= cal.get(Calendar.MONTH) + 1;
		int day 	= cal.get(Calendar.DAY_OF_MONTH);		// 1월[0] 2월[1] ---
		int week	= cal.get(Calendar.DAY_OF_WEEK);		// 일 [1]  월[2] ---
		System.out.println("현재연도 : " + year);
		System.out.println("현재월  : " + month);
		System.out.println("현재일  : " + day);
		System.out.println("현재주  : " + week);
		String strWeek = null;
		switch(week) {
			case Calendar.MONDAY	 : strWeek="월"; break;
			case Calendar.TUESDAY	 : strWeek="화"; break;
			case Calendar.WEDNESDAY	 : strWeek="수"; break;
			case Calendar.THURSDAY 	 : strWeek="목"; break;
			case Calendar.FRIDAY 	 : strWeek="금"; break;
			case Calendar.SATURDAY 	 : strWeek="토"; break;
			default 				 : strWeek="일"; break;
		}
		System.out.println(strWeek);
		
		// 오전 0 
		// 오후 1
		int amPm = cal.get(Calendar.AM_PM);
		if( amPm == Calendar.AM) {System.out.println("오전");}
		else 					 {System.out.println("오후");}
		System.out.println( cal.get( Calendar.HOUR ));
		System.out.println( cal.get( Calendar.MINUTE ));
		System.out.println( cal.get( Calendar.SECOND ));
		
		
		// 다른 클래스의 메소드 호출 하는 방법
		// 1. static 정적멤버일경우 : 클래스명.메소드명
		// 2. new 객체 생성 -> 객체명.메소드명
		// 3. 싱글톤 -> 클래스명.get싱글톤.메소드명
		// * 현재 클래스의 메소드 호출시 : 메소드명
		
		new EX4_달력().run();
		// 위와 같음
		// 아래 코드가 더 좋음.
		// 가독성이 더 좋음
		// EX4_달력 ex = new EX4_달력();
		// ex.run();
		
		
		
		
		
		
		
	}	
}
