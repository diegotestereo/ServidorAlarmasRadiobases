package KeepAlive;

import BBDD.Conexion;

public class ClaseWriteTablaKeepAlive{
	
	int IdRadiobase;
	Conexion con;
	
	public ClaseWriteTablaKeepAlive(int IdRadiobase){
		
		this.IdRadiobase=IdRadiobase;
		
		
	}

	public void run() {
		
		
		 con=new Conexion();
		  con.Conectar();
		  con.InsertarKeepAlive(IdRadiobase);
		
	}
	
	

}
