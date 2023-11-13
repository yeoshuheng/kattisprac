import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
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
public class bdayparty {
  public static int[] disc;

  public static int[] lw;

  public static int[] parents;

  public static int bridges;

  public static HashMap<Integer, ArrayList<Integer>> adj;

  public static int timer;

  public static void main(String[] args) {
    FastIO sc = new FastIO();
    while (true) {
      int p = sc.nextInt(); int c = sc.nextInt();
      if (p == 0 && c == 0) {break;}
      disc = new int[p]; lw = new int[p]; parents = new int[p]; bridges = 0;
      adj = new HashMap<>();
      Arrays.fill(disc, -1); Arrays.fill(lw, -1); Arrays.fill(parents, -1);
      for (int i = 0; i < p; i++) {adj.put(i, new ArrayList<>());}
      while(c-- > 0) {int a = sc.nextInt(); int b = sc.nextInt();
        adj.get(a).add(b); adj.get(b).add(a);
      }
      timer = 0; for (int i = 0; i < p; i++) {dfs(i);}
      if (bridges > 0) {sc.println("Yes");} else {sc.println("No");}
    }
    sc.close();
  }

  public static void dfs(int curr) {
    disc[curr] = lw[curr] = timer;
    timer++;
    for (int neigh : adj.get(curr)) {
      if (disc[neigh] == -1) {
        parents[neigh] = curr; dfs(neigh);
        lw[curr] = Math.min(lw[curr], lw[neigh]);
        if (lw[neigh] > disc[curr]) {bridges++;}
      } else if (neigh != parents[curr]) {
        lw[curr] = Math.min(lw[neigh], lw[curr]);
      }
    }
  }
}
