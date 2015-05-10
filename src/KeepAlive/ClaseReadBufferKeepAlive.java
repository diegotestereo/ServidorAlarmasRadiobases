package KeepAlive;

import java.util.regex.Pattern;

import Clases.ClaseWriteTablaEventos;

public class ClaseReadBufferKeepAlive extends Thread{
	
	 private static final Pattern SPACE = Pattern.compile(" ");
	 int Radiobase,Alarma;
	 String StringAlarma;

	 String mensaje=null;

	 ClaseWriteTablaKeepAlive EscribirKA;
	 ClaseWriteTablaEventos EscribirEvento;
		

	public ClaseReadBufferKeepAlive(String mensaje){
		
		
		this.mensaje=mensaje;
		
		
	}
	
	
	public void run(){

		System.out.println("Run ClaseReadBufferKeepAlive: Alarma: "+Alarma);
			
		String[] arr = SPACE.split(mensaje); // str is the string to be split
		Radiobase=Integer.parseInt(arr[1]);
		Alarma=Integer.parseInt(arr[2]);
		// cuando la alarma es '1' es una keep alive.
		// caso contrario es una alarma de algun tipo.
	
		if (Alarma==1){	
			
			System.out.println("KEEP ALIVE de RADIOBASE: " +Radiobase);
			EscribirKA =new ClaseWriteTablaKeepAlive(Radiobase);
			EscribirKA.start();
		
		}else{
			
			
			System.out.println("Alarma de RADIOBASE: " +Radiobase);
			EscribirEvento =new ClaseWriteTablaEventos(Radiobase,Alarma);
			EscribirEvento.start();
			
		}
		
		
		
	}
	

}


