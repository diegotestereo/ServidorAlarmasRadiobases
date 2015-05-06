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

import Clases.ClaseServidor;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



public class ventana_Principal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JTextField editPuerto;
	public JTextArea textAreaConsola;
	public JButton btn_InicioServer,btn_deteneServer;
	static ClaseServidor ServerObj;
	
	
	//Thread t ;

	/**
	 * Create the frame.
	 */
	public ventana_Principal() {
			
		// t = new Thread(pepe);
		Inicializacion();
		
		  btn_InicioServer.setEnabled(true);
		  btn_deteneServer.setEnabled(false);
	
		textAreaConsola.setText("ServerTCP");
		
	
	
	}






	private void Inicializacion() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		editPuerto = new JTextField();
		editPuerto.setText("9001");
		editPuerto.setColumns(10);
		
		btn_InicioServer = new JButton("Server ON");
		
		btn_InicioServer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			  
			  btn_InicioServer.setEnabled(false);
			  btn_deteneServer.setEnabled(true);
			
			  

				 ServerObj = new ClaseServidor(9001);
				 ServerObj.start();
			 
			  
			  
				
			}
		});
		
		JLabel lblNewLabel = new JLabel("Sistema de Alarmas");
		
		JScrollPane scrollPane = new JScrollPane();
		
		btn_deteneServer = new JButton("Server OFF");
		btn_deteneServer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				  btn_deteneServer.setEnabled(false);
				  btn_InicioServer.setEnabled(true);
				  ServerObj.StopServer();
				 
					
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
							.addComponent(editPuerto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(editPuerto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
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

 
	   


