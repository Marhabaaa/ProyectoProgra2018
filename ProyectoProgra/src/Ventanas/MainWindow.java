package Ventanas;

import java.sql.*;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.Cliente;
import clases.SList;
import clases.SST;

import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import java.io.*;
import java.util.Date;
import java.util.Enumeration;
import java.text.SimpleDateFormat;
import javax.swing.JDesktopPane;
import javax.swing.JMenuBar;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.JTabbedPane;

public class MainWindow extends JFrame {

	private JPanel contentPane;
	private JTextField rut;
	private JTextField problema;
	private static SST B;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) throws SQLException {
		
		B = new SST();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow frame = new MainWindow();				//Se crea la ventana principal del programa
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public MainWindow() throws SQLException {
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainWindow.class.getResource("/imageness/fondo-azul-836335-1.jpg")));
		setTitle("RepairURPC");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 554, 349);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.desktop);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnSalir = new JButton("Salir");					//Este boton cierra el programa
		btnSalir.setBackground(SystemColor.textHighlight);
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnSalir.setBounds(452, 11, 71, 23);
		contentPane.add(btnSalir);
		
		Date hoy= new Date(); 											
		SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy"); 		//Se imprime la fecha del dia actual
		String fecha = sdf.format(hoy);									
																		
		JLabel lblNewLabel = new JLabel("Fecha: " + fecha);				
		lblNewLabel.setForeground(Color.WHITE);							
		lblNewLabel.setFont(new Font("Segoe UI Black", Font.PLAIN, 11));
		lblNewLabel.setBounds(397, 281, 136, 14);						
		contentPane.add(lblNewLabel);									
		
		
		
		
		
		JLabel lblNuevaOrden = new JLabel("Nueva Orden: ");
		lblNuevaOrden.setForeground(SystemColor.text);
		lblNuevaOrden.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		lblNuevaOrden.setBounds(32, 80, 151, 23);
		contentPane.add(lblNuevaOrden);
		
		JLabel lblRut = new JLabel("Rut: ");		
		lblRut.setForeground(SystemColor.text);		
		lblRut.setBounds(105, 114, 46, 14);			
		contentPane.add(lblRut);					
		
		rut = new JTextField();				
		rut.setBounds(164, 114, 182, 20);	//aqui se ingresa el rut a verificar si el cliente existe o no en la base de datos
		contentPane.add(rut);
		rut.setColumns(10);
		
		JLabel lblDescripcin = new JLabel("Descripci\u00F3n:");
		lblDescripcin.setForeground(SystemColor.text);
		lblDescripcin.setBounds(67, 152, 116, 14);
		contentPane.add(lblDescripcin);
		
		problema = new JTextField();
		problema.setText("\r\n\r\n\r\n\r\n\r\n"); //aqui se ingresa el problema del cliente
		problema.setBounds(164, 149, 182, 90);
		contentPane.add(problema);
		problema.setColumns(10);
		
		
		
		
		JButton btnNewButton = new JButton("Siguiente");		//se crea el boton siguiente para ir a la nueva ventana
		btnNewButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				JLabel label = new JLabel(""+rut.getText());
				SList lista = new SList();
				label.setBounds(194, 268, 46, 14);
				contentPane.add(label);
				if(B.getClientsMap().contains(Integer.parseInt(rut.getText()))){
					VentanaPersona ventana1 = new VentanaPersona(rut.getText(),problema.getText(), B, lista); //se crea la ventana para agregar piezas a la orden del cliente
					ventana1.setVisible(true);
				}
				else {
					VentanaPersonaNoExiste ventana2 = null;
					try {
						ventana2 = new VentanaPersonaNoExiste(rut.getText(),problema.getText(), B); //se crea la ventana para registrar los datos del nuevo cliente
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					ventana2.setVisible(true);
				}
			};
		});
		btnNewButton.setBounds(356, 190, 123, 49);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Reportes");			//se crea el boton de reportes
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Reportes ventanaReportes= new Reportes (B.getOrdersMap().toSList(),B);
				ventanaReportes.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(164, 0, 129, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnEliminarOrdenes = new JButton("Eliminar ordenes");		
		btnEliminarOrdenes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EliminadorDeOrdenes ventana=new EliminadorDeOrdenes(B);
				ventana.setVisible(true);
			}
		});
		btnEliminarOrdenes.setBounds(0, 0, 165, 23);
		contentPane.add(btnEliminarOrdenes);
		
		
	}
}
