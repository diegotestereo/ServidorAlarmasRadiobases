package Clases;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class ClaseBufferAlarma extends Thread{
	
	String buffer;
	JTextArea TextArea;
	 JLabel lbl;
	
	
	
	
	public ClaseBufferAlarma(String datos, JTextArea textAreaVent, JLabel lbl2) {
		
		this.buffer=datos;
		this.TextArea=textAreaVent;
		this.lbl=lbl2;
		// TODO Auto-generated constructor stub
	}



	public void run(){
		
		lbl.setText(buffer);
		
		
		
		
	}
	
	
}
