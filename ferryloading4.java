import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
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

public class ferryloading4 {
  public static void main(String[] args) {
    FastIO sc = new FastIO();
    int tc = sc.nextInt();
    while (tc-- > 0) {
      int l = sc.nextInt() * 100;
      int m = sc.nextInt();
      Queue<Long> leftBank = new LinkedList<>();
      Queue<Long> rightBank = new LinkedList<>();
      while (m-- > 0) {
        String[] ipt = sc.nextLine().split(" ");
        if (ipt[1].equals("left")) {
          leftBank.add(Long.parseLong(ipt[0]));
        } else {
          rightBank.add(Long.parseLong(ipt[0]));
        }
      }
      int cross = 0;
      int side = 1;
      while (!leftBank.isEmpty() || !rightBank.isEmpty()) {
        if (side == 1) {
            int usedLeft = 0;
            while (!leftBank.isEmpty() && l >= usedLeft + leftBank.peek()) {
              usedLeft += leftBank.poll();
            }
          side = 0;
          } else {
          int usedRight = 0;
          while (!rightBank.isEmpty() && l >= usedRight + rightBank.peek()) {
            usedRight += rightBank.poll();
          }
          side = 1;
        }
        cross++;
      }
      sc.println(cross);
    }
    sc.close();
  }
}
