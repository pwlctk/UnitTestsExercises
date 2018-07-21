package mockito;

import org.mockito.Mockito;
import stringCalculator.StringCalculator;

public class Main {
    public static void main(String[] args) {
        StringCalculator mock = Mockito.mock(StringCalculator.class);
        Mockito.when(mock.add("5,5")).thenReturn(10);
        Mockito.when(mock.add("100")).thenReturn(100);
        System.out.println(mock.add("5,5"));
        System.out.println(mock.add("100"));
    }
}
