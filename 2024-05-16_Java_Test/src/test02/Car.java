package test02;

public class Car {

	String color;
	int speed;
	int gear;
	
	void speedUp(){
		this.speed = 10;
	}
	
	void speedDown() {
		this.speed = 0;
	}
	
	String showInfo(){
		return "Car [ color ="+this.color+", speed ="+this.speed+", gear="+this.gear+ "]";
	}
}
