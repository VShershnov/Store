


import java.io.*;
import java.net.*;

public class Server {
	public static final int PORT = 8081;

	public static void main(String[] args) throws IOException {
		ServerSocket s = new ServerSocket(PORT);
		System.out.println("Запущено: " + s);
		try {
			Socket socket = s.accept();
			try {
				System.out.println("Відкрили з'єднання: " + socket);
				BufferedReader in = new BufferedReader(new InputStreamReader(
						socket.getInputStream()));
				PrintWriter out = new PrintWriter(new BufferedWriter(
						new OutputStreamWriter(socket.getOutputStream())), true);
				while (true) {
					if(System.in!=null){	
					System.out.println(System.in);
					out.println("132");
					break;
					}
				}
				out.println("END");

			} finally {
				System.out.println("closing...");
				socket.close();
			}
		} finally {
			s.close();
		}
	}
}
