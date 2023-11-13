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
public class cheatingstudents {
  public static void main(String[] args) {
    FastIO sc = new FastIO();
    int n = sc.nextInt();
    ArrayList<Integer[]> arr = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      int a = sc.nextInt(); int b = sc.nextInt();
      arr.add(new Integer[]{i, a, b});
    }
    PriorityQueue<Integer[]> edges = new PriorityQueue<>(new Comparator<Integer[]>() {
      @Override
      public int compare(Integer[] o1, Integer[] o2) {
        return o1[2] > o2[2] ? 1 : -1;
      }
    });
    for (int i = 0; i < arr.size(); i++) {
      for (int j = i + 1; j < arr.size(); j++) {
        Integer[] a = arr.get(i); Integer[] b = arr.get(j);
        edges.offer(new Integer[]{a[0], b[0], getDist(a[1], a[2], b[1], b[2])});
      }
    }
    uf unionfind = new uf(n); int used = 0;
    while (!edges.isEmpty()) {
      Integer[] curr = edges.poll();
      if (unionfind.find(curr[0]) == unionfind.find(curr[1])) {continue;}
      unionfind.union(curr[0], curr[1]);
      used += curr[2];
    }
    sc.println(used * 2); sc.close();
  }
  public static int getDist(int x, int y, int i, int j) {
    return Math.abs(x - i) + Math.abs(y - j);
  }
}
