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
public class elevatortrouble {
  public static void main(String[] args) {
    FastIO sc = new FastIO();
    long f = sc.nextLong(); long s = sc.nextLong(); long g = sc.nextLong();
    long u = sc.nextLong(); long d = sc.nextLong();
    Deque<Long[]> states = new LinkedList<>();
    HashSet<Long> visited = new HashSet<>();
    states.add(new Long[]{s, (long) 0});
    while (!states.isEmpty()) {
      Long[] cstate = states.pollFirst();
      long currfloor = cstate[0]; long used = cstate[1];
     // System.out.println("I'm at floor " + currfloor);
      if (currfloor == g) {sc.println(used); sc.close(); return;}
      visited.add(currfloor);
      if (currfloor + u <= f && !visited.contains(currfloor + u)) {
        visited.add(currfloor + u);
        states.add(new Long[]{currfloor + u, used + 1});}
      if (currfloor - d >= 0 && !visited.contains(currfloor - d)) {
        visited.add(currfloor - d);
        states.add(new Long[]{currfloor - d, used + 1});}
    }
    sc.println("use the stairs");
    sc.close();
  }
}
