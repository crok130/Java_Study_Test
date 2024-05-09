package practice;

import java.util.Scanner;

public class TheaterReserveRowColumn {

	public static void main(String[] args) {
		// 해당 자리에 저장된 값이  0이면 빈자리
		// 예약이 완료된 자리는 1로 표현
		byte[][] seats = new byte[10][10];
		/*
		seats[1][2] = 1;
		for(byte[] line : seats) {
			for(byte column : line) {
				// ㅁ(미음) + 한자 키 + page down + 5 = □
				// ㅁ(미음) + 한자 키 + page down + 6 = ■
				if(column == 0) {
					System.out.print("[□]");
				}else {
					System.out.print("[■]");
				}
				// System.out.printf("[%d]",column);
			} // 한라인 출력
			System.out.println();
			// 출력후 줄바꿈
		} // end for
		*/
		
		// 극장 예약 프로그램 종료 flag
		boolean isRun = true;
		// 예약 좌석 정보를 입력받기 위한 Scanner 선언및 초기화
		Scanner sc = new Scanner(System.in); // import 추가
		
		while(isRun) {
			System.out.println("               [SCREEN]");
			// 열번호를 출력
			for(int i = 1; i <= seats.length; i++) {
				System.out.print("["+i+"]");
			}
			// 좌석번호 출력 후 줄바꿈
			System.out.println(" [열]");
			
			// 좌석 표시
			for(int i = 0; i < seats.length; i++) {
				for(int j = 0; j < seats[i].length; j++) {
					if(seats[i][j] == 0) {
						System.out.print("[□]");
					}else {
						System.out.print("[■]");
					}
				} // end 한행의 열정보 출력
				System.out.println(" ["+(char)(i+65)+"행]");
			} // end 10개의 행 정보 출력 , 상영관 그리기 완료, 좌석표시 끝
			
			System.out.println("예약하실 좌석의 행이름을 입력해주세요.(A-J)");
			String s = sc.next(); // A ~ J
			System.out.println(s);
			// "ABCDEF".charAt(0) == 'A'
			// A == 65
			// j == 74
			char inputRow = s.charAt(0);
			System.out.println(inputRow);
			if(inputRow < 65 || inputRow > 74) {
				System.out.println("선택 할 수 없는 행입니다.");
				continue;
			}
			
			// 65 ~ 74 일 경우 수행
			System.out.println("선택하신 행 이름은 : " + inputRow);
			
			// 좌석 열 번호 입력받기 1 ~ 10
			System.out.println("예약하실 좌석의 열번호를 입력해 주세요.(1-10)");
			boolean isNumber = sc.hasNextInt();
			if(!isNumber) {
				System.out.println("예약할 수 있는 열 번호를 입력하세요.");
				continue;
			}
			
			// scanner 에 저장된 사용자가 입력한 값이
			// 정수 타입일 경우 입력한 값을 꺼내와 inputColumn 변수에 저장
			int inputColumn = sc.nextInt();
			
			if(inputColumn < 1 || inputColumn > 10) {
				System.out.println("사용할 수 없는 열번호입니다.");
				continue;
			}
			// 정상적인 행과 열정보 입력 시 출력
			System.out.printf("선택하신 좌석은 %s행 %d열입니다. %n",inputRow, inputColumn);
			
			// 중복 예약 인지 확인
			// inputRow == A == 65 == 0
			// inputRow == J == 74 == 9
			
			// char 알파벳에서 65를 차감하여 인덱스 번호로 활용
			int row = inputRow - 65;
			// 1 ~ 10 : 0 ~ 9 인덱스로 변환
			int column = inputColumn - 1;
			
			// 중복 예약 처리
			if(seats[row][column]  != 0) {
				// 이미 예약된 자리
				System.out.println("이미 예약이 완료된 좌석입니다.");
				continue;
			}
			
			// 예약 진행
			System.out.println("예약을 완료 하시겠습니까? y / n");
			String selected = sc.next();
			
			switch(selected){
				case "Y" : case "y" : case "ㅛ" :
					seats[row][column] = 1;
					System.out.println("예약이 완료되었습니다.");
					break;
				case "N" : case "n" : case "ㅜ" :
					System.out.println("예약이 취소되었습니다.");
					break;
				default : 
					System.out.println("프로그램을 종료합니다.");
					isRun = false;
			}
			
			
		} // end while
		
	} // end main
} // end TheaterReserveRowColumn class










