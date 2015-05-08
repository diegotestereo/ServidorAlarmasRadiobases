package Clases;

import java.util.regex.Pattern;

import BBDD.Conexion;

public class ClaseWriteTablaBuffer extends Thread{
	private static final Pattern SPACE = Pattern.compile(" ");
	String buffer;
	Conexion con;
	
	public ClaseWriteTablaBuffer(String datos) {
		
		this.buffer=datos;
		
	
	}



	public void run(){
		
		String[] arr = SPACE.split(buffer); // str is the string to be split
		int Radiobase, Alarma;
		
		Radiobase=Integer.parseInt(arr[1]);
		Alarma=Integer.parseInt(arr[2]);
	    con=new Conexion();
		  con.Conectar();
		  con.InsertarEventos(Radiobase, Alarma);
		
		
		
	}
	
	
}