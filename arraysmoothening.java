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
public class arraysmoothening {
  public static void main(String[] args) {
    FastIO sc = new FastIO();
    int n = sc.nextInt(); int k = sc.nextInt();
    HashMap<Integer, Long> mp = new HashMap<>();
    while (n-- > 0) {
      int i = sc.nextInt();
      mp.put(i, mp.getOrDefault(i, (long) 0) + 1);
    }
    TreeMap<Long, Integer> pq = new TreeMap<>();
    for (Map.Entry<Integer, Long> e : mp.entrySet()) {
      pq.put(e.getValue(), pq.getOrDefault(e.getValue(), 0) + 1);
    }
    int left = k;
    while (left > 0) {
      Map.Entry<Long, Integer> q = pq.pollLastEntry();
     // System.out.println("current freq: " + q.getKey() + " with this freq: " + q.getValue());
      int possRemoval = Math.min(left, q.getValue());
      int remainder = q.getValue() - possRemoval;
      if (remainder > 0) {
        sc.println(q.getKey());
        sc.close();
        return;
      }
      left -= possRemoval;
      pq.put(q.getKey() - 1, pq.getOrDefault(q.getKey() - 1, 0) + q.getValue());
    }
    sc.println(pq.lastKey());
    sc.close();
  }
}
