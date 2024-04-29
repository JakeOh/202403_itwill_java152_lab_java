package com.itwill.jdbc.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.itwill.jdbc.controller.BlogDao;
import com.itwill.jdbc.model.Blog;

import java.awt.Font;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BlogMain {
    private static final String[] SEARCH_TYPES  = { 
            "제목", "내용", "제목+내용", "작성자" 
    };
    private static final String[] COLUMN_NAMES = {
            "번호", "제목", "작성자", "수정시간"
    };

    private JFrame frame;
    private JPanel searchPanel;
    private JComboBox<String> comboBox;
    private JTextField textSearchKeyword;
    private JButton btnSearch;
    private JPanel buttonPanel;
    private JButton btnReadAll;
    private JButton btnCreate;
    private JButton btnDetails;
    private JButton btnDelete;
    private JScrollPane scrollPane;
    private JTable table;
    private DefaultTableModel tableModel;
    
    private BlogDao dao = BlogDao.getInstance();

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    BlogMain window = new BlogMain();
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
    public BlogMain() {
        initialize();
        initializeTable();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 640, 560);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("블로그 메인");
        
        searchPanel = new JPanel();
        frame.getContentPane().add(searchPanel, BorderLayout.NORTH);
        
        comboBox = new JComboBox<>();
        final DefaultComboBoxModel<String> comboBoxModel = 
                new DefaultComboBoxModel<>(SEARCH_TYPES);
        comboBox.setModel(comboBoxModel);
        comboBox.setFont(new Font("D2Coding", Font.PLAIN, 28));
        searchPanel.add(comboBox);
        
        textSearchKeyword = new JTextField();
        textSearchKeyword.setFont(new Font("D2Coding", Font.PLAIN, 28));
        searchPanel.add(textSearchKeyword);
        textSearchKeyword.setColumns(10);
        
        btnSearch = new JButton("검색");
        btnSearch.setFont(new Font("D2Coding", Font.PLAIN, 28));
        searchPanel.add(btnSearch);
        
        buttonPanel = new JPanel();
        frame.getContentPane().add(buttonPanel, BorderLayout.SOUTH);
        
        btnReadAll = new JButton("목록보기");
        btnReadAll.setFont(new Font("D2Coding", Font.PLAIN, 28));
        buttonPanel.add(btnReadAll);
        
        btnCreate = new JButton("새 블로그");
        btnCreate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 새 블로그 작성 창 띄우기
                BlogCreateFrame.showBlogCreateFrame(frame);
            }
        });
        btnCreate.setFont(new Font("D2Coding", Font.PLAIN, 28));
        buttonPanel.add(btnCreate);
        
        btnDetails = new JButton("상세보기");
        btnDetails.setFont(new Font("D2Coding", Font.PLAIN, 28));
        buttonPanel.add(btnDetails);
        
        btnDelete = new JButton("삭제");
        btnDelete.setFont(new Font("D2Coding", Font.PLAIN, 28));
        buttonPanel.add(btnDelete);
        
        scrollPane = new JScrollPane();
        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
        
        table = new JTable();
        tableModel = new DefaultTableModel(null, COLUMN_NAMES);
        table.setModel(tableModel);
        scrollPane.setViewportView(table);
    }

    private void initializeTable() {
        // DAO를 사용해서 DB 테이블에서 검색.
        List<Blog> blogs = dao.read();
        
        // 검색한 내용을 JTable에 보여줌 - JTable의 테이블 모델을 재설정.
        tableModel = new DefaultTableModel(null, COLUMN_NAMES); // 테이블 모델 리셋.
        for (Blog b : blogs) {
            // DB 테이블에서 검색한 레코드를 JTable에서 사용할 행 데이터로 변환.
            Object[] row = {
                    b.getId(), b.getTitle(),
                    b.getWriter(), b.getModifiedTime(),
            };
            tableModel.addRow(row); // 테이블 모델에 행 데이터를 추가.
        }
        table.setModel(tableModel); // JTable의 모델을 다시 세팅.
    }
    
}
