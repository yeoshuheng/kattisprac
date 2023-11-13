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

public class treehouse {
  public static void main(String[] args) {
    FastIO sc = new FastIO();
    int n = sc.nextInt(); int e = sc.nextInt(); int p = sc.nextInt();
    double[][] coords = new double[n + 1][2];
    uf unionfind = new uf(n);
    // 0 => open
    for (int i = 1; i <= e; i++) {
      double a = sc.nextDouble(); double b = sc.nextDouble();
      coords[i] = new double[]{a, b};
      unionfind.union(0, i);
    }
    for (int i = e + 1; i < n + 1; i++) {
      double a = sc.nextDouble(); double b = sc.nextDouble();
      coords[i] = new double[]{a, b};
    }
    while (p-- > 0) {
      int a = sc.nextInt(); int b = sc.nextInt();
      unionfind.union(a, b);
    }
    double cost = 0;
    PriorityQueue<Double[]> pq = new PriorityQueue<>(new Comparator<Double[]>() {
      @Override
      public int compare(Double[] o1, Double[] o2) {
        return o1[2] > o2[2] ? 1 : -1;
      }
    });
    for (double i = 1; i < n + 1; i++) {
      for (double j = 1; j < n + 1; j++) {
        if (i == j) {continue;}
        if (unionfind.find((int) i) == unionfind.find((int) j)) {continue;}
        double[] aa = coords[(int) i];
        double[] bb = coords[(int) j];
        double gap = Math.sqrt(Math.pow(aa[0] - bb[0], 2) + Math.pow(aa[1] - bb[1], 2));
        pq.offer(new Double[]{i, j, gap});
      }
    }
    while (!pq.isEmpty()) {
      Double[] curr = pq.poll();
      int a = curr[0].intValue();
      int b = curr[1].intValue();
      if (unionfind.find(a) == unionfind.find(b)) {continue;}
      unionfind.union(a, b);
      cost += curr[2];
    }
    sc.println(cost);
    sc.close();
  }
}
class uf {

  public int[]  parents;
  public int[] size;
  public int[] rank;
  int ngrps;

  uf (int n) {
    parents = new int[n + 1];
    size = new int[n + 1];
    rank = new int[n + 1];
    for (int i = 1; i <= n; i++) {
      parents[i] = i;
      size[i] = 1;
      rank[i] = 0;
    }
    ngrps = n;
  }
  public int find(int x) {
    if (parents[x] == x) {return x;}
    int p = find(parents[x]);
    parents[x] = p;
    return p;
  }

  public int getSize(int x) {
    return size[find(x)];
  }

  public void union(int a, int b) {
    int p_a = find(a); int p_b = find(b);
    if (p_a == p_b) {return;}
    if (rank[p_a] > rank[p_b]) {
      parents[p_b] = p_a;
      size[p_a] += size[p_b];
    } else if (rank[p_b] > rank[p_a]) {
      parents[p_a] = p_b;
      size[p_b] += size[p_a];
    } else {
      parents[p_b] = p_a;
      size[p_a] += size[p_b];
      rank[p_a]++;
    }
    ngrps--;
  }
}
