import com.sun.source.tree.Tree;

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
public class grandpabernie {
  public static void main(String[] args) {
    FastIO sc = new FastIO();
    int n = sc.nextInt();
    TreeMap<String, PriorityQueue<Integer>> mp = new TreeMap<>();
    while (n-- > 0) {
      String[] ipt = sc.nextLine().split(" ");
      String cty = ipt[0]; int yr = Integer.parseInt(ipt[1]);
      if (!mp.containsKey(cty)) {
        mp.put(cty, new PriorityQueue<>());
      }
      mp.get(cty).add(yr);
    }
    TreeMap<String, Integer[]> mps = new TreeMap<>();
    for (String k : mp.keySet()) {
      Integer[] sorted = new Integer[mp.get(k).size()];
      PriorityQueue<Integer> pq = mp.get(k);
      int c = 0;
      while (!pq.isEmpty()) {
        sorted[c] = pq.poll();
        c++;
      }
      mps.put(k, sorted);
    }
    int q = sc.nextInt();
    while (q-- > 0) {
      String[] ipt = sc.nextLine().split(" ");
      String cty = ipt[0]; int k = Integer.parseInt(ipt[1]);
      int ret = 0;
      sc.println(mps.get(cty)[k - 1]);
    }
    sc.close();
  }
}
