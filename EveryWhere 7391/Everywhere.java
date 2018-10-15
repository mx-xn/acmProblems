import java.util.HashSet;
import java.util.Scanner;

public class Everywhere {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    for (int i = 0; i < n; i++) {
      int numC = in.nextInt();
      HashSet<String> hs = new HashSet<String>();
      for (int j = 0; j < numC; j++) {
        String city = in.next();
        if (!hs.contains(city))
          hs.add(city);
      }
      System.out.println(hs.size());
    }
  }
}
