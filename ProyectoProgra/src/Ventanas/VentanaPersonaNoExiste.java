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

public class VentanaPersonaNoExiste extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_3;
	private JLabel lblCorreo;


	/**
	 * Create the frame.
	 */
	public VentanaPersonaNoExiste(String rut, String problema) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.desktop);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setForeground(SystemColor.text);
		lblNombre.setBounds(65, 80, 46, 14);
		contentPane.add(lblNombre);
		
		textField = new JTextField();
		textField.setBounds(122, 77, 104, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(122, 121, 104, 20);
		contentPane.add(textField_1);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(122, 208, 104, 20);
		contentPane.add(textField_3);
		
		JLabel lblNewLabel = new JLabel("Tel\u00E9fono: ");
		lblNewLabel.setForeground(SystemColor.text);
		lblNewLabel.setBounds(65, 124, 122, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Rut:           " + rut);
		lblNewLabel_1.setForeground(SystemColor.text);
		lblNewLabel_1.setBounds(65, 168, 161, 14);
		contentPane.add(lblNewLabel_1);
		
		lblCorreo = new JLabel("Correo:");
		lblCorreo.setForeground(SystemColor.info);
		lblCorreo.setBounds(65, 211, 46, 14);
		contentPane.add(lblCorreo);
	}
}
