import java.util.Scanner;

public class Periodic {
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		while(in.hasNext()) {
			String str = in.next();
			int maxK = str.length()/2;    //maximum k can get if
										  //the String is periodic
			boolean result = false;
			int k = 1;	
			while(k <= maxK) {
				if (str.length()%k == 0) {
					result = isPeriodic(str, k);
					if (result)
						break;
				}
				k++;
			}
			if (result) //if k is found
				System.out.println(k);
			else
				System.out.println(str.length());
		}
	}

	public static boolean isPeriodic(String str, int k) {
		for(int i = k; i < str.length(); i++) {
			if (str.charAt(i) != str.charAt((i - i/k)%k))
				return false;
		}
		return true;
	}
}
