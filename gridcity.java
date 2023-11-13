import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class gridcity {
  public static void main(String[] args) throws IOException {
    BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
    String[] ca = sc.readLine().split(" ");
    int a = Integer.parseInt(ca[0]); int b = Integer.parseInt(ca[1]);
    ca = sc.readLine().split(" ");
    int c = Integer.parseInt(ca[0]); int d = Integer.parseInt(ca[1]);
    int t = Integer.parseInt(sc.readLine());
    int mhd = Math.abs(a - c) + Math.abs(b - d);
    if (mhd == t) {System.out.println("Y"); return;}
    if (mhd > t) {System.out.println("N"); return;}
    if ((t - mhd) % 2 == 1) {System.out.println("N"); return;}
    System.out.println("Y");
  }
}
