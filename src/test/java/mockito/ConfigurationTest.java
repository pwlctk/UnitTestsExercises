package mockito;

import org.junit.jupiter.api.Test;
import java.io.BufferedReader;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


//Niby odczytuje plik za pomocą klasy Configuration, ale dzięki Mockito nie musimy tak naprawdę odczytywać pliku
//tylko możemy podać na sztywno wartości
class ConfigurationTest {
    @Test
    void shouldNotReadTheFile() throws IOException {
        // given
        BufferedReader mock = mock(BufferedReader.class);
        when(mock.readLine())
                .thenReturn("Linia 1")
                .thenReturn("Linia 2")
                .thenReturn("Linia 3")
                .thenReturn(null);
        Configuration configuration = new Configuration();
        // when
        String result = configuration.readConfiguration(mock);
        // then
        assertEquals("Linia 1\nLinia 2\nLinia 3\n", result);
    }

}