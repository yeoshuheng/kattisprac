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
public class travellingcaterpillar {
  public static HashMap<Integer, ArrayList<Integer[]>> adj;

  public static int tdist = 0;

  public static HashSet<Integer> targets = new HashSet<>();

  public static void main(String[] args) {
    FastIO sc = new FastIO();
    int n = sc.nextInt(); int k = sc.nextInt(); adj = new HashMap<>();
    for (int i = 0; i < n; i++) {adj.put(i, new ArrayList<>());}
    for (int i = 0; i < n - 1; i++) {
      int a = sc.nextInt(); int b = sc.nextInt(); int d = sc.nextInt();
      adj.get(a).add(new Integer[]{b, d});
    }
    while (k-- > 0) {
      targets.add(sc.nextInt());
    }
    dfs(0);
    sc.println(tdist);
    sc.close();
  }
  public static boolean dfs(int curr) {
    if (targets.contains(curr)) {
      targets.remove(curr);
      return true;
    }
    boolean found = false;
    for (Integer[] n : adj.get(curr)) {
      boolean ret = dfs(n[0]);
      if (ret) {found = true; tdist += (n[1]) * 2;}
    }
    return found;
  }
}
