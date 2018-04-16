package Ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.Orden;
import clases.SST;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EliminadorDeOrdenes extends JFrame {

	private JPanel contentPane;
	private JTextField eliminarOrden;


	/**
	 * Create the frame.
	 */
	public EliminadorDeOrdenes(SST B) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.desktop);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIngreseCodigoDe = new JLabel("Ingrese codigo");
		lblIngreseCodigoDe.setForeground(SystemColor.text);
		lblIngreseCodigoDe.setBounds(75, 99, 154, 14);
		contentPane.add(lblIngreseCodigoDe);
		
		JLabel lblAEliminar = new JLabel(" de orden a eliminar:");
		lblAEliminar.setForeground(SystemColor.text);
		lblAEliminar.setBounds(70, 116, 115, 14);
		contentPane.add(lblAEliminar);
		
		eliminarOrden = new JTextField();
		eliminarOrden.setBounds(176, 113, 86, 20);
		contentPane.add(eliminarOrden);
		eliminarOrden.setColumns(10);
		
		String code = eliminarOrden.getText();
		JButton botonEliminarOrden = new JButton("Eliminar"); //se elimina la orden
		if(!code.equals("")) {
			int codigo=Integer.parseInt(eliminarOrden.getText());
				botonEliminarOrden.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						B.getOrdersMap().remove(codigo);
					}
				});
		}
		botonEliminarOrden.setBounds(272, 112, 89, 23);
		contentPane.add(botonEliminarOrden);
	}
}
