# 패턴을 통한 객체지향 언어의 이해 (3)

### 객체

```java
public interface IFly {
	void fly();
}
```

```java
public interface IMisail {
	void misail();
}
```

```java
public interface IKnife {
	void knife();
}
```

```java
public class FlyNo implements IFly {
	@Override
	public void fly() {
		System.out.println("날수 없습니다.");
	}
}
```

```java
public class FlyYes implements IFly {
	@Override
	public void fly() {
		System.out.println("날수 있습니다.");
	}
}
```

```java
public class MisailNo implements IMisail {
	@Override
	public void misail() {
		System.out.println("미사일을 쏠 수 없습니다.");
	}
}
```

```java
public class MisailYes implements IMisail {
	@Override
	public void misail() {
		System.out.println("미사일을 쏠 수 있습니다.");
	}
}
```

```java
public class KnifeLazer implements IKnife {
	@Override
	public void knife() {
		System.out.println("레이저 검이 있습니다.");
	}
}
```

```java
public class KnifeWood implements IKnife {
	@Override
	public void knife() {
		System.out.println("목검이 있습니다.");
	}
}
```

```java
public class KnifeNo implements IKnife {
	@Override
	public void knife() {
		System.out.println("검이 없습니다.");
	}
}
```

<br><br>

달라지는 모양들은 추상메소드를 이용한다.

각각의 기능들은 인터페이스 이용한다.
<br>

```java
public class SuperRobot extends Robot{
	public SuperRobot() {}

	@Override
	public void shape() {
		System.out.println("SuperRobot 로봇 입니다. 외형은 팔, 다리, 몸통, 머리가 있습니다.");
    }
}
```

```java
public class StandardRobot extends Robot{
	public StandardRobot() {}

	@Override
	public void shape() {
		System.out.println("StandardRobot 로봇 입니다. 외형은 팔, 다리, 몸통, 머리가 있습니다.");
	}
}
```

```java
public class LowRobot extends Robot{
	public LowRobot() {}

	@Override
	public void shape() {
		System.out.println("LowRobot 로봇 입니다. 외형은 팔, 다리, 몸통, 머리가 있습니다.");
	}
}
```

```java
import inter.IFly;
import inter.IKnife;
import inter.IMisail;

public abstract class Robot {
    // 인터페이스
	IFly fly;
	IMisail misail;
	IKnife knife;

	public Robot() {}

	//상속
	public void actionWalk() {
		System.out.println("걸을 수 있습니다.");
	}

	public void actionRun() {
		System.out.println("달릴 수 있습니다.");
	}

    // 추상 메소드
	public abstract void shape();

    // setter를 통헤 언제든지 바꿀 수 있음
	public void setFly(IFly fly) {
		this.fly = fly;
	}

	public void setMisail(IMisail misail) {
		this.misail = misail;
	}

	public void setKnife(IKnife knife) {
		this.knife = knife;
	}

    // 실행
	public void actionFly() {
		this.fly.fly();
	}

	public void actionMisail() {
		this.misail.misail();
	}

	public void actionknife() {
		this.knife.knife();
	}
}
```

```java
import inter.FlyYes;
import inter.KnifeLazer;
import inter.MisailYes;

public class Main {

	public static void main(String[] args) {
		System.out.println("SuperRobot을 만들어 주세요.");

		Robot superRobot = new SuperRobot();
		superRobot.shape();
		superRobot.actionWalk();
		superRobot.actionRun();

                // 어떤 객체를 실행할지 선택한다.
		superRobot.setFly(new FlyYes());
                 //실행
		superRobot.actionFly();
		superRobot.setMisail(new MisailYes());
		superRobot.actionMisail();
		superRobot.setKnife(new KnifeLazer());
		superRobot.actionknife();
	}

}
```

> SuperRobot을 만들어 주세요.
> SuperRobot 로봇 입니다. 외형은 팔, 다리, 몸통, 머리가 있습니다.
> 걸을 수 있습니다.
> 달릴 수 있습니다.
> 날수 있습니다.
> 미사일을 쏠 수 있습니다.
> 레이저 검이 있습니다.

### Main에서 set을 안쓰고 싶을 때 방법 2

```java
public class Main {
	public static void main(String[] args) {
		System.out.println("SuperRobot을 만들어 주세요.");

		Robot superRobot = new SuperRobot();
		superRobot.shape();
		superRobot.actionWalk();
		superRobot.actionRun();
		superRobot.actionFly();
		superRobot.actionMisail();
		superRobot.actionknife();
	}
}
```

```java
import inter.FlyYes;
import inter.MisailYes;
import inter.KnifeLazer;

public class SuperRobot extends Robot{
	public SuperRobot() {
		fly = new FlyYes();
		misail = new MisailYes();
		knife = new KnifeLazer();
	}

	@Override
	public void shape() {
		System.out.println("SuperRobot 로봇 입니다. 외형은 팔, 다리, 몸통, 머리가 있습니다.");
	}
}
```

> SuperRobot을 만들어 주세요.
> SuperRobot 로봇 입니다. 외형은 팔, 다리, 몸통, 머리가 있습니다.
> 걸을 수 있습니다.
> 달릴 수 있습니다.
> 날수 있습니다.
> 미사일을 쏠 수 있습니다.
> 레이저 검이 있습니다.
