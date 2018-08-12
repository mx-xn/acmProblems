import java.util.*;

public class CuttheCake {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			int r = in.nextInt();
			if (r == 0) 
				break;
			int[] center = new int[2];
			center[0] = in.nextInt(); //x
			center[1] = in.nextInt(); //y
			int numLines = in.nextInt();

			//used to store the k and b of the lines
			ArrayList<Double[]> lines = new ArrayList<>();
			for (int i = 0; i < numLines; i++) {
				double x1 = 0;
				double x2 = 0;
				double y1 = 0;
				double y2 = 0;

				//read in the k and b of the lines
				x1 = (double)in.nextInt();
				y1 = (double)in.nextInt();
				x2 = (double)in.nextInt();
				y2 = (double)in.nextInt();

				Double[] formula = new Double[2];
				//calculate the k and b
				if (x2 - x1 == 0) {
					formula[0] = null; //if the slope is infinite
					formula[1] = x1;
				}
				else {
					formula[0] = (y2-y1)/(x2-x1); //k
					formula[1] = y1 - (formula[0] * x1); //b
				}
				//add the k&b of one line to the arrayList
				lines.add(formula);
			}
			getParts(r, center, numLines, lines);
		}
	}

	public static void getParts(int r, int[] center, int numLines, ArrayList<Double[]> lines) {
		int num = 0;
		int intersection = 0;
		ArrayList<Integer> index = new ArrayList<>();
		for (int i = 0; i < numLines; i++) {
			//calculate distance 
			Double[] formula = lines.get(i);
			Double k = formula[0];
			Double b = formula[1];
			double d;
			if (k == null)
				d = center[0] - b;
			else if (k == 0) 
				d = center[1] - b;
			else {
				double up = k*center[0] - center[1] + b;
				double down = Math.sqrt(k*k + 1);
				d = up/down;	//calculate distance
			} 
			if (d < 0) 
				d = - d;
			
			if (d < r) {
				num++;
				index.add(i);
			}
		}

		for (int k = 0; k < index.size() - 1; k++) {
			Double[] form1 = lines.get(index.get(k));
			for (int j = k; j < index.size() - 1; j++) {
				Double[] form2 = lines.get(index.get(j+1));
				Double x = null;
				Double y = null;;
				if (form1[0] == null) {
					if (form2[0] != null) {
						x = form1[1];				//x intersection
						y = form2[0]*x + form2[1];  //y intersection 
					}
				}
				else if (form2[0] == null) {
					x = form2[1];
					y = form1[0]*x + form1[1];
				}
				else if (form1[0] == 0) {
					if (form2[0] != 0) {
						y = form1[1];
						x = (y - form2[1])/form2[0];
					}
				}
				else if (form2[0] == 0) {
					y = form2[1];
					x = (y - form1[1])/form1[0];
				}
				else if (form1[0] != form2[0]) {
					x = (form2[1] - form1[1])/(form1[0] - form2[0]);
					y = form1[0]*x + form1[1];
				}

				if (x != null) {
				//if the two lines are not parallel
					double square = (center[0] - x)*(center[0] - x) + 
						(center[1] - y)*(center[1] - y);						
					double dist = Math.sqrt(square);
					if (dist < r) {
						intersection++;
					}
				}
			}
		}
		System.out.println(num + intersection + 1);
	}
}