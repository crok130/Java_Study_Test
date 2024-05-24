package practice_06;

/**
 * Bank Class 생성
 * Bank Class 를 상속 받는 BadBank, NormalBank, GoodBank class 작성 
 */

public class BankTest {

	public static void main(String[] args) {
		Bank b1 = new BadBank();
		Bank b2 = new NormalBank();
		Bank b3 = new GoodBank();
		
		System.out.println("BadBank의 이자율 : " + b1.getInterestRate());
		System.out.println("NormalBank의 이자율 : " + b2.getInterestRate());
		System.out.println("GoodBank의 이자율 : " + b3.getInterestRate());	
		
		
		// 추상 클래스는 독립적으로 객체 생성 불가
		// Bank bank = new Bank();
		// 추상 클래스는 상속받아 추상메소드의 기능을 구현한
		// 실체(자식)클래스 로만 인스턴스 생성 가능
		Bank bank = new GoodBank();
		
		Bank OneGradeBank = new Bank() {
			
			private double interestRate = 1.0;
			
			@Override
			double getInterestRate() {
				return this.interestRate;
			}
			
		};
		System.out.println("OneGradeBank 이자률 : " + OneGradeBank.getInterestRate());
		
		
	}

}











