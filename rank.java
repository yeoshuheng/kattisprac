import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.List;

public class rank {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nTeams = sc.nextInt(); int nMatch = sc.nextInt();
        ArrayList<String> teamRank = new ArrayList<>();
        for (int i = 0; i < nTeams; i++) {
            Integer teamNo = i + 1;
            teamRank.add("T" + teamNo);
        }
        sc.nextLine();
        List<String> newteamRank = teamRank;
        for (int i = 0; i < nMatch; i++) {
            String[] matchUp = sc.nextLine().split(" ");
            String t1 = matchUp[0]; String t2 = matchUp[1];
            int t1p = newteamRank.indexOf(t1); int t2p = newteamRank.indexOf(t2);
            if (t2p < t1p) {
                newteamRank.remove(t2);
                newteamRank.add(t1p, t2);
            }
        }
        for (String i : newteamRank) {
            System.out.print(i + " ");
        }
    }
}
