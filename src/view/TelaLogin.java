package view;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaLogin extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;

    public TelaLogin() {
        setTitle("Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 350);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(null);
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblUsername = new JLabel("Usuário:");
        lblUsername.setBounds(100, 50, 80, 20);
        contentPane.add(lblUsername);

        usernameField = new JTextField();
        usernameField.setBounds(100, 70, 250, 40);
        contentPane.add(usernameField);

        JLabel lblPassword = new JLabel("Senha:");
        lblPassword.setBounds(100, 110, 80, 20);
        contentPane.add(lblPassword);

        passwordField = new JPasswordField();
        passwordField.setBounds(100, 130, 250, 40);
        passwordField.setEchoChar('*'); // Configuração do EchoChar para exibir asteriscos
        contentPane.add(passwordField);

        JButton loginButton = new JButton("LOGIN");
        loginButton.setBounds(100, 180, 250, 40);
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Aqui você pode adicionar a lógica de autenticação
                JOptionPane.showMessageDialog(null, "Bem vindo!");

                // Abrir a Tela Principal
                TelaPrincipal telaPrincipal = new TelaPrincipal();
                telaPrincipal.setVisible(true);
                
                // Fechar a tela de login
                dispose();
            }
        });
        contentPane.add(loginButton);

        // Adicionando o botão "Sair"
        JButton sairButton = new JButton("SAIR");
        sairButton.setBounds(100, 230, 250, 40);
        sairButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0); // Fecha o programa
            }
        });
        contentPane.add(sairButton);

        setLocationRelativeTo(null); // Centraliza a janela
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                TelaLogin frame = new TelaLogin();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

	public void exibirtelaLogin() {
		// TODO Auto-generated method stub
		
	}
}
