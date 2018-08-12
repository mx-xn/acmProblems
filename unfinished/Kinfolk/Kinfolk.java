import java.util.Scanner;

public class Kinfolk {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

	}
	public static void getSum(int order, int num) {
		while (in.hasNext()) {
			int p1 = in.nextInt();	//first person num
			if (p1 == -1) 
				break;
			int p2 = in.nextInt();	//second person num
			String gender = in.next();
			getKinship(p1, p2, gender);
		}
	}

	public static void getKinship(int p1, int p2, String gender) {
		int[] range = new int[15];	//buil up the level ranges
		int sum = 0;
		int add = 2;
		for (int i = 0; i < 15; i++) {
			int[i] = sum; 
			sum = sum + add;
			add = add*2;
		}
		Arrays.toString
	}
}