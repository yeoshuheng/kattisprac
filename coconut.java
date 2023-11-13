import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;


class player {
  int state;
  int num;
  public player(int num, int state) {
    this.num = num;
    this.state = state;
  }
}

// State :
//  0 : Hands folded
//  1 : Fisted
//  2 : Palm Down

public class coconut {
  public static void main(String[] args) throws IOException {
    BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter pw = new PrintWriter(System.out);
    String[] ipt = sc.readLine().split(" ");
    int n = Integer.parseInt(ipt[0]); int p = Integer.parseInt(ipt[1]);
    ArrayList<player> players = new ArrayList<>();
    for (int i = 1; i <= p; i++) {
      players.add(new player(i, 0));
    }
    int cid = 0;
    while (players.size() > 1) {
      cid = (cid + n - 1) % players.size();
      switch (players.get(cid).state) {
        case 0:
          players.get(cid).state = 1;
          players.add(cid, new player(players.get(cid).num, 1));
          break;
        case 1:
          players.get(cid).state = 2;
          cid++;
          break;
        case 2:
          players.remove(cid);
          break;
      }
    }
    pw.println(players.get(0).num);
    pw.close();
  }
}
