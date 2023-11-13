import javax.swing.plaf.synth.SynthUI;
import java.util.*;
import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.OutputStream;

class Kattio extends PrintWriter {
  public Kattio(InputStream i) {
    super(new BufferedOutputStream(System.out));
    r = new BufferedReader(new InputStreamReader(i));
  }
  public Kattio(InputStream i, OutputStream o) {
    super(new BufferedOutputStream(o));
    r = new BufferedReader(new InputStreamReader(i));
  }

  public boolean hasMoreTokens() {
    return peekToken() != null;
  }

  public int getInt() {
    return Integer.parseInt(nextToken());
  }

  public double getDouble() {
    return Double.parseDouble(nextToken());
  }

  public long getLong() {
    return Long.parseLong(nextToken());
  }

  public String getWord() {
    return nextToken();
  }



  private BufferedReader r;
  private String line;
  private StringTokenizer st;
  private String token;

  private String peekToken() {
    if (token == null)
      try {
        while (st == null || !st.hasMoreTokens()) {
          line = r.readLine();
          if (line == null) return null;
          st = new StringTokenizer(line);
        }
        token = st.nextToken();
      } catch (IOException e) { }
    return token;
  }

  private String nextToken() {
    String ans = peekToken();
    token = null;
    return ans;
  }
}

public class compoundwords {
  public static void main(String[] args) throws IOException {
    Kattio sc = new Kattio(System.in);
    HashSet<String> words = new HashSet<>();
    String line = null;
    while (sc.hasMoreTokens()) {
      words.add(sc.getWord());
    }
    TreeSet<String> formedWords = new TreeSet<>();
    String[] arr = new String[words.size()];
    arr = words.toArray(arr);
    for (int i = 0; i < arr.length; i++) {
      for (int j = i + 1; j < arr.length; j++ ) {
        String a = arr[i]; String b = arr[j];
        formedWords.add(a + b);
        formedWords.add(b + a);
      }
    }
    for (String w : formedWords) {
      sc.println(w);
    }
    sc.close();
  }
}
