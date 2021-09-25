import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class TCP_Server extends ServerSocket {

    public TCP_Server(int port) throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            while (true) {
                Socket socket = serverSocket.accept();
                new ServerThread(socket).start();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
