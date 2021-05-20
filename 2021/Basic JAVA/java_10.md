# static

## static 이해

static의 키워드는 '공유' 이다.

클래스에서 객체를 생성하기 전에 클래스에 있는 데이터를 공유한다.

```java
public class PapaPouch {
    public static int MONEY = 100;
    // 변수명은 주로 대문자를 사용한다.
    // static이 있어서 어디서나 MONEY를 공유할 수 있다.
    public PapaPouch() {

    }
}

```

```java
public class MainClass {
    public static void main(String[] args) {
        FirstChild firstChild = new FirstChild;
        firstChild.takeMoney(100);

        SecondChild secondChild = new SecondChild;
        secondChild.takeMoney(100);

        System.out.println(PapaPouch.MONEY);
    }
}
```

```java
public class FirstChild {
    public FirstChild() {

    }
    public void takeMoney(int money) {
        // 외부에서 MODEY를 사용할때
        // new로 객체를 생성하지 않아도 된다.
        PapaPouch.MONEY = PapaPouch.MONEY - money;
        // 클래스명.변수 로 바로 접근한다.
        if(PapaPouch.MONEY < 0)
            System.out.println("첫째는 돈이 없어요..")
    }
}
```

```java
public class SecondChild {
    public SecondChild() {

    }
    public void takeMoney(int money) {
        PapaPouch.MONEY = PapaPouch.MONEY - money;
        if(PapaPouch.MONEY < 0)
            System.out.println("둘째는 돈이 없어요..")
    }
}
```

> 둘째는 돈이 없어요.. <br>
> -100

(+) 생성자에는 반환값이 없다. 이게 메소드와 차이점이다.

## static과 객체와의 관계

객체는 클래스에서 생성된다. 그러한 객체들은 전혀 다른 덩어리이다.

하지만 static이 붙은 변수는 객체 변수가 아닌 클래스 변수로써 객체가 생성되기 전에 이미 존재한다.

객체들은 가비지 콜렉터가 관리하는데, 클래스는 관리하지 않는다.

## static 장점과 단점

static 키워드를 사용한 변수는 객체생성과 상관없다.<br>
즉 객체 생성을 하지 않아도 메모리에 상주하게 된다.<br>
그만큼 메모리를 사용하지 않아도 된다.

하지만, 가비지콜렉터의 관리 밖에 있기 때문에 항상 메모리에 상주해 있습니다.

static 변수로 사용되는 대표적인 예는 상수이다.

## final

```java
public class PiClass {
    public static double PI = 3.14D;

    public PiClass() {

    }
}
```

```java
public class MainClass {
    public static void main(String[] args) {
        System.out.println(PiClass.PI);
        PiClass.PI = 3.1415926D;
        System.out.println(PiClass.PI);
    }
}
```

> 3.14 <br>
> 3.1415926

위와 같이 static은 공유를 하기 때문에 값을 변경한다면 처음에 약속한 값과 달라질 수 있다.

그래서 변경을 금지하는 final을 사용한다.
