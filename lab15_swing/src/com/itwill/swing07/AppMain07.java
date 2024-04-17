package com.itwill.swing07;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AppMain07 {

    private JFrame frame;
    private JButton btnMsgDlg;
    private JButton btnConfirmDlg;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AppMain07 window = new AppMain07();
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
    public AppMain07() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 478);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        
        btnMsgDlg = new JButton("Message Dialog");
        btnMsgDlg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 메시지 다이얼로그 보여주기
//                JOptionPane.showMessageDialog(frame, "안녕하세요.");
                JOptionPane.showMessageDialog(
                        frame,                      // 부모 컴포넌트
                        "안녕하세요, Swing!",       // 다이얼로그 메시지
                        "메시지",                   // 다이얼로그 타이틀(제목)
                        JOptionPane.INFORMATION_MESSAGE); // 메시지 타입 -> 메시지 아이콘
            }
        });
        btnMsgDlg.setFont(new Font("D2Coding", Font.BOLD, 32));
        btnMsgDlg.setBounds(12, 10, 410, 64);
        frame.getContentPane().add(btnMsgDlg);
        
        btnConfirmDlg = new JButton("Confirm Dialog");
        btnConfirmDlg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Confirm(확인) 다이얼로그 보여주기
//                int result = JOptionPane.showConfirmDialog(frame, "정말 삭제할까요?");
                int result = JOptionPane.showConfirmDialog(
                        frame,                         // 부모 컴포넌트
                        "정말 삭제할까요?",            // 메시지
                        "삭제 확인",                   // 타이틀
                        JOptionPane.YES_NO_OPTION,     // 옵션 타입(버튼 종류, 개수)
                        JOptionPane.QUESTION_MESSAGE); // 메시지 타입
                
                btnConfirmDlg.setText("confirm=" + result);
            }
        });
        btnConfirmDlg.setFont(new Font("D2Coding", Font.BOLD, 32));
        btnConfirmDlg.setBounds(12, 84, 410, 64);
        frame.getContentPane().add(btnConfirmDlg);
    }

}
