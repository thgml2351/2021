# 추상클래스 (2)

놀이공원 이용 요금 구하기.

성인 : 5,000
청소년 : 3,000
어린이 : 1,000

첫 번째 가족 : 어른 1명, 청소년 2명
두 번째 가족 : 어른 2명, 어린이 3명

```java
public abstract class AmusementPark {
	public int adult;
	public int teenager;
	public int children;

	public AmusementPark(int adult, int teenager, int children) {
		this.adult = adult;
		this.teenager = teenager;
		this.children = children;
	}
	public abstract int total();
}
```

```java
public class Family1 extends AmusementPark {
	public Family1(int adult, int teenager, int children) {
		super(adult, teenager, children);
	}
	public int total() {
		return teenager+teenager+adult;
	}
}
```

```java
public class Family2 extends AmusementPark {
	public Family2(int adult, int teenager, int children) {
		super(adult, teenager, children);
	}
	public int total() {
		return adult+adult+children+children+children;
	}
}
```

```java
public class Price {
	public static final int ADULT = 5000;
	public static final int TEENAGER = 3000;
	public static final int CHILDREN = 1000;
}
```

```java
public class MainClass {
	public static void main(String[] args) {
		AmusementPark family1 = new Family1
				(Price.ADULT, Price.TEENAGER, Price.CHILDREN);
		AmusementPark family2 = new Family2
				(Price.ADULT, Price.TEENAGER, Price.CHILDREN);

		System.out.println("첫 번째 가족 놀이공원 이용 요금 : "+family1.total());
		System.out.println("두 번째 가족 놀이공원 이용 요금 : "+family2.total());
	}
}
```

> 첫 번째 가족 놀이공원 이용 요금 : 11000
> 두 번째 가족 놀이공원 이용 요금 : 13000
