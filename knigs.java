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
public class knigs {
  public static void main(String[] args) {
    FastIO sc = new FastIO();
    int k = sc.nextInt(); long n = sc.nextInt();
    String[] ka = sc.nextLine().split(" ");
    Long[] perf = new Long[(int) n - 1];
    int kay = Integer.parseInt(ka[0]);
    PriorityQueue<Long> pq11 = new PriorityQueue<>(Collections.reverseOrder());
    long ks = Long.parseLong(ka[1]);
    if (kay != 2011) {
      perf[kay - 2012] = ks;
    } else {
      pq11.offer(ks);
    }
    long x =  n + k - 2;
    while (x-- > 0) {
      String[] other = sc.nextLine().split(" ");
      int othy = Integer.parseInt(other[0]);
      long oths = Long.parseLong(other[1]);
      if (othy == 2011) {
        pq11.offer(oths);
      } else {
        perf[(int) othy - 2012] = oths;
      }
    }
    if (pq11.poll() == ks && kay == 2011) {
      sc.println(2011);
      sc.close();
      return;
    }
    for (int i = 0; i < perf.length; i++) {
      long s = perf[i];
      pq11.offer(s);
      if (pq11.poll() == ks) {
        sc.println(i + 2012);
        sc.close();
        return;
      }
    }
    sc.println("unknown");
    sc.close();
  }
}
