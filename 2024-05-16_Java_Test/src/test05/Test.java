package test05;

public class Test {

	public static void main(String[] args) {
	       int sum = 0;

	        for (int i = 0; i < 10; i++) {
	            int randomNum = (int) (Math.random() * 100) + 1;
	            System.out.print(randomNum + " ");
	            sum += randomNum;
	        }
	        
	        System.out.println("난수 총합계: " + sum);
	}
}
