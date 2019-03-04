package erg2;

import java.io.*;
import java.net.*;

public class example2_Client {

	public static void main(String[] args) {
		new example2_Client().startClient();
	}

	public void startClient() {
		Socket requestSocket = null;
		ObjectOutputStream out = null;
		ObjectInputStream in = null;
		String message;
		try {

			requestSocket=new Socket(InetAddress.getByName("127.0.0.1"),4234);
			out = new ObjectOutputStream(requestSocket.getOutputStream());
			in = new ObjectInputStream(requestSocket.getInputStream());
			out.writeUTF("Hi");
			out.flush();

			out.writeObject(new Message(101,"testData"));
			out.flush();


		} catch (UnknownHostException unknownHost) {
			System.err.println("You are trying to connect to an unknown host!");
		} catch (IOException ioException) {
			ioException.printStackTrace();
		} finally {
			try {
				in.close();
				out.close();
				requestSocket.close();
			} catch (IOException ioException) {
				ioException.printStackTrace();
			}
		}
	}
}
