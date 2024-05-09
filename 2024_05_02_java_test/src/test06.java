import java.util.Scanner;

public class test06 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("숫자를 입력해주세요 >");
		int num = sc.nextInt();
		int sum = 0;
		int odd = 0;
		for(int i = 1; i <= num; i++) {
			sum += i;
			if(i % 3 ==0) {
				odd += i;
			}
		}
		System.out.println("1부터 " +num+ "까지의 총합은 : " +sum);
		System.out.println("1부터 " +num+ "까지의 3의배수 총합은 : " +odd);
	}
}
