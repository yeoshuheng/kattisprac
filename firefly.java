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




public class firefly {

  public static ArrayList<Integer> obstaclesLower = new ArrayList<>();
  public static ArrayList<Integer> obstaclesHigher = new ArrayList<>();

  public static int minCollisions;

  public static HashSet<Integer> level = new HashSet<>();

  public static int bSearch(int curr, ArrayList<Integer> obs) {
    int l = 0; int r = obs.size();
    while (l < r) {
      int mid = (l + r) / 2;
      if (obs.get(mid) >= curr) {r = mid;}
      else {l = mid + 1;}
    }
    return l;
  }

  public static void main(String[] args) {
    FastIO sc = new FastIO();
    int n = sc.nextInt(); int h = sc.nextInt();
    for (int i = 0; i < n; i++) {
      int oh = sc.nextInt();
      if (i % 2 == 1) {obstaclesHigher.add(oh);} else {
        obstaclesLower.add(oh);}
    }
    obstaclesLower.sort(Comparator.naturalOrder());
    obstaclesHigher.sort(Comparator.naturalOrder());


    TreeMap<Integer, Integer> tm = new TreeMap<>();
    for (int i = 1; i <= h; i++) {
      int res = n - bSearch(i, obstaclesLower) - bSearch(h - i + 1, obstaclesHigher);
      tm.put(res, tm.getOrDefault(res, 0) + 1);
    }
    Map.Entry<Integer, Integer> best = tm.firstEntry();
    sc.println(best.getKey() + " " + best.getValue());
    sc.close();
  }
}
