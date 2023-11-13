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
public class addemup {
  public static void main(String[] args) {
    FastIO sc = new FastIO();
    int n = sc.nextInt(); long s = sc.nextLong();
    ArrayList<Long> arr = new ArrayList<>();
    HashMap<Character, Character> validFlips = new HashMap<>();
    validFlips.put('0', '0');
    validFlips.put('1', '1');
    validFlips.put('5', '5');
    validFlips.put('2', '2');
    validFlips.put('6', '9');
    validFlips.put('9', '6');
    HashMap<Long, Long> flippedMap = new HashMap<>();
    while (n-- > 0) {
      Long c = sc.nextLong();
      arr.add(c);
      char[] cstr = String.valueOf(c).toCharArray();
      char[] flipped = new char[cstr.length];
      boolean canfind = true;
      for (int i = 0; i < cstr.length; i++) {
        char cc = cstr[i];
        if (!validFlips.containsKey(cc)) {
          canfind = false;
          break;
        }
        flipped[cstr.length - 1 - i] = validFlips.get(cc);
      }
      if (canfind) {
        flippedMap.put(c, Long.parseLong(new String(flipped)));
      }
    }
    HashSet<Long> needed = new HashSet<>();
    for (long c : arr) {
      if (needed.contains(c)) {
        sc.println("YES");
        sc.close();
        return;
      }
      Long flippedc = flippedMap.get(c);
      if (flippedc != null) {
        if (needed.contains(flippedc)) {
          sc.println("YES");
          sc.close();
          return;
        }
        needed.add(s - flippedc);
      }
      needed.add(s - c);
    }
    sc.println("NO");
    sc.close();
  }
}
