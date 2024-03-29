package com.itwill.inheritance02;

// 회사원은 사람이다. (BusinessPerson IS A Person.)
public class BusinessPerson extends Person {
    // 필드
    private String company;
    
    // 생성자
    public BusinessPerson() {
        System.out.println("BusinessPerson() 생성자");
    }
    
    public BusinessPerson(String company) {
//        super();
        this.company = company;
        System.out.println("BusinessPerson(company) 생성자");
    }
    
    public BusinessPerson(String name, String company) {
        super(name);
        this.company = company;
        System.out.println("BusinessPerson(name, company) 생성자");
    }
    
    // 메서드
    public String getCompany() {
        return this.company;
    }
    
    public void setCompany(String company) {
        this.company = company;
    }
    
}
