package test06;

public class Test {
	
	public static void main(String[] args) {
        int[] randomNumbers = new int[10];

        for (int i = 0; i < randomNumbers.length; i++) {
            randomNumbers[i] = (int) (Math.random() * 100) + 1;
        }

        System.out.print("최초의 리스트 : ");
        for (int num : randomNumbers) {
            System.out.print(num + " ");
        }

    
        for (int i = 0; i < randomNumbers.length; i++) {
            for (int j = i + 1; j < randomNumbers.length; j++) {
                if (randomNumbers[i] > randomNumbers[j]) {
                    int temp = randomNumbers[i];
                    randomNumbers[i] = randomNumbers[j];
                    randomNumbers[j] = temp;
                }
            }
        }

      
        System.out.print("\n정렬된 리스트 : ");
        for (int num : randomNumbers) {
            System.out.print(num + " ");
        }
	}
}
