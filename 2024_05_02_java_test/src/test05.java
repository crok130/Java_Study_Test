
public class test05 {

	public static void main(String[] args) {
		for(int i = 2; i <= 9; i++) {
			for(int j = 2; j <= 9; j++) {
				System.out.printf("%d * %d = %2d\t" , j, i, (i * j));
			}
			System.out.println();
		}
	}
}
