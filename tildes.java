import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;

public class tildes {
  public static void main(String[] args) throws IOException {
    BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
    String[] ipt = sc.readLine().split(" ");
    PrintWriter wr = new PrintWriter(System.out);
    int n = Integer.parseInt(ipt[0]); int q = Integer.parseInt(ipt[1]);
    uf unionfind = new uf(n);
    for (int i = 0; i < q; i++) {
      ipt = sc.readLine().split(" ");
      if (ipt[0].equals("t")) {
        int ga = Integer.parseInt(ipt[1]); int gb = Integer.parseInt(ipt[2]);
        unionfind.union(ga, gb);
      } else {
        int ga = Integer.parseInt(ipt[1]);
        wr.println(unionfind.getSize(ga));
      }
    }
    wr.close();
  }
}

class uf {

  public HashMap<Integer, Integer>  parents;
  public int[] size;
  public int[] rank;
  uf (int n) {
    parents = new HashMap<>();
    size = new int[n + 1];
    rank = new int[n + 1];
    for (int i = 1; i <= n; i++) {
      parents.put(i, i);
      size[i] = 1;
      rank[i] = 0;
    }
  }
  public int find(int x) {
    if (parents.get(x) == x) {return x;}
    int p = find(parents.get(x));
    parents.put(x, p);
    return p;
  }

  public int getSize(int x) {
    return size[find(x)];
  }

  public void union(int a, int b) {
    int p_a = find(a); int p_b = find(b);
    if (p_a == p_b) {return;}
    if (rank[p_a] > rank[p_b]) {
      parents.put(p_b, p_a);
      size[p_a] += size[p_b];
    } else if (rank[p_b] > rank[p_a]) {
      parents.put(p_a, p_b);
      size[p_b] += size[p_a];
    } else {
      parents.put(p_b, p_a);
      size[p_a] += size[p_b];
      rank[p_a]++;
    }
  }
}