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
public class quickscope {
  public static void main(String[] args) {
    FastIO sc = new FastIO();
    int n = sc.nextInt();
    TreeMap<Integer, HashMap<String, String>> seen = new TreeMap<>();
    int cBlock = Integer.MAX_VALUE;
    while (n-- > 0) {
      String ipt = sc.nextLine();
      if (ipt.equals("{")) {
        cBlock--;
        seen.remove(cBlock);
        continue;
      }
      if (ipt.equals("}")) {
        cBlock++;
        continue;
      };
      if (!seen.containsKey(cBlock)) {
        seen.put(cBlock, new HashMap<>());
      }
      StringTokenizer var = new StringTokenizer(ipt);
      String command = var.nextToken();
      switch (command) {
        case "TYPEOF":
          String varName = var.nextToken();
          boolean canfind = false;
          SortedMap<Integer, HashMap<String, String>> sm = seen.tailMap(cBlock);
          for (HashMap<String, String> t : sm.values()) {
            String ret = t.get(varName);
            if (ret != null) {
              sc.println(t.get(varName));
              canfind = true;
              break;
            }
          }
          if (!canfind) {sc.println("UNDECLARED");}
          break;
        case "DECLARE":
          varName = var.nextToken();
          String dtype = var.nextToken();
          HashMap<String, String> tmp = seen.get(cBlock);
          if (tmp.containsKey(varName)) {
            sc.println("MULTIPLE DECLARATION");
            sc.close();
            return;
          } else {
            tmp.put(varName, dtype);
          }
          break;
      }
    }
    sc.close();
  }
}
