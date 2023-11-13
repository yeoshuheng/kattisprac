import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
public class heirs {

    public static boolean checkNumber(long num) {
        long num_ = num;
        Set<Integer> seen = new HashSet<>();
        while (num > 0) {
            int t = (int) num % 10;
            if (t == 0) {
                return false;
            }
            if (seen.contains(t)) {
                return false;
            }
            if (num_ % t != 0) {return false;}
            num = num / (int) 10;
            seen.add(t);
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long l = sc.nextLong(); long h = sc.nextLong();
        int count = 0;
        for (long i = l; i <= h; i++) {
            if (checkNumber(i)) {
                count++;
            }
        }
        System.out.println(count);
    }

}
