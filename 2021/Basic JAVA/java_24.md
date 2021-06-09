# 예외 처리

## 예외란?

간단하고, 문제없을 거 같은 프로그램도 외부환경요인 등에 의해서 문제가 발생하곤 합니다.<br>프로그램에서 문제가 발생될 만한 곳을 예상하여 사전에 '문제가 발생하면 이렇게 해라'라고 프로그래밍 하는 것을 예외 처리라고 한다.

## 예외처리의 필요성

예를 들어 두 개의 숫자를 입력받아 곱셈, 나눗셈, 덧셈, 뺄셈을 하는 프로그램이 있습니다. 사용자가 10과 0을 입력하면

10 \* 0 = 0, 10 / 0 = ?, 10 + 0 = 10, 10 - 0 = 10

0을 나눌 수 없어 프로그램이 중단될 것입니다. 이런 경우 덧셈과 뺄셈은 이상이 없어도 사용자는 프로그램이 중단되어 결과를 볼 수 없습니다. <br>
만약, 나눗셈 처리에 예외 처리를 해두었다면, 나눗셈의 결과는 못 보더라도 덧셈과 뺄셈의 결과는 볼 수 있었을 것입니다. 이것이 바로 예외 처리가 필요한 이유입니다.

## 예외처리 문법 (try ~ catch)

```java
try {
// 문제가 발생할 수 있는 로직을 기술 합니다.
} catch(Exception e) {
// try{} 안에서 문제가 발생했을 때 대처방안을 기술 합니다.
}
```

### 전 후 차이

```java
public class MainClass {
    public static void main(String[] args) {
        int i = 10;
        int j = 0;

        System.out.println(i * j);
        System.out.println(i / j);
        System.out.println(i + j);
        System.out.println(i - j);
    }
}
```

> 0
> (에러)

```java
public class MainClass {
    public static void main(String[] args) {
        int i = 10;
        int j = 0;

        System.out.println(i * j);
        try {
            System.out.println(i / j);
        } catch (Exception e) {
            // 무슨 에러인지 알려준다.
            System.out.println(e.getMessage());
        }
        System.out.println(i + j);
        System.out.println(i - j);
    }
}
```

> 0
> / by zero
> 10
> 10

## finally

try ~ catch를 이용할 경우 try{}에서 문제가 발생하면 catch문이 실행됩니다.
finally문은 try와 catch문의 영향 없이 무조건 실행됩니다.

```java
int[] iArr = {1, 2, 3};

try {
	System.out.println("***********");
	System.out.println(iArr[3]);
	System.out.println("***********");
} catch (Exception e) {
	System.out.println(e.getMessage());
} finally {
	System.out.println("무조건 실행 합니다.");
}
```

에러가 없더라도 실행 됩니다.

## 예외처리 문법 (throws)

try ~ catch 예외 처리 방법은 예외가 발생했을 때 자체적으로 catch문을 이용해서 해결했습니다. <br>
이번에 살펴볼 throws의 경우에는 예외를 발생시킨 호출 쪽으로 예외를 던져버리는 방식입니다.

```java
public class MainClass {
	public static void main(String[] args) {
		ThrowsExClass throwsExClass = new ThrowsExClass();
	}
}
```

```java

public class ThrowsExClass {
	public ThrowsExClass() {
		actionC();
	}

	private void actionA() throws Exception {
		System.out.println("actionA");

		int[] iArr = {1, 2, 3, 4};
		System.out.println(iArr[4]);

		System.out.println("actionAA");
	}

	private void actionB() {
		System.out.println("actionB");

		try {
			actionA();
		} catch(Exception e) {
			System.out.println("예외는 여기서 처리합니다.");
			System.out.println(e.getMessage());
		}

		System.out.println("actionBB");
	}

	private void actionC() {
		System.out.println("actionC");
		actionB();
		System.out.println("actionCC");
	}
}
```

> actionC
> actionB
> actionA
> 예외는 여기서 처리합니다.
> Index 4 out of bounds for length 4
> actionBB
> actionCC

## 일반적으로 많이 보게 되는 예외들
