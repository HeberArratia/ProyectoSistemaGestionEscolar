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

import javax.swing.UIManager;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.awt.event.ActionEvent;
import java.awt.Component;
import javax.swing.JTextField;

public class CrearCurso extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombreCurso;
	private JTextField textRutProfesor;
	private JTextField textCodigoCurso;
	private JTextField textNombreCurso;

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
					.addContainerGap(218, Short.MAX_VALUE)
					.addComponent(label, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)
					.addGap(173))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(button, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(450, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(74)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 409, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(54, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(28)
					.addComponent(label, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 270, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(button, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addGap(14))
		);
		panel.setLayout(null);
		
		JLabel lblNombreCurso = new JLabel("Nombre curso:");
		lblNombreCurso.setForeground(new Color(255, 255, 240));
		lblNombreCurso.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblNombreCurso.setBounds(21, 23, 97, 14);
		panel.add(lblNombreCurso);
		
		JLabel lblInfoCrear = new JLabel("");
		lblInfoCrear.setAlignmentY(Component.TOP_ALIGNMENT);
		lblInfoCrear.setAlignmentX(Component.RIGHT_ALIGNMENT);
		lblInfoCrear.setForeground(Color.WHITE);
		lblInfoCrear.setBounds(21, 64, 351, 16);
		panel.add(lblInfoCrear);
		
		JLabel lblInfoAsignar = new JLabel("");
		lblInfoAsignar.setForeground(Color.WHITE);
		lblInfoAsignar.setBounds(21, 218, 359, 16);
		panel.add(lblInfoAsignar);
		contentPane.setLayout(gl_contentPane);
		
		JButton btnCrear = new JButton("Crear");
		btnCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Obtenemos el nombre del curso
				String nombreCurso = textNombreCurso.getText();
				try {
					//Si el nombre del curso no se encuentra vacio
					if (!nombreCurso.equals("")){
						//Requerimos el servicio que permite crear el curso
						ServicioCursoProxy curso = new ServicioCursoProxy();
						//Enviamos los parametros y almacenamos el valor de retorno en una variable
						String resultado = curso.crearCurso(nombreCurso, "96356453");
						//Mostramos el resultado al usuario
						lblInfoCrear.setText(resultado);
					//Si el nombre del curso se encuentra vacio se imprime un mensaje	
					} else {
						lblInfoCrear.setText("Debe ingresar el nombre del curso");
					}
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		btnCrear.setFont(new Font("Calibri", Font.PLAIN, 12));
		btnCrear.setBounds(147, 40, 97, 23);
		panel.add(btnCrear);
		
		JLabel lblCdigoCurso = new JLabel("C\u00F3digo curso:");
		lblCdigoCurso.setForeground(new Color(255, 255, 240));
		lblCdigoCurso.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblCdigoCurso.setBounds(21, 83, 97, 14);
		panel.add(lblCdigoCurso);
		
		JLabel label_2 = new JLabel("Nombre curso:");
		label_2.setForeground(new Color(255, 255, 240));
		label_2.setFont(new Font("Calibri", Font.PLAIN, 12));
		label_2.setBounds(21, 128, 97, 14);
		panel.add(label_2);
		
		JLabel lblRutProfesor = new JLabel("Rut profesor:");
		lblRutProfesor.setForeground(new Color(255, 255, 240));
		lblRutProfesor.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblRutProfesor.setBounds(21, 174, 97, 14);
		panel.add(lblRutProfesor);
		
		JButton btnAsignarProfesor = new JButton("Asignar profesor");
		btnAsignarProfesor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Requerimos el codigo del curso
				String codigoCurso = textCodigoCurso.getText();
				try {
					// Si el codigo del curso es un dato entero se puede proceder
					if (codigoCurso.matches("\\d*")){
						//Obtenemos los datos faltantes
						String nombreCurso = txtNombreCurso.getText();
						String rutProfe = textRutProfesor.getText();
						//Si los datos faltantes contienen informacion se puede proceder
						if((!nombreCurso.equals("")) && (!rutProfe.equals(""))){
							//Convertimos el nombre del curso a entero
							int idCurso = Integer.parseInt(codigoCurso);
							//Requerimos al servicio que permite asignar el profesor
							ServicioCursoProxy curso = new ServicioCursoProxy();
							//Enviamos los parametros y almacenamos el valor de retorno del metodo
							System.out.println(idCurso + " " + nombreCurso + " " + rutProfe);
							String resultado = curso.asignarProfesor(idCurso, nombreCurso, rutProfe, "96356453");
							//Mostramos mensaje de confirmacion
							lblInfoAsignar.setText(resultado);
						//Si los datos se encuentran vacios se imprime mensaje
						} else {
							lblInfoAsignar.setText("No debe dejar campos en blanco");
						}
					} else {
						//Si el codigo del curso no es un dato entero se imprime mensaje
						lblInfoAsignar.setText("Código de curso inválido");
					}
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnAsignarProfesor.setBounds(265, 241, 138, 23);
		panel.add(btnAsignarProfesor);
		
		txtNombreCurso = new JTextField();
		txtNombreCurso.setForeground(Color.DARK_GRAY);
		txtNombreCurso.setBounds(16, 144, 134, 28);
		panel.add(txtNombreCurso);
		txtNombreCurso.setColumns(10);
		
		textRutProfesor = new JTextField();
		textRutProfesor.setBounds(16, 189, 134, 28);
		panel.add(textRutProfesor);
		textRutProfesor.setColumns(10);
		
		textCodigoCurso = new JTextField();
		textCodigoCurso.setBounds(16, 98, 134, 28);
		panel.add(textCodigoCurso);
		textCodigoCurso.setColumns(10);
		
		textNombreCurso = new JTextField();
		textNombreCurso.setBounds(16, 36, 134, 28);
		panel.add(textNombreCurso);
		textNombreCurso.setColumns(10);
		
		
	}
}
