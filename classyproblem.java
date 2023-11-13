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

class Person {
  String name;
  long val;
  public Person(String s, String v) {
    name = s; val = Long.parseLong(v);
  }
}
public class classyproblem {

  public static HashMap<String, String> classMap = new HashMap<>();

  public static void main(String[] args) {
    classMap.put("upper", "3");
    classMap.put("middle", "2");
    classMap.put("lower", "1");
    FastIO sc = new FastIO();
    int t = sc.nextInt();
    while (t-- > 0) {
      int n = sc.nextInt();
      int maxPos = 0;
      HashMap<String, String[]> sToC = new HashMap<>();
      for (int i = 0; i < n; i++) {
        String[] ipt = sc.nextLine().split(":");
        String name = ipt[0];
        String[] cl = ipt[1].split(" ")[1].split("-");
        //System.out.println(Arrays.toString(cl));
        maxPos = Math.max(maxPos, cl.length);
        sToC.put(name, cl);
      }
      ArrayList<Person> vals = new ArrayList<>();
      for (Map.Entry<String, String[]> m : sToC.entrySet()) {
        String name = m.getKey();
        int mm = maxPos;
        StringBuilder val = new StringBuilder();
        String[] mmm = m.getValue();
        for (int cn = mmm.length - 1; cn > -1; cn--) {
          String cll = mmm[cn];
          val.append(classMap.get(cll));
          mm--;
        }
        while (mm-- > 0) {
          val.append("2");
        }
        String fin = val.toString();
        Person curr = new Person(name, fin);
        vals.add(curr);
      }
      vals.sort(new Comparator<Person>() {
        @Override
        public int compare(Person o1, Person o2) {
          if (o1.val == o2.val) {
            return o1.name.compareTo(o2.name);
          }
          return o1.val < o2.val ? 1 : -1;
        }
      });
      StringBuilder sb = new StringBuilder();
      for (Person pp : vals) {
        sc.println(pp.name);
      }
      for (int x = 0; x < 30; x++) {
        sb.append("=");
      }
      sc.println(sb);
    }
    sc.close();
  }

}
