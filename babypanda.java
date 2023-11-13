import java.util.Arrays;
import java.util.Scanner;
import java.util.HashMap;

public class babypanda {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong(); long m = sc.nextLong();
        int sneezed = 0;
        while (m >= 1) {
            if (m % 2 == 1) {
                sneezed += 1;
            }
            m /= 2;
        }
        System.out.println(sneezed);
    }

}



