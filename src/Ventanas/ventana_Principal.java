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

import javax.swing.border.BevelBorder;
import javax.swing.JTable;



public class ventana_Principal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JTextField editPuerto;
	public static JTextArea textAreaConsola;
	public JButton btn_InicioServer,btn_deteneServer;
	static ClaseServidor ServerObj;


	public static JLabel lblRadiobase1;
	public JPanel panelRadiobase1;
	public JButton btn_ServerKAOn;
public 	JButton btn_ServerKAOff;
	private JTable table;
	private JTextField editPuertoKA;
	
	//Thread t ;

	/**
	 * Create the frame.
	 */
	public ventana_Principal() {
	
		Inicializacion();
		
		btn_InicioServer.setEnabled(true);
		btn_deteneServer.setEnabled(false);
		textAreaConsola.setText("Presione el Boton Inicio");
	
	}

	private void Inicializacion() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 542, 540);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		editPuerto = new JTextField();
		editPuerto.setText("9001");
		editPuerto.setColumns(10);
		
		btn_InicioServer = new JButton("Server ON");
		
		btn_InicioServer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			  
			startServidor();
			 Conexion con=new Conexion();
			 con.Conectar();	
			
			}

			
		});
		
		JLabel lblNewLabel = new JLabel("Puerto Alarmas");
		
		JScrollPane scrollPane = new JScrollPane();
		
		btn_deteneServer = new JButton("Server OFF");

		btn_deteneServer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textAreaConsola.setText("");
				stopServidor();
				
			
			}
		});
		
		panelRadiobase1 = new JPanel();
		panelRadiobase1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panelRadiobase1.setForeground(Color.BLACK);
		
		table = new JTable();
		
		JLabel lblNewLabel_1 = new JLabel("Puerto Keep Alive");
		
		editPuertoKA = new JTextField();
		editPuertoKA.setText("9002");
		editPuertoKA.setColumns(10);
		
		btn_ServerKAOn = new JButton("Server KA ON");
		btn_ServerKAOn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				  int PortKA=Integer.parseInt(editPuertoKA.getText().toString());
				 
					//Conexion con=new Conexion();
				//	 con.Conectar();	
					 btn_ServerKAOff.setEnabled(true);
				  
			}
		});
		
		btn_ServerKAOff = new JButton("Server KA OFF");
		btn_ServerKAOff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				  editPuertoKA.setEnabled(true);
				 
				  btn_ServerKAOn.setEnabled(true);
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(71)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(btn_deteneServer, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
								.addComponent(btn_InicioServer, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel_1)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(editPuertoKA, 0, 0, Short.MAX_VALUE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel)
									.addGap(18)
									.addComponent(editPuerto, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(48)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 296, GroupLayout.PREFERRED_SIZE)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(347)
							.addComponent(panelRadiobase1, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(61)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(btn_ServerKAOn, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btn_ServerKAOff, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(table, GroupLayout.PREFERRED_SIZE, 334, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(453, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(41, Short.MAX_VALUE)
					.addComponent(table, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btn_InicioServer)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btn_deteneServer))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel)
								.addComponent(editPuerto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(btn_ServerKAOn))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_1)
								.addComponent(editPuertoKA, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(btn_ServerKAOff))))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(198)
							.addComponent(panelRadiobase1, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 225, GroupLayout.PREFERRED_SIZE)))
					.addGap(24))
		);
		
		textAreaConsola = new JTextArea();
		scrollPane.setViewportView(textAreaConsola);
		
		lblRadiobase1 = new JLabel("New label");
		panelRadiobase1.add(lblRadiobase1);
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
		 editPuertoKA.setEnabled(false);
		 
		 int port=Integer.parseInt(editPuerto.getText().toString());
		 
		  ServerObj = new ClaseServidor(port,ventana_Principal.textAreaConsola,ventana_Principal.lblRadiobase1);
		  ServerObj.start();
		
		
	}
}

 
	   


