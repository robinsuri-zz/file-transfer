package performance;

import java.io.*;
import java.util.ArrayList;

public class LineCache {
  private ArrayList list = new ArrayList();

  public LineCache(String fn) throws IOException {
    FileReader fr = new FileReader(fn);
    BufferedReader br = new BufferedReader(fr);
    String ln;
    while ((ln = br.readLine()) != null) list.add(ln);
    br.close();
  }

  public String getLine(int n) {
    if (n < 0) throw new IllegalArgumentException();
    return (n < list.size() ? (String) list.get(n) : null);
  }

  public static void main(String args[]) {
    try {
      LineCache lc = new LineCache(intro1.largeFile);
      int i = 0;
      String ln;
      while ((ln = lc.getLine(i++)) != null) System.out.println(ln);
    } catch (IOException e) {
      System.err.println(e);
    }
  }
}
