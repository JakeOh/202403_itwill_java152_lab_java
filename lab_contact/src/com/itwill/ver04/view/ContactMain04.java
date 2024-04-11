package com.itwill.ver04.view;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.itwill.ver04.model.Contact;
import com.itwill.ver04.util.FileUtil;

public class ContactMain04 {

    public static void main(String[] args) {
        // FileUtil 테스트
        File f = FileUtil.initializeDataDir();
        System.out.println(f);
        
//        FileUtil.readDataFromFile();
        List<Contact> list = FileUtil.initializeData();
        System.out.println(list);
        
        List<Contact> data = new ArrayList<Contact>();
        data.add(new Contact());
        FileUtil.writeDataToFile(data);

    }

}
