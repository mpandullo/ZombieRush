package cliente;

import interfaz.Login;

public class Main {

	public static void main(String[] args) {
		Usuario usuario = new Usuario();
		Login login = new Login(usuario);
	}

}
