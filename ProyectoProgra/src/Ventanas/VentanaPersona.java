package Ventanas;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.SList;
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

	/**
	 * Create the frame.
	 */
	public VentanaPersona(String rut, String problema, SistemaServicioTecnico B) {

		/*public void MetodoAgregarPieza(String pieza){				//metodo para agregar piezas
			JButton agregarPieza = new JButton("Agregar");
			SList piezasAgregadas;
			agregarPieza.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
				}
			});
			agregarPieza.setBounds(295, 79, 89, 23);
			contentPane.add(agregarPieza);
		}*/
		
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
		
		JList listaPiezas = new JList();
		listaPiezas.setModel(new AbstractListModel() {
			String[] values = B.getStockDescriptions();
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		scrollPane.setViewportView(listaPiezas);
		
		/*JList piezasAgregadas = new JList();				//HACER ESTO, este es el jlist de piezas agregadas
		piezasAgregadas.setModel(new AbstractListModel() {
			String[] values = 
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		
		scrollPane_1.setViewportView(piezasAgregadas);
		*/
		
		JButton agregarPieza = new JButton("Agregar");
		agregarPieza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		agregarPieza.setBounds(295, 79, 89, 23);
		contentPane.add(agregarPieza);
		
		int rut1=Integer.parseInt(rut);
		JButton button = new JButton("Siguiente");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nombre = ((Component) B.getClientsMap().get(rut1)).getName();
				//if(piezas==0) {	
					OrdenCreada1 ventana = new OrdenCreada1(nombre);
					ventana.setVisible(true);
					VentanaPersona.this.dispose();
				//}else{
					OrdenCreada2 ventana1= new OrdenCreada2(nombre);
					ventana1.setVisible(true);
					VentanaPersona.this.dispose();
				//}
			}
		});
		button.setBounds(389, 257, 89, 23);
		contentPane.add(button);
		
		JButton button_1 = new JButton("Atr\u00E1s");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VentanaPersona.this.dispose();
			}
		});
		button_1.setBounds(290, 257, 89, 23);
		contentPane.add(button_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(295, 113, 129, 119);
		contentPane.add(scrollPane_1);
		
		JList piezasAgregadas = new JList();
		//piezasAgregadas.setModel(new AbstractListModel() {
			//String[] piecitas = B.getStockDescriptions();
			/*public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}*/
		//});
		
		scrollPane_1.setViewportView(piezasAgregadas);
		
		
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
