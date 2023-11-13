import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class speedrun {
  public static void main(String[] args) throws IOException {
    BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter pw = new PrintWriter(System.out);
    String[] ipt = sc.readLine().split(" ");
    int g = Integer.parseInt(ipt[0]); int n = Integer.parseInt(ipt[1]);
    ArrayList<Integer[]> tasks = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      ipt = sc.readLine().split(" ");
      int strt = Integer.parseInt(ipt[0]); int end = Integer.parseInt(ipt[1]);
      tasks.add(new Integer[]{strt, end});
    }
    tasks.sort(new Comparator<Integer[]>() {
      @Override
      public int compare(Integer[] o1, Integer[] o2) {
        if (o1[0] == o2[0]) {
          return o1[0] < o2[0] ? 1 : -1;
        }
        return o1[1] > o2[1] ? 1 : -1;
      }
    });
    int completed = 0;
    int prev_end = Integer.MIN_VALUE;
    for (Integer[] task : tasks) {
      if (task[0] < prev_end) {continue;}
      completed++;
      prev_end = task[1];
    }
    if (completed >= g) {pw.println("YES");} else {pw.println("NO");}
    pw.close();
  }
}