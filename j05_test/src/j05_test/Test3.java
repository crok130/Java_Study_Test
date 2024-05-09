package j05_test;

import java.util.Scanner;

/**
 Scanner와 조건문을 이용하여 사용자로부터 정수를 입력받아 해당 
 정수가 양수인지, 음수인지, 또는 0인지를 판별하여 출력하는 소스코드를 작성하시오. 
 양수 : input > 0
 음수 : input < 0
 input == 0
 */
public class Test3 {
	
	public static void main(String[] args) {
		
		// 사용자에게 console을 통해서 원하는 타입의 값을 입력받는 class
		Scanner sc = new Scanner(System.in);
		System.out.println("정수를 입력하세요.");
		
		int num = sc.nextInt();
		
		if(num > 0) {
			System.out.println("입력한 수는 양수 입니다.");
		}else if(num < 0) {
			System.out.println("입력한 수는 음수 입니다.");
		}else {
			// num == 0
			System.out.println("입력한 수는 0입니다.");
		}
		
	}

}




















