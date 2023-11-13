import java.lang.reflect.Array;
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
public class teque {
  public static void main(String[] args) {
    FastIO sc = new FastIO();
    int start = 0;
    int end = 0;
    int middle = 0;
    int n = sc.nextInt();
    Tq tq = new Tq();
    while (n-- > 0) {
      String[] ipt = sc.nextLine().split(" ");
      int x = Integer.parseInt(ipt[1]);
      switch (ipt[0]) {
        case "push_front":
          tq.addFirst(x);
          break;
        case "push_back":
          tq.addLast(x);
          break;
        case "push_middle":
          tq.pushMiddle(x);
          break;
        case "get":
          sc.println(tq.get(x));
          break;
        }
      //System.out.println("executed: " + ipt[0] + " " + ipt[1]);
      //tq.printState();
    }
    sc.close();
  }
}

class Tq {
  public HashMap<Integer, Integer> front = new HashMap<>();
  public HashMap<Integer, Integer> back = new HashMap<>();
  public int frontstrt = 0;
  public int frontend = 1;
  public int backstrt = 0;
  public int backend = 1;

  public void addFirst(int x) {
    front.put(frontstrt, x);
    frontstrt--;
    rebalance();
  }

  public void addLast(int x) {
    back.put(backend, x);
    backend++;
    rebalance();
  }

  public void pushMiddle(int x) {
    front.put(frontend, x);
    frontend++;
    rebalance();
  }

  public int get(int idx) {
    int frontNo = front.size();
    if (idx > frontNo - 1) {
      idx -= frontNo;
      return back.get(backstrt + 1 + idx);
    } else {
      return front.get(frontstrt + 1 + idx);
    }
  }
  public void rebalance() {
    if (back.size() > front.size()) {
      backstrt++;
      int curr = back.remove(backstrt);
      front.put(frontend, curr);
      frontend++;
    }
    if (front.size() > back.size() + 1) {
      frontend--;
      int curr = front.remove(frontend);
      back.put(backstrt, curr);
      backstrt--;
    }
  }

  public void printState() {
    System.out.println("print front");
    System.out.println("front start: " + frontstrt + " front end: " + frontend );
    for (Map.Entry<Integer, Integer> e : front.entrySet()) {
      System.out.println(e.getKey() + " : " + e.getValue());
    }

    System.out.println("print back");
    System.out.println("back start: " + backstrt + " back end: " + backend );
    for (Map.Entry<Integer, Integer> e : back.entrySet()) {
      System.out.println(e.getKey() + " : " + e.getValue());
    }
  }

}
