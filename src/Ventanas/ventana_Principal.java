package Ventanas;


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

import BBDD.Conexion;
import Clases.ClaseServidor;

import KeepAlive.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;




public class ventana_Principal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JTextField editPuerto,editPuertoKA;
	public static JTextArea textAreaConsola,textAreaConsolaDeKeeps;
	public JButton btn_InicioServer,btn_deteneServer;
	static ClaseServidor ServerObj;
	public JButton btn_ServerKAOn;
public 	JButton btn_ServerKAOff;
	
	private JPanel panel_1;
	private JScrollPane scrollPane_1;

	//Thread t ;

	/**
	 * Create the frame.
	 */
	public ventana_Principal() {
	
		Inicializacion();
		
		btn_InicioServer.setEnabled(true);
		btn_deteneServer.setEnabled(false);
		textAreaConsola.setText("Consola de Eventos");
	
	
	}

	private void Inicializacion() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 681, 469);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		//panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBackground(new Color(204, 204, 102));
		panel.setForeground(Color.BLACK);
		
		panel_1 = new JPanel();
		//panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_1.setBackground(new Color(255, 255, 102));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 271, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 290, GroupLayout.PREFERRED_SIZE)
					.addGap(66))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(21)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 374, Short.MAX_VALUE)
						.addComponent(panel_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 374, Short.MAX_VALUE))
					.addGap(26))
		);
		panel_1.setLayout(null);
		
		btn_ServerKAOn = new JButton("Server KA ON");
		btn_ServerKAOn.setBounds(28, 11, 117, 23);
		panel_1.add(btn_ServerKAOn);
		
		btn_ServerKAOff = new JButton("Server KA OFF");
		btn_ServerKAOff.setBounds(28, 45, 117, 23);
		panel_1.add(btn_ServerKAOff);
		
		editPuertoKA = new JTextField();
		editPuertoKA.setBounds(178, 42, 51, 20);
		panel_1.add(editPuertoKA);
		editPuertoKA.setText("9002");
		editPuertoKA.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Puerto Keep Alive");
		lblNewLabel_1.setBounds(168, 11, 85, 14);
		panel_1.add(lblNewLabel_1);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(28, 79, 238, 225);
		panel_1.add(scrollPane_1);
		
		textAreaConsolaDeKeeps = new JTextArea();
		textAreaConsolaDeKeeps.setText("Consola de Keeps Alives");
		scrollPane_1.setViewportView(textAreaConsolaDeKeeps);
		
		JTextArea textArea = new JTextArea();
		scrollPane_1.setViewportView(textArea);
		
		btn_ServerKAOff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				  editPuertoKA.setEnabled(true);
			 
				  btn_ServerKAOn.setEnabled(true);
			}
		});
		btn_ServerKAOn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				  int PortKA=Integer.parseInt(editPuertoKA.getText().toString());
				 
					//Conexion con=new Conexion();
				//	 con.Conectar();	
					 btn_ServerKAOff.setEnabled(true);
				  
			}
		});
		panel.setLayout(null);
		
		btn_InicioServer = new JButton("Server ON");
		btn_InicioServer.setBounds(20, 11, 106, 23);
		panel.add(btn_InicioServer);
		
		btn_deteneServer = new JButton("Server OFF");
		btn_deteneServer.setBounds(20, 45, 106, 23);
		panel.add(btn_deteneServer);
		
		JLabel lblNewLabel = new JLabel("Puerto Alarmas");
		lblNewLabel.setBounds(154, 15, 83, 14);
		panel.add(lblNewLabel);
		
		editPuerto = new JTextField();
		editPuerto.setBounds(164, 46, 40, 20);
		panel.add(editPuerto);
		editPuerto.setText("9001");
		editPuerto.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 79, 213, 225);
		panel.add(scrollPane);
		
		textAreaConsola = new JTextArea();
		scrollPane.setViewportView(textAreaConsola);
		
				btn_deteneServer.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						textAreaConsola.setText("");
						stopServidor();
						
					
					}
				});
		
		btn_InicioServer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			  
			startServidor();
			 Conexion con=new Conexion();
			 con.Conectar();	
			
			}

			
		});
		contentPane.setLayout(gl_contentPane);
		
	}

	protected void stopServidor() {
		  btn_deteneServer.setEnabled(false);
		  btn_InicioServer.setEnabled(true);
			 editPuerto.setEnabled(true);
			
		  ServerObj.StopServer();
		
		 
	}

	protected void startServidor() {
		  btn_InicioServer.setEnabled(false);
		  btn_deteneServer.setEnabled(true);
		 editPuerto.setEnabled(false);
		
		 
		 int port=Integer.parseInt(editPuerto.getText().toString());
		 
		  ServerObj = new ClaseServidor(port,ventana_Principal.textAreaConsola);
		  ServerObj.start();
		
		
	}
}

 
	   


