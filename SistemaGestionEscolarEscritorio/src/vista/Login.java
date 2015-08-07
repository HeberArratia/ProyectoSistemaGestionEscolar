package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtUser;
	private JTextField txtPass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtUser = new JTextField();
		txtUser.setBounds(39, 48, 134, 28);
		contentPane.add(txtUser);
		txtUser.setColumns(10);
		
		txtPass = new JTextField();
		txtPass.setBounds(39, 88, 134, 28);
		contentPane.add(txtPass);
		txtPass.setColumns(10);
		
		JLabel lblResultado = new JLabel("...");
		lblResultado.setBounds(79, 169, 61, 16);
		contentPane.add(lblResultado);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*String user = txtUser.getText();
				String pass = txtPass.getText();
				ServicioPersonaProxy persona = new ServicioPersonaProxy();
				try {
					String resultado = persona.login(user,pass);
					lblResultado.setText(resultado);
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				//ServicioApoderado apoderado = new ServicioApoderadoProxy();
				try {
					String resultado = apoderado.crearApoderado("Carlos", "Opazo","76543472", "");
					lblResultado.setText(resultado);
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}*/
				
			}
		});
		btnEntrar.setBounds(49, 128, 117, 29);
		contentPane.add(btnEntrar);
		
		
	}
}
