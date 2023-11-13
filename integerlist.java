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

public class integerlist {
  public static void main(String[] args) {
    FastIO sc = new FastIO();
    int tc = sc.nextInt();
    for (int x = 0; x < tc; x++) {
      String p = sc.nextLine();
      int n = sc.nextInt();
      String st = sc.nextLine();
      String[] ls;
      if (n != 0) {
        String st1 = st.split("\\[")[1];
        String st2 = st1.split("]")[0];
        ls = st2.split(",");
      } else {
        ls = new String[0];
      }
      LinkedList<Integer> d = new LinkedList<>();
      for (int s = 0; s < ls.length; s++) {
        d.add(Integer.parseInt(ls[s]));
      }
      boolean reversed = false;
      boolean ok = true;
      outerloop: for (char itr : p.toCharArray()) {
        switch (itr) {
          case 'R':
            reversed = !reversed;
            break;
          case 'D':
            if (d.isEmpty()) {
              ok = false;
              break outerloop;
            }
            if (reversed) {
              d.removeLast();
            } else {
              d.removeFirst();
            }
        }
      }
      if (ok) {
        if (reversed) {
          Iterator<Integer> itt = d.iterator();
          Stack<Integer> stk = new Stack<>();
          while (itt.hasNext()) {
            stk.push(itt.next());
          }
          ArrayList<Integer> dr = new ArrayList<>();
          while (!stk.empty()) {
            dr.add(stk.pop());
          }
          sc.println(dr.toString().replaceAll(" ", ""));
        } else {
          sc.println(d.toString().replaceAll(" ", ""));
        }
      } else {
        sc.println("error");
      }
    }
    sc.close();
  }
}
