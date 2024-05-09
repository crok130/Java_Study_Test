package j05_test;

public class TestArray {

	public static void main(String[] args) {
		/*
		 주어진 정수 배열 numbers의 반복문을 사용하여 
		 모든 요소를 출력하는 소스코드를 작성하시오.
		 */
		
		int[] numbers = { 1, 2, 3, 4, 5 };
		//  0   1   2   3   4    - index 번호
		// [1] [2] [3] [4] [5]
		// numbers[0] - numbers 배열에 0번째 인덱스에 있는 요소(항목)의 값
		// 배열 항목 - 요소의 개수
		System.out.println(numbers.length);
		// 배열의 시작 인덱스 번호 : 0
		// 배열의 마지막 인덱스 번호 : numbers.length - 1
		for(int i = 0; i < numbers.length;i++) {
			System.out.println(numbers[i]);
		}
		
		// 존경
		System.out.println(numbers[0]);
		System.out.println(numbers[1]);
		System.out.println(numbers[2]);
		System.out.println(numbers[3]);
		System.out.println(numbers[4]);
		
		/*
		 주어진 정수 배열 numbers에서 홀수의 개수가 
		 몇 개인지 출력하는 소스코드를 작성하시오.
		 */
		numbers = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		
		// for문으로 배열을 순회 완료 하고 난 다음에 
		// 홀수의 개수를 저장할 변수
		int count = 0;
		
		for(int i = 0; i < numbers.length; i++) {
			// 홀수 여부를 판단하는 조건문
			// if(numbers[i] % 2 == 1) {
			if(numbers[i] % 2 != 0) {
				// numbers[i] 항목의 값이 홀수 일때 실행
				count++;
			}// end if
		} // end for
		// for문 반복 작업 수행 후 홀수의 개수가 저장된 count 변수를 출력
		System.out.println("홀수의 개수는 : " + count);
		
		/*
		 	반복문을 활용하여 주어진 2차원 배열 matrix의 
		 	모든 요소(항목)의 값을 더하여 합계를 출력하는 소스코드를 작성하시오.
		 */
		int[][] matrix = {
						//   0  1  2
							{1, 2, 3},	// matrix[0]
						//   0  1  2
							{4, 5, 6},	// matrix[1]
						//   0  1  2
							{7, 8, 9}	// matrix[2]
						 };
		// matrix   -  [0,0][0,1][0,2]
		// matrix   -  [1,0][1,1][1,2]
		// matrix   -  [2,0][2,1][2,2]
		
		// matrix[0] == {1, 2, 3}; matrix[0][0],matrix[0][1],matrix[0][2]
		// matrix[1] == {4, 5, 6}; matrix[1][0],matrix[1][1],matrix[1][2]
		// matrix[2] == {7, 8, 9}; matrix[2][0],matrix[2][1],matrix[2][2]
		
		// 배열의 전체 합계를 저장할 변수
		int sum = 0;
		
		for(int i = 0; i < matrix.length; i ++) {
			// System.out.println(matrix[i]);
			for(int j = 0; j < matrix[i].length; j++) {
				sum += matrix[i][j];
			}
		}
		System.out.println("총합은 : " + sum);
		
		// 향상된 for문
		int total = 0; // 총합을 저장할 변수
		System.out.println(matrix);
		for(int[] arr : matrix) {
			System.out.println(arr);
			for(int i : arr) {
				total += i;
			}
		}
		System.out.println("총합은 : " + total);
		
	}// end main
} // end class













