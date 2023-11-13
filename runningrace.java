import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class runningrace {
  public static void main(String[] args) throws IOException {
    BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
    String[] ipt = sc.readLine().split(" ");
    int l = Integer.parseInt(ipt[0]); int k = Integer.parseInt(ipt[1]);
    int s = Integer.parseInt(ipt[2]);
    HashMap<Integer, ArrayList<Long>> map = new HashMap<>();
    for (int l_ = 0; l_ < l; l_++) {
      ipt = sc.readLine().split(" ");
      int i = Integer.parseInt(ipt[0]);
      if (!map.containsKey(i)) {
        map.put(i, new ArrayList<>());
      }
      String[] split_ = ipt[1].split("\\.");
      map.get(i).add(Long.parseLong(split_[0]) * 60  + Long.parseLong(split_[1]));
    }

    ArrayList<Long[]> runners = new ArrayList<>();

    for (long idx : map.keySet()) {
      ArrayList<Long> timings = map.get((int) idx);
      if (timings.size() != k) {
        continue;
      }
      long finaltime = 0;
      for (Long timing : timings) {
        finaltime += timing;
      }
      runners.add(new Long[]{idx, finaltime});
    }
    runners.sort(new Comparator<Long[]>() {
      @Override
      public int compare(Long[] o1, Long[] o2) {
        if (o1[1].equals(o2[1])) {
          return o1[0] > o2[0] ? 1 : -1;
        }
        return o1[1] > o2[1] ? 1 : -1;
      }
    });

    StringBuilder sb = new StringBuilder();
    for (Long[] a : runners) {
      sb.append(a[0] + "\n");
    }
    System.out.println(sb);
  }
}
