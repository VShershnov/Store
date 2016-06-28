package network;
import java.io.*;
import java.net.*;

public class MultiJabberServer {

	static final int PORT = 8081;

	public static void main(String[] args) throws IOException {
		ServerSocket s = new ServerSocket(PORT);
		System.out.println("������ ��������.");

		try {
			while (true) {
				Socket socket = s.accept();
				try {
					new ServeOneJabber(socket);
				} catch (IOException e) {
					// � ��� ������� ��������� �����
					socket.close();
				}
			}
		} finally {
			s.close();
		}
	}
}