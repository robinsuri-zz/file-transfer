package performance;

import java.io.*;

public class length1 {
  public static void main(String args[]) {
    File f = new File("/Users/robin.su/Documents/Checkout/file-transfer-java/src/main/resources/41-MB-Image.jpg");
    long len = f.length();
    System.out.println(len);
  }
}
