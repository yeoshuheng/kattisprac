import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class rationalseq {
  public static void main(String[] args) throws IOException {
    BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
    int p = Integer.parseInt(sc.readLine());
    for (int i = 0; i < p; i++) {
      String[] ipt = sc.readLine().split(" ");
      int k = Integer.parseInt(ipt[0]);
      long n = Long.parseLong(ipt[1]);
      Stack<Character> seen = new Stack<>();
      while (n > 1) {
        //System.out.println(n);
        if (navigateDown(navigateUp(n)) == n) { // n is a left child.
          seen.push('L');
        } else {seen.push('R');} // n is a right child.
        n = navigateUp(n); // We traverse upwards.
      }
      long num = 1; long denom = 1;
      while (!seen.empty()) {
        Character dir = seen.pop();
        //System.out.println(dir);
        if (dir.equals('L')){
          denom = num + denom;
        } else {
          num = num + denom;
        }
      }
      System.out.println(k + " " + num + "/" + denom);
    }

  }
  public static long navigateUp(long n) {
    return Math.floorDiv(n, 2);
  }
  public static long navigateDown(long n) {
    return n * 2;
  }

  public static long navigateRight(long n) {
    return (n * 2) + 1;
  }
}
