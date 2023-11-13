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
public class basicprog2 {

  public static void main(String[] args) {
    FastIO sc = new FastIO();
    HashSet<Integer> seen = new HashSet<>();
    boolean uniq = true;
    int n = sc.nextInt(); int t = sc.nextInt();
    int[] arr = new int[n];
    ArrayList<Integer> btw = new ArrayList<>();
    HashMap<Integer, Long> freqTable = new HashMap<>();
    for (int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
      if (arr[i] >= 100 && arr[i] <= 999) {
        btw.add(arr[i]);
      }
      seen.add(arr[i]);
      freqTable.put(arr[i], freqTable.getOrDefault(arr[i], (long) 0) + 1);
    }
    switch (t) {
      case 1:
        boolean possum = false;
        for (int i = 1; i <= 7777; i++) {
          if (seen.contains(i) && seen.contains(7777 - i) && i != 7777 - i) {
            sc.println("Yes");
            sc.close();
            return;
          }
        }
        sc.println("No");
        break;
      case 2:
        if (seen.size() == n) {sc.println("Unique");} else {
          sc.println("Contains duplicate");
        }
        break;
      case 3:
        for (Map.Entry<Integer, Long> mp : freqTable.entrySet()) {
          if (mp.getValue() > n / 2) {
            sc.println(mp.getKey());
            sc.close();
            return;
          }
        }
        sc.println("-1");
        break;
      case 4:
        Arrays.sort(arr);
        if (n % 2 != 0) {
          sc.println(arr[(n/2)]);
        } else {
          sc.println(arr[(n/2)-1] + " " + arr[n/2]);
        }
        break;
      case 5:
        btw.sort(Comparator.naturalOrder());
        StringBuilder sb = new StringBuilder();
        for (int aa : btw) {
          sb.append(aa + " ");
        }
        sc.println(sb);
        break;
    }
    sc.close();
  }

}