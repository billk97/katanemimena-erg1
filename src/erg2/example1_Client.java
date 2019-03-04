package erg2;

import java.io.*;
import java.net.*;

public class example1_Client {

	public static void main(String[] args) {
		new example1_Client().startClient();
	}

	public void startClient() {
		Socket requestSocket = null;
		ObjectOutputStream out = null;
		ObjectInputStream in = null;
		String message;
		try {
			requestSocket = new Socket(InetAddress.getByName("172.16.2.13"),4321);
			out = new ObjectOutputStream(requestSocket.getOutputStream());
			in = new ObjectInputStream(requestSocket.getInputStream());

			try {
				message = (String)in.readObject();
				System.out.println("Server> "+ message);
				out.writeObject("Hi");
				out.flush();
				out.writeObject("jyust Testing: ");
				out.flush();
				out.writeObject("bye");
				out.flush();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}


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
