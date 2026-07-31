// Assignment Question:
// Design a GUI application using Java Swing that implements a simple calculator with the following features: addition, subtraction, multiplication, division, and modulus operations, taking multiple numbers as input from the user, and displaying the result in a designated label.
// Author: Ansh Pandey

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;

public class SimpleCalculator extends JFrame {
    private JPanel panel;
    private JTextField textField;
    private JButton zeroButton;
    private JButton oneButton;
    private JButton twoButton;
    private JButton threeButton;
    private JButton fourButton;
    private JButton fiveButton;
    private JButton sixButton;
    private JButton sevenButton;
    private JButton eightButton;
    private JButton nineButton;
    private JButton addButton;
    private JButton subtractButton;
    private JButton multiplyButton;
    private JButton divideButton;
    private JButton equalsButton;
    private JButton clearButton;
    private JButton modulusButton;
    private JLabel resultLabel;

    public SimpleCalculator() {
        setLayout(new BorderLayout());
        panel = new JPanel(new GridLayout(4, 4));

        zeroButton = new JButton("0");
        oneButton = new JButton("1");
        twoButton = new JButton("2");
        threeButton = new JButton("3");
        fourButton = new JButton("4");
        fiveButton = new JButton("5");
        sixButton = new JButton("6");
        sevenButton = new JButton("7");
        eightButton = new JButton("8");
        nineButton = new JButton("9");
        addButton = new JButton("+");
        subtractButton = new JButton("-");
        multiplyButton = new JButton("*");
        divideButton = new JButton("/");
        equalsButton = new JButton("=");
        clearButton = new JButton("C");
        modulusButton = new JButton("%");

        textField = new JTextField();
        resultLabel = new JLabel("Result:", SwingConstants.RIGHT);

        panel.add(sevenButton);
        panel.add(eightButton);
        panel.add(nineButton);
        panel.add(divideButton);
        panel.add(fourButton);
        panel.add(fiveButton);
        panel.add(sixButton);
        panel.add(multiplyButton);
        panel.add(oneButton);
        panel.add(twoButton);
        panel.add(threeButton);
        panel.add(subtractButton);
        panel.add(zeroButton);
        panel.add(modulusButton);
        panel.add(equalsButton);
        panel.add(addButton);

        add(panel, BorderLayout.CENTER);
        add(resultLabel, BorderLayout.PAGE_END);
        add(textField, BorderLayout.PAGE_START);

        zeroButton.addActionListener(new ButtonActionListener());
        oneButton.addActionListener(new ButtonActionListener());
        twoButton.addActionListener(new ButtonActionListener());
        threeButton.addActionListener(new ButtonActionListener());
        fourButton.addActionListener(new ButtonActionListener());
        fiveButton.addActionListener(new ButtonActionListener());
        sixButton.addActionListener(new ButtonActionListener());
        sevenButton.addActionListener(new ButtonActionListener());
        eightButton.addActionListener(new ButtonActionListener());
        nineButton.addActionListener(new ButtonActionListener());
        addButton.addActionListener(new ButtonActionListener());
        subtractButton.addActionListener(new ButtonActionListener());
        multiplyButton.addActionListener(new ButtonActionListener());
        divideButton.addActionListener(new ButtonActionListener());
        equalsButton.addActionListener(new ButtonActionListener());
        clearButton.addActionListener(new ButtonActionListener());
        modulusButton.addActionListener(new ButtonActionListener());

        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private class ButtonActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();

            if (command.equals(clearButton.getText())) {
                textField.setText("");
                resultLabel.setText("Result: ");
            } else if (command.equals(equalsButton.getText())) {
                try {
                    double doubleVal = Double.parseDouble(textField.getText());
                    String[] operations = textField.getText().split("\\*|\\/|\\%|\\+|-");
                    double tempRes = doubleVal;

                    for (int i = 0; i < operations.length; i++) {
                        String oper = operations[i];

                        if (oper.equals("*")) {
                            for (int j = i + 1; j < operations.length; j++) {
                                tempRes *= Double.parseDouble(operations[j]);
                            }
                        } else if (oper.equals("/")) {
                            for (int j = i + 1; j < operations.length; j++) {
                                tempRes /= Double.parseDouble(operations[j]);
                            }
                        } else if (oper.equals("%")) {
                            for (int j = i + 1; j < operations.length; j++) {
                                tempRes %= Double.parseDouble(operations[j]);
                            }
                        } else {
                            double number = Double.parseDouble(oper);
                            if (oper.equals("+")) {
                                tempRes += number;
                            } else if (oper.equals("-")) {
                                tempRes -= number;
                            }
                        }
                        i = operations.length;
                    }

                    DecimalFormat df = new DecimalFormat("#0.000");
                    textField.setText(df.format(tempRes));
                    resultLabel.setText("Result: ");
                } catch (Exception ex) {
                    textField.setText("Error");
                    resultLabel.setText("Result: ");
                }
            } else {
                textField.setText(textField.getText() + command);
            }
        }
    }

    public static void main(String[] args) {
        new SimpleCalculator();
    }
}