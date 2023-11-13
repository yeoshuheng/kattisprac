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
public class lawnmower {
  public static void main(String[] args) {
    FastIO sc = new FastIO();
    while (true) {
      int n1 = sc.nextInt(); int n2 = sc.nextInt(); Double w = sc.nextDouble();
      if (n1 == 0 && n2 == 0 && w == (double) 0) {break;}
      double[] widthstart = new double[n1];
      double[] lengthstart = new double[n2];
      for (int i = 0; i < n1; i++) {
        widthstart[i] = sc.nextDouble();
      }
      for (int i = 0; i < n2; i++) {
        lengthstart[i] = sc.nextDouble();
      }
      boolean widthok = mergeIntervals(widthstart, w, 75);
      boolean lengthok = mergeIntervals(lengthstart, w, 100);
      sc.println(widthok && lengthok ? "YES" : "NO");
    }
    sc.close();
  }

  public static boolean mergeIntervals(double[] start, double w, double needed) {
    Arrays.sort(start);
    Double[][] intervals = new Double[start.length][2];
    double half = w / 2;
    for (int i = 0; i < start.length; i++) {
      double curr = start[i];
      intervals[i] = new Double[]{Math.max(0, curr - half), Math.min(curr + half, needed)};
    }
    Deque<Double[]> merged = new LinkedList<>();
    merged.add(intervals[0]);
    for (int i = 1; i < intervals.length; i++) {
      Double[] curr = intervals[i];
      double last = merged.peekLast()[1];
      if (curr[0] <= last) {
        merged.peekLast()[1] = Math.max(curr[1], last);
      } else {return false;}
    }
    Double[] finalmerge = merged.peek();
    return finalmerge[1] - finalmerge[0] >= needed;
  }
}
