package Clases;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class ClaseBufferAlarma extends Thread{
	
	String buffer;
	JPanel panel;
	 JLabel lbl;
	
	public  ClaseBufferAlarma(String buffer,JPanel panel, JLabel lbl){
			
		this.buffer=buffer;
		this.panel=panel;
		this.lbl=lbl;
	}

	
	
	public void run(){
		
		System.out.println("algo llegoooooooo");
		lbl.setText("ALARMA LA CONCHA DE TU MADRE !!!");
		
	}
	
	
}
