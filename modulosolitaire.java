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
public class modulosolitaire {
  public static void main(String[] args) {
    FastIO sc = new FastIO();
    long m = sc.nextLong(); int n = sc.nextInt(); long s = sc.nextLong();
    ArrayList<Long[]> moves = new ArrayList<>();
    while (n-- > 0) {
      long a = sc.nextLong(); long b = sc.nextLong();
      moves.add(new Long[]{a, b});
    }
    HashSet<Long> seen = new HashSet<>();
    Deque<Long[]> states = new LinkedList<>();
    states.add(new Long[]{s, (long) 0});
    while (!states.isEmpty()) {
      Long[] cstate = states.pollFirst();
      Long currs = cstate[0]; long used = cstate[1];
      if (currs.equals(Long.valueOf(0))) {sc.println(used); sc.close(); return;}
      if (currs < 0) {continue;}
      seen.add(currs);
      for (Long[] change : moves) {
        long newState = (currs * change[0] + change[1]) % m;
        if (newState < 0   || seen.contains(newState)) {continue;}
        Long[] nxt = new Long[]{newState, used + 1};
        states.addLast(nxt);
        seen.add(newState);
      }
    }
    sc.println(-1);
    sc.close();
  }
}
