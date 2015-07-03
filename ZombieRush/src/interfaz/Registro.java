package interfaz;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.jgoodies.forms.factories.DefaultComponentFactory;

public class Registro extends JDialog {

	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtCorreo;
	private JTextField txtConfCorreo;
	private JTextField txtUsuario;
	private JTextField txtRespSecreta;

	private String nombre;
	private String correo;
	private String usuario;
	private String password;
	private String respSecreta;
	private JPasswordField passwordField;
	private JPasswordField passwordFieldConf;

	//Constructor
	/**
	 * @wbp.parser.constructor
	 */
	public Registro(Login l) {
		super(l, true);
		carga();		
	}
	
	// Constructor para paneladmin
	public Registro(PanelAdmin p) {
		super(p, true);
		carga();		
	}

	private void carga() {
		setTitle("Registro");
		setBounds(100, 100, 483, 323);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);

		txtNombre = new JTextField();
		txtNombre.setHorizontalAlignment(SwingConstants.LEFT);
		txtNombre.setToolTipText("Nombre completo");
		txtNombre.setBounds(180, 11, 230, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);

		JLabel lblNombre = DefaultComponentFactory.getInstance().createLabel("Nombre:");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNombre.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombre.setBounds(41, 11, 129, 20);
		contentPane.add(lblNombre);

		txtCorreo = new JTextField();
		txtCorreo.setToolTipText("Nombre completo");
		txtCorreo.setHorizontalAlignment(SwingConstants.LEFT);
		txtCorreo.setColumns(10);
		txtCorreo.setBounds(180, 37, 230, 20);
		contentPane.add(txtCorreo);

		txtConfCorreo = new JTextField();
		txtConfCorreo.setToolTipText("Nombre completo");
		txtConfCorreo.setHorizontalAlignment(SwingConstants.LEFT);
		txtConfCorreo.setColumns(10);
		txtConfCorreo.setBounds(180, 63, 230, 20);
		contentPane.add(txtConfCorreo);

		txtUsuario = new JTextField();
		txtUsuario.setToolTipText("Nombre completo");
		txtUsuario.setHorizontalAlignment(SwingConstants.LEFT);
		txtUsuario.setColumns(10);
		txtUsuario.setBounds(180, 89, 230, 20);
		contentPane.add(txtUsuario);

		txtRespSecreta = new JTextField();
		txtRespSecreta.setToolTipText("Nombre completo");
		txtRespSecreta.setHorizontalAlignment(SwingConstants.LEFT);
		txtRespSecreta.setColumns(10);
		txtRespSecreta.setBounds(180, 203, 230, 20);
		contentPane.add(txtRespSecreta);

		JComboBox comboPregSeguridad = new JComboBox();
		comboPregSeguridad.setModel(new DefaultComboBoxModel(new String[] {
				"El nombre de tu madre?", "El nombre de tu primer mascota?",
				"Modelo de tu primer auto?" }));
		comboPregSeguridad.setBounds(180, 172, 230, 20);
		contentPane.add(comboPregSeguridad);

		JLabel lblNewJgoodiesLabel = DefaultComponentFactory.getInstance()
				.createLabel("Correo:");
		lblNewJgoodiesLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewJgoodiesLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewJgoodiesLabel.setBounds(78, 40, 92, 14);
		contentPane.add(lblNewJgoodiesLabel);

		JLabel lblConfirmarCorreo = DefaultComponentFactory.getInstance()
				.createLabel("Confirmar correo:");
		lblConfirmarCorreo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblConfirmarCorreo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblConfirmarCorreo.setBounds(53, 66, 117, 14);
		contentPane.add(lblConfirmarCorreo);

		JLabel lblNewJgoodiesLabel_1 = DefaultComponentFactory.getInstance()
				.createLabel("Usuario:");
		lblNewJgoodiesLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewJgoodiesLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewJgoodiesLabel_1.setBounds(78, 92, 92, 14);
		contentPane.add(lblNewJgoodiesLabel_1);

