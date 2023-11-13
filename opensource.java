import javax.swing.plaf.synth.SynthUI;
import java.io.*;
import java.util.*;

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
public class opensource {
  public static void main(String[] args) {
    FastIO sc = new FastIO();
    ArrayList<String> arr = new ArrayList<>();
    while (true) {
      String ipt = sc.nextLine();
      if (ipt.equals("1")) {
        String cproj = null;
        uf unionfind = new uf();
        for (String curr : arr) {
          if (Character.isUpperCase(curr.charAt(0))) {
            cproj = curr;
            unionfind.parent.put(cproj, cproj);
            unionfind.size.put(cproj, new project(curr, 0));
            continue;
          }
          unionfind.union(cproj, curr);
        }
        ArrayList<project> parents = new ArrayList<project>();
        for (project c : unionfind.size.values()) {
          parents.add(c);
        }
        parents.sort(new Comparator<project>() {
          @Override
          public int compare(project o1, project o2) {
            if (o1.psize == o2.psize) {
              return o1.name.compareTo(o2.name);
            }
            return o1.psize < o2.psize ? 1 : -1;
          }
        });
        for (project p : parents) {
          sc.println(p.name + " " + p.psize);
        }
        arr = new ArrayList<>();
      } else if (ipt.equals("0")) {
        break;
      }
      else {
        arr.add(ipt);
      }
    }
    sc.close();
  }
}

class project {
  public long psize;
  public String name;
  public project(String n, long s) {
    psize = s;
    name = n;
  }
}

class uf {
  HashMap<String, String> parent = new HashMap<>();
  HashMap<String, project> size = new HashMap<>();
  HashSet<String> banned = new HashSet<>();

  public String find(String x) {
    String pc = parent.get(x);
    if (pc == null || pc.equals(x)) {
      return x;
    }
    pc = find(pc);
    parent.put(x, pc);
    return pc;
  }

  public void union (String a, String b) {
    String pb = find(b);
    if (pb.equals(a) || banned.contains(b)) {
      return;
    }
    if (parent.containsKey(b)) {
      banned.add(b);
      size.get(pb).psize--;
      return;
    }
    parent.put(b, a);
    long curr = size.get(a).psize;
    size.get(a).psize++;
  }
}