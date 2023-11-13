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

public class circuitmath {
  public static HashSet<String> ops = new HashSet<>();
  public static void main(String[] args) {
    ops.add("*");
    ops.add("-");
    ops.add("+");
    FastIO sc = new FastIO();
    int n = sc.nextInt();
    HashMap<String, Boolean> Tval = new HashMap<>();
    String[] ipt = sc.nextLine().split(" ");
    char crr = 'a';
    for (int i = 0; i < n; i++) {
      String ss = ipt[i];
      boolean t;
      if (ss.equals("T")) {
        t = true;
      } else {t = false;}
      Tval.put(String.valueOf(crr), t);
      crr++;
    }
    String[] desc = sc.nextLine().split(" ");
    Stack<Boolean> operands = new Stack<>();
    int seen = 0;
    for (int i = 0; i < desc.length; i++) {
      String curr = desc[i];
      if (ops.contains(curr)) {
        switch(curr) {
          case "*":
            boolean a = operands.pop(); boolean b = operands.pop();
            operands.push(a && b);
            break;
          case "-":
            a = operands.pop();
            operands.push(!a);
            break;
          case "+":
            a = operands.pop(); b = operands.pop();
            operands.push(a || b);
            break;
        }
      } else {
        operands.push(Tval.get(curr.toLowerCase()));
      }
    }

    if (operands.peek()) {sc.println("T");}
    else {sc.println("F");}
    sc.close();
  }
}