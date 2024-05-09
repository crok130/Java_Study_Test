package practice;

import java.util.Scanner;

public class ArrayPractice {

	public static void main(String[] args) {
		//  arr 배열 중에서 값이 60인 곳의 인덱스 번호를 
		// 출력하는 소스코드를 작성하시오.
		// 일차원 배열 arr 선언과 동시에 초기화
		int[] arr = {10, 20, 30, 50, 3, 60, -3};
		for(int i = 0; i < arr.length; i++) {
			// System.out.println(i + "번째 인덱스 항목 : " + arr[i]);
			if(arr[i] == 60) {
				System.out.println("60은 "+ i +"번째 인덱스에 위치");
				// 지정된 위치를 출력하고 나면 더이상 순회할 필요없으므로 반복문 탈출
				break; 
			}
		} // end for
		
		//  0   1   2    3  4  5    6
		// {10, 20, 30, 50, 3, 60, -3};
		// arr 배열의 인덱스 번호가 3인 곳은 출력하지 말고, 나머지만 출력해보자.
		for(int i = 0; i < arr.length; i++) {
			// 인덱스 번호가 3인 곳은 출력하지 않는다.
			/*
			if(i == 3) {
				continue;
			}
			System.out.println("arr["+i+"] : " + arr[i]);
			*/
			if(i != 3) {
				// i[인덱스 번호] 가 3이 아닐 경우에 수행
				System.out.println("arr["+i+"] : " + arr[i]);
			}
		}// end for
		
		/*
			arr 배열 안의 변경하고 싶은 값의 인덱스 번호를 입력받아, 
			그 값을 1000으로 변경해보자.
			예) 입력받은 인덱스 번호 : 3
            {10, 20, 30, 1000, 3, 60, -3}
		 */
		Scanner sc = new Scanner(System.in); // import 추가
		
		System.out.println("변경할 인덱스 번호를 입력하세요 > ");
		int index = sc.nextInt();
		System.out.println("입력한 인덱스 번호 : " + index);
		// 해당되는 인덱스 번호를 가진 항목의 값을 1000으로 변경
		arr[index] = 1000;
		
		for(int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println();
		
		
		/*
		  인덱스 번호 2개를 입력받아, 그 값이 저장된 위치를 서로 바꾸고 출력하시오.
    		예) 인덱스: 1    인덱스: 2
변경전    		{10, 20, 30, 50, 3, 60, -3};
변경후       		{10, 30, 20, 50, 3, 60, -3}
		 */
		System.out.println("변경할 첫번째 인덱스 번호를 입력 > ");
		int first = sc.nextInt();
		System.out.println("변경할 두번째 인덱스 번호를 입력 > ");
		int second = sc.nextInt();
		System.out.println("변경할 인덱스 번호 1 : " + first+", 2 : "+second);
		// 1 : 0, 2 : 4
//                        0   1   2   3  4   5   6 
//		변경전    		{10, 20, 30, 50, 3, 60, -3};
		int temp = arr[first];		// temp == 10;
		arr[first] = arr[second];
//		변경후    		{3, 20, 30, 50, 3, 60, -3};
		arr[second] = temp;
//		변경후    		{3, 20, 30, 50, 10, 60, -3};
		
		for(int i : arr) {
			System.out.print(i+" ");
		}
		System.out.println();
	} // end main

} // end class









