

import java.io.*;
import java.net.*;
import java.util.Scanner;


public class Client  {

	@SuppressWarnings("null")
	public static void main(String[] args) throws IOException {
		
		InetAddress addr = InetAddress.getByName(null);
		System.out.println("addr = " + addr);
		Socket socket = new Socket(addr, Server.PORT);
		try {
			System.out.println("socket = " + socket);
			BufferedReader in = new BufferedReader(new InputStreamReader(
					socket.getInputStream()));
			PrintWriter out = new PrintWriter(new BufferedWriter(
					new OutputStreamWriter(socket.getOutputStream())), true);
			Scanner scanner = new Scanner(System.in);
			
			if (scanner.hasNextLine()) {
				String s = scanner.nextLine();
				out.println(s);
			}
			while(true){
				if(System.in!=null){
					System.out.println(System.in);
					break;
				}
			}
		} finally {
			System.out.println("closing ...");
			socket.close();
		}
	}
}
