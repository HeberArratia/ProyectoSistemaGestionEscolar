package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import servicio.ServicioEstudianteProxy;
import servicio.ServicioMatriculaProxy;

import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

public class PagoMatricula extends JFrame {


	private JPanel contentPane;
	private JTextField textRutEstudiante;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PagoMatricula frame = new PagoMatricula();
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
	public PagoMatricula() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 547, 417);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 139, 139));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setForeground(new Color(255, 255, 240));
		panel.setBackground(new Color(0, 139, 139));
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Registrar pago de matr\u00EDcula por estudiante", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 255, 240)));
		panel.setLayout(null);
		
		JLabel lblRutEstudiante = new JLabel("Rut estudiante:");
		lblRutEstudiante.setForeground(new Color(255, 255, 240));
		lblRutEstudiante.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblRutEstudiante.setBounds(20, 28, 97, 14);
		panel.add(lblRutEstudiante);
		
		JLabel lblMonto = new JLabel("Monto a pagar:");
		lblMonto.setForeground(new Color(255, 255, 240));
		lblMonto.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblMonto.setBounds(20, 208, 97, 14);
		panel.add(lblMonto);
		
		JTextArea textmonto = new JTextArea();
		textmonto.setText("$20.000");
		textmonto.setBounds(20, 222, 105, 22);
		panel.add(textmonto);
		
		textmonto.setEnabled(false);
		
		JButton btnregistrar = new JButton("Registrar");
		btnregistrar.setEnabled(false);
		btnregistrar.setIcon(new ImageIcon("C:\\Users\\Heber\\workspace\\ProyectoGestionEduc-Escritorio\\src\\Files\\anadir-mas-icono-5518-16.png"));
		btnregistrar.setBounds(286, 270, 105, 23);
		panel.add(btnregistrar);
		
		JButton btnbuscar = new JButton("Buscar");
		
		btnbuscar.setIcon(new ImageIcon("C:\\Users\\Heber\\workspace\\ProyectoGestionEduc-Escritorio\\src\\Files\\buscar-buscar-ampliar-icono-9048-16.png"));
		btnbuscar.setFont(new Font("Calibri", Font.PLAIN, 12));
		btnbuscar.setBounds(155, 41, 97, 23);
		panel.add(btnbuscar);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 139, 139));
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_1.setBounds(20, 105, 292, 92);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblEstudianteM = new JLabel("Estudiante:");
		lblEstudianteM.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEstudianteM.setForeground(new Color(255, 255, 240));
		lblEstudianteM.setBounds(10, 0, 164, 25);
		panel_1.add(lblEstudianteM);
		
		JLabel lblRutM = new JLabel("Rut:");
		lblRutM.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblRutM.setForeground(new Color(255, 255, 240));
		lblRutM.setBounds(10, 22, 164, 25);
		panel_1.add(lblRutM);
		
		JLabel lblEstadoMatriculaM = new JLabel("Estado Matrícula:");
		lblEstadoMatriculaM.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEstadoMatriculaM.setForeground(new Color(255, 255, 240));
		lblEstadoMatriculaM.setBounds(10, 51, 164, 14);
		panel_1.add(lblEstadoMatriculaM);
		
		JLabel lblApoderadoM = new JLabel("Apoderado:");
		lblApoderadoM.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblApoderadoM.setForeground(new Color(255, 255, 240));
		lblApoderadoM.setBounds(10, 72, 164, 14);
		panel_1.add(lblApoderadoM);
		
		JLabel lblApoderado = new JLabel("");
		lblApoderado.setBounds(118, 72, 164, 14);
		panel_1.add(lblApoderado);
		lblApoderado.setForeground(new Color(255, 255, 240));
		
		JLabel lblEstado = new JLabel("");
		lblEstado.setBounds(118, 51, 164, 14);
		panel_1.add(lblEstado);
		lblEstado.setForeground(new Color(255, 255, 240));
		
		JLabel lblRut = new JLabel("");
		lblRut.setBounds(118, 22, 164, 25);
		panel_1.add(lblRut);
		lblRut.setForeground(new Color(255, 255, 240));
		
		JLabel lblEstudiante = new JLabel("");
		lblEstudiante.setBounds(118, 0, 164, 25);
		panel_1.add(lblEstudiante);
		lblEstudiante.setForeground(new Color(255, 255, 240));
		
		JLabel lblsinPuntosY = new JLabel("(Sin puntos y sin d\u00EDgito verificador)");
		lblsinPuntosY.setForeground(Color.LIGHT_GRAY);
		lblsinPuntosY.setBounds(20, 65, 228, 14);
		panel.add(lblsinPuntosY);
		
		JLabel lblSecretaria = new JLabel("Secretaria");
		lblSecretaria.setIcon(new ImageIcon("C:\\Users\\Heber\\workspace\\ProyectoGestionEduc-Escritorio\\src\\Files\\naranja-usuario-mujer-blanca-icono-8475-32.png"));
		lblSecretaria.setForeground(new Color(255, 255, 240));
		lblSecretaria.setFont(new Font("Calibri", Font.PLAIN, 21));
		
		JLabel lblInfoBuscar = new JLabel("");
		lblInfoBuscar.setForeground(Color.WHITE);
		lblInfoBuscar.setBounds(20, 81, 371, 22);
		panel.add(lblInfoBuscar);
		
		JLabel lblInfoPagar = new JLabel("");
		lblInfoPagar.setForeground(Color.WHITE);
		lblInfoPagar.setBounds(20, 256, 371, 16);
		panel.add(lblInfoPagar);
		
		JButton btnhome = new JButton("Volver");
		btnhome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Bienvenido bien = new Bienvenido();
				bien.setVisible(true);
				setVisible(false);
			}
		});
		// Boton click registraPago
		btnregistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Requerimos el servicio que permite pagar la matricula
				ServicioMatriculaProxy matricula = new ServicioMatriculaProxy();
				try {
					//Enviamos los parametros y almacenamos el valor de retorno
					String resultado = matricula.pagarMatricula(lblRut.getText(), "183511203");
					//Imprimimos el resultado de la operacion
					lblInfoPagar.setText(resultado);
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		// Boton click buscarEstudiante
		btnbuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					//Obtenemos el rut del estudiante
					String rutEstudiante = textRutEstudiante.getText();
					//Si el rut del estudiante es distinto de vacio se procede
					if (!rutEstudiante.equals("")){
						//Requerimos el servicio que permite buscar a un estudiante y retornarlo
						ServicioEstudianteProxy estudiante = new ServicioEstudianteProxy();
						//Pasamos el rut y almacenamos el arreglo que retorna el metodo
						String datos[] = estudiante.buscarEstudiante(rutEstudiante);
						//Si el arreglo es distinto de nulo se puede proceder
						if (datos!=null){
							//Mostramos los datos del estudiante al usuario
							lblEstudiante.setText(datos[0]);
							lblRut.setText(datos[1]);
							lblEstado.setText(datos[2]);
							lblApoderado.setText(datos[3]);
							//Habilitamos el boton que permite pagar matricula
							btnregistrar.setEnabled(true);
						//Si el arreglo es nulo mostramos mensaje al usuario
						} else {
							lblInfoBuscar.setText("El estudiante no existe");
						}
					//Si el rut del estudiante se encuentra vacio se imprime mensaje al usuario
					} else {
						lblInfoBuscar.setText("No debe dejar el campo vacío");
					}
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		btnhome.setFont(new Font("Calibri", Font.PLAIN, 12));
		btnhome.setIcon(new ImageIcon("C:\\Users\\Heber\\workspace\\ProyectoGestionEduc-Escritorio\\src\\Files\\deshacer-icono-5993-16.png"));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(186)
							.addComponent(lblSecretaria, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnhome, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(70)
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 397, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(70, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(6)
					.addComponent(lblSecretaria)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 299, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnhome, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
					.addGap(13))
		);
		
		textRutEstudiante = new JTextField();
		textRutEstudiante.setBounds(15, 37, 134, 28);
		panel.add(textRutEstudiante);
		textRutEstudiante.setColumns(10);
		
		
		
	
		contentPane.setLayout(gl_contentPane);
	}

}
