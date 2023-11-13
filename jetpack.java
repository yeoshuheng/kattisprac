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

class State {
  public int row;
  public int col;

  public State(int r, int c) {
    row = r;
    col = c;
  }

}

public class jetpack {
  public static char[][] grid;

  public static int[][] moveStates;

  public static Deque<Integer[]> finalMoves = new LinkedList<>();

  public static int[] bounds;

  public static void main(String[] args) {
    FastIO sc = new FastIO();
    int n = sc.nextInt();
    String[] gridtemp = new String[10];
    for (int i = 0; i < 10; i++) {
      String ipt = sc.nextLine();
      gridtemp[i] = ipt;
    }
    grid = new char[10][n];
    for (int i = 0; i < gridtemp.length; i++) {
      char[] st = gridtemp[i].toCharArray();
      for (int j = 0; j < st.length; j++) {
        grid[i][j] = st[j];
      }
    }
    bounds = new int[]{grid.length, grid[0].length};
    moveStates = new int[grid.length][grid[0].length];
    //System.out.println(Arrays.toString(bounds));
    moveStates[bounds[0] - 1][0] = 0;
    dfs(bounds[0] - 1, 0, new LinkedList<>());
    //while (!finalMoves.isEmpty()) {
    //  System.out.println(Arrays.toString(finalMoves.poll()));
    //}
    Deque<Integer[]> ret = new LinkedList<>();
    while (!finalMoves.isEmpty()) {
      Integer[] curr = finalMoves.poll();
      if (curr[2] == 0) {continue;}
      if (curr[2] == 1) {
        if (ret.isEmpty()) {curr[0] = curr[1]; ret.add(curr); continue;}
        if (ret.peekLast()[1] == curr[1] - 1) {ret.peekLast()[1]++; ret.peekLast()[2]++;}
        else {curr[0] = curr[1]; ret.add(curr);}
      }
    }
    sc.println(ret.size());
    for (Integer[] mv : ret) {
      sc.println(mv[0] + " " + mv[2]);
    }
    sc.close();
  }

  public static void dfs(int x, int y, Deque<Integer[]> moves) {
    //System.out.println("i'm at: " + x + ", " + y);
    grid[x][y] = 'X';

    if (y == bounds[1] - 1) {
      finalMoves = new LinkedList<>(moves);
      return;
    }

    if (x + 1 < bounds[0] && y + 1 < bounds[1] && grid[x + 1][y + 1] != 'X') {
      moves.add(new Integer[]{x, y, 0});
      dfs(x + 1, y + 1, moves);
      moves.pollLast();
    }

    if (x == bounds[0] - 1 && y + 1 < bounds[1] && grid[x][y + 1] != 'X') {
      moves.add(new Integer[]{x, y, 0});
      dfs(x, y + 1, moves);
      moves.pollLast();
    }

    if (x == 0 && y + 1 < bounds[1] && grid[x][y + 1] != 'X') {
      moves.add(new Integer[]{x, y, 1});
      dfs(x, y + 1, moves);
      moves.pollLast();
    }

    if (x - 1 > -1 && x - 1 < bounds[0] && y > -1 && y + 1 < bounds[1] && grid[x - 1][y + 1] != 'X') {
      moves.add(new Integer[]{x, y, 1});
      dfs(x - 1, y + 1, moves);
      moves.pollLast();
    }
  }
}
