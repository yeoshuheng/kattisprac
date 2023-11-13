import com.sun.source.tree.Tree;

import java.util.*;
import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class luckyticket {
  public static void main(String[] args) {
    FastIO sc = new FastIO();
    long n = sc.nextLong();
    HashMap<Long, Integer> evens = new HashMap<>();
    HashMap<Long, Integer> odds = new HashMap<>();
    for (int i = 0; i < n; i++) {
      String s = sc.next();
      long val = 0;
      for (char c : s.toCharArray()) {
        val += Integer.parseInt(String.valueOf(c));
      }
      if (s.length() % 2 == 0) {
        evens.put(val, evens.getOrDefault(val, 0) + 1);
      } else {odds.put(val, odds.getOrDefault(val, 0) + 1);}
    }

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
