import java.util.Scanner;

class Metronome {

public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Integer dur = sc.nextInt();
    float base = 4;
    float len = dur / base;
    System.out.println(Math.round(len * 100) / 100.0);
}

}
