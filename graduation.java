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
public class graduation {
  public static void main(String[] args) {
    FastIO sc = new FastIO();
    int n = sc.nextInt(); int m = sc.nextInt(); int k = sc.nextInt();
    uf unionfind = new uf(k);
    HashMap<Character, Integer> mp = new HashMap<>();
    int curr = 0;
    HashMap<Integer, ArrayList<Integer>> colMp = new HashMap<>();
    for (int i = 0; i < m; i++) {
      colMp.put(i, new ArrayList<>());
    }
    while (n-- > 0) {
      char[] ipt = sc.nextLine().toCharArray();
      for (int i = 0; i < m; i++) {
        char c = ipt[i];
        if (!mp.containsKey(c)) {
          mp.put(c, curr);
          curr++;
        }
        colMp.get(i).add(mp.get(ipt[i]));
      }
    }
    for (ArrayList<Integer> c : colMp.values()) {
      int base = c.get(0);
      for (int stugrp : c) {
        unionfind.union(base, stugrp);
      }
    }
    sc.println(unionfind.ngrps);
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
