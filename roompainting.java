import java.util.Arrays;
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
public class roompainting {

  public static void main(String[] args) {
    FastIO sc = new FastIO();
    int n = sc.nextInt(); int m = sc.nextInt();
    long[] paints = new long[n];
    for (int i = 0; i < n; i++) {
      paints[i] = sc.nextLong();
    }
    Arrays.sort(paints);
    long[] needed = new long[m];
    for (int i = 0; i < m; i++) {
      needed[i] = sc.nextLong();
    }
    int wasted = 0;
    for (long needs : needed) {
      wasted += (binarySearch(needs, paints) - needs);
    }
    sc.println(wasted);
    sc.close();
  }

  public static long binarySearch(long target, long[] paints) {
    int l = 0; int r = paints.length;
    while (l < r) {
      int mid = (l + r) / 2;
      if (paints[mid] == target) {
        return target;
      }
      if (paints[mid] > target) {
        r = mid;
      } else {
        l = mid + 1;
      }
    }
    return paints[r];
  }
}
