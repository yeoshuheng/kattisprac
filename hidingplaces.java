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
public class hidingplaces {
  public static ArrayList<Integer[]> moves = new ArrayList<>();
  public static HashMap<Character, Integer> cmp = new HashMap<>();
  public static HashMap<Integer, Character> imp = new HashMap<>();

  public static void main(String[] args) {
    FastIO sc = new FastIO();
    moves.add(new Integer[]{2, 1});
    moves.add(new Integer[]{2, -1});
    moves.add(new Integer[]{-2, 1});
    moves.add(new Integer[]{-2, -1});
    moves.add(new Integer[]{1, 2});
    moves.add(new Integer[]{1, -2});
    moves.add(new Integer[]{-1, 2});
    moves.add(new Integer[]{-1, -2});
    char c = 'a';
    for (int i = 1; i <= 8; i++) {cmp.put(c, i); imp.put(i, c); c++;}
    int t = sc.nextInt();
    while (t-- > 0) {
      String strt = sc.nextLine();
      Deque<Integer[]> states = new LinkedList<>();
      states.add(new Integer[]{cmp.get(strt.charAt(0)), Integer.parseInt(String.valueOf(strt.charAt(1))), 0});
      boolean[][] seen = new boolean[9][9];
      int maxMoves = 0;
      TreeSet<Integer[]> ret = new TreeSet<>(new Comparator<Integer[]>() {
        @Override
        public int compare(Integer[] o1, Integer[] o2) {
          if (o1[1] == o2[1]) {return o1[0] < o2[0] ? -1 : 1;}
          return o1[1] < o2[1] ? 1 : -1;
        }
      });
      for (int i = 0; i < 9; i++) {for (int j = 0; j < 9; j++) {seen[i][j] = false;}}
      while (!states.isEmpty()) {
        Integer[] curr = states.poll();
        if (seen[curr[0]][curr[1]]) {continue;}
        if (curr[2] > maxMoves) {ret.clear(); maxMoves = curr[2];}
        if (curr[2] == maxMoves) {ret.add(curr);}
        seen[curr[0]][curr[1]] = true;
        for (Integer[] changes : moves) {
          int nxtx = curr[0] + changes[0]; int nxty = curr[1] + changes[1];
          if (nxtx < 1 || nxty < 1 || nxtx > 8 || nxty > 8 || seen[nxtx][nxty]) {continue;}
          states.offer(new Integer[]{nxtx, nxty, curr[2] + 1});
          //seen[nxtx][nxty] = true;
        }
      }
      StringBuilder sb = new StringBuilder();
      sb.append(maxMoves + " ");
      for (Integer[] st : ret) {
        char chh = imp.get(st[0]);
        sb.append(chh + String.valueOf(st[1]) + " ");
      }
      sc.println(sb);
    }
    sc.close();
  }
}
