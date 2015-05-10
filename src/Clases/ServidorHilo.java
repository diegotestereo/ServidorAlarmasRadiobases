package Clases;
import java.io.*;
import java.net.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.*;

import javax.swing.JLabel;
import javax.swing.JTextArea;

import BBDD.Conexion;

public class ServidorHilo extends Thread {
	
    private Socket socketclient;
    private DataOutputStream dos;
    private DataInputStream dis;
    Conexion Conectar;
    JTextArea TextAreaVent;
    String NombreCliente;
    BufferedReader entrada ;
    JLabel lbl;
    PrintWriter salida;
 
    ClaseReadBuffer HiloLeerBuffer;
   
    public ServidorHilo(Socket socket,JTextArea TextAreaVent, JLabel lbl) {
        this.socketclient = socket;
        this.TextAreaVent = TextAreaVent;
        this.lbl = lbl;
        
        try {
           //  NombreCliente=socketclient.getInetAddress().getHostName();
        	 entrada = new BufferedReader(new InputStreamReader(socketclient.getInputStream()));
       //   	 salida= new PrintWriter(new OutputStreamWriter(socketclient.getOutputStream()),true);
          	
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
			HiloLeerBuffer=new ClaseReadBuffer(datos);
			HiloLeerBuffer.start();
			//ThreadBufferTablaBuffer.start();
			
		//	salida.print("ok");
			 String timeStamp = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date());
		      
			 TextAreaVent.append(timeStamp+" "+datos+"\n");
		
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