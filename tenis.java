/*
 * Yeo Shu Heng A0252611R
 * */
import java.util.Scanner;

class tenis {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String players = sc.nextLine();
        String[] players_ = players.split(" ");
        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            String score = sc.nextLine();
            String[] arr = score.split(" ");
            if (validMatch(arr, players_)) {
                System.out.println("da");
            } else {
                System.out.println("ne");
            }
        }
    }

    public static boolean validMatch(String[] arr, String[] players) {
        String p1 = players[0]; String p2 = players[1];
        if (!(arr.length == 2 || arr.length == 3)) {
            return false;
        }
        if (arr.length == 3) {
            int p1Win = 0; int p2Win = 0;
            for (int i = 0; i < 3; i++) {
                if (i == 2 && (p1Win != p2Win)) {return false;}
                String[] scores = arr[i].split(":");
                int p1s = Integer.parseInt(scores[0]); int p2s = Integer.parseInt(scores[1]);
                if (i == 2 && p1s == p2s) {return false;}
                if (p1s >= 6 && p2s >= 6) {
                    if (Math.abs(p1s - p2s) != 1 && i != 2) {
                        return false;
                    }
                    if (i == 2) {
                        return ((Math.abs(p1s - p2s) >= 2) || (Math.abs(p1s - p2s) >= 2));
                    }
                    else if (p1s > p2s) {
                        if (p2.equals("federer")) {return false;}
                        p1Win++;
                    } else {
                        if (p1.equals("federer")) {return false;}
                        p2Win++;}
                    continue;
                }
                if (p1s >= 6 && Math.abs(p1s - p2s) >= 2 && p1s > p2s) {
                    if (p2.equals("federer")) {return false;}
                    p1Win++;
                }
                if (p2s >= 6 && Math.abs(p1s - p2s) >= 2 && p2s > p1s) {
                    if (p1.equals("federer")) {return false;}
                    p2Win++;
                }
            }
            return p1Win == 2 || p2Win == 2;
        } else {
            int p1Win = 0; int p2Win = 0;
            for (int i = 0; i < 2; i++) {
                String[] scores = arr[i].split(":");
                int p1s = Integer.parseInt(scores[0]); int p2s = Integer.parseInt(scores[1]);
                if (i == 1 && p1s == p2s) {return false;}
                if (p1s >= 6 && p2s >= 6) {
                    if (Math.abs(p1s - p2s) != 1  && i != 1) {
                        return false;
                    }
                    else if (p1s > p2s) {
                        if (p2.equals("federer")) {return false;}
                        p1Win++;
                    } else {
                        if (p1.equals("federer")) {return false;}
                        p2Win++;}
                    continue;
                }
                if (p1s >= 6 && Math.abs(p1s - p2s) >= 2 && p1s > p2s) {
                    if (p2.equals("federer")) {return false;}
                    p1Win++;
                }
                if (p2s >= 6 && Math.abs(p1s - p2s) >= 2 && p2s > p1s) {
                    if (p1.equals("federer")) {return false;}
                    p2Win++;
                }
            }
            return p1Win == 2 || p2Win == 2;
        }
    }
}