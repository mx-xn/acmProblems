import java.util.Scanner;

public class PurpleRain {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			String str = sc.nextLine();
			purpleRain(str);
		}
	}

	public static void purpleRain(String str) {
		int add = 0;
		int max1 = 0;
		int max2 = 0;

		int start1 = 0;
		int end1 = 0;

		int start2 = 0;
		int end2 = 0;
		for (int i = 0; i < str.length(); i++) {
			for (int j = i; j < str.length(); j++) {
				if (str.charAt(j) == 'B')
					add++;
				else	//str.charAt(j) == 'R'
					add--; 
				if (add > max1) {
					start1 = i;
					end1 = j;
					max1 = add;
				}
			}
			add = 0;
		}

		for (int i = 0; i < str.length(); i++) {
			for (int j = i; j < str.length(); j++) {
				if (str.charAt(j) == 'B')
					add--;
				else	//str.charAt(j) == 'R'
					add++; 
				if (add > max2) {
					start2 = i;
					end2 = j;
					max2 = add;
				}
			}
			add = 0;
		}

		if (max1 > max2)
			System.out.println((start1 + 1) + " " + (end1 + 1));
		else if (max2 > max1) 
			System.out.println((start2 + 1) + " " + (end2 + 1));
		else {
			//max1 == max2
			if (start1 < start2)
				System.out.println((start1 + 1) + " " + (end1 + 1));
			else if (start1 > start2)
				System.out.println((start2 + 1) + " " + (end2 + 1));
			else {
				//start1 == start2
				if (end1 < end2)
					System.out.println((start1 + 1) + " " + (end1 + 1));
				else
					System.out.println((start2 + 1) + " " + (end2 + 1));
			}
		}
	}
}