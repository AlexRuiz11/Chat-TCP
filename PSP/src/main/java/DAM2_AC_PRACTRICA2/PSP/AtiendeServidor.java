package DAM2_AC_PRACTRICA2.PSP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class AtiendeServidor extends Thread {
	
	 Socket socket;
	 String nombre;
	 String mensaje;
	DataOutputStream salida ;

	 Scanner teclado = new Scanner(System.in);



	public AtiendeServidor(Socket socket,String nombre) throws IOException {
		
		this.socket=socket;		
		this.nombre=nombre;
	
		salida= new DataOutputStream(socket.getOutputStream());

		
		
	}
	
	
	@Override	
	public void run () 
	{
			
		   try {

			DataInputStream entrada = new DataInputStream(socket.getInputStream());
			
			while(true) {
				
			
			System.out.println("Escriba el mensaje: ");
			mensaje= teclado.nextLine();
			if(mensaje.equals("*")) {
				entrada.close();
				salida.close();
				break;

			}
			salida.writeUTF(mensaje  +"\n");
			 
		String mensajeDelServidor = entrada.readUTF();
			System.out.println(mensajeDelServidor);
			
			
			
			
		   }
		} catch (IOException e) {
			// TODO Auto-generated catch block
		}
		  
		   
                 
	 
	}
	
	
	

}
