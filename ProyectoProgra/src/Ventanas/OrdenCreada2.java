package Ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import clases.SList;
import clases.Pieza;
import clases.Orden;
import clases.Cliente;
import clases.Tecnico;
import clases.SST;

public class OrdenCreada2 extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public OrdenCreada2(String nombre, Orden order, SST B) { //aqui se muestra por pantalla la orden,
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);	 //el tiempo estimado y el valor total
		setBounds(100, 100, 570, 354);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.desktop);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("Orden N\u00B0 " + order.getOrderNumber() + " ingresada con \u00E9xito.");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Segoe UI Black", Font.PLAIN, 16));
		label.setBounds(108, 91, 354, 42);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("Para "+ nombre);
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		label_1.setBounds(206, 126, 133, 34);
		contentPane.add(label_1);
		
		JLabel lblCosto = new JLabel("Costo total: " + order.getPrice());
		lblCosto.setForeground(SystemColor.text);
		lblCosto.setBounds(206, 171, 174, 14);
		contentPane.add(lblCosto);
		
		JLabel lblTiempoEstimado = new JLabel("Dias para entrega: " + order.getDateOut());
		lblTiempoEstimado.setForeground(SystemColor.text);
		lblTiempoEstimado.setBounds(195, 196, 174, 14);
		contentPane.add(lblTiempoEstimado);
		
		JButton btnFinalizar = new JButton("Finalizar");		//aqui se crea la orden y se devuelve al menu principal
		btnFinalizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				((Cliente) B.getClientsMap().get(order.getClientRut())).getOrders().add(order);
				((Tecnico) B.getTechsMap().get(order.getTechNumber())).getOrders().add(order);
				B.getOrdersMap().put(order.getOrderNumber(), order);
				OrdenCreada2.this.dispose();
			}
		});
		btnFinalizar.setBounds(280, 221, 89, 23);
		contentPane.add(btnFinalizar);
		
		JButton btnCancelar = new JButton("Cancelar");			//se cancela la creacion de la orden y se devuelve
		btnCancelar.addActionListener(new ActionListener() {	//al menu principal
			public void actionPerformed(ActionEvent arg0) {
				OrdenCreada2.this.dispose();
			}
		});
		btnCancelar.setBounds(157, 221, 89, 23);
		contentPane.add(btnCancelar);
	}

	public void OrdenCreada21(String nombre) {
		// TODO Auto-generated constructor stub
	}
}
