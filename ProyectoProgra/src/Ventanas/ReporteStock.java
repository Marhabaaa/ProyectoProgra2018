package Ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.SList;
import clases.SMap;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ReporteStock extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public ReporteStock(SList ordenes) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReporteStock.this.dispose();
			}
		});
		btnVolver.setBounds(306, 214, 89, 23);
		contentPane.add(btnVolver);
		
		
	}

	public void ReporteStock1(SList ordenes) {
		// TODO Auto-generated constructor stub
	}




}
