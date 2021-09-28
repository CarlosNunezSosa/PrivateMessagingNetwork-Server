import java.net.*;
import java.io.*;
import java.util.Objects;

public class ServerThread extends Thread {
    private Socket socket;

    public ServerThread(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            InputStream input = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));

            OutputStream output = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(output, true);

            String text = "";
            while(!text.equals("Close")){
                String spacedString = "";
                for(int i=0;i<text.length();i++){
                    spacedString = spacedString + text.charAt(i)+" ";
                }
                writer.println("Server: " + spacedString);
                text = reader.readLine();
            }
            socket.close();
        } catch (IOException ex) {
            System.out.println("Server exception: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}
