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
public class builddeps {

  public static HashMap<String, Boolean> visited = new HashMap<>();
  public static HashMap<String, ArrayList<String>> adjMap = new HashMap<>();

  public static Deque<String> toposort = new LinkedList<>();

  public static void dfs(String s) {
    visited.put(s, true);
    for (String neighbor : adjMap.get(s)) {
      if (!visited.get(neighbor)) {
        dfs(neighbor);
      }
    }
    //System.out.println("adding to topo sort: " + s);
    toposort.addFirst(s);
  }

  public static void main(String[] args) {
    FastIO sc = new FastIO();
    int n = sc.nextInt();
    while (n-- > 0) {
      String ipt = sc.nextLine();
      String[] instr = ipt.split(":");
      String fname = instr[0];
      if (!adjMap.containsKey(fname)) {adjMap.put(fname, new ArrayList<>()); visited.put(fname, false);}
      if (instr.length == 1) {continue;}
      String[] dep = instr[1].split(" ");
      for (String odep : dep) {
        if (odep == "") {continue;}
        if (!adjMap.containsKey(odep)) {adjMap.put(odep, new ArrayList<>()); visited.put(odep, false);}
        adjMap.get(odep).add(fname);
      }
    }
    dfs(sc.next());
    while (!toposort.isEmpty()) {
      sc.println(toposort.poll());
    }
    sc.close();
  }
}
