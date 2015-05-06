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
	public static JTextArea textAreaConsola;
	public JButton btn_InicioServer,btn_deteneServer;
	static ClaseServidor ServerObj;
	
	
	//Thread t ;

	/**
	 * Create the frame.
	 */
	public ventana_Principal() {
	
		Inicializacion();
		
		btn_InicioServer.setEnabled(true);
		btn_deteneServer.setEnabled(false);
		textAreaConsola.setText("ServerTCP");
	
	}

	private void Inicializacion() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 643, 350);
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
				
			}

			
		});
		
		JLabel lblNewLabel = new JLabel("Puerto");
		
		JScrollPane scrollPane = new JScrollPane();
		
		btn_deteneServer = new JButton("Server OFF");
		btn_deteneServer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				stopServidor();
					
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 597, Short.MAX_VALUE))
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
							.addGap(55)
							.addComponent(btn_InicioServer)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btn_deteneServer)
							.addGap(111)
							.addComponent(lblNewLabel)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(editPuerto, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btn_InicioServer)
						.addComponent(btn_deteneServer)
						.addComponent(editPuerto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE))
		);
		
		textAreaConsola = new JTextArea();
		scrollPane.setViewportView(textAreaConsola);
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

 
	   


