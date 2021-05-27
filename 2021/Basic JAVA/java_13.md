# 추상클래스

## 추상클래스의 이해

추상적으로 선언 -> 객체를 재정의

강제로 부모클래스에서 자식클래스에게 메소드를 강제로 재정의하게 할 수 있다. 이러한 방법으로 만들어진 클래스가 '추상클래스'이다.

- 추상클래스는 인스턴스(객체 생성)를 생성할 수 없다.

- 추상클래스를 상속받은 클래스는 추상클래스가 갖고 있는 메소드를 반드시 구현해야한다.

- 클래스와 다르게 다중상속이 가능하다.

## 추상클래스가 필요한 이유

추상클래스를 상속받은 자식 클래스가 반드시 추상 메소드를 구현하도록 하기 위함이다.

## 추상클래스의 문법

class 앞에 키워드를 사용
접근 제한 , 키워드(abstract), 리턴타입, 메소드이름

```java
abstract class 클래스이름 {
    public abstract void 메소드이름();
}
```

### 실전

```java
public abstract class SuperClassEx {
	public SuperClassEx() {
	}
	public abstract void method1();

	public void method2() {
		System.out.println("SuperClassEx의 method2 입니다.");
	}
}
```

```java
public class ChildClassEx extends SuperClassEx{
	@Override
	public void method1() {
		System.out.println("ChildClassEx의 method1 입니다.");
	}
}
```

```java
public class MainClass {
	public static void main(String[] args) {
		ChildClassEx childClassEx = new ChildClassEx();
		childClassEx.method1();
		childClassEx.method2();
	}
}
```

> ChildClassEx의 method1 입니다.
> SuperClassEx의 method2 입니다.

## 추상클래스 상속과 일반적인 상속의 차이

일반 메소드는 사용자에 따라 해당 메소드를 구현할 수 있고, 안 할 수도 있다. 하지만 추상 클래스를 상속받은 모든 자식 클래스는 추상 메소드를 구현해야만 인스턴스를 생성할 수 있다.
