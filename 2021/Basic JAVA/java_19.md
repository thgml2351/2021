# 패턴을 통한 객체지향 언어의 이해 (2)

## 스트래티지 패턴

알고리즘 군을 정의하고 각각의 캡슐화하여 교환해서 사용할 수 있도록 만든다.
스트래티지패턴을 활용하면 알고리즘을 사용하는 클라이언트와는 독립적으로 변경할 수 있다.

## 로봇을 프로그램으로 만들기

```java
public abstract class Robot {
	public Robot() {}

	//상속
	public void actionWalk() {
		System.out.println("걸을 수 있습니다.");
	}

	public void actionRun() {
		System.out.println("달릴 수 있습니다.");
	}

	public void shape() {
		System.out.println("SuperRobot 로봇 입니다. 외형은 팔, 다리, 몸통, 머리가 있습니다.");
	}

	//추상화
	public abstract void actionFly();

	public abstract void actionMisail();

	public abstract void actionKnife();
}
```

```java
public class SuperRobot extends Robot{
	public SuperRobot() {}

	@Override
	public void actionFly() {
		System.out.println("날수 있습니다.");

	}

	@Override
	public void actionMisail() {
		System.out.println("미사일 쏠 수 있습니다.");

	}

	@Override
	public void actionKnife() {
		System.out.println("레이저검이 있습니다.");

	}
}
```

```java
public class StandardRobot extends Robot{
	public StandardRobot() {}

	@Override
	public void actionFly() {
		System.out.println("날수 없습니다.");
	}

	@Override
	public void actionMisail() {
		System.out.println("미사일 쏠 수 있습니다.");
	}

	@Override
	public void actionKnife() {
		System.out.println("목검이 있습니다.");
	}
}
```

```java
public class LowRobot extends Robot{
	public LowRobot() {
	}

	@Override
	public void actionFly() {
		System.out.println("날수 없습니다.");
	}

	@Override
	public void actionMisail() {
		System.out.println("미사일 쏠 수 없습니다.");
	}


	@Override
	public void actionKnife() {
		System.out.println("검이 없습니다.");
	}
}
```

```java
public class Main {
	public static void main(String[] args) {
		SuperRobot robot = new SuperRobot();
		StandardRobot robot2 = new StandardRobot();
		LowRobot robot3 = new LowRobot();

		robot.actionRun();
		robot2.actionKnife();
		robot3.actionFly();
	}
}
```

> 달릴 수 있습니다.
> 목검이 있습니다.
> 날수 없습니다.

SuperRobot, StandardRobot, LowRobot클래스에서 actionWalk와 ActionRun, shape 메소드가 겹치기 때문에 <br>
Robot 클래스를 만들어 그곳에서 통일해주었다.

따라서 남은 actionFly, actionMisail, actionKnife 메소드에서 메소드이름은 같지만 안에 내용은 다르기 때문에 <br>
Robot클래스에서 추상메소드를 선언하였고 각각의 클래스에서 추상메소드를 구현하도록 했다.
