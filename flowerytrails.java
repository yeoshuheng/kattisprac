import java.lang.reflect.Array;
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
    while (st == null || !st.hasMoreElements()) {
      try {
        st = new StringTokenizer(br.readLine());
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    return st.nextToken();
  }

  int nextInt() {
    return Integer.parseInt(next());
  }

  long nextLong() {
    return Long.parseLong(next());
  }

  double nextDouble() {
    return Double.parseDouble(next());
  }

  String nextLine() {
    String str = "";
    try {
      str = br.readLine();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return str;
  }
}

public class flowerytrails {
  public static HashMap<Integer, ArrayList<Integer[]>> adj;

  public static int[][] adjMat;

  public static int[] best;

  public static HashMap<Integer, HashSet<Integer>> parents = new HashMap<>();

  public static void main(String[] args) {
    FastIO sc = new FastIO();
    int p = sc.nextInt(); int t = sc.nextInt();
    best = new int[p];
    adj = new HashMap<>();
    adjMat = new int[p][p];
    for (int i = 0; i < p; i++) {
      adj.put(i, new ArrayList<>());
      best[i] = Integer.MAX_VALUE;
      parents.put(i, new HashSet<>());
      int[] n = new int[p]; Arrays.fill(n, 0);
      adjMat[i] = n;
    }
    while (t-- > 0) {
      int p1 = sc.nextInt(); int p2 = sc.nextInt(); int l = sc.nextInt();
      adj.get(p1).add(new Integer[]{p2, l});
      adj.get(p2).add(new Integer[]{p1, l});
      if (adjMat[p1][p2] == 0) {
        adjMat[p1][p2] += l;
        adjMat[p2][p1] += l;} else if (adjMat[p1][p2] == l) {
        adjMat[p1][p2] += l;
      } else if (adjMat[p1][p2] > l) {adjMat[p1][p2] = l;}
    }
    PriorityQueue<Integer[]> states = new PriorityQueue<>(new Comparator<Integer[]>() {
      @Override
      public int compare(Integer[] o1, Integer[] o2) {
        return o1[1] > o2[1] ? 1 : -1;
      }
    });
    states.offer(new Integer[]{0, 0});
    //seen.add(0);
    best[0] = 0;
    while (!states.isEmpty()) {
      Integer[] curr = states.poll();
      int currNode = curr[0]; int length = curr[1];
      for (Integer[] nstate : adj.get(currNode)) {
        int neigh = nstate[0]; int nxtlen = nstate[1];
        if (length + nxtlen < best[neigh]) {
          states.add(new Integer[]{neigh, length + nxtlen});
          best[neigh] = length + nxtlen;
          parents.get(neigh).clear();
          parents.get(neigh).add(currNode);
        }
        if (length + nxtlen == best[neigh]) {parents.get(neigh).add(currNode);}
      }
    }
    //sc.println(Arrays.toString(best));
    Deque<Integer> pathtaken = new LinkedList<>();
    HashSet<Integer> visited = new HashSet<>();
    int total = 0;
    pathtaken.add(p - 1);
    while (!pathtaken.isEmpty()) {
      int curr = pathtaken.pollLast();
      if (visited.contains(curr)) {continue;}
      visited.add(curr);
      for (Integer tt : parents.get(curr)) {
        //System.out.println(curr + " is a parent of " + tt);
        //System.out.println(tt[0] +  " -> " + curr + " w: " + adjMat[tt[0]][curr]);
        total += adjMat[tt][curr];
        //System.out.println("the dist is " + adjMat[tt][curr]);
        pathtaken.addLast(tt);
      }
    }
    sc.println(total * 2);
    sc.close();
  }
}
