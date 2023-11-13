import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class relay {
  public static void main(String[] args) throws IOException {
    BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(sc.readLine());
    Double[][] timingsFirst = new Double[n][2];
    Double[][] timingsSecond = new Double[n][2];
    String[] names = new String[n];
    for (int i = 0; i < n; i++) {
        String[] inpt = sc.readLine().split(" ");
        names[i] = inpt[0];
        timingsFirst[i] = new Double[]{(double) i, Double.parseDouble(inpt[1])};
        timingsSecond[i] = new Double[]{(double) i, Double.parseDouble(inpt[2])};
    }
    Comparator<Double[]> c = (o1, o2) -> (o1[1] > o2[1]) ? 1 : -1;
    Arrays.sort(timingsSecond, c);
    double[] currCombi = new double[4]; double minTiming = Integer.MAX_VALUE;
    for (Double[] r1 : timingsFirst) {
      double[] curr = new double[4];
      curr[0] = r1[0];
      int i = 1;
      double cTiming = r1[1];
      for (Double[] r2 : timingsSecond) {
        if (i == 4) {
          break;
        }
        if (r2[0].equals(r1[0])) {
          continue;
        }
        curr[i] = r2[0]; cTiming += r2[1]; i++;
      }
      if (cTiming < minTiming) {
        minTiming = cTiming; currCombi = curr;
      }
    }
    System.out.println(minTiming);
    for (double idx : currCombi) {
      System.out.println(names[(int) idx]);
    }
  }
}
