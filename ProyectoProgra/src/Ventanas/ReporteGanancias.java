package Ventanas;

import javax.swing.*;
import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;

import clases.Orden;
import clases.Report;
import clases.SList;
import clases.SMap;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class ReporteGanancias extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public ReporteGanancias(SList ordenes) {
		
		Report reporte= new Report();

		
		//System.out.println("    Numero de orden 	    	Tecnico			Ganacia por orden ");
		//for (int i=0;i<ordenes.size();i++) {
			
			//o = (Orden)ordenes.get(i);
			//if(o.isDone()) {
			//System.out.println(" " + o.getOrderNumber()+"		" + o.getTechNumber()+ "		" + o.getProfit()+"\n");
			// suma = suma + o.getProfit();
			//}
			//System.out.println("el precio total es: "+ suma);
		//}

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.desktop);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReporteGanancias.this.dispose();
			}
		});
		btnVolver.setBounds(335, 227, 89, 23);
		contentPane.add(btnVolver);
		
		JLabel numeroDeOrden = new JLabel("Numero de Orden:");
		numeroDeOrden.setBounds(36, 30, 112, 14);
		contentPane.add(numeroDeOrden);
		
		JList reportesDeOrdenes = new JList();
		String aux;
		Orden o;
		DefaultListModel modelo = new DefaultListModel();
		for(int j=0;j<ordenes.size();j++) {			
			o= (Orden)ordenes.get(j);
				aux=o.getOrderNumber()+"		" + o.getTechNumber()+ "		" + o.getProfit();
				modelo.addElement((Object)aux);
				
		}
		reportesDeOrdenes.setModel(modelo);
		reportesDeOrdenes.setBounds(36, 59, 298, 148);
		contentPane.add(reportesDeOrdenes);
		
		JLabel lblTecnico = new JLabel("Tecnico:");
		lblTecnico.setBounds(142, 30, 46, 14);
		contentPane.add(lblTecnico);
		
		JLabel lblGananciaPorOrden = new JLabel("Ganancia por orden:");
		lblGananciaPorOrden.setBounds(220, 30, 204, 14);
		contentPane.add(lblGananciaPorOrden);
	}

	public void ReporteGanancias1(SList ordenes) {
		// TODO Auto-generated constructor stub
	}
}
