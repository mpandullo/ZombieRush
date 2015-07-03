package servidor;

import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ServerSendReceiveThread extends Thread {
	Socket socketId = null;
	List<Socket> socketsList = new ArrayList<Socket>();
	int clientId;
	Object obj;

	public ServerSendReceiveThread(Socket socket, List<Socket> socketsList,
			int numCliente) {
		this.socketId = socket;
		this.socketsList = socketsList;
		this.clientId = numCliente;
	}

	@Override
	public void run() {
		try {
			while (true) {
				ObjectInputStream inStream = new ObjectInputStream(
						socketId.getInputStream());
				obj = inStream.readObject();
				MSG tipo = MSG.valueOf(obj.getClass().getSimpleName());
				switch (tipo) {
				case Login:

					break;

				case Movimiento:

					break;

				default:
					break;
				}

			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
