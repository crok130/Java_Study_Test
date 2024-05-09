package j05_test;

import java.util.Scanner;

public class TestFor {

	public static void main(String[] args) {
		/*
		 반복문과 조건문을 이용하여 1부터 100까지의 정수 중에서 3의 배수만 
		 콘솔을 통해 출력하는 소스코드를 작성하시오.(한라인에 출력)
		 */
		/*
		System.out.print(3+" ");
		System.out.print(6+" ");
		System.out.print(9+" ");
		*/
		for(int i = 1; i <= 100; i++) {
			// i에 저장된 값을 3으로 나누었을때 남는 나머지
			// if(i % 3 == 0) System.out.print(i+" "); // end if
			if(i % 3 != 0) {
				// 3의 배수가 아닐 경우는 출력문 생략하고 반복문으로 복귀
				continue;
			}
			System.out.print(i+" ");
		} // end for
		
		// 반복문을 이용하여 구구단 중에서 7단을 출력하는 Java 프로그램을 작성하세요.
		// for(int i = 1; i < 10; i ++) {
		for(int i = 1; i <= 9; i ++) {
			int result = 7 * i;
			System.out.println("7 * "+ i +" = " + result);
			System.out.println("7 * "+ i +" = " + 7 * i);
			System.out.println("7 * "+ i +" = " + (7 * i));
		} // end for
		/*
		 반복문과 출력문을 이용하여 구구단을 다음의 출력처럼 나오게 작성하여 
		 프로그램 소스코드를 작성하시오. (공백은 \t 이스케이프 문자 사용)
		 */
		// 단수를 표현
		for(int i = 2; i <= 9; i++) {
			
			for(int j = 2; j < 10; j++) {
				// System.out.print(i + " * "+ j +" = " + (i*j)+"\t");
				System.out.printf("%d * %d = %02d\t", i, j, (i*j));
			}
			
			System.out.println();
		}
		
		/*
		 - Scanner를 사용하여 0보다 큰 양의 정수를 입력받는다. 
		 - 1에서부터 입력받은 수까지의 총 합계와 3의 배수의 합계를 구하여 출력
		 */
		Scanner sc = new Scanner(System.in); // import 추가
		// 총합계 , 3의배수 합계
		int total, sum;
		total = sum = 0;
		System.out.println("숫자를 입력하세요 > ");
		
		int num = sc.nextInt();
		// 1에서 부터 1씩 증가하되 num을 초과하면 종료
		for(int i = 1; i <= num; i++) {
			total += i; // 총 합계
			if(i % 3 == 0) {
				sum += i; // 3의 배수 총합계
			}
		} // end for
		System.out.printf("1부터 %d까지의 총합계 : %d \n",num ,total);
		System.out.printf("1부터 %d까지의 3의배수의 총합계 : %d \n",num ,sum);
		
	}// end main
} // end class











