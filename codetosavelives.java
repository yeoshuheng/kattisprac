import java.util.Scanner;

class codetosavelives {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            String t1 = sc.nextLine().replaceAll(" ", "");
            String t2 = sc.nextLine().replaceAll(" ", "");
            int outpt = Integer.parseInt(t1) + Integer.parseInt(t2);
            String outptst = Integer.toString(outpt);
            String ret = "";
            for (int j = 0; j < outptst.length(); j++) {
                ret += " " + outptst.charAt(j);
            }
            System.out.println(ret.trim());
    }
}

}
