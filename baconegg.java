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

public class baconegg {
  public static void main(String[] args) {
    FastIO sc = new FastIO();
    while (true) {
      int n = sc.nextInt();
      if (n == 0) {break;}
      TreeMap<String, TreeSet<String>> hm = new TreeMap<>();
      for (int i = 0; i < n; i++) {
        String[] ipt = sc.nextLine().split(" ");
        String name = ipt[0];
        for (int j = 1; j < ipt.length; j++) {
          String food = ipt[j];
          if (!hm.containsKey(food)) {hm.put(food, new TreeSet<>());}
          hm.get(food).add(name);
        }
      }
      for (String me : hm.keySet()) {
        StringBuilder sb = new StringBuilder();
        sb.append(me + " ");
        for (String w : hm.get(me)) {
          sb.append(w +  " ");
        }
        sc.println(sb);
      }
      sc.println();
    }
    sc.close();
  }
}
