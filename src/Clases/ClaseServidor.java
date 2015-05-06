package Clases;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JTextArea;

import Ventanas.ventana_Principal;

public class ClaseServidor extends Thread {

    ServerSocket sk = null;
    Socket socketclient;
    JTextArea jTextAreaVent;
	String NombreCliente;
	boolean BoolCliente=true;
	int Puerto;
   
    boolean continuar = true;
   // hiloCliente hilclient;
    // constructor y parametro
    public ClaseServidor(int Puerto,JTextArea jTextAreaVent) {
        this.Puerto=Puerto;
        this.jTextAreaVent=jTextAreaVent;
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
	                 jTextAreaVent.setText("************    ServidorMulticliente      ***********\n");
	                 jTextAreaVent.append("************    IP: "+InetAddress.getLocalHost().getHostAddress()+":"+Puerto+"     **********\n");
	                 jTextAreaVent.append("*****************************************************\n");
	                 System.out.println();
		          while (continuar) { 
		        	  System.out.println("Esperando cliente: "+continuar);	              
		              socketclient = sk.accept();// se queda a la espera de un cliente
		              System.out.println("Ingreso Cliente");
		              
		              try {
		              	
		              	NombreCliente=socketclient.getInetAddress().getHostName();
		                  System.out.println("Connected to client : "+NombreCliente);
		                  jTextAreaVent.append("Connected to client : "+NombreCliente+"\n");
		                  
		                  do{
		                  	//lee o que envia el cliente
		                  	BufferedReader entrada = new BufferedReader(new InputStreamReader(socketclient.getInputStream()));
		                  	// escribe la salida del servidor
		                  	PrintWriter salida= new PrintWriter(new OutputStreamWriter(socketclient.getOutputStream()),true);
		                      
		                  	//formatea el dato de entrada o caste a aString
		                  	
		                  	 System.out.println(" String datos = entrada.readLine();");
		                  	 jTextAreaVent.append("A la espera de datos del cliente: "+NombreCliente+"\n");
				               
		                  	   String datos = entrada.readLine();// bloqueante
		                    
		                      if (datos==null){
		                      	 System.out.println(NombreCliente+"Cerro la conexion");
		                      	 jTextAreaVent.append(NombreCliente+"Cerro la conexion");
		                      	 BoolCliente=false;
		                           
		                       }else{
		                      //  System.out.println("Dispositivo '"+ NombreCliente+"' : "+datos);
		                        System.out.println(datos);
		                        
		                        salida.println("Servidor -> "+NombreCliente+" : "+datos);
		                        jTextAreaVent.append("Servidor->"+NombreCliente+" : "+datos+"\n");
				                 
		                       }
		                       
		                       }while(BoolCliente);//cuando el clientees
		              } catch (Exception e) {
		            	  jTextAreaVent.append("Servidor Cerrado\n");
		                  System.err.println("mensajito : "+e.getMessage());
		                  BoolCliente=false;
		              }
			        	
		            	  
		              
		          }
		   } catch (IOException e) {
		          System.out.println("mensajito: "+e);
		         
		   }
    	
    
    }
    }
