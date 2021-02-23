package DAM2_AC_PRACTRICA2.PSP;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class AppCliente {
	static final String IP = "localhost";
	static final int PUERTO = 4444;
	
	public static void main(String[] args) throws IOException {
		 Scanner teclado = new Scanner(System.in);
		 String nombre;
		Socket socket;
		
		
		 socket= new Socket(IP,PUERTO);
		 
		   DataInputStream entrada = new DataInputStream(socket.getInputStream());
		 System.out.println("Nombre del cliente: ");
		 nombre= teclado.nextLine();

		  String mensaje= entrada.readUTF();

		    System.out.println(mensaje);
		new AtiendeServidor(socket,nombre).start();
		
	
		    
	}
	
	
}

