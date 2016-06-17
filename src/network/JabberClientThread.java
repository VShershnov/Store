package network;
import java.net.*;
import java.util.Date;
import java.io.*;

class JabberClientThread extends Thread {

	public JabberClientThread(InetAddress addr) {
		System.out.println("��������� �볺�� � ������� " + id);
		threadcount++;
		try {
			socket = new Socket(addr, MultiJabberServer.PORT);
		} catch (IOException e) {
			System.err.println("�� ������� �'�������� � ��������");
			// ���� �� ������� �������� ����� �����
			// �� ������� �������
		}
		try {
			in = new BufferedReader(new InputStreamReader(
					socket.getInputStream()));

			out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(
					socket.getOutputStream())), true);
			start();
		} catch (IOException e) {
			// ����� �� ���� �������� ��� ���� ��� �������
			// ��� ������� ������������ ������
			try {
				socket.close();
			} catch (IOException e2) {
				System.err.println("����� �� �������");
			}
		}
		// ���� ��� ���������� ��������� ����� ���� �������
		// � ����� run() ������.
	}

	public static int threadCount() {
		return threadcount;
	}

	public void run() {
		try {
			for (int i = 0; i < 5; i++) {
				out.println("Client " + id + ": " + i + " ��� ��������: "
						+ new Date().getTime());
				String str = in.readLine();
				System.out.println(str + " ��� ���������: "
						+ new Date().getTime());
			}
			out.println("END");
		} catch (IOException e) {
			System.err.println("IO Exception");
		} finally {
			// ������ �������:
			try {
				socket.close();
			} catch (IOException e) {
				System.err.println("Socket not closed");
			}
			// threadcount--; // ��������� ��� ����
		}
	}

	private Socket socket;
	private BufferedReader in;
	private PrintWriter out;
	private static int counter = 0;
	private int id = counter++;
	private static int threadcount = 0;
}