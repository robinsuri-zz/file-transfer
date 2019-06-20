package performance;

import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;

public class format1 {
  public static void main(String args[]) {
    final int COUNT = 25000;
    LocalDateTime start = LocalDateTime.now();
    for (int i = 1; i <= COUNT; i++) {
      String s = "The square of 5 is 25\n";
      System.out.print(s);
    }
    System.out.println(start+" --- "+LocalDateTime.now());
//this takes around 100 ms
  }
}
