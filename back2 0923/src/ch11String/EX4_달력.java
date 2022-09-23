package ch11String;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Scanner;
import java.util.spi.CalendarDataProvider;

import 키오스크.관리자.AdminControl;
import 키오스크.관리자.AdminDAO;

public class EX4_달력 {
	
	// 필드
	Scanner scanner = new Scanner(System.in);
	Calendar cal = Calendar.getInstance();
	int year 	= cal.get(Calendar.YEAR);
	int month 	= cal.get(Calendar.MONTH) + 1;
	int day		= cal.get(Calendar.DAY_OF_MONTH);
	// 생성자
	// 메소드
	EX4Controll acontrol = new EX4Controll();
	
	void run() {
		while(true) {
			cal.set(year, month-1, 1);									// 현재 월의 1일의 날짜
			int sweek = cal.get( Calendar.DAY_OF_WEEK );				// 현재 월의 1일의 요일
			int eday  = cal.getActualMaximum( Calendar.DAY_OF_MONTH );	// ** 현재날짜의 마지막 일 수 찾기
			
			System.out.printf(" ===== %d 년 %d 월 의 달력 =======" , year , month);
			System.out.println("\n일\t월\t화\t수\t목\t금\t토");		
			for( int i = 1 ; i<sweek; i++) {System.out.print("\t ");}	// 1일의 전까지 공백 반복문
			for( int i = 1 ; i<eday;  i++) {							// 1일~ 마지막 일수 까지 출력
				System.out.printf("%2d \t ", i);
				if(sweek % 7 == 0 ) {System.out.println();}				// 토요일 이후 마다 줄바꿈 처리
				sweek++;												// 일수를 출력할때 마다 요일도 증가처리
			}
			일정출력();
			System.out.println("\n================================");
			System.out.print("◀이전[1] ▶다음[2] \n 검색[3 연도/월 ] 일정추가[4]");
			int btn = scanner.nextInt();
	
			if(btn == 1) 		{ month--; if(month == 0)  {month=12; year--;}}
			else if(btn == 2) 	{ month++; if(month == 13) {month=1;  year++;}}
			else if(btn == 3) 	{System.out.println("연도 : "); int inyear = scanner.nextInt();
								 System.out.println("월  : "); int inmonth = scanner.nextInt();
								 if( inyear < 1900 || inyear > 9999 && inmonth < 1 || inmonth > 12 ){
									 System.out.println("지원하지 않는 날짜 입니다.");
								 }else {
									 year = inyear;
									 month = inmonth;
								 }
								 }
			else if(btn == 4) {  일정추가(); }
			else {}
		}
	} // run 메소드
	// 날짜 , 메모
	void 일정추가() {
		System.out.println("날짜 : ");	String cdate 	= scanner.next();
		System.out.println("메모 : ");	String ccoment	= scanner.next();
		boolean result = EX4DAO.getInstance().일정추가(cdate, ccoment );
		if( result) {System.out.println("메뉴 등록햇습니다.");}
		else		{System.out.println("메뉴 등록 실패했습니다.");}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	// 현재 월의 일정만
	void 일정출력() {
		HashMap< Integer, ArrayList<String> > map = EX4DAO.getInstance().일정출력();
		for( Integer key : map.keySet() ) {
			System.out.println(key + "\t");
			for( String s  :  map.get(key) ) {
				System.out.println( s + "\t");
			}
		}System.out.println();
	}
	
	// 현재 달력에 일정이 있는 달에는 *표시
}
































































