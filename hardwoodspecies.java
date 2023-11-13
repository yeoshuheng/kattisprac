import java.text.DecimalFormat;
import java.util.Map;
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
public class hardwoodspecies {
  public static void main(String[] args) {
    FastIO sc = new FastIO();
    TreeMap<String, Float> mp = new TreeMap<>();
    float count = 0;
    String ipt;
    while ((ipt = sc.nextLine()) != null) {
      mp.put(ipt, mp.getOrDefault(ipt, (float) 0) + 1);
      count++;
    }
    while (!mp.isEmpty()) {
      Map.Entry<String, Float> curr = mp.pollFirstEntry();
      sc.println(curr.getKey() + " " + 100 * (curr.getValue() / count));
    }
    sc.close();
  }
}
