package performance;

import java.io.*;
import java.time.LocalDateTime;

public class intro1 {
  public static String largeFile = "/Users/robin.su/Documents/Checkout/file-transfer-java/src/main/resources/large-file.txt";
  public static String sampleFile="/Users/robin.su/Documents/Checkout/file-transfer-java/src/main/resources/sample.txt";
  public static void main(String args[]) {
    try {
      System.out.println(LocalDateTime.now());
      FileReader fis = new FileReader(largeFile);
      int cnt = 0;
      int b;
      while ((b = fis.read()) != -1) {
        if (b == '\n') cnt++;
      }
      fis.close();
      System.out.println(LocalDateTime.now());
      System.out.println(cnt);
    } catch (IOException e) {
      System.err.println(e);
    }
  }
}
