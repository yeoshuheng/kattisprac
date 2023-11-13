import java.util.Arrays;
import java.util.Scanner;
public class waitInLine {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int[] arr = new int[20]; int dn = 0;
            for (int j = 0; j < 21; j++) {
                int temp = sc.nextInt();
                if (j == 0) {
                    dn = temp;
                    continue;
                } else {
                    arr[j - 1] = temp;
                }
            }

            int shift = 0;

            for (int x = 1; x < 20; x++) {
                int curr = arr[x]; int prev = x - 1;
                while (prev > -1 && arr[prev] > curr) {
                    arr[prev + 1] = arr[prev];
                    prev--; shift++;
                }
                arr[prev + 1] = curr;
            }
            System.out.println(dn + " " + shift);
        }
    }
}
