import java.util.*;

public class FindingLines {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    while (in.hasNext()) {
      int n = in.nextInt();
      double p = (double)in.nextInt();
      int[][] points = new int[n][2];

      //fill in the points
      for (int i = 0; i < n; i++) {
        int[i][0] = in.nextInt();
        int[i][1] = in.nextInt();
      }

      findLines(points);
    }
  }
  
  public static void findLines(points) {
    HashMap<ArrayList<Double>, Integer> count = 
      new HashMap<ArrayList<Double>, Integer>; 
    //0: k; 1: b
    
    //save k and b
    for (int i = 0; i < points.length; i++) {
      for (int j = 1 + i; j < points.length; j++) {
        if (i != j) { 
          int x1 = points[i][0];
          int y1 = points[i][1];
          int x2 = points[i][0];
          int y2 = points[i][1];
          ArrayList<Double> coord = getCoord(x1, y1, x2, y2);
          Integer num = count.get(coord);
          if (num == null) {
            //if such k and b does not exist
            count.put(coord, 1);
          } else {
            //if already exist
            num++;
            count.put(coord, num);
          }

          //iterate through hashmap to see whether exceed p
        }
      }
    }
  }

  public static ArrayList<Double> getCoord(int x1, int y1, int x2, int y2) {
    ArrayList<Double> crd = new ArrayList<Double>();
    double k = 0;
    if (x1 != x2) {
      double xDf = x2 - x1;
      double yDf = y2 - y1;
      k = yDf / xDf;
    }

    //get b
    double b = y1 - k * x1;
    crd.add(k);
    crd.add(b);

    return crd;
  }

}
