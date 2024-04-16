package com.itwill.swing04;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AppMain04 {

    private JFrame frame;
    private JTextField textNumber1;
    private JTextField textNumber2;
    private JLabel label1;
    private JLabel label2;
    private JButton btnDivide;
    private JButton btnMultiply;
    private JButton btnMinus;
    private JButton btnPlus;
    private JTextArea textResult;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AppMain04 window = new AppMain04();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public AppMain04() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 502, 453);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        
        label1 = new JLabel("Number1");
        label1.setFont(new Font("D2Coding", Font.BOLD, 32));
        label1.setBounds(12, 10, 120, 64);
        frame.getContentPane().add(label1);
        
        textNumber1 = new JTextField();
        textNumber1.setFont(new Font("D2Coding", Font.PLAIN, 32));
        textNumber1.setBounds(144, 10, 320, 64);
        frame.getContentPane().add(textNumber1);
        textNumber1.setColumns(10);
        
        label2 = new JLabel("Number2");
        label2.setFont(new Font("D2Coding", Font.BOLD, 32));
        label2.setBounds(12, 84, 120, 64);
        frame.getContentPane().add(label2);
        
        textNumber2 = new JTextField();
        textNumber2.setFont(new Font("D2Coding", Font.PLAIN, 32));
        textNumber2.setColumns(10);
        textNumber2.setBounds(144, 84, 320, 64);
        frame.getContentPane().add(textNumber2);
        
        btnPlus = new JButton("+");
        btnPlus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double x = 0;
                double y = 0;
                try {
                    x = Double.parseDouble(textNumber1.getText());
                    y = Double.parseDouble(textNumber2.getText());
                } catch (NumberFormatException ex) {
                    textResult.setText("Number1 또는 Number2에는 숫자를 입력하세요.");
                    return;
                }
                double result = x + y;
                String msg = String.format("%f + %f = %f", x, y, result);
                textResult.setText(msg);
            }
        });
        btnPlus.setFont(new Font("D2Coding", Font.BOLD, 32));
        btnPlus.setBounds(12, 158, 64, 64);
        frame.getContentPane().add(btnPlus);
        
        btnMinus = new JButton("-");
        btnMinus.setFont(new Font("D2Coding", Font.BOLD, 32));
        btnMinus.setBounds(88, 158, 64, 64);
        frame.getContentPane().add(btnMinus);
        
        btnMultiply = new JButton("x");
        btnMultiply.setFont(new Font("D2Coding", Font.BOLD, 32));
        btnMultiply.setBounds(164, 158, 64, 64);
        frame.getContentPane().add(btnMultiply);
        
        btnDivide = new JButton("/");
        btnDivide.setFont(new Font("D2Coding", Font.BOLD, 32));
        btnDivide.setBounds(240, 158, 64, 64);
        frame.getContentPane().add(btnDivide);
        
        textResult = new JTextArea();
        textResult.setFont(new Font("D2Coding", Font.PLAIN, 32));
        textResult.setBounds(12, 232, 452, 157);
        frame.getContentPane().add(textResult);
    }
}
