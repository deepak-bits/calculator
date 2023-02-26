/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.projects.calculator;

/**
 *
 * @author supermind
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener{
    JFrame frame;
    JTextField textfield;
    
    // create array to hold all the number buttons
    JButton[] numBtns = new JButton[10];
    
    // create array to hold all the function buttons
    JButton[] funcBtns = new JButton[9];
    
    // Function buttons
    JButton addBtn, subBtn, mulBtn, divBtn;
    JButton decBtn, equBtn, delBtn, clrBtn, negBtn;
    
    // 
    JPanel panel;

    // Set the font for the buttons and input text
    Font myFont = new Font("Monospace", Font.PLAIN, 30);

    /*
        Variables that will be used for calculations
        num1 - first operand 
        num2 - second operand
        operator - same as name
        result - final output value
    */
    double num1 = 0, num2 = 0, result = 0;
    char operator;

    // Constructor
    Calculator() {
        // Create the frame for calculator and set its bounds and properties
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 550);
        frame.setLayout(null);
        frame.getContentPane().setBackground(Color.ORANGE);

        // create a text field to show the input taken from user and also display the calculated value
        textfield = new JTextField();
        textfield.setBounds(50, 25, 300, 50);
        textfield.setFont(myFont);
        // Make the text field non-editable, as we don't want user to tinker with it directly
        textfield.setEditable(false);

        // Add the text to all the function btns that will displayed in UI
        addBtn = new JButton("+");
        subBtn = new JButton("-");
        mulBtn = new JButton("*");
        divBtn = new JButton("/");
        decBtn = new JButton(".");
        equBtn = new JButton("=");
        delBtn = new JButton("Del");
        clrBtn = new JButton("CE");
        negBtn = new JButton("(-)");

        // store the function buttons in the array made above
        funcBtns[0] = addBtn;
        funcBtns[1] = subBtn;
        funcBtns[2] = mulBtn;
        funcBtns[3] = divBtn;
        funcBtns[4] = decBtn;
        funcBtns[5] = equBtn;
        funcBtns[6] = delBtn;
        funcBtns[7] = clrBtn;
        funcBtns[8] = negBtn;

        // Add action listeners on the function buttons
        for(int i = 0; i < funcBtns.length; i++) {
            funcBtns[i].addActionListener(this);
            funcBtns[i].setFont(myFont);
            funcBtns[i].setFocusable(false);
        }

        // Add action listeners on the number buttons
        for(int i = 0; i < numBtns.length; i++) {
            numBtns[i] = new JButton(i + "");
            numBtns[i].addActionListener(this);
            numBtns[i].setFont(myFont);
            numBtns[i].setFocusable(false);
        }

        // Set bounds for the negative button, delete button and clear button
        // These btns will be displayed at the bottom separately
        negBtn.setBounds(50, 430, 100, 50);
        delBtn.setBounds(150, 430, 100, 50);
        clrBtn.setBounds(250, 430, 100, 50);

        // Create a JPanel and this panel will hold all the buttons and textfield
        panel = new JPanel();
        panel.setBounds(50, 100, 300, 300);
        panel.setLayout(new GridLayout(4, 4, 10, 10));
        panel.setBackground(Color.ORANGE);

        // add buttons to the panel
        panel.add(numBtns[1]);
        panel.add(numBtns[2]);
        panel.add(numBtns[3]);
        panel.add(addBtn);
        panel.add(numBtns[4]);
        panel.add(numBtns[5]);
        panel.add(numBtns[6]);
        panel.add(subBtn);
        panel.add(numBtns[7]);
        panel.add(numBtns[8]);
        panel.add(numBtns[9]);
        panel.add(mulBtn);
        panel.add(decBtn);
        panel.add(numBtns[0]);
        panel.add(equBtn);
        panel.add(divBtn);
        
        // Add panel, delete button, clear button and negation button to the JFrame
        frame.add(panel);
        frame.add(delBtn);
        frame.add(clrBtn);
        frame.add(negBtn);

        frame.add(textfield);
        frame.setVisible(true);
    }
    
    public static void main(String[] args) {
        // calling the constructor func from the main
        Calculator calc = new Calculator();
    }

    // Add Event Listeners
    @Override
    public void actionPerformed(ActionEvent e) {
        // Event listeners for all the numerical buttons
        // add the numbers to the input text when we click on them
        for(int i = 0; i < 10; i++) {
            if(e.getSource() == numBtns[i]) {
                textfield.setText(textfield.getText().concat(String.valueOf(i)));
            }
        }

        // Event listener for the decimal button
        // for adding decimal button, we check if there is already any decimal present in the input text
        if(e.getSource() == decBtn && !textfield.getText().contains(".")) {
            textfield.setText(textfield.getText().concat("."));
        }

        /*
            Add Event Listeners for add, subtract, multiply and divide buttons
            
            When these buttons are clicked, 
                -- we store the input value in a variable
                -- set operator sign
                -- clear text field
        */
        
        if(e.getSource() == addBtn) {
            num1 = Double.parseDouble(textfield.getText());
            operator = '+';
            textfield.setText("");
        }

        if(e.getSource() == subBtn) {
            num1 = Double.parseDouble(textfield.getText());
            operator = '-';
            textfield.setText("");
        }

        if(e.getSource() == mulBtn) {
            num1 = Double.parseDouble(textfield.getText());
            operator = '*';
            textfield.setText("");
        }

        if(e.getSource() == divBtn) {
            num1 = Double.parseDouble(textfield.getText());
            operator = '/';
            textfield.setText("");
        }

        /* 
            Event listener for the equal button
            
            -- store the present value in the input textfield in a variable
            -- check the operator sign
            -- using switch case statement to decide which operation to perform
            -- finally do the calculation
            -- set the calculated value in the JTextField

        */    
        
        if(e.getSource() == equBtn) {
            num2 = Double.parseDouble(textfield.getText());

            switch(operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    result = num1 / num2;
                    break;
            }
            if(result == (int) result) {
                textfield.setText(String.valueOf((int) result));
            } else {
                // handle case when the output value contains more digits that can fit in the text field
                String res = String.valueOf(result);
                if(res.length() > 15) {
                    textfield.setText(res.substring(0, 15));
                } else {
                    textfield.setText(res.substring(0, res.length()));
                }
                
            }
            num1 = result;
        }

        // resets the text field or clears the text field
        if(e.getSource() == clrBtn) {
            textfield.setText("");
        }


        // delete one character from the end
        if(e.getSource() == delBtn) {
            String str = textfield.getText();
            textfield.setText("");
            for(int i = 0; i < str.length() - 1; i++) {
                textfield.setText(textfield.getText() + str.charAt(i));
            }
        }

        // change sign of the input value
        if(e.getSource() == negBtn) {
            double temp = Double.parseDouble(textfield.getText());
            temp *= - 1;
            textfield.setText(String.valueOf(temp));
        }
    }
}
