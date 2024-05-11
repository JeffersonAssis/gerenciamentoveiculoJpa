package br.com.concessionaria.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import br.com.concessionaria.model.Cliente;
import br.com.concessionaria.model.Endereco;
import br.com.concessionaria.model.Funcionario;
import br.com.concessionaria.model.Loja;
import br.com.concessionaria.model.Veiculo;
import br.com.concessionaria.model.Venda;
import br.com.concessionaria.service.ClienteService;
import br.com.concessionaria.service.EnderecoService;
import br.com.concessionaria.service.FuncionarioSevice;
import br.com.concessionaria.service.LojaService;
import br.com.concessionaria.service.VeiculoService;
import br.com.concessionaria.service.VendaService;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.swing.JRViewer;

public class ViewFrenteCaixa extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtClienteNome;
	private JTextField txtLogradouro;
	private JTextField txtBairro;
	private JTextField txtCidade;
	private JTextField txtEstado;
	private JTextField txtComplemento;
	private JTextField txtNumero;
	private JTextField textBuscaCPF;
	private JTextField txtBuscarNome;
	private JTable tableCliente;
	private DefaultTableModel modelo;
	private DefaultTableModel modeloVeiculo;
	private List<Cliente> listCliente;
	private JLabel lbVendaId;
	static Cliente cliente = new Cliente();
	private JTextField txtPlaca;
	private JTextField txtModelo;
	private JTextField txtLoja;
	private JTable tableVeiculo;
	private JTable tableLojas;
	private DefaultTableModel modeloLoja;
	private DefaultTableModel modeloFun;
	private JTable tableFun;
	private JTextField txtNomeLoja;
	private JTextField txtbuscarCpfVenda;
	private JTextField txtBuscarPlacaVenda;
	private JTable tableVenda;
	private DefaultTableModel modeloVenda;
	private JTextField txtPlacaVenda;
	private JTextField txtModeloVenda;
	private JTextField txtCpfVenda;
	private JTextField txtClienteVenda;
	private JTextField txtMatriculaVenda;
	private JTextField txtFendVenda;
	private JTextField txtValorVenda;
	private JTextField txtBuscarLojaVenda;

	/**
	 * Create the frame.
	 * 
	 * @throws ParseException
	 */
	public ViewFrenteCaixa() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				"C:\\Users\\Davi\\eclipse-workspace\\gerenciamantoveiculo\\src\\main\\resources\\imagens\\icon.png"));
		setTitle("Concessionaria - Vem que tem!");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 943, 607);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		JInternalFrame intFremaVendas = new JInternalFrame("Realizar Vendas");
		intFremaVendas.setClosable(true);

		JInternalFrame intFremaCadastroCliente = new JInternalFrame("Cadastra Cliente");
		intFremaCadastroCliente.setClosable(true);

		JInternalFrame intFrameBuscarCliente = new JInternalFrame("Buscar dados do Cliente");
		intFrameBuscarCliente.setClosable(true);

		JInternalFrame intFrameVeiculo = new JInternalFrame("Buscar Veiculo");

		JInternalFrame intFrameInformacao = new JInternalFrame("Informações");
		intFrameInformacao.setClosable(true);

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 937, 22);
		contentPane.add(menuBar);

		JMenu Venda = new JMenu("Venda");
		menuBar.add(Venda);

		JMenuItem realizarVenda = new JMenuItem("Realizar Venda");
		realizarVenda.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				intFremaVendas.setVisible(true);
			}
		});
		Venda.add(realizarVenda);

		JMenu menuCliente = new JMenu("Cliente");
		menuBar.add(menuCliente);

		JMenuItem menuClienteCadastro = new JMenuItem("Cadastro de Cliente");
		menuClienteCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				intFremaCadastroCliente.setVisible(true);
			}
		});
		menuClienteCadastro.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, InputEvent.ALT_DOWN_MASK));
		menuCliente.add(menuClienteCadastro);

		JMenuItem menuBuscarCliente = new JMenuItem("Buscar Cliente");
		menuBuscarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				intFrameBuscarCliente.setVisible(true);
			}
		});
		menuCliente.add(menuBuscarCliente);

		JMenu menuVeiculo = new JMenu("Veiculo");
		menuBar.add(menuVeiculo);

		JMenuItem menuVeiculoPlaca = new JMenuItem("Buscar Veiculo");
		menuVeiculoPlaca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				intFrameVeiculo.setVisible(true);
			}
		});
		menuVeiculo.add(menuVeiculoPlaca);

		JMenu MenuLoja = new JMenu("Informações");
		menuBar.add(MenuLoja);

		JMenuItem menuInfo = new JMenuItem("Informações");
		menuInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				intFrameInformacao.setVisible(true);
				List<Loja> listLoja = LojaService.buscarTodos();
				for (Loja v : listLoja) {
					String[] linha = { v.getNome(), v.getEndereco().getCep(), v.getEndereco().getLogradouro(),
							v.getNumEndereco(), v.getEndereco().getBairro(), v.getEndereco().getCiade() };
					modeloLoja.addRow(linha);
				}
			}
		});
		MenuLoja.add(menuInfo);

		intFremaVendas.setFrameIcon(new ImageIcon(
				"C:\\Users\\Davi\\eclipse-workspace\\gerenciamantoveiculo\\src\\main\\resources\\imagens\\icon.png"));
		intFremaVendas.setBounds(10, 33, 907, 508);
		contentPane.add(intFremaVendas);
		intFremaVendas.getContentPane().setLayout(null);

		JLabel lblNewLabel_3_3 = new JLabel("Realizar Venda");
		lblNewLabel_3_3.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_3_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3_3.setBounds(30, 172, 107, 20);
		intFremaVendas.getContentPane().add(lblNewLabel_3_3);

		JLabel lblNewLabel_3_1_1 = new JLabel("Buscar por CPF:");
		lblNewLabel_3_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3_1_1.setBounds(10, 47, 107, 14);
		intFremaVendas.getContentPane().add(lblNewLabel_3_1_1);

		JLabel lblNewLabel_3_2_1 = new JLabel("Buscar por placa:");
		lblNewLabel_3_2_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3_2_1.setBounds(287, 47, 133, 14);
		intFremaVendas.getContentPane().add(lblNewLabel_3_2_1);

		txtbuscarCpfVenda = new JTextField();
		txtbuscarCpfVenda.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (!txtbuscarCpfVenda.getText().isEmpty()) {
					limparTabelaVenda();

					List<Venda> listV = VendaService.buscarTodasVendaCpf(txtbuscarCpfVenda.getText());
					if (listV.size() > 0) {
						for (Venda v : listV) {
							String[] linha = { v.getVeiculo().getPlaca(), v.getVeiculo().getModelo(),
									v.getCliente().getCpf(), v.getCliente().getNome(),
									v.getFuncionario().getMatricula(), v.getFuncionario().getNome() };
							modeloVenda.addRow(linha);
						}
						txtBuscarPlacaVenda.setText("");

					} else {
						JOptionPane.showMessageDialog(null, "Venda não localizada!");
					}
				}
			}
		});
		txtbuscarCpfVenda.setColumns(10);
		txtbuscarCpfVenda.setBounds(116, 45, 161, 20);
		intFremaVendas.getContentPane().add(txtbuscarCpfVenda);

		txtBuscarPlacaVenda = new JTextField();
		txtBuscarPlacaVenda.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (!txtBuscarPlacaVenda.getText().isEmpty()) {
					limparTabelaVenda();

					Venda v = VendaService.buscarVendaPlaca(txtBuscarPlacaVenda.getText());
					if (v.getId() > 0) {
						String[] linha = { v.getVeiculo().getPlaca(), v.getVeiculo().getModelo(),
								v.getCliente().getCpf(), v.getCliente().getNome(), v.getFuncionario().getMatricula(),
								v.getFuncionario().getNome() };
						modeloVenda.addRow(linha);
						txtBuscarPlacaVenda.setText("");
					} else {
						JOptionPane.showMessageDialog(null, "Venda não localizada!");
					}
				}
			}
		});
		txtBuscarPlacaVenda.setColumns(10);
		txtBuscarPlacaVenda.setBounds(405, 45, 161, 20);
		intFremaVendas.getContentPane().add(txtBuscarPlacaVenda);

		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(10, 72, 871, 84);
		intFremaVendas.getContentPane().add(scrollPane_3);

		tableVenda = new JTable();
		tableVenda.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String palca = tableVenda.getValueAt(tableVenda.getSelectedRow(), 0).toString();
				Venda v = VendaService.buscarVendaPlaca(palca);
				txtClienteVenda.setText(v.getCliente().getNome());
				txtCpfVenda.setText(v.getCliente().getCpf());
				txtMatriculaVenda.setText(v.getFuncionario().getMatricula());
				txtFendVenda.setText(v.getFuncionario().getNome());
				txtValorVenda.setText("" + v.getValor());
				txtModeloVenda.setText(v.getVeiculo().getMarca());
				txtPlacaVenda.setText(v.getVeiculo().getPlaca());
				lbVendaId.setText(""+v.getId());
				txtCpfVenda.setEditable(false);
				txtPlacaVenda.setEditable(false);
			}
		});
		String[] colunaVenda = { "Placa", "Modelo", "CPF", "Nome Cliente", "Matª", "Nome Funcionario" };
		modeloVenda = new DefaultTableModel();
		modeloVenda.setColumnIdentifiers(colunaVenda);
		tableVenda.setModel(modeloVenda);

		scrollPane_3.setViewportView(tableVenda);

		JLabel lblNewLabel_8 = new JLabel("Buscar Venda");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_8.setBounds(10, 11, 113, 14);
		intFremaVendas.getContentPane().add(lblNewLabel_8);

		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBorder(new LineBorder(new Color(92, 89, 73), 3));
		layeredPane.setBounds(10, 190, 871, 183);
		intFremaVendas.getContentPane().add(layeredPane);

		JLabel lblNewLabel_9 = new JLabel("Veiculo placa");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_9.setBounds(10, 11, 413, 14);
		layeredPane.add(lblNewLabel_9);

		JLabel lblNewLabel_9_1 = new JLabel("Veiculo Modelo");
		lblNewLabel_9_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_9_1.setBounds(319, 11, 104, 14);
		layeredPane.add(lblNewLabel_9_1);

		JLabel lblNewLabel_9_2 = new JLabel("CPF Cliente");
		lblNewLabel_9_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_9_2.setBounds(10, 62, 413, 14);
		layeredPane.add(lblNewLabel_9_2);

		JLabel lblNewLabel_9_3 = new JLabel("Nome Cliente");
		lblNewLabel_9_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_9_3.setBounds(319, 62, 104, 14);
		layeredPane.add(lblNewLabel_9_3);

		JLabel lblNewLabel_9_4 = new JLabel("Matª Vendedor");
		lblNewLabel_9_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_9_4.setBounds(10, 118, 413, 14);
		layeredPane.add(lblNewLabel_9_4);

		JLabel lblNewLabel_9_5 = new JLabel("Nome Vendedor");
		lblNewLabel_9_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_9_5.setBounds(319, 118, 104, 14);
		layeredPane.add(lblNewLabel_9_5);

		txtPlacaVenda = new JTextField();
		txtPlacaVenda.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				Veiculo v = VeiculoService.buscarPlaca(txtPlacaVenda.getText());
				try {
				if(v.getPlaca()!=null) 
					txtModeloVenda.setText(v.getModelo());
				}catch(Exception e2) {
					JOptionPane.showMessageDialog(null, "Veiculo não cadastrado!");
				}
			}
		});
		txtPlacaVenda.setBounds(10, 31, 275, 20);
		layeredPane.add(txtPlacaVenda);
		txtPlacaVenda.setColumns(10);

		txtModeloVenda = new JTextField();
		txtModeloVenda.setColumns(10);
		txtModeloVenda.setBounds(319, 31, 275, 20);
		txtModeloVenda.setEditable(false);
		layeredPane.add(txtModeloVenda);

		txtCpfVenda = new JTextField();
		txtCpfVenda.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				Cliente c = ClienteService.buscarCpf(txtCpfVenda.getText());
				try {
				if(c.getCpf() !=null) 
					txtClienteVenda.setText(c.getNome());
				}catch (Exception e2){
					JOptionPane.showMessageDialog(null, "Cliente não cadastrado!");
				}
			}
		});
		txtCpfVenda.setColumns(10);
		txtCpfVenda.setBounds(10, 87, 275, 20);
		layeredPane.add(txtCpfVenda);

		txtClienteVenda = new JTextField();
		txtClienteVenda.setColumns(10);
		txtClienteVenda.setBounds(319, 87, 275, 20);
		txtClienteVenda.setEditable(false);
		layeredPane.add(txtClienteVenda);

		txtMatriculaVenda = new JTextField();
		txtMatriculaVenda.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				Funcionario c = FuncionarioSevice.buscarMatricula(txtMatriculaVenda.getText());
				try {
				if(c.getCpf() !=null) 
					txtFendVenda.setText(c.getNome());
				}catch (Exception e2)  {
					JOptionPane.showMessageDialog(null, "Funcionario não cadastrado!");				
				}
			}
		});
		txtMatriculaVenda.setColumns(10);
		txtMatriculaVenda.setBounds(10, 143, 275, 20);
		layeredPane.add(txtMatriculaVenda);

		txtFendVenda = new JTextField();
		txtFendVenda.setColumns(10);
		txtFendVenda.setBounds(319, 143, 275, 20);
		txtFendVenda.setEditable(false);
		layeredPane.add(txtFendVenda);

		txtValorVenda = new JTextField();
		txtValorVenda.setBounds(631, 31, 216, 20);
		layeredPane.add(txtValorVenda);
		txtValorVenda.setColumns(10);

		JLabel lblNewLabel_9_6 = new JLabel("Valor da Venda");
		lblNewLabel_9_6.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_9_6.setBounds(634, 12, 157, 14);
		layeredPane.add(lblNewLabel_9_6);

		JButton btnCadastraVenda = new JButton("Realizar Venda");
		btnCadastraVenda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Venda v = new Venda();
				Cliente c = new Cliente();
				Veiculo vv = VeiculoService.buscarPlaca(txtPlacaVenda.getText());
				Funcionario fun = new Funcionario();
				c.setCpf(txtCpfVenda.getText());
				fun.setMatricula(txtMatriculaVenda.getText());
				v.setFuncionario(fun);
				v.setVeiculo(vv);
				v.setCliente(c);
				v.setValor(Float.parseFloat(txtValorVenda.getText()));
				if(vv.getValor() < v.getValor() ) {
					VendaService.save(v);
					limparCamposVenda();
					limparTabelaVenda();
				}else {
					JOptionPane.showMessageDialog(null, "Venda não realizada, valor de Compra maior que valor de venda!");
				}
				
				
			}
		});
		btnCadastraVenda.setBackground(new Color(71, 114, 226));
		btnCadastraVenda.setForeground(new Color(71, 114, 226));
		btnCadastraVenda.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCadastraVenda.setBounds(631, 118, 216, 46);
		layeredPane.add(btnCadastraVenda);

		JButton btnTelaCliente = new JButton("Cadastrar Cliente");
		btnTelaCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				intFremaVendas.setVisible(false);
				intFremaCadastroCliente.setVisible(true);
			}
		});
		btnTelaCliente.setBounds(648, 73, 178, 23);
		layeredPane.add(btnTelaCliente);

		JButton btnDeletarVenda = new JButton("Deletar");
		btnDeletarVenda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!txtPlacaVenda.getText().isEmpty()) {

					VendaService.deleteVenda(txtPlacaVenda.getText());
					limparCamposVenda();
					limparTabelaVenda();
				}
			}
		});
		btnDeletarVenda.setForeground(new Color(255, 0, 0));
		btnDeletarVenda.setBackground(new Color(255, 0, 0));
		btnDeletarVenda.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnDeletarVenda.setBounds(10, 444, 161, 23);
		intFremaVendas.getContentPane().add(btnDeletarVenda);

		JButton btnLimparCampos = new JButton("Limpar Campos");
		btnLimparCampos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limparCamposVenda();
			}
		});
		btnLimparCampos.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnLimparCampos.setBounds(720, 444, 161, 23);
		intFremaVendas.getContentPane().add(btnLimparCampos);

		JLabel lbNumVenda = new JLabel("Nº Venda");
		lbNumVenda.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbNumVenda.setBounds(720, 167, 70, 20);
		intFremaVendas.getContentPane().add(lbNumVenda);

		JLabel lblNewLabel_3_2_1_1 = new JLabel("Buscar por Loja:");
		lblNewLabel_3_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3_2_1_1.setBounds(588, 47, 133, 14);
		intFremaVendas.getContentPane().add(lblNewLabel_3_2_1_1);

		txtBuscarLojaVenda = new JTextField();
		txtBuscarLojaVenda.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (!txtBuscarLojaVenda.getText().isEmpty()) {
					limparTabelaVenda();

					List<Venda> listV = VendaService.buscarTodasVendaLoja(txtBuscarLojaVenda.getText());
					if (listV.size() > 0) {
						for (Venda v : listV) {
							String[] linha = { v.getVeiculo().getPlaca(), v.getVeiculo().getModelo(),
									v.getCliente().getCpf(), v.getCliente().getNome(),
									v.getFuncionario().getMatricula(), v.getFuncionario().getNome() };
							modeloVenda.addRow(linha);
						}
						txtBuscarPlacaVenda.setText("");

					} else {
						JOptionPane.showMessageDialog(null, "Venda não localizada!");
					}
				}
			}
		});
		txtBuscarLojaVenda.setColumns(10);
		txtBuscarLojaVenda.setBounds(697, 45, 184, 20);
		intFremaVendas.getContentPane().add(txtBuscarLojaVenda);
		
		lbVendaId = new JLabel("");
		lbVendaId.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbVendaId.setBounds(783, 166, 98, 20);
		intFremaVendas.getContentPane().add(lbVendaId);
		
		JButton btRelatorio = new JButton("Relatório");
		btRelatorio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					JasperReport relaCompilado = JasperCompileManager.compileReport("src/main/java/br/com/concessionaria/relatorio/Relatorio-VendaCarro.jrxml");
					
					JasperPrint relaPr = JasperFillManager.fillReport(relaCompilado, null, new JRBeanCollectionDataSource(VendaService.buscarTodasVendas()));
					
					JFrame frame = new JFrame("Relatório de Venda");
				    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				    
				    JRViewer painelRelatorio = new JRViewer(relaPr);
				    frame.add(painelRelatorio);
				    frame.setSize(800,600);
				    frame.pack();
				    frame.setVisible(true);
					}catch(JRException ex) {
						    JOptionPane.showMessageDialog(null, "Erro ao gerar ou exibir o relatório: " + ex.getMessage());
					}
			}
		});
		btRelatorio.setBackground(new Color(0, 255, 0));
		btRelatorio.setForeground(new Color(0, 255, 0));
		btRelatorio.setFont(new Font("Tahoma", Font.BOLD, 13));
		btRelatorio.setBounds(353, 445, 133, 23);
		intFremaVendas.getContentPane().add(btRelatorio);

		intFrameInformacao.setFrameIcon(new ImageIcon(
				"C:\\Users\\Davi\\eclipse-workspace\\gerenciamantoveiculo\\src\\main\\resources\\imagens\\icon.png"));
		intFrameInformacao.setBounds(10, 33, 907, 508);
		contentPane.add(intFrameInformacao);
		intFrameInformacao.getContentPane().setLayout(null);

		JLabel lblNewLabel_6 = new JLabel("Lista de Lojas");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_6.setBounds(24, 11, 123, 14);
		intFrameInformacao.getContentPane().add(lblNewLabel_6);

		JScrollPane scrollPaneTabelaLoja = new JScrollPane();
		scrollPaneTabelaLoja.setBounds(24, 36, 844, 99);
		intFrameInformacao.getContentPane().add(scrollPaneTabelaLoja);

		tableLojas = new JTable();
		tableLojas.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		tableLojas.setBackground(new Color(236, 235, 232));
		scrollPaneTabelaLoja.setViewportView(tableLojas);
		modeloLoja = new DefaultTableModel();
		Object[] colunaLoja = { "Nome", "CEP", "Logradouro", "Nº", "Bairro", "Cidade" };
		modeloLoja.setColumnIdentifiers(colunaLoja);
		tableLojas.setModel(modeloLoja);

		JSeparator separator = new JSeparator();
		separator.setBounds(24, 146, 844, 14);
		intFrameInformacao.getContentPane().add(separator);

		JLabel lblNewLabel_7 = new JLabel("Funcionarios");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_7.setBounds(24, 159, 76, 14);
		intFrameInformacao.getContentPane().add(lblNewLabel_7);

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(24, 196, 844, 214);
		intFrameInformacao.getContentPane().add(scrollPane_2);

		txtNomeLoja = new JTextField();
		txtNomeLoja.setBounds(110, 157, 152, 20);
		intFrameInformacao.getContentPane().add(txtNomeLoja);
		txtNomeLoja.setColumns(10);

		tableFun = new JTable();
		tableLojas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtNomeLoja.setText("");
				while (modeloFun.getRowCount() > 0) {
					((DefaultTableModel) tableFun.getModel()).removeRow(0);

				}

				String nomeLoja = tableLojas.getValueAt(tableLojas.getSelectedRow(), 0).toString();
				txtNomeLoja.setText(tableLojas.getValueAt(tableLojas.getSelectedRow(), 0).toString());
				List<Funcionario> listLoja = FuncionarioSevice.buscarTodosFuncionariosLoja(nomeLoja);
				for (Funcionario v : listLoja) {
					String[] linhaFuncionario = { v.getNome(), v.getMatricula(), v.getCpf(), v.getEndereco().getCep() };
					modeloFun.addRow(linhaFuncionario);
				}

			}
		});
		scrollPane_2.setViewportView(tableFun);
		modeloFun = new DefaultTableModel();
		Object[] colunaFun = { "Nome", "Matª", "CPF", "CEP" };
		modeloFun.setColumnIdentifiers(colunaFun);
		tableFun.setModel(modeloFun);

		intFrameInformacao.setVisible(false);

		intFrameVeiculo.setClosable(true);
		intFrameVeiculo.setFrameIcon(new ImageIcon(
				"C:\\Users\\Davi\\eclipse-workspace\\gerenciamantoveiculo\\src\\main\\resources\\imagens\\icon.png"));
		intFrameVeiculo.setBounds(10, 33, 907, 508);
		contentPane.add(intFrameVeiculo);
		intFrameVeiculo.getContentPane().setLayout(null);

		JLabel lblNewLabel_4 = new JLabel("Buscar de Veiculo");
		lblNewLabel_4.setBounds(29, 11, 98, 14);
		intFrameVeiculo.getContentPane().add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("Buscar por Placa");
		lblNewLabel_5.setBounds(24, 34, 98, 14);
		intFrameVeiculo.getContentPane().add(lblNewLabel_5);

		JLabel lblNewLabel_5_1 = new JLabel("Buscar por Modelo");
		lblNewLabel_5_1.setBounds(260, 34, 98, 14);
		intFrameVeiculo.getContentPane().add(lblNewLabel_5_1);

		JLabel lblNewLabel_5_1_1 = new JLabel("Buscar por Loja");
		lblNewLabel_5_1_1.setBounds(526, 34, 98, 14);
		intFrameVeiculo.getContentPane().add(lblNewLabel_5_1_1);

		txtPlaca = new JTextField();
		txtPlaca.setBounds(110, 31, 140, 20);
		intFrameVeiculo.getContentPane().add(txtPlaca);
		txtPlaca.setColumns(10);

		txtModelo = new JTextField();
		txtModelo.setColumns(10);
		txtModelo.setBounds(355, 31, 150, 20);
		intFrameVeiculo.getContentPane().add(txtModelo);

		txtLoja = new JTextField();
		txtLoja.setColumns(10);
		txtLoja.setBounds(608, 31, 140, 20);
		intFrameVeiculo.getContentPane().add(txtLoja);

		JButton btnBuscarVeiculo = new JButton("Buscar");
		btnBuscarVeiculo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!txtPlaca.getText().isEmpty() && txtModelo.getText().isEmpty() && txtLoja.getText().isEmpty()) {
					Veiculo v = VeiculoService.buscarPlaca(txtPlaca.getText());
					String[] linha = { v.getPlaca(), v.getMarca(), v.getModelo(), "" + v.getAno(), "" + v.getValor(),
							v.getLoja().getNome(), v.getTipoVeiculo().name() };
					modeloVeiculo.addRow(linha);

				} else if (txtPlaca.getText().isEmpty() && !txtModelo.getText().isEmpty()
						&& txtLoja.getText().isEmpty()) {
					List<Veiculo> listV = VeiculoService.buscarTodosPorModelo(txtModelo.getText());
					for (Veiculo v : listV) {
						String[] linha = { v.getPlaca(), v.getMarca(), v.getModelo(), "" + v.getAno(),
								"" + v.getValor(), v.getLoja().getNome(), v.getTipoVeiculo().name() };
						if (v.getModelo().contains(txtModelo.getText()))
							modeloVeiculo.addRow(linha);
					}

				} else if (txtPlaca.getText().isEmpty() && txtModelo.getText().isEmpty()
						&& !txtLoja.getText().isEmpty()) {
					List<Veiculo> listV = VeiculoService.buscarTodos(txtPlaca.getText());
					for (Veiculo v : listV) {
						String[] linha = { v.getPlaca(), v.getMarca(), v.getModelo(), "" + v.getAno(),
								"" + v.getValor(), v.getLoja().getNome(), v.getTipoVeiculo().name() };
						if (v.getLoja().getNome().contains(txtLoja.getText()))
							modeloVeiculo.addRow(linha);
					}
				} else {
					JOptionPane.showMessageDialog(null, "Só pode realizar a pesquisa por um campo!");
				}
			}
		});
		btnBuscarVeiculo.setBounds(758, 30, 89, 23);
		intFrameVeiculo.getContentPane().add(btnBuscarVeiculo);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(29, 94, 832, 348);
		intFrameVeiculo.getContentPane().add(scrollPane_1);

		tableVeiculo = new JTable();
		modeloVeiculo = new DefaultTableModel();
		Object[] colunaVeiculo = { "Placa", "Marca", "Modelo", "Ano", "Valor", "Loja", "TipoVeiculo" };
		modeloVeiculo.setColumnIdentifiers(colunaVeiculo);
		tableVeiculo.setModel(modeloVeiculo);
		scrollPane_1.setViewportView(tableVeiculo);

		JButton btnLimpaTabela = new JButton("Limpar");
		btnLimpaTabela.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtModelo.setText("");
				txtLoja.setText("");
				txtPlaca.setText("");
				while (modeloVeiculo.getRowCount() > 0) {
					((DefaultTableModel) tableVeiculo.getModel()).removeRow(0);

				}
			}

		});
		btnLimpaTabela.setBounds(758, 453, 89, 20);
		intFrameVeiculo.getContentPane().add(btnLimpaTabela);
		intFrameVeiculo.setVisible(false);

		intFrameBuscarCliente.setBounds(10, 33, 907, 508);
		contentPane.add(intFrameBuscarCliente);
		intFrameBuscarCliente.getContentPane().setLayout(null);

		JLabel lblNewLabel_3 = new JLabel("Informe o CPF ou Nome");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3.setBounds(23, 11, 169, 14);
		intFrameBuscarCliente.getContentPane().add(lblNewLabel_3);

		JLabel lblNewLabel_3_1 = new JLabel("CPF:");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3_1.setBounds(23, 47, 46, 14);
		intFrameBuscarCliente.getContentPane().add(lblNewLabel_3_1);

		JLabel lblNewLabel_3_2 = new JLabel("Nome:");
		lblNewLabel_3_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3_2.setBounds(386, 47, 46, 14);
		intFrameBuscarCliente.getContentPane().add(lblNewLabel_3_2);

		textBuscaCPF = new JTextField();
		textBuscaCPF.setBounds(55, 45, 285, 20);
		intFrameBuscarCliente.getContentPane().add(textBuscaCPF);
		textBuscaCPF.setColumns(10);

		txtBuscarNome = new JTextField();
		txtBuscarNome.setColumns(10);
		txtBuscarNome.setBounds(435, 45, 285, 20);
		intFrameBuscarCliente.getContentPane().add(txtBuscarNome);
		modelo = new DefaultTableModel();
		Object[] coluna = { "CPF", "Nome", "Telefone", "CEP", "Logradouro", "Cidade" };
		modelo.setColumnIdentifiers(coluna);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 92, 838, 331);
		intFrameBuscarCliente.getContentPane().add(scrollPane);

		tableCliente = new JTable();
		scrollPane.setViewportView(tableCliente);
		tableCliente.setFillsViewportHeight(true);
		tableCliente.setBackground(new Color(228, 228, 224));
		tableCliente.setModel(modelo);

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				DefaultTableModel modelo = (DefaultTableModel) tableCliente.getModel();
				if (txtBuscarNome.getText().isBlank() && !textBuscaCPF.getText().isEmpty()) {
					cliente = ClienteService.buscarCpf(textBuscaCPF.getText());
					String[] linha = { cliente.getCpf(), cliente.getNome(), cliente.getTelefone(),
							cliente.getEndereco().getCep(), cliente.getEndereco().getLogradouro(),
							cliente.getEndereco().getCiade() };
					modelo.addRow(linha);
				} else if (!txtBuscarNome.getText().isEmpty() && textBuscaCPF.getText().isEmpty()) {
					listCliente = ClienteService.buscarListaCliente(txtBuscarNome.getText());
					for (Cliente cliente : listCliente) {
						String[] linha = { cliente.getCpf(), cliente.getNome(), cliente.getTelefone(),
								cliente.getEndereco().getCep(), cliente.getEndereco().getLogradouro(),
								cliente.getEndereco().getCiade() };
						modelo.addRow(linha);
					}

				}
			}
		});
		btnBuscar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnBuscar.setForeground(Color.BLUE);
		btnBuscar.setBounds(772, 44, 89, 23);
		intFrameBuscarCliente.getContentPane().add(btnBuscar);
		intFrameBuscarCliente.setVisible(false);

		JButton btnLimpaTabelaCliente = new JButton("Limpar");
		btnLimpaTabelaCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textBuscaCPF.setText("");
				txtBuscarNome.setText("");
				while (modelo.getRowCount() > 0) {
					((DefaultTableModel) tableCliente.getModel()).removeRow(0);

				}
			}

		});
		btnLimpaTabelaCliente.setBounds(758, 453, 89, 20);
		intFrameBuscarCliente.getContentPane().add(btnLimpaTabelaCliente);

		intFremaCadastroCliente.setBounds(10, 33, 907, 508);
		contentPane.add(intFremaCadastroCliente);
		intFremaCadastroCliente.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Dados do Cliente");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(26, 11, 203, 25);
		intFremaCadastroCliente.getContentPane().add(lblNewLabel);

		txtClienteNome = new JTextField();
		txtClienteNome.setBounds(26, 90, 844, 20);
		intFremaCadastroCliente.getContentPane().add(txtClienteNome);
		txtClienteNome.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Nome:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(26, 65, 87, 14);
		intFremaCadastroCliente.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("CPF:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_1.setBounds(26, 121, 87, 14);
		intFremaCadastroCliente.getContentPane().add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("Telefone:");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_2.setBounds(484, 121, 80, 14);
		intFremaCadastroCliente.getContentPane().add(lblNewLabel_1_2);

		JLabel lblNewLabel_2 = new JLabel("CEP:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(26, 199, 80, 14);
		intFremaCadastroCliente.getContentPane().add(lblNewLabel_2);

		JLabel lblNewLabel_2_1 = new JLabel("Logradouro:");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2_1.setBounds(225, 199, 111, 14);
		intFremaCadastroCliente.getContentPane().add(lblNewLabel_2_1);

		txtLogradouro = new JTextField();
		txtLogradouro.setColumns(10);
		txtLogradouro.setBounds(225, 224, 486, 20);
		intFremaCadastroCliente.getContentPane().add(txtLogradouro);

		JLabel lblNewLabel_2_2 = new JLabel("Bairro");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2_2.setBounds(26, 259, 80, 14);
		intFremaCadastroCliente.getContentPane().add(lblNewLabel_2_2);

		txtBairro = new JTextField();
		txtBairro.setColumns(10);
		txtBairro.setBounds(26, 284, 377, 20);
		intFremaCadastroCliente.getContentPane().add(txtBairro);

		JLabel lblNewLabel_2_1_1 = new JLabel("Cidade:");
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2_1_1.setBounds(440, 259, 234, 14);
		intFremaCadastroCliente.getContentPane().add(lblNewLabel_2_1_1);

		txtCidade = new JTextField();
		txtCidade.setColumns(10);
		txtCidade.setBounds(440, 284, 430, 20);
		intFremaCadastroCliente.getContentPane().add(txtCidade);

		txtEstado = new JTextField();
		txtEstado.setColumns(10);
		txtEstado.setBounds(26, 349, 377, 20);
		intFremaCadastroCliente.getContentPane().add(txtEstado);

		JLabel lblNewLabel_2_2_1 = new JLabel("Estado:");
		lblNewLabel_2_2_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2_2_1.setBounds(26, 324, 80, 14);
		intFremaCadastroCliente.getContentPane().add(lblNewLabel_2_2_1);

		txtComplemento = new JTextField();
		txtComplemento.setColumns(10);
		txtComplemento.setBounds(440, 349, 430, 20);
		intFremaCadastroCliente.getContentPane().add(txtComplemento);

		JLabel lblNewLabel_2_1_1_1 = new JLabel("Complemento:");
		lblNewLabel_2_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2_1_1_1.setBounds(440, 324, 234, 14);
		intFremaCadastroCliente.getContentPane().add(lblNewLabel_2_1_1_1);

		MaskFormatter mascaraCpf = null, mascaraCep = null, mascaraTelefone = null;
		try {
			mascaraCpf = new MaskFormatter("###.###.###-##");
			mascaraCep = new MaskFormatter("##.###-###");
			mascaraTelefone = new MaskFormatter("(##) #####-####");
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		JFormattedTextField txtCpfCliente = new JFormattedTextField(mascaraCpf);
		txtCpfCliente.setBounds(26, 146, 430, 20);
		intFremaCadastroCliente.getContentPane().add(txtCpfCliente);

		JFormattedTextField txtCep = new JFormattedTextField(mascaraCep);
		txtCep.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				String cep = txtCep.getText().replace(".", "").replace("-", "");
				Endereco end = EnderecoService.buscarCep(cep);
				txtBairro.setText(end.getBairro());
				txtCidade.setText(end.getCiade());
				txtComplemento.setText(end.getComplemento());
				txtEstado.setText(end.getUf());
				txtLogradouro.setText(end.getLogradouro());
			}
		});
		txtCep.setBounds(26, 224, 177, 20);
		intFremaCadastroCliente.getContentPane().add(txtCep);

		JFormattedTextField txtTelefoneCliente = new JFormattedTextField(mascaraTelefone);
		txtTelefoneCliente.setBounds(484, 146, 386, 20);
		intFremaCadastroCliente.getContentPane().add(txtTelefoneCliente);

		JButton btnSalva = new JButton("Cadastrar");
		btnSalva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cliente c = new Cliente();
				Endereco end = new Endereco();
				c.setCpf(txtCpfCliente.getText().replace(".", "").replace("-", ""));
				c.setNome(txtClienteNome.getText());
				c.setNumResidencia(txtNumero.getText());
				c.setTelefone(txtTelefoneCliente.getText().replace("(", "").replace("-", "").replace(")", ""));
				end.setCep(txtCep.getText().replace(".", "").replace("-", ""));
				end.setLogradouro(txtLogradouro.getText());
				end.setBairro(txtBairro.getText());
				end.setCiade(txtCidade.getText());
				end.setUf(txtEstado.getText());
				end.setComplemento(txtComplemento.getText());
				c.setEndereco(end);

				ClienteService.save(c);

				txtCep.setText("");
				txtTelefoneCliente.setText("");
				txtCpfCliente.setText("");
				txtNumero.setText("");
				txtClienteNome.setText("");
				txtBairro.setText("");
				txtCidade.setText("");
				txtComplemento.setText("");
				txtEstado.setText("");
				txtLogradouro.setText("");
			}
		});
		btnSalva.setForeground(Color.BLUE);
		btnSalva.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnSalva.setBounds(440, 444, 124, 23);
		intFremaCadastroCliente.getContentPane().add(btnSalva);

		JLabel lblNewLabel_2_1_2 = new JLabel("Nº");
		lblNewLabel_2_1_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2_1_2.setBounds(724, 199, 214, 14);
		intFremaCadastroCliente.getContentPane().add(lblNewLabel_2_1_2);

		txtNumero = new JTextField();
		txtNumero.setColumns(10);
		txtNumero.setBounds(724, 224, 135, 20);
		intFremaCadastroCliente.getContentPane().add(txtNumero);

		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtCep.setText("");
				txtTelefoneCliente.setText("");
				txtCpfCliente.setText("");
				txtNumero.setText("");
				txtClienteNome.setText("");
				txtBairro.setText("");
				txtCidade.setText("");
				txtComplemento.setText("");
				txtEstado.setText("");
				txtLogradouro.setText("");
			}
		});
		btnLimpar.setForeground(Color.BLUE);
		btnLimpar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnLimpar.setBounds(599, 445, 89, 23);
		intFremaCadastroCliente.getContentPane().add(btnLimpar);
		intFremaCadastroCliente.setVisible(false);
		intFremaVendas.setVisible(false);

	}

	private void limparCamposVenda() {
		txtbuscarCpfVenda.setText("");
		txtBuscarPlacaVenda.setText("");
		txtClienteVenda.setText("");
		txtCpfVenda.setText("");
		txtMatriculaVenda.setText("");
		txtFendVenda.setText("");
		txtValorVenda.setText("");
		txtModeloVenda.setText("");
		txtPlacaVenda.setText("");
		txtBuscarLojaVenda.setText("");
		txtCpfVenda.setEditable(true);
		txtPlacaVenda.setEditable(true);
		lbVendaId.setText("");
	}

	private void limparTabelaVenda() {
		while (tableVenda.getRowCount() > 0) {
			((DefaultTableModel) tableVenda.getModel()).removeRow(0);
		}
	}
}
