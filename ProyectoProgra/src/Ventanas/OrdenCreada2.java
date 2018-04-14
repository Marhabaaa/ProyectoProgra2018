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

public class OrdenCreada2 extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public OrdenCreada2(String nombre) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 570, 354);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.desktop);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("Orden N\u00B0 <dynamic> ingresada con \u00E9xito.");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Segoe UI Black", Font.PLAIN, 16));
		label.setBounds(108, 91, 354, 42);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("Para <dynamic>"+ nombre);
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		label_1.setBounds(206, 126, 133, 34);
		contentPane.add(label_1);
		
		JLabel lblCosto = new JLabel("Costo total: <dynamic>");
		lblCosto.setForeground(SystemColor.text);
		lblCosto.setBounds(206, 171, 174, 14);
		contentPane.add(lblCosto);
		
		JLabel lblTiempoEstimado = new JLabel("Tiempo estimado: <dynamic>");
		lblTiempoEstimado.setForeground(SystemColor.text);
		lblTiempoEstimado.setBounds(195, 196, 174, 14);
		contentPane.add(lblTiempoEstimado);
		
		JButton btnFinalizar = new JButton("Finalizar");
		btnFinalizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				OrdenCreada2.this.dispose();
			}
		});
		btnFinalizar.setBounds(280, 221, 89, 23);
		contentPane.add(btnFinalizar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//BORRAR CLIENTE Y ORDEN DEL SISTEMA
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
