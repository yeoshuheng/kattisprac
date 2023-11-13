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
public class martentheorem {

  public static HashSet<String> seen;

  public static void main(String[] args) {
    FastIO sc = new FastIO();
    int tc = sc.nextInt();
    unionfind2 yesuf = new unionfind2();
    unionfind2 nouf = new unionfind2();
    seen = new HashSet<>();
    while (tc-- > 0) {
      String[] ipt = sc.nextLine().split(" ");
      String a = ipt[0]; String b = ipt[2]; String cmd = ipt[1];
      switch (cmd) {
        case "is":
          if (nouf.find(a) == nouf.find(b)) {
            sc.println("wait what?");
            sc.close();
            return;}
          yesuf.union(a, b);
          break;
        case "not":
          if (yesuf.find(a) == yesuf.find(b)) {
            sc.println("wait what?");
            sc.close();
            return;
          }
          nouf.union(a, b);
          break;
      }
      seen.add(a); seen.add(b);
    }
    sc.println("yes");
    sc.close();
    return;
  }
}
class unionfind2 {

  public HashMap<String, String> parents;

  public unionfind2() {
    parents = new HashMap<>();
  }

  public String find(String x) {
    if (!parents.containsKey(x)) {parents.put(x, x);}
    String par = parents.get(x);
    if (x.equals(par)) {return x;}
    String newpar = parents.get(par);
    parents.put(x, newpar);
    return newpar;
  }

  public void union(String a, String b) {
    String pa = find(a); String pb = find(b);
    if (pa.equals(pb)) {return;}
    parents.put(pa, pb);
  }

}
