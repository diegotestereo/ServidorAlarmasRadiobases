package Clases;



import BBDD.Conexion;

public class ClaseWriteTablaEventos extends Thread{

	Conexion con;
	int Radiobase,Alarma;
	
	public ClaseWriteTablaEventos(int Radiobase,int Alarma) {
		
		this.Alarma=Alarma;
		this.Radiobase=Radiobase;
		
	
	}



	public void run(){
		
	    con=new Conexion();
		  con.Conectar();
		  con.InsertarEventos(Radiobase, Alarma);
		
		
		
	}
	
	
}