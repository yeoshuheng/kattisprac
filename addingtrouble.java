import java.util.Scanner;

class addingtrouble {

public static void main(String[] args) {
  Scanner sc = new Scanner(System.in);
  int a = 0; int b = 0; int c = 0;
  for (int i = 0; i < 3; i++) {
    if (i == 0) {
        a = sc.nextInt();
    } else if (i == 1) {
        b = sc.nextInt();
    } else {
        c = sc.nextInt();
    }
  }
  if (a + b == c) {
    System.out.println("correct!");
  } else {
    System.out.println("wrong!");
  }
}

}
