import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class cardtrading {
  public static void main(String[] args) throws IOException {
    BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter pw = new PrintWriter(System.out);
    String[] ipt = sc.readLine().split(" ");
    int n = Integer.parseInt(ipt[0]); int t = Integer.parseInt(ipt[1]);
    int k = Integer.parseInt(ipt[2]);

    int[] cards = new int[100001];
    ArrayList<Prices> buySell = new ArrayList<>();
    ipt = sc.readLine().split(" ");
    //System.out.println(Arrays.toString(ipt));

    while (n-- > 0) {
      cards[Integer.parseInt(ipt[n])]++;
    }
    for (int i = 1; i <= t; i++){
      //System.out.println(i);
      ipt = sc.readLine().split(" ");
      // Suppose he buys
      long buyingPrice = Long.parseLong(ipt[0]) * (2 - cards[i]); // Can be negative (we sell extra)
      // Suppose he sells
      long sellingPrice = Long.parseLong(ipt[1]) * cards[i];
      buySell.add(new Prices(i, buyingPrice, sellingPrice));
    }
    Collections.sort(buySell, new Comparator<Prices>() {
      @Override
      public int compare(Prices o1, Prices o2) {
        long cost1 = o1.sell + o1.buy;
        long cost2 = o2.sell + o2.buy;
        // We sort based on the 'profit' we expect.
        if (cost1 < cost2) {return -1;}
        else if (cost1 > cost2) {return 1;}
        else {
          // Else, we want to see which 'buy' is cheaper.
          if (o1.buy < o2.buy) {
            return -1;
          } else if (o1.buy > o2.buy) {
            return 1;
          } else {return 0;}
        }
      }
    });
    //for (Prices p : buySell) {
    //  System.out.println("Type: " + p.type);
   //   System.out.println(p.buy);
   //   System.out.println(p.sell);
  //    System.out.println(p.buy - p.sell);
  //  }
    // Since we sorted it:
    // Lowest profit goes first, afterwards by buy price.
    // Hence, we buy all these up to achieve our objectives of k full pairings,
    // since we know this will give us lower profit, it is not that good to sell.
    // We then sell the rest to get the highest profit.
    long profit = 0;
    for (int i = 0; i < k; i++) {
      profit -= buySell.get(i).buy;
      //System.out.println(profit);
    }
    for (int i = k; i < t; i++) {
      profit += buySell.get(i).sell;
      //System.out.println(profit);
    }
    pw.println(profit);
    pw.close();
  }
}

class Prices {
  int type;
  long sell;
  long buy;

  public Prices (int type, long buy, long sell) {
    this.type = type;
    this.buy = buy;
    this.sell = sell;
  }
}


