import java.util.Scanner;

public class StarArrangements {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()) {
			long star = sc.nextLong();
			arrangements(star);
		}
	}

	public static void arrangements(long star) {
		long max = (star + 1) / 2;
		System.out.println(star + ": ");
		for (long i = 2; i < max + 1; i++) {
			ifMod0Prlong(i, i - 1, star);
			if (i + i <= star)
				ifMod0Prlong(i, i, star);
		}
	}

	public static void ifMod0Prlong(long i, long j, long star) {
		if (star%(i + j) == 0 || (star - i)%(i + j) == 0)
			System.out.println( " " + i + "," + j);
	}
}