package Ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.Orden;
import clases.Pieza;
import clases.SList;
import clases.SMap;
import clases.SST;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JList;

public class ReporteStock<E> extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public ReporteStock(SList ordenes, SST B) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setBounds(306, 214, 89, 23);
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReporteStock.this.dispose();
			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnVolver);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(71, 54, 289, 134);
		contentPane.add(scrollPane);
		
		/*public void stockPantalla(SList stock) throws IOException {
		
			
			System.out.println("Codigo           Nombre                       Cantidad ");
			for (int i=0;i<stock.size();i++) {
				p = (Pieza)stock.get(i);
				System.out.println(" " +p.getCode()+ "		"+p.getDescription()+"		"+p.getCant() );	
			}

		
		}*/
		
		JList list = new JList();
		String aux;
		SList piezas=B.getStockMap().toSList();
		Pieza p;
		DefaultListModel modelo = new DefaultListModel();
		for (int i=0;i<piezas.size();i++) {
			p=(Pieza) piezas.get(i);
			aux=" " +p.getCode()+ "		"+p.getDescription()+"		"+p.getCant(); 
			modelo.addElement((Object)aux);
		}
		scrollPane.setViewportView(list);
		
		
	}

	public void ReporteStock1(SList ordenes) {
		// TODO Auto-generated constructor stub
	}
}
