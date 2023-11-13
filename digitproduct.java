import java.util.Scanner;

class digitproduct {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        while (x > 9) {
            String x_ = Integer.toString(x);
            x = divide(x_);
        }
        System.out.println(x);
    }

    public static int divide (String x) {
        int ret = 1;
        for (int i = 0; i <  x.length(); i++) {
            char j = x.charAt(i);
            if (j == '0') {
                continue;
            }
            ret *= Character.getNumericValue(j);
        }
        return ret;
    }

}
