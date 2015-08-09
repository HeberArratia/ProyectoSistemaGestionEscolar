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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.google.gson.Gson;

import servicio.ServicioMatriculaProxy;
import servicio.ServicioMensualidadProxy;
import servicio.ServicioSueldoProxy;

import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

public class ObtenerMorososMensualidad extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textMes;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ObtenerMorososMensualidad frame = new ObtenerMorososMensualidad();
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
	public ObtenerMorososMensualidad() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 547, 417);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 139, 139));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("Director");
		label.setIcon(new ImageIcon("C:\\Users\\Heber\\workspace\\ProyectoGestionEduc-Escritorio\\src\\Files\\azul-marron-usuario-varon-blanco-icono-5443-32.png"));
		label.setForeground(new Color(255, 255, 240));
		label.setFont(new Font("Calibri", Font.PLAIN, 21));
		label.setBounds(207, 11, 146, 32);
		contentPane.add(label);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "N\u00F3mina de estudiantes morosos en los pagos de mensualidad", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 255, 240)));
		panel.setBackground(new Color(0, 139, 139));
		panel.setBounds(50, 96, 434, 261);
		contentPane.add(panel);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel label_1 = new JLabel("Rut profesor:");
		label_1.setForeground(new Color(255, 255, 240));
		label_1.setFont(new Font("Calibri", Font.PLAIN, 12));
		
		textMes = new JTextField();
		textMes.setColumns(10);
		
		JLabel lblMensaje = new JLabel("");
		lblMensaje.setForeground(Color.WHITE);
		
		JButton btnObtener = new JButton("Obtener ");
		btnObtener.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					//Obtenemos el mes ingresado
					String mes = textMes.getText();
					//Si el mes no se encuentra vacio y es un entero podemos proceder
					if (!mes.equals("") && mes.matches("\\d*")){
						//Convertimos el mes a entero
						int intmes = Integer.parseInt(mes);
						//Servicio que permite obtener obtener morosos en pago mensualidad
						ServicioMensualidadProxy mensualidad = new ServicioMensualidadProxy();
						String json;
						//Invocamos al metodo y guardamos su valor de retorno
						json = mensualidad.obtenerMorososMensualidad(intmes);
						//Si json no es igual a nulo podemos proceder
						if (json!=null){
							//Mostramos la tabla con los sueldos del profesor
							mostrarTabla(json);
						//Si json es nulo mostramos un mensaje
						} else {
							lblMensaje.setText("Ingrese mes válido");
						}
					//Si rut se encuentra vacio imprimimos un mensaje	
					} else {
						lblMensaje.setText("Ingrese mes válido");
					}
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnObtener.setFont(new Font("Calibri", Font.PLAIN, 12));
		
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(textMes, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnObtener)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblMensaje, GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE))
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 410, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
					.addGap(6)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(textMes, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnObtener, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblMensaje))
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE))
		);
		
		table = new JTable(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Estudiante","Mes","Rut","Deuda"
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
		button.setIcon(new ImageIcon("C:\\Users\\Heber\\workspace\\ProyectoGestionEduc-Escritorio\\src\\Files\\deshacer-icono-5993-16.png"));
		button.setFont(new Font("Calibri", Font.PLAIN, 12));
		button.setBounds(6, 366, 89, 23);
		contentPane.add(button);
		
		JLabel lblMesEnero = new JLabel("Mes: Enero");
		lblMesEnero.setFont(new Font("Calibri", Font.BOLD, 16));
		lblMesEnero.setForeground(new Color(255, 250, 240));
		lblMesEnero.setBounds(50, 55, 89, 14);
		contentPane.add(lblMesEnero);
		
		JLabel lblCursoClculoIi = new JLabel("Curso: C\u00E1lculo II");
		lblCursoClculoIi.setForeground(new Color(255, 250, 240));
		lblCursoClculoIi.setFont(new Font("Calibri", Font.BOLD, 16));
		lblCursoClculoIi.setBounds(50, 71, 125, 14);
		contentPane.add(lblCursoClculoIi);
	}

	public void mostrarTabla(String json){
		//Obtenemos el número de columnas de la tabla
		int numCols = table.getModel().getColumnCount();
		//Arreglo de objetos del largo de la tabla
		Object [] fila = new Object[numCols];
		//Procedemos a limpiar la tabla antes de mostrar datos (?)
		Gson gson = new Gson();
		//Transformamos la variable json en una matriz
		String[][] datos = gson.fromJson(json, String[][].class);
		//Recorremos la matriz y alamcenamos sus datos en una fila de la tabla
		for (int i = 0; i < datos.length; i++) {
			fila[0] = datos[i][0];
			fila[1] = datos[i][1];
			fila[2] = datos[i][2];
			fila[3] = "$"+datos[i][3];
			//Enviamos la fila a la tabla
			((DefaultTableModel) table.getModel()).addRow(fila);
		}					
	}
	
}
