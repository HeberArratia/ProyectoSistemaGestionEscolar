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

import servicio.ServicioCursoProxy;

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
import java.rmi.RemoteException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class InscribirEstudiante extends JFrame {

	private JPanel contentPane;
	private JTextField textRutProfesor;
	private JTextField txtRutEstudiante;
	private JTextField txtCodigoCurso;

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
					.addContainerGap(220, Short.MAX_VALUE)
					.addComponent(lblProfesor, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)
					.addGap(171))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(75)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 383, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(79, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(button, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(457, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(16)
					.addComponent(lblProfesor, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 291, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(button))
		);
		panel.setLayout(null);
		
		JLabel lblIngreseSuRut = new JLabel("Ingrese su rut:");
		lblIngreseSuRut.setForeground(new Color(255, 255, 240));
		lblIngreseSuRut.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblIngreseSuRut.setBounds(15, 22, 97, 14);
		panel.add(lblIngreseSuRut);
		
		JLabel label_1 = new JLabel("(Sin puntos y sin d\u00EDgito verificador)");
		label_1.setForeground(Color.LIGHT_GRAY);
		label_1.setBounds(15, 61, 228, 14);
		panel.add(label_1);
		
		textRutProfesor = new JTextField();
		textRutProfesor.setBounds(10, 34, 134, 28);
		panel.add(textRutProfesor);
		textRutProfesor.setColumns(10);
		
		txtRutEstudiante = new JTextField();
		txtRutEstudiante.setColumns(10);
		txtRutEstudiante.setBounds(10, 94, 134, 28);
		panel.add(txtRutEstudiante);
		
		JLabel label = new JLabel("(Sin puntos y sin dígito verificador)");
		label.setForeground(Color.LIGHT_GRAY);
		label.setBounds(15, 121, 228, 14);
		panel.add(label);
		
		JLabel lblIngreseRutDel = new JLabel("Ingrese rut del estudiante:");
		lblIngreseRutDel.setForeground(new Color(255, 255, 240));
		lblIngreseRutDel.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblIngreseRutDel.setBounds(15, 82, 167, 14);
		panel.add(lblIngreseRutDel);
		
		txtCodigoCurso = new JTextField();
		txtCodigoCurso.setColumns(10);
		txtCodigoCurso.setBounds(10, 159, 134, 28);
		panel.add(txtCodigoCurso);
		
		JLabel lblIngreseCdigoDel = new JLabel("Ingrese código del curso:");
		lblIngreseCdigoDel.setForeground(new Color(255, 255, 240));
		lblIngreseCdigoDel.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblIngreseCdigoDel.setBounds(15, 147, 129, 14);
		panel.add(lblIngreseCdigoDel);
		
		JLabel lblinfo = new JLabel("");
		lblinfo.setForeground(Color.WHITE);
		lblinfo.setBounds(15, 199, 338, 16);
		panel.add(lblinfo);
		
		JButton btnInscribir = new JButton("Inscribir");
		btnInscribir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					//Obtenemos el codigo del curso
					String codigoCurso = txtCodigoCurso.getText();
					//Si el codigo del curso es un dato entero y contiene informacion se procede
					if (codigoCurso.matches("\\d*") && !codigoCurso.equals("")){
						//Obtenemos los datos faltantes
						String rutProfesor = textRutProfesor.getText();
						String rutEstudiante = txtRutEstudiante.getText();
						//Si los datos faltantes no se encuentran vacios se procede
						if (!rutProfesor.equals("") && !rutEstudiante.equals("")){
							//Convertimos el codigo del curso a entero
							int idCurso = Integer.parseInt(codigoCurso);
							//Requerimos el servicio que permite inscribir estudiante
							ServicioCursoProxy curso = new ServicioCursoProxy();
							//Enviamos los parametros y almacenamos el valor de retorno en una variable
							String resultado = curso.incribirEstudiante(idCurso, rutEstudiante, rutProfesor);
							//Imprimimos la variable con el mensaje de confirmacion al usuario
							lblinfo.setText(resultado);
						//Si los datos faltantes se encuentras vacios se imprime mensaje al usuario	
						} else {
							lblinfo.setText("Debe llenar todos los campos");
						}
					} else {
						//Si el codigo del curso no es entero o se encuentra vacio se imprime mensaje al usuario
						lblinfo.setText("Código de curso inválido");
					}
					
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnInscribir.setBounds(260, 256, 117, 29);
		panel.add(btnInscribir);
		
		
		contentPane.setLayout(gl_contentPane);
	}
}
