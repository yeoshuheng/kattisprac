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

public class wdtfs {
  public static void main(String[] args) {
    FastIO sc = new FastIO();
    int t = sc.nextInt();
    while (t-- > 0) {
      String[] tc = sc.nextLine().split(" ");
      HashSet<String> sounds = new HashSet<>();
      for (String tt : tc) {
        sounds.add(tt);
      }
      while (true) {
        String ct = sc.nextLine();
        if (ct.equals("what does the fox say?")) {break;}
        String[] ctt = ct.split(" ");
        sounds.remove(ctt[ctt.length - 1]);
      }
      StringBuilder sb = new StringBuilder();
      for (String s : tc) {
        if (sounds.contains(s)) {
          sb.append(s + " ");
        }
      }
      sc.println(sb);
    }
    sc.close();
  }
}
