package com.itwill.class06;

public class ClassMain06 {

    public static void main(String[] args) {
        // Account 타입 객체 생성
        Account account1 = new Account(123456, 1000);
        account1.info();
        
        Account account2 = new Account(123789, 10000);
        account2.info();
        
        // account1 계좌에 10,000원 입금
        int result = account1.deposit(10_000);
        System.out.println("입금 후 잔액: " + result);
        
        // account1 계좌에서 5,000원 출금
        account1.withdraw(5_000);
        account1.info();
        
        // account1에서 account2으로 2,000원 이체
        account1.transfer(account2, 2_000);
        account1.info();
        account2.info();
        
        // account2에서 account1으로 10,000원 이체
        account2.transfer(account1, 10_000);
        account1.info();
        account2.info();

    }

}
