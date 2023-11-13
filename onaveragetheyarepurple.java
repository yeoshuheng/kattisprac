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
public class onaveragetheyarepurple {
  public static HashMap<Integer, ArrayList<Integer>> adj;
  //public static HashMap<Integer, Integer> best = new HashMap<>();
  public static void main(String[] args) {
    FastIO sc = new FastIO();
    int n = sc.nextInt(); int m = sc.nextInt();
    adj = new HashMap<>();
    for (int i = 1; i <= n; i++) {
      adj.put(i, new ArrayList<>());
    }
    while (m-- > 0) {
      int a = sc.nextInt(); int b = sc.nextInt();
      adj.get(a).add(b); adj.get(b).add(a);
    }
    HashSet<Integer> seen = new HashSet<>();
    PriorityQueue<Integer[]> states = new PriorityQueue<>(new Comparator<Integer[]>() {
      @Override
      public int compare(Integer[] o1, Integer[] o2) {
        return o1[1] < o2[1] ? -1 : 1;
      }
    });
    int retcost = 0;
    states.add(new Integer[]{1, 0});
    while (!states.isEmpty()) {
      Integer[] cstate = states.poll();
      int curr = cstate[0]; int ccost = cstate[1];
      //System.out.println("i'm @ " + curr + " with cost " + ccost);
      if (curr == n) {retcost = ccost; break;}
      seen.add(curr);
      for (int neigh : adj.get(curr)) {
        if (seen.contains(neigh)) {continue;}
        states.add(new Integer[]{neigh, ccost + 1});
      }
    }
    if (retcost % 2 == 0) {sc.println(retcost - 1);} else {sc.println((retcost -1));}
    sc.close();
  }
}
