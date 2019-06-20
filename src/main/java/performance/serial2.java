package performance;

import java.io.*;
import java.util.*;

public class serial2 {
  public static void main(String args[]) {
    String al = null;
    try {
      FileInputStream fis = new FileInputStream("test.ser");
      BufferedInputStream bis = new BufferedInputStream(fis);
      ObjectInputStream ois = new ObjectInputStream(bis);
      al = (String) ois.readObject();
      ois.close();
    } catch (Throwable e) {
      System.err.println(e);
    }
  }
}
