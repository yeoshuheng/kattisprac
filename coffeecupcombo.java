import java.util.Scanner;
public class coffeecupcombo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String cm = sc.nextLine();
        int curr_coffee = 0; int awake = 0;
        for (int i = 0; i < n; i++) {
            boolean havemachine = cm.charAt(i) == '1';
            if (havemachine) {
                awake += 1; curr_coffee = 2;
                continue;
            }
            if (curr_coffee > 0) {
                curr_coffee -= 1;
                awake += 1;
                continue;
            }
        }
        System.out.println(awake);
    }
}
