package 협업과제;

import java.util.Scanner;

public class 개인과제_박수현_윤상진 {
   
   public static void main(String[] args) {
      
      int p_hp =100;
      int p_heat;
      int p_level = 1;
      
      int m_hp = 100;
      int m_heat = 20;
      int m_level = 1;
      int count = 0;
      
      
      Scanner scanner = new Scanner(System.in);
      while(true) {
         System.out.println("■■■■■■■■■■■포켓몬스터■■■■■■■■■■■");
         System.out.println("난 몬스터 레벨:" + m_level );
         System.out.println( (m_hp + 20*count));
         System.out.println("|\\_/|");
	     System.out.println("|q p|   /}");
		 System.out.println("( 0 )\"\"\"\\");
		 System.out.println("|\"^\"`    |");
		 System.out.println("||_/=\\\\__|");
         System.out.println();
         System.out.println("	   vs	");
         System.out.println();
         System.out.println("\t\t\\    /\\");
 		 System.out.println("\t\t )  ( ')");
 		 System.out.println("\t\t(  /  )");
 		 System.out.println("\t\t \\(__)|");
         System.out.println("\t\t 난 플레이어 레벨" + p_level);
         System.out.println("\t\t " + (p_hp+ 10*count));
         System.out.println("1.찌르기 2. 몸통박치기(필살기) 3.도망가기");
         System.out.println("■■■■■■■■■■■당신의 선택은■■■■■■■■■■■");
         if( p_hp <= 0) {
             System.out.println("플레이어가 사망했습니다.");
             System.err.println("game over");
             break;
          }
         System.out.print(" 선택 : "); int btn = scanner.nextInt();
         
         	// 1.찌르기
			// 1.찌르기
			// 1.찌르기
            if( btn == 1) {
               p_heat = (int)(Math.random()*20+10);
               System.out.println(p_heat + " 데미지를 입혔습니다.");
               m_hp -= p_heat; 
               if( m_hp <= 0 ) {
                  System.err.println("몬스터를 처치했습니다.");
                  count ++;
                  m_hp = 100;   p_hp= 100;
                  m_heat += 10;
                  m_level ++;
                  p_level ++;
               }
               else if(m_hp > 0) {
                  System.out.println("몬스터 차례입니다.");
                  System.out.println("몬스터가"+ m_heat +"데미지를 입혔습니다.");
                  p_hp -= m_heat;
               }
            }
            // 2.찌르기
            // 2.찌르기
            // 2.찌르기
            else if( btn == 2) {
               p_heat = (int)(Math.random()*35+30);
               System.out.println(p_heat + " 데미지를 입혔습니다.");
               m_hp -= p_heat; 
               if( m_hp <= 0 ) {
                  System.err.println("몬스터를 처치했습니다.");
                  count ++;
                  m_hp = 100;   p_hp= 100;
                  m_heat += 10;
                  m_level ++;
                  p_level ++;
               }
               else if(m_hp > 0) {
                  System.out.println("몬스터 차례입니다.");
                  System.out.println("몬스터가"+ m_heat +"데미지를 입혔습니다.");
                  p_hp -= m_heat;
               }
            }
            // 3.찌르기
            // 3.찌르기
            // 3.찌르기
            else if( btn == 3) { 
               int run = (int)(Math.random()*10+1); 
               if( run <= 3) {
                  System.out.println(" 도망에 성공했습니다. ");
                  m_hp -=20;
                  if(m_hp <= 0) {
                     System.out.println("더 이상 도망갈 수 없습니다.");
                     System.err.println("당신은 찌질해 주거");
                     break;
                  }
               }
               else {
                  System.out.println("도망에 실패했습니다. 계속 싸우세요");
                  System.out.println("몬스터 차례입니다.");
                  System.out.println("몬스터가"+ m_heat +"데미지를 입혔습니다.");
                  p_hp -= m_heat;
               }
            }
         // 그 외
         // 그 외
         // 그 외
            else {System.out.println("잘못된 번호입니다.");}
      	}
   	}
}