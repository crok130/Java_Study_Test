package test;

import java.util.Scanner;

public class Test05 {

	public static void main(String[] args) {
		final int size = 10;
		int[] seats = new int[size];
		boolean isRun = true;
		while(isRun) {
			System.out.println("------------------------");
			for(int i = 0; i < size; i++) {
				System.out.print(i+1 + " ");
			}
			System.out.println("\n------------------------");
			for(int i = 0; i <size; i++) {
				System.out.print(seats[i] + " ");
			}
			System.out.println("\n------------------------");
			
			System.out.print("원하시는 좌석번호를 입력하세요(종료는 -1) : ");
			Scanner sc = new Scanner(System.in);
			int s = sc.nextInt();
			if(s == -1) {
				System.out.println("종료");
				isRun = false;
				break;
			}
			if(seats[s-1] == 1) {
				System.out.println("예약된좌석입니다 다른좌석을 예약해주요");
				continue;
			}

			seats[s -1] = 1;

		}
	}
}
