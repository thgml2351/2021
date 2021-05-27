# 패턴을 통한 객체지향 언어의 이해

## 디자인 패턴이란?

객체지향 언어의 장점들을 모아 가장 효율적으로 개발을 할 수 있게 만들어 놓은 틀

## 패턴을 사용하는 목적과 장점

- 경험 많은 개발자처럼 처음 보는 문제에 대해서도 단점을 최소화하는 설계가 가능하다.
- 구체적인 설명 없이 구조화된 패턴에 대한 사전 지식으로 커뮤니케이션에 드는 시간 절약.
- 설계 과정의 속도를 높일 수 있다.

## 싱글턴 패턴

: 어떤 클래스가 최초 한번만 메모리를 할당하고 그 메모리에 객체를 만들어 사용하는 디자인 패턴

```java
public class ExampleClass {
    private static ExampleClass instance = new ExampleClass();

    private ExampleClass() {}

    public static ExampleClass getInstance() {
        return instance;
    }
}
```

instance라는 전역 변수를 선언, static을 줌으로써 인스턴스화 하지 않고 사용할 수 있게 하였지만 접근 제한자가 private로 되어 있어 직접적인 접근은 불가능하다.

또한 생성자도 private로 되어 있어 new를 통한 객체 생성도 불가능하다.

결국 getInstance 메소드를 통해서 해당 인스턴스를 얻을 수 있게 된다.

(+) 어디서든 호출하면 사용할 수 있는 변수 : 전역변수
특정한 구역 {} 안에 생성되어 그 지역에만 사용할 수 있는 변수 : 지역변수
