package com.itwill.swing08;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AppMain08 {
    private static final String[] COLUMN_NAMES = {
            "국어", "영어", "수학", "총점", "평균"
    };

    private JFrame frame;
    private JLabel lblKorean;
    private JTextField textKorean;
    private JTextField textEnglish;
    private JTextField textMath;
    private JLabel lblEnglish;
    private JLabel lblMath;
    private JButton btnEnter;
    private JScrollPane scrollPane;
    private JTable table;
    private DefaultTableModel model;
    private JButton btnDelete;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AppMain08 window = new AppMain08();
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
    public AppMain08() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 548, 540);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        
        lblKorean = new JLabel("국어");
        lblKorean.setFont(new Font("D2Coding", Font.BOLD, 32));
        lblKorean.setBounds(12, 10, 120, 64);
        frame.getContentPane().add(lblKorean);
        
        textKorean = new JTextField();
        textKorean.setFont(new Font("D2Coding", Font.PLAIN, 32));
        textKorean.setBounds(144, 10, 376, 64);
        frame.getContentPane().add(textKorean);
        textKorean.setColumns(10);
        
        lblEnglish = new JLabel("영어");
        lblEnglish.setFont(new Font("D2Coding", Font.BOLD, 32));
        lblEnglish.setBounds(12, 84, 120, 64);
        frame.getContentPane().add(lblEnglish);
        
        textEnglish = new JTextField();
        textEnglish.setFont(new Font("D2Coding", Font.PLAIN, 32));
        textEnglish.setColumns(10);
        textEnglish.setBounds(144, 84, 376, 64);
        frame.getContentPane().add(textEnglish);
        
        lblMath = new JLabel("수학");
        lblMath.setFont(new Font("D2Coding", Font.BOLD, 32));
        lblMath.setBounds(12, 158, 120, 64);
        frame.getContentPane().add(lblMath);
        
        textMath = new JTextField();
        textMath.setFont(new Font("D2Coding", Font.PLAIN, 32));
        textMath.setColumns(10);
        textMath.setBounds(144, 158, 376, 64);
        frame.getContentPane().add(textMath);
        
        btnEnter = new JButton("입력");
        btnEnter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inputScoreToTable();
            }
        });
        btnEnter.setFont(new Font("D2Coding", Font.BOLD, 32));
        btnEnter.setBounds(12, 232, 235, 64);
        frame.getContentPane().add(btnEnter);
        
        scrollPane = new JScrollPane();
        scrollPane.setBounds(12, 306, 508, 185);
        frame.getContentPane().add(scrollPane);
        
        table = new JTable();
        model = new DefaultTableModel(null, COLUMN_NAMES);
        table.setModel(model);
        scrollPane.setViewportView(table);
        
        btnDelete = new JButton("삭제");
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteScoreFromTable();
            }
        });
        btnDelete.setFont(new Font("D2Coding", Font.BOLD, 32));
        btnDelete.setBounds(285, 232, 235, 64);
        frame.getContentPane().add(btnDelete);
    }

    private void deleteScoreFromTable() {
        // JTable에서 선택된 행의 인덱스를 찾음.
        int index = table.getSelectedRow();
        if (index == -1) { // 테이블에서 선택된 행이 없을 때
            JOptionPane.showMessageDialog(frame, 
                    "테이블에서 삭제할 행을 먼저 선택하세요...", 
                    "경고", 
                    JOptionPane.WARNING_MESSAGE);
            
            return;
        }
        
        // 삭제 여부를 사용자에게 확인
        int confirm = JOptionPane.showConfirmDialog(
                frame, 
                "정말 삭제할까요?", 
                "삭제 확인", 
                JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            model.removeRow(index); // 테이블 (모델)에서 해당 인덱스의 행(row)를 삭제
        }
        
    }

    private void inputScoreToTable() {
        // 1. JTextField에서 3과목의 점수를 읽음.
        int korean = 0;
        int english = 0;
        int math = 0;
        try {
            korean = Integer.parseInt(textKorean.getText());
            english = Integer.parseInt(textEnglish.getText());
            math = Integer.parseInt(textMath.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, 
                    "국어, 영어, 수학 점수는 정수로 입력...", 
                    "입력 오류", 
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // 2. Score 타입 객체를 생성.
        Score score = new Score(korean, english, math);
        
        // 3. JTable에 행(row)을 추가.
        Object[] row = {
                score.getKorean(),
                score.getEnglish(),
                score.getMath(),
                score.getTotal(),
                score.getMean(),
        };
        model.addRow(row);
        
        // 4. JTextField의 내용을 모두 지움.
        clearAllTextFields();
    }
    
    private void clearAllTextFields() {
        textKorean.setText("");
        textEnglish.setText("");
        textMath.setText("");
    }
}
