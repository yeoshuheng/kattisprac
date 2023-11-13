import java.util.*;
import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class pointsmindist {
  public static void main(String[] args) {
    FastIO sc = new FastIO();
    int t = sc.nextInt();
    while (t-- > 0) {
      int n = sc.nextInt();
      int[] arr = new int[2 * n];
      for (int i = 0; i < 2 * n; i++) {
        arr[i] = sc.nextInt();
      }
      Arrays.sort(arr);
      //System.out.println(Arrays.toString(arr));
      if (arr.length == 2) {sc.println(0); sc.println(arr[0] + " " + arr[1]);} else {
        //sc.println(Math.abs(arr[(2 * n) - 1] - arr[(2 * n) - 2]));
        sc.println(Math.abs(arr[0] - arr[n - 1]) + Math.abs(arr[n] - arr[2 * n - 1]));
        for (int i = 0; i < n; i++) {
          sc.println(arr[i] + " " + arr[n + i]);
        }
      }
    }
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