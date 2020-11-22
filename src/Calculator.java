package year2end.calculator.calculator.calculator.src;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.math.BigDecimal;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Calculator {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setVisible(true);
        frame.setSize(300, 330);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Calculator");
        frame.setResizable(false);
        frame.getContentPane().setLayout(null);
        JTextField textField = new JTextField();
        textField.setBounds(15, 10, 258, 34);
        frame.getContentPane().add(textField);
        textField.setColumns(15);
        JButton button1 = new JButton("1");
        frame.getContentPane().add(button1);
        button1.setBounds(15, 168, 61, 53);
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textField.setText(textField.getText() + 1);
            }
        });
        JButton button2 = new JButton("2");
        frame.getContentPane().add(button2);
        button2.setBounds(80, 168, 61, 53);
        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e1) {
                textField.setText(textField.getText() + 2);
            }
        });
        JButton button3 = new JButton("3");
        frame.getContentPane().add(button3);
        button3.setBounds(145, 168, 61, 53);
        button3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e2) {
                textField.setText(textField.getText() + 3);
            }
        });
        JButton button4 = new JButton("4");
        button4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e3) {
                textField.setText(textField.getText() + 4);
            }
        });
        JButton button5 = new JButton("5");
        button5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e4) {
                textField.setText(textField.getText() + 5);
            }
        });
        frame.getContentPane().add(button5);
        button5.setBounds(80, 112, 61, 53);
        frame.getContentPane().add(button4);
        button4.setBounds(15, 112, 61, 53);
        JButton button6 = new JButton("6");
        button6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e5) {
                textField.setText(textField.getText() + 6);
            }
        });
        frame.getContentPane().add(button6);
        button6.setBounds(145, 112, 61, 53);
        JButton button7 = new JButton("7");
        button7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e6) {
                textField.setText(textField.getText() + 7);
            }
        });
        frame.getContentPane().add(button7);
        button7.setBounds(15, 56, 61, 53);
        JButton button8 = new JButton("8");
        button8.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e7) {
                textField.setText(textField.getText() + 8);
            }
        });
        frame.getContentPane().add(button8);
        button8.setBounds(80, 56, 61, 53);
        JButton button9 = new JButton("9");
        button9.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e8) {
                textField.setText(textField.getText() + 9);
            }
        });
        frame.getContentPane().add(button9);
        button9.setBounds(145, 56, 61, 53);
        JButton button0 = new JButton("0");
        button0.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e10) {
                textField.setText(textField.getText() + 0);
            }
        });
        frame.getContentPane().add(button0);
        button0.setBounds(80, 224, 61, 53);
        JButton buttonClear = new JButton("C");
        buttonClear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e9) {
                textField.setText("");
            }
        });
        frame.getContentPane().add(buttonClear);
        buttonClear.setBounds(15, 224, 61, 53);
        JButton buttonDivide = new JButton("/");
        buttonDivide.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e15) {
                textField.setText(textField.getText() + "/");
            }
        });
        frame.getContentPane().add(buttonDivide);
        buttonDivide.setBounds(210, 56, 61, 53);
        JButton buttonMultiply = new JButton("*");
        buttonMultiply.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e14) {
                textField.setText(textField.getText() + "*");
            }
        });
        frame.getContentPane().add(buttonMultiply);
        buttonMultiply.setBounds(210, 112, 61, 53);
        JButton buttonMinus = new JButton("-");
        buttonMinus.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e13) {
                textField.setText(textField.getText() + "-");
            }
        });
        frame.getContentPane().add(buttonMinus);
        buttonMinus.setBounds(210, 168, 61, 53);
        JButton buttonPlus = new JButton("+");
        buttonPlus.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e12) {
                textField.setText(textField.getText() + "+");
            }
        });
        frame.getContentPane().add(buttonPlus);
        buttonPlus.setBounds(210, 224, 61, 53);
        JButton buttonEnter = new JButton("=");
        frame.getRootPane().setDefaultButton(buttonEnter);
        textField.requestFocus();
        buttonEnter.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e11) {
                try {
                    System.out.println("Result: " + executeExpression(textField.getText()));
                    textField.setText(String.valueOf(executeExpression(textField.getText())));
                } catch (Exception e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(null, "please enter correct expression");
                }
            }
        });
        frame.getContentPane().add(buttonEnter);
        buttonEnter.setBounds(145, 224, 61, 53);
    }

    public static double executeExpression(String str) {
        str = str.replaceAll(" ", "");
        return Double.parseDouble(recursion(str));
    }

    private static String recursion(String str) {
        if (str.contains("(")) {
            int closingParenthesisIndex = str.indexOf(")");
            int openingParenthesisIndex = str.lastIndexOf("(", closingParenthesisIndex);
            return recursion(str.substring(0, openingParenthesisIndex)
                    + recursion(str.substring(openingParenthesisIndex + 1, closingParenthesisIndex))
                    + str.substring(closingParenthesisIndex + 1, str.length()));
        } else if (str.contains("*") || str.contains("/")) {
            int multiplyIndex = str.indexOf("*");
            int divideIndex = str.indexOf("/");
            if (multiplyIndex == -1)
                multiplyIndex = Integer.MAX_VALUE;
            if (divideIndex == -1)
                divideIndex = Integer.MAX_VALUE;
            if (multiplyIndex <= divideIndex) {
                int operand2End = findOperandEnd(str.substring(multiplyIndex + 1, str.length())) + multiplyIndex + 1;
                int operand1Start = findOperandStart(str.substring(0, multiplyIndex));
                double operand1 = Double.parseDouble(str.substring(operand1Start, multiplyIndex));
                double operand2 = Double.parseDouble(str.substring(multiplyIndex + 1, operand2End));
                String execute = new BigDecimal(operand1 * operand2).toPlainString();
                return recursion(str.substring(0, operand1Start) + execute + str.substring(operand2End, str.length()));
            } else {
                int operand2End = findOperandEnd(str.substring(divideIndex + 1, str.length())) + divideIndex + 1;
                int operand1Start = findOperandStart(str.substring(0, divideIndex));
                double operand1 = Double.parseDouble(str.substring(operand1Start, divideIndex));
                double operand2 = Double.parseDouble(str.substring(divideIndex + 1, operand2End));
                String execute = new BigDecimal(operand1 / operand2).toPlainString();
                return recursion(str.substring(0, operand1Start) + execute + str.substring(operand2End, str.length()));
            }
        } else if (str.contains("+") || str.contains("-")) {
            int plusIndex = str.indexOf("+");
            int minusIndex = str.indexOf("-");
            if (plusIndex == -1)
                plusIndex = Integer.MAX_VALUE;
            if (minusIndex == -1)
                minusIndex = Integer.MAX_VALUE;
            if (plusIndex <= minusIndex) {
                int operand2End = findOperandEnd(str.substring(plusIndex + 1, str.length())) + plusIndex + 1;
                int operand1Start = findOperandStart(str.substring(0, plusIndex));
                double operand1 = Double.parseDouble(str.substring(operand1Start, plusIndex));
                double operand2 = Double.parseDouble(str.substring(plusIndex + 1, operand2End));
                String execute = new BigDecimal(operand1 + operand2).toPlainString();
                return recursion(str.substring(0, operand1Start) + execute + str.substring(operand2End, str.length()));
            } else {
                int operand2End = findOperandEnd(str.substring(minusIndex + 1, str.length())) + minusIndex + 1;
                int operand1Start = findOperandStart(str.substring(0, minusIndex));
                double operand1 = Double.parseDouble(str.substring(operand1Start, minusIndex));
                double operand2 = Double.parseDouble(str.substring(minusIndex + 1, operand2End));
                String execute = new BigDecimal(operand1 - operand2).toPlainString();
                return recursion(str.substring(0, operand1Start) + execute + str.substring(operand2End, str.length()));
            }
        } else
            return str;
    }

    private static int findOperandStart(String str) {
        char[] expression = str.toCharArray();
        for (int i = expression.length - 1; i >= 0; i--)
            if (!Character.isDigit(expression[i]) && expression[i] != '.' && expression[i] != '-')
                return i + 1;
        return 0;
    }

    private static int findOperandEnd(String str) {
        char[] expression = str.toCharArray();
        for (int i = 0; i < expression.length; i++)
            if (!Character.isDigit(expression[i]) && expression[i] != '.' && expression[i] != '-')
                return i;
        return expression.length;
    }
}
