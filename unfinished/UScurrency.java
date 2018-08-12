import java.util.*;

public class UScurrency {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		numWays(n);
	}

	public static void numWays(int n) {
		int[] coins = {1, 5, 25, 50, 100, 500, 2000};
		int[][] arr = new int[n][7];
		arr[0][0] = 1;
		for(int i = 1; i < 7; i++) 
			arr[0][i] = 1;
		for(int i = 1; i < n; i++) 
			arr[i][0] = 1;

		for (int i = 1; i < n; i++) {		//row
			for (int j = 1; j < 7; j++) {	//column
				int precClmn = arr[i][j-1];
				int precRow = 0;
				if (i/coins[j] > 0) {
					precRow = 1;
					if (i/coins[j] > 1)
						precRow = arr[i-coins[j]][j];
				} 
				arr[i][j] = precClmn + precRow;
			}
		}
		System.out.println(arr[n-1][6]);
	}
}