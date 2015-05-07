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
		        	//  System.out.println("Esperando cliente: "+continuar);
		        	  Socket socketclient;
		        	  socketclient = sk.accept();// se queda a la espera de un cliente
		           //   System.out.println("Ingreso Cliente");
		                ((ServidorHilo) new ServidorHilo(socketclient,jTextAreaVent)).start();
		          
		         }
		   } catch (IOException e) {
		          System.out.println("mensajito: "+e);
		         
		   }
    	
    
    }
    }
