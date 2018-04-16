package Ventanas;
import java.sql.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.Cliente;
import clases.SST;

import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JList;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;


public class VentanaPersonaNoExiste extends JFrame {

	private JPanel contentPane;
	private JTextField nombre;
	private JTextField telefono;
	private JTextField correo;
	private JLabel lblCorreo;
	private JButton btnNewButton;
	private JButton btnAtrs;
	private JTextField tipoCliente;
	private JLabel lblCrearNuevoCliente;


	/**
	 * Create the frame.
	 */
	public VentanaPersonaNoExiste(String rut, String problema,SST B) throws SQLException { //Aqui se crea al nuevo cliente
		String rut1=rut;
		Cliente client;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 564, 354);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.desktop);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setForeground(SystemColor.text);
		lblNombre.setBounds(65, 80, 66, 14);
		
		contentPane.add(lblNombre);
		
		nombre = new JTextField();			//Aqui se agrega el nombre del cliente
		nombre.setBounds(162, 77, 104, 20);
		contentPane.add(nombre);
		nombre.setColumns(10);
		
		
		telefono = new JTextField();		//Aqui se agrega el telefono del cliente
		telefono.setColumns(10);
		telefono.setBounds(162, 121, 104, 20);
		contentPane.add(telefono);
		
		correo = new JTextField();			//Aqui se agrega el correo del cliente
		correo.setColumns(10);
		correo.setBounds(162, 208, 104, 20);
		contentPane.add(correo);
		
		tipoCliente = new JTextField();		//Aqui se agrega el tipo de cliente (persona o empresa)
		tipoCliente.setColumns(10);
		tipoCliente.setBounds(162, 245, 104, 20);
		contentPane.add(tipoCliente);
		
		JLabel lblNewLabel = new JLabel("Tel\u00E9fono: ");
		lblNewLabel.setForeground(SystemColor.text);
		lblNewLabel.setBounds(65, 124, 122, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Rut:                         "+rut);
		lblNewLabel_1.setForeground(SystemColor.text);
		lblNewLabel_1.setBounds(65, 168, 161, 14);
		contentPane.add(lblNewLabel_1);
		
		lblCorreo = new JLabel("Correo:");
		lblCorreo.setForeground(SystemColor.info);
		lblCorreo.setBounds(65, 211, 46, 14);
		contentPane.add(lblCorreo);
		
		JLabel lblTipoDeCliente = new JLabel("Tipo de Cliente:");
		lblTipoDeCliente.setForeground(SystemColor.info);
		lblTipoDeCliente.setBounds(65, 248, 104, 14);
		contentPane.add(lblTipoDeCliente);
		
		btnNewButton = new JButton("Siguiente");				//este boton vuelve a la ventana principal para verificar
		btnNewButton.addActionListener(new ActionListener() {	//si el cliente fue creado con exito y asi empezar a 		
			public void actionPerformed(ActionEvent arg0) {		//agregar piezas a la orden del cliente
				Cliente c;
				if(tipoCliente.getText()=="empresa"){
					c = new Cliente(Integer.parseInt(rut), nombre.getText(), telefono.getText(), correo.getText(), true);
				}else {
					c = new Cliente(Integer.parseInt(rut), nombre.getText(), telefono.getText()	, correo.getText(), false);
				}
				B.getClientsMap().put(Integer.parseInt(rut), c);
				VentanaPersonaNoExiste.this.dispose();
			}
		});
		btnNewButton.setBounds(409, 244, 89, 23);
		contentPane.add(btnNewButton);
		
		btnAtrs = new JButton("Atr\u00E1s");				//boton para volver al menu principal
		btnAtrs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VentanaPersonaNoExiste.this.dispose();
			}
		});
		btnAtrs.setBounds(305, 244, 89, 23);
		contentPane.add(btnAtrs);
		
		lblCrearNuevoCliente = new JLabel("Crear nuevo cliente:");
		lblCrearNuevoCliente.setForeground(SystemColor.text);
		lblCrearNuevoCliente.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		lblCrearNuevoCliente.setBounds(42, 27, 167, 14);
		contentPane.add(lblCrearNuevoCliente);
		
	
	}
}
