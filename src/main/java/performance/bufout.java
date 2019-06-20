package performance;

import java.io.*;
import java.time.LocalDateTime;

public class bufout {
  public static void main(String args[]) {
    FileOutputStream fdout = new FileOutputStream(FileDescriptor.out);
    BufferedOutputStream bos = new BufferedOutputStream(fdout, 10000);
    PrintStream ps = new PrintStream(bos, false);
    System.setOut(ps);
    final int N = 100_000_0;
    LocalDateTime start = LocalDateTime.now();
    for (int i = 1; i <= N; i++) System.out.println(i);
    System.out.println(start+"-"+LocalDateTime.now());

    ps.close();
  }
}
