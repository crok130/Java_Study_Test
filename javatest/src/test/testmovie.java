package test;

import java.util.Scanner;

public class testmovie {

	public static void main(String[] args) {
        String[][] seats = new String[10][11]; 
        int columnLabel = 65; 
        Scanner sc = new Scanner(System.in);
        boolean isRun = true;
        for (int i = 0; i < seats.length; i++) {
            for (int j = 0; j < seats[i].length; j++) {
                seats[i][j] = (j == seats[i].length - 1) ? " [" + (char)(columnLabel++) + "열" + "]" : "[□]"; 
            }
        } 
        
        while(isRun) {
        	int count = 0;
            System.out.println("             SCREEN");
            for (int i = 0; i < 10; i ++) {
            	count ++;
            	System.out.print("["+count+"]");
            }
            System.out.println();
            
            for (String[] row : seats) {
                for (String seat : row) {
                    System.out.print(seat);
                }
                System.out.println(); 
            } // 좌석출력
        	System.out.println("예약할 좌석의 열을 입력해주세요");
        	char input = sc.next().charAt(0);
        	System.out.println("입력한 열 : "+input);
        	System.out.println("예약할 좌석의 행을 입력해주세요");
        	int num = sc.nextInt();
        	System.out.println("선택하신 좌석운 : " +input+"열" +num+"행입니다."); 
        	System.out.println("예약 완료 하시겠습니까? y/n");
        	char s = sc.next().charAt(0);
           	if(s == 'y' && seats[input-65][num -1] .equals ("[■]")) {
           		System.out.println("이미 예약이 완료된 좌석입니다.");
        	}else if(s == 'y') {
        		seats[input-65][num -1] = ("[■]");
        	}else if(s == 'n'){
        		System.out.println("예약을 취소하겠습니다.");
        	}
        	
        } 
	}
}
