import java.util.HashMap;
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

public class cd {
  public static void main(String[] args) {
    FastIO sc = new FastIO();
    while (true) {
      long m = sc.nextLong(); long n = sc.nextLong();
      if ((int) m == 0 && (int) n == 0) {break;}
      HashSet<Integer> cd = new HashSet<>();
      HashSet<Integer> db = new HashSet<>();
      while (m-- > 0) {
        cd.add(sc.nextInt());
      }
      while (n-- > 0) {
        int cc = sc.nextInt();
        if (cd.contains(cc)) {
          db.add(cc);
        }
        cd.add(cc);
      }
      sc.println(db.size());
    }
    sc.close();
  }
}
