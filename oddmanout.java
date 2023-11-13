import java.util.HashMap;
import java.util.Map;
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
public class oddmanout {
  public static void main(String[] args) {
    FastIO sc = new FastIO();
    int n = sc.nextInt();
    for (int i = 1; i <= n; i++) {
      int g = sc.nextInt();
      HashMap<Long, Integer> mp = new HashMap<>();
      while (g-- > 0) {
        long gg = sc.nextLong();
        if (!mp.containsKey(gg)) {mp.put(gg, 0);}
        mp.put(gg, mp.get(gg) + 1);
      }
      loop1: for (Map.Entry mmp : mp.entrySet()) {
        if ((int) mmp.getValue() < 2) {
          sc.println("Case #" + i + ": " + mmp.getKey());
          break loop1;
        }
      }
    }
    sc.close();
  }
}
