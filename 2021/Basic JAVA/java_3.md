# 제어문과 루프

## 문제 1

### 출력값을 구하세요

```
int kor = 90;
int avg = 60;

if(kor > avg) {
    System.out.println("평균 이상입니다.");
} else if(kor < avg) {
    System.out.println("평균 이하입니다.");
} else {
    System.out.println("평균입니다.");
}
```

## 문제 2

### 10을 입력했을때 무엇이 출력될까요?

```
Scanner sc = new Scanner(System.in);
int i = sc.nextInt();
int result = i%2;
switch(result){
case 0 :
    System.out.println("짝수입니다.");
    break;
case 1 :
    System.out.println("홀수입니다.");
    break;
default :
    System.out.println("에러입니다.");
    break;
```

## 문제 3

### 구구단을 출력하기 위한 출력문을 작성해라

```
for(int i=1; i<10; i++) {
	for(int j=2; j<10; j++) {
		System.out.print();
	} System.out.println("");
	}
```
