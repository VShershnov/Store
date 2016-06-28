package network;
import java.io.*;
import java.net.*;

public class ServeOneJabber extends Thread {

	public ServeOneJabber(Socket s) throws IOException {
		socket = s;
		in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		// �������� ����������� �������������
		out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(
				socket.getOutputStream())), true);
		// ���� ����-���� � ���� ������������� ������� ������� �� ����������
		// ����������, ��� ����������� ���� ������������ �� �������� ������
		// ������ ���� ����� ����
		start();// ��������� run();
	}

	public void run() {
		try {
			while (true) {
				String str = in.readLine();
				if (str.equals("END"))
					break;
				System.out.println("��� ������:" + str);
				out.println(str);
			}
			System.out.println("��������� ����� �� ������");
		} catch (IOException e) {
			System.err.println("IO Exception");
		} finally {
			try {
				socket.close();
			} catch (IOException e) {
				System.err.println("����� �� ������� ...");
			}
		}
	}

	private Socket socket;
	private BufferedReader in;
	private PrintWriter out;
}