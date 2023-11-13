import java.io.*;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.util.PriorityQueue;

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

public class ballotbox {
  public static void main(String[] args) {
    Kattio sc = new Kattio(System.in);
    while (true) {
      long n = sc.getLong(); long b = sc.getLong();
      if (n == -1 && b == -1) {
        break;
      };
      PriorityQueue<Long[]> pq = new PriorityQueue<>(new Comparator<Long[]>() {
        @Override
        public int compare(Long[] o1, Long[] o2) {
          double o1perbox = Math.ceil(o1[0] / (double) o1[1]);
          double o2perbox = Math.ceil(o2[0] / (double) o2[1]);
          return o1perbox > o2perbox ? -1 : 1;
        }
      });

      for (long i = 0; i < n; i++) {
        long pop = sc.getLong();
        pq.add(new Long[]{pop, (long) 1});
      }
      b -= n;
      while (b-- > 0) {
        //System.out.println("getting dist");
        //for(City c : pq) {System.out.println(getDist(c));}
        Long[] curr = pq.poll();
        curr[1]++;
        pq.add(curr);
      }
      Long[] fin = pq.peek();
      sc.println((fin[0] + fin[1] - 1) / fin[1]);
    }
    sc.close();
  }
}
