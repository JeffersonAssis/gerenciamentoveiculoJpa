package br.com.concessionaria.view;

import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ViewCadastro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtCpfBuscar;
	private JTextField textField;
	private JTable tableCliente;
	
	
	public ViewCadastro() {
		setTitle("Concessionaria -  Vem que Tem!");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Davi\\eclipse-workspace\\gerenciamantoveiculo\\src\\main\\resources\\imagens\\icon.png"));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 950, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		JInternalFrame intFrameCliente = new JInternalFrame("Cadastro de Cliente");

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 964, 22);
		contentPane.add(menuBar);
		
		JMenu MenuCliente = new JMenu("Atualizar Cliente");
		MenuCliente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				intFrameCliente.setVisible(true);
			}
		});
		menuBar.add(MenuCliente);
		
		JMenu manuVeiculo = new JMenu("Atualizar Veiculo");
		menuBar.add(manuVeiculo);
		
		JMenu menuFuncionario = new JMenu("Atualizar Funcionario");
		menuBar.add(menuFuncionario);
		
		JMenu menuLoja = new JMenu("Atualizar Loja");
		menuBar.add(menuLoja);
		
		JMenu menuVenda = new JMenu("Atualizar Venda");
		menuBar.add(menuVenda);
		
		
		intFrameCliente.setFrameIcon(new ImageIcon("C:\\Users\\Davi\\eclipse-workspace\\gerenciamantoveiculo\\src\\main\\resources\\imagens\\icon.png"));
		intFrameCliente.setClosable(true);
		intFrameCliente.setBounds(10, 21, 914, 629);
		contentPane.add(intFrameCliente);
		intFrameCliente.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Buscar CPF:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(10, 11, 91, 14);
		intFrameCliente.getContentPane().add(lblNewLabel);
		
		txtCpfBuscar = new JTextField();
		txtCpfBuscar.setBounds(87, 9, 210, 20);
		intFrameCliente.getContentPane().add(txtCpfBuscar);
		txtCpfBuscar.setColumns(10);
		
		JLabel lblBuscarNome = new JLabel("Buscar Nome:");
		lblBuscarNome.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblBuscarNome.setBounds(320, 11, 91, 14);
		intFrameCliente.getContentPane().add(lblBuscarNome);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(416, 9, 472, 20);
		intFrameCliente.getContentPane().add(textField);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 36, 878, 165);
		intFrameCliente.getContentPane().add(scrollPane);
		
		tableCliente = new JTable();
		
		scrollPane.setViewportView(tableCliente);
		intFrameCliente.setVisible(false);
	}
}
