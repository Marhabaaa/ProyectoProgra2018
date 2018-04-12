package Ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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

public class VentanaPersonaNoExiste extends JFrame {

	private JPanel contentPane;
	private JTextField nombre;
	private JTextField telefono;
	private JTextField correo;
	private JLabel lblCorreo;
	private JButton btnNewButton;
	private JButton btnAtrs;


	/**
	 * Create the frame.
	 */
	public VentanaPersonaNoExiste(String rut, String problema) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		
		nombre = new JTextField();
		nombre.setBounds(141, 77, 104, 20);
		contentPane.add(nombre);
		nombre.setColumns(10);
		
		telefono = new JTextField();
		telefono.setColumns(10);
		telefono.setBounds(141, 121, 104, 20);
		contentPane.add(telefono);
		
		correo = new JTextField();
		correo.setColumns(10);
		correo.setBounds(141, 208, 104, 20);
		contentPane.add(correo);
		
		JLabel lblNewLabel = new JLabel("Tel\u00E9fono: ");
		lblNewLabel.setForeground(SystemColor.text);
		lblNewLabel.setBounds(65, 124, 122, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Rut:                  " + rut);
		lblNewLabel_1.setForeground(SystemColor.text);
		lblNewLabel_1.setBounds(65, 168, 161, 14);
		contentPane.add(lblNewLabel_1);
		
		lblCorreo = new JLabel("Correo:");
		lblCorreo.setForeground(SystemColor.info);
		lblCorreo.setBounds(65, 211, 46, 14);
		contentPane.add(lblCorreo);
		
		
		JRadioButton rdbtnPersona = new JRadioButton("Persona");	
		rdbtnPersona.setForeground(SystemColor.text);
		rdbtnPersona.setBackground(SystemColor.desktop);
		rdbtnPersona.setBounds(305, 164, 87, 23);
		contentPane.add(rdbtnPersona);
		
		
		JRadioButton rdbtnEmpresa = new JRadioButton("Empresa");
		rdbtnEmpresa.setForeground(SystemColor.text);
		rdbtnEmpresa.setBackground(SystemColor.desktop);
		rdbtnEmpresa.setBounds(409, 164, 123, 23);
		contentPane.add(rdbtnEmpresa);
		
		btnNewButton = new JButton("Siguiente");
		btnNewButton.setBounds(409, 244, 89, 23);
		contentPane.add(btnNewButton);
		
		btnAtrs = new JButton("Atr\u00E1s");
		btnAtrs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainWindow ventana = new MainWindow();
				setVisible(false);
				ventana.setVisible(true);
			}
		});
		btnAtrs.setBounds(305, 244, 89, 23);
		contentPane.add(btnAtrs);
	
	}
}
