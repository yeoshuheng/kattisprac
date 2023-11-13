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
public class candydivision {
  public static void main(String[] args) {
    FastIO sc = new FastIO();
    long n = sc.nextLong();
    TreeSet<Long> arr = new TreeSet<>();
    for (long i = 1; i <= Math.sqrt(n); i++) {
      if (n % i == 0) {
        arr.add(i - 1);
        arr.add((n/i) - 1);
      }
    }
    while (!arr.isEmpty()) {
      sc.print(arr.pollFirst());
      sc.println(" ");
    }
    sc.close();
  }
}
