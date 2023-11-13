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
public class numbertree {
  public static void main(String[] args) {
    FastIO sc = new FastIO();
    String[] ipt = sc.nextLine().split(" ");
    int h = Integer.parseInt(ipt[0]);
    char[] movement;
    if (ipt.length > 1) {
      movement = ipt[1].toCharArray();
    } else {
      movement = new char[0];
    }
    long n = (long) Math.pow(2, h + 1) - 1;
    long pos = 1;
    for (char c : movement) {
      if (c == 'L') {
        pos *= 2;
      } else {
        pos *= 2;
        pos++;
      }
    }
    sc.println(Math.max(n - (pos - 1), 0));
    sc.close();
    }
  }
