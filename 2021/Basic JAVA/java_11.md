# 상속

## 상속이 필요한 이유

이미 만들어 놓은 프로그램이 있다면 상속을 통해서 결과물을 빠른 시간 내에 만들 수 있다. 또한 기존의 프로그램은 대부분 검증이 잘 되어 있어 버그도 거의 없을 수 있다.

다양한 객체를 상속을 통해서 하나의 객체로 묶을 수 있다.

## 상속 문법

ChildClass extends ParentClass
상속받는클래스, 키워드, 상속해주는클래스

- 자바는 다중 상속(부모가 여러개)은 안된다.

```java
public class ParentClass {
    String pStr = "부모클래스";

    public ParentClass() {

    }

    public String getPapaName() {
        System.out.println("홍길동");
        return "";
    }

    public String getMamiName() {
        System.out.println("홍길자");
        return "";
    }
}
```

```java
public class ChildClass extends ParentClass {
    String cStr = "아들 클래스";

    public ChildClass() {

    }
}
```

```java
public class MainClass {
    public static void main(String[] args) {
        ChildClass childClass = new ChildClass();
        System.out.print("아버님 이름 : ");
        ChildClass.getPapaName();
        System.out.print("어머님 이름 : ");
        ChildClass.getPapaName();

        System.out.println(ChildClass.cStr);
    }
}
```

> 아버님 이름 : 홍길동
> 어머님 이름 : 홍길순
> 자식클래스

## 재정의

부모클래스에서 상속받은 기능을 재정의 할 수 있다.

```java
public class ParentMenu {
	public ParentMenu() {

	}
	public void makeChungGukJang() {
		System.out.println("청국장");
	}
	public void makeDoenJamgGuk() {
		System.out.println("된장국");
	}
	public void makeGalbiJim() {
		System.out.println("갈비찜");
	}
	public void makeSoybean() {
		System.out.println("콩비지");
	}
}
```

```java
public class ChildMenu extends ParentMenu {
	public ChildMenu() {

	}
	private void makeBeefChungGukJang() {
		System.out.println("쇠고기 청국장");
	}
	public void makeHotDoenJangGuk() {
		System.out.println("얼큰 된장국");
	}
	public void makeKongNaMool() {
		System.out.println("콩나물국");
	}
    @Override
	public void makeChungGukJang() {
		System.out.println("냄새 없는 청국장");
	}
}
```

```java
public class MainClass {
	public static void main(String[] args) {
		ChildMenu childMenu = new ChildMenu();
		childMenu.makeChungGukJang();
		childMenu.makeDoenJamgGuk();
		childMenu.makeGalbiJim();
		childMenu.makeHotDoenJangGuk();
		childMenu.makeKongNaMool();
		childMenu.makeSoybean();
	}
}
```

> 된장국
> 갈비찜
> 얼큰 된장국
> 콩나물국
> 콩비지
