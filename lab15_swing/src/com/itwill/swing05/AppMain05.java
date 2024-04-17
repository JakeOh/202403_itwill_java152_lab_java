package com.itwill.swing05;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AppMain05 {

    private JFrame frame;
    private JLabel lblName;
    private JTextField textName;
    private JTextField textPhone;
    private JLabel lblPhone;
    private JTextField textEmail;
    private JLabel lblEmail;
    private JButton btnInput;
    private JScrollPane scrollPane;
    private JTextArea textArea;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AppMain05 window = new AppMain05();
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
    public AppMain05() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 638, 575);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        
        lblName = new JLabel("이름");
        lblName.setFont(new Font("D2Coding", Font.BOLD, 32));
        lblName.setBounds(12, 10, 186, 64);
        frame.getContentPane().add(lblName);
        
        textName = new JTextField();
        textName.setFont(new Font("D2Coding", Font.PLAIN, 32));
        textName.setBounds(208, 10, 402, 64);
        frame.getContentPane().add(textName);
        textName.setColumns(10);
        
        lblPhone = new JLabel("전화번호");
        lblPhone.setFont(new Font("D2Coding", Font.BOLD, 32));
        lblPhone.setBounds(12, 84, 186, 64);
        frame.getContentPane().add(lblPhone);
        
        textPhone = new JTextField();
        textPhone.setFont(new Font("D2Coding", Font.PLAIN, 32));
        textPhone.setColumns(10);
        textPhone.setBounds(208, 84, 402, 64);
        frame.getContentPane().add(textPhone);
        
        lblEmail = new JLabel("이메일");
        lblEmail.setFont(new Font("D2Coding", Font.BOLD, 32));
        lblEmail.setBounds(12, 158, 186, 64);
        frame.getContentPane().add(lblEmail);
        
        textEmail = new JTextField();
        textEmail.setFont(new Font("D2Coding", Font.PLAIN, 32));
        textEmail.setColumns(10);
        textEmail.setBounds(208, 158, 402, 64);
        frame.getContentPane().add(textEmail);
        
        btnInput = new JButton("입력");
        btnInput.addActionListener(new ActionListener() { // 익명 내부 클래스
            @Override
            public void actionPerformed(ActionEvent e) {
                handleInputButtonClick();
            }
        });
        btnInput.setFont(new Font("D2Coding", Font.BOLD, 32));
        btnInput.setBounds(12, 232, 186, 64);
        frame.getContentPane().add(btnInput);
        
        scrollPane = new JScrollPane();
        scrollPane.setBounds(12, 306, 598, 220);
        frame.getContentPane().add(scrollPane);
        
        textArea = new JTextArea();
        textArea.setFont(new Font("D2Coding", Font.PLAIN, 32));
        scrollPane.setViewportView(textArea);
    }

    private void handleInputButtonClick() {
        // JTextField(이름, 전화번호, 이메일)에 입력된 문자열을 읽음.
        String name = textName.getText();
        String phone = textPhone.getText();
        String email = textEmail.getText();
        String msg = String.format("이름: %s, 전화번호: %s, 이메일: %s\n", 
                name, phone, email);
        
        // 이름, 전화번호, 이메일을 JTextArea에 씀.
//        textArea.setText(msg);
        textArea.append(msg); // 기존에 작성된 내용 끝에 추가.
        
        // 모든 JTexaField의 입력된 내용을 지움.
        textName.setText("");
        textPhone.setText("");
        textEmail.setText("");
    }
    
}
