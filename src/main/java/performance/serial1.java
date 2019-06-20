package performance;

import java.io.*;
import java.util.*;

public class serial1 {
  public static void main(String args[]) {
    ArrayList al = new ArrayList();
    Random rn = new Random();
    final int N = 100000;
    for (int i = 1; i <= N; i++) al.add(new Integer(rn.nextInt()));
    try {
      FileOutputStream fos = new FileOutputStream("test.ser");
      BufferedOutputStream bos = new BufferedOutputStream(fos);
      ObjectOutputStream oos = new ObjectOutputStream(bos);
      oos.writeObject(al);
      oos.close();
    } catch (Throwable e) {
      System.err.println(e);
    }
  }
}
