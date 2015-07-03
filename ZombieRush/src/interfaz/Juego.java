package interfaz;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Juego extends JDialog {

	private JPanel contentPane;
	
	private Tablero tablero = new Tablero();
	
	// Constructor
	public Juego(PanelCliente p) {
		
		super(p, true);
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				cerrar();
			}
		});
		
		setTitle("Apocalipsis Now");
		setBounds(100, 100, 625, 627);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);
		tablero.setBorder(new LineBorder(new Color(67, 78, 84), 2));
		tablero.setBackground(SystemColor.scrollbar);
		
		tablero.setBounds(10, 34, 600, 450);
		contentPane.add(tablero);
		
		JLabel lblNombreJugador = new JLabel("Nombre Jugador");
		lblNombreJugador.setBounds(10, 10, 161, 14);
		contentPane.add(lblNombreJugador);
		
		JLabel lblPuntos = new JLabel("Puntos: 40");
		lblPuntos.setBounds(546, 9, 64, 14);
		contentPane.add(lblPuntos);
		
		JLabel lblTiempoDePartida = new JLabel("Tiempo de Partida: 12:01");
		lblTiempoDePartida.setBounds(10, 489, 200, 14);
		contentPane.add(lblTiempoDePartida);
		
		JLabel lblTiempoDeTurno = new JLabel("Tiempo de Turno: 5");
		lblTiempoDeTurno.setBounds(495, 489, 115, 14);
		contentPane.add(lblTiempoDeTurno);
		
		// Boton Arriba
		ImageIcon iconUp = new ImageIcon(Juego.class.getResource("/img/arriba.png"));
		ImageIcon iconUpHover = new ImageIcon(Juego.class.getResource("/img/arribaHover.png"));
		ImageIcon iconUpActive = new ImageIcon(Juego.class.getResource("/img/arribaActive.png"));
		JButton btnUp = new JButton("");
		btnUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tablero.arriba();
			}
		});
		btnUp.setBorderPainted(false);
		btnUp.setContentAreaFilled(false);
		btnUp.setFocusable(false);
		btnUp.setRolloverEnabled(true);
		
		btnUp.setIcon(iconUp);
		btnUp.setRolloverIcon(iconUpHover);
		btnUp.setPressedIcon(iconUpActive);
		
		btnUp.setBounds(286, 495, 36, 38);
		contentPane.add(btnUp);
		
		// Boton Abajo
		ImageIcon iconDown = new ImageIcon(Juego.class.getResource("/img/abajo.png"));
		ImageIcon iconDownHover = new ImageIcon(Juego.class.getResource("/img/abajoHover.png"));
		ImageIcon iconDownActive = new ImageIcon(Juego.class.getResource("/img/abajoActive.png"));
		JButton btnDown = new JButton("");
		btnDown.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tablero.abajo();
			}
		});
		btnDown.setBorderPainted(false);
		btnDown.setContentAreaFilled(false);
		btnDown.setFocusable(false);
		btnDown.setRolloverEnabled(true);
				
		btnDown.setIcon(iconDown);
		btnDown.setRolloverIcon(iconDownHover);
		btnDown.setPressedIcon(iconDownActive);
				
		btnDown.setBounds(286, 544, 36, 38);
		contentPane.add(btnDown);
		
		// Boton Izquierda
		ImageIcon iconLeft = new ImageIcon(Juego.class.getResource("/img/izquierda.png"));
		ImageIcon iconLeftHover = new ImageIcon(Juego.class.getResource("/img/izquierdaHover.png"));
		ImageIcon iconLeftActive = new ImageIcon(Juego.class.getResource("/img/izquierdaActive.png"));
		JButton btnLeft = new JButton("");
		btnLeft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tablero.izquierda();
			}
		});
		btnLeft.setBorderPainted(false);
		btnLeft.setContentAreaFilled(false);
		btnLeft.setFocusable(false);
		btnLeft.setRolloverEnabled(true);
					
		btnLeft.setIcon(iconLeft);
		btnLeft.setRolloverIcon(iconLeftHover);
		btnLeft.setPressedIcon(iconLeftActive);
				
		btnLeft.setBounds(246, 518, 36, 38);
		contentPane.add(btnLeft);
		
		// Boton Derecha
		ImageIcon iconRight = new ImageIcon(Juego.class.getResource("/img/derecha.png"));
		ImageIcon iconRightHover = new ImageIcon(Juego.class.getResource("/img/derechaHover.png"));
		ImageIcon iconRightActive = new ImageIcon(Juego.class.getResource("/img/derechaActive.png"));
		JButton btnRight = new JButton("");
		btnRight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tablero.derecha();
			}
		});
		btnRight.setBorderPainted(false);
		btnRight.setContentAreaFilled(false);
		btnRight.setFocusable(false);
		btnRight.setRolloverEnabled(true);
							
		btnRight.setIcon(iconRight);
		btnRight.setRolloverIcon(iconRightHover);
		btnRight.setPressedIcon(iconRightActive);
						
		btnRight.setBounds(326, 518, 36, 38);
		contentPane.add(btnRight);
	}
	
	// Cerrar ventana
	private void cerrar() {
		int opcion = JOptionPane.showConfirmDialog(this, "Desea abandonar la partida?\nSe perderán los puntos acumulados.");
		if( opcion == JOptionPane.YES_OPTION) {
			this.dispose();
		} 
	}
}
