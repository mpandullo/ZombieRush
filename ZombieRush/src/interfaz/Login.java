package interfaz;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import cliente.Usuario;
import cliente.UsuarioAdmin;
import cliente.UsuarioNormal;

@SuppressWarnings("serial")
public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txt_Usuario;
	private JPasswordField pss_Usuario;

	private Usuario usuario;

	// Constructor
	public Login(Usuario usr) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\workspace\\ZombieRushCompleto\\src\\img\\zombie.png"));
		setTitle("Zombie Rush");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);

		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setBounds(105, 73, 77, 14);
		contentPane.add(lblUsuario);

		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setBounds(105, 113, 77, 14);
		contentPane.add(lblContrasea);

		txt_Usuario = new JTextField();
		txt_Usuario.setBounds(181, 70, 86, 20);
		contentPane.add(txt_Usuario);
		txt_Usuario.setColumns(10);

		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent arg0) {
				login();
			}
		});
		btnEntrar.setBounds(48, 183, 89, 23);
		contentPane.add(btnEntrar);

		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnSalir.setBounds(310, 183, 89, 23);
		contentPane.add(btnSalir);

		pss_Usuario = new JPasswordField();
		pss_Usuario.setBounds(181, 110, 86, 20);
		contentPane.add(pss_Usuario);

		JButton btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				abrirVentanaRegistro();
			}
		});
		btnRegistrarse.setBounds(166, 183, 112, 23);
		contentPane.add(btnRegistrarse);
		
		this.usuario = usr;
		
		this.setVisible(true);
	}

	/* METODOS */

	// Abrir la segunda ventana utilizando el this (necesito crearlo afuera del
	// constructor Principal)
	private void abrirPanelCliente() {
		try {
			UsuarioNormal normal = new UsuarioNormal(usuario);
			PanelCliente panelCliente = new PanelCliente(normal);
			panelCliente.setVisible(true);
			this.dispose();
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}
	
	private void abrirPanelAdmin() {
		try {
			UsuarioAdmin admin = new UsuarioAdmin(usuario);
			PanelAdmin panelAdmin = new PanelAdmin(admin);
			panelAdmin.setVisible(true);
			this.dispose();
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}

	// Abrimos la ventana de registro
	private void abrirVentanaRegistro() {
		try {
			Registro ventanaRZR = new Registro(this);
			ventanaRZR.setVisible(true);
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}
	
	private void login() {
		// Cargo los datos en el usuario creado en el main para hacer la validacion
		this.usuario.setUsuario(this.txt_Usuario.getText());
		this.usuario.setPassword(this.pss_Usuario.toString());
		
		this.usuario.login();
		
		int valor = this.usuario.getIdUsuario();
		
		switch (valor) {			
		case -1:
			JOptionPane.showMessageDialog(this, "Usuario y/o contraseña inválidos", "Error", JOptionPane.ERROR_MESSAGE);
			break;
			
		case -2:
			JOptionPane.showMessageDialog(this, "Usuario inexistente", "Error", JOptionPane.ERROR_MESSAGE);
			break;

		default:
			JOptionPane.showMessageDialog(this, "Bienvenido a Zombie Rush", "Bienvenido", JOptionPane.INFORMATION_MESSAGE);
			if (this.usuario.getTipoUsuario() == 0) {				
				this.abrirPanelCliente();
			} else {
				this.abrirPanelAdmin();
			}
			break;
		}
	}
}