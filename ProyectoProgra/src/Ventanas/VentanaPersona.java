package Ventanas;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.SList;
import clases.SST;
import clases.Cliente;
import clases.Tecnico;
import clases.Orden;
import clases.Pieza;

import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.AbstractListModel;

public class VentanaPersona extends JFrame {

	private JPanel contentPane;
	private JTextField piezaAñadida;

	/**
	 * Create the frame.
	 */
	public VentanaPersona(String rut, String problema, SST B, SList lista) {
				
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
		
		//String selected = (String) listaPiezas.getSelectedValue();
		//int i=Integer.parseInt(selected);
		//lista.add(B.getStockMap().get(i));
		
		//JList piezasAgregadas = new JList();					//HACER ESTO, este es el jlist de piezas agregadas
		//piezasAgregadas.setModel(new AbstractListModel() {
			//String[] values = 
			//public int getSize() {
				//return values.length;
			//}
			//public Object getElementAt(int index) {
				//return values[index];
			//}
		//});
		//scrollPane_1.setViewportView(piezasAgregadas);
		
		//////////////////////////////////////////////////////////
		JButton agregarPieza = new JButton("Agregar otra");
		//SList piezasAgregadas;
		agregarPieza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String text = piezaAñadida.getText();
				if(!text.equals("")) {
					Pieza aux = (Pieza) B.getStockMap().get(Integer.parseInt(text));
					if(aux != null)
						lista.add(aux);
					VentanaPersona ventana1= new VentanaPersona(rut,problema,B,lista);
					ventana1.setVisible(true);
					VentanaPersona.this.dispose();
				}
			}
		});
		agregarPieza.setBounds(290, 209, 107, 23);
		contentPane.add(agregarPieza);
///////////////////////////////////////////////////////////////
		
		int rut1=Integer.parseInt(rut);
		Tecnico auxT = B.leastWorkload();
		JButton button = new JButton("Siguiente");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Orden auxO;
				Date hoy= new Date(); 
				SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy"); 
				String fecha = sdf.format(hoy);
				auxO = new Orden(B.getNewOrderNumber(), problema, fecha, rut1, auxT.getTechNumber());
				Cliente auxC = (Cliente) B.getClientsMap().get(rut1);
				String nombre = auxC.getName();
				if(lista.isEmpty()) {
					OrdenCreada1 ventana = new OrdenCreada1(nombre, auxO, B);
					ventana.setVisible(true);
					VentanaPersona.this.dispose();
				}else{
					
					auxO.setPartsList(lista);
					auxO.setDateOut(String.valueOf(B.delayOfReturn(auxO)));
					auxO.set();
					OrdenCreada2 ventana1= new OrdenCreada2(nombre, auxO, B);
					ventana1.setVisible(true);
					VentanaPersona.this.dispose();
				}
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
		
		piezaAñadida = new JTextField();
		piezaAñadida.setBounds(293, 181, 86, 20);
		contentPane.add(piezaAñadida);
		piezaAñadida.setColumns(10);
	}
}
