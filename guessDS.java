import java.util.*;
import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.OutputStream;

class Kattio extends PrintWriter {
  public Kattio(InputStream i) {
    super(new BufferedOutputStream(System.out));
    r = new BufferedReader(new InputStreamReader(i));
  }
  public Kattio(InputStream i, OutputStream o) {
    super(new BufferedOutputStream(o));
    r = new BufferedReader(new InputStreamReader(i));
  }

  public boolean hasMoreTokens() {
    return peekToken() != null;
  }

  public int getInt() {
    return Integer.parseInt(nextToken());
  }

  public double getDouble() {
    return Double.parseDouble(nextToken());
  }

  public long getLong() {
    return Long.parseLong(nextToken());
  }

  public String getWord() {
    return nextToken();
  }



  private BufferedReader r;
  private String line;
  private StringTokenizer st;
  private String token;

  private String peekToken() {
    if (token == null)
      try {
        while (st == null || !st.hasMoreTokens()) {
          line = r.readLine();
          if (line == null) return null;
          st = new StringTokenizer(line);
        }
        token = st.nextToken();
      } catch (IOException e) { }
    return token;
  }

  private String nextToken() {
    String ans = peekToken();
    token = null;
    return ans;
  }
}
public class guessDS {
  public static void main(String[] args) {
    Kattio sc = new Kattio(System.in);
    while (sc.hasMoreTokens()) {
      int n = sc.getInt();
      Stack<Integer> stk = new Stack<>();
      PriorityQueue<Integer> pq = new PriorityQueue<>();
      Queue<Integer> q = new LinkedList<>();

      boolean[] possible = new boolean[3];
      for (int i = 0; i < 3; i++) {
        possible[i] = true;
      }

      while (n-- > 0) {
        int a = sc.getInt(); int b = sc.getInt();
        if (a == 1) {
          stk.push(b);
          pq.offer(-1 * b);
          q.add(b);
        } else  {
          if (stk.isEmpty() || stk.pop() != b) {
            possible[0] = false;
          }
          if (pq.isEmpty() || pq.poll() != -1 * b) {
            possible[1] = false;
          }
          if (q.isEmpty() || q.poll() != b) {
            possible[2] = false;
          }
        }
      }
      if (possible[0] && !possible[1] && !possible[2]) {
        sc.println("stack");
      } else if (possible[1] && !possible[0] && !possible[2]) {
        sc.println("priority queue");
      } else if (possible[2] && !possible[0] && !possible[1]) {
        sc.println("queue");
      } else if (!possible[0] && !possible[1] && !possible[2]) {
        sc.println("impossible");
      } else {sc.println("not sure");}
    }
    sc.close();
  }
}
