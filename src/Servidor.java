

import Ventanas.*;
import Clases.*;
	public class Servidor {
		
		static ventana_Principal mainFrame;
		static int Puerto;
		
		 
		 
		 public static void main(String args[]) {
			
			 mainFrame=new ventana_Principal();
			 mainFrame.setVisible(true);
			 Puerto=Integer.parseInt(mainFrame.editPuerto.getText().toString());
			
		 
		 
		 }
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
			
	}
	

