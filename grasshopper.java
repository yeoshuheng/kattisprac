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
public class grasshopper {

  public static long minJump;

  public static boolean[][] visited;

  public static ArrayList<Integer[]> moves = new ArrayList<>();

  public static void bfs(int r, int c, int gr, int gc, int lr, int lc) {
    visited = new boolean[r + 1][c + 1];
    minJump = Long.MAX_VALUE;
    for (int rr = 1; rr <= r; rr++) {
      for (int cc = 1; cc <= c; cc++) {
        visited[rr][cc] = false;
      }
    }
    Deque<Integer[]> q = new LinkedList<>();
    q.add(new Integer[]{gr, gc, 0});
    while (!q.isEmpty()) {
      Integer[] state = q.pop();
      int cr = state[0]; int cc = state[1]; int used = state[2];
      if (cr == lr && lc == cc) {
        minJump = Math.min(used, minJump);
        return;
      }
      visited[cr][cc] = true;
      for (Integer[] mv : moves) {
        int newr = cr + mv[0]; int newc = cc + mv[1];
        if (newc > c || newr > r || newc < 1 || newr < 1 || visited[newr][newc]) {
          continue;
        }
        visited[newr][newc] = true; // IMPORTANT!!!
        q.add(new Integer[]{newr, newc, used + 1});
      }
    }
  }

  public static void main(String[] args) {
    FastIO sc = new FastIO();
    String ipt;

    moves.add(new Integer[]{2, -1});
    moves.add(new Integer[]{2, 1});
    moves.add(new Integer[]{-2, -1});
    moves.add(new Integer[]{-2, 1});
    moves.add(new Integer[]{1, 2});
    moves.add(new Integer[]{1, -2});
    moves.add(new Integer[]{-1, 2});
    moves.add(new Integer[]{-1, -2});

    while ((ipt = sc.nextLine()) != null) {
      String[] iptt = ipt.split(" ");
      int r = Integer.parseInt(iptt[0]); int c = Integer.parseInt(iptt[1]);
      int gr = Integer.parseInt(iptt[2]); int gc =  Integer.parseInt(iptt[3]);
      int lr =  Integer.parseInt(iptt[4]);; int lc =  Integer.parseInt(iptt[5]);
      bfs(r, c, gr, gc, lr, lc);
      if (minJump == Long.MAX_VALUE) {sc.println("impossible");} else {
        sc.println(minJump);}
    }
    sc.close();
  }
}
