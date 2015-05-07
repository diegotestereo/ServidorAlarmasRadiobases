package Clases;


public class ClaseTimerReadBBDD extends Thread{
	
	int segundos;
	boolean boolDetener=true;
	
	public  ClaseTimerReadBBDD(int segundos) {
		this.segundos=segundos;
	
	}

	public void detener(){
	 boolDetener=false;
	}

	public void run(){
		
		while(boolDetener){
		
		try {
			Thread.sleep(segundos*1000);
			System.out.print("Consulta BBDD\n");
			/////////////////////
			//tarea a realizar la consulta de la base de datos
			////////////7
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		System.out.print("Se detuvo la verga esta");
	}
	
	
}
