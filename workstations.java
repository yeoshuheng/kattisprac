import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class workstations {
  public static void main(String[] args) throws IOException {
    BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter pw = new PrintWriter(System.out);
    String[] ipt = sc.readLine().split(" ");
    int n = Integer.parseInt(ipt[0]); int m = Integer.parseInt(ipt[1]);
    PriorityQueue<Integer> stationsPq = new PriorityQueue<>();
    PriorityQueue<Integer[]> researchPq = new PriorityQueue<>(new Comparator<Integer[]>() {
      @Override
      public int compare(Integer[] o1, Integer[] o2) {
        if (o1[0] == o2[0]) {
          return o1[1] < o2[1] ? -1 : 1;
        }
        return o1[0] < o2[0] ? -1 : 1;
      }
    });
    int res = 0;
    for (int i = 0; i < n; i++) {
      ipt = sc.readLine().split(" ");
      int a = Integer.parseInt(ipt[0]); int s = Integer.parseInt(ipt[1]);
      researchPq.add(new Integer[]{a, s});
    }
    while (!researchPq.isEmpty()) {
      Integer[] researcher = researchPq.poll();
      // Remove all the workstations that will not be available for current researcher.
      while (!stationsPq.isEmpty() && stationsPq.peek() + m < researcher[0]) {
        stationsPq.poll();
      }
      // Check the current workstation -> need to make sure:
      // 1) Check if the current researcher's arrival time is less than equal to the opening of the workstation
      // 2) Check that the current researcher's arrival time is more than the start of the workstation opening.
      if (!stationsPq.isEmpty() && researcher[0] <= stationsPq.peek() + m
        && stationsPq.peek() <= researcher[0]) {
        stationsPq.poll(); // This station can be used.
        res++;
      }
      // Add when the current station is free again.
      stationsPq.offer(researcher[0] + researcher[1]);
    }
    System.out.println(res);
  }
}
