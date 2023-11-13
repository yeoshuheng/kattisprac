import java.util.ArrayList;
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
public class whereinternet {
  public static void main(String[] args) {
    FastIO sc = new FastIO();
    int n = sc.nextInt(); int m = sc.nextInt();
    uf unionfind = new uf(n);
    unionfind.union(0, 1);
    //System.out.println(unionfind.find(1));
    while (m-- > 0) {
      int a = sc.nextInt(); int b = sc.nextInt();
      unionfind.union(a, b);
    }
    boolean found = false;
    for (int i = 1; i <= n; i++) {
      //System.out.println(i + "'s parent: " + unionfind.find(i));
      if (unionfind.find(i) != unionfind.find(0)) {found = true; sc.println(i);}
    }
    if (!found){sc.println("connected");}
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
    for (int i = 0; i <= n; i++) {
      parents[i] = i;
      size[i] = 1;
      rank[i] = 0;
    }
    ngrps = n + 1;
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
    parents[p_b] = p_a;
    size[p_a] += size[p_b];
    rank[p_a]++;
    ngrps--;
  }
}