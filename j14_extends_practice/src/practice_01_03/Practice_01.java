package practice_01_03;

import java.util.Scanner;

public class Practice_01 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		// sample id
		String myId = "id001";
		
		System.out.print("아이디 입력>");
		String id = sc.next();
		
		
		// if(myId == id) {
		// 문자열 비교연산을 할땐 == 가 아니라 equals 가 들어가야해서 원하는결과가 나오지않음
		if(id.equals(myId)) {
			System.out.println("아이디가 일치합니다.");
		}else {
			System.out.println("아이디가 일치하지 않습니다.");
		}
		sc.close();
	}
}
