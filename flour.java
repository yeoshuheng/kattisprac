import java.util.ArrayList;
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

class flour {
  public static void main(String[] args) {
    FastIO sc = new FastIO();
    int n = sc.nextInt();
    ArrayList<Integer> q = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      int c = sc.nextInt();
      if (c == 0) {continue;}
      q.add(c);
    }
    long[] leftBound = new long[q.size() + 1];
    long[] rightBound = new long[q.size() + 1];
    leftBound[0] = 0;
    rightBound[q.size()] = 0;
    long sum = 0;
    for (int i = 1; i < q.size() + 1; i++) {
      int curr = q.get(i - 1);
      sum += curr * (i);
      leftBound[i] = sum;
    }
    sum = 0;
    for (int i = q.size() - 1; i > -1; i--) {
      int curr = q.get(i);
      sum += curr * (i + 2);
      rightBound[i] = sum;
    }
    long cMax = leftBound[0] + rightBound[0];
    for (int i = 0; i < leftBound.length; i++) {
      long c = leftBound[i] + rightBound[i];
      cMax = Math.max(cMax, c);
    }
    sc.println(cMax);
    sc.close();
  }
}