package view;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class TelaLogin {
    JTextField campoLogin;
    JPasswordField campoSenha;
    JLabel rotuloLogin = new JLabel("Login:");
    JLabel rotuloSenha = new JLabel("Senha:");
    JPanel painel = new JPanel(new GridLayout(0, 2)); 

    public void exibirtelaLogin() {
        painel.add(rotuloLogin);
        painel.add(campoLogin = new JTextField());
        painel.add(rotuloSenha);
        painel.add(campoSenha = new JPasswordField()); 

        int opcao;
        do {
            opcao = JOptionPane.showConfirmDialog(null, painel, "Digite os valores dos campos", JOptionPane.OK_CANCEL_OPTION);

            if (opcao == JOptionPane.OK_OPTION) {
                if (campoLogin.getText().equals("admUnisul")) {
                    char[] senhaChars = campoSenha.getPassword(); 
                    String senha = new String(senhaChars);
                    
                    if (senha.equals("1234")) {
                        JOptionPane.showMessageDialog(painel, "Login bem-sucedido!");
                        //tela adm
                        break; 
                    } else {
                    	JOptionPane.showMessageDialog(painel, "Login bem-sucedido!");
                        //tela de usuario comum
                    }
                } else {
                    JOptionPane.showMessageDialog(painel, "Usuário incorreto. Tente novamente.");
                }
            } else if (opcao == JOptionPane.CANCEL_OPTION) {
                JOptionPane.showMessageDialog(painel, "Operação cancelada.");
                break; 
            }
        } while (true); 
    }
}
