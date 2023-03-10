import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CalculatorApp extends JFrame implements ActionListener {

    private JButton[] numButtons;
    private JButton addButton, subtractButton, multiplyButton, divideButton, equalsButton, clearButton;
    private JTextField inputField;
    private double num1, num2, result;
    private String operator;//lala

    public CalculatorApp() {
        setTitle("Calculator App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(400, 400);

        JPanel mainPanel = new JPanel(new BorderLayout());

        inputField = new JTextField();
        inputField.setEditable(false);
        inputField.setPreferredSize(new Dimension(400, 50));
        mainPanel.add(inputField, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new GridLayout(4, 4));

        numButtons = new JButton[10];
        for (int i = 0; i < 10; i++) {
            numButtons[i] = new JButton(String.valueOf(i));
            numButtons[i].addActionListener(this);
            buttonPanel.add(numButtons[i]);
        }

        addButton = new JButton("+");
        addButton.addActionListener(this);
        buttonPanel.add(addButton);

        subtractButton = new JButton("-");
        subtractButton.addActionListener(this);
        buttonPanel.add(subtractButton);

        multiplyButton = new JButton("*");
        multiplyButton.addActionListener(this);
        buttonPanel.add(multiplyButton);

        divideButton = new JButton("/");
        divideButton.addActionListener(this);
        buttonPanel.add(divideButton);

        equalsButton = new JButton("=");
        equalsButton.addActionListener(this);
        buttonPanel.add(equalsButton);

        clearButton = new JButton("C");
        clearButton.addActionListener(this);
        buttonPanel.add(clearButton);

        mainPanel.add(buttonPanel, BorderLayout.CENTER);

        add(mainPanel);
        setVisible(true);
    }

    public static void main(String[] args) {
        new CalculatorApp();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == clearButton) {
            inputField.setText("");
            num1 = 0;
            num2 = 0;
            result = 0;
            operator = "";
        } else if (e.getSource() == addButton) {
            num1 = Double.parseDouble(inputField.getText());
            operator = "+";
            inputField.setText("");
        } else if (e.getSource() == subtractButton) {
            num1 = Double.parseDouble(inputField.getText());
            operator = "-";
            inputField.setText("");
        } else if (e.getSource() == multiplyButton) {
            num1 = Double.parseDouble(inputField.getText());
            operator = "*";
            inputField.setText("");
        } else if (e.getSource() == divideButton) {
            num1 = Double.parseDouble(inputField.getText());
            operator = "/";
            inputField.setText("");
        } else if (e.getSource() == equalsButton) {
            num2 = Double.parseDouble(inputField.getText());
            if (operator.equals("+")) {
                result = num1 + num2;
            } else if (operator.equals("-")) {
                result = num1 - num2;
            } else if (operator.equals("*")) {
                result = num1 * num2;
            } else if (operator.equals("/")) {
                result = num1 / num2;
            }
            inputField.setText(String.valueOf(result));
        } else {
            String currentInput = inputField.getText();
            String buttonInput = e.getActionCommand();
            inputField.setText(currentInput + buttonInput);
        }
    }
}
