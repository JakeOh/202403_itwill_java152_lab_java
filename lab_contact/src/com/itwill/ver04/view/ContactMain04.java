package com.itwill.ver04.view;

import java.io.File;

import com.itwill.ver04.util.FileUtil;

public class ContactMain04 {

    public static void main(String[] args) {
        // FileUtil 테스트
        File f = FileUtil.initializeDataDir();
        System.out.println(f);

    }

}
