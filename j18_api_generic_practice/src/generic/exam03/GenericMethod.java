package generic.exam03;

import java.util.Arrays;

public class GenericMethod {

	/*
	 * printArray method 정의 
	 * 
	 */
	public static <T> void printArray(T[] array) {
		System.out.println(Arrays.toString(array));
	}
	/*
	public static void printArray(Object[] array) {
		for(Object o : array) {
			System.out.print(o+ " ");
		}
		System.out.println();
	}
	*/
	public static void main(String[] args) {
		Integer[] iArray = {10,20,30,40,50};
		Double[] dArray = {1.1, 1.2, 1.3, 1.4, 1.5};
		Character[] cArray = {'K','O','R','E','A'};
		
		GenericMethod.<Integer>printArray(iArray);
		printArray(dArray); // 컴파일러가 매개변수 타입을 보고 제네릭 타입 유추
		printArray(cArray);
	}
	
}
