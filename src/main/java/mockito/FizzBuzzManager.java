package mockito;

public class FizzBuzzManager {
    private FizzBuzz fizzBuzz;

    public FizzBuzzManager(FizzBuzz fizzBuzz) {
        this.fizzBuzz = fizzBuzz;
    }

    public String doFizzBuzz(int number) {
        return fizzBuzz.fizzBuzz(number);
    }
}
