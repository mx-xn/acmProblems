import java.util.*;


public class Island {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		if (in.hasNext()) {
			//read in the num of lines
			int lines = in.nextInt();

			//process each line
			for (int i = 0; i < lines; i++) {
				int[] nums = new int[16];

				//read each char in each line into the array
				for (int j = 0; j < 16; j++) {
					nums[j] = in.nextInt();
				}

				countIslands(nums);
			}
		}
	}

	public static void countIslands(int[] nums) {
		int count = 0;
		for(int i = 1; i < nums.length - 1; i++) {
			if (nums[i] < nums[i+1]) 
				count++;
		}
		System.out.println(nums[0] + " " + count);
	}
}