import java.util.Scanner;

public class MapTiles {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    while (sc.hasNext()) {
      String s = sc.next();
      result(s);
    }
  }

  public static void result(String s) {
    //level
    int n = s.length();
    
    int x = 0;
    int y = 0;
    for (int i = 0; i < n; i++) {
      x *= 2;
      y *= 2;

      if (s.charAt(i) == '1')
        x++;
      else if (s.charAt(i) == '2')
        y++;
      else if (s.charAt(i) == '3') {
        x++;
        y++;
      }
    }
    System.out.println(n + " " + x + " " + y);
  }
}
