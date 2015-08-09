package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import servicio.ServicioEstudianteProxy;
import servicio.ServicioMensualidad;
import servicio.ServicioMensualidadProxy;

import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class PagoMensualidad extends JFrame {

	private JPanel contentPane;
	private JTextField textMes;
	private JTextField txtRut;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PagoMensualidad frame = new PagoMensualidad();
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
	public PagoMensualidad() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 547, 466);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 139, 139));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSecretaria = new JLabel("Secretaria");
		lblSecretaria.setBounds(197, 11, 146, 32);
		lblSecretaria.setIcon(new ImageIcon("C:\\Users\\Heber\\workspace\\ProyectoGestionEduc-Escritorio\\src\\Files\\naranja-usuario-mujer-blanca-icono-8475-32.png"));
		lblSecretaria.setForeground(new Color(255, 255, 240));
		lblSecretaria.setFont(new Font("Calibri", Font.PLAIN, 21));
		contentPane.add(lblSecretaria);
		
		JPanel panel = new JPanel();
		panel.setBounds(101, 54, 353, 336);
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Registrar pago de mensualidad ", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 250, 250)));
		panel.setBackground(new Color(0, 139, 139));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("(Sin puntos y sin d\u00EDgito verificador)");
		label.setForeground(Color.LIGHT_GRAY);
		label.setBounds(10, 63, 228, 14);
		panel.add(label);
		
		JLabel label_1 = new JLabel("Rut estudiante:");
		label_1.setForeground(new Color(255, 255, 240));
		label_1.setFont(new Font("Calibri", Font.PLAIN, 12));
		label_1.setBounds(10, 26, 97, 14);
		panel.add(label_1);
		
		
		
		JLabel lblMesAPagar = new JLabel("Mes a pagar:");
		lblMesAPagar.setForeground(new Color(255, 255, 240));
		lblMesAPagar.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblMesAPagar.setBounds(10, 198, 97, 14);
		panel.add(lblMesAPagar);
		
		JLabel lblNewLabel = new JLabel("Monto a pagar por curso:");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(10, 243, 185, 14);
		panel.add(lblNewLabel);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setEnabled(false);
		textArea_1.setText("10000");
		textArea_1.setBounds(10, 259, 114, 22);
		panel.add(textArea_1);
		
		
		
		textMes = new JTextField();
		textMes.setBounds(6, 214, 134, 28);
		panel.add(textMes);
		textMes.setColumns(10);
		
		txtRut = new JTextField();
		txtRut.setBounds(5, 37, 134, 28);
		panel.add(txtRut);
		txtRut.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_1.setBackground(new Color(0, 139, 139));
		panel_1.setBounds(10, 101, 292, 92);
		panel.add(panel_1);
		
		JLabel label_2 = new JLabel("Estudiante:");
		label_2.setForeground(new Color(255, 255, 240));
		label_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_2.setBounds(10, 0, 164, 25);
		panel_1.add(label_2);
		
		JLabel label_3 = new JLabel("Rut:");
		label_3.setForeground(new Color(255, 255, 240));
		label_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_3.setBounds(10, 22, 164, 25);
		panel_1.add(label_3);
		
		JLabel label_4 = new JLabel("Estado Matrícula:");
		label_4.setForeground(new Color(255, 255, 240));
		label_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_4.setBounds(10, 51, 164, 14);
		panel_1.add(label_4);
		
		JLabel label_5 = new JLabel("Apoderado:");
		label_5.setForeground(new Color(255, 255, 240));
		label_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_5.setBounds(10, 72, 164, 14);
		panel_1.add(label_5);
		
		JLabel lblApoderado = new JLabel("");
		lblApoderado.setForeground(new Color(255, 255, 240));
		lblApoderado.setBounds(118, 72, 164, 14);
		panel_1.add(lblApoderado);
		
		JLabel lblEstado = new JLabel("");
		lblEstado.setForeground(new Color(255, 255, 240));
		lblEstado.setBounds(118, 51, 164, 14);
		panel_1.add(lblEstado);
		
		JLabel lblRut = new JLabel("");
		lblRut.setForeground(new Color(255, 255, 240));
		lblRut.setBounds(118, 22, 164, 25);
		panel_1.add(lblRut);
		
		JLabel lblEstudiante = new JLabel("");
		lblEstudiante.setForeground(new Color(255, 255, 240));
		lblEstudiante.setBounds(118, 0, 164, 25);
		panel_1.add(lblEstudiante);
		
		JLabel lblInfoBuscar = new JLabel("");
		lblInfoBuscar.setForeground(Color.WHITE);
		lblInfoBuscar.setBounds(10, 80, 314, 16);
		panel.add(lblInfoBuscar);
		
		JLabel lblInfoPagar = new JLabel("");
		lblInfoPagar.setForeground(Color.WHITE);
		lblInfoPagar.setBounds(10, 286, 314, 16);
		panel.add(lblInfoPagar);
		
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					//Obtenemos el ems en que se desea pagar la mensualidad
					String mes = textMes.getText();
					//Si el mes es un dato entero y no se encuentra vacio se puede proceder
					if (!mes.equals("") && mes.matches("\\d*")){
						//Convertimos el mes a entero
						int intmes = Integer.parseInt(mes);
						//Requerimos al servicio que permite pagar la mensualidad de un mes
						ServicioMensualidadProxy mensualidad = new ServicioMensualidadProxy();
						//Enviamos los parametros necesarios y almacenamos el mensaje de retorno
						String resultado = mensualidad.registrarPagoMensualidad("183511203", lblRut.getText(), intmes);
						//Imprimimos el mensaje de retorno
						lblInfoPagar.setText(resultado);
					//Si el mes no es entero y se encuentra vacio se imprime mensaje
					} else {
						lblInfoPagar.setText("Ingrese un més válido");
					}
					
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnRegistrar.setEnabled(false);
		btnRegistrar.setBounds(258, 307, 89, 23);
		panel.add(btnRegistrar);
		
		JButton btnIngresar = new JButton("Buscar");
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					//Obtenemos el rut del estudiante
					String rutEstudiante = txtRut.getText();
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
							//Habilitamos el boton que permite pagar mensualidad
							btnRegistrar.setEnabled(true);
						//Si el arreglo es nulo mostramos mensaje al usuario
						} else {
							lblInfoBuscar.setText("El estudiante no existe");
						}
					//Si el rut del estudiante se encuentra vacio se imprime mensaje al usuario
					} else {
						lblInfoBuscar.setText("No debe dejar el campo vacío");
					}
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnIngresar.setFont(new Font("Calibri", Font.PLAIN, 12));
		btnIngresar.setBounds(141, 39, 97, 23);
		panel.add(btnIngresar);
		
		
		JButton button = new JButton("Volver");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Bienvenido bien = new Bienvenido();
				bien.setVisible(true);
				setVisible(false);
			}
		});
		button.setIcon(new ImageIcon("C:\\Users\\Heber\\workspace\\ProyectoGestionEduc-Escritorio\\src\\Files\\deshacer-icono-5993-16.png"));
		button.setFont(new Font("Calibri", Font.PLAIN, 12));
		button.setBounds(10, 393, 89, 23);
		contentPane.add(button);
	}
}
