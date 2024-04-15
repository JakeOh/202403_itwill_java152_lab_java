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
        
        // Ex2. 개발(1, 2)팀에서 일하는 직원들의 급여 합계
        
        // Ex3. 개발팀에서 일하는 직원들의 급여 평균
        
        // Ex4. 직급이 부장인 직원들의 급여 합계
        
        // Ex5. 직급이 부장인 직원들의 급여 평균
        
        // Ex6. 급여가 1,000 이상인 직원들의 정보를 한 줄에 한 명씩 출력
        
        // Ex7. 개발1팀 직원들의 급여를 10% 인상하고, 인상된 급여의 평균

    }

}
