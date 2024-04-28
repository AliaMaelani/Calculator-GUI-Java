import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorGUI2 extends JFrame implements ActionListener {
    private JTextField angkaField1;
    private JTextField angkaField2;
    private JTextField hasilField;
    private JButton tambahButton;
    private JButton kurangButton;
    private JButton kaliButton;
    private JButton bagiButton;

    public CalculatorGUI2() {
        setTitle("Kalkulator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLayout(new GridLayout(5, 2, 5, 5));

        JLabel labelAngka1 = new JLabel("Bilangan 1:");
        add(labelAngka1);

        angkaField1 = new JTextField();
        add(angkaField1);

        JLabel labelAngka2 = new JLabel("Bilangan 2:");
        add(labelAngka2);

        angkaField2 = new JTextField();
        add(angkaField2);

        JLabel labelHasil = new JLabel("Hasil:");
        add(labelHasil);

        hasilField = new JTextField();
        hasilField.setEditable(false);
        add(hasilField);

        tambahButton = new JButton("Tambah");
        tambahButton.addActionListener(this);
        add(tambahButton);

        kurangButton = new JButton("Kurang");
        kurangButton.addActionListener(this);
        add(kurangButton);

        kaliButton = new JButton("Kali");
        kaliButton.addActionListener(this);
        add(kaliButton);

        bagiButton = new JButton("Bagi");
        bagiButton.addActionListener(this);
        add(bagiButton);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        double angka1;
        double angka2;
        double hasil = 0;

        try {
            angka1 = Double.parseDouble(angkaField1.getText());
            angka2 = Double.parseDouble(angkaField2.getText());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Masukkan angka yang valid!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (e.getSource() == tambahButton) {
            hasil = angka1 + angka2;
        } else if (e.getSource() == kurangButton) {
            hasil = angka1 - angka2;
        } else if (e.getSource() == kaliButton) {
            hasil = angka1 * angka2;
        } else if (e.getSource() == bagiButton) {
            if (angka2 != 0) {
                hasil = angka1 / angka2;
            } else {
                JOptionPane.showMessageDialog(this, "Tidak bisa melakukan pembagian dengan 0!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }

        hasilField.setText(Double.toString(hasil));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CalculatorGUI2());
    }
}