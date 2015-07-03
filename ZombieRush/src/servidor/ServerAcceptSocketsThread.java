package servidor;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ServerAcceptSocketsThread extends Thread {
	ServerSocket serverSocket = null;
	List<Socket> socketsList = new ArrayList<Socket>();

	public ServerAcceptSocketsThread(ServerSocket serverSocket, ArrayList<Socket> socketList) {
		this.serverSocket = serverSocket;
		this.socketsList = socketList;
	}
	
	@Override
	public void run() {
		try {
			int numCliente = 0;
			while (true) {
				Socket clientSocket = serverSocket.accept();
				socketsList.add(clientSocket);

				System.out.println("Conexion recibida desde: "
						+ clientSocket.getInetAddress() + " en el puerto: "
						+ clientSocket.getPort());

				// creo un Thread para enviar y recibir desde el cliente
				ServerSendReceiveThread sendReceive = new ServerSendReceiveThread(
						clientSocket, socketsList, numCliente);
				
				Thread threadSendReceive = new Thread(sendReceive);
				threadSendReceive.start();
				numCliente++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
