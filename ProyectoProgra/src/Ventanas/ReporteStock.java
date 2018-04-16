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
import java.awt.SystemColor;
import javax.swing.JLabel;

public class ReporteStock<E> extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */	
	public ReporteStock(SList ordenes, SST B) {				//aqui se muestra por pantalla el reporte del inventario de piezas
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.desktop);
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
		scrollPane.setBounds(37, 54, 358, 134);
		contentPane.add(scrollPane);
		
		JList list = new JList();
		String aux;
		SList piezas=B.getStockMap().toSList();
		Pieza p;
		DefaultListModel modelo = new DefaultListModel();
		for (int i=0;i<piezas.size();i++) {
			p=(Pieza) piezas.get(i);
			//aux=" " +p.getCode()+ "                                           "+p.getDescription()+"                                           "+p.getCant(); 
			aux=" " +p.getCode()+ "                                      "+p.getCant()+"                                   "+p.getDescription(); 
			modelo.addElement(aux);
		}
		scrollPane.setViewportView(list);
		list.setModel(modelo);
		
		JLabel lblMaterialDelInventario = new JLabel("Codigo:                           Cantidad:                          Nombre: \r\n");
		lblMaterialDelInventario.setForeground(SystemColor.menu);
		lblMaterialDelInventario.setBounds(37, 29, 387, 14);
		contentPane.add(lblMaterialDelInventario);
		
		JLabel lblNewLabel = new JLabel("Material del inventario:");
		lblNewLabel.setForeground(SystemColor.inactiveCaptionBorder);
		lblNewLabel.setBounds(37, 11, 167, 14);
		contentPane.add(lblNewLabel);
		
		
	}

	public void ReporteStock1(SList ordenes) {
		// TODO Auto-generated constructor stub
	}
}
