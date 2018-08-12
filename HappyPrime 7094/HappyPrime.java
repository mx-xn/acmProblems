import java.util.Scanner;
import java.util.HashMap;

public class HappyPrime {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int num = sc.nextInt();
    for (int i = 0; i < num; i++) {
      int order = sc.nextInt();
      int n = sc.nextInt();

      if (isPrime(n)) {
        if (isHappy(n)) {
          System.out.println(order + " " + n +
              " " + "YES");
        } else {
          System.out.println(order + " " + n +
              " " + "NO");
        }
      } else {
        System.out.println(order + " " + n +
            " " + "NO");
      }
    }
  }

  public static boolean isPrime(int n) {
    if (n < 2)
      return false;
    for (int i = 2; i < (n / 2); i++) {
      if (n%i == 0) {
        return false;
      }
    }
    //if there is no proper denominator
    return true;
  }

  public static boolean isHappy(int n) {
    HashMap<Integer, Integer> record = new HashMap<Integer, Integer>();
    int sum = 0;
    while (sum != 1) {
      sum = 0;
      while (n != 0) {
        int r = n%10;
        sum += (r * r);
        n /= 10;
      }
      //when the squares of all digits are added to sum
      if (record.containsKey(sum)) {
        //if sum was already computed once, not happy
        return false;
      }
      //if sum was not computed before, add it to map
      record.put(sum, sum);
      n = sum;
    }

    //when sum gets one, happy
    return true;
  }
}
