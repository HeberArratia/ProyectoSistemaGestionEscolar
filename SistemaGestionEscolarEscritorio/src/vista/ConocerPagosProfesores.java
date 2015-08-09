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
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.google.gson.Gson;

import servicio.ServicioReporteProxy;
import servicio.ServicioSueldoProxy;

import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ConocerPagosProfesores extends JFrame {
	private JPanel contentPane;
	private JTable table;
	private JTextField txtRut;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConocerPagosProfesores frame = new ConocerPagosProfesores();
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
	public ConocerPagosProfesores() {
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
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Reporte de montos a pagar mensualmente", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 255, 240)));
		panel.setBackground(new Color(0, 139, 139));
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel lblMensaje = new JLabel("");
		lblMensaje.setForeground(Color.WHITE);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				try {
					//Obtenemos el rut ingresado
					String rut = txtRut.getText();
					//Si el rut no se encuentra vacio podemos proceder
					if (!rut.equals("")){
						//Servicio que permite obtener los sueldos de un profesor
						ServicioSueldoProxy sueldo = new ServicioSueldoProxy();
						String json;
						//Invocamos al metodo y guardamos su valor de retorno
						json = sueldo.obtenerSueldos(rut);
						//Si json no es igual a nulo podemos proceder
						if (json!=null){
							//Mostramos la tabla con los sueldos del profesor
							mostrarTabla(json);
						//Si json es nulo mostramos un mensaje
						} else {
							lblMensaje.setText("El profesor no existe");
						}
					//Si rut se encuentra vacio imprimimos un mensaje	
					} else {
						lblMensaje.setText("Debe ingresar un rut");
					}
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnBuscar.setFont(new Font("Calibri", Font.PLAIN, 12));
		
		JLabel lblRutProfesor = new JLabel("Rut profesor:");
		lblRutProfesor.setForeground(new Color(255, 255, 240));
		lblRutProfesor.setFont(new Font("Calibri", Font.PLAIN, 12));
		
		JLabel label_2 = new JLabel("(Sin puntos y sin dígito verificador)");
		label_2.setForeground(Color.LIGHT_GRAY);
		
		txtRut = new JTextField();
		txtRut.setColumns(10);
		
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(14)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(txtRut, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(109)
									.addComponent(lblMensaje, GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE))
								.addGroup(gl_panel.createSequentialGroup()
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(lblRutProfesor, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
										.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
											.addComponent(btnBuscar, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
											.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 228, GroupLayout.PREFERRED_SIZE)))
									.addPreferredGap(ComponentPlacement.RELATED, 183, Short.MAX_VALUE))))
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 419, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblRutProfesor, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblMensaje)
						.addComponent(txtRut, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnBuscar, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
					.addGap(1)
					.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Profesor","Mes","Cantidad de cursos","Monto","Estado de pago"
			}
		));
		scrollPane.setViewportView(table);
		panel.setLayout(gl_panel);
		
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
					.addContainerGap(213, Short.MAX_VALUE)
					.addComponent(label, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)
					.addGap(178))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(button, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 437, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(35, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(29)
					.addComponent(label, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 286, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(357, Short.MAX_VALUE)
					.addComponent(button))
		);
		contentPane.setLayout(gl_contentPane);		
	}
	
	public void mostrarTabla(String json){
		//Obtenemos el número de columnas de la tabla
		int numCols = table.getModel().getColumnCount();
		//Arreglo de objetos del largo de la tabla
		Object [] fila = new Object[numCols];
		//Procedemos a limpiar la tabla antes de mostrar datos
		Gson gson = new Gson();
		//Transformamos la variable json en una matriz
		String[][] datos = gson.fromJson(json, String[][].class);
		//Recorremos la matriz y alamcenamos sus datos en una fila de la tabla
		for (int i = 0; i < datos.length; i++) {
			fila[0] = datos[i][0];
			fila[1] = datos[i][1];
			fila[2] = datos[i][2];
			fila[3] = "$"+datos[i][3];
			fila[4] = datos[i][4];
			//Enviamos la fila a la tabla
			((DefaultTableModel) table.getModel()).addRow(fila);
		}					
	}
}
