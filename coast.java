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
public class coast {

  public static ArrayList<Integer[]> MOVES = new ArrayList<>();

  public static boolean[][] visited;
  public static int dist = 0;

  public static int[][] grid;

  public static void main(String[] args) {
    MOVES.add(new Integer[]{0, -1});
    MOVES.add(new Integer[]{0, 1});
    MOVES.add(new Integer[]{1, 0});
    MOVES.add(new Integer[]{-1, 0});
    FastIO sc = new FastIO();
    int n = sc.nextInt(); int m = sc.nextInt();
    grid = new int[n + 2][m + 2]; visited = new boolean[n + 2][m + 2];
    for (int i = 0; i < m + 2; i++) {grid[0][i] = 0; grid[n + 1][i] = 0;}
    for (int i = 0; i < n + 2; i++) {grid[i][0] = 0; grid[i][m + 1] = 0;}
    for (int i = 1; i < n + 1; i++) {
      String ipt = sc.nextLine();
      for (int j = 1; j < m + 1; j++) {
        grid[i][j] = Integer.parseInt(String.valueOf(ipt.charAt(j - 1)));
        visited[i][j] = false;
      }
    }
    bfs(0, 0);
    sc.println(dist);
    sc.close();
  }

  public static void bfs(int i, int j) {
    Deque<Integer[]> q = new LinkedList<>();
    q.add(new Integer[]{i, j});
    //visited[i][j] = true;
    while (!q.isEmpty()) {
      Integer[] cstate = q.pollFirst();
      visited[cstate[0]][cstate[1]] = true;
      for (Integer[] nxtmve : MOVES) {
        int nxti = cstate[0] + nxtmve[0]; int nxtj = cstate[1] + nxtmve[1];
        if (nxti < 0 || nxtj < 0 || nxti >= grid.length || nxtj >= grid[0].length) {continue;}
        if (grid[nxti][nxtj] == 1) {
          dist++; continue;}
        if (visited[nxti][nxtj]) {continue;}
        q.add(new Integer[]{nxti, nxtj});
        visited[nxti][nxtj] = true;
      }
    }
  }
}
