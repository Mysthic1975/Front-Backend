import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class IBANChecker extends JFrame implements ActionListener {                    //Frontend
    private final JTextField ibanField;
    private final JLabel resultLabel;
    private final IBANValidator validator;

    public IBANChecker() {
        super("IBAN Prüfer");
        setLayout(new FlowLayout());

        add(new JLabel("IBAN:"));
        ibanField = new JTextField(20);
        add(ibanField);

        JButton checkButton = new JButton("Prüfung");
        checkButton.addActionListener(this);
        add(checkButton);

        resultLabel = new JLabel();
        add(resultLabel);

        validator = new IBANValidator();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 100);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String iban = ibanField.getText();
        if (validator.isValid(iban)) {
            resultLabel.setText("Gültige IBAN");
        } else {
            resultLabel.setText("Ungültige IBAN");
        }
    }

    public static void main(String[] args) {
        new IBANChecker();
    }
}
