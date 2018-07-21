package mockito;

class FizzBuzzManager {
    private FizzBuzz fizzBuzz;

    FizzBuzzManager(FizzBuzz fizzBuzz) {
        this.fizzBuzz = fizzBuzz;
    }

    String doFizzBuzz(int number) {
        return fizzBuzz.fizzBuzz(number);
    }
}
