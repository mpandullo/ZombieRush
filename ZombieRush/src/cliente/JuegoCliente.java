package cliente;

public class JuegoCliente {
	
	private Usuario usuario;
	private int[] partidas;
	private String[][] datosTabla;	
	
	public JuegoCliente(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public String[][] getDatosTabla() {
		return datosTabla;
	}

	public void setDatosTabla(String[][] datosTabla) {
		this.datosTabla = datosTabla;
	}

	public String[][] obtenerPartidas() {
		new SocketCliente().obtenerPartidas(this);
		this.partidas = new int[this.datosTabla.length];
		for (int i = 0; i < datosTabla.length; i++) {
			this.partidas[i] = Integer.parseInt(datosTabla[i][0]);
		}
		
		return datosTabla;
	}
}
