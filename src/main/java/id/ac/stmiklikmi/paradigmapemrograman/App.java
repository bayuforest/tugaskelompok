package id.ac.stmiklikmi.paradigmapemrograman;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

/**
 * Class utama yang merupakan turunan dari class JFrame dan implements dari
 * interface ActionListener
 * 
 * @author USER
 * @since 5 Oct 2019
 * 
 */
public class App extends JFrame implements ActionListener {
	
	
	/**
	 * Default serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * pesan yang ditampilkan dalam teks berjalan, berisi nama-nama anggota kelompok, terurut berdasarkan abjad
	 */
	String pesan[] = { "Ami", "Bayu", "Farhan", "Firman", "Prio", "Rina" };
	
	/**
	 * variabel yang menunjukan indeks pesan yang ditampilkan dalam teks berjalan
	 */
	int index = 0;
	
	/**
	 * komponen teks berjalan (JLabel) yang akan ditampilkan
	 */
	JLabel lblInfo = new JLabel(pesan[index]);
	
	/**
	 * koordinat teks berjalan yang nantinya akan dikurangi secara berulang, dan akan direset setelah mencapai titik tertentu
	 */
	int x = 400;
	
	/**
	 * komponen timer yang setiap 0.1 detik nantinya akan menggeser posisi lblInfo dgn memanggil method aturTampilPesan()
	 */
	Timer timer = new Timer(100, this);
	
	/**
	 * inisialisasi variabel saja
	 */
	Random random = new Random();
	
	/**
	 * Constructor dari kelas App yang menginisialisasi kondisi awal program
	 */
	public App(){
		setTitle("Rolling Text");
		setLayout(null);		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 100);
		setResizable(false);
		setLocationRelativeTo(null);

		lblInfo.setBounds(x, 20, 300, 30);
		lblInfo.setFont(new Font("Arial", 1, 24));
		add(lblInfo);
		
		setVisible(true);
		timer.start();
	}
	
	public void actionPerformed(ActionEvent ae) {		
		aturTampilPesan();
	}

	/**
	 * main method
	 * @param args
	 */
	public static void main(String[] args) {
		new App();
	}
	
	/**
	 * method yang melakukan algoritma teks berjalan. Ketika posisi teks ada pada koordinat x > -150, maka x akan dikurangi 10.
	 * Selebihnya, posisi x akan dikembalikan ke posisi x = 400, kemudian akan dilakukan random untuk menentukan warna dari teks,
	 * dan menampilkan nama anggota kelompok berikutnya. Bila semua nama anggota sudah ditampilkan, maka nama anggota kelompok 
	 * yang ditampilkan akan mulai dari awal.
	 */
	private void aturTampilPesan(){
		if (x >= -150) {
			x -= 10;
			lblInfo.setBounds(x, 20, 300, 30);
		} else {
			x = 400;
			int warna = random.nextInt(6);
			index = (index<pesan.length-1)?++index:0;
			if (warna == 0) {
				lblInfo.setForeground(Color.MAGENTA);
				lblInfo.setText(pesan[index]);
			} else if (warna == 1) {
				lblInfo.setForeground(Color.BLUE);
				lblInfo.setText(pesan[index]);
			} else if (warna == 2) {
				lblInfo.setForeground(Color.RED);
				lblInfo.setText(pesan[index]);
			} else if (warna == 3){
				lblInfo.setForeground(Color.BLACK);
				lblInfo.setText(pesan[index]);
			} else if (warna == 4){
				lblInfo.setForeground(Color.GREEN);
				lblInfo.setText(pesan[index]);
			} else {
				lblInfo.setForeground(Color.ORANGE);
				lblInfo.setText(pesan[index]);
			}
		}
	}
}
