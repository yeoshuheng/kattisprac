import java.io.PrintWriter;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Stack;

class juggling {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    PrintWriter pw = new PrintWriter(System.out);
    while (sc.hasNextLine()) {
      String iptt = sc.nextLine();
      char[] ipt = iptt.toCharArray();
      long sum = getSum(ipt);
      if (sum % ipt.length != 0) {
        pw.println(iptt + ": invalid # of balls");
        continue;
      }
      long nUsed = sum / ipt.length;
      HashSet<Long> stk = new HashSet<>();
      for (int i = 0; i < ipt.length; i++) {
        stk.add((Long.parseLong(String.valueOf(ipt[i])) + i) % ipt.length);
      }
      if (stk.size() == ipt.length) {
        pw.println(iptt + ": valid with " + nUsed + " balls");
      } else {
        pw.println("invalid pattern");
      }
    }
    pw.close();
  }

  public static long getSum(char[] ipt) {
    long sum = 0;
    for (char c : ipt) {
      sum += Integer.parseInt(String.valueOf(c));
    }
    return sum;
  }
}
