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

public class acm {
  public static void main(String[] args) {
    FastIO sc = new FastIO();
    int n = sc.nextInt();
    unionFind used = new unionFind();
    long ret = 0;
    while (n-- > 0) {
      int cn = sc.nextInt();
      ArrayList<Integer> cUsed = new ArrayList<>();
      HashMap<Integer, Long> needed = new HashMap<>();
      while (cn-- > 0) {
        int cc = sc.nextInt();
        cUsed.add(cc);
        int p = used.find(cc);
        needed.put(p, needed.getOrDefault(p, (long) 0) + 1);
      }
      boolean ok = true;
      for (Map.Entry<Integer, Long> p : needed.entrySet()) {
        if (used.size[p.getKey()] != p.getValue()) {
          ok = false;
          break;
        }
      }
      if (ok) {
        ret++;
        int base = cUsed.get(0);
        for (int i = 1; i < cUsed.size(); i++) {
          used.union(base, cUsed.get(i));
        }
      }
      //System.out.println("New Ret: " + ret);
    }
    sc.println(ret);
    sc.close();
  }
}

class unionFind {
  int[] parents = new int[500001];
  long[] size = new long[500001];

  public unionFind() {
    for (int i = 0; i < 500001; i++) {
      parents[i] = i;
      size[i] = 1;
    }
  }

  public int find(int x) {
    if (x == parents[x]) {return x;}
    int p = find(parents[x]);
    parents[x] = p;
    return p;
  }

  public void union(int a, int b) {
    int pa = find(a); int pb = find(b);
    if (pa == pb) {return;}
    // Add pa to pb.
    size[pb] += size[pa];
    size[pa] = 0;
    parents[pa] = pb;
  }
}