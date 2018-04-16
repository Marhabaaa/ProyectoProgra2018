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
import java.awt.Color;

public class ReporteGanancias extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public ReporteGanancias(SList ordenes) {
		
		Report reporte= new Report();

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
		numeroDeOrden.setForeground(Color.WHITE);
		numeroDeOrden.setBounds(36, 30, 112, 14);
		contentPane.add(numeroDeOrden);
		String aux;
		Orden o;
		int suma=0;
		DefaultListModel modelo = new DefaultListModel();
		for(int j=0;j<ordenes.size();j++) {			
			o= (Orden)ordenes.get(j);
				aux = o.getOrderNumber()+"                   " + o.getTechNumber()+ "                    " + o.getProfit();
				modelo.addElement(aux);
				suma = suma + o.getProfit();
		}
		
		JLabel lblTecnico = new JLabel("Tecnico:");
		lblTecnico.setForeground(Color.WHITE);
		lblTecnico.setBounds(142, 30, 68, 14);
		contentPane.add(lblTecnico);
		
		JLabel lblGananciaPorOrden = new JLabel("Ganancia por orden:");
		lblGananciaPorOrden.setForeground(Color.WHITE);
		lblGananciaPorOrden.setBounds(220, 30, 204, 14);
		contentPane.add(lblGananciaPorOrden);
		
		JLabel lblTotal = new JLabel("Total: "+suma);
		lblTotal.setForeground(Color.WHITE);
		lblTotal.setBounds(36, 219, 162, 14);
		contentPane.add(lblTotal);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(36, 55, 319, 148);
		contentPane.add(scrollPane);
		
		JList reportesDeOrdenes = new JList();
		scrollPane.setViewportView(reportesDeOrdenes);
		reportesDeOrdenes.setModel(modelo);
	}

	public void ReporteGanancias1(SList ordenes) {
		// TODO Auto-generated constructor stub
	}
}
