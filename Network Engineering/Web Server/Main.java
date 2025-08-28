import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class WebServer {
	
	private int port;
	private int maxConnections;

	protected void setPort(int port) { 
		this.port = port; 
	}
	
	public int getPort() { 
		return port; 
	}
	
	protected void setMaxConnections(int max) {
		maxConnections = max;
	}
	
	public int getMaxConnections() { 
		return maxConnections; 
	}
	
	public WebServer(int port, int maxConnections) {
		setPort(port);
		setMaxConnections(maxConnections);
	}
	
	// NOTE: We want to read and write full lines of characters, terminated by newlines, which is 
	//		 functionality provided by BufferedReader and PrintWriter.
	
	// this method can be overridden to handle different client requests: get, post, put etc.
	protected void handleConnection(Socket server) throws IOException {
		
		System.out.println("Processing the request...");
		
		BufferedReader in = new BufferedReader( new InputStreamReader(server.getInputStream()) );			
		System.out.println("Generic network server: got connection from " + 
				server.getInetAddress().getHostName() + "\n" +
				"with first line '" + in.readLine() + "'");
		
		PrintWriter out = new PrintWriter( server.getOutputStream(),true );		 
		out.println("Generic network server"); // this will give invalid http error on the browser
		
		// We can use multiple switch cases or conditional statements to handle different requests.
		// However, such kind of code quickly leads to tightly coupled and rigid software that is 
		// difficult-to-change.
		// Also, such class designs are blatant violation of the basic OOPs' concepts and the SOLID 
		// design principles – primarily the Open Close and Single Responsibility principles.
		
		server.close();
		
	}

	public void listen() {
		int i = 0;
		try(ServerSocket listener = new ServerSocket(port)) {
			Socket server; 
			while((i++ < maxConnections) || (maxConnections == 0)) {
				System.out.println("\nWaiting for connection...");
				server = listener.accept();			
				System.out.println("connection is established for "+i+"th time.");
				handleConnection(server);
			}
		} catch (IOException ioe) {
			System.out.println("IOException : " + ioe);
			ioe.printStackTrace();
		}
	} 

	public static void main(String args[]) {
		WebServer test = new WebServer(6502, 5);
		test.listen();
	}
 
}