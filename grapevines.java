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

public class grapevines {
  public static void main(String[] args) {
    FastIO sc = new FastIO();
    int n = sc.nextInt(); int m = sc.nextInt(); int d = sc.nextInt();

    // Build Adjacency Map
    HashMap<Integer, ArrayList<Integer>> adjMap = new HashMap<>();
    HashMap<String, Integer> nameMap = new HashMap<>();
    HashMap<Integer, HashSet<Integer>> heard = new HashMap<>();
    HashMap<Integer, Integer> skepLevel = new HashMap<>();

    for (int i = 0; i < n; i++) {
      String s = sc.next(); int t = sc.nextInt();
      nameMap.put(s, i);
      adjMap.put(i, new ArrayList<>());
      heard.put(i, new HashSet<>());
      skepLevel.put(i, t);
    }
    while (m-- > 0) {
      String a = sc.next(); String b = sc.next();
      int an = nameMap.get(a); int bn = nameMap.get(b);
      adjMap.get(an).add(bn);
      adjMap.get(bn).add(an);
    }
    HashSet<Integer> visited = new HashSet<>();
    String origin = sc.next();
    int start = nameMap.get(origin);

    Deque<Integer[]> states = new LinkedList<>();

    states.add(new Integer[]{start, 0});
    visited.add(start);

    while (!states.isEmpty()) {
      Integer[] cState = states.pollFirst();
      int person = cState[0]; int currday = cState[1];
      if (currday == d) {continue;}
      for (int neigh : adjMap.get(person)) {
        heard.get(neigh).add(person);
        // we add first, if he is in visited,
        // he alr exists in state, we will visit him if requirements met.
        if (visited.contains(neigh)) {continue;}
        if (heard.get(neigh).size() >= skepLevel.get(neigh)) {
          visited.add(neigh);
          states.addLast(new Integer[]{neigh, currday + 1});
        }
      }
    }
    sc.println(visited.size() - 1);
    sc.close();
  }
}
