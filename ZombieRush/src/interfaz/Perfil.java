package interfaz;

import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultComboBoxModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;

public class Perfil extends JDialog {

	private JPanel contentPane;
	private String codUsuario;
	private JTextField txtUsuario;
	private JTextField txtNombre;
	private JPasswordField txtContrasena;
	private JTextField txtRepCorreo;
	private JTextField txtRespuesta;
	private JPasswordField txtRepContrasena;
	private JTextField txtCorreo;

	// Constructor
	/**
	 * @wbp.parser.constructor
	 */
	public Perfil(PanelCliente p) {
		super(p, true);		
		cargar();		
	}
	
	// Constructor Panel Admin
	public Perfil(PanelAdmin p) {
		super(p, true);
		cargar();
	}
	
	private void cargar() {
		setTitle("Perfil");
		setBounds(100, 100, 453, 501);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUsuario.setBounds(10, 130, 126, 19);
		contentPane.add(lblUsuario);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombre.setBounds(10, 160, 126, 19);
		contentPane.add(lblNombre);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setHorizontalAlignment(SwingConstants.RIGHT);
		lblContrasea.setBounds(10, 190, 126, 19);
		contentPane.add(lblContrasea);
		
		JLabel lblMail = new JLabel("Correo:");
		lblMail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMail.setBounds(10, 254, 126, 19);
		contentPane.add(lblMail);
		
		JLabel lblNewLabel = new JLabel("Pregunta de Seguridad:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(10, 349, 126, 19);
		contentPane.add(lblNewLabel);
		
		JLabel lblRespuesta = new JLabel("Respuesta:");
		lblRespuesta.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRespuesta.setBounds(10, 380, 126, 19);
		contentPane.add(lblRespuesta);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(153, 129, 243, 20);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(153, 160, 243, 20);
		contentPane.add(txtNombre);
		
		txtContrasena = new JPasswordField();
		txtContrasena.setColumns(10);
		txtContrasena.setBounds(153, 191, 243, 20);
		contentPane.add(txtContrasena);
		
		txtRepCorreo = new JTextField();
		txtRepCorreo.setColumns(10);
		txtRepCorreo.setBounds(153, 284, 243, 20);
		contentPane.add(txtRepCorreo);
		
		txtRespuesta = new JTextField();
		txtRespuesta.setColumns(10);
		txtRespuesta.setBounds(153, 379, 243, 20);
		contentPane.add(txtRespuesta);
		
		JComboBox cmbPreg = new JComboBox();
		cmbPreg.setModel(new DefaultComboBoxModel(new String[] {"El nombre de tu madre?", "El nombre de tu primer mascota?", "Modelo de tu primer auto?"}));
		cmbPreg.setBounds(153, 348, 243, 20);
		contentPane.add(cmbPreg);
		
		JButton btnModificarDatos = new JButton("Aceptar");
		btnModificarDatos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				comprobarSeguridad();
			}
		});
		btnModificarDatos.setBounds(121, 427, 89, 23);
		contentPane.add(btnModificarDatos);
		
		txtRepContrasena = new JPasswordField();
		txtRepContrasena.setColumns(10);
		txtRepContrasena.setBounds(153, 222, 243, 20);
		contentPane.add(txtRepContrasena);
		
		txtCorreo = new JTextField();
		txtCorreo.setColumns(10);
		txtCorreo.setBounds(153, 253, 243, 20);
		contentPane.add(txtCorreo);
		
		JLabel lblRepetirCorreo = new JLabel("Repetir Correo:");
		lblRepetirCorreo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRepetirCorreo.setBounds(10, 284, 126, 19);
		contentPane.add(lblRepetirCorreo);
		
		JLabel lblRepetirContrasea = new JLabel("Repetir Contrase\u00F1a:");
		lblRepetirContrasea.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRepetirContrasea.setBounds(10, 220, 126, 19);
		contentPane.add(lblRepetirContrasea);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnCancelar.setBounds(240, 427, 89, 23);
		contentPane.add(btnCancelar);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Perfil.class.getResource("/img/perfil.png")));
		lblNewLabel_1.setBounds(162, -17, 167, 144);
		contentPane.add(lblNewLabel_1);
		
		cargarDatosPerfil();
	}
	
	@SuppressWarnings("deprecation")
	private void comprobarSeguridad(){
		
		if (!txtContrasena.getText().equals(txtRepContrasena.getText()) ){ 
			JOptionPane.showMessageDialog(this, "Revise la confirmación de la Contraseña");
			//System.out.println("pass1:"+passwordField.getText()+"pass2:"+passwordFieldConf.getText());
		}
		else if (!txtCorreo.getText().equals(txtRepCorreo.getText())){ 
			JOptionPane.showMessageDialog(this, "Revise la confirmación del Correo");
			
		}else
			actualizarUsuario();
	}
	
	public void cargarDatosPerfil(){
		
		Conexion con=null;
		ResultSet rs = null;
		String sql;
		
		try {
			con = new Conexion();
			sql = "SELECT cod_usuario,nom_usuario,contraseña,nick_usuario,"
					+ "correo,pregunta_seguridad FROM usuario WHERE cod_usuario='"+Login.getCodUsuario()+"'";
		//	System.out.println(sql);
			
			rs = con.obtenerRegistros(sql);
			if (rs.next()) {
				codUsuario= rs.getString("cod_usuario");
				txtUsuario.setText(rs.getString("nick_usuario"));
				txtNombre.setText(rs.getString("nom_usuario"));
				txtCorreo.setText(rs.getString("correo"));
				txtRepCorreo.setText(rs.getString("correo"));
				txtRespuesta.setText(rs.getString("pregunta_seguridad"));
				txtContrasena.setText(rs.getString("contraseña"));
				txtRepContrasena.setText(rs.getString("contraseña"));
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			try {
				if (con != null)
					con.cerrarConexion();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}	
	}
	
	@SuppressWarnings("deprecation")
	public void actualizarUsuario(){
		
		Conexion con = null;
		String sql;
		
		try {
			con = new Conexion();
			
			sql = "UPDATE usuario SET nom_usuario='"+txtNombre.getText()+"',contraseña='"+txtContrasena.getText()+"',fecha_mod=getdate()"
			+",usuario_mod='"+txtUsuario.getText()+"',nick_usuario='"+txtUsuario.getText()+"',correo='"+txtCorreo.getText()
			+"',pregunta_seguridad='"+txtRespuesta.getText()+"' WHERE cod_usuario='"+codUsuario+"';";
			//System.out.println(sql);
			if (con.ejecutarQuery(sql)== true) {
				JOptionPane.showMessageDialog(this, "Perfil actualizado exitosamente!");
				this.dispose();
			}
			else
				JOptionPane.showMessageDialog(this, "Error al Actualizar Perfil, Revise los Datos");
		// TODO si el registro es exitoso abrimos dialogo y cerramos
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			try {
				if (con != null)
					con.cerrarConexion();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
