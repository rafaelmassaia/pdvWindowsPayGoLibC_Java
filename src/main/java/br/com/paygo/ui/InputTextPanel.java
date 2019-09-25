package br.com.paygo.ui;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.text.DecimalFormat;

class InputTextPanel extends JPanel {

    private JTextField textField;
    private ABMTextField currencyField;
    private JFormattedTextField formattedTextField;
    private String mask;

    InputTextPanel(String message, String mask) {
        this.mask = mask;
        setLayout(new GridLayout(2, 1, 0,2));

        JLabel label = new JLabel("<html>" + message.replaceAll("\n", "<br/>") + "</html>");

        add(label);

        if(!mask.equals("")) {
            try {
                if (mask.equals("R$@.@@@.@@@,@@")) {
                    DecimalFormat format = new DecimalFormat("R$#,###,##0.00");
                    currencyField = new ABMTextField(format);

                    add(currencyField);
                } else {
                    MaskFormatter maskFormatter = new MaskFormatter(mask.replaceAll("@", "#"));
                    maskFormatter.setOverwriteMode(true);

                    formattedTextField = new JFormattedTextField(maskFormatter);
                    formattedTextField.setMargin(new Insets(5, 2, 5, 2));
                    formattedTextField.setFocusLostBehavior(JFormattedTextField.PERSIST);
                    formattedTextField.grabFocus();

                    formattedTextField.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
                    formattedTextField.applyComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
                    formattedTextField.setCaretPosition(0);

                    add(formattedTextField);
                }
            } catch (Exception e) {
                addSimpleTextField();
            }
        } else {
            addSimpleTextField();
        }
    }

    String getValue() {
        if (!mask.equals("") && textField == null) {

            if (mask.equals("R$@.@@@.@@@,@@")) {
                return currencyField.getText().replaceAll("[^\\d]", "");
            }

            return formattedTextField.getText().replaceAll("[^\\d]", "");
        }
        return textField.getText();
    }

    private void addSimpleTextField() {
        textField = new JTextField();
        textField.setMargin(new Insets(5, 2, 5, 2));
        add(textField);
    }
}
