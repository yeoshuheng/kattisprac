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
public class basicprog1 {
  public static void main(String[] args) {
    FastIO sc = new FastIO();
    HashMap<Integer, Character> alpha = new HashMap<>();
    char currc = 'a';
    for (int i = 0; i < 26; i++) {
      alpha.put(i, currc);
      currc++;
    }
    int n = sc.nextInt(); int t = sc.nextInt();
    int[] arr = new int[n];
    long sum = 0;
    long sumev = 0;
    char[] modulo = new char[n];
    for (int i  = 0; i < n; i++) {
      arr[i] = sc.nextInt();
      sum += arr[i];
      if (arr[i] % 2 == 0) {
        sumev += arr[i];
      }
      int mod = arr[i] % 26;
      modulo[i] = alpha.get(mod);
    }
    switch (t) {
      case 1:
        sc.println(7);
        break;
      case 2:
        if (arr[0] > arr[1]) {
          sc.println("Bigger");
        } else if (arr[0] == arr[1]) {
          sc.println("Equal");
        } else {
          sc.println("Smaller");
        }
        break;
      case 3:
        int[] subArr = new int[]{arr[0], arr[1], arr[2]};
        Arrays.sort(subArr);
        sc.println(subArr[1]);
        break;
      case 4:
        sc.println(sum);
        break;
      case 5:
        sc.println(sumev);
        break;
      case 6:
        StringBuilder sb = new StringBuilder();
        for (char cc : modulo) {
          sb.append(cc);
        }
        sc.println(sb);
        break;
      case 7:
        int curr = 0;
        HashSet<Integer> seen = new HashSet<>();
        seen.add(0);
        while (curr < n && curr > -1) {
          curr = arr[curr];
          if (curr == n - 1) {
            sc.println("Done");
            sc.close();
            return;
          }
          if (seen.contains(curr)) {
            sc.println("Cyclic");
            sc.close();
            return;
          }
          seen.add(curr);
        }
        sc.println("Out");
        sc.close();
        return;
    }
    sc.close();
  }
}
