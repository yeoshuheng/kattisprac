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
public class buttonbashing {
  public static void main(String[] args) {
    FastIO sc = new FastIO();
    int tc = sc.nextInt();
    mainloop: while (tc-- > 0) {
      int n = sc.nextInt(); int t = sc.nextInt();
      int[] timeAdded = new int[n];
      for (int i = 0; i < n; i++) {
        timeAdded[i] = sc.nextInt();
      }

      Deque<Integer[]> states = new LinkedList<>();
      HashSet<Integer> seen = new HashSet<>();
      HashMap<Integer, Integer> distNeeded = new HashMap<>();
      for (int i = 0; i <= 3600; i++) {distNeeded.put(i, Integer.MAX_VALUE);}

      seen.add(0);
      states.add(new Integer[]{0, 0});
      while (!states.isEmpty()) {
       Integer[] cstate = states.poll();
       int ctime = cstate[0]; int used = cstate[1];
       seen.add(ctime);
       for (int nxttime : timeAdded) {
         int newtime = ctime + nxttime;
         if (states.contains(newtime) || newtime > 3600 || newtime < 0) {continue;}
         //System.out.println(newtime);
         if (used + 1 < distNeeded.get(newtime)) {
           distNeeded.put(newtime, used + 1);
           seen.add(newtime);
           states.add(new Integer[]{newtime, used + 1});
         }
       }
      }
      for (int i = t; i <= 3600; i++) {
        if (distNeeded.get(i) != Integer.MAX_VALUE) {
          sc.println(distNeeded.get(i) + " " + (i -t));
          break;
        }
      }
    }
    sc.close();
  }
}
