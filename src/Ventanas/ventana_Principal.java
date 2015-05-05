package Ventanas;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



public class ventana_Principal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextArea textAreaConsola;
	private JButton btn_InicioServer,btn_deteneServer;
	private ServerSocket sk;
	private int Puerto=9001;
	Serv pepe;
	hiloCliente hilclient;
	//Thread t ;

	/**
	 * Create the frame.
	 */
	public ventana_Principal() {
		pepe=new Serv();
		
		// t = new Thread(pepe);
		Inicializacion();
		
		  btn_InicioServer.setEnabled(true);
		  btn_deteneServer.setEnabled(false);
	
		textAreaConsola.setText("pepe");
		
	
	
	}






	private void Inicializacion() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		textField = new JTextField();
		textField.setColumns(10);
		
		btn_InicioServer = new JButton("Server ON");
		btn_InicioServer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

			
					pepe.start();
				  btn_InicioServer.setEnabled(false);
				  btn_deteneServer.setEnabled(true);
			
				
			}
		});
		
		JLabel lblNewLabel = new JLabel("Sistema de Alarmas");
		
		JScrollPane scrollPane = new JScrollPane();
		
		btn_deteneServer = new JButton("Server OFF");
		btn_deteneServer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				  btn_deteneServer.setEnabled(false);
				  btn_InicioServer.setEnabled(true);
				  pepe.detenerHilo();
					
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(55)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 299, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(35)
							.addComponent(btn_InicioServer)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btn_deteneServer)
							.addPreferredGap(ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
							.addComponent(lblNewLabel)
							.addGap(18)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(btn_InicioServer)
							.addComponent(btn_deteneServer)))
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		
		textAreaConsola = new JTextArea();
		scrollPane.setViewportView(textAreaConsola);
		contentPane.setLayout(gl_contentPane);
		
	}
}


class hiloCliente extends Thread {
    Socket client = null;
    
    // constructor y parametro
    public hiloCliente(Socket c) {
        this.client = c;
    }
    
    public void run() {
    	
    	String NombreCliente;
    	boolean BoolCliente=true;
    	
        try {
        	
        	NombreCliente=client.getInetAddress().getHostName();
            System.out.println("Connected to client : "+NombreCliente);
            
            do{
            	//lee o que envia el cliente
            	BufferedReader entrada = new BufferedReader(new InputStreamReader(client.getInputStream()));
            	// escribe la salida del servidor
            	PrintWriter salida= new PrintWriter(new OutputStreamWriter(client.getOutputStream()),true);
                
            	//formatea el dato de entrada o caste a aString
                String datos = entrada.readLine();
              //  System.out.println("datos: "+datos);
	         
                if (datos==null){
                	// System.out.println("dato nulo");
                	 BoolCliente=false;
                     
                 }else{
                //  System.out.println("Dispositivo '"+ NombreCliente+"' : "+datos);
                  System.out.println(datos);
                  
                  salida.println("Servidor -> "+NombreCliente+" : "+datos);
                 }
                 
                 }while(BoolCliente);//cuando el clientees
        } catch (Exception e) {
            System.err.println(e.getMessage());
            BoolCliente=false;
        }
    }
    }






 class Serv extends Thread {
	    ServerSocket sk = null;
	    Socket cliente;
	    int Puerto=9001;
	    boolean continuar = true;
	    hiloCliente hilclient;
	    // constructor y parametro
	    public Serv() {
	        
	    }
	    
	    public void detenerHilo(){
	    	  continuar = false;
	    }
	    public void run() {
	    	
			   try {
			          sk = new ServerSocket(Puerto);
			          System.out.println();  
		        	     System.out.println("*****************************************************");
				        System.out.println("************    ServidorMulticliente      ***********");
		                  System.out.println("************    IP: "+InetAddress.getLocalHost().getHostAddress()+":"+Puerto+"     **********");
		                 System.out.println("*****************************************************");
			                 
		                 System.out.println();
			          while (continuar) { 
			        	  System.out.println("antes"+continuar);
			              
			               
			                 cliente = sk.accept();// se queda a la espera de un cliente
			            	  System.out.println("despues"+continuar);
				        	if(!continuar){  cliente.close();
				        	  System.out.println("cliente cerrado");}
						   
				        	hilclient= new hiloCliente(cliente);// crea un hilo con un nuevo cliente.
				        	hilclient.start();
				        	
			                 //y le paso como parametro el Socket cliente ingresado.
			              
			          }
			   } catch (IOException e) {
			          System.out.println(e);
			          System.out.println("IOException"+continuar);
			        
			   }
	    	
	    
	    }
	    }



