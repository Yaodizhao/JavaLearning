package JavaCoreLearning2;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class TelnetTest {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("time-a.nist.gov", 13);
        InputStream inputStream = socket.getInputStream();
        System.out.println(inputStream);
    }
}
