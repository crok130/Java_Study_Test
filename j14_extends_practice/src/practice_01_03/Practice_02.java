package practice_01_03;


public class Practice_02 {

	public static void main(String[] args) {

		int[] lotto = new int[6];
		
		// int number = (int) (Math.random() * 45 + 1); // 참고
		// 작성
		// 1부터 45까지의 난수를 발생시켜 반본문을 사용해 lotto 배열을 순회하면서 난수를 배열에 적는 코드?
		for(int i = 0; i < lotto.length; i++) {
			int number = (int)(Math.random() * 45 + 1);
			lotto[i] = number;
		}
		
		// lotto 배열까지 반복하는i와 lotto배열까지 반복하는 i+1 의 j  두값을 배열로 비교하면
		// lotto[i] : lotto[0] lotto[1] lotto[2]
		// lotto[j] : lotto[1] lotto[2]	lotto[3]
		// 이런식으로 나오는데 (lotto[i] > lotto[j]) 이식이 참이 나오면 lotto[i]를 정수temp에 담고
		// lotto[i] = lotto[j] 대입연산을해서 [j]를 [i]에 대입후에 temp에 담기 lotto[i]를 lotto[j] = temp; 대입연산하면 오름차순 정리가 된다
		for(int i = 0; i < lotto.length; i ++) {
			for(int j = i+1; j < lotto.length; j++) {
				if(lotto[i] > lotto[j]) {
					int temp = lotto[i];
					lotto[i] = lotto[j];
					lotto[j] = temp;
				}
			}
		}
		
		// 결과 출력 코드 수정 x
		System.out.println("[ 결과 ]");
		for (int i : lotto) {
			System.out.print("[" +i+ "]");
		}
	}
}
