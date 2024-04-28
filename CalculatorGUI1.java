import javax.swing.*;

public class CalculatorGUI1 {
    public static void main(String[] args) {
        // Tampilan dialog dengan tema yang menarik
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Menampilkan dialog untuk memasukkan angka pertama
        String input1 = JOptionPane.showInputDialog(null, "Masukkan angka pertama:", "Calculator", JOptionPane.PLAIN_MESSAGE);
        double angka1 = Double.parseDouble(input1);

        // Menampilkan dialog untuk memilih operasi
        Object[] operasi = {"+", "-", "*", "/", "Sin", "Cos", "Tan", "Log"};
        Object selectedOperation = JOptionPane.showInputDialog(null, "Pilih operasi:", "Operasi", 
                                                               JOptionPane.PLAIN_MESSAGE, null, operasi, operasi[0]);
        
        // Menampilkan dialog untuk memasukkan angka kedua
        String input2 = JOptionPane.showInputDialog(null, "Masukkan angka kedua:", "Calculator", JOptionPane.PLAIN_MESSAGE);
        double angka2 = Double.parseDouble(input2);

        double hasil = 0;
        String operasiStr = (String) selectedOperation;
        switch (operasiStr) {
            case "+":
                hasil = angka1 + angka2;
                break;
            case "-":
                hasil = angka1 - angka2;
                break;
            case "*":
                hasil = angka1 * angka2;
                break;
            case "/":
                if (angka2 != 0) {
                    hasil = angka1 / angka2;
                } else {
                    JOptionPane.showMessageDialog(null, "Tidak bisa melakukan pembagian dengan 0!", "Error", JOptionPane.ERROR_MESSAGE);
                    System.exit(0);
                }
                break;
            case "Sin":
                hasil = Math.sin(angka1);
                break;
            case "Cos":
                hasil = Math.cos(angka1);
                break;
            case "Tan":
                hasil = Math.tan(angka1);
                break;
            case "Log":
                hasil = Math.log(angka1);
                break;
        }

        // Menampilkan hasil
        JOptionPane.showMessageDialog(null, "Hasil: " + hasil, "Hasil", JOptionPane.INFORMATION_MESSAGE);
    }
}