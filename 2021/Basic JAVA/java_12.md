# 상속 (2)

## override

모든클래스의 부모 클래스 = object

StoreNum1이 HeadQuarterStore를 상속받고 있다면 외부에서 호출할 때

```java
StoreNum1 store1 = new StoreNum1();
```

아래와 같이 바꿀 수 있다.

```java
HeadQuarterStore를 store1 = new StoreNum1();
```

또한 모든 클래스의 부모클래스인 Object으로도 바꿀 수 있다.

# super

override의 장점은 잘 만들어진 클래스를 상속받아 일부 메소드를 재정의 할 수 있는 것이다. <br>하지만, 자식클래스에서 부모클래스를 override하면 부모클래스의 메소드는 사용할 수 없다는게 단점이다.

자식클래스에서 부모클래스의 메소드를 사용하고자 할 때 super키워드를 사용한다.

this의 반대라도 생각하면 된다.

```java
public class ParentClass {
	public void method() {
		System.out.println("부모 클래스의 method() 입니다.");
	}
}
```

```java
public class ChildClass extends ParentClass{
	public void method() {
		super.method();
		System.out.println("부모 클래스의 method()를 실행하고, 자식 클래스의 나머지 작업을 합니다.");
	}
}
```

```java
public class MainClass {
	public static void main(String[] args) {
		ChildClass childClass = new ChildClass();
		childClass.method();
	}
}
```

> 부모 클래스의 method() 입니다. <br>
> 부모 클래스의 method()를 실행하고, 자식 클래스의 나머지 작업을 합니다.

```java
public class ParentClass {
	public ParentClass() {
		System.out.println("ParentClass");
	}
}
```

```java
public class ChildClass extends ParentClass{
	public ChildClass() {
		System.out.println("ChildClass");
	}
}
```

```java
public class MainClass {
	public static void main(String[] args) {
		ChildClass childClass = new ChildClass();
	}
}
```

부모클래스부터 실행하기 때문에 이러한 결과가 나온다.

> ParentClass <br>
> ChildClass
