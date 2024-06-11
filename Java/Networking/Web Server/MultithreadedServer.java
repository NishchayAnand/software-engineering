import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class ClientHandler implements Runnable {

    // Socket representing private connection between a client and the server.
    private final Socket clientSocket;

    public ClientHandler(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
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

public class MultithreadedServer {

    private static final int PORT = 8080;
    private static final int THREAD_POOL_SIZE = 4;

    private void go() throws IOException {

        // Creates an executorService object that is used for managing threads in a
        // thread pool.
        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server started on port: " + PORT);

            while (true) {
                // Accept client connection
                Socket clientSocket = serverSocket.accept();

                // Create a new thread to handle the client
                ClientHandler clientHandler = new ClientHandler(clientSocket);
                executorService.execute(clientHandler);
            }
        }

    }

    public static void main(String[] args) {

        MultithreadedServer server = new MultithreadedServer();
        server.go();

    }
}
