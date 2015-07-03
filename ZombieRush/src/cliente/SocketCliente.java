package cliente;

public class SocketCliente {
	
	// Comunicacion con el server, devuelve un objeto usuario con los datos cargados
	// En caso de error el atributo idUsuario se carga con
	// -1:Usuario o pass invalidos / -2: usuario inexistente /
	public void login(Usuario usuario) {
		usuario.setIdUsuario(0);
		usuario.setTipoUsuario(0);
	}
	
	public JuegoCliente obtenerPartidas(JuegoCliente juego) {
		
		juego.setDatosTabla(new String[][] {
				{"0", "Apocalipsis Now", "Activo", "5", "20", "8", "124", "21:57"},
				{"1", "Comiendo Cerebros", "En espera", "10", "30", "4", "15", "05:45"}
			});
		
		return juego;
	}
}
