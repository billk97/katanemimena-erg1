package erg2;

import java.io.*;
import java.net.*;

public class example2_Server {
	//otan sisndeetai enas client dimioyrgite ena neo thread me kainoyrio socket
	//inetAdress
	//tha stelnei kanonika o client kai sto serverSocket kai tha epistrefei ena socket kai tha sikonei neo thread
	//stream input output streams
	//input gia na akoyme
	//output gia na stelnoyme
	//output---> input
	//yparxoyn data/object input/output streams\
	//object gia thn ergasia
	public static void main(String[] args) {
		new example2_Server().openServer();
	}

	public void openServer() {
		ServerSocket providerSocket = null;
		Socket connection = null;
		String message = null;
		try {


		} catch (IOException ioException) {
			ioException.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				providerSocket.close();
			} catch (IOException ioException) {
				ioException.printStackTrace();
			}
		}
	}
}
