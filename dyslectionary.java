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
public class dyslectionary {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    PrintWriter pw = new PrintWriter(System.out);
    HashMap<String, String> revToWord = new HashMap<>();
    ArrayList<String> rev = new ArrayList<>();
    int maxLen = 0;
    boolean end = false;
    while (sc.hasNextLine()) {
      while (true) {
        String nxt = sc.nextLine();
        if (nxt.equals("")) {break;}
        StringBuilder cchr = new StringBuilder();
        char[] ca = nxt.toCharArray();
        maxLen = Math.max(ca.length, maxLen);
        for (int i = ca.length - 1; i > -1; i--) {
          cchr.append(ca[i]);
        }
        String cnxt = cchr.toString();
        revToWord.put(cnxt, nxt);
        rev.add(cnxt);

        if (!sc.hasNextLine()) {
          end = true;
          break;
        }
      }
      rev.sort(Comparator.naturalOrder());
      for (String r : rev) {
        StringBuilder sb = new StringBuilder();
        int needed = maxLen - r.length();
        while (needed-- > 0) {
          sb.append(" ");
        }
        sb.append(revToWord.get(r));
        pw.println(sb);
      }
      revToWord = new HashMap<>();
      rev = new ArrayList<>();
      maxLen = 0;
      if (end) {break;}
      pw.println();
    }
    pw.close();
  }
}
