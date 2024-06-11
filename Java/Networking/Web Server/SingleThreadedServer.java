import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

class ClientHandler {

    // Socket representing private connection between a client and the server.
    private final Socket clientSocket;

    public ClientHandler(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    public void handleRequest() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter writer = new PrintWriter(clientSocket.getOutputStream())) {

            // Read request from client
            String request = reader.readLine();
            System.out.println("Received request: " + request);

            // Simulate processing the request (replace with actual logic)
            String response = "Hello World from the Multithreaded Server!";

            // Send response to client
            writer.println(response);
            writer.flush();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

public class SingleThreadedServer {

    private static final int PORT = 8080;

    public void go() {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {

            System.out.println("Server started on port: " + PORT);

            while (true) {
                // Accept client connection
                Socket clientSocket = serverSocket.accept();
                // Handle the client
                ClientHandler clientHandler = new ClientHandler(clientSocket);
                clientHandler.handleRequest();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        SingleThreadedServer server = new SingleThreadedServer();
        server.go();

    }

}