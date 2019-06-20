package performance;

import java.io.*;

public class token1 {
  public static void main(String args[]) {
    try {
      FileReader fr = new FileReader(intro1.sampleFile);
      BufferedReader br = new BufferedReader(fr);
      StreamTokenizer st = new StreamTokenizer(br);
      st.resetSyntax();
      st.wordChars('a', 'z');
      int tok;
      while ((tok = st.nextToken()) != StreamTokenizer.TT_EOF) {
        if (tok == StreamTokenizer.TT_WORD)
          System.out.println(st.sval);
      }
      br.close();
    } catch (IOException e) {
      System.err.println(e);
    }
  }
}
