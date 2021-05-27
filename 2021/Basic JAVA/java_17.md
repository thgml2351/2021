# 인터페이스 (2)

## 인터페이스와 다중상속

Clss에 대해 배울때 java는 다중상속을 못한다고 배웠습니다. 하지만 interface를 통해 여러 가지 타입으로 객체를 선언할 수 있습니다.
이것을 다형성이라고 합니다. 다른 말로는 다중구현이라고 합니다.

```java
public class ChildClass implements iFunction1, iFunction2, iFunction3 {

}
```

## 다중구현을 이용한 화장품 회사들의 유명템들 알아보기!

```java
public class MainClass {
	public static void main(String[] args) {
		IFunction romand = new Romand();
		IFunction peripera = new Peripera();
		IFunction clio = new Clio();
	}
}
```

```java
public interface IFunction {
}
```

```java
public interface LIP extends IFunction {
	void lip();
}
```

```java
public interface PALETTE extends IFunction {
	void palette();
}
```

```java
public interface BLUSHER extends IFunction{
	void blusher();
}
```

```java
public class Romand implements LIP, PALETTE, BLUSHER{
    public Romand() {
    	lip();
    	palette();
    	blusher();
    	System.out.println("----------------------");
    }
	@Override
	public void lip() {
		System.out.println("쥬시 래스팅 틴트");
	}
	@Override
	public void palette() {
		System.out.println("베러 댄 아이즈 팔레트");
	}
	@Override
	public void blusher() {
		System.out.println("베러 댄 치크 블러셔");
	}
}
```

```java
public class Peripera implements LIP, PALETTE, BLUSHER{
    public Peripera() {
    	lip();
    	palette();
    	blusher();
    	System.out.println("----------------------");
    }
	@Override
	public void lip() {
		System.out.println("잉크 더 에어리 벨벳");
	}
	@Override
	public void palette() {
		System.out.println("올테이크 무드 팔레트");
	}
	@Override
	public void blusher() {
		System.out.println("유명템이 아닙니다.");
	}
}
```

```java
public class Clio implements LIP, PALETTE, BLUSHER{
    public Clio() {
    	lip();
    	palette();
    	blusher();
    	System.out.println("----------------------");
    }
	@Override
	public void lip() {
		System.out.println("유명템이 아닙니다.");
	}
	@Override
	public void palette() {
		System.out.println("프로 아이 팔레트");
	}
	@Override
	public void blusher() {
		System.out.println("유명템이 아닙니다.");
	}
}
```

> 쥬시 래스팅 틴트
> 베러 댄 아이즈 팔레트
> 베러 댄 치크 블러셔
>
> ---
>
> 잉크 더 에어리 벨벳
> 올테이크 무드 팔레트
> 유명템이 아닙니다.
>
> ---
>
> 유명템이 아닙니다.
> 프로 아이 팔레트
> 유명템이 아닙니다.
>
> ---

## 인터페이스와 추상클래스

#### 공통점

- 추상메소드를 가지고 있다. 따라서 하위 클래스에서 구현해야 된다.
- 자기 자신이 new를 통해 객체를 생성할 수 없으며, 상속받은 자식만이 객체를 생성할 수 있다.

#### 차이점

- 추상 메소드는 상속을 통한 사용이고, 인터페이스는 구현을 통한 사용이다.
- 추상클래스는 일반 클래스와 동일하게 변수, 메소드의 모든 기능을 사용할 수 있지만, 인터페이스는 상수와 추상메소드만 존재한다.
- 추상클래스는 상속이므로 단일 상속만 지원하고, 인터페이스는 다중구현이 가능하다.
