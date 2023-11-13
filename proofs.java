import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;

public class proofs {
  public static void main(String[] args) throws IOException {
    BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter pw = new PrintWriter(System.out);
    int n = Integer.parseInt(sc.readLine());
    HashSet<String> seen = new HashSet<>();
    for (int i = 0; i < n; i++) {
      String[] st = sc.readLine().split(" ");
      boolean assumption = false;
      for (String s : st) {
        if (s.equals("->")) {
          assumption = true;
          continue;
        }
        if (!assumption && !seen.contains(s)) {
          System.out.println(i + 1);
          return;
        }
        if (assumption) {
          seen.add(s);
        }
      }
    }
    System.out.println("correct");
  }
}
