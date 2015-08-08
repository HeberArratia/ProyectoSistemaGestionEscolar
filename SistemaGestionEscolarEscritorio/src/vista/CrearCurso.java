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
import javax.swing.UIManager;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CrearCurso extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CrearCurso frame = new CrearCurso();
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
	public CrearCurso() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 547, 417);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 139, 139));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel label = new JLabel("Jefe Adm.");
		label.setIcon(new ImageIcon("C:\\Users\\Heber\\Documents\\ProyectoGestionEducacional\\ProyectoGestionEduc-Escritorio\\src\\Files\\green-usuario-varon-blanco-icono-5465-32.png"));
		label.setForeground(new Color(255, 255, 240));
		label.setFont(new Font("Calibri", Font.PLAIN, 21));
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Crear curso y asignar profesor", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 255, 255)));
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
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(74, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 409, GroupLayout.PREFERRED_SIZE)
							.addGap(54))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(label, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)
							.addGap(173))))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(button, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(450, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(28)
					.addComponent(label, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 212, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
					.addComponent(button, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addGap(14))
		);
		panel.setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 16));
		textArea.setBounds(21, 36, 160, 22);
		panel.add(textArea);
		
		JLabel lblNombreCurso = new JLabel("Nombre curso:");
		lblNombreCurso.setForeground(new Color(255, 255, 240));
		lblNombreCurso.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblNombreCurso.setBounds(21, 23, 97, 14);
		panel.add(lblNombreCurso);
		
		JButton btnCrear = new JButton("Crear");
		btnCrear.setFont(new Font("Calibri", Font.PLAIN, 12));
		btnCrear.setBounds(182, 37, 97, 23);
		panel.add(btnCrear);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setFont(new Font("Monospaced", Font.PLAIN, 16));
		textArea_1.setBounds(21, 82, 72, 22);
		panel.add(textArea_1);
		
		JLabel lblCdigoCurso = new JLabel("C\u00F3digo curso:");
		lblCdigoCurso.setForeground(new Color(255, 255, 240));
		lblCdigoCurso.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblCdigoCurso.setBounds(21, 69, 97, 14);
		panel.add(lblCdigoCurso);
		
		JTextArea txtrCursoCreado = new JTextArea();
		txtrCursoCreado.setEnabled(false);
		txtrCursoCreado.setFont(new Font("Monospaced", Font.PLAIN, 12));
		txtrCursoCreado.setBounds(21, 127, 105, 22);
		panel.add(txtrCursoCreado);
		
		JLabel label_2 = new JLabel("Nombre curso:");
		label_2.setForeground(new Color(255, 255, 240));
		label_2.setFont(new Font("Calibri", Font.PLAIN, 12));
		label_2.setBounds(21, 114, 97, 14);
		panel.add(label_2);
		
		JTextArea textArea_3 = new JTextArea();
		textArea_3.setFont(new Font("Monospaced", Font.PLAIN, 16));
		textArea_3.setBounds(21, 173, 105, 22);
		panel.add(textArea_3);
		
		JLabel lblRutProfesor = new JLabel("Rut profesor:");
		lblRutProfesor.setForeground(new Color(255, 255, 240));
		lblRutProfesor.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblRutProfesor.setBounds(21, 160, 97, 14);
		panel.add(lblRutProfesor);
		
		JButton btnAsignarProfesor = new JButton("Asignar profesor");
		btnAsignarProfesor.setBounds(261, 177, 138, 23);
		panel.add(btnAsignarProfesor);
		contentPane.setLayout(gl_contentPane);
	}


}
