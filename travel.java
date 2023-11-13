import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class travel {
  public static void main(String[] args) throws IOException {
    BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
    String[] ipt = sc.readLine().split(" ");
    int k = Integer.parseInt(ipt[0]);
    int n = Integer.parseInt(ipt[1]);
    int m = Integer.parseInt(ipt[2]);
    HashMap<Integer, Integer> airportToCapacity = new HashMap<>();
    for (int i = 1; i <= k; i++) {
      airportToCapacity.put(i, 0);
    }
    HashMap<Integer, ArrayList<Integer[]>> flights = new HashMap<>();
    HashMap<Integer, ArrayList<Integer[]>> airport_status = new HashMap<>();
    for (int i = 1; i <= n; i++) {
      airport_status.put(i, new ArrayList<Integer[]>());
      flights.put(i, new ArrayList<Integer[]>());
    }
    for (int i = 0; i < m; i++) {
      ipt = sc.readLine().split(" ");
      // start, end, capacity
      int day = Integer.parseInt(ipt[2]);
      Integer[] curr = new Integer[]{Integer.parseInt(ipt[0]),
        Integer.parseInt(ipt[1]), Integer.parseInt(ipt[3])};
      flights.get(day).add(curr);
    }
    for (int i = 0; i < k * n; i++) {
      ipt = sc.readLine().split(" ");
      int day = Integer.parseInt(ipt[1]);
      // airport, day, customers_arrived
      Integer[] curr = new Integer[]{Integer.parseInt(ipt[0]), Integer.parseInt(ipt[2])};
      airport_status.get(day).add(curr);
    }
    for (int cday = 1; cday <= n; cday++) {
      ArrayList<Integer[]> flights_today = flights.get(cday);
      ArrayList<Integer[]> movement_today = airport_status.get(cday);
      for (Integer[] m_t : movement_today) {
        int airport = m_t[0]; int arrived = m_t[1];
        airportToCapacity.put(airport, airportToCapacity.get(airport) + arrived);
      }
      for (Integer[] f_t : flights_today) {
        int depart = f_t[0]; int cap = f_t[2];
        int ppl = airportToCapacity.get(depart);
        if (ppl < cap) {
          System.out.println("suboptimal");
          return;
        }
        airportToCapacity.put(depart, ppl - cap);
      }
      for (Integer[] f_t : flights_today) {
        int arrive = f_t[1]; int cap = f_t[2];
        airportToCapacity.put(arrive, airportToCapacity.get(arrive) + cap);
      }
    }
    System.out.println("optimal");
  }
}
