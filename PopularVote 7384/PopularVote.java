import java.util.Scanner;

public class PopularVote {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    int n = in.nextInt();
    for (int i = 0; i < n; i++) {
      int numP = in.nextInt();
      int sum = 0;
      int max = 0;
      int maxInd = 0;
      
      boolean sameFlag = false;
      for (int j = 1; j <= numP; j++) {
        int vote = in.nextInt();
        if (vote > max) {
          sameFlag = false;
          max = vote;
          maxInd = j;
        } else if (vote == max) {
          sameFlag = true;
        }
        sum += vote;
      }

      if (sameFlag) {
        System.out.println("no winner");
      } else {
        //we have a winner
        if (max > (sum / 2)) {
          System.out.println("majority winner " + maxInd);
        } else {
          System.out.println("minority winner " + maxInd);
        }
      }

    }
  }
}
