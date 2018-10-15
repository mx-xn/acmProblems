import java.util.*;

public class DiceCup {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    while (in.hasNext()) {
      int n1 = in.nextInt();
      int n2 = in.nextInt();
      getSum(n1, n2);
      if (in.hasNext()) 
        System.out.println();
    }
  }

  public static void getSum(int n1, int n2) {
    int max;
    int min;
    
    if (n1 > n2) {
      max = n1;
      min = n2;
    } else {
      max = n2;
      min = n1;
    }

    int diff = max - min;

    for (int i = 0; i < diff + 1; i++) {
      System.out.println(min + 1);
      min++;
    }
  }

}
