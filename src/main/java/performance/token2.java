package performance;

import java.io.*;

public class token2 {
  public static void main(String args[]) {
    try {
      FileReader fr = new FileReader(intro1.sampleFile);
      BufferedReader br = new BufferedReader(fr);
      int maxlen = 256;
      int currlen = 0;
      char wordbuf[] = new char[maxlen];
      int c;
      do {
        c = br.read();
        if (c >= 'a' && c <= 'z') {
          if (currlen == maxlen) {
            maxlen *= 1.5;
            char xbuf[] = new char[maxlen];
            System.arraycopy(wordbuf, 0, xbuf, 0, currlen);
            wordbuf = xbuf;
          }
          wordbuf[currlen++] = (char) c;
        } else if (currlen > 0) {
          String s = new String(wordbuf, 0, currlen);           // do something with s
          currlen = 0;
        }
      } while (c != -1);
      br.close();
    } catch (IOException e) {
      System.err.println(e);
    }
  }
}
