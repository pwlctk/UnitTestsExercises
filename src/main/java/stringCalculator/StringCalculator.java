package stringCalculator;

public class StringCalculator {

    public int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        } else if (numbers.length() > 1) {
            int sum = 0;
            String[] onlyNumbers;
            String delimiter = "[,\n]";

            if (numbers.substring(0, 2).equals("//")) {
                String[] delimiterAndNumbers = numbers.split("\n");
                delimiter = delimiterAndNumbers[0].substring(2);
                onlyNumbers = delimiterAndNumbers[1].split(delimiter);
            } else {
                onlyNumbers = numbers.split(delimiter);
            }
            //Sprawdzam każdą liczbę czy jest ujemna
            StringBuilder negativeNumbers = new StringBuilder();
            for (String onlyNumber : onlyNumbers) {
                if (Integer.parseInt(onlyNumber) < 0) {
                    negativeNumbers.append(onlyNumber).append(",");
                }
            }
            if (negativeNumbers.length() != 0) {
                //usywam ostatni przecinek
                negativeNumbers.deleteCharAt(negativeNumbers.length() - 1);
                throw new IllegalArgumentException(negativeNumbers.toString());
            }
            sum = getSum(sum, onlyNumbers);
            return sum;
        }
        return Integer.parseInt(numbers);
    }

    private int getSum(int sum, String[] onlyNumbers) {
        for (String onlyNumber : onlyNumbers) {
            sum += Integer.parseInt(onlyNumber);
        }
        return sum;
    }
}
