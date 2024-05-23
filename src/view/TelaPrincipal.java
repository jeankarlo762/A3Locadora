package view;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaPrincipal extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    /**
     * Inicia a aplicação.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                TelaPrincipal frame = new TelaPrincipal();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * Cria o frame.
     */
    public TelaPrincipal() {
        setTitle("Sistema de Vendas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);

        // Cria a barra de menu
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        // Cria o menu "Cadastro"
        JMenu cadastroMenu = new JMenu("Cadastro");
        menuBar.add(cadastroMenu);
        
        // Adiciona o item de menu "Cliente"
        JMenuItem clienteMenuItem = new JMenuItem("Cliente");
        cadastroMenu.add(clienteMenuItem);
        clienteMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Aqui você pode abrir a tela de cadastro de clientes
                TelaCadastroCliente telaCadastroCliente = new TelaCadastroCliente();
                telaCadastroCliente.setVisible(true);
            }
        });

        // Adiciona o item de menu "Carro"
        JMenuItem carroMenuItem = new JMenuItem("Carro");
        cadastroMenu.add(carroMenuItem);
        carroMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Aqui você pode abrir a tela de cadastro de carros
                TelaCadastroCarro telaCadastroCarro = new TelaCadastroCarro();
                telaCadastroCarro.setVisible(true);
            }
        });

        // Adiciona o item de menu "Sair" para fechar a aplicação
        JMenuItem sairMenuItem = new JMenuItem("Sair");
        sairMenuItem.addActionListener(e -> System.exit(0));
        cadastroMenu.add(sairMenuItem);

        // Cria o menu "Consulta"
        JMenu consultaMenu = new JMenu("Consulta");
        menuBar.add(consultaMenu);
        
        JMenuItem consultaClienteMenuItem = new JMenuItem("Cliente");
        consultaMenu.add(consultaClienteMenuItem);
        
        JMenuItem consultaCarroMenuItem = new JMenuItem("Carro");
        consultaMenu.add(consultaCarroMenuItem);

        // Cria o menu "Sobre"
        JMenu sobreMenu = new JMenu("Sobre");
        menuBar.add(sobreMenu);

        // Configura o painel de conteúdo
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
    }
}
