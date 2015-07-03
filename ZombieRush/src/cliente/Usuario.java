package cliente;

import java.io.Serializable;

public class Usuario implements Serializable {
	
	private String tipoComunicacion;
	
	private int idUsuario;
	private int tipoUsuario;
	private String usuario;
	private String password;
	private String nombre;
	private String correo;
	private String preguntaSeguridad;
	private String respuestaSeguridad;
	
	public Usuario() {
		
	}
	
	public Usuario(Usuario usuario) {
		this.idUsuario = usuario.idUsuario;
		this.tipoUsuario = usuario.tipoUsuario;
		this.usuario = usuario.usuario;
		this.password = usuario.password;
		this.nombre = usuario.nombre;
		this.correo = usuario.correo;
		this.preguntaSeguridad = usuario.preguntaSeguridad;
		this.respuestaSeguridad = usuario.respuestaSeguridad;
	}
	
	// Gets y Sets
	public String getUsuario() {
		return usuario;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public int getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(int tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	// Metodos
	public void login() {
		this.tipoComunicacion = "login";
		
		new SocketCliente().login(this);	
	}
	
	
}
