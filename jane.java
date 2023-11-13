import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;

class book {
  public String name; public int page; public int r;
  public book(String name, int page, int received) {
    this.name = name; this.page = page; this.r = received;
  }
}
public class jane {

  public static void main(String[] args) throws IOException {
    BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
    String[] ipt = sc.readLine().split(" ");
    int n = Integer.parseInt(ipt[0]); int m = Integer.parseInt(ipt[1]);
    int k = Integer.parseInt(ipt[2]);
    LinkedList<bookings> unread = new LinkedList<>();
    for (int i = 0; i < n; i++) {
      String[] ipt_ = sc.readLine().split("\"");
      unread.add(new bookings(ipt_[1], Integer.parseInt(ipt_[2].strip()), 0));
    }
    unread.add(new bookings("Jane Eyre", k, 0));
    unread.sort(new Comparator<bookings>() {
      @Override
      public int compare(bookings o1, bookings o2) {
        return o1.name.compareTo(o2.name);
      }
    });
    LinkedList<bookings> given = new LinkedList<>();
    for (int i = 0; i < m; i++) {
      String[] ipt_ = sc.readLine().split("\"");
      if (ipt_[1].compareTo("Jane Erye") >= 0) {continue;}
      given.add(new bookings(ipt_[1], Integer.parseInt(ipt_[2].strip()), Integer.parseInt(ipt_[0].strip())));
    }
    given.sort(new Comparator<bookings>() {
      @Override
      public int compare(bookings o1, bookings o2) {
        return o1.r >= o2.r ? 1 : -1;
      }
    });
    String currName = ""; long tUsed = 0;
    while (!currName.equals("Jane Eyre")) {
      bookings cBook = unread.peekFirst();
      if (!given.isEmpty() && tUsed >= given.peekFirst().r && cBook.name.compareTo(given.peekFirst().name) > 0) {
        cBook = given.pollFirst();
      } else {
        cBook = unread.pollFirst();
      }
      currName = cBook.name; tUsed += cBook.page;
    }
    System.out.println(tUsed);
  }
}
