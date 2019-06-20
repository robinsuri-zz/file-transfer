package performance;

import java.io.*;
import java.time.LocalDateTime;

public class line1 {
  public static void main(String args[]) {

    try {
      System.out.println(LocalDateTime.now());
      FileReader fr = new FileReader(intro1.largeFile);
      BufferedReader br = new BufferedReader(fr);
      int cnt = 0;
      while (br.readLine() != null) cnt++;
      br.close();
      System.out.println(LocalDateTime.now());
      System.out.println(cnt);
    } catch (IOException e) {
      System.err.println(e);
    }
  }
}
