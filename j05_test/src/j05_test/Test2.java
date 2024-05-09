package j05_test;

public class Test2 {
	/**
	 	정수타입의 변수 두 개 num1과 num2를 선언하고, 
	 	이 두 변수에 각각 정수값으로 초기화하여
 		두 변수에 저장된 수의 합을 출력하는 소스코드를 작성하시오.
 		(각 변수의 초기값은 임의로 지정) [4점]
	 */
	public static void main(String[] args) {
		// byte, short, int, long
		// 두 변수를 선언과 동시에 초기화
		// int num1 = 10, num2 =20;
		
		// 두 변수를 각각 선언 후 값을 대입하여 초기화
		/*
		int num1;
		int num2;
		num1 = 10;
		num2 = 20;
		*/
		int num1 = 10;
		int num2 = 20;
		
		// System.out.println("두수의 합 : "+ (num1 + num2));
		int sum = num1 + num2;
		System.out.println("두수의 합 : " + sum);
		
	}

}








