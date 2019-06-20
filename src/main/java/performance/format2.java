package performance;

import java.time.LocalDateTime;
//this takes around 150 ms
public class format2 {
  public static void main(String args[]) {
    int n = 5;
    final int COUNT = 25000;
    LocalDateTime start = LocalDateTime.now();
    for (int i = 1; i <= COUNT; i++) {
      String s = "The square of " + n + " is " + n * n + "\n";
      System.out.print(s);
    }
    System.out.println(start+" --- "+LocalDateTime.now());
  }
}
