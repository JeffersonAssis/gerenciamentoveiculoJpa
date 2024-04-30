package br.com.concessionaria.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import br.com.concessionaria.model.Cliente;
import br.com.concessionaria.model.Endereco;
import br.com.concessionaria.model.Funcionario;
import br.com.concessionaria.model.Loja;
import br.com.concessionaria.service.ClienteService;
import br.com.concessionaria.service.EnderecoService;
import br.com.concessionaria.service.FuncionarioSevice;

public class ViewCadastro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtCpfBuscar;
	private JTextField txtBuscarNome;
	private JTable tableCliente;
	private DefaultTableModel modeloCliente;
	private DefaultTableModel modeloFun;
	private JTextField txtNomeCliente;
	private JTextField txtTelefoneCliente;
	private JTextField txtCpfCliente;
	private JTextField txtCepCliente;
	private JTextField txtLogradouro;
	private JTextField txtNumCliente;
	private JTextField txtUfCliente;
	private JTextField txtCidadeCliente;
	private JTextField txtBairroCliente;
	private JTextField txtComplementoCliente;
	private JTextField txtMatriculaFun;
	private JTextField txtNomeLojaFun;
	private JTextField txtNomeFun;
	private JTextField txtMatricula;
	private JTextField txtCpfFun;
	private JTextField txtCepFun;
	private JTextField txtLogradouroFun;
	private JTextField txtNumFun;
	private JTextField txtUfFun;
	private JTextField txtCidadeFun;
	private JTextField txtBairroFun;
	private JTextField txtComplementoFun;
	private JTable tableFun;
	private JTextField txtFunNomeLoja;
	private JTextField txtFunCepLoja;
	
	
	public ViewCadastro() {
		setTitle("Concessionaria -  Vem que Tem!");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Davi\\eclipse-workspace\\gerenciamantoveiculo\\src\\main\\resources\\imagens\\icon.png"));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 950, 609);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		JInternalFrame intFrameCliente = new JInternalFrame("Cadastro de Cliente");
		JInternalFrame intFrameFuncionario = new JInternalFrame("Cadastro de Funcionario");
		
		
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
		menuFuncionario.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				intFrameFuncionario.setVisible(true);
			}
		});
		menuBar.add(menuFuncionario);
		
		JMenu menuLoja = new JMenu("Atualizar Loja");
		menuBar.add(menuLoja);
		
		JMenu menuVenda = new JMenu("Atualizar Venda");
		menuBar.add(menuVenda);
		modeloCliente = new DefaultTableModel();
		String [] colunaCliente = {"CPF","NOME","TELEFONE","CEP","LOGRADOURO","Nº"};
		modeloCliente.setColumnIdentifiers(colunaCliente);
		
		
		intFrameFuncionario.setFrameIcon(new ImageIcon("C:\\Users\\Davi\\eclipse-workspace\\gerenciamantoveiculo\\src\\main\\resources\\imagens\\icon.png"));
		intFrameFuncionario.setClosable(true);
		intFrameFuncionario.setBounds(10, 21, 914, 542);
		contentPane.add(intFrameFuncionario);
		intFrameFuncionario.getContentPane().setLayout(null);
		
		JLabel lblBuscarMatricula = new JLabel("Buscar Matricula:");
		lblBuscarMatricula.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblBuscarMatricula.setBounds(10, 22, 122, 14);
		intFrameFuncionario.getContentPane().add(lblBuscarMatricula);
		
		txtMatriculaFun = new JTextField();
		txtMatriculaFun.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
			while(tableFun.getRowCount()>0) {
				((DefaultTableModel)tableFun.getModel()).removeRow(0);
			}
			if(!txtMatriculaFun.getText().isEmpty()) {
			Funcionario fun =  FuncionarioSevice.buscarMatricula(txtMatriculaFun.getText());
				if(!fun.getCpf().isEmpty()) {
					String [] linha = {fun.getMatricula(), fun.getNome(), fun.getCpf(),fun.getEndereco().getCep(),fun.getEndereco().getLogradouro(),fun.getNumResidencia()};
					modeloFun.addRow(linha);
					txtMatriculaFun.setText("");
				}else {
					JOptionPane.showMessageDialog(null, "Funcionario não Cadastrado!");
				}
			}
		}
		});
		txtMatriculaFun.setColumns(10);
		txtMatriculaFun.setBounds(124, 20, 173, 20);
		intFrameFuncionario.getContentPane().add(txtMatriculaFun);
		
		JLabel lblBuscarNomeLoja = new JLabel("Buscar Nome Loja:");
		lblBuscarNomeLoja.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblBuscarNomeLoja.setBounds(320, 22, 126, 14);
		intFrameFuncionario.getContentPane().add(lblBuscarNomeLoja);
		
		txtNomeLojaFun = new JTextField();
		txtNomeLojaFun.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				while(tableFun.getRowCount()>0) {
					((DefaultTableModel)tableFun.getModel()).removeRow(0);
				}
				if(!txtNomeLojaFun.getText().isEmpty()) {
				List<Funcionario> Listfun =  FuncionarioSevice.buscarTodosFuncionariosLoja(txtNomeLojaFun.getText());
					if(Listfun.size()>0) {
						for(Funcionario fun : Listfun) {
						String [] linha = {fun.getMatricula(), fun.getNome(), fun.getCpf(),fun.getEndereco().getCep(),fun.getEndereco().getLogradouro(),fun.getNumResidencia()};
						modeloFun.addRow(linha);
						}
						txtNomeLojaFun.setText("");
					}else {
						JOptionPane.showMessageDialog(null, "Funcionario não Cadastrado!");
					}
				}
			}
		});
		txtNomeLojaFun.setColumns(10);
		txtNomeLojaFun.setBounds(442, 20, 446, 20);
		intFrameFuncionario.getContentPane().add(txtNomeLojaFun);
		
		JLabel lblNewLabel_1_2 = new JLabel("Nome:");
		lblNewLabel_1_2.setBounds(22, 246, 46, 14);
		intFrameFuncionario.getContentPane().add(lblNewLabel_1_2);
		
		txtNomeFun = new JTextField();
		txtNomeFun.setColumns(10);
		txtNomeFun.setBounds(22, 268, 424, 20);
		intFrameFuncionario.getContentPane().add(txtNomeFun);
		
		JLabel lblNewLabel_1_1_3 = new JLabel("Matricula");
		lblNewLabel_1_1_3.setBounds(22, 299, 46, 14);
		intFrameFuncionario.getContentPane().add(lblNewLabel_1_1_3);
		
		txtMatricula = new JTextField();
		txtMatricula.setColumns(10);
		txtMatricula.setBounds(22, 321, 204, 20);
		intFrameFuncionario.getContentPane().add(txtMatricula);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("CPF:");
		lblNewLabel_1_1_1_1.setBounds(487, 246, 46, 14);
		intFrameFuncionario.getContentPane().add(lblNewLabel_1_1_1_1);
		
		txtCpfFun = new JTextField();
		txtCpfFun.setColumns(10);
		txtCpfFun.setBounds(487, 268, 234, 20);
		intFrameFuncionario.getContentPane().add(txtCpfFun);
		
		JLabel lblNewLabel_2_4 = new JLabel("CEP:");
		lblNewLabel_2_4.setBounds(281, 299, 46, 14);
		intFrameFuncionario.getContentPane().add(lblNewLabel_2_4);
		
		txtCepFun = new JTextField();
		txtCepFun.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(txtCepFun.getText().length() == 8) {
					Endereco end = EnderecoService.buscarCep(txtCepFun.getText());
						if(!end.getCiade().isEmpty()) {
							txtBairroFun.setText(end.getBairro());
							txtLogradouroFun.setText(end.getLogradouro());
							txtCidadeFun.setText(end.getCiade());
							txtComplementoFun.setText(end.getComplemento());
							txtUfFun.setText(end.getUf());
						}else {
							JOptionPane.showMessageDialog(null, "CEP inválido!");
						}
					}else {
						JOptionPane.showMessageDialog(null, "CEP inválido!");
					}
			}
		});
		txtCepFun.setColumns(10);
		txtCepFun.setBounds(279, 321, 204, 20);
		intFrameFuncionario.getContentPane().add(txtCepFun);
		
		txtLogradouroFun = new JTextField();
		txtLogradouroFun.setColumns(10);
		txtLogradouroFun.setBounds(522, 321, 353, 20);
		intFrameFuncionario.getContentPane().add(txtLogradouroFun);
		
		JLabel lblNewLabel_2_1_2 = new JLabel("Logradouro:");
		lblNewLabel_2_1_2.setBounds(524, 299, 197, 14);
		intFrameFuncionario.getContentPane().add(lblNewLabel_2_1_2);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("Nº");
		lblNewLabel_2_2_1.setBounds(747, 246, 128, 14);
		intFrameFuncionario.getContentPane().add(lblNewLabel_2_2_1);
		
		txtNumFun = new JTextField();
		txtNumFun.setColumns(10);
		txtNumFun.setBounds(745, 268, 130, 20);
		intFrameFuncionario.getContentPane().add(txtNumFun);
		
		JLabel lblNewLabel_1_1_2_1 = new JLabel("Bairro:");
		lblNewLabel_1_1_2_1.setBounds(22, 352, 46, 14);
		intFrameFuncionario.getContentPane().add(lblNewLabel_1_1_2_1);
		
		JLabel lblNewLabel_2_3_1 = new JLabel("Cidade:");
		lblNewLabel_2_3_1.setBounds(281, 352, 46, 14);
		intFrameFuncionario.getContentPane().add(lblNewLabel_2_3_1);
		
		JLabel lblNewLabel_2_1_1_2 = new JLabel("Estado:");
		lblNewLabel_2_1_1_2.setBounds(489, 352, 183, 14);
		intFrameFuncionario.getContentPane().add(lblNewLabel_2_1_1_2);
		
		txtUfFun = new JTextField();
		txtUfFun.setColumns(10);
		txtUfFun.setBounds(487, 374, 185, 20);
		intFrameFuncionario.getContentPane().add(txtUfFun);
		
		txtCidadeFun = new JTextField();
		txtCidadeFun.setColumns(10);
		txtCidadeFun.setBounds(279, 374, 181, 20);
		intFrameFuncionario.getContentPane().add(txtCidadeFun);
		
		txtBairroFun = new JTextField();
		txtBairroFun.setColumns(10);
		txtBairroFun.setBounds(22, 374, 204, 20);
		intFrameFuncionario.getContentPane().add(txtBairroFun);
		
		JButton btnCadastraFun = new JButton("Cadastrar");
		btnCadastraFun.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Funcionario c  = new Funcionario();
				Endereco end = new Endereco();
				Loja l = new Loja();
				c.setCpf(txtCpfFun.getText());
				c.setNome(txtNomeFun.getText());
				c.setMatricula(txtMatricula.getText());
				c.setNumResidencia(txtNumFun.getText());
				end.setCep(txtCepFun.getText());
				l.setNome(txtFunNomeLoja.getText());
				c.setLoja(l);
				c.setEndereco(end);
				
				if(c.getCpf().length() == 11) {
					FuncionarioSevice.save(c);
					txtBairroFun.setText(""); txtCepFun.setText(""); txtCidadeFun.setText("");
					txtComplementoFun.setText(""); txtNomeLojaFun.setText(""); txtMatriculaFun.setText("");
					txtCpfFun.setText(""); txtLogradouroFun.setText(""); txtNomeFun.setText(""); 
					txtNumFun.setText(""); txtMatricula.setText(""); txtUfFun.setText("");
					txtFunCepLoja.setText(""); txtFunNomeLoja.setText("");
				}
			}
		});
		btnCadastraFun.setForeground(new Color(0, 128, 255));
		btnCadastraFun.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCadastraFun.setBackground(new Color(0, 128, 255));
		btnCadastraFun.setBounds(22, 463, 119, 23);
		intFrameFuncionario.getContentPane().add(btnCadastraFun);
		
		JLabel lblNewLabel_2_1_1_1_1 = new JLabel("Complemento:");
		lblNewLabel_2_1_1_1_1.setBounds(715, 352, 160, 14);
		intFrameFuncionario.getContentPane().add(lblNewLabel_2_1_1_1_1);
		
		txtComplementoFun = new JTextField();
		txtComplementoFun.setColumns(10);
		txtComplementoFun.setBounds(713, 374, 162, 20);
		intFrameFuncionario.getContentPane().add(txtComplementoFun);
		
		JButton btnAtualizarFun = new JButton("Atualizar");
		btnAtualizarFun.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Funcionario c  = new Funcionario();
				Endereco end = new Endereco();
				Loja l = new Loja();
				c.setCpf(txtCpfFun.getText());
				c.setNome(txtNomeFun.getText());
				c.setMatricula(txtMatricula.getText());
				c.setNumResidencia(txtNumFun.getText());
				end.setCep(txtCepFun.getText());
				l.setNome(txtFunNomeLoja.getText());
				c.setLoja(l);
				c.setEndereco(end);
				
				if(c.getCpf().length() == 11) {
					FuncionarioSevice.update(c.getMatricula(), c);
					txtBairroFun.setText(""); txtCepFun.setText(""); txtCidadeFun.setText("");
					txtComplementoFun.setText(""); txtNomeLojaFun.setText(""); txtMatriculaFun.setText("");
					txtCpfFun.setText(""); txtLogradouroFun.setText(""); txtNomeFun.setText(""); 
					txtNumFun.setText(""); txtMatricula.setText(""); txtUfFun.setText("");
					txtFunCepLoja.setText(""); txtFunNomeLoja.setText("");
				}
				
			}
		});
		btnAtualizarFun.setForeground(new Color(0, 128, 0));
		btnAtualizarFun.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAtualizarFun.setBackground(new Color(0, 128, 0));
		btnAtualizarFun.setBounds(208, 465, 119, 23);
		intFrameFuncionario.getContentPane().add(btnAtualizarFun);
		
		JButton btnExcluirFun = new JButton("Excluir");
		btnExcluirFun.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String matricula = txtMatricula.getText();
				FuncionarioSevice.deleteMatricula(matricula);
				txtBairroFun.setText(""); txtCepFun.setText(""); txtCidadeFun.setText("");
				txtComplementoFun.setText(""); txtNomeLojaFun.setText(""); txtMatriculaFun.setText("");
				txtCpfFun.setText(""); txtLogradouroFun.setText(""); txtNomeFun.setText(""); 
				txtNumFun.setText(""); txtMatricula.setText(""); txtUfFun.setText("");
				txtFunCepLoja.setText(""); txtFunNomeLoja.setText("");
				while(tableFun.getRowCount()>0) {
					((DefaultTableModel)tableFun.getModel()).removeRow(0);
					}
				JOptionPane.showMessageDialog(null, "Registro excluido com Sucesso!");
			}
		});
		btnExcluirFun.setForeground(Color.RED);
		btnExcluirFun.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnExcluirFun.setBackground(Color.RED);
		btnExcluirFun.setBounds(405, 463, 119, 23);
		intFrameFuncionario.getContentPane().add(btnExcluirFun);
		
		JButton btnLimparFun = new JButton("Limpar Campos");
		btnLimparFun.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtBairroFun.setText(""); txtCepFun.setText(""); txtCidadeFun.setText("");
				txtComplementoFun.setText(""); txtNomeLojaFun.setText(""); txtMatriculaFun.setText("");
				txtCpfFun.setText(""); txtLogradouroFun.setText(""); txtNomeFun.setText(""); 
				txtNumFun.setText(""); txtMatricula.setText(""); txtUfFun.setText("");
				txtFunCepLoja.setText(""); txtFunNomeLoja.setText("");
				while(tableFun.getRowCount()>0) {
					((DefaultTableModel)tableFun.getModel()).removeRow(0);
				}
			}
		});
		btnLimparFun.setBounds(747, 478, 128, 23);
		intFrameFuncionario.getContentPane().add(btnLimparFun);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 47, 878, 188);
		intFrameFuncionario.getContentPane().add(scrollPane_1);
		
		tableFun = new JTable();
		tableFun.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String mat = tableFun.getValueAt(tableFun.getSelectedRow(),0).toString();
				Funcionario c = FuncionarioSevice.buscarMatricula(mat);
				txtBairroFun.setText(c.getEndereco().getBairro()); txtCepFun.setText(c.getEndereco().getCep()); txtCidadeFun.setText(c.getEndereco().getCiade()); txtComplementoFun.setText(c.getEndereco().getComplemento());
				txtCpfFun.setText(c.getCpf()); txtLogradouroFun.setText(c.getEndereco().getLogradouro());
				txtNomeFun.setText(c.getNome()); txtNumFun.setText(c.getNumResidencia()); txtUfFun.setText(c.getEndereco().getUf()); txtMatricula.setText(c.getMatricula());
				txtFunCepLoja.setText(c.getLoja().getEndereco().getCep()); txtFunNomeLoja.setText(c.getLoja().getNome());
			}
		});
		modeloFun = new DefaultTableModel();
		String [] colunaFun =  {"MATRICULA","NOME","CPF","CEP","LOGRADOURO","Nº"};
		modeloFun.setColumnIdentifiers(colunaFun);
		tableFun.setModel(modeloFun);
		scrollPane_1.setViewportView(tableFun);
		
		txtFunNomeLoja = new JTextField();
		txtFunNomeLoja.setColumns(10);
		txtFunNomeLoja.setBounds(22, 422, 204, 20);
		intFrameFuncionario.getContentPane().add(txtFunNomeLoja);
		
		JLabel lblNewLabel_1_1_2_1_1 = new JLabel("Loja:");
		lblNewLabel_1_1_2_1_1.setBounds(22, 400, 46, 14);
		intFrameFuncionario.getContentPane().add(lblNewLabel_1_1_2_1_1);
		
		JLabel lblNewLabel_2_3_1_1 = new JLabel("CEP Loja:");
		lblNewLabel_2_3_1_1.setBounds(281, 400, 46, 14);
		intFrameFuncionario.getContentPane().add(lblNewLabel_2_3_1_1);
		
		txtFunCepLoja = new JTextField();
		txtFunCepLoja.setColumns(10);
		txtFunCepLoja.setBounds(279, 422, 181, 20);
		intFrameFuncionario.getContentPane().add(txtFunCepLoja);
		
		intFrameCliente.setFrameIcon(new ImageIcon("C:\\Users\\Davi\\eclipse-workspace\\gerenciamantoveiculo\\src\\main\\resources\\imagens\\icon.png"));
		intFrameCliente.setClosable(true);
		intFrameCliente.setBounds(10, 21, 914, 542);
		contentPane.add(intFrameCliente);
		intFrameCliente.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Buscar CPF:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(10, 11, 91, 14);
		intFrameCliente.getContentPane().add(lblNewLabel);
		
		txtCpfBuscar = new JTextField();
		txtCpfBuscar.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				while(tableCliente.getRowCount()>0) {
				((DefaultTableModel)tableCliente.getModel()).removeRow(0);
				}
				if(txtCpfBuscar.getText().length() == 11) {
				Cliente cliente =  ClienteService.buscarCpf(txtCpfBuscar.getText());
					if(!cliente.getCpf().isEmpty()) {
						String [] linha = {cliente.getCpf(), cliente.getNome(), cliente.getTelefone(),cliente.getEndereco().getCep(),cliente.getEndereco().getLogradouro(),cliente.getNumResidencia()};
						modeloCliente.addRow(linha);
						txtCpfBuscar.setText("");
					}else {
						JOptionPane.showMessageDialog(null, "Cliente não Cadastrado!");
					}
				}
			}
		});
		txtCpfBuscar.setBounds(87, 9, 210, 20);
		intFrameCliente.getContentPane().add(txtCpfBuscar);
		txtCpfBuscar.setColumns(10);
		
		JLabel lblBuscarNome = new JLabel("Buscar Nome:");
		lblBuscarNome.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblBuscarNome.setBounds(320, 11, 91, 14);
		intFrameCliente.getContentPane().add(lblBuscarNome);
		
		txtBuscarNome = new JTextField();
		txtBuscarNome.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(txtBuscarNome.getText().length() > 3) {
					while(tableCliente.getRowCount()>0) {
					((DefaultTableModel)tableCliente.getModel()).removeRow(0);
					}
					List<Cliente> client =  ClienteService.buscarListaCliente(txtBuscarNome.getText());
						if(client.size() > 0) {
							for(Cliente cliente : client) {
							String [] linha = {cliente.getCpf(), cliente.getNome(), cliente.getTelefone(),cliente.getEndereco().getCep(),cliente.getEndereco().getLogradouro(),cliente.getNumResidencia()};
							modeloCliente.addRow(linha);
							}
							txtBuscarNome.setText("");
						}else {
							JOptionPane.showMessageDialog(null, "Cliente não Cadastrado!");
						}
					
				}
			}
		});
		txtBuscarNome.setColumns(10);
		txtBuscarNome.setBounds(416, 9, 472, 20);
		intFrameCliente.getContentPane().add(txtBuscarNome);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 36, 878, 165);
		intFrameCliente.getContentPane().add(scrollPane);
		
		tableCliente = new JTable();
		tableCliente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			String cpf = tableCliente.getValueAt(tableCliente.getSelectedRow(),0).toString();
			Cliente c = ClienteService.buscarCpf(cpf);
			txtBairroCliente.setText(c.getEndereco().getBairro()); txtCepCliente.setText(c.getEndereco().getCep()); txtCidadeCliente.setText(c.getEndereco().getCiade()); txtComplementoCliente.setText(c.getEndereco().getComplemento());
			txtCpfCliente.setText(c.getCpf()); txtLogradouro.setText(c.getEndereco().getLogradouro());
			txtNomeCliente.setText(c.getNome()); txtNumCliente.setText(c.getNumResidencia()); txtUfCliente.setText(c.getEndereco().getUf()); txtTelefoneCliente.setText(c.getTelefone());
			}
		});
		tableCliente.setModel(modeloCliente);
		
		scrollPane.setViewportView(tableCliente);
		
		JLabel lblNewLabel_1 = new JLabel("Nome:");
		lblNewLabel_1.setBounds(22, 235, 46, 14);
		intFrameCliente.getContentPane().add(lblNewLabel_1);
		
		txtNomeCliente = new JTextField();
		txtNomeCliente.setBounds(22, 257, 424, 20);
		intFrameCliente.getContentPane().add(txtNomeCliente);
		txtNomeCliente.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Telefone:");
		lblNewLabel_1_1.setBounds(22, 288, 46, 14);
		intFrameCliente.getContentPane().add(lblNewLabel_1_1);
		
		txtTelefoneCliente = new JTextField();
		txtTelefoneCliente.setColumns(10);
		txtTelefoneCliente.setBounds(22, 310, 204, 20);
		intFrameCliente.getContentPane().add(txtTelefoneCliente);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("CPF:");
		lblNewLabel_1_1_1.setBounds(487, 235, 46, 14);
		intFrameCliente.getContentPane().add(lblNewLabel_1_1_1);
		
		txtCpfCliente = new JTextField();
		txtCpfCliente.setColumns(10);
		txtCpfCliente.setBounds(487, 257, 234, 20);
		intFrameCliente.getContentPane().add(txtCpfCliente);
		
		JLabel lblNewLabel_2 = new JLabel("CEP:");
		lblNewLabel_2.setBounds(281, 288, 46, 14);
		intFrameCliente.getContentPane().add(lblNewLabel_2);
		
		txtCepCliente = new JTextField();
		txtCepCliente.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(txtCepCliente.getText().length() == 8) {
				Endereco end = EnderecoService.buscarCep(txtCepCliente.getText());
					if(!end.getCiade().isEmpty()) {
						txtBairroCliente.setText(end.getBairro());
						txtLogradouro.setText(end.getLogradouro());
						txtCidadeCliente.setText(end.getCiade());
						txtComplementoCliente.setText(end.getComplemento());
						txtUfCliente.setText(end.getUf());
					}else {
						JOptionPane.showMessageDialog(null, "CEP inválido!");
					}
				}else {
					JOptionPane.showMessageDialog(null, "CEP inválido!");
				}
			}
		});
		txtCepCliente.setColumns(10);
		txtCepCliente.setBounds(279, 310, 204, 20);
		intFrameCliente.getContentPane().add(txtCepCliente);
		
		txtLogradouro = new JTextField();
		txtLogradouro.setColumns(10);
		txtLogradouro.setBounds(522, 310, 353, 20);
		intFrameCliente.getContentPane().add(txtLogradouro);
		
		JLabel lblNewLabel_2_1 = new JLabel("Logradouro:");
		lblNewLabel_2_1.setBounds(524, 288, 197, 14);
		intFrameCliente.getContentPane().add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("Nº");
		lblNewLabel_2_2.setBounds(747, 235, 128, 14);
		intFrameCliente.getContentPane().add(lblNewLabel_2_2);
		
		txtNumCliente = new JTextField();
		txtNumCliente.setColumns(10);
		txtNumCliente.setBounds(745, 257, 130, 20);
		intFrameCliente.getContentPane().add(txtNumCliente);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Bairro:");
		lblNewLabel_1_1_2.setBounds(22, 341, 46, 14);
		intFrameCliente.getContentPane().add(lblNewLabel_1_1_2);
		
		JLabel lblNewLabel_2_3 = new JLabel("Cidade:");
		lblNewLabel_2_3.setBounds(281, 341, 46, 14);
		intFrameCliente.getContentPane().add(lblNewLabel_2_3);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Estado:");
		lblNewLabel_2_1_1.setBounds(489, 341, 183, 14);
		intFrameCliente.getContentPane().add(lblNewLabel_2_1_1);
		
		txtUfCliente = new JTextField();
		txtUfCliente.setColumns(10);
		txtUfCliente.setBounds(487, 363, 185, 20);
		intFrameCliente.getContentPane().add(txtUfCliente);
		
		txtCidadeCliente = new JTextField();
		txtCidadeCliente.setColumns(10);
		txtCidadeCliente.setBounds(279, 363, 181, 20);
		intFrameCliente.getContentPane().add(txtCidadeCliente);
		
		txtBairroCliente = new JTextField();
		txtBairroCliente.setColumns(10);
		txtBairroCliente.setBounds(22, 363, 204, 20);
		intFrameCliente.getContentPane().add(txtBairroCliente);
		
		JButton btnCadastraCliente = new JButton("Cadastrar");
		btnCadastraCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cliente c  = new Cliente();
				Endereco end = new Endereco();
				c.setCpf(txtCpfCliente.getText());
				c.setNome(txtNomeCliente.getText());
				c.setTelefone(txtTelefoneCliente.getText());
				c.setNumResidencia(txtNumCliente.getText());
				end.setCep(txtCepCliente.getText());
				c.setEndereco(end);
				
				if(c.getCpf().length() == 11) {
					ClienteService.save(c);
					txtBairroCliente.setText(""); txtCepCliente.setText(""); txtCidadeCliente.setText("");
					txtComplementoCliente.setText(""); txtCpfBuscar.setText(""); txtBuscarNome.setText("");
					txtCpfCliente.setText(""); txtLogradouro.setText(""); txtNomeCliente.setText(""); 
					txtNumCliente.setText(""); txtTelefoneCliente.setText(""); txtUfCliente.setText("");
				}
			}
		});
		btnCadastraCliente.setForeground(new Color(0, 128, 255));
		btnCadastraCliente.setBackground(new Color(0, 128, 255));
		btnCadastraCliente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCadastraCliente.setBounds(22, 428, 119, 23);
		intFrameCliente.getContentPane().add(btnCadastraCliente);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("Complemento:");
		lblNewLabel_2_1_1_1.setBounds(715, 341, 160, 14);
		intFrameCliente.getContentPane().add(lblNewLabel_2_1_1_1);
		
		txtComplementoCliente = new JTextField();
		txtComplementoCliente.setColumns(10);
		txtComplementoCliente.setBounds(713, 363, 162, 20);
		intFrameCliente.getContentPane().add(txtComplementoCliente);
		
		JButton btnAtualizarCliente = new JButton("Atualizar");
		btnAtualizarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Cliente c  = new Cliente();
				Endereco end = new Endereco();
				c.setCpf(txtCpfCliente.getText());
				c.setNome(txtNomeCliente.getText());
				c.setTelefone(txtTelefoneCliente.getText());
				c.setNumResidencia(txtNumCliente.getText());
				end.setCep(txtCepCliente.getText());
				c.setEndereco(end);
				ClienteService.update(c.getCpf(), c);
				txtBairroCliente.setText(""); txtCepCliente.setText(""); txtCidadeCliente.setText(""); txtComplementoCliente.setText("");
				txtCpfBuscar.setText(""); txtBuscarNome.setText(""); txtCpfCliente.setText(""); txtLogradouro.setText("");
				txtNomeCliente.setText(""); txtNumCliente.setText(""); txtUfCliente.setText(""); txtTelefoneCliente.setText("");
			
			}
			
		});
		btnAtualizarCliente.setForeground(new Color(0, 128, 0));
		btnAtualizarCliente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAtualizarCliente.setBackground(new Color(0, 128, 0));
		btnAtualizarCliente.setBounds(208, 430, 119, 23);
		intFrameCliente.getContentPane().add(btnAtualizarCliente);
		
		JButton btnExcluirCliente = new JButton("Excluir");
		btnExcluirCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cpf = txtCpfCliente.getText();
				ClienteService.deleteCpf(cpf);
				txtBairroCliente.setText(""); txtCepCliente.setText(""); txtCidadeCliente.setText(""); txtComplementoCliente.setText("");
				txtCpfBuscar.setText(""); txtBuscarNome.setText(""); txtCpfCliente.setText(""); txtLogradouro.setText("");
				txtNomeCliente.setText(""); txtNumCliente.setText(""); txtUfCliente.setText(""); txtTelefoneCliente.setText("");
				while(tableCliente.getRowCount()>0) {
					((DefaultTableModel)tableCliente.getModel()).removeRow(0);
					}
				JOptionPane.showMessageDialog(null, "Registro excluido com Sucesso!");
			}
		});
		btnExcluirCliente.setForeground(new Color(255, 0, 0));
		btnExcluirCliente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnExcluirCliente.setBackground(new Color(255, 0, 0));
		btnExcluirCliente.setBounds(405, 430, 119, 23);
		intFrameCliente.getContentPane().add(btnExcluirCliente);
		
		JButton btnNewButton = new JButton("Limpar Campos");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtBairroCliente.setText(""); txtCepCliente.setText(""); txtCidadeCliente.setText(""); txtComplementoCliente.setText("");
				txtCpfBuscar.setText(""); txtBuscarNome.setText(""); txtCpfCliente.setText(""); txtLogradouro.setText("");
				txtNomeCliente.setText(""); txtNumCliente.setText(""); txtUfCliente.setText(""); txtTelefoneCliente.setText("");
			}
			
		});
		btnNewButton.setBounds(747, 478, 128, 23);
		intFrameCliente.getContentPane().add(btnNewButton);
		intFrameCliente.setVisible(false);
		intFrameFuncionario.setVisible(false);
	}
}
