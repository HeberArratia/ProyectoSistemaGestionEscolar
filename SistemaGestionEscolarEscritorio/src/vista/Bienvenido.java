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
import javax.swing.UIManager;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class Bienvenido extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Bienvenido frame = new Bienvenido();
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
	public Bienvenido() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 547, 417);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 139, 139));
		contentPane.setForeground(new Color(176, 196, 222));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 139, 139));
		panel.setForeground(Color.BLACK);
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Seleccione usuario", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 255, 255)));
		panel.setLayout(null);
		
		JButton btndirector = new JButton("Director");
		btndirector.setBackground(new Color(220, 220, 220));
		btndirector.setIcon(new ImageIcon("C:\\Users\\Heber\\workspace\\ProyectoGestionEduc-Escritorio\\src\\Files\\hombre-negro-de-un-usuario-icono-7176-16.png"));
		
		btndirector.setBounds(10, 21, 95, 23);
		panel.add(btndirector);
		
		JButton btnjefeadm = new JButton("Jefe Adm.");
		btnjefeadm.setBackground(new Color(220, 220, 220));
		btnjefeadm.setIcon(new ImageIcon("C:\\Users\\Heber\\workspace\\ProyectoGestionEduc-Escritorio\\src\\Files\\hombre-negro-de-un-usuario-icono-7176-16.png"));
		btnjefeadm.setBounds(115, 21, 95, 23);
		
		panel.add(btnjefeadm);
		
		JButton btnprofesor = new JButton("Profesor");
		
		btnprofesor.setBackground(new Color(220, 220, 220));
		btnprofesor.setIcon(new ImageIcon("C:\\Users\\Heber\\workspace\\ProyectoGestionEduc-Escritorio\\src\\Files\\hombre-negro-de-un-usuario-icono-7176-16.png"));
		btnprofesor.setBounds(220, 21, 95, 23);
		panel.add(btnprofesor);
		
		JButton btnsecretaria = new JButton("Secretaria");
		btnsecretaria.setBackground(new Color(220, 220, 220));
		btnsecretaria.setIcon(new ImageIcon("C:\\Users\\Heber\\workspace\\ProyectoGestionEduc-Escritorio\\src\\Files\\hombre-negro-de-un-usuario-icono-7176-16.png"));
		btnsecretaria.setBounds(323, 21, 95, 23);
		
		
		panel.add(btnsecretaria);
		JPanel paneldirector = new JPanel();
		paneldirector.setBackground(new Color(0, 139, 139));
		paneldirector.setLayout(null);
		paneldirector.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Director - Seleccione tarea:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 255, 255)));
		paneldirector.setBounds(60, 55, 314, 142);
		panel.add(paneldirector);
		
		JButton button = new JButton("Obtener lista estudiantes morosos pago mensualidad");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ObtenerMorososMensualidad mm = new ObtenerMorososMensualidad();
				mm.setVisible(true);
				setVisible(false);
			}
		});
		button.setBounds(28, 110, 265, 21);
		paneldirector.add(button);
		button.setFont(new Font("Calibri", Font.PLAIN, 11));
		button.setBackground(new Color(224, 255, 255));
		
		JButton button_1 = new JButton("Obtener lista estudiantes morosos pago matricula");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ObtenerMorososMatricula di = new ObtenerMorososMatricula();
				di.setVisible(true);
				setVisible(false);
			}
		});
		button_1.setBounds(28, 91, 265, 21);
		paneldirector.add(button_1);
		button_1.setFont(new Font("Calibri", Font.PLAIN, 11));
		button_1.setBackground(new Color(224, 255, 255));
		
		JButton button_2 = new JButton("Conocer pagos profesores por curso");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConocerPagosProfesores rps = new ConocerPagosProfesores();
				rps.setVisible(true);
				setVisible(false);
			}
		});
		button_2.setBounds(28, 72, 265, 21);
		paneldirector.add(button_2);
		button_2.setFont(new Font("Calibri", Font.PLAIN, 11));
		button_2.setBackground(new Color(224, 255, 255));
		
		JButton button_3 = new JButton("Desactivar curso");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DesactivarCurso dc = new DesactivarCurso();
				dc.setVisible(true);
				setVisible(false);
			}
		});
		button_3.setBounds(28, 52, 265, 21);
		paneldirector.add(button_3);
		button_3.setFont(new Font("Calibri", Font.PLAIN, 11));
		button_3.setBackground(new Color(224, 255, 255));
		
		JButton button_4 = new JButton("Obtener balance de ingreso y gasto");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BalanceIngresoGasto big = new BalanceIngresoGasto();
				big.setVisible(true);
				setVisible(false);
			}
		});
		button_4.setBounds(28, 33, 265, 21);
		paneldirector.add(button_4);
		button_4.setFont(new Font("Calibri", Font.PLAIN, 11));
		button_4.setBackground(new Color(224, 255, 255));
		
		JPanel paneljefeadm = new JPanel();
		paneljefeadm.setBounds(60, 57, 312, 91);
		panel.add(paneljefeadm);
		paneljefeadm.setLayout(null);
		paneljefeadm.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Jefe Administraci\u00F3n - Seleccione tarea:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 255, 255)));
		paneljefeadm.setBackground(new Color(0, 139, 139));
		
		JButton btncrearcurso = new JButton("Crear curso y asignar profesor");
		btncrearcurso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CrearCurso cc = new CrearCurso();
				cc.setVisible(true);
				setVisible(false);
			}
		});
		btncrearcurso.setBounds(25, 41, 265, 21);
		paneljefeadm.add(btncrearcurso);
		btncrearcurso.setBackground(new Color(224, 255, 255));
		btncrearcurso.setFont(new Font("Calibri", Font.PLAIN, 11));
		
		JButton btnRegistrarSueldo = new JButton("Registrar sueldo profesor por curso");
		btnRegistrarSueldo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistrarSueldo rs = new RegistrarSueldo();
				rs.setVisible(true);
				setVisible(false);
			}
		});
		btnRegistrarSueldo.setBounds(25, 22, 265, 21);
		paneljefeadm.add(btnRegistrarSueldo);
		btnRegistrarSueldo.setBackground(new Color(224, 255, 255));
		btnRegistrarSueldo.setFont(new Font("Calibri", Font.PLAIN, 11));
		
		// Desactivar paneles de menus
				paneljefeadm.setVisible(false);
		
		JPanel panelprofesor = new JPanel();
		panelprofesor.setBounds(60, 55, 297, 79);
		panel.add(panelprofesor);
		panelprofesor.setLayout(null);
		panelprofesor.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Profesor: - Seleccione tarea:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 255, 255)));
		panelprofesor.setBackground(new Color(0, 139, 139));
		
		JButton btnInscribirAlumno = new JButton("Inscribir alumno en un curso");
		btnInscribirAlumno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InscribirEstudiante ia = new InscribirEstudiante();
				ia.setVisible(true);
				setVisible(false);
			}
		});
		btnInscribirAlumno.setFont(new Font("Calibri", Font.PLAIN, 11));
		btnInscribirAlumno.setBackground(new Color(224, 255, 255));
		btnInscribirAlumno.setBounds(14, 31, 265, 21);
		panelprofesor.add(btnInscribirAlumno);
		panelprofesor.setVisible(false);
		panelprofesor.setVisible(false);
		
		JPanel panelsecretaria = new JPanel();
		panelsecretaria.setBounds(60, 55, 297, 103);
		panel.add(panelsecretaria);
		panelsecretaria.setLayout(null);
		panelsecretaria.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Secretaria - Seleccione tarea:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 255, 255)));
		panelsecretaria.setBackground(new Color(0, 139, 139));
		
		JButton btnRegistrarPagoMen = new JButton("Registrar pago mensualidad del estudiante");
		btnRegistrarPagoMen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PagoMensualidad pm = new PagoMensualidad();
				pm.setVisible(true);
				setVisible(false);
			}
		});
		btnRegistrarPagoMen.setFont(new Font("Calibri", Font.PLAIN, 11));
		btnRegistrarPagoMen.setBackground(new Color(224, 255, 255));
		btnRegistrarPagoMen.setBounds(14, 52, 265, 21);
		panelsecretaria.add(btnRegistrarPagoMen);
		
		JButton btnRegistrarPagoMa = new JButton("Registrar pago matr\u00EDcula del estudiante");
		btnRegistrarPagoMa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PagoMatricula secre = new PagoMatricula();
				secre.setVisible(true);
				setVisible(false);
				
			}
		});
		btnRegistrarPagoMa.setFont(new Font("Calibri", Font.PLAIN, 11));
		btnRegistrarPagoMa.setBackground(new Color(224, 255, 255));
		btnRegistrarPagoMa.setBounds(14, 31, 265, 21);
		panelsecretaria.add(btnRegistrarPagoMa);
		panelsecretaria.setVisible(false);
		
		
		
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Heber\\workspace\\ProyectoGestionEduc-Escritorio\\src\\Files\\user.png"));
		
		JLabel lblBienvenido = new JLabel("Bienvenido");
		lblBienvenido.setForeground(new Color(255, 255, 240));
		lblBienvenido.setFont(new Font("Calibri", Font.PLAIN, 22));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(212)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblBienvenido, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(15)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE))))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(46)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 426, GroupLayout.PREFERRED_SIZE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(30)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblBienvenido, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(25)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)))
					.addGap(11)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 217, GroupLayout.PREFERRED_SIZE))
		);
		contentPane.setLayout(gl_contentPane);
		
		btnjefeadm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				paneldirector.setVisible(false);
				paneljefeadm.setVisible(true);
				panelprofesor.setVisible(false);
				panelsecretaria.setVisible(false);
			}
		});
		
		btndirector.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				paneldirector.setVisible(true);
				paneljefeadm.setVisible(false);
				panelprofesor.setVisible(false);
				panelsecretaria.setVisible(false);
			}
		});
		btnprofesor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelprofesor.setVisible(true);
				paneljefeadm.setVisible(false);
				paneldirector.setVisible(false);
				panelsecretaria.setVisible(false);
			}
		});
btnsecretaria.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				panelsecretaria.setVisible(true);
				panelprofesor.setVisible(false);
				paneljefeadm.setVisible(false);
				paneldirector.setVisible(false);
				
			}
		});
	}

}