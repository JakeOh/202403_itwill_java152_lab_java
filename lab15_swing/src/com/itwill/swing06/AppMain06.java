package com.itwill.swing06;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JRadioButton;
import java.awt.Font;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class AppMain06 {

    private JFrame frame;
    private JRadioButton rbPrivate;
    private JRadioButton rbPackage;
    private JRadioButton rbProtected;
    private JRadioButton rbPublic;
    private final ButtonGroup buttonGroup = new ButtonGroup();
    private JCheckBox cbAbstract;
    private JCheckBox cbFinal;
    private JCheckBox cbStatic;
    private JComboBox<String> comboBox;
    private JButton btnInfo;
    private JScrollPane scrollPane;
    private JTextArea textArea;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AppMain06 window = new AppMain06();
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
    public AppMain06() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 753, 457);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        
        rbPrivate = new JRadioButton("private");
        rbPrivate.setSelected(true);
        buttonGroup.add(rbPrivate);
        rbPrivate.setFont(new Font("D2Coding", Font.PLAIN, 32));
        rbPrivate.setBounds(8, 6, 172, 64);
        frame.getContentPane().add(rbPrivate);
        
        rbPackage = new JRadioButton("package");
        buttonGroup.add(rbPackage);
        rbPackage.setFont(new Font("D2Coding", Font.PLAIN, 32));
        rbPackage.setBounds(184, 6, 172, 64);
        frame.getContentPane().add(rbPackage);
        
        rbProtected = new JRadioButton("protected");
        buttonGroup.add(rbProtected);
        rbProtected.setFont(new Font("D2Coding", Font.PLAIN, 32));
        rbProtected.setBounds(363, 6, 172, 64);
        frame.getContentPane().add(rbProtected);
        
        rbPublic = new JRadioButton("public");
        buttonGroup.add(rbPublic);
        rbPublic.setFont(new Font("D2Coding", Font.PLAIN, 32));
        rbPublic.setBounds(539, 6, 172, 64);
        frame.getContentPane().add(rbPublic);
        
        cbAbstract = new JCheckBox("abstract");
        cbAbstract.setFont(new Font("D2Coding", Font.PLAIN, 32));
        cbAbstract.setBounds(8, 85, 172, 64);
        frame.getContentPane().add(cbAbstract);
        
        cbFinal = new JCheckBox("final");
        cbFinal.setFont(new Font("D2Coding", Font.PLAIN, 32));
        cbFinal.setBounds(184, 85, 172, 64);
        frame.getContentPane().add(cbFinal);
        
        cbStatic = new JCheckBox("static");
        cbStatic.setFont(new Font("D2Coding", Font.PLAIN, 32));
        cbStatic.setBounds(363, 85, 172, 64);
        frame.getContentPane().add(cbStatic);
        
        comboBox = new JComboBox<>(); // new JComboBox<String>();
        comboBox.setFont(new Font("D2Coding", Font.PLAIN, 32));
        final String[] emails = {"naver.com", "gmail.com", "kakao.com", "yahoo.com"};
        final DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>(emails);
        comboBox.setModel(model);
        comboBox.setBounds(8, 155, 348, 64);
        frame.getContentPane().add(comboBox);
        
        btnInfo = new JButton("확인");
        btnInfo.setFont(new Font("D2Coding", Font.PLAIN, 32));
        btnInfo.setBounds(363, 155, 172, 64);
        frame.getContentPane().add(btnInfo);
        
        scrollPane = new JScrollPane();
        scrollPane.setBounds(8, 229, 704, 159);
        frame.getContentPane().add(scrollPane);
        
        textArea = new JTextArea();
        textArea.setFont(new Font("D2Coding", Font.PLAIN, 32));
        scrollPane.setViewportView(textArea);
    }
}
