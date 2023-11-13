import java.util.Scanner;

class undeadoralive {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String ipt = sc.nextLine();
    boolean smiley = ipt.contains(":)");
    boolean frown = ipt.contains(":(");
    if (smiley && frown) {
        System.out.println("double agent");
        return;
    }
    if (smiley && !frown) {
        System.out.println("alive");
        return;
    }
    if (frown && !smiley) {
        System.out.println("undead");
        return;
    }
    System.out.println("machine");
  }

}
