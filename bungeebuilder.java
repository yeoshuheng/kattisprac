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

public class bungeebuilder {
  public static void main(String[] args) {
    FastIO sc = new FastIO();
    int n = sc.nextInt();
    long[] mountains = new long[n];
    long maxHeight = Long.MIN_VALUE;
    int maxIdx = 0;
    long ret = 0;

    for (int i = 0; i < n; i++) {
      mountains[i] = sc.nextInt();
      if (mountains[i] > maxHeight) {
        maxIdx = i;
        maxHeight = mountains[i];
      }
    }
    Stack<Long[]> mountainPairs = new Stack<>();
    mountainPairs.push(new Long[]{maxHeight, (long) 0});
    for (int i = maxIdx - 1; i >= 0; i--) {
      //printStk(mountainPairs);
      long maxJump = 0;
      while (!mountainPairs.isEmpty() && mountains[i] >= mountainPairs.peek()[0]) {
        maxJump = Math.max(maxJump, mountains[i] - mountainPairs.peek()[0] + mountainPairs.peek()[1]);
        mountainPairs.pop();
      }
      mountainPairs.push(new Long[]{mountains[i], maxJump});
      ret = Math.max(ret, maxJump);
    }
    Stack<Long[]> mountainPairsR = new Stack<>();
    mountainPairsR.push(new Long[]{maxHeight, (long) 0});
    for (int i = maxIdx + 1; i < mountains.length; i++) {
      long maxJump = 0;
      while (!mountainPairsR.isEmpty() && mountains[i] >= mountainPairsR.peek()[0]) {
        maxJump = Math.max(maxJump, mountains[i] - mountainPairsR.peek()[0] + mountainPairsR.peek()[1]);
        mountainPairsR.pop();
      }
      mountainPairsR.push(new Long[]{mountains[i], maxJump});
      ret = Math.max(ret, maxJump);
    }
    sc.println(ret);
    sc.close();
  }
  public static void printStk(Stack<Integer[]> stk) {
    @SuppressWarnings("unchecked")
    Stack<Integer[]> test = (Stack<Integer[]> ) stk.clone();
    while (!test.empty()) {
      System.out.println(Arrays.toString(test.pop()));
    }
  }
}
