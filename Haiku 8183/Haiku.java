import java.util.Scanner;

public class Haiku {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    while (sc.hasNext()) {
      String str = sc.nextLine();
      print(str);
    }
  }

  public static void print(String str) {
    String[] words = str.split(" ");
    int count = 0;
    int count1 = -1;
    int count2 = -1;
    for (int  i = 0; i < words.length; i++) {
      String word = words[i].replaceAll("\\W+", "");
      count += countSyllable(word);
      if (count == 5) 
        count1 = i;
      if (count == 12)
        count2 = i;
    }
    if (count1 != -1 && count2 != -1 && count == 17) {
      for (int i = 0; i < count1; i++) {
        System.out.print(words[i] + " ");
      }
      System.out.println(words[count1]);
      for (int i = count1 + 1; i < count2; i++) {
        System.out.print(words[i] + " ");
      }
      System.out.println(words[count2]);
      for (int i = count2 + 1; i < words.length - 1; i++) {
        System.out.print(words[i] + " ");
      }
      System.out.println(words[words.length - 1]);
    } else {
      System.out.println(str);
    }
  }

  public static int countSyllable(String word) {
    int count = 0;
    for (int i = 0; i < word.length(); i++) {
      char c = word.charAt(i);
      switch(c) {
        case 'Q': case 'q':
          if (!isLastC(i, word.length())) {
            if (word.charAt(i + 1) == 'u' || word.charAt(i + 1) == 'U')
              i++;
          }
          break;
        case 'Y': case 'y':
          if (!isLastC(i, word.length())) {
            if (!isVowel(word.charAt(i + 1))) {
              count++;
            }
          }
          break;
        case 'E': case 'e':
          if (isLastC(i, word.length())) {
            //if e is the last character of the word
            if (i - 1 >= 0) {
              if (word.charAt(i - 1) == 'L' || word.charAt(i - 1) == 'l') {
                if (i - 2 >= 0) {
                  if (isVowel(word.charAt(i - 2))) {
                    count++;
                  }
                }
              }
            }
          } else if (isLastC(i + 1, word.length())) {
            //if e is the second to last
            if (word.charAt(i + 1) == 'S' || word.charAt(i + 1) == 's') {
              //if es is the end
              if (i - 2 >= 0) {
                if ((!isVowel(word.charAt(i - 1))) && 
                    (!isVowel(word.charAt(i - 2)))) {
                  count++;
                  i++;
                }
              }  
            } else {
              //if not es
              if ((i != 0 && !isVowel(word.charAt(i - 1))) || i == 0) {
                count++;
              }
            }
          } else {
            //if e is neither last nor second to last
            if ((i != 0 && !isVowel(word.charAt(i - 1))) || i == 0) {
              count++;
            }
          }
          break;
        default:
          if (isVowel(c)) {
            if ((i != 0 && !isVowel(word.charAt(i - 1))) || i == 0) {
              count++;
            }
          }
      }
    }
    if (count == 0)
      count = 1;
    return count;
  }

  public static boolean isVowel(char c) {
    if (c == 'Y' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U' ||
      c == 'y' || c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
      return true;
    }
    return false;
  }

  public static boolean isLastC(int i, int length) {
    if (i == length - 1)
      return true;
    return false;
  }

}
