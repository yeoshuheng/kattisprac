import java.util.*;
import java.util.Stack;
import java.util.Set;

class bookshelves {

    private static int shelfWidth;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt(); int b = sc.nextInt(); int c = sc.nextInt();
        shelfWidth = sc.nextInt();
        int ret = Integer.MAX_VALUE;

        boolean[][][][][] seen = new boolean[a + 1][b + 1][c + 1][shelfWidth + 1][a + b + c + 1];
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                for (int h = 0; h < c; h++) {
                    for (int w = 0; w < shelfWidth; w++) {
                        for (int u = 0; u < a + b + c; u++) {
                            seen[i][j][h][w][u] = false;
                        }
                    }
                }
            }
        }

        Stack<int[]> stk = new Stack<>();
        stk.push(new int[]{a, b, c, shelfWidth, 1});
        while (!stk.empty()){
            int[] curr = stk.pop();

            int a_ = curr[0]; int b_ = curr[1]; int c_ = curr[2];
            int shelveWidth_ = curr[3]; int used_ = curr[4];
            if (seen[a_][b_][c_][shelveWidth_][used_]) {
                continue;
            }
            if (a_ == 0 && c_ == 0 && b_ == 0) {
                ret = Math.min(ret, used_);
                continue;
            }
            if (shelveWidth_ < 0) {
                continue;
            }

            if (b_ == 0 && c_ == 0 && a_ > 0) {
                if (a_ <= shelveWidth_) {
                    ret = Math.min(ret, used_);
                    continue;
                } else {
                    stk.push(new int[]{a_ - shelveWidth_, b_, c_, shelfWidth, used_ + 1});
                    continue;
                }
            }

            for (int i = 0; i < 3; i++) {
                if (curr[i] > 0) {
                    if (shelveWidth_ >= i + 1) {
                        int[] newCurr = new int[]{a_, b_, c_, shelveWidth_, used_};
                        newCurr[i]--;
                        newCurr[3] -= (i + 1);
                        stk.push(newCurr);
                    } else {
                        int[] newCurr = new int[]{a_, b_, c_, shelveWidth_, used_};
                        newCurr[i]--;
                        newCurr[3] = shelfWidth - 1 - i;
                        newCurr[4] += 1;
                        stk.push(newCurr);
                    }
                }
            }
            seen[a_][b_][c_][shelveWidth_][used_] = true;
        }
        System.out.println(ret);
    }

}
