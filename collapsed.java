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
public class collapsed {

  public static HashSet<Integer> collapsed = new HashSet<>();
  public static HashMap<Integer, Integer> goodsNeeded;

  public static HashMap<Integer, Integer> currState;

  public static HashMap<Integer, ArrayList<Integer[]>> adjMap;

  public static void main(String[] args) {
    FastIO sc = new FastIO();
    int n = sc.nextInt();
    goodsNeeded = new HashMap<>();
    adjMap = new HashMap<>();
    currState = new HashMap<>();
    for (int i = 1; i <= n; i++) {
      goodsNeeded.put(i, 0);
      adjMap.put(i, new ArrayList<>());
    }
    for (int i = 1; i <= n; i++) {
      int t = sc.nextInt(); int k = sc.nextInt();
      goodsNeeded.put(i, t);
      int gettingNow = 0;
      while (k-- > 0) {
        int partner = sc.nextInt(); int goods = sc.nextInt();
        //System.out.println("adding edge " + partner + "->" + i);
        adjMap.get(partner).add(new Integer[]{i, goods});
        gettingNow += goods;
      }
      currState.put(i, gettingNow);
    }
    dfs(1);
    sc.println(n - collapsed.size());
    sc.close();
  }
  public static void dfs(int i) {
    //System.out.println(i + " has collapsed!");
    collapsed.add(i);
    for (Integer[] trade : adjMap.get(i)) {
      int neigh = trade[0]; int goodsDue = trade[1];

      //System.out.println("checking " + neigh);
      if (collapsed.contains(neigh)) {continue;}
      currState.put(neigh, currState.get(neigh) - goodsDue);
      if (currState.get(neigh) < goodsNeeded.get(neigh)) {
        dfs(neigh);
      }
    }
  }
}
