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
class vegetable {
  public int nCuts = 0;
  public double initialweight;
  public double newWeight;

  public vegetable(double initialweight_) {
    initialweight = initialweight_;
    newWeight = initialweight;
  }
  public void cut() {
    nCuts++;
    newWeight = initialweight / (nCuts + 1);
  }
}
public class boilingveges {
  public static void main(String[] args) {
    FastIO sc = new FastIO();
    int cuts = 0;
    TreeSet<vegetable> pq = new TreeSet<>(new Comparator<vegetable>() {
      @Override
      public int compare(vegetable o1, vegetable o2) {
        return o1.newWeight > o2.newWeight ? 1 : -1;
      }
    });
    double t = sc.nextDouble(); int n = sc.nextInt();
    while (n-- > 0) {
      double cw = sc.nextDouble();
      pq.add(new vegetable(cw));
    }
    while (true) {
      vegetable largest = pq.pollLast();
      vegetable smallest = pq.first();
      double largesize = largest.newWeight; double smallsize = smallest.newWeight;
      if (smallsize / largesize > t) {
        sc.println(cuts);
        sc.close();
        return;
      }
      cuts++;
      largest.cut();
      pq.add(largest);
    }
  }
}
