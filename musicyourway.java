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

public class musicyourway {

  public static HashMap<Integer, String> idx_Var = new HashMap<>();
  public static HashMap<String, Integer> var_Idx = new HashMap<>();

  public static void main(String[] args) {
    FastIO sc = new FastIO();
    String[] attr = sc.nextLine().split(" ");
    for (int i = 0; i < attr.length; i++) {
      idx_Var.put(i, attr[i]);
      var_Idx.put(attr[i], i);
    }
    ArrayList<String[]> all = new ArrayList<>();
    int m = sc.nextInt();
    while (m-- > 0) {
      String[] ipt = sc.nextLine().split(" ");
      all.add(ipt);
    }
    int q = sc.nextInt();
    while (q-- > 0) {
      String atr = sc.nextLine();
      int idx = var_Idx.get(atr);
      all.sort(new Comparator<String[]>() {
        @Override
        public int compare(String[] o1, String[] o2) {
          return o1[idx].compareTo(o2[idx]);
        }
      });
      StringBuilder sb = new StringBuilder();
      for (String sa : attr) {
        sb.append(sa + " ");
      }
      sc.println(sb);
      for (String[] sa : all) {
        sb = new StringBuilder();
        for (String ss : sa) {
          sb.append(ss + " ");
        }
        sc.println(sb);
      }
      sc.println();
    }
    sc.close();
  }
}
