import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class accounting {
  public static void main(String[] args) throws IOException {
    BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
    String[] ipt = sc.readLine().split(" ");
    int n = Integer.parseInt(ipt[0]); int q = Integer.parseInt(ipt[1]);
    HashMap<Integer, Integer> population = new HashMap<>();
    int default_val = 0;
    for (int i = 0; i < q; i++) {
      ipt = sc.readLine().split(" ");
      if (ipt[0].equals("SET")) {
        population.put(Integer.parseInt(ipt[1]), Integer.parseInt(ipt[2]));
      } else if (ipt[0].equals("PRINT")) {
        System.out.println(population.getOrDefault(Integer.parseInt(ipt[1]), default_val));
      } else if (ipt[0].equals("RESTART")) {
        default_val = Integer.parseInt(ipt[1]);
        population.clear();
      }
    }
  }
}
