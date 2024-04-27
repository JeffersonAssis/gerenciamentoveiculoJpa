package br.com.concessionaria.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.concessionaria.conexao.Conexao;
import jakarta.persistence.EntityManager;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PrimeiraTela extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EntityManager em = Conexao.getConn();
		
		try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException|IllegalAccessException |javax.swing.UnsupportedLookAndFeelException ex) {
        	System.err.println("Erro:"+ex);
        }
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrimeiraTela frame = new PrimeiraTela();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PrimeiraTela() {
		setForeground(new Color(0, 0, 255));
		setFont(null);
		setResizable(false);
		setTitle("Concessionaria - Vem que tem!!");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Davi\\eclipse-workspace\\gerenciamantoveiculo\\src\\main\\resources\\imagens\\icon.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnFrenteLoja = new JButton("Frente de Loja");
		btnFrenteLoja.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ViewFrenteCaixa frame = new ViewFrenteCaixa();
				frame.setVisible(true);
			}
		});
		btnFrenteLoja.setForeground(new Color(0, 0, 255));
		btnFrenteLoja.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnFrenteLoja.setBounds(10, 92, 185, 68);
		contentPane.add(btnFrenteLoja);
		
		JLabel lblNewLabel = new JLabel("Seja bem-vindo!");
		lblNewLabel.setBounds(139, 11, 147, 22);
		lblNewLabel.setForeground(new Color(0, 0, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		contentPane.add(lblNewLabel);
		
		JButton btnManutencao = new JButton("Cadastro");
		btnManutencao.setForeground(Color.BLUE);
		btnManutencao.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnManutencao.setBounds(239, 92, 185, 68);
		contentPane.add(btnManutencao);
	}
}