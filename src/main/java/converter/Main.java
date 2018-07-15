package converter;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Podaj temperaturę (stopnie Celcjusza): ");
        double degree = scanner.nextDouble();

        System.out.println();
        System.out.println("Temperatura w stopniach Fahrenheita: " + Converter.celsiusToFahrenheit(degree));
    }
}
