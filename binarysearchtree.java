import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.TreeMap;

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

public class binarysearchtree {
  public static void main(String[] args) {
    FastIO sc = new FastIO();
    int n = sc.nextInt();
    //BST tree = new BST();
    TreeMap<Integer, Integer> tm = new TreeMap<>();
    long td = 0;
    while (n-- > 0) {
      int s = sc.nextInt();
      Integer floor = tm.floorKey(s); // Parent if insert on right.
      Integer ceil = tm.ceilingKey(s); // Parent if insert on left.
      int cdepth = 0;
      if (floor == null) { // No floor,
        if (ceil == null) {
          cdepth = 0; // Empty tree
        } else {
          cdepth = tm.get(ceil) + 1;
        }
      } else if (ceil == null) {
        cdepth = tm.get(floor) + 1;
      } else {
        cdepth = Math.max(tm.get(ceil), tm.get(floor)) + 1;
      }
      tm.put(s, cdepth);
      td += cdepth;
      sc.println(td);
    }

    sc.close();
  }
}


class BSTNode {
  int value;
  BSTNode left;
  BSTNode right;
  public BSTNode(int v) {
    this.value = v;
    this.left = null;
    this.right = null;
  }
}

class BST {
  BSTNode root;
  public int traversed;

  public BST() {
    root = null;
    traversed = 0;
  }

  public void insertInt(int v) {
    root = insert(v, root);
  }

  public BSTNode insert(int v, BSTNode curr) {
    if (curr == null) {
      BSTNode vv = new BSTNode(v);
      return vv;
    }
    traversed++;
    if (curr.value < v) {
      curr.left = insert(v, curr.left);
    } else {
      curr.right = insert(v, curr.right);
    }
    return curr;
  }
}
