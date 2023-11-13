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
public class boatparts {
  public static void main(String[] args) {
    FastIO sc = new FastIO();
    HashSet<String> parts = new HashSet<>();
    int p = sc.nextInt(); int n = sc.nextInt();
    for (int i = 1; i <= n; i++) {
      parts.add(sc.nextLine());
      if (parts.size() == p) {
        sc.println(i);
        sc.close();
        return;
      }
    }
    sc.println("paradox avoided");
    sc.close();
  }
}
