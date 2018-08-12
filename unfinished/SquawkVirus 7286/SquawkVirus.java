import java.util.*;

public class SquawkVirus {
	public static void main(String args[]) {

	
		Scanner in = new Scanner(System.in);

		while (in.hasNext()) {
			int numVert = in.nextInt();
			int numEdge = in.nextInt();
			int infected = in.nextInt();
			int time = in.nextInt();

			int[][] matrix = new int[numVert][numVert];
			for (int i = 0; i < numEdge; i++) {
				int vert1 = in.nextInt();
				int vert2 = in.nextInt();

				matrix[vert1][vert2] = 1;
				matrix[vert2][vert1] = 1;
			}

			findNumSquawk(numVert, infected, time, matrix);
		}
	}

	public static void findNumSquawk(int numVert, int infected, 
		int time, int[][] matrix) {
		int[] virus = new int[numVert];
		virus[infected] = 1;

		Map<Integer, Integer> temp = new HashMap<>();

		int sum = 0;

		for (int t = 1; t <= time; t++) {

			//check if the vertex currently has virus
			for (int i = 0; i < virus.length; i++) {
				if (virus[i] != 0) {
					temp.put(i, virus[i]);
					virus[i] = 0;
				}
			}

			Set<Integer> keySet = temp.keySet();
			Iterator<Integer> it = keySet.iterator();


			while(it.hasNext()) {
				int index = it.next();
				int value = temp.get(index);

				for (int j = 0; j < numVert; j++) {
					if (matrix[index][j] == 1) {
						virus[j] += value;
					}
				}
			}
			temp.clear();

		} 
		for (int k = 0; k < virus.length; k++)
			sum += virus[k];

		System.out.println(sum);
	}
}