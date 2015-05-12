package KeepAlive;

import java.util.regex.Pattern;

import BBDD.ClaseWriteTablaEventos;
import BBDD.ClaseWriteTablaKA;

public class ClaseReadBufferKA {
	
	 private static final Pattern SPACE = Pattern.compile(" ");
	 int Radiobase,Alarma;
	 String StringAlarma;

	 String mensaje=null;
	 ClaseWriteTablaKA EscribirEvento;
	
	public ClaseReadBufferKA(String mensaje){
		
		
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
		EscribirEvento=new ClaseWriteTablaKA(Radiobase);
		EscribirEvento.escribir();
		
		
	}else{
		System.out.println("KEEP ALIVE Erroneo");
		EscribirEvento=new ClaseWriteTablaKA(Radiobase);
		EscribirEvento.escribir();
		
		
	}
}

}
