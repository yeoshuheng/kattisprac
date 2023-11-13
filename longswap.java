import java.lang.reflect.Array;
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
public class longswap {
  public static void main(String[] args) {
    FastIO sc = new FastIO();
    String str = sc.next(); int k = sc.nextInt();
    HashMap<Integer, Integer> mapToIdx = new HashMap<>();
    char[] ss = str.toCharArray();
    uf swaps = new uf(ss.length);
    for (int i = 0; i < ss.length; i++) {
      for (int j = i + 1; j < ss.length; j++) {
        if (Math.abs(i - j) >= k) {
          swaps.union(i, j);
        }
      }
    }
    HashMap<Character, HashSet<Integer>> cToIdx = new HashMap<>();
    for (int i = 0; i < ss.length; i++) {
      char c = ss[i];
      if (!cToIdx.containsKey(c)) {cToIdx.put(c, new HashSet<>());}
      cToIdx.get(c).add(i);
    }
    char[] sorted = ss.clone();
    Arrays.sort(sorted);
    for (int i = 0; i < sorted.length; i++) {
      HashSet<Integer> ogIdx = cToIdx.get(sorted[i]);
      boolean pos = false;
      for (int j : ogIdx) {
        if (swaps.find(j) == swaps.find(i)) {
          pos = true;
          ogIdx.remove(j);
          break;
        }
      }
      if (!pos) {
        sc.println("No");
        sc.close();
        return;
      }
    }
    sc.println("Yes");
    sc.close();
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