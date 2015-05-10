package KeepAlive;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ClaseKeepAliveServer extends Thread  {
	
	   ServerSocket sk = null;
	boolean continuar;
	String NombreCliente;
	boolean BoolCliente=true;
	static final int Puerto=9002;
   
	
	
	   public void StopServer(){
	    	  continuar = false;
	    	  try {
				sk.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	    public void run() {
	    	
			   try {
			         sk = new ServerSocket(Puerto);
			         System.out.println();  
		        	 System.out.println("*****************************************************");
				     System.out.println("************    ServidorMulticliente      ***********");
		             System.out.println("************    IP: "+InetAddress.getLocalHost().getHostAddress()+":"+Puerto+"     **********");
		             System.out.println("*****************************************************");
		             System.out.println();
		         
			         
		             while (continuar) { 
			        	  System.out.println("Esperando cliente KA: "+continuar);
			        	  Socket socketclient;
			        	  socketclient = sk.accept();// se queda a la espera de un cliente
			             System.out.println("Ingreso Cliente KA");
			                ((KeepAliveHilo) new KeepAliveHilo(socketclient)).start();
			          
			         }
			   } catch (IOException e) {
			          System.out.println("El Puerto se encuentra ocupado");
			          
			            
			          
			          
			         
			   }
	    	
	    
	    
	    }

}
