import java.util.Scanner;

class internationaldates {

public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String ipt = sc.nextLine();
    String a = ipt.substring(0, 2);
    String b = ipt.substring(3, 5);
    int a_ = Integer.parseInt(a); int b_ = Integer.parseInt(b);
    if (a_ > 12) {
        System.out.println("EU");
        return;
    }
    if (b_ > 12) {
        System.out.println("US");
        return;
    } 
    System.out.println("either");
}

}
