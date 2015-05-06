package Clases;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ClaseServidor extends Thread {
     ServerSocket sk = null;
    Socket socketclient;

	String NombreCliente;
	boolean BoolCliente=true;
	int Puerto;
   
    boolean continuar = true;
   // hiloCliente hilclient;
    // constructor y parametro
    public ClaseServidor(int Puerto) {
        this.Puerto=Puerto;
    }
    
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
		        	  System.out.println("Esperando cliente"+continuar);	              
		              socketclient = sk.accept();// se queda a la espera de un cliente
		              System.out.println("Ingreso Cliente");
		              
		              try {
		              	
		              	NombreCliente=socketclient.getInetAddress().getHostName();
		                  System.out.println("Connected to client : "+NombreCliente);
		                  
		                  do{
		                  	//lee o que envia el cliente
		                  	BufferedReader entrada = new BufferedReader(new InputStreamReader(socketclient.getInputStream()));
		                  	// escribe la salida del servidor
		                  	PrintWriter salida= new PrintWriter(new OutputStreamWriter(socketclient.getOutputStream()),true);
		                      
		                  	//formatea el dato de entrada o caste a aString
		                  	
		                  	 System.out.println(" String datos = entrada.readLine();");
		                      String datos = entrada.readLine();// bloqueante
		                    //  System.out.println("datos: "+datos);
		      	         
		                      if (datos==null){
		                      	// System.out.println("dato nulo");
		                      	 BoolCliente=false;
		                           
		                       }else{
		                      //  System.out.println("Dispositivo '"+ NombreCliente+"' : "+datos);
		                        System.out.println(datos);
		                        
		                        salida.println("Servidor -> "+NombreCliente+" : "+datos);
		                       }
		                       
		                       }while(BoolCliente);//cuando el clientees
		              } catch (Exception e) {
		                  System.err.println(e.getMessage());
		                  BoolCliente=false;
		              }
			        	
		            	  
		              
		          }
		   } catch (IOException e) {
		          System.out.println(e);
		          System.out.println("IOException"+continuar);
		        
		   }
    	
    
    }
    }
