package interfaz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import cliente.JuegoCliente;
import cliente.UsuarioNormal;

public class PanelCliente extends JFrame {

	private JPanel contentPane;
	private JTable table;
	
	private JuegoCliente juego;
	
	private String[][] datosTabla;

	// Constructor
	public PanelCliente(UsuarioNormal usuario) {
		
		this.juego = new JuegoCliente(usuario);
		
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				salir();
			}
		});
		
		setResizable(false);
		setTitle("Zombie Rush");
		setBounds(100, 100, 457, 232);
		setLocationRelativeTo(null);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		
		JMenu mnArchivo = new JMenu("Usuario");
		menuBar.add(mnArchivo);
		
		JMenuItem mnRegistrarme = new JMenuItem("Perfil");
		mnRegistrarme.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				perfil();
			}
		});
		mnArchivo.add(mnRegistrarme);
		
		JMenuItem mntmEstadisticas = new JMenuItem("Estadisticas");
		mntmEstadisticas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrirStats();
			}
		});
		mnArchivo.add(mntmEstadisticas);
		
		JMenuItem mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				salir();
			}
		});
		
		
		/*
		JMenuItem mntmCerrarSesin = new JMenuItem("Cerrar Sesi\u00F3n");
		mntmCerrarSesin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				try{
					Login frame = new Login();
					frame.setVisible(true);
				}catch(SQLException e){
					e.printStackTrace();
				}
			}
		});
		mnArchivo.add(mntmCerrarSesin);*/
		mnArchivo.add(mntmSalir);
		
		JMenu mnEstadisticas = new JMenu("Ranking");
		menuBar.add(mnEstadisticas);
		
		JMenuItem mntmVer = new JMenuItem("Ver");
		mntmVer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrirRanking();
			}
		});
		mnEstadisticas.add(mntmVer);
		
		JMenu mnSalir = new JMenu("Ayuda");
		menuBar.add(mnSalir);
		
		JMenuItem mntmInstrucciones = new JMenuItem("Instrucciones");
		mnSalir.add(mntmInstrucciones);
		
		JMenuItem mntmAcerdaDe = new JMenuItem("acerca de Zombie Rush");
		mnSalir.add(mntmAcerdaDe);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnUnirse = new JButton("Unirse");
		btnUnirse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				abrirJuego();
			}
		});
		btnUnirse.setBounds(182, 149, 89, 23);
		contentPane.add(btnUnirse);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 449, 139);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setShowVerticalLines(false);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		// Cargamos los datos de la tabla
		this.cargarDatosTabla();
		table.getColumnModel().getColumn(0).setPreferredWidth(116);
	}
	
	private void cargarDatosTabla() {
		String aux[][] = this.juego.obtenerPartidas();
		this.datosTabla = new String[aux.length][aux[0].length];
		for (int i = 0; i < aux.length; i++) {
			this.datosTabla[i][0] = aux[i][1];
			this.datosTabla[i][1] = aux[i][5] + "/" + aux[i][4];
			this.datosTabla[i][2] = aux[i][2];
		}
		this.table.setModel(new DefaultTableModel(this.datosTabla
				, new String[] {
					"Nombre", "Participantes", "Estado"
				}
			));
	}
	
	// Salir
	private void salir() {
		int opcion = JOptionPane.showConfirmDialog(this, "seguro que desea salir?", "Seleccionar una Opción",JOptionPane.YES_NO_OPTION);
		if( opcion == JOptionPane.YES_OPTION) {
			System.exit(0);
		} 
	}
	
	// Abrir Perfil
	private void perfil() {
		Perfil perfil = new Perfil(this);
		perfil.setVisible(true);
	}
	
	// Abrir Juego
	private void abrirJuego() {

	}
	
	// Abrir Estadisticas
	private void abrirStats() {

	}
	
	// Abrir Ranking
	private void abrirRanking() {

	}
}
