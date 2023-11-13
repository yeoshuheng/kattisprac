import java.util.HashMap;
import java.util.HashSet;
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

public class forests {
  public static void main(String[] args) {
    FastIO sc = new FastIO();
    int p = sc.nextInt(); int t = sc.nextInt();
    String ipt;
    HashMap<Integer, HashSet<Integer>> opinions = new HashMap<>();
    for (int i = 1; i <= p; i++) {
      opinions.put(i, new HashSet<>());
    }
    while ((ipt = sc.nextLine()) != null) {
      StringTokenizer st = new StringTokenizer(ipt);
      int a = Integer.parseInt(st.nextToken()); int b = Integer.parseInt(st.nextToken());
      opinions.get(a).add(b);
    }
    HashSet<HashSet<Integer>> seenOpinions = new HashSet<>();
    for (HashSet<Integer> ii : opinions.values()) {
      seenOpinions.add(ii);
    }
    sc.println(seenOpinions.size());
    sc.close();
  }
}
