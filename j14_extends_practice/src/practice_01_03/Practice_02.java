package practice_01_03;


public class Practice_02 {

	public static void main(String[] args) {
		
		// 중복제거, 정렬:오름차순
		int[] lotto = new int[6];
		// System.out.println(lotto[0]);
		// System.out.println(lotto[4]);
		
		int number = (int) (Math.random() * 45 + 1); // 참고
		// 작성
		lotto[0] = number;		// lotto 배열에 0번째 인덱스 항목에
								// number에 저장된 난수 저장
		for(int i = 1; i < lotto.length; i++) {
			
			// 1 ~ 45 까지의 난수를 배열 각 항목에 저장
			lotto[i] = (int) (Math.random() * 45 + 1); // 참고
			
			// 항목에 등록된 배열 정보 출력
			System.out.print("[");
			for(int n : lotto) {
				System.out.print(n+", ");
			}
			System.out.println("]");
			
			// 등록할려는 항목 이전의 값이랑 중복되는지 비교
			for(int j = 0; j < i; j++) {
				System.out.printf("%d == %d result : %b i : %d %n",lotto[i],lotto[j],(lotto[i] == lotto[j]),i);
				if(lotto[i] == lotto[j]) {
					// 동일한 값이 이미 배열에 등록이 되어있음.
					// lotto[i]에 새로운 난수로 값 저장
					// 배열 index 번호를 표현하는 i값을 1감소
					i--;
					break;
				}else if(lotto[i] < lotto[j]) {
					int temp = lotto[i];
					lotto[i] = lotto[j];
					lotto[j] = temp;
				}
			} // end 중복 체크 for
		} // end 난수 등록 for
		
		
		
		// 결과 출력 코드 수정 x
		System.out.println("[ 결과 ]");
		for (int i : lotto) {
			System.out.print("[" +i+ "]");
		}
	}
}
