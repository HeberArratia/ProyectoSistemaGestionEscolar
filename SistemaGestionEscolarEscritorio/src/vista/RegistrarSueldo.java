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
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.border.EtchedBorder;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegistrarSueldo extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistrarSueldo frame = new RegistrarSueldo();
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
	public RegistrarSueldo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 547, 417);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 139, 139));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 139, 139));
		panel.setForeground(new Color(0, 139, 139));
		panel.setBorder(new TitledBorder(null, "Pagar sueldo profesor", TitledBorder.LEADING, TitledBorder.TOP, null, Color.WHITE));
		
		JLabel lblJefeAdm = new JLabel("Jefe Adm.");
		lblJefeAdm.setIcon(new ImageIcon("C:\\Users\\Heber\\Documents\\ProyectoGestionEducacional\\ProyectoGestionEduc-Escritorio\\src\\Files\\green-usuario-varon-blanco-icono-5465-32.png"));
		lblJefeAdm.setForeground(new Color(255, 255, 240));
		lblJefeAdm.setFont(new Font("Calibri", Font.PLAIN, 21));
		
		JButton button_1 = new JButton("Volver");
		button_1.setIcon(new ImageIcon("C:\\Users\\Heber\\Documents\\ProyectoGestionEducacional\\ProyectoGestionEduc-Escritorio\\src\\Files\\deshacer-icono-5993-16.png"));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Bienvenido bien = new Bienvenido();
				bien.setVisible(true);
				setVisible(false);
			}
		});
		button_1.setFont(new Font("Calibri", Font.PLAIN, 12));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(button_1)
					.addContainerGap(444, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(90, Short.MAX_VALUE)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 355, GroupLayout.PREFERRED_SIZE)
					.addGap(76))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(193, Short.MAX_VALUE)
					.addComponent(lblJefeAdm, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)
					.addGap(182))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(20)
					.addComponent(lblJefeAdm, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 260, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
					.addComponent(button_1)
					.addGap(7))
		);
		panel.setLayout(null);
		
		JTextArea textArea_3 = new JTextArea();
		textArea_3.setFont(new Font("Monospaced", Font.PLAIN, 16));
		textArea_3.setBounds(10, 46, 105, 22);
		panel.add(textArea_3);
		
		JLabel label_15 = new JLabel("(Sin puntos y sin d\u00EDgito verificador)");
		label_15.setForeground(Color.LIGHT_GRAY);
		label_15.setBounds(10, 70, 228, 14);
		panel.add(label_15);
		
		JLabel lblRutProfesor = new JLabel("Rut profesor:");
		lblRutProfesor.setForeground(new Color(255, 255, 240));
		lblRutProfesor.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblRutProfesor.setBounds(10, 33, 97, 14);
		panel.add(lblRutProfesor);
		
		JButton button_3 = new JButton("Ingresar");
		button_3.setFont(new Font("Calibri", Font.PLAIN, 12));
		button_3.setBounds(120, 46, 97, 23);
		panel.add(button_3);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_1.setBackground(new Color(0, 139, 139));
		panel_1.setBounds(10, 97, 292, 119);
		panel.add(panel_1);
		
		JLabel label_1 = new JLabel("Nombre:");
		label_1.setForeground(new Color(255, 255, 240));
		label_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_1.setBounds(10, 0, 164, 25);
		panel_1.add(label_1);
		
		JLabel label_2 = new JLabel("Apellido:");
		label_2.setForeground(new Color(255, 255, 240));
		label_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_2.setBounds(10, 22, 164, 25);
		panel_1.add(label_2);
		
		JLabel label_3 = new JLabel("Rut: ");
		label_3.setForeground(new Color(255, 255, 240));
		label_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_3.setBounds(10, 51, 164, 14);
		panel_1.add(label_3);
		
		JLabel lblNCursos = new JLabel("N\u00B0 Cursos:");
		lblNCursos.setForeground(new Color(255, 255, 240));
		lblNCursos.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNCursos.setBounds(10, 72, 164, 14);
		panel_1.add(lblNCursos);
		
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
		
		JLabel lblSueldoTotal = new JLabel("Sueldo total:");
		lblSueldoTotal.setForeground(new Color(255, 255, 240));
		lblSueldoTotal.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSueldoTotal.setBounds(10, 95, 164, 14);
		panel_1.add(lblSueldoTotal);
		
		JButton button = new JButton("Registrar");
		button.setBounds(256, 226, 89, 23);
		panel.add(button);
		contentPane.setLayout(gl_contentPane);
	}
}
