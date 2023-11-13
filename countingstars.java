import java.util.ArrayList;
import java.util.Arrays;
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

public class countingstars {

  public static ArrayList<Integer[]> dir = new ArrayList<>();
  public static void dfs (int x, int y, char[][] grid) {
    if (grid[x][y] == '#') {return;}
    grid[x][y] = '#';
    for (Integer[] mv : dir) {
      int newx = x + mv[0]; int newy = y + mv[1];
      if (newx < 0 || newx >= grid.length || newy < 0 || newy >= grid[0].length || grid[newx][newy] == '#') {
        continue;
      }
      dfs(newx, newy, grid);
    }
  }

  public static void main(String[] args) {
    FastIO sc = new FastIO();
    dir.add(new Integer[]{0, 1});
    dir.add(new Integer[]{0, -1});
    dir.add(new Integer[]{-1, 0});
    dir.add(new Integer[]{1, 0});
    int tc = 0;
    while (true) {
      String ipt = sc.nextLine();
      if (ipt == null) {break;}
      tc++;
      String[] iptt = ipt.split(" ");
      int m = Integer.parseInt(iptt[0]); int n = Integer.parseInt(iptt[1]);
      char[][] grid = new char[m][n];
      for (int i = 0; i < m; i++) {
        char[] rr = sc.nextLine().toCharArray();
        for (int j = 0; j < n; j++) {
          grid[i][j] = rr[j];
        }
      }
      int no = 0;
      for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
          if (grid[i][j] == '-') {
            //System.out.println("dfs @ " + i + ", " + j);
            dfs(i, j, grid);
            no++;
          }
        }
      }
      sc.println("Case " + tc + ": " + no);
    }
    sc.close();
  }
}
