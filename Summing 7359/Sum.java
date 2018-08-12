import java.util.Scanner;

public class Sum {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int i = in.nextInt();
		for (int k = 0; k < i; k++) {
			int order = in.nextInt();
			int num = in.nextInt();
			getSum(order, num);
		}

	}
	public static void getSum(int order, int num) {
		int sum;
		int sumOdd;
		int sumEven;

		sum = (1 + num)*num/2;
		sumOdd = (1 + 1 + (num - 1)*2)*num/2;
		sumEven = (2 + 2 + (num - 1)*2)*num/2;

		System.out.println(order + " " + sum + " " + sumOdd + " " + sumEven);
	}
}