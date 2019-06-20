package performance;

import java.io.*;
import java.time.LocalDateTime;

public class intro3 {
  public static void main(String args[]) {
    try {
      System.out.println(LocalDateTime.now());
      FileInputStream fis = new FileInputStream(intro1.largeFile);
      byte buf[] = new byte[20000];
      int cnt = 0;
      int n;
      while ((n = fis.read(buf)) != -1) {
        for (int i = 0; i < n; i++) {
          if (buf[i] == '\n') cnt++;
        }
      }
      fis.close();
      System.out.println(LocalDateTime.now());
      System.out.println(cnt);
    } catch (IOException e) {
      System.err.println(e);
    }
  }
}
