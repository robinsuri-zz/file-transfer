package performance;

import java.io.*;

public class conv2 {
  public static void main(String args[]) {
    try {
      FileOutputStream fos = new FileOutputStream("out2");
      OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF8");
      PrintWriter pw = new PrintWriter(osw);
      pw.println("\uffff\u4321\u1234");
      pw.close();
    } catch (IOException e) {
      System.err.println(e);
    }
  }
}
