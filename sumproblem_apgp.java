import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class sumproblem_apgp {
  public static void main(String[] args) throws IOException {
    BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
    int k = Integer.parseInt(sc.readLine());
    for (int i = 0; i < k; i++) {
      String[] ipt = sc.readLine().split(" ");
      int dataForN = Integer.parseInt(ipt[1]);
      int odd = (int) Math.pow(dataForN, 2);
      int even = dataForN * (dataForN + 1);
      int possum = (dataForN * (dataForN + 1)) / 2;
      System.out.println(i + 1 + " " + possum + " " + odd + " " + even);
    }
  }
}
