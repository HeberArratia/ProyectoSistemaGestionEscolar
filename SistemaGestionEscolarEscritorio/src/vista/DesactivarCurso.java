package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.border.TitledBorder;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.border.EtchedBorder;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DesactivarCurso extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DesactivarCurso frame = new DesactivarCurso();
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
	public DesactivarCurso() {

	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 547, 417);
	contentPane = new JPanel();
	contentPane.setBackground(new Color(0, 139, 139));
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	
	JLabel label = new JLabel("Director");
	label.setIcon(new ImageIcon("C:\\Users\\Heber\\Documents\\ProyectoGestionEducacional\\ProyectoGestionEduc-Escritorio\\src\\Files\\azul-marron-usuario-varon-blanco-icono-5443-32.png"));
	label.setForeground(new Color(255, 255, 240));
	label.setFont(new Font("Calibri", Font.PLAIN, 21));
	
	JPanel panel = new JPanel();
	panel.setBorder(new TitledBorder(null, "Desactivar Curso", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 255, 255)));
	panel.setBackground(new Color(0, 139, 139));
	
	JButton button = new JButton("Volver");
	button.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
		}
	});
	button.setIcon(new ImageIcon("C:\\Users\\Heber\\Documents\\ProyectoGestionEducacional\\ProyectoGestionEduc-Escritorio\\src\\Files\\deshacer-icono-5993-16.png"));
	button.setFont(new Font("Calibri", Font.PLAIN, 12));
	GroupLayout gl_contentPane = new GroupLayout(contentPane);
	gl_contentPane.setHorizontalGroup(
		gl_contentPane.createParallelGroup(Alignment.TRAILING)
			.addGroup(gl_contentPane.createSequentialGroup()
				.addGap(71)
				.addComponent(panel, GroupLayout.PREFERRED_SIZE, 383, GroupLayout.PREFERRED_SIZE)
				.addContainerGap(83, Short.MAX_VALUE))
			.addGroup(gl_contentPane.createSequentialGroup()
				.addContainerGap(207, Short.MAX_VALUE)
				.addComponent(label, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)
				.addGap(184))
			.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
				.addComponent(button, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
				.addContainerGap(451, Short.MAX_VALUE))
	);
	gl_contentPane.setVerticalGroup(
		gl_contentPane.createParallelGroup(Alignment.LEADING)
			.addGroup(gl_contentPane.createSequentialGroup()
				.addGap(23)
				.addComponent(label, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
				.addGap(18)
				.addComponent(panel, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.RELATED, 107, Short.MAX_VALUE)
				.addComponent(button))
	);
	panel.setLayout(null);
	
	JTextArea textArea = new JTextArea();
	textArea.setFont(new Font("Monospaced", Font.PLAIN, 16));
	textArea.setBounds(10, 38, 105, 22);
	panel.add(textArea);
	
	JLabel lblCdigoCurso = new JLabel("C\u00F3digo curso:");
	lblCdigoCurso.setForeground(new Color(255, 255, 240));
	lblCdigoCurso.setFont(new Font("Calibri", Font.PLAIN, 12));
	lblCdigoCurso.setBounds(10, 25, 97, 14);
	panel.add(lblCdigoCurso);
	
	JButton btnIngresar = new JButton("Ingresar");
	btnIngresar.setFont(new Font("Calibri", Font.PLAIN, 12));
	btnIngresar.setBounds(120, 38, 97, 23);
	panel.add(btnIngresar);
	
	JPanel panel_1 = new JPanel();
	panel_1.setLayout(null);
	panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
	panel_1.setBackground(new Color(0, 139, 139));
	panel_1.setBounds(10, 74, 292, 49);
	panel.add(panel_1);
	
	JLabel lblNombreCurso = new JLabel("Nombre Curso:");
	lblNombreCurso.setForeground(new Color(255, 255, 240));
	lblNombreCurso.setFont(new Font("Tahoma", Font.BOLD, 11));
	lblNombreCurso.setBounds(10, 0, 164, 25);
	panel_1.add(lblNombreCurso);
	
	JLabel lblProfesorAsignado = new JLabel("Profesor Asignado:");
	lblProfesorAsignado.setForeground(new Color(255, 255, 240));
	lblProfesorAsignado.setFont(new Font("Tahoma", Font.BOLD, 11));
	lblProfesorAsignado.setBounds(10, 22, 164, 25);
	panel_1.add(lblProfesorAsignado);
	
	JLabel label_5 = new JLabel("");
	label_5.setForeground(new Color(255, 255, 240));
	label_5.setBounds(118, 72, 164, 14);
	panel_1.add(label_5);
	
	JLabel label_6 = new JLabel("");
	label_6.setForeground(new Color(255, 255, 240));
	label_6.setBounds(118, 51, 164, 14);
	panel_1.add(label_6);
	
	JLabel label_7 = new JLabel("");
	label_7.setForeground(new Color(255, 255, 240));
	label_7.setBounds(118, 22, 164, 25);
	panel_1.add(label_7);
	
	JLabel label_8 = new JLabel("");
	label_8.setForeground(new Color(255, 255, 240));
	label_8.setBounds(118, 0, 164, 25);
	panel_1.add(label_8);
	
	JButton btnDesactivar = new JButton("Desactivar");
	btnDesactivar.setFont(new Font("Calibri", Font.PLAIN, 12));
	btnDesactivar.setBounds(276, 143, 97, 23);
	panel.add(btnDesactivar);
	contentPane.setLayout(gl_contentPane);
}

	

}
