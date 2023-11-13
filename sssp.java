import java.util.*;
import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class sssp {
  public static HashMap<Integer, ArrayList<Integer[]>> mp;
  public static void main(String[] args) {
    Deque<String> rett = new LinkedList<>();
    FastIO sc = new FastIO();
    while (true) {
      int n = sc.nextInt(); int m = sc.nextInt(); int q = sc.nextInt(); int s = sc.nextInt();
      if (n == 0 && m == 0 && q == 0 && s == 0) {break;}
      mp = new HashMap<>();
      int[] best = new int[n + 1];
      for (int i = 0; i <= n; i++) {mp.put(i, new ArrayList<>()); best[i] = Integer.MAX_VALUE;}
      while (m-- > 0) {int u = sc.nextInt(); int v = sc.nextInt(); int w = sc.nextInt();
        mp.get(u).add(new Integer[]{v, w}); //mp.get(v).add(new Integer[]{u, w});
      }
      PriorityQueue<Integer[]> states = new PriorityQueue<>(new Comparator<Integer[]>() {
        @Override
        public int compare(Integer[] o1, Integer[] o2) {
          return o1[1] > o2[1] ? 1 : -1;
        }
      });
      states.add(new Integer[]{s, 0});
      best[s] = 0;
      while (!states.isEmpty()) {
        Integer[] cstate = states.poll();
        int curr = cstate[0]; int cw = cstate[1];
        for (Integer[] neigh : mp.get(curr)) {
          int nxt = neigh[0]; int nw = neigh[1] + cw;
          if (best[nxt] <= nw) {continue;}
          best[nxt] = nw;
          states.add(new Integer[]{nxt, nw});
        }
      }
      while (q-- > 0) {
        int ret = best[sc.nextInt()];
        if (ret == Integer.MAX_VALUE) {rett.add("Impossible");} else {
          rett.add(String.valueOf(ret));}
      }
      rett.add("{}");
    }
    while (rett.size() > 1) {
      String s = rett.pollFirst();
      if (s.equals("{}")) {sc.println();} else {sc.println(s);}
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
