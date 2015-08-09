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

import servicio.ServicioCursoProxy;

import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.border.EtchedBorder;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class DesactivarCurso extends JFrame {

	private JPanel contentPane;
	private JTextField txtCodigoCurso;

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
			Bienvenido bien = new Bienvenido();
			bien.setVisible(true);
			setVisible(false);
		}
	});
	button.setIcon(new ImageIcon("C:\\Users\\Heber\\Documents\\ProyectoGestionEducacional\\ProyectoGestionEduc-Escritorio\\src\\Files\\deshacer-icono-5993-16.png"));
	button.setFont(new Font("Calibri", Font.PLAIN, 12));
	GroupLayout gl_contentPane = new GroupLayout(contentPane);
	gl_contentPane.setHorizontalGroup(
		gl_contentPane.createParallelGroup(Alignment.LEADING)
			.addGroup(gl_contentPane.createSequentialGroup()
				.addContainerGap(207, Short.MAX_VALUE)
				.addComponent(label, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)
				.addGap(184))
			.addGroup(gl_contentPane.createSequentialGroup()
				.addComponent(button, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
				.addContainerGap(451, Short.MAX_VALUE))
			.addGroup(gl_contentPane.createSequentialGroup()
				.addGap(71)
				.addComponent(panel, GroupLayout.PREFERRED_SIZE, 383, GroupLayout.PREFERRED_SIZE)
				.addContainerGap(83, Short.MAX_VALUE))
	);
	gl_contentPane.setVerticalGroup(
		gl_contentPane.createParallelGroup(Alignment.LEADING)
			.addGroup(gl_contentPane.createSequentialGroup()
				.addGap(23)
				.addComponent(label, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
				.addGap(18)
				.addComponent(panel, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.RELATED, 188, Short.MAX_VALUE)
				.addComponent(button))
	);
	panel.setLayout(null);
	
	JLabel lblCdigoCurso = new JLabel("C\u00F3digo curso:");
	lblCdigoCurso.setForeground(new Color(255, 255, 240));
	lblCdigoCurso.setFont(new Font("Calibri", Font.PLAIN, 12));
	lblCdigoCurso.setBounds(10, 25, 97, 14);
	panel.add(lblCdigoCurso);
	
	txtCodigoCurso = new JTextField();
	txtCodigoCurso.setBounds(7, 40, 134, 28);
	panel.add(txtCodigoCurso);
	txtCodigoCurso.setColumns(10);
	
	JLabel lblInfo = new JLabel("");
	lblInfo.setForeground(Color.WHITE);
	lblInfo.setBounds(11, 69, 345, 16);
	panel.add(lblInfo);
	
	JButton btnNewButton_1 = new JButton("Desactivar");
	btnNewButton_1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {		
			try {
				//Obtenemos el codigo del curso
				String codigoCurso = txtCodigoCurso.getText();
				//Si el codigo del curso es un dato entero y tiene informacion se puede proceder
				if (codigoCurso.matches("\\d*") && !codigoCurso.equals("")){
					//Convertimos el codigo de curso a entero
					int idCurso = Integer.parseInt(codigoCurso);
					//Requerimos el servicio que permite desactivar el curso
					ServicioCursoProxy curso = new ServicioCursoProxy();
					//Enviamos los parametros y almacenamos el valor de retorno
					String resultado = curso.desactivarCurso(idCurso, "52347653");
					//Imprimimos mensaje de confirmacion al usuario
					lblInfo.setText(resultado);
				//Si el codigo de curso no es entero se imprime mensaje al usuario
				} else {
					lblInfo.setText("Código de curso inválido");
				}
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	});
	btnNewButton_1.setBounds(137, 41, 117, 29);
	panel.add(btnNewButton_1);
	
	
	contentPane.setLayout(gl_contentPane);
}
}
