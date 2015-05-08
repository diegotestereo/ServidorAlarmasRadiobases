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
import Clases.ClaseTimerReadBBDD;

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
	public JLabel lblRadiobase2;
	public static JLabel lblRadiobase1;
	public JPanel panelRadiobase1;
	public JPanel panelRadiobase2;
	public JLabel lblRadiobase3;
	public JPanel panelRadiobase3;
	ClaseTimerReadBBDD Timer;
	private JTable table;
	
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
			
			Timer=new ClaseTimerReadBBDD(4);
			//Timer.start();
		 
			}

			
		});
		
		JLabel lblNewLabel = new JLabel("Puerto");
		
		JScrollPane scrollPane = new JScrollPane();
		
		btn_deteneServer = new JButton("Server OFF");
		btn_deteneServer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textAreaConsola.setText("");
				stopServidor();
				
				Timer.detener();
			}
		});
		
		panelRadiobase1 = new JPanel();
		panelRadiobase1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panelRadiobase1.setForeground(Color.BLACK);
		
		panelRadiobase2 = new JPanel();
		panelRadiobase2.setForeground(Color.BLACK);
		panelRadiobase2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		lblRadiobase2 = new JLabel("New label");
		panelRadiobase2.add(lblRadiobase2);
		
		panelRadiobase3 = new JPanel();
		panelRadiobase3.setForeground(Color.BLACK);
		panelRadiobase3.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		lblRadiobase3 = new JLabel("New label");
		panelRadiobase3.add(lblRadiobase3);
		
		table = new JTable();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 287, GroupLayout.PREFERRED_SIZE)
									.addGap(54)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addComponent(panelRadiobase1, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)
										.addComponent(panelRadiobase2, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)
										.addComponent(panelRadiobase3, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)))
								.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
									.addComponent(btn_InicioServer)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btn_deteneServer, GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
									.addGap(18)
									.addComponent(lblNewLabel)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(editPuerto, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
									.addGap(320)))
							.addGap(0))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(table, GroupLayout.PREFERRED_SIZE, 485, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(111, Short.MAX_VALUE))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(table, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 122, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btn_InicioServer)
						.addComponent(btn_deteneServer)
						.addComponent(lblNewLabel)
						.addComponent(editPuerto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 225, GroupLayout.PREFERRED_SIZE)
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(panelRadiobase1, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(panelRadiobase2, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(panelRadiobase3, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
							.addGap(36))))
		);
		
		lblRadiobase1 = new JLabel("New label");
		panelRadiobase1.add(lblRadiobase1);
		
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
		  ServerObj = new ClaseServidor(port,ventana_Principal.textAreaConsola,ventana_Principal.lblRadiobase1);
		  ServerObj.start();
		
	}
}

 
	   


