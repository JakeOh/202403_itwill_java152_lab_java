package com.itwill.inheritance02;

// 회사원은 사람이다. (BusinessPerson IS A Person.)
public class BusinessPerson extends Person {
    // 필드
    private String company;
    
    // 생성자
    /*
     * 상위(부모) 타입 객체가 먼저 생성되어야 하위(자식) 타입의 객체를 생성할 수 있음.
     * 생성자 호출 순서: 상위클래스 생성자 -> 하위클래스 생성자 호출.
     * 하위클래스의 생성자에서 상위클래스의 생성자를 명시적으로 호출하지 않으면, 
     * 상위클래스의 "기본 생성자"가 자동으로 호출됨.
     * super(); 호출은 생략 가능.
     * 하위클래스의 생성자에서 상위클래스의 생성자를 명시적으로 호출할 때는 super 키워드를 사용.
     * 상위클래스의 아규먼트를 갖는 생성자는 자동으로 호출되지 않음.
     * 상위클래스의 아규먼트를 갖는 생성자를 호출하려면 반드시 super(...);를 호출해야만 함.
     * 생성자 코드 안에서 super(...) 호출은 가장 먼저 작성되어야 함.
     * 
     * this의 의미:
     * (1) 생성된 객체(인스턴스)의 참조값: this.field, this.method(...)
     * (2) 오버로딩(overloading)된 생성자: this(), this(...)
     * 
     * super의 의미:
     * (1) 생성된 상위 타입 객체의 참조값: super.field, super.method(...)
     * (2) 상위클래스의 생성자: super(), super(...)
     */
    
    public BusinessPerson() {
//        super();
        System.out.println("BusinessPerson() 생성자");
    }
    
    public BusinessPerson(String company) {
//        super();
        this.company = company;
        System.out.println("BusinessPerson(company) 생성자");
    }
    
    public BusinessPerson(String name, String company) {
        super(name); // 상위클래스의 아규먼트가 1개인 생성자를 "명시적"으로 호출.
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
