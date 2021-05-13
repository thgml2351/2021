# 객체지향 프로그램의 기초적인 코딩 방법

## 클래스 제작

```java
package com.javalec.human;

public class WomanClass {

	public WomanClass() {
	}
}
```

1. 패키지명
2. 클래스명
3. 생성자

외부에서 이 클래스를 가지고 객체를 만든다고 하면 <br>
ManClass 변수 = new ManClass();

```java
package com.javalec.makeClass;

import com.javalec.human.WomanClass;

public class MainClass {

	public static void main(String[] args) {

		WomanClass wc = new WomanClass();
		WomanClass wc1 = new WomanClass();

		System.out.println(wc.equals(wc1));
	}

}
```

```java
package com.javalec.human;

public class WomanClass {

	public WomanClass() {

		System.out.println("여기는 womanclass 생성자 입니다.");
	}

}
```

객체 wc와 wc1는 완전한 독립체이기 때문에 equals로 비교했을때 false가 나온다.

## 메소드, 인스턴스 변수 만들기

1. 인스턴스 변수(멤버변수)
2. 메소드
3. Getter & setter

## 인스턴스 (getter & setter)

public int age;

- public은 생략이 가능하다.
- 평소에 우리가 쓰던 형태이다.
- 다른 객체에서 언제든지 사용할 수 있다.

private int age;

- 클래스 내부에서만 쓴다.
- 다른 객체에서는 접근해서 사용할 수 없다.

private 값을 외부에서 활용할려면

![7-1](https://user-images.githubusercontent.com/66400531/118077644-7962b600-b3ef-11eb-8a9f-ed1b5bcbe478.PNG)
![7-2](https://user-images.githubusercontent.com/66400531/118077683-8ed7e000-b3ef-11eb-9435-171f0a06b5d7.PNG)
![7-3](https://user-images.githubusercontent.com/66400531/118077957-26d5c980-b3f0-11eb-9a8f-53de703bf81e.PNG)

값을 얻어오는 getter, setter를 통해 접근할 수 있다.
= public으로 선언되어 있기 때문이다.

getter : 값을 얻어오고 싶을때 사용
setter : 값을 재설정 하고 싶을때 사용

## 메소드

```java
public double calculaterBMI() {
			double result = weight / (height * height);
			return result;
		}
```

public이고 반환형이 double이여서 외부에서 호출할 수 있다.

```java
double d = mc.calculaterBMI();
```

## this 키워드

![7-4](https://user-images.githubusercontent.com/66400531/118079112-83d27f00-b3f2-11eb-979f-db55b3ff3da7.PNG)

this.age (객체, 나 자신)

this.age는 private int age에서 온것이고, 매개변수 age에 값을 할당한다는 것이다.

this.age를 그냥 age로 하면 파라미터의 age로 된다.
파라미터값은 this.age = age 오른쪽에 들어간다.
