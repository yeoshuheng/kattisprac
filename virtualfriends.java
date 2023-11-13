import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.HashSet;

public class virtualfriends {
  public static void main(String[] args) throws IOException {
    BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter pw = new PrintWriter(System.out);
    int n = Integer.parseInt(sc.readLine());
    for (int x = 0; x < n; x++) {
      int f = Integer.parseInt(sc.readLine());
      unionFind friendGraph = new unionFind();
      HashMap<String, Integer> friendNo = new HashMap<>();
      int c = 0;
      for (int y = 0; y < f; y++) {
        String[] ipt = sc.readLine().split(" ");
        String f1 = ipt[0]; String f2 = ipt[1];
        if (!friendNo.containsKey(f1)) {
          friendNo.put(f1, c);
          c++;
        }
        if (!friendNo.containsKey(f2)) {
          friendNo.put(f2, c);
          c++;
        }
        pw.println(friendGraph.union(friendNo.get(f1), friendNo.get(f2)));
      }
    }
    pw.close();
  }
}

class unionFind {

  HashMap<Integer, Integer> parents = new HashMap<>();
  HashMap<Integer, Long> size = new HashMap<>();
  HashMap<Integer, Long> rank = new HashMap<>();
  public unionFind(){}

  public int find(int x) {
    if (!parents.containsKey(x)) {
      size.put(x, (long) 1);
      parents.put(x, x);
      rank.put(x, (long) 0);
    }
    if (x == parents.get(x)) {
      return x;
    }
    int p = find(parents.get(x));
    parents.put(x, p);
    return p;
  }

  public long union(int a, int b) {
    int pa = find(a); int pb = find(b);
    if (pa == pb) {
      return size.get(pa);}
    if (rank.get(pa) > rank.get(pb)) {
      parents.put(pb, pa);
      size.put(pa, size.get(pa) + size.get(pb));
      return size.get(pa);
    } else if (rank.get(pa) < rank.get(pb)) {
      parents.put(pa, pb);
      size.put(pb, size.get(pa) + size.get(pb));
      return size.get(pb);
    } else {
      parents.put(pa, pb);
      size.put(pb, size.get(pa) + size.get(pb));
      rank.put(pb, rank.get(pb) + 1);
      return size.get(pb);
    }
  }
}
