import java.util.Arrays;
import java.util.StringTokenizer;
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
public class driving {
  public static void main(String[] args) {
    FastIO sc = new FastIO();
    int n = sc.nextInt(); int p = sc.nextInt();
    long[] cars = new long[n];
    for (int i = 0; i < n; i++) {
      cars[i] = sc.nextLong();
    }
    Arrays.sort(cars);
    long[] distNeeded = new long[n];
    long ret = Long.MIN_VALUE;
    for (int i = 0; i < n; i++) {
      distNeeded[i] = ((i + 1) * p);
      ret = Math.max(ret, distNeeded[i] - cars[i]);
    }
    sc.println(ret + cars[0]);
    sc.close();
  }
}
