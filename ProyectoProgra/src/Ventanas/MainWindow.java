package Ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import java.io.*;
import java.util.Date;
import java.util.Enumeration;
import java.text.SimpleDateFormat;





public class MainWindow extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow frame = new MainWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainWindow() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainWindow.class.getResource("/imageness/fondo-azul-836335-1.jpg")));
		setTitle("11 chupalo entonceh");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 549, 345);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.desktop);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setBackground(SystemColor.textHighlight);
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnSalir.setBounds(452, 11, 71, 23);
		contentPane.add(btnSalir);
		
		JButton btnNewButton = new JButton("Nueva Orden");
		btnNewButton.setBackground(SystemColor.textHighlight);
		
		btnNewButton.setFont(new Font("Segoe UI Black", Font.PLAIN, 23));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(10, 11, 187, 54);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Ver Ordenes");
		btnNewButton_1.setFont(new Font("Segoe UI Black", Font.PLAIN, 23));
		btnNewButton_1.setBackground(SystemColor.textHighlight);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(10, 76, 187, 54);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Piezas");
		btnNewButton_2.setBackground(SystemColor.textHighlight);
		btnNewButton_2.setFont(new Font("Segoe UI Black", Font.PLAIN, 23));
		btnNewButton_2.setBounds(336, 76, 187, 54);
		contentPane.add(btnNewButton_2);
		
		Date hoy= new Date(); 
		SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy"); 
		String fecha = sdf.format(hoy); 
		
		JTextPane txtpnDateformatDateformat = new JTextPane();
		txtpnDateformatDateformat.setBackground(SystemColor.desktop);
		txtpnDateformatDateformat.setText("Fecha:" + fecha);
		txtpnDateformatDateformat.setBounds(409, 275, 114, 20);
		contentPane.add(txtpnDateformatDateformat);
	}
}
