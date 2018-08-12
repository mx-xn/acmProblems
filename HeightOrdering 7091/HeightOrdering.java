import java.util.*;

public class HeightOrdering {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		while(in.hasNext()) {
			int lines = in.nextInt();
			for(int i = 0; i < lines; i++) {
				int[] heights = new int[21];
				//read in the heights
				for (int j = 0; j < 21; j++) {
					heights[j] = in.nextInt();
				}

				steps(heights);
			}
		}
	}

	public static void steps(int[] heights) {
		int count = 0;
		for(int i = 2; i < heights.length; i++) {
			int j = i;
			while(heights[j] < heights[j-1] && (j != 1)) {
			//if heights[i+1] is smaller than the index before it 
			//or it hits the front
				int temp = heights[j];
				heights[j] = heights[j-1];
				heights[j-1] = temp;
				j--;
				count++;
			}
		}
		System.out.println(heights[0] + " " + count);
	}
}