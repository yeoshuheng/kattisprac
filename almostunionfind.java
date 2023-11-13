import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class almostunionfind {
  public static void main(String[] args) throws IOException {
    Kattio sc = new Kattio(System.in, System.out);
    while (sc.hasMoreTokens()) {
      int n = sc.getInt();
      int m = sc.getInt();
      adaptedUF uf = new adaptedUF(n);
      for (int i = 0; i < m; i++) {
        int op = sc.getInt();
        if (op == 1) {
          int a = sc.getInt();
          int b = sc.getInt();
          uf.union(a, b);
        } else if (op == 2) {
          int a = sc.getInt();
          int b = sc.getInt();
          uf.move(a, b);
        } else if (op == 3) {
          int a = sc.getInt();
          System.out.println(uf.findSize(a) + " " + uf.findSum(a));
        }
      }
    }
    sc.close();
  }
}

class adaptedUF {
  int[] par;

  int[] adj;

  long[] sze;

  long[] sum_;
  public adaptedUF(int n) {
    par = new int[n + 1];
    sze = new long[n + 1];
    sum_ = new long[n + 1];
    adj = new int[n + 1]; // Tracks which node is above the other.
    for (int i = 1; i <= n; i++) {
      par[i] = i;
      sze[i] = 1;
      adj[i] = i;
      sum_[i] = i;
    }
  }
  public int find(int x) {
    int p = par[x];
    while (p != adj[p]) {
      p = adj[p];
    } // Iterate through the nodes above the current parent to find the final parent.
    par[x] = p;
    return p;
  }
  public void union(int a, int b) {
    int pa = find(a); int pb = find(b);
    if (pa == pb) {return;}
    // add a -> b.
    adj[pa] = pb; // Now successor node of parent of a is parent of b.
    par[a] = pb; // Now a & b share the same parent.
    sze[pb] += sze[pa];
    sum_[pb] += sum_[pa];
    sum_[pa] = 0; sze[pa] = 0; // Reset a.
  }

  public void move(int a, int b) {
    int pa = find(a); int pb = find(b);
    if (pa == pb) {return;}
    // move a -> b
    sze[pb] += 1;
    sum_[pb] += a;
    sze[pa] -= 1;
    sum_[pa] -= a;
    par[a] = pb;
    // Shift parent of b to be parent of a.
    // Next time a find() is called to a child of a, note that the adj array does not change,
    // hence it will still report the correct parent (old parent of a).
    // Whereas, if we call find() on a, it will return the parent of b.
    // Since adj[parent of b] == parent of b, the inner while loop in find terminates.
  }

  public long findSize(int x) {
    return sze[find(x)];
  }

  public long findSum(int x) {
    return sum_[find(x)];
  }
}
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