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

class contestant {
  int id;
  long prob;
  long penalty;
  long t;
  long xtra;
  public contestant(int id_, long p, long pe, long t_, long x) {
    id = id_;
    prob = p;
    penalty = pe;
    t = t_;
    xtra = x;
  }

}
public class includescoring {

  public static int[] rankScore;

  public static int ceilDiv(int x, int y) {
    return Math.floorDiv(x, y) + (x % y == 0 ? 0 : 1);
  }

  public static void main(String[] args) {
    rankScore = new int[31];
    int max = 100;
    for (int i = 1; i <= 30; i++) {
      rankScore[i] = max;
      if (i == 1) {max -= 25;}
      if (i == 2) {max -= 15;}
      if (i == 3) {max -= 10;}
      if (i >= 4 && i < 6) {max -= 5;}
      if (i >= 6 && i < 8) {max -= 4;}
      if (i >= 8 && i < 10) {max -= 3;}
      if (i >= 10 && i < 15) {max -= 2;}
      if (i >= 15) {max -=1;}
    }
    FastIO sc = new FastIO();
    int n = sc.nextInt();
    HashMap<Integer, Integer> score = new HashMap<>();
    TreeMap<Long, TreeMap<Long, TreeMap<Long, HashSet<contestant>>>> pq = new TreeMap<>(Collections.reverseOrder());
    for (int i = 0; i < n; i++) {
      long a = sc.nextLong(); long b = sc.nextLong(); long c = sc.nextLong(); long d = sc.nextLong();
      contestant curr = new contestant(i, a, b, c, d);
      score.put(i, (int) d);
      if (!pq.containsKey(a)) {pq.put(a, new TreeMap<>());}
      TreeMap<Long, TreeMap<Long, HashSet<contestant>>> tmp = pq.get(a);
      if (!tmp.containsKey(b)) {tmp.put(b, new TreeMap<>());}
      TreeMap<Long, HashSet<contestant>> tmp2 = tmp.get(b);
      if (!tmp2.containsKey(c)) {tmp2.put(c, new HashSet<>());}
      tmp2.get(c).add(curr);
    }
    int crank = 1;
    mainloop: while (!pq.isEmpty()) {
      TreeMap<Long, TreeMap<Long, HashSet<contestant>>> byComplete = pq.pollFirstEntry().getValue();
      while (!byComplete.isEmpty()) {
        TreeMap<Long, HashSet<contestant>> byPenalty = byComplete.pollFirstEntry().getValue();
        while (!byPenalty.isEmpty()) {
          HashSet<contestant> currRank = byPenalty.pollFirstEntry().getValue();
          int average = 0;
          for (contestant c : currRank) {
            if (crank > 30) {
              continue;
            }
            average += rankScore[crank];
            crank++;
          }
          int tscore = ceilDiv(average, currRank.size());
          for (contestant c : currRank) {
            //System.out.println("id: " + c.id + " probsolved: " + c.prob + " penalty: " + c.penalty + " time: " + c.t);
            score.put(c.id, score.get(c.id) + tscore);
            //System.out.println("score: " + tscore);
          }
          if (crank > 30) {break;}
        }
      }
    }
    for (int i = 0; i < n; i++) {
      sc.println(score.get(i));
    }
    sc.close();
  }
}
