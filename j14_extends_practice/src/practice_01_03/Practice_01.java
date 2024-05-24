package practice_01_03;

import java.util.Scanner;

public class Practice_01 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		// sample id
		String myId = "id001";
		System.out.println(myId.toString());
		System.out.println(myId);
		// 객체가 저장되어 있는 메모리 주소를 10진법의 int type의 정수로 반환
		// null 은 0을 반환
		int address = System.identityHashCode(myId);
		System.out.println("myId address : " + address);
		
		String tempId = "id001";
		address = System.identityHashCode(tempId);
		System.out.println("tempId address : " + address);
		
		System.out.println(myId == tempId);
		
		System.out.print("아이디 입력>");
		
		String id = sc.next();
		
		if(myId.equals(id)) {
			System.out.println("아이디가 일치합니다.");
		}else {
			System.out.println("아이디가 일치하지 않습니다.");
		}
		sc.close();
	}
}
