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
import br.com.concessionaria.model.Veiculo;
import br.com.concessionaria.service.ClienteService;
import br.com.concessionaria.service.EnderecoService;
import br.com.concessionaria.service.FuncionarioSevice;
import br.com.concessionaria.service.LojaService;
import br.com.concessionaria.service.VeiculoService;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import br.com.concessionaria.util.TipoVeiculos;
import br.com.concessionaria.util.VeiculoVendido;

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
	private JTextField txtBuscarPlaca;
	private JTextField txtBuscaVeiculoLoja;
	private JTextField txtPlacaVeiculo;
	private JTextField txtAnoVeiculo;
	private JTextField txtMarcaVeiculo;
	private JTextField txtValorVeiculo;
	private JTextField txtModeloVeiculo;
	private JComboBox boxTipoVeiculo;
	private JTextField txtLojaVeiculo;
	private JTextField txtLojaCepVeiculo;
	private JTextField txtBuscarVeiculoModelo;
	private JTable tableVeiculo;
	private DefaultTableModel modeloVeiculo;
	private DefaultTableModel modeloLoja;
	private JTextField txtNomeLoja;
	private JTextField txtLojaCep;
	private JTextField txtLojaRua;
	private JTextField txtLojaNum;
	private JTextField txtLojaUf;
	private JTextField txtLojaCidade;
	private JTextField txtLojaBairro;
	private JTextField txtLojaCom;
	private JTable tableLoja;

	public ViewCadastro() {
		setTitle("Concessionaria -  Vem que Tem!");
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				"C:\\Users\\Davi\\eclipse-workspace\\gerenciamantoveiculo\\src\\main\\resources\\imagens\\icon.png"));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 950, 609);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		JInternalFrame intFrameCliente = new JInternalFrame("Cadastro de Cliente");
		JInternalFrame intFrameFuncionario = new JInternalFrame("Cadastro de Funcionario");
		JInternalFrame intFrameVeiculo = new JInternalFrame("Cadastro de Veiculo");
		JInternalFrame intFrameLoja = new JInternalFrame("Cadastro de Loja");
		
		boxTipoVeiculo = new JComboBox();

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
		manuVeiculo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				intFrameVeiculo.setVisible(true);
			}
		});
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
		menuLoja.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				intFrameLoja.setVisible(true);
				popularTableLoja();
			}
		});
		menuBar.add(menuLoja);
		
		intFrameLoja.setFrameIcon(new ImageIcon(
				"C:\\Users\\Davi\\eclipse-workspace\\gerenciamantoveiculo\\src\\main\\resources\\imagens\\icon.png"));
		intFrameLoja.setClosable(true);
		intFrameLoja.setBounds(10, 21, 914, 542);
		contentPane.add(intFrameLoja);
		intFrameLoja.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_1_3 = new JLabel("Nome:");
		lblNewLabel_1_3.setBounds(22, 235, 46, 14);
		intFrameLoja.getContentPane().add(lblNewLabel_1_3);
		
		txtNomeLoja = new JTextField();
		txtNomeLoja.setColumns(10);
		txtNomeLoja.setBounds(22, 257, 617, 20);
		intFrameLoja.getContentPane().add(txtNomeLoja);
		
		JLabel lblNewLabel_2_5 = new JLabel("CEP:");
		lblNewLabel_2_5.setBounds(651, 235, 46, 14);
		intFrameLoja.getContentPane().add(lblNewLabel_2_5);
		
		txtLojaCep = new JTextField();
		txtLojaCep.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(txtLojaCep.getText().length()==8) {
					Endereco end = EnderecoService.buscarCep(txtLojaCep.getText());
						if(end!=null) {
					txtLojaBairro.setText(end.getBairro());
					txtLojaCidade.setText(end.getCiade());
					txtLojaCom.setText(end.getComplemento());
					txtLojaRua.setText(end.getLogradouro());
					txtLojaUf.setText(end.getUf());
						}else{
							JOptionPane.showMessageDialog(null, "CEP inválido!");
						}
				}
			}
		});
		txtLojaCep.setColumns(10);
		txtLojaCep.setBounds(649, 257, 204, 20);
		intFrameLoja.getContentPane().add(txtLojaCep);
		
		txtLojaRua = new JTextField();
		txtLojaRua.setColumns(10);
		txtLojaRua.setBounds(22, 310, 353, 20);
		intFrameLoja.getContentPane().add(txtLojaRua);
		
		JLabel lblNewLabel_2_1_3 = new JLabel("Logradouro:");
		lblNewLabel_2_1_3.setBounds(24, 288, 197, 14);
		intFrameLoja.getContentPane().add(lblNewLabel_2_1_3);
		
		JLabel lblNewLabel_1_1_2_2 = new JLabel("Bairro:");
		lblNewLabel_1_1_2_2.setBounds(22, 341, 46, 14);
		intFrameLoja.getContentPane().add(lblNewLabel_1_1_2_2);
		
		JLabel lblNewLabel_2_3_2 = new JLabel("Cidade:");
		lblNewLabel_2_3_2.setBounds(371, 341, 274, 14);
		intFrameLoja.getContentPane().add(lblNewLabel_2_3_2);
		
		JLabel lblNewLabel_2_1_1_3 = new JLabel("Estado:");
		lblNewLabel_2_1_1_3.setBounds(670, 341, 183, 14);
		intFrameLoja.getContentPane().add(lblNewLabel_2_1_1_3);
		
		txtLojaUf = new JTextField();
		txtLojaUf.setColumns(10);
		txtLojaUf.setBounds(668, 363, 185, 20);
		intFrameLoja.getContentPane().add(txtLojaUf);
		
		txtLojaCidade = new JTextField();
		txtLojaCidade.setColumns(10);
		txtLojaCidade.setBounds(369, 363, 276, 20);
		intFrameLoja.getContentPane().add(txtLojaCidade);
		
		txtLojaBairro = new JTextField();
		txtLojaBairro.setColumns(10);
		txtLojaBairro.setBounds(22, 363, 325, 20);
		intFrameLoja.getContentPane().add(txtLojaBairro);
		
		JButton bntCadastroLoja = new JButton("Cadastrar");
		bntCadastroLoja.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(!txtNomeLoja.getText().isEmpty()) {
					Loja l = new Loja();
					Endereco end = new Endereco();
					l.setNome(txtNomeLoja.getText());
					l.setNumEndereco(txtLojaNum.getText());
					end.setCep(txtLojaCep.getText());
					l.setEndereco(end);
					LojaService.save(l);
					JOptionPane.showMessageDialog(null, "Registros realizado com sucesso!");
					limparCamposLoja();
					popularTableLoja();
				}
			}
		});
		bntCadastroLoja.setForeground(new Color(0, 128, 255));
		bntCadastroLoja.setFont(new Font("Tahoma", Font.PLAIN, 14));
		bntCadastroLoja.setBackground(new Color(0, 128, 255));
		bntCadastroLoja.setBounds(22, 428, 119, 23);
		intFrameLoja.getContentPane().add(bntCadastroLoja);
		
		JLabel lblNewLabel_2_1_1_1_2 = new JLabel("Complemento:");
		lblNewLabel_2_1_1_1_2.setBounds(547, 288, 306, 14);
		intFrameLoja.getContentPane().add(lblNewLabel_2_1_1_1_2);
		
		txtLojaCom = new JTextField();
		txtLojaCom.setColumns(10);
		txtLojaCom.setBounds(545, 310, 308, 20);
		intFrameLoja.getContentPane().add(txtLojaCom);
		
		JButton bntAtualizarLoja = new JButton("Atualizar");
		bntAtualizarLoja.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Loja l = new Loja();
				Endereco end = new Endereco();
				l.setNome(txtNomeLoja.getText());
				l.setNumEndereco(txtLojaNum.getText());
				end.setCep(txtLojaCep.getText());
				l.setEndereco(end);
				LojaService.update(l.getNome(), l);
				JOptionPane.showMessageDialog(null, "Registros realizado com sucesso!");
				limparCamposLoja();
				popularTableLoja();
			}
		});
		bntAtualizarLoja.setForeground(new Color(0, 128, 0));
		bntAtualizarLoja.setFont(new Font("Tahoma", Font.PLAIN, 14));
		bntAtualizarLoja.setBackground(new Color(0, 128, 0));
		bntAtualizarLoja.setBounds(208, 430, 119, 23);
		intFrameLoja.getContentPane().add(bntAtualizarLoja);
		
		JButton bntExcluirLoja = new JButton("Excluir");
		bntExcluirLoja.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(!txtNomeLoja.getText().isEmpty()) {
					LojaService.deleteNome(txtNomeLoja.getText());
					limparCamposLoja();
					JOptionPane.showMessageDialog(null, "Registro excluido com sucesso!");
					popularTableLoja();
				}
			}
		});
		bntExcluirLoja.setForeground(Color.RED);
		bntExcluirLoja.setFont(new Font("Tahoma", Font.PLAIN, 14));
		bntExcluirLoja.setBackground(Color.RED);
		bntExcluirLoja.setBounds(405, 430, 119, 23);
		intFrameLoja.getContentPane().add(bntExcluirLoja);
		
		JButton bntLimpaLoja = new JButton("Limpar Campos");
		bntLimpaLoja.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				limparCamposLoja();
			}
		});
		bntLimpaLoja.setBounds(747, 478, 128, 23);
		intFrameLoja.getContentPane().add(bntLimpaLoja);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(22, 42, 853, 182);
		intFrameLoja.getContentPane().add(scrollPane_3);
		
		tableLoja = new JTable();
		String [] colunaLoja = {"Nome","Logradouro","Nª","CEP"};
		modeloLoja = new DefaultTableModel();
		modeloLoja.setColumnIdentifiers(colunaLoja);
		tableLoja.setModel(modeloLoja);
		tableLoja.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String nomeLoja = tableLoja.getValueAt(tableLoja.getSelectedRow(), 0).toString();
				Loja l = LojaService.buscarNome(nomeLoja);
				txtLojaBairro.setText(l.getEndereco().getBairro());
				txtLojaCep.setText(l.getEndereco().getCep());
				txtLojaCidade.setText(l.getEndereco().getCiade());
				txtLojaCom.setText(l.getEndereco().getComplemento());
				txtLojaNum.setText(l.getNumEndereco());
				txtLojaRua.setText(l.getEndereco().getLogradouro());
				txtNomeLoja.setText(l.getNome());
				txtLojaUf.setText(l.getEndereco().getUf());
				txtNomeLoja.setEditable(false);
				
			}
		});
		scrollPane_3.setViewportView(tableLoja);
		
		JLabel lblNewLabel_4 = new JLabel("Informação das Lojas:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_4.setBounds(22, 11, 279, 14);
		intFrameLoja.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_2_2_2 = new JLabel("Nº");
		lblNewLabel_2_2_2.setBounds(396, 288, 128, 14);
		intFrameLoja.getContentPane().add(lblNewLabel_2_2_2);
		
		txtLojaNum = new JTextField();
		txtLojaNum.setBounds(394, 310, 130, 20);
		intFrameLoja.getContentPane().add(txtLojaNum);
		txtLojaNum.setColumns(10);
		
		intFrameVeiculo.setFrameIcon(new ImageIcon(
				"C:\\Users\\Davi\\eclipse-workspace\\gerenciamantoveiculo\\src\\main\\resources\\imagens\\icon.png"));
		intFrameVeiculo.setClosable(true);
		intFrameVeiculo.setBounds(10, 21, 914, 542);
		contentPane.add(intFrameVeiculo);
		intFrameVeiculo.getContentPane().setLayout(null);
		
		modeloCliente = new DefaultTableModel();
		String[] colunaCliente = { "CPF", "NOME", "TELEFONE", "CEP", "LOGRADOURO", "Nº" };
		modeloCliente.setColumnIdentifiers(colunaCliente);

		intFrameVeiculo.setFrameIcon(new ImageIcon(
				"C:\\Users\\Davi\\eclipse-workspace\\gerenciamantoveiculo\\src\\main\\resources\\imagens\\icon.png"));
		intFrameVeiculo.setClosable(true);
		intFrameVeiculo.setBounds(10, 21, 914, 542);
		contentPane.add(intFrameVeiculo);
		intFrameVeiculo.getContentPane().setLayout(null);

		JLabel lblBuscarPlaca = new JLabel("Buscar Placa:");
		lblBuscarPlaca.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblBuscarPlaca.setBounds(10, 13, 79, 14);
		intFrameVeiculo.getContentPane().add(lblBuscarPlaca);

		txtBuscarPlaca = new JTextField();
		txtBuscarPlaca.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {

				if (!txtBuscarPlaca.getText().isEmpty()) {
					limparTabelaVeico();
					String placa = txtBuscarPlaca.getText();
					Veiculo v = VeiculoService.buscarPlaca(placa);
					if (v.getPlaca().length() == 7) {
						String[] linha = { v.getPlaca(), v.getMarca(), v.getModelo(), "" + v.getAno(),
								"" + v.getValor(), v.getLoja().getNome() };
						modeloVeiculo.addRow(linha);
						txtBuscarPlaca.setText("");

					} else {
						JOptionPane.showMessageDialog(null, "Veiculo não localizado!");
					}
				}
			}
		});
		txtBuscarPlaca.setColumns(10);
		txtBuscarPlaca.setBounds(92, 11, 173, 20);
		intFrameVeiculo.getContentPane().add(txtBuscarPlaca);

		JLabel lblBuscarVeiculoLoja = new JLabel("Buscar Veiculo Loja:");
		lblBuscarVeiculoLoja.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblBuscarVeiculoLoja.setBounds(271, 13, 126, 14);
		intFrameVeiculo.getContentPane().add(lblBuscarVeiculoLoja);

		txtBuscaVeiculoLoja = new JTextField();
		txtBuscaVeiculoLoja.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {

				if (!txtBuscaVeiculoLoja.getText().isEmpty()) {
					limparTabelaVeico();
					String nome = txtBuscaVeiculoLoja.getText();
					List<Veiculo> listVeiculo = VeiculoService.buscarTodos(nome);
					if (listVeiculo.size() > 0) {
						for (Veiculo v : listVeiculo) {
							String[] linha = { v.getPlaca(), v.getMarca(), v.getModelo(), "" + v.getAno(),
									"" + v.getValor(), v.getLoja().getNome() };
							modeloVeiculo.addRow(linha);
						}

						txtBuscaVeiculoLoja.setText("");
					} else {
						JOptionPane.showMessageDialog(null, "Veiculo não localizado!");
					}
				}
			}
		});
		txtBuscaVeiculoLoja.setColumns(10);
		txtBuscaVeiculoLoja.setBounds(397, 11, 173, 20);
		intFrameVeiculo.getContentPane().add(txtBuscaVeiculoLoja);

		JLabel lblNewLabel_1_2_1 = new JLabel("Placa:");
		lblNewLabel_1_2_1.setBounds(24, 237, 46, 14);
		intFrameVeiculo.getContentPane().add(lblNewLabel_1_2_1);

		txtPlacaVeiculo = new JTextField();
		txtPlacaVeiculo.setColumns(10);
		txtPlacaVeiculo.setBounds(22, 259, 212, 20);
		intFrameVeiculo.getContentPane().add(txtPlacaVeiculo);

		JLabel lblAno = new JLabel("Ano:");
		lblAno.setBounds(22, 290, 46, 14);
		intFrameVeiculo.getContentPane().add(lblAno);

		txtAnoVeiculo = new JTextField();
		txtAnoVeiculo.setColumns(10);
		txtAnoVeiculo.setBounds(22, 312, 204, 20);
		intFrameVeiculo.getContentPane().add(txtAnoVeiculo);

		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Marca:");
		lblNewLabel_1_1_1_1_1.setBounds(246, 237, 254, 14);
		intFrameVeiculo.getContentPane().add(lblNewLabel_1_1_1_1_1);

		txtMarcaVeiculo = new JTextField();
		txtMarcaVeiculo.setColumns(10);
		txtMarcaVeiculo.setBounds(244, 259, 270, 20);
		intFrameVeiculo.getContentPane().add(txtMarcaVeiculo);

		JLabel lblNewLabel_2_4_1 = new JLabel("Valor:");
		lblNewLabel_2_4_1.setBounds(246, 290, 46, 14);
		intFrameVeiculo.getContentPane().add(lblNewLabel_2_4_1);

		txtValorVeiculo = new JTextField();
		txtValorVeiculo.setColumns(10);
		txtValorVeiculo.setBounds(244, 312, 270, 20);
		intFrameVeiculo.getContentPane().add(txtValorVeiculo);

		JLabel lblNewLabel_2_2_1_1 = new JLabel("Modelo:");
		lblNewLabel_2_2_1_1.setBounds(545, 237, 330, 14);
		intFrameVeiculo.getContentPane().add(lblNewLabel_2_2_1_1);

		txtModeloVeiculo = new JTextField();
		txtModeloVeiculo.setColumns(10);
		txtModeloVeiculo.setBounds(543, 259, 332, 20);
		intFrameVeiculo.getContentPane().add(txtModeloVeiculo);

		JButton btnCadastraFun_1 = new JButton("Cadastrar");
		btnCadastraFun_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(txtPlacaVeiculo.getText().length() ==7) {
					Veiculo v =  new Veiculo();
					v.setAno(Integer.parseInt(txtAnoVeiculo.getText()));
					Loja l = LojaService.buscarNome(txtLojaVeiculo.getText());
					v.setLoja(l);
					v.setMarca(txtMarcaVeiculo.getText());
					v.setModelo(txtModeloVeiculo.getText());
					v.setPlaca(txtPlacaVeiculo.getText());
					v.setValor(Double.parseDouble(txtValorVeiculo.getText()));
					v.setTipoVeiculo((TipoVeiculos) boxTipoVeiculo.getSelectedItem());
					v.setVendido(VeiculoVendido.Disponivel);
					if(v.getValor() > 0) {
						VeiculoService.save(v);
						JOptionPane.showMessageDialog(null, "Veiculo Cadastro com sucesso!");
						limparCampoVeiculo();
						limparTabelaVeico();
					}
				}
			}
		});
		btnCadastraFun_1.setForeground(new Color(0, 128, 255));
		btnCadastraFun_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCadastraFun_1.setBackground(new Color(0, 128, 255));
		btnCadastraFun_1.setBounds(22, 454, 119, 23);
		intFrameVeiculo.getContentPane().add(btnCadastraFun_1);

		JButton btnAtualizarFun_1 = new JButton("Atualizar");
		btnAtualizarFun_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(txtPlacaVeiculo.getText().length() ==7) {
					Veiculo v =  new Veiculo();
					v.setAno(Integer.parseInt(txtAnoVeiculo.getText()));
					Loja l = LojaService.buscarNome(txtLojaVeiculo.getText());
					v.setLoja(l);
					v.setMarca(txtMarcaVeiculo.getText());
					v.setModelo(txtModeloVeiculo.getText());
					v.setPlaca(txtPlacaVeiculo.getText());
					v.setValor(Double.parseDouble(txtValorVeiculo.getText()));
					v.setTipoVeiculo((TipoVeiculos) boxTipoVeiculo.getSelectedItem());
					v.setVendido(VeiculoVendido.Disponivel);
					if(v.getValor() > 0) {
						VeiculoService.update(v.getPlaca(), v);
						JOptionPane.showMessageDialog(null, "Veiculo Atuaizado com sucesso!");
						limparCampoVeiculo();
						limparTabelaVeico();
					}
				}
				
			}
		});
		btnAtualizarFun_1.setForeground(new Color(0, 128, 0));
		btnAtualizarFun_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAtualizarFun_1.setBackground(new Color(0, 128, 0));
		btnAtualizarFun_1.setBounds(208, 456, 119, 23);
		intFrameVeiculo.getContentPane().add(btnAtualizarFun_1);

		JButton btnExcluirFun_1 = new JButton("Excluir");
		btnExcluirFun_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(!txtPlacaVeiculo.getText().isEmpty()) {
					VeiculoService.deletePlaca(txtPlacaVeiculo.getText());
					limparCampoVeiculo();
					JOptionPane.showMessageDialog(null, "Registro excluido!");
				}
			}
		});
		btnExcluirFun_1.setForeground(Color.RED);
		btnExcluirFun_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnExcluirFun_1.setBackground(Color.RED);
		btnExcluirFun_1.setBounds(405, 454, 119, 23);
		intFrameVeiculo.getContentPane().add(btnExcluirFun_1);

		JButton btnLimparFun_1 = new JButton("Limpar Campos");
		btnLimparFun_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 limparCampoVeiculo();
				 limparTabelaVeico();
			
			}
		});
		btnLimparFun_1.setBounds(747, 469, 128, 23);
		intFrameVeiculo.getContentPane().add(btnLimparFun_1);

		txtLojaVeiculo = new JTextField();
		txtLojaVeiculo.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(!txtLojaVeiculo.getText().isEmpty()) {
				Loja l = LojaService.buscarNome(txtLojaVeiculo.getText());
				txtLojaCepVeiculo.setText(l.getEndereco().getCep());
				}
			}
		});
		txtLojaVeiculo.setColumns(10);
		txtLojaVeiculo.setBounds(24, 365, 196, 20);
		intFrameVeiculo.getContentPane().add(txtLojaVeiculo);

		JLabel lblNewLabel_1_1_2_1_1_1 = new JLabel("Loja:");
		lblNewLabel_1_1_2_1_1_1.setBounds(24, 343, 46, 14);
		intFrameVeiculo.getContentPane().add(lblNewLabel_1_1_2_1_1_1);

		JLabel lblNewLabel_2_3_1_1_1 = new JLabel("CEP Loja:");
		lblNewLabel_2_3_1_1_1.setBounds(246, 343, 46, 14);
		intFrameVeiculo.getContentPane().add(lblNewLabel_2_3_1_1_1);

		txtLojaCepVeiculo = new JTextField();
		txtLojaCepVeiculo.setColumns(10);
		txtLojaCepVeiculo.setBounds(246, 365, 268, 20);
		intFrameVeiculo.getContentPane().add(txtLojaCepVeiculo);

		JLabel lblBuscarPorModelo = new JLabel("Buscar por Modelo:");
		lblBuscarPorModelo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblBuscarPorModelo.setBounds(580, 13, 126, 14);
		intFrameVeiculo.getContentPane().add(lblBuscarPorModelo);

		txtBuscarVeiculoModelo = new JTextField();
		txtBuscarVeiculoModelo.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {

				if (!txtBuscarVeiculoModelo.getText().isEmpty()) {
					limparTabelaVeico();
					String nome = txtBuscarVeiculoModelo.getText();
					List<Veiculo> listVeiculo = VeiculoService.buscarTodosPorModelo(nome);
					if (listVeiculo.size() > 0) {
						for (Veiculo v : listVeiculo) {
							String[] linha = { v.getPlaca(), v.getMarca(), v.getModelo(), "" + v.getAno(),
									"" + v.getValor(), v.getLoja().getNome() };
							modeloVeiculo.addRow(linha);
						}
						txtBuscarVeiculoModelo.setText("");
					} else {
						JOptionPane.showMessageDialog(null, "Veiculo não localizado!");
					}
				}
			}
		});
		txtBuscarVeiculoModelo.setColumns(10);
		txtBuscarVeiculoModelo.setBounds(706, 11, 173, 20);
		intFrameVeiculo.getContentPane().add(txtBuscarVeiculoModelo);

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 38, 869, 192);
		intFrameVeiculo.getContentPane().add(scrollPane_2);

		
		boxTipoVeiculo.setModel(new DefaultComboBoxModel(TipoVeiculos.values()));
		boxTipoVeiculo.setSelectedIndex(-1);
		boxTipoVeiculo.setBounds(545, 311, 330, 22);
		intFrameVeiculo.getContentPane().add(boxTipoVeiculo);

		tableVeiculo = new JTable();
		tableVeiculo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String placa = tableVeiculo.getValueAt(tableVeiculo.getSelectedRow(), 0).toString();
				Veiculo v = VeiculoService.buscarPlaca(placa);
				txtAnoVeiculo.setText("" + v.getAno());
				txtValorVeiculo.setText("" + v.getValor());
				txtLojaCepVeiculo.setText(v.getLoja().getEndereco().getCep());
				txtLojaVeiculo.setText(v.getLoja().getNome());
				txtMarcaVeiculo.setText(v.getMarca());
				txtModeloVeiculo.setText(v.getModelo());
				txtPlacaVeiculo.setText(v.getPlaca());
				boxTipoVeiculo.setSelectedIndex(v.getTipoVeiculo().getCod());
				txtPlacaVeiculo.setEditable(false);
			}
		});
		String[] colunaVeiculo = { "Placa", "Marca", "Modelo", "Ano", "Valor", "Loja" };
		modeloVeiculo = new DefaultTableModel();
		modeloVeiculo.setColumnIdentifiers(colunaVeiculo);
		tableVeiculo.setModel(modeloVeiculo);
		scrollPane_2.setViewportView(tableVeiculo);

		JLabel lblNewLabel_3 = new JLabel("Tipo:");
		lblNewLabel_3.setBounds(545, 290, 46, 14);
		intFrameVeiculo.getContentPane().add(lblNewLabel_3);

		intFrameFuncionario.setFrameIcon(new ImageIcon(
				"C:\\Users\\Davi\\eclipse-workspace\\gerenciamantoveiculo\\src\\main\\resources\\imagens\\icon.png"));
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
				limparTabelaFun();
				if (!txtMatriculaFun.getText().isEmpty()) {
					Funcionario fun = FuncionarioSevice.buscarMatricula(txtMatriculaFun.getText());
					if (!fun.getCpf().isEmpty()) {
						String[] linha = { fun.getMatricula(), fun.getNome(), fun.getCpf(), fun.getEndereco().getCep(),
								fun.getEndereco().getLogradouro(), fun.getNumResidencia() };
						modeloFun.addRow(linha);
						txtMatriculaFun.setText("");
					} else {
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
				limparTabelaFun();
				if (!txtNomeLojaFun.getText().isEmpty()) {
					List<Funcionario> Listfun = FuncionarioSevice.buscarTodosFuncionariosLoja(txtNomeLojaFun.getText());
					if (Listfun.size() > 0) {
						for (Funcionario fun : Listfun) {
							String[] linha = { fun.getMatricula(), fun.getNome(), fun.getCpf(),
									fun.getEndereco().getCep(), fun.getEndereco().getLogradouro(),
									fun.getNumResidencia() };
							modeloFun.addRow(linha);
						}
						txtNomeLojaFun.setText("");
					} else {
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
				if (txtCepFun.getText().length() == 8) {
					Endereco end = EnderecoService.buscarCep(txtCepFun.getText());
					if (!end.getCiade().isEmpty()) {
						txtBairroFun.setText(end.getBairro());
						txtLogradouroFun.setText(end.getLogradouro());
						txtCidadeFun.setText(end.getCiade());
						txtComplementoFun.setText(end.getComplemento());
						txtUfFun.setText(end.getUf());
					} else {
						JOptionPane.showMessageDialog(null, "CEP inválido!");
					}
				} else {
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
				Funcionario c = new Funcionario();
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

				if (c.getCpf().length() == 11) {
					FuncionarioSevice.save(c);
					limparCamposFun();
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
				Funcionario c = new Funcionario();
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

				if (c.getCpf().length() == 11) {
					FuncionarioSevice.update(c.getMatricula(), c);
					limparCamposFun();
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
				limparCamposFun();
				limparTabelaFun();
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
				limparCamposFun();
				limparTabelaFun();
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
				String mat = tableFun.getValueAt(tableFun.getSelectedRow(), 0).toString();
				Funcionario c = FuncionarioSevice.buscarMatricula(mat);
				txtBairroFun.setText(c.getEndereco().getBairro());
				txtCepFun.setText(c.getEndereco().getCep());
				txtCidadeFun.setText(c.getEndereco().getCiade());
				txtComplementoFun.setText(c.getEndereco().getComplemento());
				txtCpfFun.setText(c.getCpf());
				txtLogradouroFun.setText(c.getEndereco().getLogradouro());
				txtNomeFun.setText(c.getNome());
				txtNumFun.setText(c.getNumResidencia());
				txtUfFun.setText(c.getEndereco().getUf());
				txtMatricula.setText(c.getMatricula());
				txtFunCepLoja.setText(c.getLoja().getEndereco().getCep());
				txtFunNomeLoja.setText(c.getLoja().getNome());
				txtMatricula.setEditable(false);
			}
		});
		modeloFun = new DefaultTableModel();
		String[] colunaFun = { "MATRICULA", "NOME", "CPF", "CEP", "LOGRADOURO", "Nº" };
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

		intFrameCliente.setFrameIcon(new ImageIcon(
				"C:\\Users\\Davi\\eclipse-workspace\\gerenciamantoveiculo\\src\\main\\resources\\imagens\\icon.png"));
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
				limparTabelaCliente();
				if (txtCpfBuscar.getText().length() == 11) {
					Cliente cliente = ClienteService.buscarCpf(txtCpfBuscar.getText());
					if (!cliente.getCpf().isEmpty()) {
						String[] linha = { cliente.getCpf(), cliente.getNome(), cliente.getTelefone(),
								cliente.getEndereco().getCep(), cliente.getEndereco().getLogradouro(),
								cliente.getNumResidencia() };
						modeloCliente.addRow(linha);
						txtCpfBuscar.setText("");
					} else {
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
				if (txtBuscarNome.getText().length() > 3) {
					limparTabelaCliente();
					List<Cliente> client = ClienteService.buscarListaCliente(txtBuscarNome.getText());
					if (client.size() > 0) {
						for (Cliente cliente : client) {
							String[] linha = { cliente.getCpf(), cliente.getNome(), cliente.getTelefone(),
									cliente.getEndereco().getCep(), cliente.getEndereco().getLogradouro(),
									cliente.getNumResidencia() };
							modeloCliente.addRow(linha);
						}
						txtBuscarNome.setText("");
					} else {
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
				String cpf = tableCliente.getValueAt(tableCliente.getSelectedRow(), 0).toString();
				Cliente c = ClienteService.buscarCpf(cpf);
				txtBairroCliente.setText(c.getEndereco().getBairro());
				txtCepCliente.setText(c.getEndereco().getCep());
				txtCidadeCliente.setText(c.getEndereco().getCiade());
				txtComplementoCliente.setText(c.getEndereco().getComplemento());
				txtCpfCliente.setText(c.getCpf());
				txtLogradouro.setText(c.getEndereco().getLogradouro());
				txtNomeCliente.setText(c.getNome());
				txtNumCliente.setText(c.getNumResidencia());
				txtUfCliente.setText(c.getEndereco().getUf());
				txtTelefoneCliente.setText(c.getTelefone());
				txtCpfCliente.setEditable(false);
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
				if (txtCepCliente.getText().length() == 8) {
					Endereco end = EnderecoService.buscarCep(txtCepCliente.getText());
					if (!end.getCiade().isEmpty()) {
						txtBairroCliente.setText(end.getBairro());
						txtLogradouro.setText(end.getLogradouro());
						txtCidadeCliente.setText(end.getCiade());
						txtComplementoCliente.setText(end.getComplemento());
						txtUfCliente.setText(end.getUf());
					} else {
						JOptionPane.showMessageDialog(null, "CEP inválido!");
					}
				} else {
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
				Cliente c = new Cliente();
				Endereco end = new Endereco();
				c.setCpf(txtCpfCliente.getText());
				c.setNome(txtNomeCliente.getText());
				c.setTelefone(txtTelefoneCliente.getText());
				c.setNumResidencia(txtNumCliente.getText());
				end.setCep(txtCepCliente.getText());
				c.setEndereco(end);

				if (c.getCpf().length() == 11) {
					ClienteService.save(c);
					limparCampos();
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

				Cliente c = new Cliente();
				Endereco end = new Endereco();
				c.setCpf(txtCpfCliente.getText());
				c.setNome(txtNomeCliente.getText());
				c.setTelefone(txtTelefoneCliente.getText());
				c.setNumResidencia(txtNumCliente.getText());
				end.setCep(txtCepCliente.getText());
				c.setEndereco(end);
				ClienteService.update(c.getCpf(), c);
				limparCampos();

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
				limparCampos();
				limparTabelaCliente();
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
				limparCampos();
			}

		});
		btnNewButton.setBounds(747, 478, 128, 23);
		intFrameCliente.getContentPane().add(btnNewButton);
		intFrameCliente.setVisible(false);
		intFrameFuncionario.setVisible(false);
	}

	private void limparCampos() {
		txtBairroCliente.setText("");
		txtCepCliente.setText("");
		txtCidadeCliente.setText("");
		txtComplementoCliente.setText("");
		txtCpfBuscar.setText("");
		txtBuscarNome.setText("");
		txtCpfCliente.setText("");
		txtLogradouro.setText("");
		txtNomeCliente.setText("");
		txtNumCliente.setText("");
		txtUfCliente.setText("");
		txtTelefoneCliente.setText("");
		txtCpfCliente.setEditable(true);
	}

	private void limparTabelaCliente() {
		while (tableCliente.getRowCount() > 0) {
			((DefaultTableModel) tableCliente.getModel()).removeRow(0);
		}
	}

	private void limparTabelaFun() {
		while (tableFun.getRowCount() > 0) {
			((DefaultTableModel) tableFun.getModel()).removeRow(0);
		}
	}

	private void limparCamposFun() {
		txtBairroFun.setText("");
		txtCepFun.setText("");
		txtCidadeFun.setText("");
		txtComplementoFun.setText("");
		txtNomeLojaFun.setText("");
		txtMatriculaFun.setText("");
		txtCpfFun.setText("");
		txtLogradouroFun.setText("");
		txtNomeFun.setText("");
		txtNumFun.setText("");
		txtMatricula.setText("");
		txtUfFun.setText("");
		txtFunCepLoja.setText("");
		txtFunNomeLoja.setText("");
		txtMatricula.setEditable(true);

	}

	private void limparTabelaVeico() {
		while (tableVeiculo.getRowCount() > 0) {
			((DefaultTableModel) tableVeiculo.getModel()).removeRow(0);
		}
	}

	private void limparCampoVeiculo() {
		txtBuscarPlaca.setText("");
		txtBuscaVeiculoLoja.setText("");
		txtPlacaVeiculo.setText("");
		txtAnoVeiculo.setText("");
		txtMarcaVeiculo.setText("");
		txtValorVeiculo.setText("");
		txtModeloVeiculo.setText("");
		txtLojaVeiculo.setText("");
		txtLojaCepVeiculo.setText("");
		txtBuscarVeiculoModelo.setText("");
		boxTipoVeiculo.setSelectedIndex(-1);
		txtPlacaVeiculo.setEditable(true);
	}
	
	private void limparCamposLoja() {
		txtLojaBairro.setText("");
		txtLojaCep.setText("");
		txtLojaCidade.setText("");
		txtLojaCom.setText("");
		txtLojaNum.setText("");
		txtLojaRua.setText("");
		txtNomeLoja.setText("");
		txtLojaUf.setText("");
		txtNomeLoja.setEditable(true);
	}
	private void popularTableLoja() {
		while(tableLoja.getRowCount()>0) {
			((DefaultTableModel) tableLoja.getModel()).removeRow(0);
		}
		List<Loja> listl = LojaService.buscarTodos();
		for(Loja l : listl) {
			String [] linha = {l.getNome(),l.getEndereco().getLogradouro(),l.getNumEndereco(),l.getEndereco().getCep()};
			modeloLoja.addRow(linha);
		}
	}
}
