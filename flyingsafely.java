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
public class flyingsafely {
  public static void main(String[] args) {
    FastIO sc = new FastIO();
    int tc = sc.nextInt();
    while (tc-- > 0) {
      int n = sc.nextInt();
      int m = sc.nextInt();
      HashMap<Integer, HashSet<Integer>> adj = new HashMap<>();
      for (int i = 1; i <= n; i++) {
        adj.put(i, new HashSet<>());
      }
      while (m-- > 0) {
        int a = sc.nextInt(); int b = sc.nextInt();
        adj.get(a).add(b); adj.get(b).add(a);
      }
      sc.println(n - 1);
    }
    sc.close();
  }
  public void dfs(int curr, HashMap<Integer, HashSet<Integer>> adj, boolean[] seen, int used) {
    seen[curr] = true;
    for (int n : adj.get(curr)) {
      if (seen[n]) {continue;}
       dfs(n, adj, seen, used);
    }
  }
}
