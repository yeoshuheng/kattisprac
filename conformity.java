import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class conformity {
  public static void main(String[] args) throws IOException {
    BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter pw = new PrintWriter(System.out);
    int n = Integer.parseInt(sc.readLine());
    HashMap<String, Integer> pop = new HashMap<>();
    int mostPop = 1;
    for (int i = 0; i < n; i++) {
      String[] ipt = sc.readLine().split(" ");
      Arrays.sort(ipt);
      String k = Arrays.toString(ipt);
      if (!pop.containsKey(k)) {
        pop.put(k, 1);
        continue;
      }
      pop.put(k, pop.get(k) + 1);
      mostPop = Math.max(pop.get(k), mostPop);
    }
    int ret = 0;
    for (Map.Entry p : pop.entrySet()) {
      if (p.getValue().equals(mostPop)) {ret += pop.get(p.getKey());}
    }
    System.out.println(ret);
  }
}
