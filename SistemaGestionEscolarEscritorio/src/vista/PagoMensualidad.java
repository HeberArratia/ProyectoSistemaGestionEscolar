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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PagoMensualidad extends JFrame {

	private JPanel contentPane;

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
		panel.setBounds(101, 54, 353, 325);
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
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 16));
		textArea.setBounds(10, 39, 105, 22);
		panel.add(textArea);
		
		JButton btnIngresar = new JButton("Ingresar");
		btnIngresar.setFont(new Font("Calibri", Font.PLAIN, 12));
		btnIngresar.setBounds(120, 39, 97, 23);
		panel.add(btnIngresar);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_1.setBackground(new Color(0, 139, 139));
		panel_1.setBounds(10, 84, 292, 92);
		panel.add(panel_1);
		
		JLabel label_2 = new JLabel("Nombre:");
		label_2.setForeground(new Color(255, 255, 240));
		label_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_2.setBounds(10, 0, 164, 25);
		panel_1.add(label_2);
		
		JLabel label_3 = new JLabel("Apellido:");
		label_3.setForeground(new Color(255, 255, 240));
		label_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_3.setBounds(10, 22, 164, 25);
		panel_1.add(label_3);
		
		JLabel label_4 = new JLabel("Rut: ");
		label_4.setForeground(new Color(255, 255, 240));
		label_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_4.setBounds(10, 51, 164, 14);
		panel_1.add(label_4);
		
		JLabel label_5 = new JLabel("Estado Matr\u00EDcula:");
		label_5.setForeground(new Color(255, 255, 240));
		label_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_5.setBounds(10, 72, 164, 14);
		panel_1.add(label_5);
		
		JLabel label_6 = new JLabel("");
		label_6.setForeground(new Color(255, 255, 240));
		label_6.setBounds(118, 72, 164, 14);
		panel_1.add(label_6);
		
		JLabel label_7 = new JLabel("");
		label_7.setForeground(new Color(255, 255, 240));
		label_7.setBounds(118, 51, 164, 14);
		panel_1.add(label_7);
		
		JLabel label_8 = new JLabel("");
		label_8.setForeground(new Color(255, 255, 240));
		label_8.setBounds(118, 22, 164, 25);
		panel_1.add(label_8);
		
		JLabel label_9 = new JLabel("");
		label_9.setForeground(new Color(255, 255, 240));
		label_9.setBounds(118, 0, 164, 25);
		panel_1.add(label_9);
		
		JLabel lblMesAPagar = new JLabel("Mes a pagar:");
		lblMesAPagar.setForeground(new Color(255, 255, 240));
		lblMesAPagar.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblMesAPagar.setBounds(10, 188, 97, 14);
		panel.add(lblMesAPagar);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"}));
		comboBox.setBounds(10, 202, 122, 20);
		panel.add(comboBox);
		
		JLabel lblNewLabel = new JLabel("Monto a pagar por curso:");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(10, 226, 122, 14);
		panel.add(lblNewLabel);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setEnabled(false);
		textArea_1.setText("10000");
		textArea_1.setBounds(10, 243, 114, 22);
		panel.add(textArea_1);
		
		JLabel lblMontoAPagar = new JLabel("Monto a pagar:");
		lblMontoAPagar.setForeground(Color.WHITE);
		lblMontoAPagar.setBounds(10, 275, 122, 14);
		panel.add(lblMontoAPagar);
		
		JTextArea textArea_2 = new JTextArea();
		textArea_2.setText("100000");
		textArea_2.setEnabled(false);
		textArea_2.setBounds(10, 292, 114, 22);
		panel.add(textArea_2);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.setBounds(254, 293, 89, 23);
		panel.add(btnRegistrar);
		
		JButton button = new JButton("Volver");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
			}
		});
		button.setIcon(new ImageIcon("C:\\Users\\Heber\\workspace\\ProyectoGestionEduc-Escritorio\\src\\Files\\deshacer-icono-5993-16.png"));
		button.setFont(new Font("Calibri", Font.PLAIN, 12));
		button.setBounds(10, 393, 89, 23);
		contentPane.add(button);
	}

}
