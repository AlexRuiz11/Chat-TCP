package DAM2_AC_PRACTRICA2.PSP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class AtiendeCliente extends Thread {
	Socket socket;
	DataInputStream entrada;
	 ComunHilos comunhilos;

	public AtiendeCliente(Socket socket, ComunHilos comunhilos) throws IOException{
		
		this.socket=socket;		
		this.comunhilos=comunhilos;
		
		

	}
	
	
	@Override	
	public void run () 
	{  
			
    
		    String mensajeDelCliente;

			try {
				DataInputStream entrada = new DataInputStream(socket.getInputStream());
			    DataOutputStream salida = new DataOutputStream(socket.getOutputStream());

			    while(true){
			    // Leemos un mensaje y devolvemos el mismo mensaje
			     mensajeDelCliente = entrada.readUTF();
			   
			 
			     comunhilos.anadirMensaje(mensajeDelCliente,getName());
			     
			 //   System.out.println("Recibido mensaje del cliente: " + mensajeDelCliente);
			    salida.writeUTF(comunhilos.getMensajes());
			    }

			} catch (IOException e) {
				// TODO Auto-generated catch block
			}
      	 	
      	
      	 	
    	}
		
		   
                 
	 
	}
	
	


