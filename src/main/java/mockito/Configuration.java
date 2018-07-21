package mockito;

import java.io.BufferedReader;
import java.io.IOException;

public class Configuration {
    public String readConfiguration(BufferedReader reader) throws IOException {


        String line;
        StringBuilder stringBuilder = new StringBuilder();
        while((line = reader.readLine()) != null){
            stringBuilder.append(line).append('\n');
        }

        return stringBuilder.toString();
    }
}
