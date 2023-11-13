import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class reachableroads {
  public static void main(String[] args) throws IOException {
    BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter pw = new PrintWriter(System.out);
    int n = Integer.parseInt(sc.readLine());

    for (int j = 0; j < n; j++) {
      int m = Integer.parseInt(sc.readLine());
      int r = Integer.parseInt(sc.readLine());
      HashMap<Integer, HashSet<Integer>> graph = new HashMap<>();
      boolean[] seen = new boolean[m];
      for (int i = 0; i < m; i++) {
        graph.put(i, new HashSet<>());
        seen[i] = false;
      }
      for (int i = 0; i < r; i++) {
        String[] ipt = sc.readLine().split(" ");
        graph.get(Integer.parseInt(ipt[0])).add(Integer.parseInt(ipt[1]));
        graph.get(Integer.parseInt(ipt[1])).add(Integer.parseInt(ipt[0]));
      }
      int ret = 0;
      for (int i = 0; i < m; i++) {
        //System.out.println(Arrays.toString(seen));
        if (!seen[i]) {
          ret++;
          search(i, graph, seen);
        }
      }
      System.out.println(ret - 1);
    }
  }

  public static void search(int curr, HashMap<Integer, HashSet<Integer>> graph, boolean[] seen) {
    seen[curr] = true;
    for (int neigh : graph.get(curr)) {
      if (!seen[neigh]) {
        search(neigh, graph, seen);
      }
    }
  }
}
