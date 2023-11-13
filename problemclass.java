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
public class problemclass {
  public static void main(String[] args) {
    FastIO sc = new FastIO();
    int n = sc.nextInt();
    HashMap<String, HashSet<String>> mp = new HashMap<>();
    while (n-- > 0) {
      String cat = sc.next();
      int nn = sc.nextInt();
      while (nn-- > 0) {
        String curr = sc.next();
        if (!mp.containsKey(curr)) {
          mp.put(curr, new HashSet<>());
        }
        mp.get(curr).add(cat);
      }
    }
    String ipttt;
    HashMap<String, Long> count = new HashMap<>();
    while ((ipttt = sc.nextLine()) != null) {
      StringTokenizer st = new StringTokenizer(ipttt);
      while (st.hasMoreTokens()) {
        String ipt = st.nextToken();
        HashSet<String> cc = mp.get(ipt);
        if (cc == null) {
          continue;
        }
        for (String catt : cc) {
          count.put(catt, count.getOrDefault(catt, (long) 0) + 1);
        }
      }
    }
    TreeMap<Long, TreeSet<String>> arr = new TreeMap<>();
    for (Map.Entry<String, Long> e : count.entrySet()) {
      long ce = e.getValue();
      if (!arr.containsKey(ce)) {arr.put(ce, new TreeSet<>());}
      arr.get(ce).add(e.getKey());
    }
    Map.Entry<Long, TreeSet<String>> ts = arr.lastEntry();
    if (ts == null) {sc.close(); return;}
    for (String tt : ts.getValue()) {
      sc.println(tt);
    }
    sc.close();
  }
}