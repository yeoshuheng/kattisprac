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
public class brexit {
  public static HashMap<Integer, HashSet<Integer>> adjMap;
  public static HashMap<Integer, Integer> currSize;
  public static HashSet<Integer> left = new HashSet<>();

  public static void main(String[] args) {
    FastIO sc = new FastIO();
    int c = sc.nextInt(); int p = sc.nextInt(); int x = sc.nextInt(); int l = sc.nextInt();
     adjMap = new HashMap<>();
    currSize = new HashMap<>();
    while (p-- > 0) {
      int a = sc.nextInt(); int b = sc.nextInt();
      if (!adjMap.containsKey(a)) {adjMap.put(a, new HashSet<>());}
      if (!adjMap.containsKey(b)) {adjMap.put(b, new HashSet<>());}
      adjMap.get(a).add(b);
      adjMap.get(b).add(a);
    }
    for (Map.Entry<Integer, HashSet<Integer>> ety : adjMap.entrySet()) {
      currSize.put(ety.getKey(), ety.getValue().size());
    }
    dfs(l);
    if (left.contains(x)) {sc.println("leave");} else {sc.println("stay");}
    sc.close();
  }

  public static void dfs(int curr) {
    left.add(curr);
    //System.out.println(curr + " left!");
    for (int neigh : adjMap.get(curr)) {
      if (left.contains(neigh)) {continue;}
      currSize.put(neigh, currSize.get(neigh) - 1);
      if (currSize.get(neigh) <= Math.ceil(adjMap.get(neigh).size() / 2)) {
        dfs(neigh);
      }
    }
  }

}
