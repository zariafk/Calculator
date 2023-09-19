import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener {

    //COMPONENTS
    JFrame frame;
    JTextField textField;
    JButton [] numberButtons = new JButton [10];
    JButton [] functionButtons = new JButton[9];
    JButton addButton, subButton, mulButton, divButton, decButton, equButton, delButton, clrButton, negButton;
    JPanel panel;
    JPanel colourPanel;

    Color purple = new Color(102, 102, 255);
    Color blue = new Color(204, 255, 255);
    Font font = new Font("Monospace", Font.BOLD, 30);
    double num1 = 0, num2 = 0, ans = 0;
    char operator;

    Calculator() {

        //FRAME
        frame = new JFrame("Zaria's Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 550);
        frame.setLayout(null);

        //TEXT FIELD
        textField = new JTextField();
        textField.setBounds(50, 25, 300, 50);
        textField.setFont(font);
        textField.setBackground(blue);
        textField.setEditable(false);

        //BUTTONS
        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("DEL");
        clrButton = new JButton("CLR");
        negButton = new JButton("(-)");

        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decButton;
        functionButtons[5] = equButton;
        functionButtons[6] = delButton;
        functionButtons[7] = clrButton;
        functionButtons[8] = negButton;

        for (int i = 0; i < 9; i++) {
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(font);
            functionButtons[i].setBackground(blue);
            functionButtons[i].setFocusable(false);
        }

        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(font);
            numberButtons[i].setBackground(blue);
            numberButtons[i].setFocusable(false);
        }

        negButton.setBounds(50, 430, 100, 50);
        delButton.setBounds(150, 430, 100, 50);
        clrButton.setBounds(250, 430, 100, 50);

        //PANEL
        panel = new JPanel();
        panel.setBounds(50, 100, 300, 300);
        panel.setBackground(purple);
        panel.setLayout(new GridLayout(4, 4, 10, 10));

        //STYLING
        colourPanel = new JPanel();
        colourPanel.setBounds(0, 0, 420, 550);
        colourPanel.setBackground(purple);

        //ADDING COMPONENTS
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);
        panel.add(decButton);
        panel.add(numberButtons[0]);
        panel.add(equButton);
        panel.add(divButton);

        
        frame.add(panel);
        frame.add(negButton);
        frame.add(delButton);
        frame.add(clrButton);
        frame.add(textField);
        frame.add(colourPanel);
        frame.setVisible(true);

    }

    public static void main(String[] args) {
        Calculator calc = new Calculator();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        //FUNCTIONALITY
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]) {
                textField.setText(textField.getText().concat(String.valueOf(i)));

            }
        }

        if (e.getSource() == decButton) {
            textField.setText(textField.getText().concat("."));
        }

        if (e.getSource() == addButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText("");
        }

        if (e.getSource() == subButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText("");
        }

        if (e.getSource() == mulButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '*';
            textField.setText("");
        }

        if (e.getSource() == divButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText("");
        }

        if (e.getSource() == equButton) {
            num2 = Double.parseDouble(textField.getText());
            switch(operator) {
                case '+' :
                    ans = num1 + num2;
                    break;
                
                case '-' :
                    ans = num1 - num2;
                    break;

                case '*' :
                    ans = num1 * num2;
                    break;
                
                case '/' :
                    ans = num1 / num2;
                    break;
            }
            textField.setText(String.valueOf(ans));
            num1 = ans;
        }

        if (e.getSource() == negButton) {
            Double temp = Double.parseDouble(textField.getText());
            temp*=-1;
            textField.setText(String.valueOf(temp));
        }

        if (e.getSource() == clrButton) {
            textField.setText("");
        }

        if (e.getSource() == delButton) {
            String string = textField.getText();
            textField.setText("");

            for (int i = 0; i < string.length()-1; i++) {
                textField.setText(textField.getText() + string.charAt(i));
            }
        }
    }
}