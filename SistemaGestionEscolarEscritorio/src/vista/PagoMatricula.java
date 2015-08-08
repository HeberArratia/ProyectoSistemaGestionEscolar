package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

public class PagoMatricula extends JFrame {


	private JPanel contentPane;

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
		
		JTextArea txtrutestudiante = new JTextArea();
		txtrutestudiante.setFont(new Font("Monospaced", Font.PLAIN, 16));
		txtrutestudiante.setBounds(20, 41, 105, 22);
		panel.add(txtrutestudiante);
		
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
		btnregistrar.setBounds(204, 253, 105, 23);
		panel.add(btnregistrar);
		
		JButton btnbuscar = new JButton("Buscar");
		
		btnbuscar.setIcon(new ImageIcon("C:\\Users\\Heber\\workspace\\ProyectoGestionEduc-Escritorio\\src\\Files\\buscar-buscar-ampliar-icono-9048-16.png"));
		btnbuscar.setFont(new Font("Calibri", Font.PLAIN, 12));
		btnbuscar.setBounds(130, 41, 97, 23);
		panel.add(btnbuscar);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 139, 139));
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_1.setBounds(20, 105, 292, 92);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel label = new JLabel("Nombre:");
		label.setFont(new Font("Tahoma", Font.BOLD, 11));
		label.setForeground(new Color(255, 255, 240));
		label.setBounds(10, 0, 164, 25);
		panel_1.add(label);
		
		JLabel label_1 = new JLabel("Apellido:");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_1.setForeground(new Color(255, 255, 240));
		label_1.setBounds(10, 22, 164, 25);
		panel_1.add(label_1);
		
		JLabel label_2 = new JLabel("Rut: ");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_2.setForeground(new Color(255, 255, 240));
		label_2.setBounds(10, 51, 164, 14);
		panel_1.add(label_2);
		
		JLabel label_3 = new JLabel("Estado Matr\u00EDcula:");
		label_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_3.setForeground(new Color(255, 255, 240));
		label_3.setBounds(10, 72, 164, 14);
		panel_1.add(label_3);
		
		JLabel lblestado = new JLabel("");
		lblestado.setBounds(118, 72, 164, 14);
		panel_1.add(lblestado);
		lblestado.setForeground(new Color(255, 255, 240));
		
		JLabel lblrut = new JLabel("");
		lblrut.setBounds(118, 51, 164, 14);
		panel_1.add(lblrut);
		lblrut.setForeground(new Color(255, 255, 240));
		
		JLabel lblapellido = new JLabel("");
		lblapellido.setBounds(118, 22, 164, 25);
		panel_1.add(lblapellido);
		lblapellido.setForeground(new Color(255, 255, 240));
		
		JLabel lblnombre = new JLabel("");
		lblnombre.setBounds(118, 0, 164, 25);
		panel_1.add(lblnombre);
		lblnombre.setForeground(new Color(255, 255, 240));
		
		JLabel lblsinPuntosY = new JLabel("(Sin puntos y sin d\u00EDgito verificador)");
		lblsinPuntosY.setForeground(Color.LIGHT_GRAY);
		lblsinPuntosY.setBounds(20, 65, 228, 14);
		panel.add(lblsinPuntosY);
		
		JLabel lblmensajerut = new JLabel("El rut es invalido");
		lblmensajerut.setIcon(new ImageIcon("C:\\Users\\Heber\\workspace\\ProyectoGestionEduc-Escritorio\\src\\Files\\de-dialogo-de-error-icono-7543-16.png"));
		lblmensajerut.setBounds(20, 90, 145, 14);
		panel.add(lblmensajerut);
		lblmensajerut.setForeground(new Color(255, 250, 240));
		lblmensajerut.setFont(new Font("Calibri", Font.BOLD, 13));
		
		JLabel lblmensajeregistro = new JLabel("La matricula se ha pagado");
		lblmensajeregistro.setIcon(new ImageIcon("C:\\Users\\Heber\\workspace\\ProyectoGestionEduc-Escritorio\\src\\Files\\aceptar-verde-ok-si-icono-8925-16.png"));
		lblmensajeregistro.setForeground(new Color(255, 250, 240));
		lblmensajeregistro.setFont(new Font("Calibri", Font.BOLD, 13));
		lblmensajeregistro.setBounds(20, 262, 176, 14);
		panel.add(lblmensajeregistro);
		lblmensajerut.setVisible(false);
		lblmensajeregistro.setVisible(false);
		
		JLabel lblSecretaria = new JLabel("Secretaria");
		lblSecretaria.setIcon(new ImageIcon("C:\\Users\\Heber\\workspace\\ProyectoGestionEduc-Escritorio\\src\\Files\\naranja-usuario-mujer-blanca-icono-8475-32.png"));
		lblSecretaria.setForeground(new Color(255, 255, 240));
		lblSecretaria.setFont(new Font("Calibri", Font.PLAIN, 21));
		
		JButton btnhome = new JButton("Volver");
		btnhome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		// Boton click registraEstudiante
		btnregistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*// Se llama al metodo pagar matricula con los parametros correspontienes y se asigna a la variable resultado
				String resultado = Matricula.pagarMatricula(lblrut.getText(), "183511203", 20000);
				// Se hace visible un lavel de confirmacion de la operacion
				lblmensajeregistro.setVisible(true);
				// Dependiendo el valor de retorno se imprime un mensaje al usuario por medio del lavel lblmensajerut
				if (resultado=="matricula pagada"){
					lblmensajeregistro.setText("La matricula se ha pagado");
					lblmensajeregistro.setIcon(new ImageIcon("C:\\Users\\Heber\\workspace\\"
							+ "ProyectoGestionEduc-Escritorio\\src\\Files\\aceptar-verde-ok-si-icono-8925-16.png"));
			    } else if (resultado=="la matricula ya se encuentra pagada"){
			    	lblmensajeregistro.setText("La matricula se encuentra pagada");
			    	lblmensajeregistro.setIcon(new ImageIcon("C:\\Users\\Heber\\workspace\\"
			    			+ "ProyectoGestionEduc-Escritorio\\src\\Files\\de-dialogo-de-error-icono-7543-16.png"));
			    } else{
			    	lblmensajeregistro.setText("Error de registro");
			    	lblmensajeregistro.setIcon(new ImageIcon("C:\\Users\\Heber\\workspace\\"
			    			+ "ProyectoGestionEduc-Escritorio\\src\\Files\\de-dialogo-de-error-icono-7543-16.png"));
			    }
			    */
			}
		});
		// Boton click buscarEstudiante
		btnbuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/*lblmensajeregistro.setVisible(false);
				// Se captura el dato del textField
				String rut = txtrutestudiante.getText();
				// Se llama al metodo buscar estudiante y se asigna a una variable tipo Estudiante
				orm.Estudiante est = Estudiante.buscarEstudiate(rut);
				// Si est es distinto de nulo se puede proceder
				if (est != null) {
					// Se muestran en lbl los datos del estudiante buscado
					lblnombre.setText(est.getPersona().getNombre());
					lblapellido.setText(est.getPersona().getApellido());
					lblrut.setText(est.getPersona().getRut());
					// Si el estado de la matricula es 1, se muestra "Pagada"
					if (est.getMatricula().getEstadoMatricula() == 1) {
						lblestado.setText("Pagada");
					// De lo contrario, se muestra "Por pagar"	
					} else {
						lblestado.setText("Por pagar");
						btnregistrar.setEnabled(true);
					}
				} else{
					// Si est es nulo entonces se muestra un mensaje de error
					lblmensajerut.setVisible(true);
				}*/
			}
		});
		
		btnhome.setFont(new Font("Calibri", Font.PLAIN, 12));
		btnhome.setIcon(new ImageIcon("C:\\Users\\Heber\\workspace\\ProyectoGestionEduc-Escritorio\\src\\Files\\deshacer-icono-5993-16.png"));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(186)
					.addComponent(lblSecretaria, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(100)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 329, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(5)
					.addComponent(btnhome, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(6)
					.addComponent(lblSecretaria)
					.addGap(11)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 287, GroupLayout.PREFERRED_SIZE)
					.addGap(3)
					.addComponent(btnhome, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
		);
		contentPane.setLayout(gl_contentPane);
	}

}
