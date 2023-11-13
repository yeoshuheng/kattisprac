import java.io.IOException;
import java.io.InputStreamReader;

import java.io.BufferedReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class jobswitch {

    private static int swaps = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(sc.readLine());
        String[] arr_ = sc.readLine().split(" ");
        int[] arr = new int[arr_.length];
        boolean[] visit = new boolean[arr_.length];
        for (int i = 0; i < arr_.length; i++) {
            visit[i] = false;
            arr[i] = Integer.parseInt(arr_[i]) - 1;
        }
        int swaps = 0;
        for (int i = 0; i < arr.length; i++) {
            if (!visit[i]) {
                visit[i] = true;
                int curr = i;
                while (!visit[arr[curr]]) {
                    swaps++;
                    curr = arr[curr];
                    visit[curr] = true;
                }
            }
        }
        System.out.println(swaps);
    }
}


