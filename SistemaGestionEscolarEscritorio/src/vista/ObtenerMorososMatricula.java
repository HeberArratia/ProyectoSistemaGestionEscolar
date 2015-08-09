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


public class ObtenerMorososMatricula extends JFrame {
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ObtenerMorososMatricula frame = new ObtenerMorososMatricula();
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
	public ObtenerMorososMatricula() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 547, 417);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 128));
		contentPane.setForeground(new Color(0, 139, 139));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbltitulo = new JLabel("Director");
		lbltitulo.setIcon(new ImageIcon("C:\\Users\\Heber\\workspace\\ProyectoGestionEduc-Escritorio\\src\\Files\\azul-marron-usuario-varon-blanco-icono-5443-32.png"));
		lbltitulo.setForeground(new Color(255, 255, 240));
		lbltitulo.setFont(new Font("Calibri", Font.PLAIN, 21));
		lbltitulo.setBounds(196, 48, 146, 32);
		contentPane.add(lbltitulo);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 128, 128));
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "N\u00F3mina de estudiantes morosos en los pagos de matr\u00EDcula", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 255, 240)));
		panel.setBounds(46, 91, 434, 225);
		contentPane.add(panel);
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 402, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		// Tabla 
		DefaultTableModel modelo = new DefaultTableModel();
		JTable table = new JTable(modelo);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				// Titulos de la tabla
				"Estudiante", "Rut", "Deuda"
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
		button.setBounds(10, 327, 89, 23);
		contentPane.add(button);
		
		//Obtenemos el número de columnas de la tabla
		int numCols = table.getModel().getColumnCount();
		//Arreglo de objetos del largo de la tabla
		Object [] fila = new Object[numCols];
		//Servicio que permite imprimir morosos matricula
		ServicioMatriculaProxy matricula = new ServicioMatriculaProxy(); 
		Gson gson = new Gson();
		String json;
		try {
			//Invocamos el metodo y almacenamos su valor de retorno en una variable
			json = matricula.obtenerMorososMatricula();
			// Si la variable es distinta de nulo se puede proceder
			if (json!=null){
				//Transformamos la variable en una matriz
				String[][] datos = gson.fromJson(json, String[][].class);
				//Recorremos la matriz y alamcenamos sus datos
				for (int i = 0; i < datos.length; i++) {
					fila[0] = datos[i][0];
					fila[1] = datos[i][1];
					fila[2] = "$"+datos[i][2];
					//Enviamos los datos a la tabla
					((DefaultTableModel) table.getModel()).addRow(fila);
				}
			}
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
		


