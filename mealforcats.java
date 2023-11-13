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
    parents = new int[n];
    size = new int[n];
    rank = new int[n];
    for (int i = 0; i < n; i++) {
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

public class mealforcats {
  public static void main(String[] args) {
    FastIO sc = new FastIO();
    int t = sc.nextInt();
    while (t-- > 0) {
      int m = sc.nextInt(); int c = sc.nextInt();
      PriorityQueue<Integer[]> edges = new PriorityQueue<>(new Comparator<Integer[]>() {
        @Override
        public int compare(Integer[] o1, Integer[] o2) {
          return o1[2] > o2[2] ? 1 : -1;
        }
      });
      int q = (c * (c - 1)) / 2;
      while (q-- > 0) {
        int i = sc.nextInt(); int j = sc.nextInt(); int d = sc.nextInt();
        edges.add(new Integer[]{i, j, d});
      }
      uf unionfind = new uf(c);
      int used = c;
      while (!edges.isEmpty()) {
        Integer[] ed = edges.poll();
        int a = ed[0]; int b = ed[1]; int w = ed[2];
        if (unionfind.find(a) == unionfind.find(b)) {continue;}
        unionfind.union(a, b);
        used += w;
      }
      if (used <= m) {sc.println("yes");} else {sc.println("no");}
    }
    sc.close();
  }
}
