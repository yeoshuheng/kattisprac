import java.util.*;
import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class hermits {
  public static void main(String[] args) {
    FastIO sc = new FastIO();
    int n = sc.nextInt();
    int[] ppl = new int[n + 1];
    for (int i = 1; i <= n; i++) {
      ppl[i] = sc.nextInt();
    }
    int m = sc.nextInt();
    HashMap<Integer, HashSet<Integer>> mp = new HashMap<>();
    for (int i = 1; i <= n; i++) {
      mp.put(i, new HashSet<>());
    }
    int[] res = new int[n + 1];
    for (int i = 0; i < m; i++) {
      int a = sc.nextInt(); int b = sc.nextInt();
      res[a] += ppl[b];
      res[b] += ppl[a];
    }
    int min = Integer.MAX_VALUE;
    int minI = 0;
    for (int i = 1; i <= n; i++) {
      res[i] += ppl[i];
      if (res[i] < min) {
        minI = i;
        min = res[i];
      }
    }
    sc.println(minI);
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