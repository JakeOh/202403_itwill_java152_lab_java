package com.itwill.interface02;

/*
 * 인터페이스가 가질 수 있는 멤버들 - Java 8 버전 이후 변경 사항
 * 1. [public static final] 필드
 * 2. [public abstract] 메서드
 * 3. [public] static 메서드 - Java 8 버전부터
 *    -> 객체 생성 없이, 인터페이스 이름을 접두사로 써서 호출할 수 있는 메서드.
 * 4. [public] default 메서드 - Java 8 버전부터
 *    -> body(몸통)이 구현된 메서드.
 *    -> 인터페이스를 구현한 하위 타입의 객체를 생성한 후에 호출할 수 있는 메서드.
 * 5. private static 메서드 - Java 9 버전부터
 *    -> body가 구현된 메서드.
 *    -> static 또는 default 메서드에서만 호출할 목적으로 만드는 메서드.
 * 6. private default 메서드 - Java 9 버전부터
 *    -> body가 구현된 메서드.
 *    -> default 메서드에서만 호출할 목적으로 만드는 메서드.
 */

public interface Test {

}
