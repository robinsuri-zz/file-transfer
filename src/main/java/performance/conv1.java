package performance;

import java.io.*;

public class conv1 {
  public static void main(String args[]) {
    try {
      FileOutputStream fos = new FileOutputStream("out1");
      PrintStream ps = new PrintStream(fos);
      ps.println("\uffff\u4321\u1234");
      ps.close();
    } catch (IOException e) {
      System.err.println(e);
    }
  }
}
