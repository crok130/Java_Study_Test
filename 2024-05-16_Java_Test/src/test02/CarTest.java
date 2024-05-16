package test02;

public class CarTest {

	public static void main(String[] args) {
		Car mycar = new Car();
		mycar.color = "red";
		mycar.speed = 0;
		mycar.gear =1;
		System.out.println(mycar.showInfo());
		
		mycar.speedUp();
		mycar.gear = 2;
		System.out.println(mycar.showInfo());
		
		mycar.speedDown();
		mycar.gear =1;
		System.out.println(mycar.showInfo());
	}
}
