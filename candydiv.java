import java.util.*;
import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
public class candydiv {
  public static void main(String[] args) {
    FastIO sc = new FastIO();
    long n = sc.nextInt();
    HashSet<Long> ret = new HashSet<>();
    for (long i = 1; i < (long) (Math.sqrt(n) + 2); i++) {
      if (n % i == 0) {
        ret.add(i);
        ret.add(n / i);
      }
    }
    Long[] rett = new Long[ret.size()];
    rett = ret.toArray(rett);
    Arrays.sort(rett);
    StringBuilder sb = new StringBuilder();
    for (long r : rett) {
      sb.append((r - 1) + " ");
    }
    sc.println(sb);
    sc.close();
  }
}


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