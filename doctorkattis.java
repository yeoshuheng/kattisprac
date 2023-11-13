import javax.naming.Name;
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

class cat {
  public String name;
  public int inf;
  public cat(String s, int iff) {
    inf = iff;
    name = s;
  }
}

public class doctorkattis {
  public static void main(String[] args) {
    FastIO sc = new FastIO();
    HashMap<String, Integer[]> catToInfLevel = new HashMap<>();
    TreeMap<Integer, TreeMap<Integer, String>> pq = new TreeMap<>(Collections.reverseOrder());
    int n = sc.nextInt();
    int arrived = 0;
    while (n-- > 0) {
      int type = sc.nextInt();
      switch (type) {
        case 0:
          String name = sc.next(); int inf = sc.nextInt();
          catToInfLevel.put(name, new Integer[]{arrived, inf});
          if (!pq.containsKey(inf)) {
            pq.put(inf, new TreeMap<>());
          }
          pq.get(inf).put(arrived, name);
          arrived++;
          break;
        case 1:
          name = sc.next();
          int incr = sc.nextInt();
          Integer[] catDetails = catToInfLevel.get(name);
          int currinf = catDetails[1];
          int catidx = catDetails[0];
          int newInf = Math.min(100, incr + currinf);
          catToInfLevel.get(name)[1] = newInf;
          TreeMap<Integer, String> tmp = pq.get(currinf);
          tmp.remove(catidx);
          if (!pq.containsKey(newInf)) {
            pq.put(newInf, new TreeMap<>());
          }
          pq.get(newInf).put(catidx, name);
          break;
        case 2:
          name = sc.next();
          catDetails = catToInfLevel.get(name);
          catToInfLevel.remove(name);
          currinf = catDetails[1];
          catidx = catDetails[0];
          tmp = pq.get(currinf);
          tmp.remove(catidx);
          break;
        case 3:
          if (catToInfLevel.isEmpty()) {
            sc.println("The clinic is empty");
            break;
          }
          Map.Entry<Integer, TreeMap<Integer, String>> temp = pq.firstEntry();
          while (temp.getValue().isEmpty()) {
            pq.remove(temp.getKey());
            temp = pq.firstEntry();
          }
          sc.println(temp.getValue().firstEntry().getValue());
          break;
      }
    }
    sc.close();
  }
}
