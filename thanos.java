import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class thanos {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(sc.readLine());
        for (int i = 0; i < n; i++) {
            String[] inpt = sc.readLine().split(" ");
            long p = Long.parseLong(inpt[0]);
            long r = Long.parseLong(inpt[1]);
            long f = Long.parseLong(inpt[2]);
            int sustained = 0;
            while (f >= p) {
                p *= r;
                sustained++;
            }
            System.out.println(sustained);
        }
    }
}
