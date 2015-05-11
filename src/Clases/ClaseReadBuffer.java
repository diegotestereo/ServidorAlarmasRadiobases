package Clases;

import java.util.regex.Pattern;

import KeepAlive.*;

public class ClaseReadBuffer {
	
	
	 private static final Pattern SPACE = Pattern.compile(" ");
	 int Radiobase,Alarma;
	 String StringAlarma;

	 String mensaje=null;
	 ClaseWriteTablaEventos EscribirEvento;
	
	public ClaseReadBuffer(String mensaje){
		
		
		this.mensaje=mensaje;
		
		
	}
	
	
	public void run(){
		
			
		String[] arr = SPACE.split(mensaje); // str is the string to be split
		Radiobase=Integer.parseInt(arr[1]);
		Alarma=Integer.parseInt(arr[2]);
		// cuando la alarma es '1' es una keep alive.
		// caso contrario es una alarma de algun tipo.

		System.out.println("Alarma: "+Alarma);
		
		
	if (Alarma==1){	
		
		System.out.println("KEEP ALIVE de RADIOBASE: " +Radiobase);
		
	}else{
		
		
		System.out.println("Alarma de RADIOBASE: " +Radiobase);
		EscribirEvento =new ClaseWriteTablaEventos(Radiobase,Alarma);
		EscribirEvento.run();
		
	}

}
}