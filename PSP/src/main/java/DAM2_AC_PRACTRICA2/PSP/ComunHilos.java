package DAM2_AC_PRACTRICA2.PSP;


import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Arrays;

public class ComunHilos {
	
	 int MAX_CONEXIONES;
	 int	 conexionesTotales;
	private Socket miLista[];
	 String mensajes="";
	 
	public ComunHilos(int mAX_CONEXIONES) {
	
		this.MAX_CONEXIONES = mAX_CONEXIONES;
		miLista= new Socket[MAX_CONEXIONES];
		
		
	}
	

	public Socket[] getMiLista() {
		return miLista;
	}




	public int getConexionesTotales() {
		return conexionesTotales;
	}

	

	public void setMensajes(String mensajes) {
		this.mensajes = mensajes;
	}

	public String getMensajes() {
		
		
		
		return mensajes;
	}

	public synchronized void anadirMensaje(String mensaje, String nombreUsuario) throws IOException {
		String mensajeConUsuario=nombreUsuario+": "+mensaje;
		mensajes+=mensajeConUsuario +"\n";
		
		for(int i=0;i<conexionesTotales;i++) {
			System.out.println(mensajeConUsuario);
		}
		
	}

		
public synchronized  void anidirConex(Socket miCliente) throws IOException{
	
	
        
		
		miLista[conexionesTotales]= miCliente;
		conexionesTotales++;
        System.out.println("Se ha unido un usuario, ahora hay " + conexionesTotales);
        System.out.println(mensajes);
   

 
	
	
	}



	
}




