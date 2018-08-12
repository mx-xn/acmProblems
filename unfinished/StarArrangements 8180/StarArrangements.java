import java.util.Scanner;

public class StarArrangements {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()) {
			int star = sc.nextInt();
			arrangements(star);
		}
	}

	public static void arrangements(int star) {
		int max = (star + 1) / 2;
		System.out.println(star + ": ");
		for (int i = 2; i < max + 1; i++) {
			ifMod0Print(i, i - 1, star);
			if (i + i <= star)
				ifMod0Print(i, i, star);
		}
	}

	public static void ifMod0Print(int i, int j, int star) {
		if (star%(i + j) == 0 || (star - i)%(i + j) == 0)
			System.out.println( " " + i + "," + j);
	}
}