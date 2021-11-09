import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


public class Client {
    BufferedReader input;
    PrintWriter output;

    public Client(int x) {
        System.out.println("starting client");
        try (Socket socket = new Socket("localhost", 5000)){
            System.out.println("Connected to server");
            input = new BufferedReader( new InputStreamReader(socket.getInputStream()));
            output = new PrintWriter(socket.getOutputStream(),true);


            ClientRunnable clientRun = new ClientRunnable(socket);

            new Thread(clientRun).start();
            while (true) {}

        } catch (Exception e) {
            System.out.println("Exception occured in client main: " + e.getStackTrace());
    }
    }

    public void SendMessage(String json) {
        output.println(json);
    }
}
