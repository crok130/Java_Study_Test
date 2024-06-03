package api_practice;

import java.util.Arrays;
import java.util.Random;

/**
	1. 1~100까지의 난수를 발생해 int형 배열에 10개의 값을 담고 
	아래와 같이 출력 후 오름차순으로 정렬해서 출력 될 수 있도록 코드를 작성하시오.
	(Random class 와 Arrays class 사용)
*/
public class Practice01ArraysRandomExample {

	public static void main(String[] args) {
		
		int[] arrays = new int[10];	// 10개의 정수값을 저장할 배열
		
		Random random = new Random(); // import 추가
		// 무작위 boolean, int, double 값을 추출 Math.random() == random.nextDouble()
		for(int i = 0; i < arrays.length; i++) {
			//          0 <= ~ < 100 
			arrays[i] = random.nextInt(100) + 1; // 1  <= ~ < 100 + 1
		}
		
		System.out.println("최초의 리스트 : " + Arrays.toString(arrays));
		
		// 배열 각 항목의 값을 오름차순으로 정렬
		Arrays.sort(arrays);
		
		System.out.println("정렬된 리스트 : " + Arrays.toString(arrays));
		
		
	}

}
















