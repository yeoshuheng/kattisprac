import java.util.*;
import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

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
public class magicsequencing {
  public static void main(String[] args) {
    FastIO sc = new FastIO();
    int tc = sc.nextInt();
    while (tc-- > 0) {
      int n = sc.nextInt();
      long a = sc.nextLong(); long b = sc.nextLong(); long c = sc.nextLong();
      long x = sc.nextInt(); long y = sc.nextInt();
      TreeMap<Long, Long> s = new TreeMap<>();
      long prev = a;
      s.put(a, (long) 1);
      for (int i = 1; i < n; i++) {
        long curr = (prev * b + a) % c;
        s.put(curr, s.getOrDefault(curr, (long)0) + 1);
        prev = curr;
      }
      long v = 0;
      while (!s.isEmpty()) {
        Map.Entry<Long, Long> cc = s.pollFirstEntry();
        long needed = cc.getValue();
        while (needed-- > 0) {
          v = (v * x + cc.getKey()) % y;
        }
      }
      sc.println(v);
    }
    sc.close();
  }
}
