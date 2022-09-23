package ch2연산자;

public class EX1_연산자 {// class start 

	public static void main(String[] args) {
		
		// 1. 산술 
		int 정수1 = 10; int 정수2 = 20;
		System.out.println(" 1.더하기 : "+ 정수1 + 정수2 );
		System.out.println(" 2.더하기 : "+ (정수1 + 정수2) );
		System.out.println(" 3.빼기 : "+(정수1 - 정수2) );
		System.out.println(" 4.곱하기 : "+(정수1 * 정수2));
		System.out.println(" 5.나누기 : "+(정수1 / 정수2) );
		System.out.println(" 6.나머지 : "+(정수1 % 정수2) );
		// 2. 비교 
		System.out.println(" 7.이상 : " + (정수1 >= 정수2) );
		System.out.println(" 8.이하 : " + (정수1 <= 정수2) );
		System.out.println(" 9.초과 : " + (정수1 > 정수2) );
		System.out.println(" 10.미만 : " + (정수1 < 정수2) );
		System.out.println(" 11.같다 : " + (정수1 == 정수2) );
		System.out.println(" 12.같지않다 : " + (정수1 != 정수2) );
		// 3. 논리
		int 정수3 = 30; int 정수4 = 40;
		System.out.println(" 13.&&[AND] " + (정수1 >= 정수2 && 정수3 >= 정수4));
		System.out.println(" 14.||[OR] " + (정수1 >= 정수2 || 정수4 >= 정수3 ));
		// 4. 증감 
		int 정수5 = 10;
		System.out.println(" 후위증가 : " + (정수5++) );	// 출력 후에 1 증가 
		System.out.println(" 확인 : " + 정수5 );
		System.out.println(" 선위증가 : " + (++정수5) );	// 출력 전에 1 증가 
		System.out.println(" 후위감소 : " + (정수5--) );	// 출력 후에 1 감소 
		System.out.println(" 확인 : " + 정수5 );
		System.out.println(" 선위감소 : " + (--정수5) );  	// 출력 전에 1 감소
		
		// 5. 대입연산자 
		int 정수6 = 10;	// = : 대입
		정수6 += 3 ;		// += : 오른쪽 데이터를 왼쪽에 더한 후에 대입 
			// 1.  정수6 + 3  -> 13       2. 정수6 = 13
		System.out.println(" 대입 결과 : " + 정수6);
		
		정수6 -= 5;		// 1. 정수6-5 -> 8   2. 정수6 = 8
		System.out.println(" 대입 결과 : " + 정수6 );
		
		// 6. 삼항연산자 
		int 점수 = 85;
		char 등급 = 점수 > 90 ? 'A' : 'B';	// 조건식 ? 참 : 거짓 
				 // 만약에 점수가 90점 초과이면 'A' 대입 아니면 'B'대입
		System.out.println(" 등급 결과 : " + 등급 );
		
		char 등급2 = 점수 > 90 ? 'A' : 점수 > 80 ? 'B' : 'C' ;
		System.out.println(" 등급 결과 : " + 등급2 );
		
		
		
	} // main end 
}// class end 
/*
 	연산자 : 계산시 사용되는 특수문자 
 		1.산술연산자
 			+ 더하기 -빼기 *곱하기 /나누기 %나머지
 			+ 연결연산자
 		2.비교연산자 -> 결과 : true 혹은 false
 			>=이상[크거나같다]	>초과[크다]	==[같다]
 			<=이하[작거나같다]	<미만[작다]	!=[같지않다/다르다]
 		3.논리연산자 : 비교연산자 2개 이상 작성 
 			 5 <= a <= 10 [x] ---> and / or ---> a>=5 && a<=10
 			&& : and[ 이면서 면서 이고 그리고 모두 ]
 			|| : or[ 이거나 거나 또는 하나라도 ]
 			! : not[ 부정(반대) : true -> false / false -> true ]
 		4.대입연산자
 			= : 오른쪽 데이터를 왼쪽에 저장(대입)
 			+= : 오른쪽 데이터를 왼쪽 데이터와 더한 후 왼쪽에 대입 
 			*= /= %= -=
 		5.증감연산자
 			변수++ [ 1증가 ]
 			변수-- [ 1감소 ]
 		6.삼항연산자
 			 조건식 ? 참 : 거짓
 			 조건식1 ? 조건식2 ? 참2 : 거짓2 : 거짓1  ---> 조건식이 많으면 가독성 떨어짐 -> if 사용 
 			 
 */