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
public class supplyroutes {

  public static HashMap<Long, HashSet<Long>> adj = new HashMap<>();
  public static HashSet<Long> seen = new HashSet<>();

  public static void main(String[] args) {
    FastIO sc = new FastIO();
    long n = sc.nextLong(); long m = sc.nextLong(); long q = sc.nextLong();
    for (long i = 0; i < n; i++) {adj.put(i, new HashSet<>());}
    while (m-- > 0) {
      long u = sc.nextLong(); long v = sc.nextLong();
      adj.get(u).add(v); adj.get(v).add(u);
    }
    while (q-- > 0) {
      int t = sc.nextInt(); long u = sc.nextLong(); long v = sc.nextLong();
      switch (t) {
        case 1:
          seen = new HashSet<>();
          boolean res = dfs(u, v);
          if (res) {sc.println("safe");} else {sc.println("unsafe");}
          break;
        case 0:
          adj.get(u).remove(v); adj.get(v).remove(u);
          break;
      }
    }
    sc.close();
  }
  public static boolean dfs(long curr, long target) {
    if (curr == target) {return true;}
    seen.add(curr);
    boolean found = false;
    for (long n : adj.get(curr)) {
      if (seen.contains(n)) {continue;}
      found = found || dfs(n, target);
    }
    return found;
  }
}
