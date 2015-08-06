package vista;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.border.EtchedBorder;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InscribirEstudiante extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InscribirEstudiante frame = new InscribirEstudiante();
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
	public InscribirEstudiante() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 547, 417);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 139, 139));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Inscribir alumno en curso", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 255, 255)));
		panel.setBackground(new Color(0, 139, 139));
		
		JLabel lblProfesor = new JLabel("Profesor");
		lblProfesor.setIcon(new ImageIcon("C:\\Users\\Heber\\Documents\\ProyectoGestionEducacional\\ProyectoGestionEduc-Escritorio\\src\\Files\\macho-de-color-marron-rojo-blanco-de-usuario-icono-9675-32.png"));
		lblProfesor.setForeground(new Color(255, 255, 240));
		lblProfesor.setFont(new Font("Calibri", Font.PLAIN, 21));
		
		JButton button = new JButton("Volver");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		button.setIcon(new ImageIcon("C:\\Users\\Heber\\Documents\\ProyectoGestionEducacional\\ProyectoGestionEduc-Escritorio\\src\\Files\\deshacer-icono-5993-16.png"));
		button.setFont(new Font("Calibri", Font.PLAIN, 12));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(button)
					.addContainerGap(434, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(204, Short.MAX_VALUE)
					.addComponent(lblProfesor, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)
					.addGap(171))
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addGap(75)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 383, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(63, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(16)
					.addComponent(lblProfesor, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(button))
		);
		panel.setLayout(null);
		
		JLabel label = new JLabel("Rut estudiante:");
		label.setForeground(new Color(255, 255, 240));
		label.setFont(new Font("Calibri", Font.PLAIN, 12));
		label.setBounds(10, 24, 97, 14);
		panel.add(label);
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 16));
		textArea.setBounds(10, 37, 105, 22);
		panel.add(textArea);
		
		JLabel label_1 = new JLabel("(Sin puntos y sin d\u00EDgito verificador)");
		label_1.setForeground(Color.LIGHT_GRAY);
		label_1.setBounds(10, 61, 228, 14);
		panel.add(label_1);
		
		JButton btnIngresar = new JButton("Ingresar");
		btnIngresar.setFont(new Font("Calibri", Font.PLAIN, 12));
		btnIngresar.setBounds(120, 37, 97, 23);
		panel.add(btnIngresar);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_1.setBackground(new Color(0, 139, 139));
		panel_1.setBounds(10, 79, 292, 92);
		panel.add(panel_1);
		
		JLabel label_2 = new JLabel("Nombre:");
		label_2.setForeground(new Color(255, 255, 240));
		label_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_2.setBounds(10, 0, 164, 25);
		panel_1.add(label_2);
		
		JLabel label_3 = new JLabel("Apellido:");
		label_3.setForeground(new Color(255, 255, 240));
		label_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_3.setBounds(10, 22, 164, 25);
		panel_1.add(label_3);
		
		JLabel label_4 = new JLabel("Rut: ");
		label_4.setForeground(new Color(255, 255, 240));
		label_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_4.setBounds(10, 51, 164, 14);
		panel_1.add(label_4);
		
		JLabel label_5 = new JLabel("Estado Matr\u00EDcula:");
		label_5.setForeground(new Color(255, 255, 240));
		label_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_5.setBounds(10, 72, 164, 14);
		panel_1.add(label_5);
		
		JLabel label_6 = new JLabel("");
		label_6.setForeground(new Color(255, 255, 240));
		label_6.setBounds(118, 72, 164, 14);
		panel_1.add(label_6);
		
		JLabel label_7 = new JLabel("");
		label_7.setForeground(new Color(255, 255, 240));
		label_7.setBounds(118, 51, 164, 14);
		panel_1.add(label_7);
		
		JLabel label_8 = new JLabel("");
		label_8.setForeground(new Color(255, 255, 240));
		label_8.setBounds(118, 22, 164, 25);
		panel_1.add(label_8);
		
		JLabel label_9 = new JLabel("");
		label_9.setForeground(new Color(255, 255, 240));
		label_9.setBounds(118, 0, 164, 25);
		panel_1.add(label_9);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 139, 139));
		panel_2.setBounds(10, 200, 117, 67);
		panel.add(panel_2);
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
		);
		
		JList list = new JList();
		scrollPane.setViewportView(list);
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"Matem\u00E1tica", "C\u00E1lculo", "Programaci\u00F3n", "\u00C1lgebra", "Base de datos"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		panel_2.setLayout(gl_panel_2);
		
		JLabel lblCursosDisponibles = new JLabel("Cursos disponibles:");
		lblCursosDisponibles.setForeground(new Color(255, 255, 240));
		lblCursosDisponibles.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblCursosDisponibles.setBounds(18, 182, 143, 14);
		panel.add(lblCursosDisponibles);
		
		JButton btnInscribir = new JButton("Inscribir");
		btnInscribir.setIcon(new ImageIcon("C:\\Users\\Heber\\Documents\\ProyectoGestionEducacional\\ProyectoGestionEduc-Escritorio\\src\\Files\\anadir-mas-icono-5518-16.png"));
		btnInscribir.setBounds(268, 244, 105, 23);
		panel.add(btnInscribir);
		contentPane.setLayout(gl_contentPane);
	}

}
