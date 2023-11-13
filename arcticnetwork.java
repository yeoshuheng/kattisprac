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
public class arcticnetwork {
  public static void main(String[] args) {
    FastIO sc = new FastIO(); int t = sc.nextInt();
    while (t-- > 0) {
      ArrayList<Integer[]> pt = new ArrayList<>();
      int s = sc.nextInt(); int p = sc.nextInt();
      for (int i = 0; i < p; i++) {int x = sc.nextInt(); int y = sc.nextInt(); pt.add(new Integer[]{i, x, y});}
      PriorityQueue<Double[]> edges = new PriorityQueue<>(new Comparator<Double[]>() {
        @Override
        public int compare(Double[] o1, Double[] o2) {
          return o1[2] > o2[2] ? 1 : -1;
        }
      });
      for (int i = 0; i < p; i++) {
        for (int j = i + 1; j < p; j++) {
          Integer[] p1 = pt.get(i); Integer[] p2 = pt.get(j);
          edges.offer(new Double[]{(double) p1[0], (double) p2[0], dist(p1[1], p1[2], p2[1], p2[2])});
        }
      }
      Stack<Double> dist = new Stack<>();
      uf uff = new uf(p);
      while (!edges.isEmpty()) {
        Double[] pp = edges.poll();
        if (uff.find(pp[0].intValue()) == uff.find(pp[1].intValue())) {continue;}
        uff.union(pp[0].intValue(), pp[1].intValue());
        dist.push(pp[2]);
      }
      double ret = 0;
      while (s-- > 0) {
        ret = dist.pop();
      }
      sc.println(String.format("%.2f", ret));
    }
    sc.close();
  }
  public static double dist(int x, int y, int a, int b) {
    return Math.sqrt(Math.pow(x - a, 2) + Math.pow(y - b, 2));
  }
}
