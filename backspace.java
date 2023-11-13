import java.util.Stack;
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

public class backspace {
  public static void main(String[] args) {
    FastIO sc = new FastIO();
    Stack<Character> st = new Stack<>();
    char[] ipt = sc.nextLine().toCharArray();
    for (int i = 0; i < ipt.length; i++) {
      if (ipt[i] == '<') {
        if (st.isEmpty()) {continue;}
        st.pop();
      } else {
        st.push(ipt[i]);
      }
    }
    StringBuilder sb = new StringBuilder();
    for (char i : st) {
      sb.append(i);
    }
    sc.println(sb);
    sc.close();
  }
}
