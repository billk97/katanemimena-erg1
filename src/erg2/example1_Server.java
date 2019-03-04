package erg2;

import java.io.*;
import java.net.*;

public class example1_Server {

	public static void main(String[] args) {
		new example1_Server().openServer();
	}

	public void openServer() {
		ServerSocket providerSocket = null;
		Socket connection = null;
		String message = null;
		try {
			providerSocket = new ServerSocket(4321);

			while (true) {
			    //dimiourgoume ena object gia kathe client anigi kainoyrio socket
				connection = providerSocket.accept();
				//gia na steiloyme ena antikimeno
				ObjectOutputStream out = new ObjectOutputStream(connection.getOutputStream());
				ObjectInputStream in = new ObjectInputStream(connection.getInputStream());
				out.writeObject("conenection Succerful");
				//oti exie mazeytei to buffer stelto
				out.flush();

				do {
					try {
					    //casting se string
					    message=(String) in.readObject();
					    //epistrefei thn ip
					    System.out.println(connection.getInetAddress().getHostAddress()+" > "+ message);

					} catch (ClassNotFoundException classnot) {
						System.err.println("Data received in unknown format");
					}
				} while (!message.equals("bye"));
				//prosoxi klinoyme sockets
				in.close();
				out.close();
				//prosoxi klinoyme to conection
				connection.close();
			}
		} catch (IOException ioException) {
			ioException.printStackTrace();
		} finally {
			try {
				providerSocket.close();
			} catch (IOException ioException) {
				ioException.printStackTrace();
			}
		}

	}
}
