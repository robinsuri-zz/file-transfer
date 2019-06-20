package performance;

import java.time.LocalDateTime;

public class print {
  public static void main(String[] args) {
    final int N = 100_000_0;
    LocalDateTime start = LocalDateTime.now();
    for (int i = 1; i <= N; i++) System.out.println(i);
    System.out.println(start+"-"+LocalDateTime.now());
  }
}
