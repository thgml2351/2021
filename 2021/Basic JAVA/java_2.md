# 연산자

### 문제 1

출력될 값을 예상하기

```
int i = 5;
System.out.println(i++);
System.out.println(++i);
```

i++ // 선 대입 후 연산
++i // 선 연산 후 대입

### 문제 2

출력될 값을 예상하기

```
int i = 7;
int j = 3;
int h = 5;

System.out.println(i>j && i<h);
System.out.println(i>j || i>h);

int result = h != 5 ? 1 : 2;
System.out.println(result);
```

### 문제 3

빈칸을 채우세요.

```
Scanner sc = new Scanner(System.in);
int i = sc.nextInt();
System.out.println("i를 5으로 나눠서 나머지가 0이 나오면 사용자가 입력한 숫자는 5의 배수 입니다.");
System.out.println(빈칸);
```
