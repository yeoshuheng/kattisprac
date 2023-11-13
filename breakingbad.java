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
public class breakingbad {
  public static HashSet<String> w = new HashSet<>();
  public static HashSet<String> j = new HashSet<>();
  public static HashMap<String, ArrayList<String>> adj = new HashMap<>();
  public static ArrayList<String> ig = new ArrayList<>();
  public static void main(String[] args) {
    FastIO sc = new FastIO(); long n = sc.nextLong();
    while (n-- > 0) {
      String igg = sc.nextLine();
      adj.put(igg, new ArrayList<>());
      ig.add(igg);
    } long m = sc.nextLong();
    while (m-- > 0) {
      String a = sc.next(); String b = sc.next();
      adj.get(a).add(b); adj.get(b).add(a);
    }
    for (String igg : ig) {boolean res = dfs(igg);
    if (!res){sc.println("impossible"); sc.close(); return;}}
    StringBuilder ww = new StringBuilder();
    for (String s : w) {ww.append(s + " ");}
    StringBuilder jj = new StringBuilder();
    for (String s : j) {jj.append(s + " ");}
    sc.println(ww); sc.println(jj); sc.close();
  }

  public static boolean dfs(String c) {
    if (!w.contains(c) && !j.contains(c)) {w.add(c);}
    boolean poss = true;
    for (String nxt : adj.get(c)) {
      if (w.contains(c) && !j.contains(nxt) && !w.contains(nxt)) {
        j.add(nxt); dfs(nxt);
      }
      if (j.contains(c) && !j.contains(nxt) && !w.contains(nxt)) {
        w.add(nxt); dfs(nxt);
      }
      if ((j.contains(c) && j.contains(nxt)) || (w.contains(c) && w.contains(nxt))) {
        poss = false;
        break;
      }
    }
    return poss;
  }
}
