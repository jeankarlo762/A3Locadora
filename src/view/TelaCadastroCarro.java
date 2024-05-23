package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import database.ConnectionFactory;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class TelaCadastroCarro extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;

    /**
     * Launch the application.
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
     * Create the frame.
     */
    public TelaCadastroCarro() {
        setTitle("Cadastro de Carro");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 532, 241);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        JLabel lblNewLabel = new JLabel("Código");
        JLabel lblPlaca = new JLabel("Placa");
        JLabel lblMarca = new JLabel("Marca");

        textField = new JTextField();
        textField.setColumns(10);

        textField_1 = new JTextField();
        textField_1.setColumns(10);

        textField_2 = new JTextField();
        textField_2.setColumns(10);

        JButton btnSalvar = new JButton("Salvar");
        btnSalvar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String sql = "INSERT INTO carro(placa, marca) VALUES (?, ?)";
                ConnectionFactory factory = new ConnectionFactory();
                try (Connection c = factory.obtemConexao()) {
                    PreparedStatement ps = c.prepareStatement(sql);
                    ps.setString(1, textField_1.getText());
                    ps.setString(2, textField_2.getText());
                    ps.execute();
                    JOptionPane.showMessageDialog(null, "Carro cadastrado");
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                textField_1.setText("");
                textField_2.setText("");
            }

        });

        JButton btnAlterar = new JButton("Alterar");
        btnAlterar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String sql = "UPDATE carro SET placa = ?, marca = ? WHERE idCarro = ?";
                ConnectionFactory factory = new ConnectionFactory();
                try(Connection c = factory.obtemConexao()) {
                    PreparedStatement ps = c.prepareStatement(sql);
                    ps.setString(1, textField_1.getText());
                    ps.setString(2, textField_2.getText());
                    ps.setInt(3, Integer.parseInt(textField.getText()));
                    ps.execute();
                    JOptionPane.showMessageDialog(null, "Carro " + textField.getText() + " alterado com sucesso");
                } catch (Exception ex ) {
                    ex.printStackTrace();
                }
                textField.setText("");
                textField_1.setText("");
                textField_2.setText("");
            }
        });

        JButton btnExcluir = new JButton("Excluir");
        btnExcluir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String sql = "DELETE FROM carro WHERE idCarro = ?";
                ConnectionFactory factory = new ConnectionFactory();
                try (Connection c = factory.obtemConexao()) {
                    PreparedStatement ps = c.prepareStatement(sql);
                    ps.setInt(1, Integer.parseInt(textField.getText()));
                    ps.execute();
                    JOptionPane.showMessageDialog(null, "Carro " + textField.getText() + " excluído com sucesso");
                } catch (Exception ex){
                    ex.printStackTrace();
                }
                textField_1.setText("");
                textField_2.setText("");
            }
        });

        JButton btnFechar = new JButton("Fechar");
        btnFechar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        JButton btnConsultar = new JButton("Consultar");
        btnConsultar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String sql = "SELECT * FROM carro";
                ConnectionFactory factory = new ConnectionFactory();
                try(Connection c = factory.obtemConexao()) {
                    PreparedStatement ps = c.prepareStatement(sql);
                    ResultSet rs = ps.executeQuery();
                    while (rs.next()) {
                        int idCarro = rs.getInt("idCarro");
                        String placa = rs.getString("placa");
                        String marca = rs.getString("marca");
                        String aux = String.format(
                                "Código: %d \n Placa: %s \n Marca: %s\n", 
                                idCarro, placa, marca);
                        JOptionPane.showMessageDialog(null, aux);
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
            gl_contentPane.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_contentPane.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                            .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                .addComponent(lblPlaca)
                                .addComponent(lblMarca))
                            .addGap(18)
                            .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                .addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
                                .addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)))
                        .addGroup(gl_contentPane.createSequentialGroup()
                            .addComponent(lblNewLabel)
                            .addGap(18)
                            .addComponent(textField, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)))
                    .addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
                        .addComponent(btnConsultar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSalvar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAlterar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnExcluir, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnFechar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addContainerGap())
        );
        gl_contentPane.setVerticalGroup(
            gl_contentPane.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_contentPane.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                        .addComponent(lblNewLabel)
                        .addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnConsultar))
                    .addPreferredGap(ComponentPlacement.RELATED)
                    .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                        .addComponent(lblPlaca)
                        .addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnSalvar))
                    .addPreferredGap(ComponentPlacement.RELATED)
                    .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                        .addComponent(lblMarca)
                        .addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnAlterar))
                    .addPreferredGap(ComponentPlacement.RELATED)
                    .addComponent(btnExcluir)
                    .addPreferredGap(ComponentPlacement.RELATED)
                    .addComponent(btnFechar)
                    .addContainerGap(26, Short.MAX_VALUE))
        );
        contentPane.setLayout(gl_contentPane);
    }
}
