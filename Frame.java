import java.awt.*;
import javax.swing.*;

public class Frame extends JFrame {
    private Container cp;
    private JPanel mainPanel;
    private JRadioButton opz1;
    private JRadioButton opz2;
    private ButtonGroup grup;

    public Frame() {
        setTitle("Converti");
        setSize(new Dimension(250, 200));
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        cp = getContentPane();
       
        mainPanel = new JPanel();
        mainPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

        JTextField input = new JTextField(15); 

        JButton converti = new JButton("Converti");

        opz1 = new JRadioButton("miles");
        opz2 = new JRadioButton("yards");

        grup = new ButtonGroup();
        grup.add(opz1);
        grup.add(opz2);

        converti.addActionListener(e -> {
            String input2 = input.getText().toString();

            try {
                double numero = converti(input2);

                if (opz1.isSelected()) {
                    double miles = numero * 0.62137 * 1760;
                    JOptionPane.showMessageDialog(this, miles);
                }
                if (opz2.isSelected()) {
                    double yards = numero / 1.60934;
                    JOptionPane.showMessageDialog(this, yards);

                }

            } catch (NumberFormatException e_num) {
                JOptionPane.showMessageDialog(this, "Errore Input");
            }

        });

        mainPanel.add(input);
        mainPanel.add(converti);
        mainPanel.add(opz1);
        mainPanel.add(opz2);
        cp.add(mainPanel);

        setVisible(true);
    }

    public static Double converti(String input) throws NumberFormatException {

        return Double.parseDouble(input);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Frame();
        });
    }
}