		JLabel lblContrasea = DefaultComponentFactory.getInstance()
				.createLabel("Contrase\u00F1a:");
		lblContrasea.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblContrasea.setHorizontalAlignment(SwingConstants.RIGHT);
		lblContrasea.setBounds(78, 118, 92, 14);
		contentPane.add(lblContrasea);

		JLabel lblRepetirContrasea = DefaultComponentFactory.getInstance()
				.createLabel("Confirmar Contrase\u00F1a:");
		lblRepetirContrasea.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblRepetirContrasea.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRepetirContrasea.setBounds(41, 144, 129, 14);
		contentPane.add(lblRepetirContrasea);

		JLabel lblRespuesta = DefaultComponentFactory.getInstance()
				.createLabel("Respuesta:");
		lblRespuesta.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblRespuesta.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRespuesta.setBounds(78, 206, 92, 14);
		contentPane.add(lblRespuesta);

		JLabel lblPreguntaDeSeguridad = DefaultComponentFactory.getInstance()
				.createLabel("Pregunta de seguridad:");
		lblPreguntaDeSeguridad.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPreguntaDeSeguridad.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPreguntaDeSeguridad.setBounds(31, 175, 139, 14);
		contentPane.add(lblPreguntaDeSeguridad);

		JButton btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comprobarSeguridad();
			}
		});
		btnRegistrarse.setBounds(180, 250, 102, 23);
		contentPane.add(btnRegistrarse);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnCancelar.setBounds(308, 250, 102, 23);
		contentPane.add(btnCancelar);

		passwordField = new JPasswordField();
		passwordField.setBounds(180, 116, 230, 20);
		contentPane.add(passwordField);

		passwordFieldConf = new JPasswordField();
		passwordFieldConf.setBounds(180, 141, 230, 20);
		contentPane.add(passwordFieldConf);
	}
	
	@SuppressWarnings("deprecation")
	private void comprobarSeguridad(){
		
		if (!passwordField.getText().equals(passwordFieldConf.getText()) ){ 
			JOptionPane.showMessageDialog(this, "Revise la confirmación de la Contraseña");
			//System.out.println("pass1:"+passwordField.getText()+"pass2:"+passwordFieldConf.getText());
		}
		else if (!txtCorreo.getText().equals(txtConfCorreo.getText())){ 
			JOptionPane.showMessageDialog(this, "Revise la confirmación del Correo");
			
		}else
			registrarse();
	}
	
	public int getNumerador(Conexion con, String table){
		
		ResultSet rs = null;
		String sql;
		int numerador=0;
		
		try {
			sql ="SELECT count() numerador FROM "+ table;
			rs = con.obtenerRegistros(sql);
			if (rs.next()) {
				numerador= rs.getInt("numerador");
			}
			numerador++;
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			try {
				con.cerrarRs(rs);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return numerador;
	}
	
	@SuppressWarnings("deprecation")
	protected void registrarse() {
		nombre = txtNombre.getText();
		correo = txtCorreo.getText();
		usuario = txtUsuario.getText();
		password = passwordField.getText();
		respSecreta = txtRespSecreta.getText();
		int codUsuario;
		
		Conexion con = null;
		String sql;
		
		try {
			con = new Conexion();
			codUsuario= getNumerador(con,"Usuario");
			sql = "INSERT INTO usuario (cod_usuario, nom_usuario, contraseña, fecha_mod, usuario_mod, nick_usuario, "
					+ "correo, pregunta_seguridad, partidas_jugadas, total_puntos, fecha_creacion) VALUES ("+codUsuario+",'"+nombre+"','"+password
					+"',getdate(),'"+usuario+"','"+usuario+"','"+correo+"','"+respSecreta+"',0,0,"+"getdate()"+");";
			System.out.println(sql);
			if (con.ejecutarQuery(sql)== true) {
				JOptionPane.showMessageDialog(this, "Registro procesado exitosamente!");
				this.dispose();
			}
			else
				JOptionPane.showMessageDialog(this, "Error al Insertar Registro, Revise los Datos");
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

