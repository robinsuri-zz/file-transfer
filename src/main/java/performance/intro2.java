package performance;

import java.io.*;
import java.time.LocalDateTime;

public class intro2 {
  public static void main(String args[]) {
    try {
      System.out.println(LocalDateTime.now());
      FileReader fis = new FileReader(intro1.largeFile);
      BufferedReader bis = new BufferedReader(fis);
      int cnt = 0;
      int b;
      while ((b = bis.read()) != -1) {
        if (b == '\n') cnt++;
      }
      bis.close();
      System.out.println(LocalDateTime.now());
      System.out.println(cnt);
    } catch (IOException e) {
      System.err.println(e);
    }
  }
}