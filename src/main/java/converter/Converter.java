package converter;

class Converter {
    static double celsiusToFahrenheit(double c) {
        if (c < -273.15) {
            throw new UnsupportedOperationException();
        }
        return (c * 9 / 5) + 32;
    }

    static double fahrenheitToCelsius(double f) {
        if (f < -459.67) {
            throw new UnsupportedOperationException();
        }
        return (f - 32) * 5 / 9;
    }
}
