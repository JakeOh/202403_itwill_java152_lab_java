package com.itwill.lambda04;

import java.util.Arrays;
import java.util.List;

public class LambdaMain04 {

    public static void main(String[] args) {
        // 사원(Employee)들의 리스트
        List<Employee> employees = Arrays.asList(
                new Employee(101, "김지현", "개발1팀", "과장", 700),
                new Employee(102, "이동준", "개발2팀", "부장", 800),
                new Employee(103, "이승행", "개발1팀", "대리", 500),
                new Employee(104, "정윤정", "개발2팀", "부장", 1_000),
                new Employee(105, "김동환", "인사팀", "회장", 30_000),
                new Employee(106, "노형진", "인사팀", "차장", 900),
                new Employee(107, "오쌤", "총무", "대리", 300)
        );
        
        // Ex1. 모든 직원들의 정보를 한 줄에 한 명씩 출력
        System.out.println("--- Ex1. ---");
//        for (Employee e : employees) {
//            System.out.println(e);
//        }
//        employees.forEach((x) -> System.out.println(x));
        employees.forEach(System.out::println);
        
        // Ex2. 개발(1, 2)팀에서 일하는 직원들의 급여 합계
        // Ex3. 개발팀에서 일하는 직원들의 급여 평균
        System.out.println("--- Ex2. Ex3. ---");
        double sum = 0.0; // 급여 합계를 저장하기 위한 변수
        int count = 0; // 개발팀 직원수를 저장하기 위한 변수
        for (Employee e : employees) { // 리스트의 모든 직원들을 순서대로 반복
            if (e.getDept().contains("개발")) { // 직원의 부서 이름이 "개발"을 포함하면
                sum += e.getSalary(); // 개발팀 직원의 급여를 더함.
                count++; // 직원수 증가
            }
        }
        System.out.println("합계=" + sum);
        System.out.println("평균=" + (sum / count));
        
        sum = employees.stream()
                .filter((x) -> x.getDept().contains("개발"))
                .mapToDouble((x) -> x.getSalary())
                .sum();
        System.out.println("sum=" + sum);
        
        double mean = employees.stream()
                .filter((e) -> e.getDept().contains("개발"))
//                .mapToDouble((e) -> e.getSalary())
                .mapToDouble(Employee::getSalary)
                .average() // 리턴 타입: OptionalDouble
                .orElseThrow(); // 평균을 계산할 수 있으면 double 값을 리턴, 그렇지 않으면 예외를 발생.
        System.out.println("mean=" + mean);
        
        // Ex4. 직급이 부장인 직원들의 급여 합계
        // Ex5. 직급이 부장인 직원들의 급여 평균
        System.out.println("--- Ex4. Ex5. ---");
        
        sum = 0.0;
        mean = 0.0;
        count = 0;
        for (Employee e : employees) {
            if (e.getJobTitle().equals("부장")) {
                sum += e.getSalary();
                count++;
            }
        }
        System.out.println("합계=" + sum);
        
        mean = sum / count;
        System.out.println("평균=" + mean);
        
        sum = employees.stream()
                .filter((e) -> e.getJobTitle().equals("부장"))
                .mapToDouble((e) -> e.getSalary())
                .sum();
        System.out.println("sum=" + sum);
        
        mean = employees.stream()
                .filter((e) -> e.getJobTitle().equals("부장"))
                .mapToDouble((e) -> e.getSalary())
                .average()
                .orElseThrow();
        System.out.println("mean=" + mean);
        
        // Ex6. 급여가 1,000 이상인 직원들의 정보를 한 줄에 한 명씩 출력
        System.out.println("--- Ex6. ---");
        employees.stream()
                .filter((e) -> e.getSalary() >= 1_000)
                .forEach(System.out::println); // e -> System.out.println(e)
        
        // Ex7. 개발1팀 직원들의 급여를 10% 인상하고, 인상된 급여의 평균
        System.out.println("--- Ex7. ---");
        
        sum = 0.0; // 개발1팀 직원들의 (10% 인상한) 급여 합계
        count = 0;
        for (Employee e : employees) {
            if (e.getDept().equals("개발1팀")) {
                sum += e.getSalary() * 1.1;
                count++;
            }
        }
        mean = sum / count;
        System.out.println("mean=" + mean);
        
        mean = employees.stream()
                .filter((e) -> e.getDept().equals("개발1팀"))
                .mapToDouble((e) -> e.getSalary() * 1.1)
                .average()
                .orElseThrow();
        System.out.println("mean=" + mean);
        
        // Ex8. 직원들 중 대리는 몇 명?
        System.out.println("--- Ex8. ---");
        count = 0;
        for (Employee e : employees) {
            if (e.getJobTitle().equals("대리")) {
                count++;
            }
        }
        System.out.println("count=" + count);
        
        long empCount = employees.stream()
                .filter((e) -> e.getJobTitle().equals("대리"))
                .count();
        System.out.println("empCount=" + empCount);
    }

}
