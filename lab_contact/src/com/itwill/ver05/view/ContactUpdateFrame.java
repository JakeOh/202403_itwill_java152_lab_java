package com.itwill.ver05.view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.itwill.ver05.controller.ContactDao;
import com.itwill.ver05.controller.ContactDaoImpl;
import com.itwill.ver05.model.Contact;

public class ContactUpdateFrame extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JPanel contentPanel;
    private JPanel buttonPanel;
    private JButton btnSave;
    private JButton btnCancel;
    private JLabel lblName;
    private JTextField textName;
    private JTextField textPhone;
    private JTextField textEmail;
    private JLabel lblPhone;
    private JLabel lblEmail;

    private Component parentComponent; // 부모 컴포넌트를 저장하기 위해서
    private int index; // 업데이트할 연락처의 (리스트) 인덱스를 저장하기 위해서
    
    private ContactDao dao = ContactDaoImpl.getInstance();
    
    /**
     * Launch the application.
     */
    public static void showContactUpdateFrame(Component parentComponent, int index) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ContactUpdateFrame frame = new ContactUpdateFrame(parentComponent, index);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public ContactUpdateFrame(Component parentComponent, int index) {
        this.parentComponent = parentComponent;
        this.index = index;
        initialize();
        initializeTextFields();
    }
    
    private void initializeTextFields() {
        // 3개의 텍스트필드에 해당 인덱스의 연락처 정보를 채움.
        Contact contact = dao.read(index);
        textName.setText(contact.getName());
        textPhone.setText(contact.getPhone());
        textEmail.setText(contact.getEmail());
    }
    
    public void initialize() {
        setTitle("연락처 업데이트");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        int x = 0;
        int y = 0;
        if (parentComponent != null) {
            x = parentComponent.getX();
            y = parentComponent.getY();
        }
        setBounds(x, y, 542, 367);
        
        if (parentComponent == null) {
            setLocationRelativeTo(null);
        }
        
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));
        
        contentPanel = new JPanel();
        contentPane.add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(null);
        
        lblName = new JLabel("이름");
        lblName.setFont(new Font("D2Coding", Font.PLAIN, 28));
        lblName.setBounds(12, 10, 121, 64);
        contentPanel.add(lblName);
        
        textName = new JTextField();
        textName.setFont(new Font("D2Coding", Font.PLAIN, 28));
        textName.setBounds(145, 10, 359, 64);
        contentPanel.add(textName);
        textName.setColumns(10);
        
        lblPhone = new JLabel("전화번호");
        lblPhone.setFont(new Font("D2Coding", Font.PLAIN, 28));
        lblPhone.setBounds(12, 84, 121, 64);
        contentPanel.add(lblPhone);
        
        textPhone = new JTextField();
        textPhone.setFont(new Font("D2Coding", Font.PLAIN, 28));
        textPhone.setColumns(10);
        textPhone.setBounds(145, 84, 359, 64);
        contentPanel.add(textPhone);
        
        lblEmail = new JLabel("이메일");
        lblEmail.setFont(new Font("D2Coding", Font.PLAIN, 28));
        lblEmail.setBounds(12, 158, 121, 64);
        contentPanel.add(lblEmail);
        
        textEmail = new JTextField();
        textEmail.setFont(new Font("D2Coding", Font.PLAIN, 28));
        textEmail.setColumns(10);
        textEmail.setBounds(145, 158, 359, 64);
        contentPanel.add(textEmail);
        
        buttonPanel = new JPanel();
        contentPane.add(buttonPanel, BorderLayout.SOUTH);
        
        btnSave = new JButton("저장");
        btnSave.setFont(new Font("D2Coding", Font.PLAIN, 28));
        buttonPanel.add(btnSave);
        
        btnCancel = new JButton("취소");
        btnCancel.setFont(new Font("D2Coding", Font.PLAIN, 28));
        buttonPanel.add(btnCancel);
    }
}
