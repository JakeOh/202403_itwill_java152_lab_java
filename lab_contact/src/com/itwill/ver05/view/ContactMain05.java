package com.itwill.ver05.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.itwill.ver05.controller.ContactDao;
import com.itwill.ver05.controller.ContactDaoImpl;
import com.itwill.ver05.model.Contact;
import com.itwill.ver05.view.ContactCreateFrame.CreateNotify;

public class ContactMain05 implements CreateNotify {
    
    private static final String[] COLUMN_NAMES = { "이름", "전화번호" };

    private ContactDao dao = ContactDaoImpl.getInstance();
    
    private JFrame frame;
    private JPanel buttonPanel;
    private JButton btnCreate;
    private JButton btnUpdate;
    private JButton btnDelete;
    private JButton btnSearch;
    private JScrollPane scrollPane;
    private JTable table;
    private DefaultTableModel model;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ContactMain05 window = new ContactMain05();
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
    public ContactMain05() {
        initialize(); // UI 컴포넌트들(버튼, 테이블, ...)을 생성, 초기화
        loadContactData(); // ContactDao를 사용해서 파일에 저장된 연락처 데이터를 테이블에 로딩.
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 560, 484);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("연락처 v0.5");
        
        buttonPanel = new JPanel();
        frame.getContentPane().add(buttonPanel, BorderLayout.NORTH);
        
        btnCreate = new JButton("새 연락처");
        btnCreate.addActionListener((e) -> 
                ContactCreateFrame.showContactCreateFrame(frame, ContactMain05.this)
        );
        btnCreate.setFont(new Font("D2Coding", Font.BOLD, 28));
        buttonPanel.add(btnCreate);
        
        btnUpdate = new JButton("업데이트");
        btnUpdate.setFont(new Font("D2Coding", Font.BOLD, 28));
        buttonPanel.add(btnUpdate);
        
        btnDelete = new JButton("삭제");
        btnDelete.setFont(new Font("D2Coding", Font.BOLD, 28));
        buttonPanel.add(btnDelete);
        
        btnSearch = new JButton("검색");
        btnSearch.setFont(new Font("D2Coding", Font.BOLD, 28));
        buttonPanel.add(btnSearch);
        
        scrollPane = new JScrollPane();
        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
        
        table = new JTable();
        model = new DefaultTableModel(null, COLUMN_NAMES);
        table.setModel(model);
        scrollPane.setViewportView(table);
    }
    
    private void loadContactData() {
        // DAO를 사용해서 파일에 저장된 데이터를 읽어옴.
        List<Contact> list = dao.read();
        
        // 리스트의 연락처들을 테이블에 행으로 추가.
        for (Contact c : list) {
            Object[] row = { c.getName(), c.getPhone() };
            model.addRow(row);
        }
        
    }

    @Override // ContactCreateFrame.CreateNotify 인터페이스의 메서드 재정의
    public void notifyContactCreated() {
        // 데이터를 모두 지운 새로운 테이블 모델 객체를 생성
        model = new DefaultTableModel(null, COLUMN_NAMES);
        // 파일에 저장된 연락처(새 연락처가 추가된 데이터)를 로딩
        loadContactData();
        // 새 테이블 모델을 테이블에 다시 세팅
        table.setModel(model);
        
        // 사용자에게 알림
        JOptionPane.showMessageDialog(frame, "새 연락처 저장 성공!");
    }

}
