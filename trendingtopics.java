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
public class trendingtopics {
  public static void main(String[] args) {
    FastIO sc = new FastIO();
    HashMap<Integer, ArrayList<String>> words = new HashMap<>();
    HashMap<Integer, ArrayList<Integer>> queries = new HashMap<>();
    String ipt;
    int currDay = 0;
    words.put(currDay, new ArrayList<>());
    queries.put(currDay, new ArrayList<>());
    while ((ipt = sc.nextLine()) != null) {
      if (ipt.equals("")) {continue;}
      if (ipt.equals("<text>")) {
        currDay++;
        words.put(currDay, new ArrayList<>());
        queries.put(currDay, new ArrayList<>());
        continue;
      } else if (ipt.equals("</text>")) {
        continue;
      } else if (ipt.startsWith("<top")) {
        char topVal = ipt.charAt(5);
        queries.get(currDay).add(Integer.parseInt(String.valueOf(topVal)));
        continue;
      }
      StringTokenizer st = new StringTokenizer(ipt);
      while (st.hasMoreTokens()) {
        String c = st.nextToken();
        if (c.length() < 4) {continue;}
        words.get(currDay).add(c);
      }
    }
    HashMap<String, Integer> window = new HashMap<>();
    for (int i = 0; i < currDay + 1; i++) {
      ArrayList<String> wordsToAdd = words.get(i);
      for (String w : wordsToAdd) {
        window.put(w, window.getOrDefault(w, 0) + 1);
      }
      if (i > 7) {
        int expiredday = i - 7;
        ArrayList<String> wordsToRemove = words.get(expiredday);
        for (String w : wordsToRemove) {
          window.put(w, window.get(w) - 1);
          if (window.get(w) == 0) {window.remove(w);}
        }
      }
     // System.out.println("curr day: " + i);
      for (int topNeeded : queries.get(i)) {
        sc.println("<top " + topNeeded + ">");
        TreeMap<Integer, TreeSet<String>> sorted = new TreeMap<>();
        for (Map.Entry<String, Integer> mp : window.entrySet()) {
          String focusword = mp.getKey(); int freq = mp.getValue();
          if (!sorted.containsKey(freq)) {sorted.put(freq, new TreeSet<>());}
          sorted.get(freq).add(focusword);
        }
        //System.out.println(sorted.values());
        long top = topNeeded;
        while (top > 0) {
          Map.Entry<Integer, TreeSet<String>> entry = sorted.pollLastEntry();
          long cfreq = entry.getKey();
          for  (String s : entry.getValue()) {
            sc.println(s + " " + cfreq);
            top--;
          }
        }
        sc.println("</top>");
        if (queries.isEmpty()) {sc.close(); return;}
      }
    }
    sc.close();
  }
}
