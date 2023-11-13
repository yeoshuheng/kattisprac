import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.TreeMap;

public final class treasuremaps {
  public static void main(String[] args) {
    FastIO sc = new FastIO();
    int t = sc.nextInt();
    while (t-- > 0) {
      int x = sc.nextInt(); int y = sc.nextInt(); int k = sc.nextInt();
      if (x >= y) {sc.println(x);} // chest > key -> go chest
      else { // chest < key
        if (Math.abs(x - y) > k) {
            sc.println(y + Math.abs(x + k - y));
        }  else {
          sc.println(y);
        }
      }
    }
    sc.close();
  }
}

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
