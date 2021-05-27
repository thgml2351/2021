# 추상클래스 (3)

웜톤, 쿨톤의 특징을 알아보자!

```java
public class MainClass {

	public static void main(String[] args) {
		Tone person1 = new Person1(Data.SUN_BLACK , Data.LIP_PEACH, Data.SKIN_YELLOW);
		Tone person2 = new Person2(Data.SUN_RED , Data.LIP_PINK , Data.SKIN_RED );

		person1.result();
		person2.result();
	}
}
```

```java
public abstract class Tone {
	public String sun;
	public String lip;
	public String skin;

	public Tone(String sun, String lip, String skin) {
		this.sun = sun;
		this.lip = lip;
		this.skin = skin;
	}

	public abstract void result();
}
```

```java
public class Person1 extends Tone{
	public Person1(String sun, String lip, String skin) {
		super(sun, lip, skin);
	}

	public void result() {
		System.out.println("----------------------------");
		System.out.println("웜톤 피부의 특징!\n");
		System.out.println(sun);
		System.out.println(lip);
		System.out.println(skin);
		System.out.println("----------------------------\n");
	}
}
```

```java
public class Person2 extends Tone{
	public Person2(String sun, String lip, String skin) {
		super(sun, lip, skin);
	}

	public void result() {
		System.out.println("----------------------------");
		System.out.println("쿨톤 피부의 특징!\n");
		System.out.println(sun);
		System.out.println(lip);
		System.out.println(skin);
		System.out.println("----------------------------");

	}
}
```

```java
public class Data {
	public static final String SUN_BLACK = "햇볕에 검게 탄다";
	public static final String SUN_RED = "햇볕에 붉게 탄다. ";

	public static final String LIP_PEACH = "피치 계열 립스틱";
	public static final String LIP_PINK = "핑크 계열 립스틱";

	public static final String SKIN_YELLOW = "피부톤이 노란 편";
	public static final String SKIN_RED = "피부톤이 붉은 편";
}

```

---

웜톤 피부의 특징!

햇볕에 검게 탄다
피치 계열 립스틱
피부톤이 노란 편

---

---

쿨톤 피부의 특징!

햇볕에 붉게 탄다.
핑크 계열 립스틱
피부톤이 붉은 편

---
