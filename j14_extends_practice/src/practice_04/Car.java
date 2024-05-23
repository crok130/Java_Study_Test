package practice_04;

public class Car extends Object 
{

	String color;
	int speed;
	int gear;
	
	// 반환 받을 필요가 없어서 void 로 정의
	void speedUp(){
		speed += 10;
	}
	
	void speedDown() {
		speed -= 10;
	}
	
	void changeGear(int gear){
		this.gear = gear;
	}

	@Override
	public String toString() {
		return "Car [color=" + color + ", speed=" + speed + ", gear=" + gear + "]";
	}
	
	
}
