package practice_06;

public class NormalBank extends Bank{

	// Bank를 상속 받아서 getInterestRate를 오버라이드한후 값을 리턴해서 반환
	@Override
    double getInterestRate() {
        return 5.0;
    }
}
