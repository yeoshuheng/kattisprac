import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class swaptosort {
  public static void main(String[] args) throws IOException {
    BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
    String[] ipt = sc.readLine().split(" ");
    int n = Integer.parseInt(ipt[0]);
    int k = Integer.parseInt(ipt[1]);
    unionfind ufds = new unionfind();
    Integer[][] swapsNeeded = new Integer[n][2];
    for (int n_ = 0; n_ < n; n_++) {
      Integer[] curr = new Integer[]{n_, n - n_ - 1};
      swapsNeeded[n_] = curr;
    }
    for (int n_ = 0; n_ < n; n_++) {
      unionfind.parent.put(n_, n_);
    }

    Integer[][] possMoves = new Integer[k][2];
    for (int k_ = 0; k_ < k; k_++) {
      ipt = sc.readLine().split(" ");
      int a = Integer.parseInt(ipt[0]) - 1;
      int b = Integer.parseInt(ipt[1]) - 1;
      unionfind.union(a, b);
    }

    boolean poss = true;
    for (Integer[] swaps : swapsNeeded) {
     if (unionfind.find(swaps[0]) != unionfind.find(swaps[1])) {
       poss = false;
       break;
     }
    }
    if (poss) {
      System.out.println("Yes");
    } else {
      System.out.println("No");
    }
  }
}

class unionfind {

  static HashMap<Integer, Integer> parent = new HashMap<>();

  static int find(int i) {
    if (parent.get(i) == i) {
      return i;
    }
    int pr = find(parent.get(i));
    parent.put(i, pr);
    return pr;
  }

  static void union(int i, int j) {
    int x = find(i); int y = find(j);
    if (x == y) {return;}
    parent.put(x, y);
  }
}
