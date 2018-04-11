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
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaPersona extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public VentanaPersona(String rut, String problema) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 554, 349);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.desktop);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAgregarPiezas = new JLabel("Agregar Piezas: ");
		lblAgregarPiezas.setForeground(SystemColor.text);
		lblAgregarPiezas.setBounds(76, 79, 179, 14);
		contentPane.add(lblAgregarPiezas);
		
		JScrollPane scrollPane = new JScrollPane();
		
		scrollPane.setBounds(156, 79, 86, 153);
		contentPane.add(scrollPane);
		
		JList list = new JList();
		scrollPane.setViewportView(list);
		
		JButton agregarPieza = new JButton("Agregar");
		agregarPieza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		agregarPieza.setBounds(265, 79, 89, 23);
		contentPane.add(agregarPieza);
	}
}
