package Ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class OrdenCreada1 extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	//public OrdenCreada1(String nombre) {
	public OrdenCreada1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 570, 354);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.desktop);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblOrdenNIngresada = new JLabel((String) null);
		lblOrdenNIngresada.setBounds(107, 31, 348, 66);
		contentPane.add(lblOrdenNIngresada);
		
		JLabel lblOrdenNIngresada_1 = new JLabel("Orden N\u00B0 <dynamic> ingresada con \u00E9xito.");
		lblOrdenNIngresada_1.setFont(new Font("Segoe UI Black", Font.PLAIN, 16));
		lblOrdenNIngresada_1.setForeground(SystemColor.text);
		lblOrdenNIngresada_1.setBounds(95, 95, 354, 42);
		contentPane.add(lblOrdenNIngresada_1);
		
		JLabel lblSujetaARevisin = new JLabel("Sujeta a revisi\u00F3n.");
		lblSujetaARevisin.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		lblSujetaARevisin.setForeground(SystemColor.text);
		lblSujetaARevisin.setBounds(194, 158, 133, 34);
		contentPane.add(lblSujetaARevisin);
		
		JButton btnMenuPrincipal = new JButton("Finalizar");
		btnMenuPrincipal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainWindow ventana = new MainWindow();
				setVisible(false);
				ventana.setVisible(true);
			}
		});
		btnMenuPrincipal.setBounds(403, 235, 108, 23);
		contentPane.add(btnMenuPrincipal);
		
		JLabel lblPara = new JLabel("Para <dynamic>");
		lblPara.setForeground(SystemColor.text);
		lblPara.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		lblPara.setBounds(194, 130, 133, 34);
		contentPane.add(lblPara);
	}
}
