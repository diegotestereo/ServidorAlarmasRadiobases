package KeepAlive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;


public class KeepAliveHilo extends Thread {
	Socket socketclient;
	int Puerto;
	String NombreCliente;
	BufferedReader entrada ;
	ClaseReadBufferKeepAlive HiloLeerBuffer;
	
	
	public KeepAliveHilo(Socket socket){
		//this.Puerto=Puerto;
		this.socketclient=socket;
		   try {
	            // NombreCliente=socketclient.getInetAddress().getHostName();
	        	 entrada = new BufferedReader(new InputStreamReader(socketclient.getInputStream()));
	          //	 salida= new PrintWriter(new OutputStreamWriter(socketclient.getOutputStream()),true);
	          	
	        } catch (IOException ex) {
	            
	        }
	    }
	 public void desconnectar() {
	        try {
	        	socketclient.close();
	        } catch (IOException ex) {
	           
	        }
		
		
	}
	 
	 
	 public void run() {
   	  String datos;
		try {
			datos = entrada.readLine();
		//	ThreadBufferTablaBuffer=new ClaseWriteTablaEventos(datos);
			HiloLeerBuffer=new ClaseReadBufferKeepAlive(datos);
			HiloLeerBuffer.start();
			//ThreadBufferTablaBuffer.start();
			
		//	salida.print("ok");
	///		 String timeStamp = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date());
		      
	//		 TextAreaVent.append(timeStamp+" "+datos+"\n");
		
		     if (datos==null){
		       	//socketclient.close();
		               
		           }else{
		             System.out.println(datos);
		              
		           }
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}// bloqueante
         
    
       
       desconnectar();
   }
	

}
