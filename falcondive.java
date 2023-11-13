/*
 * Yeo Shu Heng A0252611R
 * */
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;

public class falcondive {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt(); int n = sc.nextInt(); Character c = sc.next().charAt(1);
        sc.nextLine();
        String[] pic1 = new String[m];
        for (int i = 0; i < m; i++) {
            pic1[i] = sc.nextLine();
        }
        sc.nextLine();
        String[] pic2 = new String[m];
        for (int i = 0; i < m; i++) {
            pic2[i] = sc.nextLine();
        }

        int[] c1 = new int[]{0 , 0}; int[] c2 = new int[]{0, 0};
        boolean seen1 = false; boolean seen2 = false;
        mainloop:
        for (int line = 0; line < m; line++) {
            for (int pixel = 0; pixel < n; pixel++) {
                Character ch1 = pic1[line].charAt(pixel);
                Character ch2 = pic2[line].charAt(pixel);
                if (ch1.equals(c) && !seen1) {
                    c1 = new int[]{line, pixel};
                    seen1 = true;
                }
                if (ch2.equals(c) && !seen2) {
                    c2 = new int[]{line, pixel};
                    seen2 = true;
                }
                if (seen1 == true && seen2 == true) {
                    break mainloop;}
            }
        }

        if (seen2 == false) {
            for (String s : pic2) {
                System.out.println(s);
            }
            return;
        }

        int[] shift = new int[]{c2[0] - c1[0], c2[1] - c1[1]};
        ArrayList<int[]> pic2_bird_coord = new ArrayList<>();
        String[] newImg = new String[m];
        for (int line = 0; line < m; line++) {
            String currLine = "";
            for (int pixel = 0; pixel < n; pixel++) {
                Character ch1_ = pic1[line].charAt(pixel);
                Character ch2_ = pic2[line].charAt(pixel);
                if (ch2_.equals(c)) {
                    int[] pic2bird = new int[]{line, pixel};
                    pic2_bird_coord.add(pic2bird);
                }
                if (ch1_.equals(ch2_)) {
                    currLine += pic1[line].charAt(pixel);
                }
                else if (ch1_.equals(c)) {
                    currLine += pic2[line].charAt(pixel);
                } else {
                    currLine += pic1[line].charAt(pixel);
                }
            }
            newImg[line] = currLine;
        }

        for (int[] bird : pic2_bird_coord) {
            int x_shift = bird[0] + shift[0]; int y_shift = bird[1] + shift[1];
            if (x_shift < m && y_shift < n && x_shift >= 0 && y_shift >= 0) {
                String cst = newImg[x_shift];
                newImg[x_shift] = cst.substring(0, y_shift) + c + cst.substring(y_shift + 1, cst.length());
            }
        }
        for (String x : newImg) {
            System.out.println(x);
        }
        System.out.println("");
    }
}
