import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;
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

public class sidewaysort {
  public static void main(String[] args) {
    FastIO sc = new FastIO();
    while(true) {
      int r = sc.nextInt(); int c = sc.nextInt();
      if (r == 0 && c == 0) {break;}
      char[][] mat = new char[c][r];
      for (int i = 0; i < r; i++) {
        String st = sc.nextLine();
        char[] temp = st.toCharArray();
        // i -> row, j -> column
        // swapover, i -> column, j -> row
        for (int j = 0; j < temp.length; j++) {
          mat[j][i] = temp[j];
        }
      }
      String[] st = new String[c];
      for (int i = 0; i < mat.length; i++) {
        st[i] = new String(mat[i]);
      }
      Arrays.sort(st, new Comparator<String> () {
        @Override
        public int compare(String s1, String s2) {
          return s1.toUpperCase().compareTo(s2.toUpperCase());
      }});
      char[][] reversedmat = new char[r][c];
      for (int i = 0; i < st.length; i++) {
        int ll = st[i].length();
        for (int j = 0; j < ll; j++) {
          reversedmat[j][i] = st[i].charAt(j);
        }
      }
      for (char[] opt : reversedmat) {
        sc.println(new String(opt));
      }
      //printMat(reversedmat);
    }
    sc.close();
  }
  public static void printMat(char[][] mat) {
    System.out.println("Checking mat");
    for (char[] ss : mat) {
      System.out.println(new String(ss));
    }
  }
}
