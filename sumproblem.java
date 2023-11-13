import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class sumproblem {
  public static void main(String[] args) throws IOException {
    BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
    int k = Integer.parseInt(sc.readLine());
    int maxInt = Integer.MIN_VALUE;
    long[][] mapNoToDataset = new long[k][4];
    for (int i = 0; i < k; i++) {
      String[] ipt = sc.readLine().split(" ");
      int dataForN = Integer.parseInt(ipt[1]);
      mapNoToDataset[i] = new long[]{dataForN, 0, 0, 0};
      maxInt = Math.max(dataForN, maxInt);
    }
    long sumEven = 0; long sumOdd = 0; long sumPos = 0;
    int evenSeen = 0; int oddSeen = 0; int posSeen = 0;
    int i = 1;
    while (evenSeen <= maxInt || oddSeen <= maxInt || posSeen <= maxInt) {
      if (i % 2 == 0) {sumEven += i; evenSeen++;} else {sumOdd += i; oddSeen++;}
      if (i > -1) {sumPos += i; posSeen++;}
      for (int j = 0; j < mapNoToDataset.length; j++) {
        long req = mapNoToDataset[j][0];
        if (req == evenSeen) {mapNoToDataset[j][3] = sumEven;}
        if (req == posSeen) {mapNoToDataset[j][1] = sumPos;}
        if (req == oddSeen) {mapNoToDataset[j][2] = sumOdd;}
      }
      i++;
    }
    int c = 1;
    for (long[] opt : mapNoToDataset) {
      System.out.println(c + " " + opt[1] + " " + opt[2] + " " + opt[3]);
      c++;
    }
  }
}
