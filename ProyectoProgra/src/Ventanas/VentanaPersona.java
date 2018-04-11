package Ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.List;
import clases.SistemaServicioTecnico;

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
	private SistemaServicioTecnico B = new SistemaServicioTecnico();

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
			List parts = B.getStockMap();
			public int getSize() {
				return B.getStockMap().size();
			}
			public Object getElementAt(int index) {
				return B.getStockMap().get(index);
			}
		});
		scrollPane.setViewportView(list);
		
		/*JList list = new JList();
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"a", "b", "caballo", "chupalo entonceh", "chupalla", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "\u00F1", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		scrollPane.setViewportView(list);*/
		
		JButton agregarPieza = new JButton("Agregar");
		agregarPieza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				values.getElementAt(i);
			}
		});
		agregarPieza.setBounds(295, 79, 89, 23);
		contentPane.add(agregarPieza);
		
		JButton button = new JButton("Siguiente");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//if(piezas==0) {
					//String nombre = ((Cliente) S.getClientsMap().get(rut)).getName();
					//OrdenCreada1 ventana = new OrdenCreada1(nombre);
					OrdenCreada1 ventana = new OrdenCreada1();
					setVisible(false);
					ventana.setVisible(true);
				//}
			}
		});
		button.setBounds(389, 257, 89, 23);
		contentPane.add(button);
		
		JButton button_1 = new JButton("Atr\u00E1s");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainWindow ventana = new MainWindow();
				setVisible(false);
				ventana.setVisible(true);
			}
		});
		button_1.setBounds(290, 257, 89, 23);
		contentPane.add(button_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(295, 113, 129, 119);
		contentPane.add(scrollPane_1);
		
		/*JList list_1 = new JList();
		list_1.setModel(new AbstractListModel() {
			List piezas = new List();
			piezas.add(list.getElementAt(i));
			public int getSize() {
				return piezas.size();
			}
			public Object getElementAt(int index) {
				return piezas.get(index);
			}
		});
		scrollPane_1.setViewportView(list_1);*/
		
		
	
		
	}
}
