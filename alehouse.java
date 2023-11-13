import java.util.ArrayList;
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
public class alehouse {
  public static void main(String[] args) {
    FastIO sc = new FastIO();
    int n = sc.nextInt(); long k = sc.nextLong();
    TreeMap<Long, Long> starts = new TreeMap();
    TreeMap<Long, Long> ends = new TreeMap<>();
    while (n-- > 0) {
      long a = sc.nextLong(); long b = sc.nextLong();
      starts.put(a, starts.getOrDefault(a, (long) 0) + 1);
      ends.put(b, starts.getOrDefault(b, (long) 0) + 1);
    }
    for (long ss : starts.keySet()) {
      long neededend = ss + k;
      starts.tailMap(ss);
    }
  }
}


