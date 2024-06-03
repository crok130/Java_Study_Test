package api_practice;

public class Practice04WrapperExample {

	public static void main(String[] args) {
		String scores = "100,11,35,41";
		
		int total = 0; 		// 총점
		double avg = 0.0;   // 평균
		
		// 작성
		// 특정 구분자를 이용해서 문자열 추출
		// 문자열.split("구분자");
		String[] strs = scores.split(",");
		// ["100"]["11"]["35"]["41"]
		for(String s : strs) {
			System.out.println(s);
			// Number == Byte, Short, Integer, Long, Float, Double
			int num = Integer.valueOf(s);	// 반환타입 : Integer
			num = Integer.parseInt(s);		// 반환타입 : int
			total += num;		// 변환된 정수값을 total 변수에 누적 합산 - 총점
		}
		
		
		avg = ((double)total / strs.length);
		System.out.println(scores);
		System.out.println("총점 : " + total + "점");
		System.out.printf("평균 : %.1f점 \n",avg);
		
	}

}









