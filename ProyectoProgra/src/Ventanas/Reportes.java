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

import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;
import clases.SST;
public class Reportes extends JFrame {

	private JPanel contentPane;


	/**
	 * Create the frame.
	 */
	public Reportes(SList ordenes, SST B) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.desktop);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton ReporteGanancias = new JButton("Ganancias totales");
		ReporteGanancias.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReporteGanancias ventana1= new ReporteGanancias(ordenes);
				ventana1.setVisible(true);
			}
		});
		ReporteGanancias.setBounds(34, 127, 162, 23);
		contentPane.add(ReporteGanancias);
		
		JButton Stock = new JButton("Stock");
		Stock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReporteStock ventana2= new ReporteStock(ordenes,B);
				ventana2.setVisible(true);
			}
		});
		Stock.setBounds(225, 127, 177, 23);
		contentPane.add(Stock);
		
		JButton btnNewButton_2 = new JButton("Generar reporte");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				File f= new File ("Reporte.txt");
				BufferedWriter bw = null;
				try {
					bw = new BufferedWriter(new FileWriter("Reporte.txt"));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				Orden o;
				int suma=0;
				if(f.exists()) {

					try {
						bw.write(" Numero de orden 	    	Tecnico			Ganacia por orden ");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					for (int i=0;i<ordenes.size();i++) {
						o = (Orden)ordenes.get(i);
						if(o.isDone()) {
						   try {
							bw.newLine();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						   try {
							bw.write(" " + o.getOrderNumber()+"				" + o.getTechNumber()+ "				" + o.getProfit());
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						   suma = suma + o.getProfit();
						}
					}
					try {
						bw.newLine();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					try {
						bw.write("la ganancia total es: "+ suma);
					} catch (IOException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					try {
						bw.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}	
				}
			}
		}
				
		);
		btnNewButton_2.setBounds(34, 150, 162, 23);
		contentPane.add(btnNewButton_2);
		
		JButton GenerarReporte2 = new JButton("Generar Reporte");
		GenerarReporte2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				File f= new File ("ReporteStock.txt");
				Orden o;
				int suma=0;
				BufferedWriter bw = null;
				try {
					bw = new BufferedWriter(new FileWriter("ReporteStock.txt"));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if(f.exists()) {

					try {
						bw.write(" Material del inventario \n");
					} catch (IOException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					try {
						bw.write("Codigo           Nombre                       Cantidad \n");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					for (int j=0;j<ordenes.size();j++) {
						o= (Orden)ordenes.get(j);
						for (int i=0;i<o.getPartsList().size();i++) {
							Pieza p = (Pieza)o.getPartsList().get(i);
							try {
								bw.newLine();
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							try {
								bw.write("    		          " +p.getCode()+ "		"+p.getDescription()+"		"+p.getCant() +"\n");
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}	
						}
					}
						try {
							bw.newLine();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					try {
						bw.write("la gananacia total es: "+ suma);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					try {
						bw.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}	
				//AQUI HAY QUE HACER EL ARCHIVO REPORTE DE STOCK
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
