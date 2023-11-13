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
public class majoritycard {
  public static void main(String[] args) {
    FastIO sc = new FastIO();
    majorityStack ms = new majorityStack();
    int n = sc.nextInt();
    while (n-- > 0) {
      String command = sc.next();
      //sc.println("running command: " + command);
      switch (command) {
        case "PUT_TOP":
          long x = sc.nextLong(); long y = sc.nextLong();
          ms.putTop(x, y);
          break;
        case "PUT_BOTTOM":
          x = sc.nextLong(); y = sc.nextLong();
          ms.putBottom(x, y);
          break;
        case "REMOVE_TOP":
          long z = sc.nextLong();
          ms.removeTop(z);
          break;
        case "REMOVE_BOTTOM":
          z = sc.nextLong();
          ms.removeBottom(z);
      }
      //sc.println(ms.pq);
      //sc.println(ms.count);
      sc.println(ms.getMajority());
    }
    sc.close();
  }
}

class card {
  long count;
  long value;

  public card (long c, long v) {
    count = c; value = v;
  }
}

class majorityStack {

  public static Deque<card> stk = new LinkedList<>();
  public static HashMap<Long, Long> count = new HashMap<>();

  public static TreeMap<Long, TreeSet<Long>> pq = new TreeMap<>();

  public long getMajority() {
    return pq.lastEntry().getValue().first();
  }

  public void removeTop(long z) {
    while (z > 0 && !stk.isEmpty()) {
      card currCard = stk.pollFirst();

      //System.out.println("removing " + currCard.count + " number of " + currCard.value);
      // get local diff
      long subtracted = Math.min(currCard.count, z);
      if (subtracted != currCard.count) { // local card not completely removed.
        currCard.count -= subtracted; // add back to queue.
        stk.addFirst(currCard);
      }

      // update global states
      long initialcount = count.get(currCard.value);
      long newCount = initialcount - subtracted;
      pq.get(initialcount).remove(currCard.value);
      if (pq.get(initialcount).isEmpty()) {pq.remove(initialcount);}

      // update count
      if (newCount == 0) {
        count.remove(currCard.value);
      } else {
        count.put(currCard.value, newCount);
        if (!pq.containsKey(newCount)) {pq.put(newCount, new TreeSet<>());}
        pq.get(newCount).add(currCard.value);
      }
      z -= subtracted;
    }
  }

  public void removeBottom(long z) {
    while (z > 0 && !stk.isEmpty()) {
      card currCard = stk.pollLast();

      // get local diff
      long subtracted = Math.min(currCard.count, z);
      if (subtracted != currCard.count) { // local card not completely removed.
        currCard.count -= subtracted; // add back to queue.
        stk.addLast(currCard);
      }

      // update global states
      long initialcount = count.get(currCard.value);
      long newCount = initialcount - subtracted;
      pq.get(initialcount).remove(currCard.value);
      if (pq.get(initialcount).isEmpty()) {pq.remove(initialcount);}

      // update count
      if (newCount == 0) {
        count.remove(currCard.value);
      } else {
        count.put(currCard.value, newCount);
        if (!pq.containsKey(newCount)) {pq.put(newCount, new TreeSet<>());}
        pq.get(newCount).add(currCard.value);
      }
      z -= subtracted;
    }
  }

  public void putTop (long x, long y) {
    card newcard = new card(x, y);
    stk.addFirst(newcard);

    // remove old entry from PQ
    Long currCount = count.get(y);
    if (currCount != null) {
      pq.get(currCount).remove(y);
      if (pq.get(currCount).isEmpty()) {pq.remove(currCount);}
    }

    // update count
    long newCount = count.getOrDefault(y, (long) 0) + x;
    count.put(y, newCount);

    // update PQ
    if (!pq.containsKey(newCount)) {pq.put(newCount, new TreeSet<>());}
    pq.get(newCount).add(y);
  }

  public void putBottom (long x, long y) {
    card newcard = new card(x, y);
    stk.addLast(newcard);

    // remove old entry from PQ
    Long currCount = count.get(y);
    if (currCount != null) {
      pq.get(currCount).remove(y);
      if (pq.get(currCount).isEmpty()) {pq.remove(currCount);}
    }

    // update count
    long newCount = count.getOrDefault(y, (long) 0) + x;
    count.put(y, newCount);

    // update PQ
    if (!pq.containsKey(newCount)) {pq.put(newCount, new TreeSet<>());}
    pq.get(newCount).add(y);
  }

}

