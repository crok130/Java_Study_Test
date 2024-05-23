package practice_01_03;


public class Practice_03 {

	public static void main(String[] args) {
		// code 작성
		int[] numbers = new int[10];
		System.out.print("최초의 리스트 : ");
		for(int i = 0; i < numbers.length; i++) {
			// numbers 배열 각 항목에 1 ~ 100까지의 난수를 저장
			numbers[i] = (int)(Math.random() * 100) +1;
			// 줄바꿈 하지 않고 각 배열의 항목에 저장된 난수를 출력 후 공백 추가
			System.out.print(numbers[i] + " ");
		}

		
		
		// 내림차순 정리해주는코드
		for(int i = 0; i < numbers.length; i++) {
			for(int j = i+1; j < numbers.length; j++) {
				if(numbers[i] < numbers[j]) {
					int temp = numbers[i];
					numbers[i] = numbers[j];
					numbers[j] = temp;
				}
			}
		}
		
		// 내림차순 출력
		System.out.print("\n정렬 리스트 : ");
		for(int i : numbers) {
			System.out.print(i+ " ");
		}
		
	}
}
