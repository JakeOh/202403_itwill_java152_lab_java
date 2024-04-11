package com.itwill.ver04.view;

import java.util.List;
import java.util.Scanner;

import com.itwill.ver04.controller.ContactDao;
import com.itwill.ver04.controller.ContactDaoImpl;
import com.itwill.ver04.model.Contact;

// View
public class ContactMain04 {
    
    private final Scanner scanner = new Scanner(System.in);
    private ContactDao dao = ContactDaoImpl.getInstance();
    
    public static void main(String[] args) {
        System.out.println("*** 연락처 프로그램 v0.4 ***");
        
        ContactMain04 app = new ContactMain04();
        
        boolean run = true;
        while (run) {
            int menu = app.selectMainMenu();
            switch (menu) {
            case 0:
                run = false;
                break;
            case 1:
                app.saveNewContact();
                break;
            case 2:
                app.readAllContacts();
                break;
            case 3:
                app.readContactByIndex();
                break;
            case 4:
                app.updateContactByIndex();
                break;
            case 5:
                app.deleteContactByIndex();
                break;
            default:
                System.out.println("메뉴 번호(0 ~ 5)를 확인하세요.");
            }
        }
        
        System.out.println("*** 프로그램 종료 ***");
    }
    
    private void deleteContactByIndex() {
        System.out.println("\n--- 연락처 삭제 ---");
        
        System.out.print("삭제할 인덱스>> ");
        int index = inputInteger();
        
        if (!((ContactDaoImpl) dao).isValidIndex(index)) {
            System.out.println("해당 인덱스에는 수정할 정보가 없습니다...");
            return;
        }
        
        int result = dao.delete(index);
        if (result == 1) {
            System.out.println(">>> 연락처 삭제 성공");
        } else {
            System.out.println(">>> 연락처 삭제 실패");
        }
    }
    
    private void updateContactByIndex() {
        System.out.println("\n--- 연락처 수정 ---");
        
        System.out.print("인덱스 입력>> ");
        int index = inputInteger();
        
        if (!((ContactDaoImpl) dao).isValidIndex(index)) {
            System.out.println("해당 인덱스에는 수정할 정보가 없습니다...");
            return;
        }
        
        Contact old = dao.read(index);
        System.out.println("수정전: " + old);
        
        System.out.print("이름 수정>> ");
        String name = scanner.nextLine();
        
        System.out.print("전화번호 수정>> ");
        String phone = scanner.nextLine();
        
        System.out.print("이메일 수정>> ");
        String email = scanner.nextLine();
        
        Contact updated = new Contact(0, name, phone, email);
        
        int result = dao.update(index, updated);
        if (result == 1) {
            System.out.println(">>> 연락처 수정 성공");
        } else {
            System.out.println(">>> 연락처 수정 실패");
        }
        
    }

    private void readContactByIndex() {
        System.out.println("\n--- 인덱스 검색 ---");
        
        System.out.print("인덱스 입력>> ");
        int index = inputInteger();
        
        if (!((ContactDaoImpl) dao).isValidIndex(index)) {
            System.out.println("해당 인덱스에는 연락처 정보가 없습니다.");
            return;
        }
        
        Contact contact = dao.read(index);
        if (contact != null) {
            System.out.println(contact);
        } else {
            System.out.println("해당 인덱스에는 연락처 정보가 없습니다.");
        }
    }
    
    private void readAllContacts() {
        System.out.println("\n--- 연락처 목록 ---");
        
        List<Contact> contacts = dao.read();
        int index = 0;
        for (Contact c : contacts) {
            System.out.println("[" + index + "] " + c);
            index++;
        }
    }
    
    private void saveNewContact() {
        System.out.println("\n--- 새 연락처 저장 ---");
        
        System.out.print("이름 입력>> ");
        String name = scanner.nextLine();
        
        System.out.print("전화번호 입력>> ");
        String phone = scanner.nextLine();
        
        System.out.print("이메일 입력>> ");
        String email = scanner.nextLine();
        
        Contact contact = new Contact(0, name, phone, email);
        int result = dao.create(contact);
        if (result == 1) {
            System.out.println(">>> 연락처 저장 성공");
        } else {
            System.out.println(">>> 연락처 저장 실패");
        }
        
    }
    
    private int selectMainMenu() {
        System.out.println("\n---------------------------------------------------");
        System.out.println("[0]종료 [1]저장 [2]목록 [3]인덱스검색 [4]수정 [5]삭제");
        System.out.println("---------------------------------------------------");
        System.out.print("선택> ");
        
        int menu = inputInteger();
        
        return menu;
    }
    
    private int inputInteger() {
        int result = 0;
        
        while(true) {
            try {
                result = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("입력값은 정수여야 합니다.");
                System.out.print("정수 입력>> ");
            }
        }
        
        return result;
    }

}
