import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class annoyed {
  public static void main(String[] args) throws IOException {
    BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter pw = new PrintWriter(System.out);
    String[] ipt = sc.readLine().split(" ");
    long h = Integer.parseInt(ipt[0]); long c = Integer.parseInt(ipt[1]);
    long maxAnnoy = Integer.MIN_VALUE;
    HashMap<Long, Long> annoyIncrease = new HashMap<>();
    PriorityQueue<Long[]> pq = new PriorityQueue<>(new Comparator<Long[]>() {
      @Override
      public int compare(Long[] o1, Long[] o2) {
        if (o1[1] == o2[1]) {
          return annoyIncrease.get(o1[0]) > annoyIncrease.get(o2[0]) ? 1 : -1;
        }
        return o1[1] > o2[1] ? 1 : -1;
      }
    });
    for (int i = 0; i < c; i++) {
      ipt  = sc.readLine().split(" ");
      Long a = Long.parseLong(ipt[0]); Long d = Long.parseLong(ipt[1]);
      pq.add(new Long[]{(long) i, a + d});
      annoyIncrease.put((long) i, d);
      maxAnnoy = Math.max(maxAnnoy, a);
    }
    while (h > 0) {
      //System.out.println("PQ State");
      //printPQ(pq);
      Long[] cw = pq.poll();
      //System.out.println("Picking: " + cw[0]);
      maxAnnoy = Math.max(cw[1], maxAnnoy);
      //System.out.println("Current Annoy: " + maxAnnoy);
      cw[1] += annoyIncrease.get(cw[0]);
      pq.offer(cw);
      h--;
    }
    pw.println(maxAnnoy);
    pw.close();
  }

  public static void printPQ(PriorityQueue<Integer[]> pq) {
    for (Integer[] c : pq) {
      System.out.println(Arrays.toString(c));
    }
  }
}
