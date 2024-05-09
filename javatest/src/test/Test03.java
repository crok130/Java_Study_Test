package test;

import java.util.Scanner;

public class Test03 {

	public static void main(String[] args) {
		
        int[] arr = {10, 20, 30, 1000, 3, 60, -3};
        Scanner scanner = new Scanner(System.in);

        System.out.print("변경하고 싶은 값의 인덱스 번호를 입력하세요: ");
        int index = scanner.nextInt();

        if (index >= 0 && index < arr.length) {
            arr[index] = 1000;
        } else {
            System.out.println("유효하지 않은 인덱스 번호입니다.");
        }
        System.out.println("index "+ index  +" 값은 : "+arr[index]);
	}
}
