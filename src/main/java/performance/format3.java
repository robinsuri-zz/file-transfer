package performance;

import java.text.*;
import java.time.LocalDateTime;
// approx 600 ms
public class format3 {
  public static void main(String args[]) {
    MessageFormat fmt = new MessageFormat("The square of {0} is {1}\n");
    Object values[] = new Object[2];
    int n = 5;
    values[0] = new Integer(n);
    values[1] = new Integer(n * n);
    final int COUNT = 25000;
    LocalDateTime start = LocalDateTime.now();
    for (int i = 1; i <= COUNT; i++) {
      String s = fmt.format(values);
      System.out.print(s);
    }
    System.out.println(start+" --- "+LocalDateTime.now());
  }
}

