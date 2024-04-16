package com.itwill.swing02;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class AppMain02 {

    private JFrame frame;
    private JTextField textInput;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AppMain02 window = new AppMain02();
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
    public AppMain02() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 705, 320);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null); // Absolute layout
        
        JLabel lblMessage = new JLabel("메시지를 입력하세요...");
        lblMessage.setFont(new Font("D2Coding", Font.PLAIN, 32));
        lblMessage.setBounds(12, 10, 665, 80);
        frame.getContentPane().add(lblMessage);
        
        textInput = new JTextField();
        textInput.setFont(new Font("D2Coding", Font.PLAIN, 32));
        textInput.setBounds(12, 100, 665, 80);
        frame.getContentPane().add(textInput);
        textInput.setColumns(10);
        
        JButton btnInput = new JButton("입력");
        btnInput.setFont(new Font("D2Coding", Font.PLAIN, 32));
        btnInput.setBounds(252, 190, 186, 80);
        frame.getContentPane().add(btnInput);
    }
}
