import java.util.Arrays;
import java.util.Comparator;
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
public class synchrolist {
  public static void main(String[] args) {
    FastIO sc = new FastIO();
    while (true) {
      int n = sc.nextInt();
      if (n == 0) {break;}
      int[][] l1 = new int[n][2];
      int[] l2 = new int[n];
      for (int i = 0; i < n; i++) {
        l1[i] = new int[]{sc.nextInt(), i};
      }
      for (int i = 0; i < n; i++) {
        l2[i] = sc.nextInt();
      }
      Arrays.sort(l1, new Comparator<int[]>() {
        @Override
        public int compare(int[] o1, int[] o2) {
          return o1[0] > o2[0] ? 1 : -1;
        }
      });
      Arrays.sort(l2);
      int[] sortedl2 = new int[n];
      for (int i = 0; i < l1.length; i++) {
        int correctpos = l1[i][1];
        sortedl2[correctpos] = l2[i];
      }
      for (int i : sortedl2) {
        sc.println(i);
      }
      sc.println();
    }
    sc.close();
  }
}
