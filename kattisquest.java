import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.TreeMap;
import java.util.PriorityQueue;

public class kattisquest {
  public static void main(String[] args) throws IOException {
    BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter pw = new PrintWriter(System.out);
    int n = Integer.parseInt(sc.readLine());
    TreeMap<Long, PriorityQueue<Long>> questMap = new TreeMap<>();
    for (int i = 0; i < n; i++) {
      String[] ipt = sc.readLine().split(" ");
      if (ipt[0].equals("add")) {
        long e = Long.parseLong(ipt[1]);
        long g = Long.parseLong(ipt[2]);
        if (!questMap.containsKey(e)) {
          questMap.put(e, new PriorityQueue<>());
        }
        questMap.get(e).add(-1 * g);
      } else {
        long x = Long.parseLong(ipt[1]);
        long earned = 0;
        while (questMap.floorKey(x) != null && x > 0) {
          long lower_ = questMap.floorKey(x);
          Long earned_to_add = (questMap.get(lower_).poll() * -1);
          if (earned_to_add == null) {questMap.remove(lower_); continue;}
          earned += earned_to_add;
          if (questMap.get(lower_).isEmpty()) {questMap.remove(lower_);}
          x -= lower_;
        }
        System.out.println(earned);
      }
    }
  }
}
