# API (2)

## Random

랜덤 숫자를 수하는 작업

### Random() 메소드

Random() 메소드는 static이고, 반환 타입이 double이다.

```java
double d = Math.random();
```

정수형으로 보고 싶을 땐

```java
int dd = (int)(d*10);
```

### Random 클래스

nextInt() : 원하는 숫자까지를 괄호 안에 쓴다.

```java
Random random = new Random();
random.nextInt();
```

## Scanner 및 Sysout

### Scanner

문자열을 읽어올 때 사용한다.

```java
Scanner sc = new Scanner(System.in);

//정수
int i = sc.nextInt();

//문자열, 공백을 기준으로 입력받는다.
String str = sc.next();

//문자열, 개행문자를 기준으로 입력받는다.
String str1 = sc.nextLine();
```

#### 주의할 점

String str = sc.next(); 을 실행할 때 실제로는 \n 까지 자동으로 인식돼서 개행문자는 str1으로 넘어간다. 따라서 원하는 결과가 나오지 않을 수 있다.

```java
Scanner sc = new Scanner(System.in);
String str = sc.next();
System.out.println(str);

String str1 = sc.nextLine();
System.out.println(str1);
```

이러한 문제점을 해결하기 위해서는
sc.nextLine(); 를 추가한다.

```java
Scanner sc = new Scanner(System.in);
String str = sc.next();
System.out.println(str);

sc.nextLine();

String str1 = sc.nextLine();
System.out.println(str1);
```

### Sysout

println() : 개행을 한다.
print() : 개행을 안 한다.

```java
System.out.println("AAA");
System.out.println("BBB");
```

> AAA
> BBB

```java
System.out.print("AAA");
System.out.print("BBB");
```

> AAABBB

## Wrapper 클래스의 이해

기초데이터를 객체데이터로 변환한다.

![22_1](https://user-images.githubusercontent.com/66400531/121291693-a8534580-c923-11eb-8504-09e39c5995b2.PNG)

```java
Integer integer = new Integer(10);
int i = integer.intValue();
System.out.println(i);
```

> 10

### 숫자가 들어간 String을 int로 바꾸고 싶을 때

```java
String str = "3";
int i = Integer.parseInt(str);

System.out.println(i+10);
```

> 13
