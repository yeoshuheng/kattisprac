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
public class chartingprogress {
  public static void main(String[] args) {
    FastIO sc = new FastIO();
    ArrayList<String> rows = new ArrayList<>();
    while (true) {
      String ipt = sc.nextLine();
      if (ipt == null || ipt.equals("")) {
        int ncols = rows.get(0).length();
        int nrows = rows.size();
        char[][] mat = new char[ncols][nrows];
        for (int i = 0; i< nrows; i++) {
          char[] cr = rows.get(i).toCharArray();
          for (int j = 0; j < ncols; j++) {
            mat[j][i] = cr[j];
          }
        }
        String[] comb = new String[ncols];
        for (int i = 0; i < mat.length; i++) {
          comb[i] = new String(mat[i]);
        }
        Arrays.sort(comb, Collections.reverseOrder());
        char[][] inversemat = new char[nrows][ncols];
        for (int i = 0; i < comb.length; i++) {
          String cc = comb[i];
          for (int j = 0; j < cc.length(); j++) {
            inversemat[j][i] = cc.charAt(j);
          }
        }
        for (char[] s : inversemat) {
          sc.println(new String(s));
        }
        sc.println();
        rows = new ArrayList<>();
        if (ipt == null) {break;}
        continue;
      }
      rows.add(ipt);
    }
    sc.close();
  }
}
