package view.TelaOperacaoUsuario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TelaDataAluguel extends JFrame {

	/*
	 * 
	 * mostrar dois campos onde o usuario insira uma data
	 * 
	 * a data não deve ser antes da data atual e
	 *  o aluguel não pode passar de 30 dias 
	 * 
	 * 
	 * 
	*/
	
	private JTextField startDateField;
    private JTextField endDateField;

    public TelaDataAluguel() {
        setTitle("Aluguel");
        setSize(300, 150);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));

        JLabel startDateLabel = new JLabel("Data de Início (dd/MM/YYYY):");
        startDateField = new JTextField();
        JLabel endDateLabel = new JLabel("Data de Fim (dd/MM/YYYY):");
        endDateField = new JTextField();

        JButton validateButton = new JButton("Validar");

        panel.add(startDateLabel);
        panel.add(startDateField);
        panel.add(endDateLabel);
        panel.add(endDateField);
        panel.add(new JLabel());
        panel.add(validateButton);

        validateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                validarDatas();
            }
        });

        add(panel);
        setVisible(true);
    }

    private void validarDatas() {
        String startDateText = startDateField.getText();
        String endDateText = endDateField.getText();

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false); // Para fazer a validação escrita das datas

        try {
            Date startDate = sdf.parse(startDateText);
            Date endDate = sdf.parse(endDateText);

            Date currentDate = new Date(); // Data atual

            if (startDate.before(currentDate)) {
                JOptionPane.showMessageDialog(this, "A data de início deve ser uma data futura em relação à data atual!", "Erro", JOptionPane.ERROR_MESSAGE);
            } else if (startDate.after(endDate)) {
                JOptionPane.showMessageDialog(this, "A data de início não pode ser posterior à data de fim!", "Erro", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Datas válidas!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(this, "Formato de data inválido! Use o formato dd/MM/YYYY.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
	
}
