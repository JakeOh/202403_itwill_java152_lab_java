package com.itwill.jdbc.view;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.itwill.jdbc.controller.BlogDao;
import com.itwill.jdbc.model.Blog;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BlogDetailsFrame extends JFrame {
    
    public interface UpdateNotify {
        public void notifyUpdateSuccess();
    }

    private static final long serialVersionUID = 1L;
    
    private BlogDao dao = BlogDao.getInstance();
    private Component parent;
    private int blogId;
    private UpdateNotify app;
    
    private JPanel contentPane;
    private JLabel lblId;
    private JTextField textId;
    private JLabel lblTitle;
    private JTextField textTitle;
    private JLabel lblContent;
    private JScrollPane scrollPane;
    private JTextArea textContent;
    private JLabel lblWriter;
    private JTextField textWriter;
    private JLabel lblCreated;
    private JTextField textCreated;
    private JLabel lblModified;
    private JTextField textModified;
    private JButton btnUpdate;
    private JButton btnCancel;

    /**
     * Launch the application.
     */
    public static void showBlogDetailsFrame(Component parent, int blogId, UpdateNotify app) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    BlogDetailsFrame frame = new BlogDetailsFrame(parent, blogId, app);
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
    public BlogDetailsFrame(Component parent, int blogId, UpdateNotify app) {
        this.parent = parent;
        this.blogId = blogId;
        this.app = app;
        
        initialize();
        initializeBlog();
    }
    
    private void initialize() {
        setTitle("블로그 상세보기");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        int x = 0;
        int y = 0;
        if (parent != null) {
            x = parent.getX();
            y = parent.getY();
        }
        setBounds(x, y, 450, 682);
        
        if (parent == null) {
            setLocationRelativeTo(null);
        }
        
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        lblId = new JLabel("번호");
        lblId.setFont(new Font("D2Coding", Font.BOLD, 28));
        lblId.setBounds(12, 10, 121, 48);
        contentPane.add(lblId);
        
        textId = new JTextField();
        textId.setEditable(false);
        textId.setFont(new Font("D2Coding", Font.PLAIN, 28));
        textId.setBounds(145, 10, 277, 48);
        contentPane.add(textId);
        textId.setColumns(10);
        
        lblTitle = new JLabel("제목");
        lblTitle.setFont(new Font("D2Coding", Font.BOLD, 28));
        lblTitle.setBounds(12, 68, 121, 48);
        contentPane.add(lblTitle);
        
        textTitle = new JTextField();
        textTitle.setFont(new Font("D2Coding", Font.PLAIN, 28));
        textTitle.setColumns(10);
        textTitle.setBounds(145, 68, 277, 48);
        contentPane.add(textTitle);
        
        lblContent = new JLabel("내용");
        lblContent.setFont(new Font("D2Coding", Font.BOLD, 28));
        lblContent.setBounds(12, 126, 121, 48);
        contentPane.add(lblContent);
        
        scrollPane = new JScrollPane();
        scrollPane.setBounds(12, 184, 410, 200);
        contentPane.add(scrollPane);
        
        textContent = new JTextArea();
        textContent.setFont(new Font("D2Coding", Font.PLAIN, 28));
        scrollPane.setViewportView(textContent);
        
        lblWriter = new JLabel("작성자");
        lblWriter.setFont(new Font("D2Coding", Font.BOLD, 28));
        lblWriter.setBounds(12, 394, 121, 48);
        contentPane.add(lblWriter);
        
        textWriter = new JTextField();
        textWriter.setEditable(false);
        textWriter.setFont(new Font("D2Coding", Font.PLAIN, 28));
        textWriter.setColumns(10);
        textWriter.setBounds(145, 394, 277, 48);
        contentPane.add(textWriter);
        
        lblCreated = new JLabel("작성시간");
        lblCreated.setFont(new Font("D2Coding", Font.BOLD, 28));
        lblCreated.setBounds(12, 452, 121, 48);
        contentPane.add(lblCreated);
        
        textCreated = new JTextField();
        textCreated.setFont(new Font("D2Coding", Font.PLAIN, 28));
        textCreated.setEditable(false);
        textCreated.setColumns(10);
        textCreated.setBounds(145, 452, 277, 48);
        contentPane.add(textCreated);
        
        lblModified = new JLabel("수정시간");
        lblModified.setFont(new Font("D2Coding", Font.BOLD, 28));
        lblModified.setBounds(12, 510, 121, 48);
        contentPane.add(lblModified);
        
        textModified = new JTextField();
        textModified.setFont(new Font("D2Coding", Font.PLAIN, 28));
        textModified.setEditable(false);
        textModified.setColumns(10);
        textModified.setBounds(145, 510, 277, 48);
        contentPane.add(textModified);
        
        btnUpdate = new JButton("업데이트");
        btnUpdate.addActionListener((e) -> updateBlog());
        btnUpdate.setFont(new Font("D2Coding", Font.PLAIN, 28));
        btnUpdate.setBounds(12, 568, 176, 48);
        contentPane.add(btnUpdate);
        
        btnCancel = new JButton("취소");
        btnCancel.addActionListener((e) -> dispose());
        btnCancel.setFont(new Font("D2Coding", Font.PLAIN, 28));
        btnCancel.setBounds(200, 568, 176, 48);
        contentPane.add(btnCancel);
    }
    
    private void initializeBlog() {
        Blog blog = dao.read(blogId);
        if (blog == null) return;
        
        textId.setText(blogId + "");
        textTitle.setText(blog.getTitle());
        textContent.setText(blog.getContent());
        textWriter.setText(blog.getWriter());
        textCreated.setText(blog.getCreatedTime().toString());
        textModified.setText(blog.getModifiedTime().toString());
    }
    
    private void updateBlog() {
        String title = textTitle.getText();
        String content = textContent.getText();
        if (title.equals("") || title.equals("")) {
            JOptionPane.showMessageDialog(this, 
                    "제목과 내용은 반드시 입력해야 합니다.", 
                    "경고", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        Blog blog = new Blog(blogId, title, content, null, null, null);
        int result = dao.update(blog);
        if (result == 1) {
            app.notifyUpdateSuccess();
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "업데이트 실패");
        }
    }

}
