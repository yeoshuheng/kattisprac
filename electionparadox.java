import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

class electionparadox {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        float base = 2;
        int neededToWin = (int) Math.ceil(n / base);
        ArrayList<Integer> populations = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int pop = sc.nextInt();
            populations.add(pop);
        }
        Collections.sort(populations);
        int ret = 0;
        for (int j = 0; j < neededToWin; j++) {
            int p = populations.get(j);
            int neededForRegion = (int) Math.ceil(p / base);
            ret += neededForRegion;
        }
        int total = 0;
        for (int p : populations) {
            total += p;
        }
        System.out.println(total - ret);
    }

}
