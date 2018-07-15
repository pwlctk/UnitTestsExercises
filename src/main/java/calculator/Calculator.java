package calculator;

class Calculator {
    int add(int a, int b) {
        return a + b;
    }
    int parse(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Niepoprawny numer");
        }
    }
}
