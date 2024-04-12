package com.itwill.inner03;

import com.itwill.inner03.Button.OnClickListener;

public class InnerMain03 {

    public static void main(String[] args) {
        // 1. Button 타입 객체 생성
        Button btnOpen = new Button("열기");
        
        // 2. 생성된 버튼 객체가 할 일 정의 -> 리스너 객체를 생성하고 버튼에 세팅.
        OnClickListener listener = new OpenButtonListener(); // 다형성
        btnOpen.setOnClickListener(listener);
        
        // 3. 열기 버튼 클릭
        btnOpen.click();

        //----- 지역 클래스를 사용한 버튼 객체 생성 및 리스너 설정
        // 1. 버튼 생성
        Button btnClose = new Button("닫기");
        
        // 2. OnClickListener 구현하는 지역 클래스를 선언
        class CloseButtonListener implements OnClickListener {
            @Override
            public void onClick() {
                System.out.println("파일 닫기 실행");
            }
        }
        
        // 3. OnClickListener를 구현하는 클래스 타입 객체 생성하고 버튼에 리스너 설정.
//        OnClickListener closeListener = new CloseButtonListener();
//        btnClose.setOnClickListener(closeListener);
        btnClose.setOnClickListener(new CloseButtonListener());
        
        // 4. 닫기 버튼 클릭
        btnClose.click();
        
        
        //----- 익명 클래스를 사용한 버튼 객체 생성 및 리스너 설정 1
        // 1. 버튼 생성
        Button btnAdd = new Button("Add");
        
        // 2. 리스너 구현 객체 생성
        OnClickListener addListener = new OnClickListener() {
            @Override
            public void onClick() {
                System.out.println("추가하기");
            }
        };
        // 3. 버튼에 리스너 설정
        btnAdd.setOnClickListener(addListener);
        
        // 4. 버튼 클릭
        btnAdd.click();
        
        //----- 익명 클래스 2
        Button btnCancel = new Button("취소");
        btnCancel.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick() {
                System.out.println("취소하고 창 닫기");
            }
        });
        btnCancel.click();
        
        
    } // end main() 메서드

}
