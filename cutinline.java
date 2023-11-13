import java.util.Scanner;
import java.util.ArrayList;

public class cutinline {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<String> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(sc.next());
        }
        int c = sc.nextInt();
        sc.nextLine();
        for (int j = 0; j < c; j++) {
            String[] input = sc.nextLine().split(" ");
            String command = input[0];
            if (command.equals("cut")) {
                String a = input[1]; String b = input[2];
                int idxb = arr.indexOf(b);
                arr.add(idxb, a);
            } else if (command.equals("leave")) {
                int idxa = arr.indexOf(input[1]);
                arr.remove(idxa);
            }
        }
        for (String s : arr) {
            System.out.println(s);
        }
    }
}
