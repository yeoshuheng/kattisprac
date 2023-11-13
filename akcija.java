import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.PriorityQueue;

public class akcija {
  public static void main(String[] args) throws IOException {
    BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter pw = new PrintWriter(System.out);
    int n = Integer.parseInt(sc.readLine());
    PriorityQueue<Integer> t = new PriorityQueue<>();
    for (int i = 0; i < n; i++) {
      t.add(-1 * Integer.parseInt(sc.readLine()));
    }
    //System.out.println(Arrays.toString(t));
    int total_pay = 0;
    while (t.size() >= 3) {
      total_pay += ((t.poll() + t.poll()) * -1);
      t.poll();
    }
    while (!t.isEmpty()) {
      total_pay += (t.poll() * -1);
    }
    System.out.println(total_pay);
  }
}
