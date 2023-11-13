import java.util.*;
import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

class FastIO extends PrintWriter {
  BufferedReader br;
  StringTokenizer st;
  public FastIO() {
    super(new BufferedOutputStream(System.out));
    br = new BufferedReader(new InputStreamReader(System.in));
  }
  String next() {
    while (st == null || ! st.hasMoreElements()) {
      try { st = new StringTokenizer(br.readLine()); }
      catch (IOException  e) { e.printStackTrace(); }
    }
    return st.nextToken();
  }
  int nextInt() { return Integer.parseInt(next()); }
  long nextLong() { return Long.parseLong(next()); }
  double nextDouble() { return Double.parseDouble(next()); }
  String nextLine() {
    String str = "";
    try { str = br.readLine(); }
    catch (IOException e) { e.printStackTrace(); }
    return str;
  }
}

class prescribed {
  long timedropped;
  int timeToClear;
  public prescribed(long d, int k) {
    timedropped = d;
    timeToClear = k;
  }
}
public class pharmacy {
  public static void main(String[] args) {
    FastIO sc = new FastIO();
    int n = sc.nextInt(); int t = sc.nextInt();
    PriorityQueue<Long> pharmacist = new PriorityQueue<>();
    for (int i = 0; i < t; i++) {pharmacist.offer((long) 0);}
    Deque<prescribed> remote = new LinkedList<>();
    Deque<prescribed> inclinic = new LinkedList<>();
    while (n-- > 0) {
      long td = sc.nextLong(); String type = sc.next(); int tt = sc.nextInt();
      prescribed curr = new prescribed(td, tt);
      if (type.equals("R")) {remote.addLast(curr);} else {inclinic.add(curr);}
    }
    long nremote = remote.size(); long ninclinic = inclinic.size();
    long remotett = 0; long inclinictt = 0;
    while (!remote.isEmpty() || !inclinic.isEmpty()) {

      while (!remote.isEmpty() && !inclinic.isEmpty() && !pharmacist.isEmpty() && remote.peek().timedropped < inclinic.peek().timedropped) {
        prescribed currP = remote.poll();
        long currPharma = pharmacist.poll();
        long realStart = Math.max(currP.timedropped, currPharma);
        long realEnd = realStart + currP.timeToClear;
        System.out.println("pharmacist @ t " + currPharma + " filling up prescription that came in @ time " + currP.timedropped);
        remotett += realEnd - currP.timedropped;
        pharmacist.offer(realEnd);
      }
      System.out.println("tt remote: " + remotett + " tt ic " + inclinictt);
      while (!inclinic.isEmpty() && !pharmacist.isEmpty()) {
        prescribed currP = inclinic.poll();
        long currPharma = pharmacist.poll();
        long realStart = Math.max(currP.timedropped, currPharma);
        long realEnd = realStart + currP.timeToClear;
        System.out.println("pharmacist @ t " + currPharma + " filling up prescription that came in @ time " + currP.timedropped);
        inclinictt += realEnd - currP.timedropped;
        pharmacist.offer(realEnd);
      }

      System.out.println("tt remote: " + remotett + " tt ic " + inclinictt);
      while (!remote.isEmpty() && !pharmacist.isEmpty()) {
        prescribed currP = remote.poll();
        long currPharma = pharmacist.poll();
        long realStart = Math.max(currP.timedropped, currPharma);
        long realEnd = realStart + currP.timeToClear;
        System.out.println("pharmacist @ t " + currPharma + " filling up prescription that came in @ time " + currP.timedropped);
        remotett += realEnd - currP.timedropped;
        pharmacist.offer(realEnd);
      }

      System.out.println("tt remote: " + remotett + " tt ic " + inclinictt);
    }
    double o = inclinictt / (double) ninclinic;
    double r = remotett / (double) nremote;
    sc.println(o + " " + r);
    sc.close();
  }
}
