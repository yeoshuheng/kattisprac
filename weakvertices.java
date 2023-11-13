import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class weakvertices {
  public static void main(String[] args) throws IOException {
    BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter pw = new PrintWriter(System.out);
    while (true) {
      int n = Integer.parseInt(sc.readLine());
      if (n == -1) {break;}
      HashMap<Integer, HashSet<Integer>> adjMap = new HashMap<>();
      for (int i = 0; i < n; i++) {
        adjMap.put(i, new HashSet<>());
      }
      for (int i = 0; i < n; i++) {
        String[] ipt = sc.readLine().split(" ");
        for (int j = 0; j < ipt.length; j++) {
          if (ipt[j].equals("0")) {
            continue;
          }
          int col = Integer.parseInt(ipt[j]);
          adjMap.get(j).add(i);
          adjMap.get(i).add(j);
        }
      }
      ArrayList<Integer> weak = new ArrayList<>();
      for (int curr : adjMap.keySet()) {
        HashSet<Integer> curr_neighbours = adjMap.get(curr);
        boolean seen = false;
        outerloop:
        for (int neighbour : curr_neighbours) {
          for (int other_n : curr_neighbours) {
            if (adjMap.get(other_n).contains(neighbour)) {
              seen = true;
              break;
            }
          }
        }
        if (!seen) {
          weak.add(curr);
        }
      }
      StringBuilder sb = new StringBuilder();
      for (Integer wk : weak) {
        sb.append(wk + " ");
      }
      pw.println(sb);
    }
    pw.close();
  }
}
