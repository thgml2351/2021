# java 7~9 문제

## 메인클래스에서 private 모든 값을 호출, 값 변경하여 호출 하시오.

```java
public class MainClass {
    public static void main(String[] args) {
        ManClass mc = new ManClass(15, 160, 50, "010-5555-6666");
    }
}

public class ManClass {
    private int age;
    private int height;
    private int weight;
    private String phoneNum;
}
```

## 학생 인바디 정보를 입력하는 프로그램을 만드시오.

- 이름, 나이, 몸무게, 키
  민동, 19, 50, 165
  준영, 18, 60, 170
  수희, 17, 45, 155
  영수, 18, 65, 175

## 접근 제한 default가 사용가능한 예시와 사용불가능한 예시를 만드시오.
