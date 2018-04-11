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
import javax.swing.AbstractListModel;

public class VentanaPersona extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public VentanaPersona(String rut, String problema) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 554, 354);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.desktop);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAgregarPiezas = new JLabel("Agregar Piezas: ");
		lblAgregarPiezas.setForeground(SystemColor.text);
		lblAgregarPiezas.setBounds(63, 81, 220, 14);
		contentPane.add(lblAgregarPiezas);
		
		JScrollPane scrollPane = new JScrollPane();
		
		scrollPane.setBounds(156, 79, 129, 153);
		contentPane.add(scrollPane);
		
		JList list = new JList();
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"a", "b", "caballo", "chupalo entonceh", "chupalla", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "\u00F1", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		scrollPane.setViewportView(list);
		
		JButton agregarPieza = new JButton("Agregar");
		agregarPieza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		agregarPieza.setBounds(295, 79, 89, 23);
		contentPane.add(agregarPieza);
		
		JButton button = new JButton("Siguiente");
		button.setBounds(389, 257, 89, 23);
		contentPane.add(button);
		
		JButton button_1 = new JButton("Atr\u00E1s");
		button_1.setBounds(290, 257, 89, 23);
		contentPane.add(button_1);
	}
}
