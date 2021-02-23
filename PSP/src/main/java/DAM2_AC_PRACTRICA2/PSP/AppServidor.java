package DAM2_AC_PRACTRICA2.PSP;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class AppServidor {
	static final int PUERTO = 4444;

	public static void main(String[] args) throws IOException {
		
		
		
		 ServerSocket servidor = new ServerSocket(PUERTO);
		    System.out.println("Escuchando en el puerto " + PUERTO + " ...");
			ComunHilos comunhilos= new ComunHilos(10);
		    // Esperamos a la primera petición de conexión que venga y la aceptamos
		    while(true) {
		    Socket socketTcp = servidor.accept();
		    DataOutputStream salida = new DataOutputStream(socketTcp.getOutputStream());	
			

		    comunhilos.anidirConex(socketTcp);
		    salida.writeUTF(comunhilos.getMensajes());

		    new AtiendeCliente(socketTcp, comunhilos).start();

		

	  
		  
		    // Leemos un mensaje y devolvemos el mismo mensaje
		   
		     
		 //   System.out.println("Recibido mensaje del cliente: " + mensajeDelCliente);
		 
          
			}
		

		
	}
	
	

}
