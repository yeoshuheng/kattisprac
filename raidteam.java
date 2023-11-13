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

class adventurer {
  String name;
  long sk1;
  long sk2;
  long sk3;
  public adventurer(String name_, long s1, long s2, long s3) {
    name = name_;
    sk1 = s1;
    sk2 = s2;
    sk3 = s3;
  }
}
public class raidteam {
  public static void main(String[] args) {
    FastIO sc = new FastIO();
    long n = sc.nextLong();
    Comparator<adventurer> cp1 = new Comparator<adventurer>() {
      @Override
      public int compare(adventurer o1, adventurer o2) {
        if (o1.sk1 == o2.sk1) {
          return o1.name.compareTo(o2.name);
        }
        return o1.sk1 < o2.sk1 ? 1 : -1;
      }
    };
    Comparator<adventurer> cp2 = new Comparator<adventurer>() {
      @Override
      public int compare(adventurer o1, adventurer o2) {
        if (o1.sk2 == o2.sk2) {
          return o1.name.compareTo(o2.name);
        }
        return o1.sk2 < o2.sk2 ? 1 : -1;
      }
    };
    Comparator<adventurer> cp3 = new Comparator<adventurer>() {
      @Override
      public int compare(adventurer o1, adventurer o2) {
        if (o1.sk3 == o2.sk3) {
          return o1.name.compareTo(o2.name);
        }
        return o1.sk3 < o2.sk3 ? 1 : -1;
      }
    };
    PriorityQueue<adventurer> pqs1 = new PriorityQueue<>(cp1);
    PriorityQueue<adventurer> pqs2 = new PriorityQueue<>(cp2);
    PriorityQueue<adventurer> pqs3 = new PriorityQueue<>(cp3);
    while(n-- > 0) {
      String name = sc.next();
      long s1 = sc.nextLong();
      long s2 = sc.nextLong();
      long s3 = sc.nextLong();
      adventurer curr = new adventurer(name, s1, s2, s3);
      pqs1.offer(curr);
      pqs2.offer(curr);
      pqs3.offer(curr);
    }
    HashSet<String> seen = new HashSet<>();
    while (true) {
      TreeSet<String> team = new TreeSet<>();
      adventurer mem1 = null;
      while (!pqs1.isEmpty()) {
        adventurer m1 = pqs1.poll();
        if (!seen.contains(m1.name)) {
          mem1 = m1;
          seen.add(m1.name);
          team.add(m1.name);
          break;
        }
      }
      if (mem1 == null) {break;}
      adventurer mem2 = null;
      while (!pqs2.isEmpty()) {
        adventurer m2 = pqs2.poll();
        if (!seen.contains(m2.name)) {
          mem2 = m2;
          seen.add(m2.name);
          team.add(m2.name);
          break;
        }
      }
      if (mem2 == null) {break;}
      adventurer mem3 = null;
      while (!pqs3.isEmpty()) {
        adventurer m3 = pqs3.poll();
        if (!seen.contains(m3.name)) {
          mem3 = m3;
          seen.add(m3.name);
          team.add(m3.name);
          break;
        }
      }
      if (mem3 == null) {break;}
      StringBuilder sb = new StringBuilder();
      for (String tn : team) {
        sb.append(tn + " ");
      }
      sc.println(sb);
    }
    sc.close();
  }
}
