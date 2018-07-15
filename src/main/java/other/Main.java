package other;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {

    private static String greet = "ABCDEFGHIJKLMNOPRSTUWZ";

    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Podaj liczbę: ");
            int elo = scanner.nextInt();
            for (int i = 0; i < elo; i++) {
                StringBuilder sb = new StringBuilder();
                int len = new Random().nextInt(greet.length());
                for (int j = 0; j < len; j++) {
                    sb.append(greet.charAt(new Random().nextInt(greet.length())));
                }
                strings.add(sb.toString());
            }
            int remove = new Random().nextInt(elo);
            for (int i = 0; i < remove; i++) {
                strings.remove(new Random().nextInt(strings.size()));
            }
        }
    }
}
