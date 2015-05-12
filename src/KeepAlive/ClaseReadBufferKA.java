package KeepAlive;

import java.util.regex.Pattern;

import BBDD.ClaseWriteTablaEventos;
import BBDD.ClaseWriteTablaKA;

public class ClaseReadBufferKA {
	
	 private static final Pattern SPACE = Pattern.compile(" ");
	 int Radiobase,Alarma;
	 String StringAlarma;

	 String mensaje=null;
	
	public ClaseReadBufferKA(String mensaje){
		
		
		this.mensaje=mensaje;
		
		
	}
	
	
	public void run(){
		
			
		String[] arr = SPACE.split(mensaje); // str is the string to be split
		Radiobase=Integer.parseInt(arr[1]);
		Alarma=Integer.parseInt(arr[2]);
		// cuando la alarma es '1' es una keep alive.
		// caso contrario es una alarma de algun tipo.
int Alarma2=1;
		System.out.println("mensajes: "+mensaje);
		
		
	if (Alarma==Alarma2){	
		
		
		 ClaseWriteTablaKA EscribirEventoKA=new ClaseWriteTablaKA(Radiobase);
		EscribirEventoKA.escribir();
		System.out.println("Keep Alive escrito");
			
		
	}else{System.out.println("Keep Alive NO escrito");
	}
}

}
