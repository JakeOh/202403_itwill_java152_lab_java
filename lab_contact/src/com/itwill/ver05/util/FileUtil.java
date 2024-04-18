package com.itwill.ver05.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import com.itwill.ver05.model.Contact;

// 도우미 클래스(helper class): 파일 관련(read, write, 폴더 생성) 기능을 제공하는 클래스.
// 객체를 생성하지 못하도록 작성. 모든 메서드는 public static으로 작성.
public class FileUtil {
    public static final String DATA_DIR = "data"; // 데이터 파일을 저장할 폴더 이름
    public static final String DATA_FILE = "contacts.dat"; // 데이터 파일 이름
    
    // private 생성자 -> 다른 클래스에서 생성자를 호출할 수 없음(객체 생성을 할 수 없음).
    private FileUtil() {}
    
    /**
     * 연락처 데이터 파일을 저장하는 폴더가 생성되어 있지 않으면, 
     * 폴더를 새로 생성하고 File 타입 객체를 리턴.
     * 데이터 폴더가 이미 존재하면, 그 폴더의 File 객체를 리턴.
     * 
     * @return File 객체.
     */
    public static File initializeDataDir() {
        boolean result = false;
        
        File file = new File(DATA_DIR);
        
        if (file.exists()) { // 폴더가 이미 있는 경우
            System.out.println("데이터 폴더가 이미 있습니다...");
        } else { // 폴더가 없는 경우
            result = file.mkdir();
            if (result) {
                System.out.println("데이터 폴더 생성 성공");
            } else {
                System.out.println("데이터 폴더 생성 실패");
            }
        }
        
        return file;
    }
    
    /**
     * 연락처 리스트가 저장된 데이터 파일을 읽고, 그 결과를 List 타입으로 리턴.
     * 
     * @return 연락처 리스트(List<Contact>)
     */
    public static List<Contact> readDataFromFile() {
        List<Contact> list = null;
        
        File file = new File(DATA_DIR, DATA_FILE);
        try (
                FileInputStream in = new FileInputStream(file);
                BufferedInputStream bis = new BufferedInputStream(in);
                ObjectInputStream ois = new ObjectInputStream(bis);
        ) {
            list = (List<Contact>) ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return list;
    }
    
    /**
     * 연락처 리스트를 파일에 쓰기.
     * 
     * @param list 연락처 데이터를 저장하는 리스트(List<Contact>).
     */
    public static void writeDataToFile(List<Contact> list) {
        File file = new File(DATA_DIR, DATA_FILE);
        try (
                FileOutputStream out = new FileOutputStream(file);
                BufferedOutputStream bos = new BufferedOutputStream(out);
                ObjectOutputStream oos = new ObjectOutputStream(bos);
        ) {
            oos.writeObject(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     * 연락처 파일이 존재하면, 파일의 내용을 읽어서 리스트를 리턴.
     * 연락처 파일이 없으면, 빈(원소가 없는) 리스트를 리턴.
     * 
     * @return 연락처 리스트(List<Contact>).
     */
    public static List<Contact> initializeData() {
        List<Contact> list = new ArrayList<>();
        
        File file = new File(DATA_DIR, DATA_FILE);
        if (file.exists()) {
            list = readDataFromFile();
        }
        
        return list;
    }

}
