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
import clases.Report;

import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class Reportes extends JFrame {

	private JPanel contentPane;


	/**
	 * Create the frame.
	 */
	public Reportes(SList ordenes, SST B) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.desktop);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton ReporteGanancias = new JButton("Ganancias totales");		//se crea una ventana donde se muestra por pantalla el reporte de ganancias
		ReporteGanancias.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReporteGanancias ventana1= new ReporteGanancias(ordenes);
				ventana1.setVisible(true);
			}
		});
		ReporteGanancias.setBounds(34, 127, 162, 23);
		contentPane.add(ReporteGanancias);
		
		JButton Stock = new JButton("Reporte Stock");						//se crea una ventana donde se muestra por pantalla el reporte de piezas del inventario
		Stock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReporteStock ventana2= new ReporteStock(ordenes,B);
				ventana2.setVisible(true);
			}
		});
		Stock.setBounds(225, 127, 177, 23);
		contentPane.add(Stock);
		
		JButton btnNewButton_2 = new JButton("Generar reporte");			//se crea el archivo .txt de reporte de ganancias
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Report r = new Report();
				try {
					r.ganaciasTotales(ordenes);
				} catch (IOException e1) {
					System.out.println("Error al generar reporte!");
					e1.printStackTrace();
				}
			}
		}
				
		);
		btnNewButton_2.setBounds(34, 150, 162, 23);
		contentPane.add(btnNewButton_2);
		
		JButton GenerarReporte2 = new JButton("Generar Reporte");			//se crea el archivo .txt de reporte de piezas del inventario
		GenerarReporte2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Report r = new Report();
				try {
					r.stock(B.getStockMap().toSList());
				} catch (IOException e1) {
					System.out.println("Error al generar reporte!");
					e1.printStackTrace();
				}
			}
		});
		GenerarReporte2.setBounds(225, 150, 177, 23);
		contentPane.add(GenerarReporte2);
		
		JButton button = new JButton("Volver");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Reportes.this.dispose();
			}
		});
		button.setBounds(310, 227, 89, 23);
		contentPane.add(button);
	}


	public void Reportes1(SList sList, SST b) {
		// TODO Auto-generated constructor stub
	}





	

}
