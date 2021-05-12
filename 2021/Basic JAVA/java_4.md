# 변수

## 배열 문법

배열의 크기는 최초에 한 번 설정되면 변경이 불가하다.

```java
int[] arr = {10, 20, 30};

int[] arr = new int[3]
arr[0] = 10;
arr[1] = 20;
arr[2] = 30;
```

## 레퍼선스의 이해

배열은 데이터들의 주소값(레퍼런스)을 가지고 있다.
만약 동일한 주소값을 가지고 있다면, 같은 데이터를 가리키고 있다.

```java
int[] arr = {10, 20, 30};
int[] arr2 = arr;
for(int i=0; i<arr.length;i++) {
    System.out.println("arr["+i+"] = "+arr[i]);
    System.out.println("arr2["+i+"] = "+arr2[i]);
}
arr2[0] = 100;
arr2[1] = 200;
arr2[2] = 300;
for(int i=0; i<arr.length;i++) {
    System.out.println("arr["+i+"] = "+arr[i]);
    System.out.println("arr2["+i+"] = "+arr2[i]);
}
```

![4-1](https://user-images.githubusercontent.com/66400531/117936701-22ea6e80-b340-11eb-8ff8-106e94b81285.PNG)

## 배열 응용 문제

각 학생의 평균 점수와, 두 학생의 평균점수를 구하기

```java
import java.util.Scanner;

public class arr2 {
    public static void main(String[] args) {
        String[] name = { "철수", "영희" };
        String[] subject = { "국어", "영어", "수학" };
        int sum = 0;
        int stotal, ntotal = 0;

        // 개인 평균
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < name.length; i++) {
            for (int j = 0; j < subject.length; j++) {
                System.out.print(name[i] + " 학생 " + subject[j] + " 점수를 입력하세요 : ");
                sum += sc.nextInt();
            }
            stotal = sum / subject.length;
            System.out.println(name[i] + " 학생의 평균 점수는 " + stotal);
            System.out.println("");
            ntotal += stotal;
            sum = 0;
        }
        System.out.println("두 학생의 평균 점수는: " + (ntotal / name.length));
    }
}
```

![4-2](https://user-images.githubusercontent.com/66400531/117939437-03087a00-b343-11eb-8bce-e3ac89e3c818.PNG)

## 다차원 배열
