package calculator;

public class CalculatorSinus {
    public float sinus(int cathetus, int hypotenuse) {
        if (hypotenuse <= 0 || cathetus <= 0){
            throw new IllegalArgumentException("Negative and zero values are not allowed!");
        }
            if (hypotenuse < cathetus) {
                throw new IllegalArgumentException();
            }
        return (float) cathetus / hypotenuse;
    }
}
