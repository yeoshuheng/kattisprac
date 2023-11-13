import java.util.HashSet;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.TreeMap;

class FastIO extends PrintWriter {
  BufferedReader br;
  StringTokenizer st;
  public FastIO() {
    super(new BufferedOutputStream(System.out));
    br = new BufferedReader(new InputStreamReader(System.in));
  }
  String next() {
    while (st == null || ! st.hasMoreElements()) {
      try { st = new StringTokenizer(br.readLine()); }
      catch (IOException  e) { e.printStackTrace(); }
    }
    return st.nextToken();
  }
  int nextInt() { return Integer.parseInt(next()); }
  long nextLong() { return Long.parseLong(next()); }
  double nextDouble() { return Double.parseDouble(next()); }
  String nextLine() {
    String str = "";
    try { str = br.readLine(); }
    catch (IOException e) { e.printStackTrace(); }
    return str;
  }
}
public class shiritori {
  public static void main(String[] args) {
    FastIO sc = new FastIO();
    int n = sc.nextInt();
    boolean p1 = true;
    HashSet<String> seen = new HashSet<>();
    Character p = null;
    while (n-- > 0) {
      String curr = sc.nextLine();
      if (p == null) {
       p = curr.charAt(curr.length() - 1);
       seen.add(curr);
       p1 = false;
       continue;
      }
      if (!p.equals(curr.charAt(0)) || seen.contains(curr)) {
       if (p1) {
         sc.println("Player 1 lost");
       } else {
         sc.println("Player 2 lost");
       }
       sc.close();
       return;
      }
      seen.add(curr);
      p = curr.charAt(curr.length() - 1);
      p1 = !p1;
    }
    sc.println("Fair Game");
    sc.close();
  }
}
