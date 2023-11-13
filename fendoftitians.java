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
public class fendoftitians {

  public static HashMap<Long, ArrayList<Long[]>> adjMap;

  public static HashSet<Long> seen = new HashSet<>();
  public static long[][] bestStates;

  public static void main(String[] args) {
    FastIO sc = new FastIO();
    int n = sc.nextInt();
    int m = sc.nextInt(); int x = sc.nextInt(); int y = sc.nextInt();
    adjMap = new HashMap<>();
    for (long i = 1; i <= n; i++) {
        adjMap.put(i, new ArrayList<>());
    }
    while (m-- > 0) {
      long a = sc.nextLong(); long b = sc.nextLong();
      long weight = sc.nextLong(); long present = sc.nextLong();
      adjMap.get(a).add(new Long[]{b, weight, present});
      adjMap.get(b).add(new Long[]{a, weight, present});
    }
    bestStates = new long[n + 1][3];
    for (int i = 1; i <= n; i++) {
      for (int j = 0; j < 3; j++) {
        bestStates[i][j] = Long.MAX_VALUE;
      }
    }
    Comparator<Long[]> cp = new Comparator<Long[]>() {
      @Override
      public int compare(Long[] o1, Long[] o2) {
        if (o1[3] == o2[3]) {
          if (o1[2] == o2[2]) {
            return o1[1] > o2[1] ? 1 : -1;
          }
          return o1[2] > o2[2] ? 1 : -1;
        }
        return o1[3] > o2[3] ? 1 : -1;
      }
    };
    PriorityQueue<Long[]> states = new PriorityQueue<>(cp);
    states.add(new Long[]{(long) x, (long) 0, (long) 0, (long) 0});
    bestStates[x] = new long[]{0, 0, 0};
    while (seen.size() != n) {
      if (states.isEmpty()) {
        break;
      }
      Long[] nextVisit = states.poll();
      Long cNode = nextVisit[0];
      long cCost = nextVisit[1];
      long cShamans = nextVisit[2];
      long cTitans = nextVisit[3];
      seen.add(cNode);
      for (Long[] neighbor : adjMap.get(cNode)) {
        long nNode = neighbor[0];
        if (seen.contains(nNode)) {
          continue;
        }
        long nCost = cCost + neighbor[1];
        long nShamans = cShamans;
        long nTitans = cTitans;
        if (neighbor[2] == 1) {
          nShamans++;
        } else if (neighbor[2] == 2) {
          nTitans++;
        }
        long[] bestStateN = bestStates[(int) nNode];
        boolean proceed = true;
        if (nTitans > bestStateN[2]) {
          proceed = false;
        } else if (nTitans == bestStateN[2]) {
          if (nShamans > bestStateN[1]) {
            proceed = false;
          } else if (nShamans == bestStateN[1]) {
            if (nCost >= bestStateN[0]) {
              proceed = false;
            }
          }
        }
        if (proceed) {
          bestStates[(int) nNode] = new long[]{nCost, nShamans, nTitans};
          states.offer(new Long[]{nNode, nCost, nShamans, nTitans});
        }
      }
    }

    long[] ret = bestStates[y];
    if (ret[0] == Long.MAX_VALUE && ret[1] == Long.MAX_VALUE && ret[2] == Long.MAX_VALUE) {
      sc.println("IMPOSSIBLE");
    } else {
      sc.println(ret[0] + " " + ret[1] + " " + ret[2]);
    }
    sc.close();
  }
}
