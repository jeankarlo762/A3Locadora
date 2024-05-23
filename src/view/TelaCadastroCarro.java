package view;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaCadastroCarro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldPlaca;
	private JTextField textFieldMarca;
	private JTextField textFieldModelo;

	/**
	 * Método principal para iniciar a aplicação.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroCarro frame = new TelaCadastroCarro();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Cria o frame da tela de cadastro de carros.
	 */
	public TelaCadastroCarro() {
		setTitle("Cadastro de Carro");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// Rótulo e campo de texto para a placa do carro
		JLabel lblNewLabel = new JLabel("Placa:");
		lblNewLabel.setBounds(33, 31, 46, 14);
		contentPane.add(lblNewLabel);
		
		textFieldPlaca = new JTextField();
		textFieldPlaca.setBounds(89, 28, 86, 20);
		contentPane.add(textFieldPlaca);
		textFieldPlaca.setColumns(10);
		
		// Rótulo e campo de texto para a marca do carro
		JLabel lblMarca = new JLabel("Marca:");
		lblMarca.setBounds(33, 73, 46, 14);
		contentPane.add(lblMarca);
		
		textFieldMarca = new JTextField();
		textFieldMarca.setBounds(89, 70, 274, 20);
		contentPane.add(textFieldMarca);
		textFieldMarca.setColumns(10);
		
		// Rótulo e campo de texto para o modelo do carro
		JLabel lblModelo = new JLabel("Modelo:");
		lblModelo.setBounds(33, 116, 46, 14);
		contentPane.add(lblModelo);
		
		textFieldModelo = new JTextField();
		textFieldModelo.setBounds(89, 113, 274, 20);
		contentPane.add(textFieldModelo);
		textFieldModelo.setColumns(10);
		
		// Botão para salvar o carro
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Aqui seria a lógica para salvar o carro no banco de dados
				JOptionPane.showMessageDialog(null, "Carro cadastrado com sucesso!");
				limparCampos();
			}
		});
		btnSalvar.setBounds(33, 174, 89, 23);
		contentPane.add(btnSalvar);
		
		// Botão para cancelar o cadastro
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limparCampos();
			}
		});
		btnCancelar.setBounds(155, 174, 89, 23);
		contentPane.add(btnCancelar);
		
		// Botão para fechar a janela
		JButton btnFechar = new JButton("Fechar");
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnFechar.setBounds(274, 174, 89, 23);
		contentPane.add(btnFechar);
		
		// Botão para alterar o carro
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Aqui seria a lógica para alterar o carro no banco de dados
				JOptionPane.showMessageDialog(null, "Carro alterado com sucesso!");
				limparCampos();
			}
		});
		btnAlterar.setBounds(33, 208, 89, 23);
		contentPane.add(btnAlterar);
		
		// Botão para excluir o carro
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Aqui seria a lógica para excluir o carro do banco de dados
				JOptionPane.showMessageDialog(null, "Carro excluído com sucesso!");
				limparCampos();
			}
		});
		btnExcluir.setBounds(155, 208, 89, 23);
		contentPane.add(btnExcluir);
		
		// Botão para consultar o carro
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Aqui seria a lógica para consultar o carro no banco de dados
				JOptionPane.showMessageDialog(null, "Consulta realizada com sucesso!");
				limparCampos();
			}
		});
		btnConsultar.setBounds(274, 208, 89, 23);
		contentPane.add(btnConsultar);
	}
	
	// Método para limpar os campos de texto
	private void limparCampos() {
		textFieldPlaca.setText("");
		textFieldMarca.setText("");
		textFieldModelo.setText("");
	}
}
